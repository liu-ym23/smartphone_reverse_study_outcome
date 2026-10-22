package com.bytedance.android.live.browser;

import com.bytedance.android.annie.resource.AnnieGeckoAppRegister;
import com.bytedance.android.annie.resource.AnnieGeckoClient;
import com.bytedance.android.live.browser.gecko.SaaSGeckoAppRegister;
import com.bytedance.android.livesdk.config.ma;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<V> implements Callable {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        AnnieGeckoClient r0 = com.bytedance.android.annie.resource.i.a;
        com.bytedance.android.annie.resource.g r1 = new com.bytedance.android.annie.resource.g();
        Intrinsics.checkNotNullParameter("saas", "<set-?>");
        r1.a = "saas";
        r1.b = true;
        ma r2 = ma.a;
        r1.d = ((Boolean) r2.getValue()).booleanValue();
        int r3 = u20.b.b();
        if (r3 <= 0) goto L5;
        Map r4 = MapsKt.mapOf(TuplesKt.to("ecomSaaSVersion", Integer.valueOf(r3)));
    L6:
        r1.c = r4;
        Unit r5 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "config");
        if (com.bytedance.android.annie.ng.g.g == false) goto L9;
        com.bytedance.android.annie.resource.i.a = new AnnieGeckoClient(r1);
    L10:
        int r6 = com.bytedance.android.annie.resource.h.a;
        com.bytedance.geckox.b r7 = com.bytedance.geckox.b.a.a;
        com.bytedance.geckox.b.e(new AnnieGeckoAppRegister());
        if (((Boolean) r2.getValue()).booleanValue() == false) goto L14;
        com.bytedance.geckox.b r8 = com.bytedance.geckox.b.a.a;
        com.bytedance.geckox.b.e(new SaaSGeckoAppRegister());
        return;
    L14:
        return;
    L9:
        x8.a.b("AnnieResourceInterceptor", "annie env not init", false);
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
