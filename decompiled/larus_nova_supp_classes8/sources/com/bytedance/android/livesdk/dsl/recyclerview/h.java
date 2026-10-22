package com.bytedance.android.livesdk.dsl.recyclerview;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements m {
    public final /* synthetic */ SingleDSLViewHolder a;

    @Override // yt1.m
    public final void onFetchSuccess() {
    }

    public h(SingleDSLViewHolder r1) {
        this.a = r1;
    }

    @Override // yt1.m
    public final void a(final com.bytedance.android.livesdk.dslservice.a r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "loadFrom");
        Intrinsics.checkNotNullParameter(r3, "loadFrom");
        this.a.b.a(1);
        Function1<? super Function0<Unit>, Unit> r4 = this.a.e.b;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke(new SingleDSLViewHolder$2$onLoadSuccess$1(this, r1));
        return;
    }

    @Override // yt1.m
    public final void b(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "reason");
        m.a.a(r1, r2);
    }
}
