package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements qb2.e {
    public final /* synthetic */ PinAnswerHighlightPageItemView a;

    public a(PinAnswerHighlightPageItemView r1) {
        this.a = r1;
    }

    @Override // qb2.e
    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        this.a.c.setText(r2.a);
        UtilityKotlinExtentionsKt.t(this.a.b);
        UtilityKotlinExtentionsKt.w(this.a.c);
    }
}
