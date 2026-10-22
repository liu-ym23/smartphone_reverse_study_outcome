package com.bytedance.android.livesdk.interactivity.square;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements l52.c.b {
    public final /* synthetic */ j a;

    public i(j r1) {
        this.a = r1;
    }

    @Override // l52.c.b
    public final void a(h52.d r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r0 = this.a.j;
        Intrinsics.checkNotNullParameter(r0, "$this$getReceiver");
        Intrinsics.checkNotNullParameter(r3, "origin");
        h52.a<h52.d, ? extends h52.c> r1 = r0.getMessagePluginByType(r3.b());
        if (r1 != null) goto L5;
    L7:
        r1 = null;
    L8:
        if (r1 == null) goto L18;
        gc2.a r4 = r1.d(r3);
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.a == false) goto L14;
        this.a.i.a(r4, false, false);
        return;
    L14:
        Function1<? super List<? extends h52.c>, Unit> r2 = this.a.b;
        if (r2 == null) goto L21;
        Unit r5 = (Unit) r2.invoke(CollectionsKt.listOf(r4));
        return;
    L21:
        return;
    L18:
        return;
    L5:
        if (r1.a(r3) == false) goto L7;
        goto L7
    }
}
