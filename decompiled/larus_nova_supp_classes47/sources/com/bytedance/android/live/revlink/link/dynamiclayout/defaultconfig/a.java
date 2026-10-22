package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.live.dynamicresource.client.ResourceClientContext;
import com.bytedance.revenue.platform.api.core.rx.h;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t51.f;
import t51.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.live.dynamicresource.producer.a<f, g, o51.f> {
    public final DefaultConfig a;
    public final MediaDefaultConfig b;

    public a() {
        this.a = new DefaultConfig();
        this.b = new MediaDefaultConfig();
    }

    public final Object c(Object r2, ResourceClientContext r3) {
        o51.f r4 = (o51.f) r2;
        Intrinsics.checkNotNullParameter(r4, "routerKey");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "$this$isMedia");
        o51.f.i r5 = o51.f.i.e;
        if (Intrinsics.areEqual(r4, r5) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L17;
        if (Intrinsics.areEqual(r4, r5) == false) goto L14;
        return (g) this.b.b.getValue();
    L14:
        if (Intrinsics.areEqual(r4, o51.f.h.e) == true) goto L52;
    L49:
        return null;
    L52:
        return (g) this.b.c.getValue();
    L17:
        if (Intrinsics.areEqual(r4, o51.f.j.e) == false) goto L20;
        return this.a.c();
    L20:
        if (Intrinsics.areEqual(r4, o51.f.b.e) == false) goto L23;
        return (g) this.a.c.getValue();
    L23:
        if (Intrinsics.areEqual(r4, o51.f.c.e) == false) goto L26;
        return (g) this.a.d.getValue();
    L26:
        if (Intrinsics.areEqual(r4, o51.f.d.e) == false) goto L29;
        return (g) this.a.e.getValue();
    L29:
        if (Intrinsics.areEqual(r4, o51.f.e.e) == false) goto L32;
        return (g) this.a.f.getValue();
    L32:
        if (Intrinsics.areEqual(r4, o51.f.k.e) == false) goto L35;
        return (g) this.a.g.getValue();
    L35:
        if (Intrinsics.areEqual(r4, o51.f.l.e) == false) goto L38;
        return (g) this.a.h.getValue();
    L38:
        if (Intrinsics.areEqual(r4, o51.f.m.e) == false) goto L41;
        return (g) this.a.i.getValue();
    L41:
        if (Intrinsics.areEqual(r4, o51.f.n.e) == false) goto L44;
        return (g) this.a.j.getValue();
    L44:
        if (Intrinsics.areEqual(r4, o51.f.C0284f.e) == false) goto L47;
        return (g) this.a.k.getValue();
    L47:
        if (Intrinsics.areEqual(r4, o51.f.g.e) == false) goto L49;
        return (g) this.a.l.getValue();
    L5:
        if (Intrinsics.areEqual(r4, o51.f.h.e) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void a(Object r2, ResourceClientContext r3, Object r4) {
        Intrinsics.checkNotNullParameter((o51.f) r2, "routerKey");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter((g) r4, "res");
    }

    public final Disposable b(Object r2, ResourceClientContext r3, Function1 r4, Function1 r5) {
        Intrinsics.checkNotNullParameter((o51.f) r2, "routerKey");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        Intrinsics.checkNotNullParameter(r5, "onFail");
        int r6 = h.a;
        return h.a(DefaultResProducer$produceAsync$1.INSTANCE);
    }
}
