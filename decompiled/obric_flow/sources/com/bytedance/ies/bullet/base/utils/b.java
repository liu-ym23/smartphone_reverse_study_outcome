package com.bytedance.ies.bullet.base.utils;

import ai.j0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.apm.j;
import com.bytedance.crash.upload.CrashUploader$NetworkType;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.obric.flow.cardlistpage.R$string;
import com.obric.oui.window.permission.WebViewActivity;
import com.squareup.kotlinpoet.e;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jg.k;
import ko.r;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wn.f;
import wn.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Boolean f5231a;

    public static Matrix a(int r10, int r11, int r12, int r13, f r14) {
        TraceEvent.c("image.NinePatchHelper.getMatrix");
        Matrix r5 = new Matrix();
        float r15 = r10;
        float r16 = r12;
        float r17 = (r15 * 1.0f) / r16;
        float r18 = r11;
        float r19 = r13;
        float r20 = (r18 * 1.0f) / r19;
        if (r14 != g.f22893h) goto L6;
        r5.preScale(r17, r20);
    L18:
        TraceEvent.a(0, "image.NinePatchHelper.getMatrix");
        return r5;
    L6:
        if (r14 != g.g) goto L12;
        if (r17 <= r20) goto L10;
        r5.setScale(r20, r20);
        r5.postTranslate((r15 - (r16 * r20)) / 2.0f, 0.0f);
        goto L18
    L10:
        r5.setScale(r17, r17);
        r5.postTranslate(0.0f, (r18 - (r19 * r17)) / 2.0f);
        goto L18
    L12:
        if (r14 == g.f) goto L14;
        float r110 = com.lynx.tasm.utils.g.a(1.0f, 0.0f);
        float r21 = Math.round((r15 - (r16 * r110)) * 0.5f);
        float r22 = Math.round((r18 - (r19 * r110)) * 0.5f);
        r5.setScale(r110, r110);
        r5.postTranslate(r21, r22);
        goto L18
    L14:
        if (r17 <= r20) goto L16;
        r5.setScale(r17, r17);
        r5.postTranslate(0.0f, (r18 - (r19 * r17)) / 2.0f);
        goto L18
    L16:
        r5.setScale(r20, r20);
        r5.postTranslate((r15 - (r16 * r20)) / 2.0f, 0.0f);
        goto L18
    }

    public static String c(Context r5) {
        ConnectivityManager r10 = (ConnectivityManager) r5.getSystemService("connectivity");     // Catch: Throwable -> L31
        if (r10 != null) goto L5;
        CrashUploader$NetworkType r11 = CrashUploader$NetworkType.f4090a;     // Catch: Throwable -> L31
    L45:
    L48:
        switch(r11.ordinal()) {
            case 1: goto L40;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L50;
            default: goto L42;
        };     // Catch: Exception -> L44
    L40:
        return "mobile";
    L50:
        return "5g";
    L51:
        return "4g";
    L52:
        return "wifi";
    L53:
        return "3g";
    L54:
        return "2g";
    L42:
        return "";
    L5:
        NetworkInfo r12 = r10.getActiveNetworkInfo();     // Catch: Throwable -> L31
        if (r12 != null) goto L8;
    L29:
        r11 = CrashUploader$NetworkType.f4090a;     // Catch: Throwable -> L31
        goto L45
    L8:
        if (r12.isAvailable() == false) goto L29;
        int r13 = r12.getType();     // Catch: Throwable -> L31
        if (1 != r13) goto L13;
        r11 = CrashUploader$NetworkType.d;     // Catch: Throwable -> L31
        goto L45
    L13:
        if (r13 != 0) goto L28;
        int r14 = ((TelephonyManager) r5.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L31
        if (r14 != 3) goto L17;
    L27:
        r11 = CrashUploader$NetworkType.f4092c;     // Catch: Throwable -> L31
        goto L45
    L17:
        if (r14 != 20) goto L19;
        r11 = CrashUploader$NetworkType.f;     // Catch: Throwable -> L31
        goto L45
    L19:
        if (r14 == 5) goto L27;
        if (r14 == 6) goto L27;
        switch(r14) {
            case 8: goto L27;
            case 9: goto L27;
            case 10: goto L27;
            default: goto L23;
        };     // Catch: Throwable -> L31
    L23:
        switch(r14) {
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L27;
            case 15: goto L27;
            default: goto L24;
        };     // Catch: Throwable -> L31
    L24:
        r11 = CrashUploader$NetworkType.f4091b;     // Catch: Throwable -> L31
        goto L45
    L25:
        r11 = CrashUploader$NetworkType.e;     // Catch: Throwable -> L31
        goto L45
    L28:
        r11 = CrashUploader$NetworkType.f4091b;     // Catch: Throwable -> L31
    L31:
        r11 = CrashUploader$NetworkType.f4091b;
        goto L48
    }

    public static k e(Map r5) {
        k r10 = new k(1);
        if (r5 == null) goto L10;
        Iterator r11 = r5.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r11.next();
        Class r13 = (Class) r12.getKey();
        Object r14 = r12.getValue();
        Intrinsics.checkNotNullParameter(r13, "clazz");
        if (r14 == null) goto L6;
        ((ConcurrentHashMap) r10.f18339b).put(r13, r14);
    L10:
        return r10;
    }

    public static void f(int r32, int r33, int r34, int r35, f r36, float[] r37, float r38, Canvas r39, Bitmap r40) {
        TraceEvent.c("image.NinePatchHelper.drawWithCapInsets");
        Rect r10 = new Rect(0, 0, (int) (r37[3] * r38), (int) (r37[0] * r38));
        float r14 = r34;
        Rect r11 = new Rect(r10.right, r10.top, (int) (r14 - (r37[1] * r38)), r10.bottom);
        Rect r12 = new Rect(r11.right, r10.top, r34, r10.bottom);
        float r13 = r35;
        Rect r15 = new Rect(r10.left, r10.bottom, r10.right, (int) (r13 - (r37[2] * r38)));
        Rect r5 = new Rect(r15.right, r15.top, r11.right, r15.bottom);
        Rect r16 = new Rect(r5.right, r15.top, r12.right, r15.bottom);
        Rect r17 = new Rect(r15.left, r15.bottom, r15.right, r35);
        Rect r18 = new Rect(r17.right, r17.top, r5.right, r17.bottom);
        Rect r19 = new Rect(r18.right, r17.top, r16.right, r17.bottom);
        Rect r110 = new Rect();
        Rect r111 = new Rect();
        Rect r112 = new Rect();
        Rect r113 = new Rect();
        Rect r20 = new Rect();
        Rect r114 = new Rect();
        Rect r21 = new Rect();
        Rect r22 = new Rect();
        Rect r23 = new Rect();
        float r24 = r33;
        float r25 = r32;
        float r26 = r32 / r34;
        float r27 = r33 / r35;
        if (r36 != g.g) goto L8;
        if (r26 > r27) goto L12;
    L11:
        float r28 = r13 * r26;
        float r29 = androidx.constraintlayout.motion.widget.a.a(r24, r28, 2.0f, 0.0f);
        r24 = r28;
        float r30 = 0.0f;
    L17:
        int r31 = (int) r30;
        r110.left = r31;
        int r41 = (int) r29;
        r110.top = r41;
        r110.right = (int) (com.lynx.tasm.utils.g.a(r37[3], 0.0f) + r30);
        r110.bottom = (int) (com.lynx.tasm.utils.g.a(r37[0], 0.0f) + r29);
        r111.left = r110.right;
        r111.top = r110.top;
        int r42 = (int) ((r30 + r25) - com.lynx.tasm.utils.g.a(r37[1], 0.0f));
        r111.right = r42;
        r111.bottom = r110.bottom;
        r112.left = r42;
        r112.top = r110.top;
        r112.right = r31 + ((int) r25);
        r112.bottom = r110.bottom;
        r113.left = r110.left;
        r113.top = r110.bottom;
        r113.right = r110.right;
        int r43 = (int) ((r29 + r24) - com.lynx.tasm.utils.g.a(r37[2], 0.0f));
        r113.bottom = r43;
        r20.left = r113.right;
        r20.top = r113.top;
        int r44 = r111.right;
        r20.right = r44;
        r20.bottom = r43;
        r114.left = r44;
        r114.top = r112.bottom;
        r114.right = r112.right;
        r114.bottom = r113.bottom;
        r21.left = r110.left;
        r21.top = r113.bottom;
        int r45 = r113.right;
        r21.right = r45;
        int r46 = r41 + ((int) r24);
        r21.bottom = r46;
        r22.left = r45;
        r22.top = r20.bottom;
        int r47 = r20.right;
        r22.right = r47;
        r22.bottom = r46;
        r23.left = r47;
        r23.top = r114.bottom;
        r23.right = r114.right;
        r23.bottom = r46;
        Paint r48 = new Paint(1);
        r39.drawBitmap(r40, r10, r110, r48);
        r39.drawBitmap(r40, r11, r111, r48);
        r39.drawBitmap(r40, r12, r112, r48);
        r39.drawBitmap(r40, r15, r113, r48);
        r39.drawBitmap(r40, r5, r20, r48);
        r39.drawBitmap(r40, r16, r114, r48);
        r39.drawBitmap(r40, r17, r21, r48);
        r39.drawBitmap(r40, r18, r22, r48);
        r39.drawBitmap(r40, r19, r23, r48);
        TraceEvent.a(0, "image.NinePatchHelper.drawWithCapInsets");
        return;
    L12:
        float r115 = r14 * r27;
        r30 = androidx.constraintlayout.motion.widget.a.a(r25, r115, 2.0f, 0.0f);
        r29 = 0.0f;
        r25 = r115;
        goto L17
    L8:
        if (r36 != g.f) goto L14;
        if (r26 <= r27) goto L12;
    L14:
        if (r36 != g.e) goto L16;
        float r49 = com.lynx.tasm.utils.g.a(1.0f, 0.0f);
        int r50 = (int) (r14 * r49);
        int r51 = (int) (r13 * r49);
        float r52 = Math.round((r32 - r50) * 0.5f);
        r25 = r50;
        r24 = r51;
        r30 = r52;
        r29 = Math.round((r33 - r51) * 0.5f);
        goto L17
    L16:
        r29 = 0.0f;
        r30 = 0.0f;
        goto L17
    }

    public static void g(String r5) {
        if (r5 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a.c("XPreload", r5);
        return;
    }

    public static boolean j(int r15, int r16, int r17, int r18, f r19, String r20, String r21, Canvas r22, Bitmap r23) {
        TraceEvent.c("image.NinePatchHelper.drawNinePatch");
        boolean r5 = false;
        float[] r11 = k(l(r20), r17, r18);     // Catch: Throwable -> L14
        if (r21 != null) goto L6;
    L13:
        float r12 = 1.0f;
    L17:
        if (r11 != null) goto L19;
    L30:
        r22.drawBitmap(r23, a(r15, r16, r17, r18, r19), null);     // Catch: Throwable -> L14
    L31:
        r5 = true;
    L33:
        TraceEvent.a(0, "image.NinePatchHelper.drawNinePatch");
        return r5;
    L19:
        if (r11.length != 4) goto L30;
        if (r11[0] == 0.0f) goto L23;
    L29:
        f(r15, r16, r17, r18, r19, r11, r12, r22, r23);     // Catch: Throwable -> L14
        goto L31
    L23:
        if (r11[1] != 0.0f) goto L29;
        if (r11[2] != 0.0f) goto L29;
        if (r11[3] != 0.0f) goto L29;
    L6:
        if (r21.equalsIgnoreCase("") == true) goto L13;
        r12 = Float.parseFloat(r21);     // Catch: Throwable -> L10
        goto L17
    L10:
        th = move-exception;
        LynxLog.b(3, "BaseRoundedCornerPostprocessor", "initCapInsetsScale error " + th.getMessage());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        LynxLog.b(3, "BaseRoundedCornerPostprocessor", "process customDraw warn " + th.getMessage());
        goto L33
    }

    public static float[] k(String[] r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length > 4) goto L28;
        float[] r5 = new float[4];
        r5[0] = 0.0f;
        r5[1] = 0.0f;
        r5[2] = 0.0f;
        r5[3] = 0.0f;
        int r13 = 0;
    L8:
        if (r13 >= r10.length) goto L20;
        if (r10[r13].endsWith("px") == false) goto L13;
        String r14 = r10[r13];
        r5[r13] = Float.parseFloat(r14.substring(0, r14.length() - 2));
    L19:
        r13 = r13 + 1;
        goto L8
    L13:
        if (r10[r13].endsWith("%") == false) goto L19;
        if (r13 == 0) goto L18;
        if (r13 == 2) goto L18;
        String r15 = r10[r13];
        r5[r13] = Float.parseFloat(r15.substring(0, r15.length() - 2)) * r11;
    L18:
        String r16 = r10[r13];
        r5[r13] = Float.parseFloat(r16.substring(0, r16.length() - 2)) * r12;
        goto L19
    L20:
        return r5;
    L28:
        return null;
    }

    public static String[] l(String r10) {
        if (r10 != null) goto L5;
    L32:
        return null;
    L5:
        if (r10.equalsIgnoreCase("") == true) goto L32;
        String[] r11 = r10.split(" ");
        if (r11.length > 4) goto L32;
        int r5 = 0;
        boolean r12 = true;
    L11:
        if (r5 >= Math.min(r11.length, 4)) goto L30;
        if (r11[r5].endsWith("px") == true) goto L18;
        if (r11[r5].endsWith("%") == true) goto L18;
    L27:
        r12 = false;
    L29:
        r5 = r5 + 1;
    L18:
        if (r11[r5].endsWith("px") == false) goto L24;
        if (r11[r5].length() <= 2) goto L27;
        String r13 = r11[r5];
        r12 = r13.substring(0, r13.length() - 2).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L24:
        if (r11[r5].endsWith("%") == false) goto L29;
        if (r11[r5].length() <= 1) goto L27;
        String r14 = r11[r5];
        r12 = r14.substring(0, r14.length() - 1).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L30:
        if (r12 == false) goto L32;
        return r11;
    }

    public static void m(String r5) {
        if (r5 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPreload", r5, null, 12);
        return;
    }

    public static boolean n(Context r5) {
        ConnectivityManager r10 = (ConnectivityManager) r5.getSystemService("connectivity");     // Catch: Exception -> L13
        if (r10 != null) goto L6;
        return false;
    L6:
        NetworkInfo r11 = r10.getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r11 == null) goto L12;
        if (r11.isAvailable() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static JSONObject o(boolean r5, int r10, Exception r11, JSONObject r12) {
        if (r12 != null) goto L11;
        r12 = new JSONObject();
    L11:
        r12.put("success", r5);     // Catch: Exception -> L8
        r12.put("code", r10);     // Catch: Exception -> L8
        if (r11 == null) goto L10;
        r12.put("exception", r11.getMessage() + ym.a.g(30, r11));     // Catch: Exception -> L8
        r12.put("exception_object", r11);     // Catch: Exception -> L8
    L10:
        return r12;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static final boolean p(DelayTaskInfo r5) {
        if (r5.runInProcess.contains("all") == false) goto L5;
        return true;
    L5:
        List<String> r10 = r5.runInProcess;
        InitScheduler r11 = InitScheduler.INSTANCE;
        if (r10.contains(r11.getConfig$initscheduler_release().getProcessName()) == false) goto L9;
        return true;
    L9:
        if (r11.getConfig$initscheduler_release().isMainProcess() == false) goto L13;
        return r5.runInProcess.contains(JvmProtoBufUtil.DEFAULT_MODULE_NAME);
    L13:
        if (r5.runInProcess.contains("nonmain") == false) goto L15;
        return true;
    L15:
        ProcessMatchMode r12 = r11.getProcessMatchMode$initscheduler_release();
        int r13 = com.bytedance.lego.init.util.a.f6772a[r12.ordinal()];
        if (r13 != 1) goto L18;
        Iterator<T> r14 = r5.runInProcess.iterator();
    L28:
        if (r14.hasNext() == false) goto L41;
        String r15 = (String) r14.next();
        if (StringsKt.i(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName(), r15) == false) goto L28;
        return true;
    L41:
        return false;
    L18:
        if (r13 != 2) goto L32;
        Iterator<T> r16 = r5.runInProcess.iterator();
    L22:
        if (r16.hasNext() == false) goto L40;
        String r17 = (String) r16.next();
        if (StringsKt.e(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName(), r17, true) == false) goto L22;
        return true;
    L40:
        return false;
    L32:
        return false;
    }

    public static e q(Collection r10, String r11, String r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r11 = ", ";
    L5:
        String r5 = r11;
        if ((r14 & 2) == 0) goto L8;
        String r15 = "";
    L10:
        if ((r14 & 4) == 0) goto L12;
        String r16 = "";
    L13:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r5, "separator");
        Intrinsics.checkNotNullParameter(r15, "prefix");
        Intrinsics.checkNotNullParameter(r16, "suffix");
        int r17 = 0;
        Object[] r18 = r10.toArray(new e[0]);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        e[] r19 = (e[]) r18;
        int r20 = r19.length;
        String[] r21 = new String[r20];
    L14:
        if (r17 >= r20) goto L16;
        r21[r17] = "%L";
        r17 = r17 + 1;
        goto L14
    L16:
        Set r22 = e.f15130c;
        return com.bytedance.apm.util.a.p(ArraysKt.l(r21, r5, r15, r16, null, 56), Arrays.copyOf(r19, r19.length));
    L12:
        r16 = r13;
        goto L13
    L8:
        r15 = r12;
        goto L10
    }

    public static void r(String r5) {
        if (j.f3887a == false) goto L6;
        Log.i("AlogUploadTag", com.bytedance.android.anniex.base.service.f.o(new String[]{r5, ""}));
        return;
    }

    public static void s(Context r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r13, "source");
        if (StringsKt.isBlank(r11) == false) goto L10;
        String r14 = "openWithNetworkConfirm skipped: empty url, source=".concat(r13);
        Intrinsics.checkNotNullParameter("PrivacyPolicyNavigator", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L9;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("PrivacyPolicyNavigator", r14);
        return;
    L9:
        throw new IllegalStateException("KoinApplication has not been started");
    L10:
        ju.a r5 = ju.a.f18481a;
        r5.d("PrivacyPolicyNavigator", "PrivacyPolicyClick(source=" + r13 + ")");
        if (r10.getApplicationContext().getSharedPreferences("card_feed_prefs", 0).getBoolean("privacy_policy_network_confirmed", false) == false) goto L17;
        r5.d("PrivacyPolicyNavigator", "PrivacyPolicyNetworkConfirm(skip=true, source=" + r13 + ")");
        r5.d("PrivacyPolicyNavigator", j0.l("PrivacyPolicyOpenWeb(source=", r13, ", url=", r11, ")"));
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, Constant.TITLE);
        Intent r16 = new Intent(r10, WebViewActivity.class);
        r16.putExtra("extra_url", r11);
        r16.putExtra("extra_title", r12);
        if ((r10 instanceof Activity) == false) goto L15;
        r10.startActivity(r16);
        return;
    L15:
        r16.setFlags(276824064);
        r10.startActivity(r16);
        return;
    L17:
        new Handler(Looper.getMainLooper()).post(new com.bytedance.ai.bridge.method.router.f(2, r10, r11, r12, r13));
    }

    public static com.obric.oui.dialog.v2.alert.b t(final Activity r10, final String r11, final String r12, final String r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r13, "source");
        if (r10.getApplicationContext().getSharedPreferences("card_feed_prefs", 0).getBoolean("privacy_policy_network_confirmed", false) == false) goto L9;
        ju.a r5 = ju.a.f18481a;
        r5.d("PrivacyPolicyNavigator", "PrivacyPolicyNetworkConfirm(skip=true, source=" + r13 + ")");
        r5.d("PrivacyPolicyNavigator", j0.l("PrivacyPolicyOpenWeb(source=", r13, ", url=", r11, ")"));
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, Constant.TITLE);
        Intent r15 = new Intent(r10, WebViewActivity.class);
        r15.putExtra("extra_url", r11);
        r15.putExtra("extra_title", r12);
        r10.startActivity(r15);
        if (r14 == null) goto L11;
        r14.invoke();
        return null;
    L11:
        return null;
    L9:
        com.obric.oui.dialog.v2.alert.e r16 = new com.obric.oui.dialog.v2.alert.e(r10);
        r16.s = true;
        String r17 = r10.getString(R$string.privacy_policy_network_confirm_title);
        r16.f13159i = false;
        r16.g = r17;
        r16.f13158h = r10.getString(R$string.privacy_policy_network_confirm_message);
        r16.f13168r = true;
        com.obric.oui.dialog.v2.alert.e.f(r16, r10.getString(R$string.privacy_policy_network_confirm_negative), new com.bytedance.ai.model.c(r13, 2));
        com.obric.oui.dialog.v2.alert.e.h(r16, r10.getString(R$string.privacy_policy_network_confirm_positive), new lq.a(r13, r11, r10, r12));
        com.obric.flow.cardlistpage.ui.b r18 = new com.obric.flow.cardlistpage.ui.b(1, r14);
        Intrinsics.checkNotNullParameter(r18, "onDismissListener");
        r16.f13116a = r18;
        com.obric.oui.dialog.v2.alert.b r19 = r16.a();
        r19.show();
        return r19;
    }

    public abstract OptionalBool b(String r5);

    public abstract String d(r r5);

    public void i(r r5, go.a r10) {
    }
}
