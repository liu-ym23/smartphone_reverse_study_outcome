package com.ss.ugc.live.sdk.platform;

import com.ss.ugc.live.sdk.msg.dispatch.f;
import com.ss.ugc.live.sdk.platform.imbroadcast.IMBroadcast;
import gm2.o;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final List<f> a = null;
    public static final List<ylc.a> b = null;
    public static final List<omc.b> c = null;
    public static final List<Object> d = null;
    public static final IMBroadcast e = null;
    public static com.ss.ugc.live.sdk.platform.bytelink.f f;

    static {
        a = new CopyOnWriteArrayList();
        b = new CopyOnWriteArrayList();
        c = new CopyOnWriteArrayList();
        d = new CopyOnWriteArrayList();
        e = new IMBroadcast();
        f = new com.ss.ugc.live.sdk.platform.bytelink.f();
    }

    public static void a() {
        Intrinsics.throwUninitializedPropertyAccessException("depend");
    }

    @JvmStatic
    public static final void b(final o r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        List<omc.b> r0 = c;
        CollectionsKt.removeAll(r0, new MessagePlatform$injectSupportPBDecoderWithCheck$1(r2));
        ((CopyOnWriteArrayList) r0).add(r2);
    }
}
