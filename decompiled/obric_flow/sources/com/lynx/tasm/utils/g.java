package com.lynx.tasm.utils;

import ai.i0;
import ai.j0;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f11171a = -1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class f11172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f11173c;
    public static volatile int d;
    public static volatile int e;

    public static float a(float r5, float r10) {
        if (r10 > 0.0f) goto L6;
        r10 = DisplayMetricsHolder.a().density;
    L6:
        return r5 * r10;
    }

    public static final int b(int r5, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (f11171a >= 0) goto L5;
        f11171a = r10.getResources().getDisplayMetrics().density;
    L5:
        ConcurrentHashMap r11 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r12 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r12 == null) goto L12;
        xc.d r13 = (xc.d) r12.a(xc.d.class);
        if (r13 == null) goto L12;
        Boolean r14 = r13.M();
        if (r14 == null) goto L12;
        boolean r15 = r14.booleanValue();
    L14:
        if (r15 == false) goto L18;
        return (int) ((r5 * f11171a) + 0.5f);
    L18:
        return MathKt.roundToInt((r5 * f11171a) + 0.5f);
    L12:
        r15 = true;
        goto L14
    }

    public static int c(Context r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return (int) ((r10 / r5.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String d(String r5, String r10, String r11) {
        return j0.k(r5, r10, r11);
    }

    public static final nb.b e(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = -1;
        Object r11 = r5.getSystemService("window");     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L10
        Display r12 = ((WindowManager) r11).getDefaultDisplay();     // Catch: Exception -> L10
        Point r13 = new Point();     // Catch: Exception -> L10
        if (r12 == null) goto L6;
        r12.getRealSize(r13);     // Catch: Exception -> L10
        int r14 = h(r13.x, r5);     // Catch: Exception -> L10
        r10 = h(r13.y, r5);     // Catch: Exception -> L13
    L12:
        return new nb.b(r14, r10);
    L6:
        return new nb.b(-1, -1);
    L10:
        r14 = -1;
        goto L12
    }

    public static void f(int r5, Function0 r10) {
        if (r5 != 3) goto L9;
        if (com.bytedance.ies.bullet.core.h.g.f5315a == false) goto L9;
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.c("AnnieXSceneManager", (String) r10.invoke());
        return;
    L9:
        if (r5 != 4) goto L11;
    L14:
        int r12 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXSceneManager", (String) r10.invoke(), null, 12);
        return;
    L11:
        if (r5 == 5) goto L14;
    }

    public static final byte[] g(int r5) {
        LinkedList r10 = cb.a.d;
        if (r5 != 4096) goto L5;
        LinkedList r11 = cb.a.d;
        monitor-enter(r11);
        byte[] r12 = (byte[]) r11.poll();     // Catch: Throwable -> L14
        if (r12 != null) goto L12;
        r12 = new byte[4096];     // Catch: Throwable -> L14
    L12:
        monitor-exit(r11);
        return r12;
    L14:
        th = move-exception;
        throw th;
    L5:
        return new byte[r5];
    }

    public static final int h(int r5, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (f11171a >= 0) goto L6;
        f11171a = r10.getResources().getDisplayMetrics().density;
    L6:
        return (int) ((r5 / f11171a) + 0.5f);
    }

    public static int i(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        boolean r5 = true;
        if (((Boolean) com.bytedance.ies.bullet.base.utils.c.f5232a.getValue()).booleanValue() == true) goto L5;
    L7:
        Resources r10 = r11.getResources();
        int r12 = r10.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r12 <= 0) goto L10;
        int r13 = r10.getDimensionPixelSize(r12);
    L11:
        Rect r14 = new Rect();
        if ((r11 instanceof Activity) == false) goto L40;
        ((Activity) r11).getWindow().getDecorView().getWindowVisibleDisplayFrame(r14);
        int r15 = r14.height();
    L27:
        DisplayMetrics r16 = r11.getResources().getDisplayMetrics();
        if (r16 == null) goto L30;
        int r17 = r16.heightPixels;
    L31:
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r11, "context");
        Resources r18 = r11.getResources();
        if (r18 != null) goto L34;
        r18 = Resources.getSystem();
    L34:
        int r19 = r18.getIdentifier("status_bar_height", "dimen", "android");
        if (r19 <= 0) goto L37;
        int r110 = r18.getDimensionPixelSize(r19);
    L39:
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((r17 - r110) - r15, 0), r13);
    L37:
        r110 = 0;
        goto L39
    L30:
        r17 = 0;
        goto L31
    L15:
        if ((r11 instanceof Activity) == false) goto L17;
        WindowManager r20 = ((Activity) r11).getWindowManager();     // Catch: Exception -> L27
    L18:
        Display r21 = r20.getDefaultDisplay();
        DisplayMetrics r22 = new DisplayMetrics();
        Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r21, new Object[]{r22});     // Catch: Exception -> L21
        r17 = r22.heightPixels;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        DisplayMetrics r23 = r11.getResources().getDisplayMetrics();
        if (r23 == null) goto L25;
        int r24 = r23.heightPixels;
    L26:
        e.printStackTrace();
        r17 = r24;
        goto L31
    L25:
        r24 = 0;
        goto L26
    L17:
        Object r25 = r11.getSystemService("window");     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L27
        r20 = (WindowManager) r25;     // Catch: Exception -> L27
        goto L18
    L40:
        Intrinsics.checkNotNullParameter(r11, "context");
        Resources r111 = r11.getResources();
        int r26 = r111.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r26 <= 0) goto L43;
        boolean r112 = r111.getBoolean(r26);
    L55:
        Class<?> r27 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L54
        Object r28 = r27.getMethod("get", new Class[]{String.class}).invoke(r27, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L54
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L54
        String r29 = (String) r28;     // Catch: Exception -> L54
        if (Intrinsics.areEqual(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, r29) == false) goto L47;
        r5 = false;
    L51:
        if (r5 == true) goto L53;
        return 0;
    L53:
        return r13;
    L47:
        if (Intrinsics.areEqual("0", r29) == true) goto L51;
    L50:
        r5 = r112;
        goto L51
    L43:
        r112 = false;
        goto L55
    L10:
        r13 = 0;
        goto L11
    L5:
        if (Settings.Global.getInt(r11.getContentResolver(), "hide_gesture_line", 0) != 1) goto L7;
        return 0;
    }

    public static String j(String r5, byte[] r10) {
        String r11 = "";
        byte[] r12 = Base64.decode(r10, 0);     // Catch: Exception -> L15
        if (android.text.TextUtils.isEmpty(r5) == false) goto L19;
        return "";
    L19:
        SecretKeySpec r13 = new SecretKeySpec(r5.getBytes(), "AES");     // Catch: Exception -> L16
        Cipher r14 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L16
        r14.init(2, r13);     // Catch: Exception -> L16
        String r15 = new String(r14.doFinal(r12));     // Catch: Exception -> L16
        int r16 = r15.indexOf("$");     // Catch: Exception -> L12
        if (r16 == (-1)) goto L23;
        return r15.substring(0, r16);
    L23:
        return r15;
    L12:
        r11 = r15;
    L14:
        return r11;
    L15:
        return "";
    }

    public static int k(int r5, RoundingMode r10) {
        if (r5 <= 0) goto L25;
        boolean r11 = true;
        switch(com.google.common.math.c.f9305a[r10.ordinal()]) {
            case 1: goto L12;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        int r12 = Integer.numberOfLeadingZeros(r5);
        return ((~(~(((-1257966797) >>> r12) - r5))) >>> 31) + (31 - r12);
    L6:
        throw new AssertionError();
    L10:
        return 32 - Integer.numberOfLeadingZeros(r5 - 1);
    L12:
        if (r5 <= 0) goto L14;
        boolean r13 = true;
    L16:
        if (((r5 - 1) & r5) == 0) goto L20;
        r11 = false;
    L20:
        if ((r13 & r11) == true) goto L22;
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    L14:
        r13 = false;
    L22:
        return 31 - Integer.numberOfLeadingZeros(r5);
    L25:
        StringBuilder r14 = new StringBuilder(27);
        r14.append("x (");
        r14.append(r5);
        r14.append(") must be > 0");
        throw new IllegalArgumentException(r14.toString());
    }

    public static String l(String r10) {
        if (android.text.TextUtils.isEmpty(r10) == false) goto L42;
        return "unknown message";
    L42:
        String[] r5 = r10.split(":");     // Catch: Throwable -> L39
        if (r5.length != 2) goto L10;
        String r11 = r5[1];     // Catch: Throwable -> L39
    L12:
        if (r10.contains("{") == true) goto L14;
    L18:
        String r12 = r10;
    L20:
        if (r10.contains("@") == false) goto L25;
        String[] r13 = r10.split("@");     // Catch: Throwable -> L17
        if (r13.length <= 1) goto L25;
        r10 = r13[0];     // Catch: Throwable -> L17
    L25:
        if (r10.contains("(") == false) goto L35;
        if (r10.contains(")") == false) goto L35;
        if (r10.endsWith(" null") == true) goto L35;
        String[] r14 = r10.split("\\(");     // Catch: Throwable -> L17
        if (r14.length <= 1) goto L33;
        r10 = r14[1];     // Catch: Throwable -> L17
    L33:
        r10 = r10.replace(")", "");     // Catch: Throwable -> L17
    L35:
        if (r10.startsWith(" ") == false) goto L37;
        r10 = r10.replace(" ", "");     // Catch: Throwable -> L17
    L37:
        return r10 + r11;
    L44:
        return r12;
    L14:
        if (r10.contains("}") == false) goto L18;
        r12 = r10.split("\\{")[0];     // Catch: Throwable -> L39
        r10 = r12 + r10.split("\\}")[1];     // Catch: Throwable -> L17
        goto L20
    L10:
        r11 = "";
    L45:
        return r10;
    }

    public static byte[] m(boolean r15, int r16, InputStream r17, int[] r18, i0 r19) {
        InputStream r5 = r17;
        if (r16 > 0) goto L5;
        int r10 = 5242880;
    L7:
        if (r10 >= 1048576) goto L10;
        r10 = 1048576;
    L10:
        if (r5 != null) goto L83;
        return null;
    L83:
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L23
        if (r15 == false) goto L15;
        r5 = new GZIPInputStream(r5);     // Catch: Throwable -> L23
    L16:
        int r12 = d;     // Catch: Throwable -> L23
        boolean r13 = true;
        if (r12 < 4096) goto L20;
        if (r12 > 5242880) goto L20;
        boolean r14 = true;
    L21:
        if (r14 == false) goto L25;
        int r110 = d;     // Catch: Throwable -> L23
    L26:
        int r111 = e;     // Catch: Throwable -> L23
        if (r111 < 4096) goto L30;
        if (r111 > 5242880) goto L30;
    L31:
        if (r13 == false) goto L33;
        int r20 = e;     // Catch: Throwable -> L23
    L34:
        byte[] r112 = new byte[r110];     // Catch: Throwable -> L23
        int r113 = 0;
    L84:
    L46:
        e = move-exception;
        if (r15 == false) goto L80;
        if (r113 <= 0) goto L80;
        Logger.w("g", "ungzip got exception " + e);     // Catch: Throwable -> L23
    L72:
        if (r113 <= 0) goto L78;
        if (r19 == null) goto L75;
        r19.M.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - r11));     // Catch: Throwable -> L23
        r19.M.put("streamReadByteCount", Long.valueOf(r113));     // Catch: Throwable -> L23
    L75:
        r18[0] = r113;     // Catch: Throwable -> L23
        n(r5);
        return r112;
    L78:
        n(r5);
        return null;
    L80:
        throw e;     // Catch: Throwable -> L23
    L44:
        e = move-exception;
        String r21 = e.getMessage();     // Catch: Throwable -> L23
        if (r15 == false) goto L68;
        if (r113 <= 0) goto L68;
        if ("CRC mismatch".equals(r21) == false) goto L66;
    L67:
        Logger.w("g", "ungzip got exception " + e);     // Catch: Throwable -> L23
        goto L72
    L66:
        if ("Size mismatch".equals(r21) == true) goto L67;
    L68:
        throw e;     // Catch: Throwable -> L23
    L42:
        e = move-exception;
        Logger.e("g", "new buff error" + e);     // Catch: Throwable -> L23
        n(r5);
        return null;
    L38:
        if ((r113 + 4096) > r112.length) goto L40;
    L50:
        int r114 = r5.read(r112, r113, r112.length - r113);     // Catch: Throwable -> L23 OutOfMemoryError -> L42 IOException -> L44 EOFException -> L46
        if (r114 <= 0) goto L72;
        r113 = r113 + r114;     // Catch: Throwable -> L23 OutOfMemoryError -> L42 IOException -> L44 EOFException -> L46
        if (r113 <= r10) goto L84;
        Logger.w("g", "entity length did exceed given maxLength");     // Catch: Throwable -> L23 OutOfMemoryError -> L42 IOException -> L44 EOFException -> L46
        throw new DownloadFileTooLargeException(r10, r113);     // Catch: Throwable -> L23 OutOfMemoryError -> L42 IOException -> L44 EOFException -> L46
    L40:
        if (r112.length >= r20) goto L48;
        int r115 = r112.length + r20;     // Catch: Throwable -> L23 OutOfMemoryError -> L42 IOException -> L44 EOFException -> L46
    L49:
        byte[] r116 = new byte[r115];     // Catch: Throwable -> L23 OutOfMemoryError -> L42 IOException -> L44 EOFException -> L46
        System.arraycopy(r112, 0, r116, 0, r113);     // Catch: Throwable -> L23 OutOfMemoryError -> L42 IOException -> L44 EOFException -> L46
        r112 = r116;
        goto L50
    L48:
        r115 = r112.length * 2;     // Catch: Throwable -> L23 OutOfMemoryError -> L42 IOException -> L44 EOFException -> L46
        goto L49
    L33:
        r20 = 102400;
    L30:
        r13 = false;
        goto L31
    L25:
        r110 = 32768;
    L20:
        r14 = false;
        goto L21
    L15:
        sj.d r117 = s9.h.f21879a;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        n(r5);
        throw th;
    L5:
        r10 = r16;
        goto L7
    }

    public static void n(Closeable r5) {
        if (r5 == null) goto L9;
        r5.close();     // Catch: Exception -> L5
        return;
    L5:
        Logger.debug();
        return;
    }

    public static String o(StackTraceElement[] r10) {
        if (r10 != null) goto L5;
        return "Invalid Stack\n";
    L5:
        StringBuilder r5 = new StringBuilder();
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r12 >= r11) goto L12;
        StackTraceElement r14 = r10[r12];
        r13 = r13 + 1;
        r5.append("\tat " + r14.getClassName());
        r5.append(".");
        r5.append(r14.getMethodName());
        r5.append("(");
        r5.append(r14.getFileName());
        r5.append(":");
        r5.append(r14.getLineNumber());
        r5.append(")\n");
        if (r13 > 40) goto L12;
        r12 = r12 + 1;
    L12:
        return r5.toString();
    }

    public static final void p(int r10, Context r11) {
        Object r5 = null;
        if (r11 != null) goto L5;
        Object r12 = null;
    L6:
        if (r12 != null) goto L9;
    L11:
        Vibrator r13 = (Vibrator) r5;
        boolean r14 = true;
        if (r13 == null) goto L31;
        Intrinsics.checkNotNullParameter(r13, "target");
    L17:
        e = move-exception;
        ps.a.c("VibratorSmt", Intrinsics.stringPlus("vibrateEffectWithHapticPlayer error: ", e));
        return;
    L15:
        if (f11172b != null) goto L20;
        f11172b = i.a.class;     // Catch: Exception -> L17
    L20:
        if (f11173c != null) goto L25;
        Class r15 = f11172b;     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L17
        Method r16 = r15.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L17
        f11173c = r16;     // Catch: Exception -> L17
        if (r16 == null) goto L25;
        r16.setAccessible(true);     // Catch: Exception -> L17
    L25:
        Method r17 = f11173c;     // Catch: Exception -> L17
        if (r17 == null) goto L38;
        r17.invoke(f11172b, new Object[]{r13, Integer.valueOf(r10)});     // Catch: Exception -> L17
        return;
    L38:
        return;
    L31:
        if (r11 == null) goto L34;
        r14 = false;
    L34:
        ps.a.c("VibratorSmt", Intrinsics.stringPlus("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ", Boolean.valueOf(r14)));
        return;
    L9:
        if ((r12 instanceof Vibrator) == false) goto L11;
        r5 = r12;
        goto L11
    L5:
        r12 = r11.getSystemService("vibrator");
        goto L6
    }
}
