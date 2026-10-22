package com.bytedance.android.live.network;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.network.ILiveRetrofitWrapper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.retrofit2.Retrofit;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static volatile com.bytedance.android.live.a e;
    public static volatile c f;
    public final ConcurrentHashMap<Class, Object> a;
    public final ConcurrentHashMap<Class, Object> b;
    public volatile Retrofit c;
    public volatile ILiveRetrofitWrapper d;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.android.live.network.impl.utils.RetrofitProvider");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.network.impl.utils.RetrofitProvider");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.network.impl.utils.RetrofitProvider");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.android.live.network.impl.utils.RetrofitProvider");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.network.impl.utils.RetrofitProvider");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.network.impl.utils.RetrofitProvider");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.network.impl.utils.RetrofitProvider");
    }

    public static c b() {
        if (f != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public static com.bytedance.android.live.a d() {
        if (e != null) goto L9;
        int r0 = jc1.e.a;     // Catch: Throwable -> L6
        e = (com.bytedance.android.live.a) a().newInstance();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        ALogger.i("NetWorkService_", "LiveClient getRetrofitProvider   sRetrofitProvider = null  " + th.getMessage());
        ALogger.e("NetWorkService_", th);
        th.printStackTrace();
    L9:
        return e;
    }

    public final Retrofit c() {
        if (this.c != null) goto L13;
        com.bytedance.android.live.a r1 = d();
        if (r1 == null) goto L13;
        this.c = r1.getRetrofitInstance();     // Catch: Throwable -> L10
        if (this.c != null) goto L13;
        ALogger.i("NetWorkService_", "LiveClient getRetrofit   retrofit = null  ");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        ALogger.i("NetWorkService_", "LiveClient getRetrofit   retrofit = null  err " + th.getMessage());
    L13:
        return this.c;
    }

    public c() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public final <T> T e(Class<T> r3) {
        if (this.a.contains(r3) == true) goto L9;
        Retrofit r0 = c();
        if (r0 == null) goto L7;
        this.a.putIfAbsent(r3, r0.create(r3));
        goto L9
    L7:
        ALogger.i("NetWorkService_", "LiveClient getService   getRetrofit = null  ".concat(r3.getName()));
    L9:
        return (T) this.a.get(r3);
    }
}
