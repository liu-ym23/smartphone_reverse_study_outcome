package com.lynx.tasm.utils;

import ai.j0;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.graphics.Insets;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.TemplateData;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f11179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f11180b;

    public static Handler a() {
        if (f11179a != null) goto L16;
        monitor-enter(j.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f11179a != null) goto L11;
        f11179a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L9
    L11:
        monitor-exit(j.class);     // Catch: Throwable -> L9
    L16:
        return f11179a;
    }

    public static final cb.a b(InputStream r10, int r11) {
        cb.a r5 = new cb.a(r11);
        byte[] r12 = new byte[8192];
        int r13 = r10.read(r12);
        long r14 = 0;
    L3:
        if (r13 < 0) goto L5;
        r5.b(0, r12, (int) r14, r13);
        r14 = r14 + ((long) r13);
        r13 = r10.read(r12);
        goto L3
    L5:
        return r5;
    }

    public static final TemplateData c(ae.a r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r5 = r10.f161b;
        if (r5 == null) goto L8;
        TemplateData r11 = TemplateData.b(r5);
    L9:
        Map r12 = r10.f160a;
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r12.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L15;
        Map.Entry r15 = (Map.Entry) r14.next();
        if ((r15.getValue() instanceof Bundle) == false) goto L11;
        r13.put(r15.getKey(), r15.getValue());
        goto L11
    L15:
        Iterator r16 = r13.entrySet().iterator();
    L17:
        if (r16.hasNext() == false) goto L30;
        Map.Entry r17 = (Map.Entry) r16.next();
        Map r18 = r10.f160a;
        Object r19 = r17.getKey();
        Object r20 = r17.getValue();
        if (r20 == null) goto L29;
        Bundle r21 = (Bundle) r20;
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator<T> r23 = r21.keySet().iterator();
    L22:
        if (r23.hasNext() == false) goto L27;
        String r24 = (String) r23.next();
        Object r25 = r21.get(r24);
        if (r25 != null) goto L26;
        Intrinsics.throwNpe();
    L26:
        r22.put(r24, r25);
        goto L22
    L27:
        r18.put(r19, r22);
        goto L17
    L29:
        throw new TypeCastException("null cannot be cast to non-null type android.os.Bundle");
    L30:
        r11.l(r10.f160a);
        return r11;
    L8:
        r11 = new TemplateData();
        goto L9
    }

    public static StringBuilder d(String r5, String r10) {
        return j0.w(r5, r10);
    }

    public static yg.b e(String r12, nh.d r13) {
        boolean r5 = false;
        if (r12 != null) goto L5;
    L9:
        if (r12 != null) goto L11;
    L71:
        return null;
    L11:
        if (StringsKt.g(r12, "__pia_manifest__") != true) goto L71;
        Uri r10 = Uri.parse(r12);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L15
        Object r15 = yg.b.g.fromJson(r10.getQueryParameter("__pia_manifest__"), yg.a.class);     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L15
        Object r16 = Result.m124constructorimpl((yg.a) r15);     // Catch: Throwable -> L15
    L18:
        if (Result.m127exceptionOrNullimpl(r16) != null) goto L67;
        yg.a r17 = (yg.a) r16;
        com.bytedance.pia.core.utils.j.y("[Manifest] Parse inline manifest (InlineManifest: " + r17 + ')', null);
        String r11 = r17.b();
        if (r11 != null) goto L30;
        String r18 = r10.getLastPathSegment();
        if (r18 == null) goto L26;
        List r19 = StringsKt.J(r18, new char[]{'.'}, 0, 6);
        if (r19 == null) goto L26;
        String r20 = (String) r19.get(0);
    L27:
        if (r20 != null) goto L29;
        return null;
    L29:
        String r21 = r20;
    L31:
        boolean r22 = com.bytedance.pia.core.setting.d.f7088a;
        String r23 = r17.c();
        if (r23 != null) goto L72;
    L66:
        return null;
    L72:
        Object r24 = Result.m124constructorimpl(Uri.parse(r23));     // Catch: Throwable -> L35
    L38:
        if (Result.m127exceptionOrNullimpl(r24) != null) goto L62;
        Uri r25 = (Uri) r24;
        if (r25 == null) goto L66;
        if (r25.isRelative() == false) goto L45;
        return null;
    L45:
        if (Intrinsics.areEqual(r25.getScheme(), "http") == false) goto L47;
    L49:
        Boolean r26 = r17.e();
        if (r26 == null) goto L52;
        boolean r27 = r26.booleanValue();
    L53:
        Boolean r28 = r17.d();
        if (r28 == null) goto L56;
        boolean r110 = r28.booleanValue();
    L57:
        Boolean r111 = r17.a();
        if (r111 == null) goto L61;
        r5 = r111.booleanValue();
    L61:
        return new yg.b(r10, r21, r25, r27, r110, r5);
    L56:
        r110 = false;
        goto L57
    L52:
        r27 = false;
        goto L53
    L47:
        if (Intrinsics.areEqual(r25.getScheme(), IIvyAIPackageResourceService.SCHEMA) == true) goto L49;
        return null;
    L62:
        if (r13 == null) goto L66;
        kh.c r112 = r13.f20239j;
        if (r112 == null) goto L66;
        r112.b(PointerIconCompat.TYPE_CELL, "manifest", "");
    L35:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L26:
        r20 = null;
        goto L27
    L30:
        r21 = r11;
        goto L31
    L67:
        if (r13 == null) goto L71;
        kh.c r113 = r13.f20239j;
        if (r113 == null) goto L71;
        r113.b(WebSocketProtocol.CLOSE_NO_STATUS_CODE, "manifest", "");
    L15:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (StringsKt.P(r12, "http://") == true) goto L9;
        if (StringsKt.P(r12, "https://") == true) goto L9;
        return null;
    }

    public static void f(Runnable r5) {
        if (j() == false) goto L6;
        r5.run();
        return;
    L6:
        a().post(r5);
    }

    public static void g(String r10, JSONObject r11) {
        df.c r5 = df.c.f16652i;
        r5.a();
        GeckoGlobalConfig r12 = df.c.f;
        if (r12 == null) goto L16;
        ya.a r13 = r12.getStatisticMonitor();
        if (r13 == null) goto L17;
        r11.put("params_for_special", "gecko");
        r11.put("os", 0);
        r11.put(WsConstants.KEY_SDK_VERSION, "5.2.4");
        long r14 = System.currentTimeMillis();
        r11.put("local_time", r14);
        r5.a();
        GeckoGlobalConfig r15 = df.c.f;
        if (r15 == null) goto L14;
        r11.put(WsConstants.KEY_APP_ID, r15.getAppId());
        r11.put("dur_from_cold_start", r14 - r15.getAppColdStartTime());
    L14:
        r13.b(r10, r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        GeckoLogger.a("UploadStatistic.uploadEventWithJson", th);
        return;
    L17:
        return;
    }

    public static final boolean h(i4.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        jh.a r10 = (jh.a) r5.d;
        Number r11 = r10.a();
        String r12 = r10.g();
        if (r11 != null) goto L5;
    L15:
        return false;
    L5:
        if (android.text.TextUtils.isEmpty(r12) == true) goto L15;
        if (android.text.TextUtils.isEmpty((String) r5.f17503c) == false) goto L11;
        return false;
    L11:
        if (r11.longValue() > System.currentTimeMillis()) goto L13;
        return false;
    L13:
        return true;
    }

    public static final void i(Context r5, WindowManager.LayoutParams r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        if (r5 != null) goto L6;
        return;
    L6:
        if (t(r5) == true) goto L8;
        return;
    L8:
        Activity r12 = m(r5);
        int r13 = 2;
        if (r11 != null) goto L11;
        if (r12 == null) goto L22;
        Window r14 = r12.getWindow();
        if (r14 == null) goto L22;
        WindowManager.LayoutParams r15 = r14.getAttributes();
        if (r15 == null) goto L22;
        r13 = r15.layoutInDisplayCutoutMode;
    L22:
        r10.layoutInDisplayCutoutMode = r13;
        return;
    L11:
        if (r11.booleanValue() == false) goto L22;
        r13 = 3;
        goto L22
    }

    public static boolean j() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L6;
        return true;
    L6:
        return false;
    }

    public static void k(long r5, boolean r10) {
        if (r10 == false) goto L4;
        return;
    L4:
        StringBuilder r11 = new StringBuilder("checkedMultiply".length() + 54);
        r11.append("overflow: checkedMultiply(");
        r11.append(r5);
        r11.append(", 64)");
        throw new ArithmeticException(r11.toString());
    }

    public static void l(String r5, int r10, int r11, boolean r12) {
        if (r12 == false) goto L4;
        return;
    L4:
        StringBuilder r13 = new StringBuilder(r5.length() + 36);
        r13.append("overflow: ");
        r13.append(r5);
        r13.append("(");
        r13.append(r10);
        r13.append(", ");
        r13.append(r11);
        r13.append(")");
        throw new ArithmeticException(r13.toString());
    }

    public static Activity m(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if ((r5 instanceof Activity) == false) goto L7;
        return (Activity) r5;
    L7:
        if ((r5 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return m(((ContextWrapper) r5).getBaseContext());
    }

    public static final Size n(Context r10) {
        if (r10 == null) goto L4;
        Activity r5 = m(r10);
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r5, "activity");
        Rect r11 = r5.getWindowManager().getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullParameter(r11, "bounds");
        us.b r12 = new us.b(r11);
        Intrinsics.checkNotNullParameter(r12, "_bounds");
        int r13 = new Rect(r12.f22454a, r12.f22455b, r12.f22456c, r12.d).width();
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r5, "activity");
        Rect r14 = r5.getWindowManager().getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullParameter(r14, "bounds");
        us.b r15 = new us.b(r14);
        Intrinsics.checkNotNullParameter(r15, "_bounds");
        return new Size(r13, new Rect(r15.f22454a, r15.f22455b, r15.f22456c, r15.d).height());
    L9:
        Object r16 = r10.getSystemService("window");
        Rect r17 = null;
        if ((r16 instanceof WindowManager) == false) goto L12;
        WindowManager r18 = (WindowManager) r16;
    L13:
        if (r18 == null) goto L19;
        WindowMetrics r19 = r18.getCurrentWindowMetrics();
        if (r19 == null) goto L19;
        r17 = r19.getBounds();
    L19:
        if (r17 == null) goto L23;
        return new Size(r17.width(), r17.height());
    L23:
        return new Size(a.x(r10), a.w(r10));
    L12:
        r18 = null;
        goto L13
    L4:
        return new Size(0, 0);
    }

    public static int o(View r10) {
        Intrinsics.checkNotNullParameter(r10, "rootView");
        WindowInsetsController r11 = r10.getWindowInsetsController();     // Catch: Exception -> L9
        if (r11 != null) goto L6;
        return 0;
    L6:
        Rect r5 = null;
        Method r12 = r11.getClass().getDeclaredMethod("getState", null);     // Catch: Exception -> L9
        r12.setAccessible(true);     // Catch: Exception -> L9
        Object r13 = r12.invoke(r11, null);     // Catch: Exception -> L9
        int r14 = Build.VERSION.SDK_INT;     // Catch: Exception -> L9
        if (r14 < 35) goto L11;
        Class<?> r15 = Class.forName("android.view.InsetsSource");     // Catch: Exception -> L9
    L12:
        if (r14 < 35) goto L14;
        Field r16 = r15.getDeclaredField("ID_IME");     // Catch: Exception -> L9
    L15:
        r16.setAccessible(true);     // Catch: Exception -> L9
        int r17 = r16.getInt(null);     // Catch: Exception -> L9
        Method r18 = r13.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L9
        r18.setAccessible(true);     // Catch: Exception -> L9
        Object r19 = r18.invoke(r13, new Object[]{Integer.valueOf(r17)});     // Catch: Exception -> L9
        if (r19 != null) goto L19;
        r19 = null;
    L19:
        if (r19 != null) goto L21;
        return 0;
    L21:
        Method r20 = r19.getClass().getDeclaredMethod("isVisible", null);     // Catch: Exception -> L9
        r20.setAccessible(true);     // Catch: Exception -> L9
        Object r21 = r20.invoke(r19, null);     // Catch: Exception -> L9
        if ((r21 instanceof Boolean) == false) goto L24;
        Boolean r22 = (Boolean) r21;     // Catch: Exception -> L9
    L25:
        if (r22 != null) goto L28;
        return 0;
    L28:
        if (r22.booleanValue() == false) goto L37;
        Method r23 = r19.getClass().getDeclaredMethod("getFrame", null);     // Catch: Exception -> L9
        r23.setAccessible(true);     // Catch: Exception -> L9
        Object r24 = r23.invoke(r19, null);     // Catch: Exception -> L9
        if ((r24 instanceof Rect) == false) goto L32;
        r5 = (Rect) r24;     // Catch: Exception -> L9
    L32:
        if (r5 != null) goto L34;
        return 0;
    L34:
        return r5.height();
    L37:
        return 0;
    L24:
        r22 = null;
        goto L25
    L14:
        r16 = r15.getDeclaredField("ITYPE_IME");     // Catch: Exception -> L9
        goto L15
    L11:
        r15 = Class.forName("android.view.InsetsState");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L37
    }

    public static int p(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r10 = r5.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (r10 > 0) goto L8;
        Class<?> r11 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r12 = r11.newInstance();     // Catch: Exception -> L11
        int r13 = Integer.parseInt(r11.getField("navigation_bar_height").get(r12).toString());     // Catch: Exception -> L11
        return r5.getResources().getDimensionPixelSize(r13);
    L11:
        return 0;
    L8:
        return r5.getResources().getDimensionPixelSize(r10);
    }

    public static final int q(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r10 = r5.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r10 > 0) goto L8;
        Class<?> r11 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r12 = r11.newInstance();     // Catch: Exception -> L11
        int r13 = Integer.parseInt(r11.getField("status_bar_height").get(r12).toString());     // Catch: Exception -> L11
        return r5.getResources().getDimensionPixelSize(r13);
    L11:
        return 0;
    L8:
        return r5.getResources().getDimensionPixelSize(r10);
    }

    public static final Insets r(View r5, WindowInsets r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (r10 != null) goto L5;
        r10 = r5.getRootWindowInsets();
    L5:
        if (r10 != null) goto L9;
        return Insets.NONE;
    L9:
        return WindowInsetsCompat.toWindowInsetsCompat(r10).getSystemWindowInsets();
    }

    public static final boolean s(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        Resources r10 = r5.getResources();
        int r11 = r10.getIdentifier("config_navBarInteractionMode", "integer", "android");
        if (r11 > 0) goto L5;
        return false;
    L5:
        if (r10.getInteger(r11) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean t(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r5.getResources().getConfiguration().orientation != 2) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        ps.a.b(e, "OWindowConfigController", "isLandscape error");
        return false;
    }
}
