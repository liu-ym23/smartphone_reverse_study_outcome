package com.optimize.statistics;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ExceedTheLimitBitmapMonitor {
    private static final int BIG_REASON_FILE_TOO_LARGE = 1;
    private static final int BIG_REASON_RAM_TOO_LARGE = 3;
    private static final int BIG_REASON_RESOLUTION_TOO_LARGE = 2;
    private static final int DEFAULT_LIMIT_BITMAP_CONTRAST = 2;
    private static final long DEFAULT_LIMIT_FILE_SIZE = 20971520;
    private static final long DEFAULT_LIMIT_RAM_SIZE = 0;
    private static CustomExceedLimit mCustomExceedLimit;
    private static boolean sExceedTheLimitBitmapMonitorEnabled;
    private static int sLimitBitmapContrast;
    private static long sLimitFileSize;
    private static long sLimitRamSize;

    public ExceedTheLimitBitmapMonitor() {
    }

    static {
        long r0 = getScreenPixelMemory();
        DEFAULT_LIMIT_RAM_SIZE = r0;
        sLimitBitmapContrast = 2;
        sLimitFileSize = DEFAULT_LIMIT_FILE_SIZE;
        sLimitRamSize = r0;
        sExceedTheLimitBitmapMonitorEnabled = false;
    }

    private static long getScreenPixelMemory() {
        DisplayMetrics r0 = INVOKEVIRTUAL_com_optimize_statistics_ExceedTheLimitBitmapMonitor_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem());
        return (r0.heightPixels * r0.widthPixels) * 4;
    }

    public static boolean isExceedTheLimitBitmapMonitorEnabled() {
        return sExceedTheLimitBitmapMonitorEnabled;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_optimize_statistics_ExceedTheLimitBitmapMonitor_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private static Pair<String, String> dealBigReason2(int r2) {
        if (r2 != 1) goto L5;
        String r3 = "1";
        String r0 = "1_filesize";
    L25:
        return new Pair(r3, r0);
    L5:
        if (r2 != 10) goto L7;
        r3 = "2";
        r0 = "2_resolution";
        goto L25
    L7:
        if (r2 != 11) goto L9;
        r3 = "1,2";
        r0 = "1_filesize,2_resolution";
        goto L25
    L9:
        if (r2 != 100) goto L11;
        r3 = "3";
        r0 = "3_ramsize";
        goto L25
    L11:
        if (r2 != 101) goto L13;
        r3 = "1,3";
        r0 = "1_filesize,3_ramsize";
        goto L25
    L13:
        if (r2 != 110) goto L15;
        r3 = "2,3";
        r0 = "2_resolution,3_ramsize";
        goto L25
    L15:
        if (r2 == 111) goto L17;
        r3 = "";
        r0 = "";
        goto L25
    L17:
        r3 = "1,2,3";
        r0 = "1_filesize,2_resolution,3_ramsize";
        goto L25
    }

    private static Pair<Integer, Integer> segmentAndCheckSize(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        String[] r4 = r3.split("x");
        if (r4.length == 2) goto L13;
        return null;
    L13:
        int r0 = CastIntegerProtector.parseInt(r4[0]);     // Catch: NumberFormatException -> L12
        int r5 = CastIntegerProtector.parseInt(r4[1]);     // Catch: NumberFormatException -> L12
        return new Pair(Integer.valueOf(r0), Integer.valueOf(r5));
    L15:
        return null;
    }

    public static void setCustomExceedLimit(CustomExceedLimit r0) {
        mCustomExceedLimit = r0;
    }

    public static void setExceedTheLimitBitmapMonitorEnabled(boolean r0) {
        sExceedTheLimitBitmapMonitorEnabled = r0;
    }

    public static void setBitmapMonitorLimit(long r0, int r2, long r3) {
        sLimitBitmapContrast = r2;
        sLimitFileSize = r0;
        sLimitRamSize = r3;
        PipelineDraweeController.setLimit(r2, r0, r3);
    }

    private static int computerContrast(int r0, int r1, int r2, int r3) {
        return Math.min((r2 * 1000) / r0, (r3 * 1000) / r1);
    }

    private static int checkLimit(int r3, int r4, int r5, int r6, long r7, long r9) {
        if (r7 < sLimitFileSize) goto L5;
        int r8 = 1;
    L6:
        if (r3 <= 0) goto L14;
        if (r4 <= 0) goto L14;
        if (r5 <= 0) goto L14;
        if (r6 <= 0) goto L14;
        if ((r5 * r6) <= ((r3 * r4) * sLimitBitmapContrast)) goto L14;
        r8 = r8 | 10;
    L14:
        if (r9 >= sLimitRamSize) goto L16;
        return r8;
    L16:
        return r8 | 100;
    L5:
        r8 = 0;
        goto L6
    }

    public static void checkAndReport(ImageRequest r21, String r22, int r23, String r24, String r25, String r26, String r27, long r28, String r30) {
        SizeDeterminer r0 = r21.getSizeDeterminer();
        int r1 = -1;
        if (r0 == null) goto L7;
        Pair r2 = r0.getSize();
        if (r2 == null) goto L7;
        int r3 = ((Integer) r2.first).intValue();
        int r15 = ((Integer) r2.second).intValue();
        int r14 = r3;
    L8:
        Pair<Integer, Integer> r4 = segmentAndCheckSize(r27);
        if (r4 == null) goto L11;
        r1 = ((Integer) r4.first).intValue();
        int r5 = ((Integer) r4.second).intValue();
    L13:
        if (TextUtils.isEmpty(r30) == false) goto L15;
        long r6 = 0;
    L16:
        long r18 = r6;
        int r7 = checkLimit(r14, r15, r1, r5, r28, r18);
        boolean r8 = true;
        if (r7 <= 0) goto L19;
        boolean r9 = true;
    L20:
        Pair<String, String> r10 = dealBigReason2(r7);
        String r11 = (String) r10.first;
        String r12 = (String) r10.second;
        CustomExceedLimit r13 = mCustomExceedLimit;
        if (r13 == null) goto L41;
        Pair r16 = r13.isBigImg(r22, r23, r1, r5);
        if (r16 != null) goto L26;
        r8 = false;
    L26:
        r9 = r9 | r8;
        if (r16 == null) goto L41;
        if (TextUtils.isEmpty(r11) == false) goto L31;
        String r17 = String.valueOf(((Integer) r16.first).intValue() + 10000);
    L32:
        Object r19 = r16.second;
        if (r19 != null) goto L35;
        String r20 = "";
    L37:
        if (TextUtils.isEmpty(r12) == false) goto L39;
        String r29 = (((Integer) r16.first).intValue() + 10000) + "_" + r20;
    L40:
        String r31 = r29;
        r11 = r17;
    L42:
        if (r9 == false) goto L49;
        String r32 = r21.getSourceUri().toString();
        if (r0 == null) goto L46;
        String r33 = ViewUtils.getViewInfo(r0.getView());
    L47:
        doReport(r32, r22, r23, r11, r31, r24, r25, r26, r28, r14, r15, r1, r5, r18, r33);
        return;
    L46:
        r33 = null;
        goto L47
    L49:
        return;
    L39:
        r29 = r12 + "," + (((Integer) r16.first).intValue() + 10000) + "_" + r20;
        goto L40
    L35:
        r20 = ((String) r19).replace(",", "，");
        goto L37
    L31:
        r17 = r11 + "," + (((Integer) r16.first).intValue() + 10000);
    L41:
        r31 = r12;
        goto L42
    L19:
        r9 = false;
        goto L20
    L15:
        r6 = CastLongProtector.parseLong(r30);
        goto L16
    L11:
        r5 = -1;
    L7:
        r14 = -1;
        r15 = -1;
        goto L8
    }

    private static void doReport(String r6, String r7, int r8, String r9, String r10, String r11, String r12, String r13, long r14, int r16, int r17, int r18, int r19, long r20, String r22) {
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L5;
    L6:
        int r0 = computerContrast(r16, r17, r18, r19);
        JSONObject r2 = new JSONObject();
        r2.put("url", r6);     // Catch: JSONException -> L10
        r2.put("image_type", r7);     // Catch: JSONException -> L10
        r2.put("image_count", r8);     // Catch: JSONException -> L10
        r2.put("bigimage_reason", r9);     // Catch: JSONException -> L10
        r2.put("description", r10);     // Catch: JSONException -> L10
        r2.put("biz_tag", r11);     // Catch: JSONException -> L10
        r2.put("scene_tag", r12);     // Catch: JSONException -> L10
        r2.put("page_tag", r13);     // Catch: JSONException -> L10
        r2.put("file_size", r14);     // Catch: JSONException -> L10
        r2.put("view_width", r16);     // Catch: JSONException -> L10
        r2.put("view_height", r17);     // Catch: JSONException -> L10
        r2.put("image_width", r18);     // Catch: JSONException -> L10
        r2.put("image_height", r19);     // Catch: JSONException -> L10
        r2.put("ram_size", r20);     // Catch: JSONException -> L10
        r2.put("contrast", r0);     // Catch: JSONException -> L10
        r2.put("view_info", r22);     // Catch: JSONException -> L10
        r2.put("image_sdk_version", "1.41.6");     // Catch: JSONException -> L10
    L8:
        MonitorUtils.monitorCommonLog("image_monitor_exceed_limit_v2", r2);
        FrescoMonitor.onExceedLimitCallback(r2);
        return;
    L5:
        if (FrescoMonitor.getLogTypeSwitch("image_monitor_exceed_limit_v2") == true) goto L6;
    }
}
