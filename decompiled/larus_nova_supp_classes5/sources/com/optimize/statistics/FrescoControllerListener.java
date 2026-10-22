package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.BaseFrescoControllerListener;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.cache.DealCacheHelper;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.sampling.IFrescoMonitorSamplingDecider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class FrescoControllerListener extends BaseFrescoControllerListener {
    private static final int FROM_BITMAP_MEMORYCACHE = 3;
    private static final int FROM_CACHE = 1;
    private static final int FROM_DISKCACHE = 2;
    private static final int FROM_ENCODE_MEMORYCACHE = 1;
    private static final int FROM_NETWORK = 0;
    private static final int FROM_UNKNOW = -1;
    private static final int HASH_MAP_DEFAULT_MAX_SIZE = 50;
    public static final String IMAGE_MONITOR_USER_SENCE = "image_sensible_monitor";
    public static final String IMAGE_MONITOR_WASTE = "image_waste_show";
    private static final int NOT_FROM_CACHE = 0;
    private static final String TAG = "UserSenceListener";
    private static boolean mForceRunInSubThread = false;
    private static int mHashMapMaxSize = 50;
    private static boolean mHashMapOpt = false;
    private static HashMap<ImageRequest, Long> mImageLoadDurationMap = null;
    private static SparseArray<Long> mImageLoadDurationOptMap = null;
    private static boolean mIsRecordSensible = true;
    private static boolean mIsRecordWaste = true;
    private static boolean mUseOptHashMap;

    private int getHitCache(int r3) {
        if (r3 == 2) goto L10;
        if (r3 == 1) goto L10;
        if (r3 == 3) goto L10;
        return 0;
    L10:
        return 1;
    }

    private int getHitType(int r2) {
        if (r2 != (-1)) goto L6;
        return 0;
    L6:
        return r2;
    }

    static {
        mImageLoadDurationMap = new HashMap();
        mImageLoadDurationOptMap = new SparseArray();
        mUseOptHashMap = false;
    }

    public static void clearHashMap() {
    L7:
        th = move-exception;
        FLog.d(TAG, "clearHashMap mImageLoadDurationMap clear failed! t = " + th);
        return;
    L3:
        if (mUseOptHashMap == false) goto L5;
        mImageLoadDurationOptMap.clear();     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        mImageLoadDurationMap.clear();     // Catch: Throwable -> L7
        goto L10
    }

    private boolean isReportWaste() {
        if (mIsRecordWaste == true) goto L5;
    L7:
        return false;
    L5:
        if (FrescoMonitor.isReportImageWaste() == false) goto L7;
        return true;
    }

    public FrescoControllerListener() {
    }

    public static int getMapMaxSize() {
        return mHashMapMaxSize;
    }

    public static boolean isHashMapOpt() {
        return mHashMapOpt;
    }

    public static void forceRunInSubThread(boolean r0) {
        mForceRunInSubThread = r0;
    }

    private int getFrom(CloseableImage r2) {
        if (r2.isRequestInternet() == false) goto L7;
        return 0;
    L7:
        if (r2.isHitDiskCache() == false) goto L11;
        return 2;
    L11:
        if (r2.isHitEncodeMemoryCache() == false) goto L15;
        return 1;
    L15:
        if (r2.isHitBitmapMemoryCache() == false) goto L18;
        return 3;
    L18:
        return -1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:13:0x0030). Please report as a decompilation issue!!! */
    private int getLoadDuration(ImageRequest r5) {
        if (mUseOptHashMap == false) goto L8;
        if (r5 == null) goto L12;
        long r2 = mImageLoadDurationOptMap.get(r5.hashCode()).longValue();     // Catch: Exception -> L11
    L13:
        if (r2 != (-1)) goto L16;
        return -1;
    L16:
        return (int) (System.currentTimeMillis() - r2);
    L8:
        if (mImageLoadDurationMap.containsKey(r5) == false) goto L12;
        r2 = mImageLoadDurationMap.get(r5).longValue();     // Catch: Exception -> L11
    L12:
        r2 = -1;
        goto L13
    }

    public static void setHashMapOpt(boolean r0) {
        mHashMapOpt = r0;
    }

    public static void setMapMaxSize(int r0) {
        mHashMapMaxSize = r0;
    }

    public static void setUseOptHashMap(boolean r0) {
        mUseOptHashMap = r0;
    }

    public void setIsRecordSensible(boolean r1) {
        mIsRecordSensible = r1;
    }

    public void setIsRecordWaste(boolean r1) {
        mIsRecordWaste = r1;
    }

    private void addTagsFromMonitorHook(JSONObject r11, String r12) {
        IMonitorHook r0 = FrescoMonitor.getMonitorHook();
        if (r0 == null) goto L18;
        Pair r1 = r0.onMonitorCompleted(null, null, null, r11, true);     // Catch: Exception -> L7
    L8:
        if (r1 == null) goto L18;
        Map r2 = (Map) r1.second;
        if (r2 == null) goto L18;
        Iterator r3 = r2.keySet().iterator();     // Catch: JSONException -> L16
    L13:
        if (r3.hasNext() == false) goto L18;
        String r4 = (String) r3.next();     // Catch: JSONException -> L16
        r11.put(r4, r2.get(r4));     // Catch: JSONException -> L16
    L7:
        r1 = null;
    L18:
        if (FrescoCacheMonitorUtil.isOptListenerAnr() == false) goto L32;
        Iterator<IMonitorHookV2> r5 = FrescoMonitor.sNewMonitorHookV2s.iterator();
    L21:
        if (r5.hasNext() == false) goto L48;
        Pair<Boolean, Map<String, Object>> r6 = r5.next().onMonitorCompleted(null, null, null, r11, true, false);
        if (r6 == null) goto L21;
        Map r7 = (Map) r6.second;
        if (r7 == null) goto L21;
        Iterator r8 = r7.keySet().iterator();     // Catch: JSONException -> L31
    L28:
        if (r8.hasNext() == false) goto L21;
        String r9 = (String) r8.next();     // Catch: JSONException -> L31
        r11.put(r9, r7.get(r9));     // Catch: JSONException -> L31
    L48:
        if (TextUtils.isEmpty(r11.optString("biz_tag")) == false) goto L99;
        Uri r13 = UriProtector.parse(r12);
        String r10 = UriProtector.getQueryParameter(r13, "biz_tag");
        if (TextUtils.isEmpty(r10) == false) goto L53;
        r10 = UriProtector.getQueryParameter(r13, "from");
    L53:
        if (TextUtils.isEmpty(r10) == false) goto L60;
        String r14 = r13.getPath();
        if (r14 == null) goto L57;
        int r15 = r14.lastIndexOf(47);
    L58:
        if (r15 <= 0) goto L60;
        r10 = r14.substring(0, r15);
        goto L60
    L57:
        r15 = -1;
    L60:
        if (r10 == null) goto L100;
        r11.put("biz_tag", r10);     // Catch: JSONException -> L63
        return;
    L63:
        e = move-exception;
        e.printStackTrace();
        return;
    L100:
        return;
    L99:
        return;
    L32:
        List<IMonitorHookV2> r16 = FrescoMonitor.sMonitorHookV2s;
        monitor-enter(r16);
        Iterator<IMonitorHookV2> r17 = r16.iterator();     // Catch: Throwable -> L66
    L36:
        if (r17.hasNext() == false) goto L46;
        Pair<Boolean, Map<String, Object>> r18 = r17.next().onMonitorCompleted(null, null, null, r11, true, false);     // Catch: Throwable -> L66
        if (r18 == null) goto L36;
        Map r19 = (Map) r18.second;     // Catch: Throwable -> L66
        if (r19 == null) goto L36;
        Iterator r20 = r19.keySet().iterator();     // Catch: JSONException -> L69 Throwable -> L66
    L43:
        if (r20.hasNext() == false) goto L36;
        String r21 = (String) r20.next();     // Catch: JSONException -> L69 Throwable -> L66
        r11.put(r21, r19.get(r21));     // Catch: JSONException -> L69 Throwable -> L66
    L46:
        monitor-exit(r16);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        throw th;
    }

    public void onControllerStart(ImageRequest r3, long r4) {
    L18:
        th = move-exception;
        FLog.d(TAG, "onControllerStart mImageLoadDurationMap put element failed! t = " + th);
        return;
    L3:
        if (mUseOptHashMap == false) goto L12;
        if (mHashMapOpt == true) goto L7;
    L9:
        if (r3 == null) goto L22;
        mImageLoadDurationOptMap.put(r3.hashCode(), Long.valueOf(r4));     // Catch: Throwable -> L18
        return;
    L22:
        return;
    L7:
        if (mImageLoadDurationOptMap.size() <= mHashMapMaxSize) goto L9;
        mImageLoadDurationOptMap.clear();     // Catch: Throwable -> L18
        goto L9
    L12:
        if (mHashMapOpt == true) goto L14;
    L16:
        mImageLoadDurationMap.put(r3, Long.valueOf(r4));     // Catch: Throwable -> L18
        return;
    L14:
        if (mImageLoadDurationMap.size() <= mHashMapMaxSize) goto L16;
        mImageLoadDurationMap.clear();     // Catch: Throwable -> L18
        goto L16
    }

    public void onRelease(String r2, ImageRequest r3) {
    L8:
        th = move-exception;
        FLog.d(TAG, "onRelease mImageLoadDurationMap put element failed! t = " + th);
        return;
    L3:
        if (mUseOptHashMap == true) goto L5;
        mImageLoadDurationMap.remove(r3);     // Catch: Throwable -> L8
    L11:
        return;
    L5:
        if (r3 == null) goto L11;
        mImageLoadDurationOptMap.remove(r3.hashCode());     // Catch: Throwable -> L8
        goto L11
    }

    public void onFailure(String r1, ImageRequest r2, Throwable r3) {
    L8:
        th = move-exception;
        FLog.d(TAG, "onFailure mImageLoadDurationMap put element failed! t = " + th);
        return;
    L3:
        if (mUseOptHashMap == true) goto L5;
        mImageLoadDurationMap.remove(r2);     // Catch: Throwable -> L8
    L11:
        return;
    L5:
        if (r2 == null) goto L11;
        mImageLoadDurationOptMap.remove(r2.hashCode());     // Catch: Throwable -> L8
        goto L11
    }

    public void onFinalImageSet(String r19, Object r20, Animatable r21, ImageRequest r22, Map r23) {
        if (r22 != null) goto L6;
        FLog.e(TAG, "imageRequest is null");
        return;
    L6:
        IFrescoMonitorSamplingDecider r0 = FrescoMonitor.getSamplingDecider();
        if (r0 != null) goto L145;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L143;
        boolean r3 = FrescoMonitor.getLogTypeSwitch(IMAGE_MONITOR_USER_SENCE);
        boolean r2 = isReportWaste();
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L35;
        if (r3 == true) goto L35;
        if (r2 == true) goto L35;
    L31:
        th = move-exception;
        FLog.d(TAG, "onFinalImageSet fast-path remove failed! t = " + th);
        return;
    L27:
        if (mUseOptHashMap == false) goto L29;
        mImageLoadDurationOptMap.remove(r22.hashCode());     // Catch: Throwable -> L31
    L139:
        return;
    L29:
        mImageLoadDurationMap.remove(r22);     // Catch: Throwable -> L31
    L35:
        if (r22.getSourceUri() == null) goto L37;
        String r4 = r22.getSourceUri().toString();
    L38:
        String r8 = r4;
        int r7 = -1;
        if ((r20 instanceof CloseableImage) == false) goto L41;
        CloseableImage r5 = (CloseableImage) r20;
        int r6 = r5.getImageCount();
        ImageFormat r9 = r5.getImageFormat();
        int r11 = getFrom(r5);
        int r10 = r6;
    L42:
        SizeDeterminer r12 = r22.getSizeDeterminer();
        if (r12 != null) goto L45;
    L64:
        boolean r13 = false;
        int r14 = -1;
        String r15 = null;
        boolean r16 = false;
    L65:
        Object r17 = r23.get("scene_tag");
        if (r17 != null) goto L68;
    L71:
        int r110 = r11;
        String r18 = FrescoMonitor.getCurrentScene();
        if (r18 == null) goto L75;
        r23.put("scene_tag", r18);
    L75:
        if (TextUtils.isEmpty(r15) == false) goto L80;
        String r111 = FrescoMonitor.getCurrentActivity();
        if (r111 == null) goto L80;
        r15 = r111;
    L80:
        if (TextUtils.isEmpty(r15) == true) goto L82;
        r23.put("page_tag", r15);
    L82:
        if (r2 == false) goto L100;
        JSONObject r24 = new JSONObject();
        StringBuilder r112 = new StringBuilder();     // Catch: JSONException -> L97
        int r25 = r10;
        r112.append(r23.get("drawableWidth"));     // Catch: JSONException -> L133
        r112.append("x");     // Catch: JSONException -> L133
        r112.append(r23.get("drawableHeight"));     // Catch: JSONException -> L133
        r24.put("applied_image_size", r112.toString());     // Catch: JSONException -> L133
        if (r9 != null) goto L89;
        Object r113 = "undefined";
    L90:
        r24.put("image_type", r113);     // Catch: JSONException -> L133
        r24.put("log_type", IMAGE_MONITOR_WASTE);     // Catch: JSONException -> L133
        r24.put("uri", r8);     // Catch: JSONException -> L133
        r24.put("scene_tag", r23.get("scene_tag"));     // Catch: JSONException -> L133
        addTagsFromMonitorHook(r24, r8);     // Catch: RuntimeException -> L93 JSONException -> L133
    L99:
        FrescoMonitor.onImageShowCallback(r13, r24);
    L101:
        if (r3 == false) goto L106;
        if (r12 == null) goto L106;
        if (r12.getView() == null) goto L106;
    L111:
        int r26 = getLoadDuration(r22);
        if (mForceRunInSubThread == true) goto L114;
    L116:
        upload(r7, r14, r23, r26, r9, r8, r16, r25, r110, r12);
    L134:
    L122:
        th = move-exception;
        FLog.d(TAG, "onFinalImageSet2 mImageLoadDurationMap put element failed! t = " + th);
        return;
    L118:
        if (mUseOptHashMap == false) goto L120;
        mImageLoadDurationOptMap.remove(r22.hashCode());     // Catch: Throwable -> L122
        return;
    L120:
        mImageLoadDurationMap.remove(r22);     // Catch: Throwable -> L122
        return;
    L114:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L116;
        DealCacheHelper.getIOExecutor().execute(new 1(this, r7, r14, r23, r26, r9, r8, r16, r25, r110, r12));
    L106:
        if (FrescoCacheMonitorUtil.isOptSensibleMonitor() == true) goto L108;
    L138:
    L130:
        th = move-exception;
        FLog.d(TAG, "onFinalImageSet mImageLoadDurationMap put element failed! t = " + th);
        return;
    L126:
        if (mUseOptHashMap == false) goto L128;
        mImageLoadDurationOptMap.remove(r22.hashCode());     // Catch: Throwable -> L130
        return;
    L128:
        mImageLoadDurationMap.remove(r22);     // Catch: Throwable -> L130
        return;
    L108:
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L111;
        if (r3 == true) goto L111;
    L93:
        e = move-exception;
        FLog.e(TAG, "RuntimeException error is: ", e);     // Catch: JSONException -> L133
        goto L99
    L89:
        r113 = r9.getName();     // Catch: JSONException -> L133
    L98:
        FLog.w(TAG, "JSONException in FrescoControllerListener");
    L97:
        r25 = r10;
        goto L98
    L100:
        r25 = r10;
        goto L101
    L68:
        if (TextUtils.isEmpty(r17.toString()) == true) goto L71;
        r110 = r11;
        goto L75
    L45:
        if (r12.getView() == null) goto L64;
        r14 = r12.getView().getHeight();
        r7 = r12.getView().getWidth();
        Rect r27 = new Rect();
        if (r12.getView().getGlobalVisibleRect(r27) == false) goto L49;
    L52:
        boolean r28 = true;
    L54:
        if (r12.getView().getGlobalVisibleRect(r27) == true) goto L56;
    L58:
        boolean r29 = false;
    L59:
        Context r30 = r12.getView().getContext();
        boolean r114 = r29;
        if ((r30 instanceof Activity) == false) goto L62;
        r15 = ((Activity) r30).getClass().getSimpleName();
    L63:
        r13 = r114;
        r16 = r28;
        goto L65
    L62:
        r15 = null;
        goto L63
    L56:
        if (r12.getView().isShown() == false) goto L58;
        r29 = true;
        goto L59
    L49:
        if (r12.getView().isShown() == true) goto L52;
        r28 = false;
        goto L54
    L41:
        r9 = null;
        r10 = -1;
        r11 = -1;
        goto L42
    L37:
        r4 = "";
        goto L38
    L143:
    L19:
        th = move-exception;
        FLog.d(TAG, "onFinalImageSet mImageLoadDurationMap remove element failed! t = " + th);
        return;
    L15:
        if (mUseOptHashMap == false) goto L17;
        mImageLoadDurationOptMap.remove(r22.hashCode());     // Catch: Throwable -> L19
    L142:
        return;
    L17:
        mImageLoadDurationMap.remove(r22);     // Catch: Throwable -> L19
        goto L142
    L145:
        r1 = r0.shouldSampleFinalImageSet(r22, r23);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        FLog.w(TAG, "sampling decider error in onFinalImageSet, fallback to sample", th);
        goto L12
    }

    private void upload(int r6, int r7, Map r8, int r9, ImageFormat r10, String r11, boolean r12, int r13, int r14, SizeDeterminer r15) {
        JSONObject r3 = new JSONObject();
        if (mIsRecordSensible == true) goto L31;
        return;
    L31:
        r3.put("view_width", r6);     // Catch: JSONException -> L23
        r3.put("view_height", r7);     // Catch: JSONException -> L23
        r3.put("image_width", r8.get("drawableWidth"));     // Catch: JSONException -> L23
        r3.put("image_height", r8.get("drawableHeight"));     // Catch: JSONException -> L23
        r3.put("duration", r9);     // Catch: JSONException -> L23
        r3.put("from", r14);     // Catch: JSONException -> L23
        if (r10 != null) goto L8;
        String r16 = "undefined";
    L9:
        r3.put("image_type", r16);     // Catch: JSONException -> L23
        r3.put("image_sdk_version", "1.41.6");     // Catch: JSONException -> L23
        r3.put("log_type", IMAGE_MONITOR_USER_SENCE);     // Catch: JSONException -> L23
        r3.put("image_count", r13);     // Catch: JSONException -> L23
        r3.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L23
        r3.put("uri", r11);     // Catch: JSONException -> L23
        r3.put("scene_tag", r8.get("scene_tag"));     // Catch: JSONException -> L23
        addTagsFromMonitorHook(r3, r11);     // Catch: RuntimeException -> L12 JSONException -> L23
    L14:
        if (r15 == null) goto L16;
        View r17 = r15.getView();     // Catch: JSONException -> L23
    L17:
        if (r17 == null) goto L21;
        Context r18 = r17.getContext();     // Catch: JSONException -> L23
        if ((r18 instanceof Activity) == false) goto L21;
        r3.put("page_tag", ((Activity) r18).getClass().getSimpleName());     // Catch: JSONException -> L23
    L21:
        r3.put("exception_tag", 1);     // Catch: JSONException -> L23
        r3.put("hit_cache", getHitCache(r14));     // Catch: JSONException -> L23
        r3.put("hit_type", getHitType(r14));     // Catch: JSONException -> L23
    L25:
        if (FrescoCacheMonitorUtil.isOptSensibleMonitor() == true) goto L27;
        if (r12 == true) goto L27;
        return;
    L27:
        FrescoMonitor.onSensibleCallback(r3);
        MonitorUtils.monitorCommonLog(IMAGE_MONITOR_USER_SENCE, r3);
        FLog.d(TAG, "User sence tracking upload successful, content: " + r3);
        return;
    L16:
        r17 = null;
        goto L17
    L12:
        e = move-exception;
        FLog.e(TAG, "RuntimeException error is: ", e);     // Catch: JSONException -> L23
        goto L14
    L8:
        r16 = r10.getName();     // Catch: JSONException -> L23
    L23:
        FLog.w(TAG, "JSONException in FrescoControllerListener");
        goto L25
    }

    public static /* synthetic */ void access$000(FrescoControllerListener r0, int r1, int r2, Map r3, int r4, ImageFormat r5, String r6, boolean r7, int r8, int r9, SizeDeterminer r10) {
        r0.upload(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
