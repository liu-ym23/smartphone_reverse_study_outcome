package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements qb2.e {
    public final /* synthetic */ PortraitSimpleZDanmakuPresenter a;
    public final /* synthetic */ p0 b;

    @Override // qb2.e
    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        SpannableString r3 = r2.a;
        this.b.setRenderSpan(r3);
        p0 r4 = this.b;
        if ((r4 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.d) == false) goto L6;
        this.a.e.a(r4);
        return;
    }

    public a(PortraitSimpleZDanmakuPresenter r1, p0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
