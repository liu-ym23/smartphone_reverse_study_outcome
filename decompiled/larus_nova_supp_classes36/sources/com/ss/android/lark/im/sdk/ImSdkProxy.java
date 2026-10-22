package com.ss.android.lark.im.sdk;

import com.ss.android.lark.log.Log;
import ikb.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import okb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkProxy {
    public static volatile h a;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;

    public ImSdkProxy() {
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        b = LazyKt.lazy(r0, ImSdkProxy$innerAppProxy$2.INSTANCE);
        c = LazyKt.lazy(r0, ImSdkProxy$innerConfigProxy$2.INSTANCE);
        d = LazyKt.lazy(r0, ImSdkProxy$innerUserProxy$2.INSTANCE);
        e = LazyKt.lazy(r0, ImSdkProxy$innerImageProxy$2.INSTANCE);
        f = LazyKt.lazy(r0, ImSdkProxy$innerOpenProxy$2.INSTANCE);
        g = LazyKt.lazy(r0, ImSdkProxy$innerMonitorProxy$2.INSTANCE);
        h = LazyKt.lazy(r0, ImSdkProxy$innerStorageProxy$2.INSTANCE);
        i = LazyKt.lazy(r0, ImSdkProxy$innerPhotoProxy$2.INSTANCE);
    }

    @JvmStatic
    public static final okb.a b() {
        return (okb.a) b.getValue();
    }

    @JvmStatic
    public static final okb.b c() {
        return (okb.b) c.getValue();
    }

    @JvmStatic
    public static final f d() {
        return (f) i.getValue();
    }

    @JvmStatic
    public static final okb.h e() {
        return (okb.h) d.getValue();
    }

    public static final void a(String r1) {
        Log.i("ImSdkProxy", "ProxyFactory provides full proxy for ".concat(r1));
    }
}
