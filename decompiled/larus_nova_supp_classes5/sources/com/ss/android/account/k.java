package com.ss.android.account;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.account.dialog.Gravity;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.badger.AccountBadger;
import com.ss.android.token.TokenFactory;
import com.ss.android.token.h0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.reflect.KProperty;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k {
    public static final b a = null;
    public static volatile wqa.f b;
    public static volatile wqa.h c;
    public static volatile wqa.c d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static volatile boolean g;
    public static volatile boolean h;
    public static volatile ExecutorService i;
    public static final wqa.b j = null;
    public static long k;

    public static class b extends Handler {
        public b(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r9) {
            switch(r9.what) {
                case 2001: goto L11;
                case 2002: goto L9;
                case 2003: goto L5;
                default: goto L17;
            };
        L5:
            Object r10 = r9.obj;
            if (r10 == null) goto L18;
            Gravity r0 = Gravity.CENTER;
            hb7.b r11 = new hb7.b("！！重要提醒！！", r10.toString(), new hb7.a("我知道了", null, 6, 0), null, false);
            com.bytedance.sdk.account.utils.b.a.a(r11);
            return;
        L18:
            return;
        L9:
            k.b.isLocalTest();
            return;
        L17:
            return;
        L11:
            if (TokenFactory.E == true) goto L16;
            k.b.isLocalTest();
            com.bytedance.sdk.account.monitor.a.a("never_call_token_init", null);
            return;
        }
    }

    public k() {
    }

    static {
        a = new b(Looper.getMainLooper());
        e = false;
        j = new wqa.b();
        k = 0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.ss.android.account.adapter.InternalAccountAdapter");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.account.adapter.InternalAccountAdapter");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.account.adapter.InternalAccountAdapter");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.ss.android.account.adapter.InternalAccountAdapter");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.account.adapter.InternalAccountAdapter");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.account.adapter.InternalAccountAdapter");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.account.adapter.InternalAccountAdapter");
    }

    public static void b() {
        j.a("DoComponentReflectionStart", 0, new Pair[0]);
        a().getMethod("init", new Class[]{Context.class}).invoke(null, new Object[]{b.getApplicationContext()});     // Catch: Exception -> L5
    L7:
        j.a("DoComponentReflectionEnd", 0, new Pair[0]);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static Context c() {
        if (b != null) goto L7;
        return null;
    L7:
        return b.getApplicationContext();
    }

    public static wqa.f d() {
        if (b == null) goto L7;
        return b;
    L7:
        throw new IllegalStateException("not init TTAccount config");
    }

    public static void e(boolean r3) {
        if (r3 == false) goto L4;
        a.postDelayed(new a(), 5000);
    L6:
        if (h0.d(b.getApplicationContext()) == false) goto L14;
        b r4 = a;
        r4.sendEmptyMessageDelayed(2001, 60000);
        r4.sendEmptyMessageDelayed(2002, 10000);
        KProperty[] r5 = AccountBadger.a;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.H == true) goto L11;
        return;
    L11:
        if (AccountBadger.c.compareAndSet(false, true) == false) goto L15;
        ThreadPlus.submitRunnable(com.ss.android.badger.c.a);
        return;
    L15:
        return;
    L14:
        return;
    L4:
        b();
        rgc.b.b(sgc.a.class, com.ss.android.account.b.z0());
        goto L6
    }
}
