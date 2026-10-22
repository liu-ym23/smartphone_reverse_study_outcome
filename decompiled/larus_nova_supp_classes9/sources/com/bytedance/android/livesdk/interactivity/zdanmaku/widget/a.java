package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements qb2.e {
    public final /* synthetic */ CarnivalDanmakuPresenter a;
    public final /* synthetic */ b0 b;

    @Override // qb2.e
    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        b0 r0 = this.b;
        r0.b = r2.a;
        this.a.g0(r0);
        this.a.s0();
    }

    public a(CarnivalDanmakuPresenter r1, b0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
