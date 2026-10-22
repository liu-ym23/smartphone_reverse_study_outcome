package com.bytedance.android.livesdk.chatroom.utils;

import android.app.Activity;
import android.app.ActivityOptions;
import com.bytedance.android.livesdk.chatroom.multitask.LiveInnerIndependentManager;
import com.bytedance.android.livesdk.config.bz0;
import com.bytedance.android.livesdk.config.cz0;
import com.bytedance.android.livesdk.config.dz0;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k5 {
    public static boolean a;
    public static final boolean b = false;
    public static final boolean c = false;

    public class a implements InvocationHandler {
        public final /* synthetic */ b a;
        public final /* synthetic */ long b;

        public a(b r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r1, Method r2, Object[] r3) throws Throwable {
            k5.b(this.a, true);
            k5.c(this.b, "1");
            return null;
        }
    }

    public interface b {
        void a();
    }

    static {
        b = bz0.a.getValue().booleanValue();
        c = dz0.a.getValue().booleanValue();
    }

    public static void b(b r0, boolean r1) {
        if (a == true) goto L7;
        if (r0 == null) goto L8;
        r0.a();
        a = true;
        return;
    L8:
        return;
    }

    public static void c(long r3, String r5) {
        if (b == true) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("success", r5);
        r0.put("duration", String.valueOf(System.currentTimeMillis() - r3));
        com.bytedance.android.livesdk.log.u.l().sendLog("ttlive_window_utils_error_alog_upload", r0, new Object[0]);
    }

    public static void a(Activity r11, boolean r12, final b r13) {
        a = false;
        boolean r1 = LiveInnerIndependentManager.c(r11);
        if (r11.isTaskRoot() == true) goto L5;
        if (r12 == true) goto L5;
    L8:
        final long r2 = System.currentTimeMillis();
        Class<?>[] r3 = Activity.class.getDeclaredClasses();     // Catch: Throwable -> L30
        int r4 = r3.length;     // Catch: Throwable -> L30
        Class<?> r6 = null;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L21;
        Class<?> r7 = r3[r5];     // Catch: Throwable -> L30
        if (r7.getSimpleName().contains("TranslucentConversionListener") == false) goto L19;
        if (c == true) goto L16;
    L18:
        r6 = r7;
        goto L19
    L16:
        if (r7.getSimpleName().startsWith("Sem") == false) goto L18;
    L19:
        r5 = r5 + 1;     // Catch: Throwable -> L30
        goto L10
    L21:
        if (r6 == null) goto L24;
        Object r8 = Proxy.newProxyInstance(r6.getClassLoader(), new Class[]{r6}, new a(r13, r2));     // Catch: Throwable -> L30
    L44:
        Method r9 = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);     // Catch: Exception -> L27 Throwable -> L41
        r9.setAccessible(true);     // Catch: Exception -> L27 Throwable -> L41
        Object r10 = r9.invoke(r11, new Object[0]);     // Catch: Exception -> L27 Throwable -> L41
    L28:
        Method r14 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{r6, ActivityOptions.class});     // Catch: Throwable -> L41
        r14.setAccessible(true);     // Catch: Throwable -> L41
        r14.invoke(r11, new Object[]{r8, r10});     // Catch: Throwable -> L41
    L32:
        if (r8 != null) goto L35;
        b(r13, false);
    L39:
        r11.getWindow().setBackgroundDrawable(null);
        return;
    L35:
        if (a == true) goto L39;
        long r15 = cz0.a.getValue().longValue();
        if (r15 <= 0) goto L39;
        fjc.a.a().postDelayed(new j5(r2, r13), r15);
    L27:
        r10 = null;
    L31:
        b(r13, false);
        goto L32
    L24:
        r8 = null;
    L30:
        r8 = null;
    L5:
        if (r1 == true) goto L8;
        b(r13, false);
    }
}
