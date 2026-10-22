package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements t22.d {
    public final /* synthetic */ PinAnswerProcessor a;
    public final /* synthetic */ j42.b b;

    @Override // t22.d
    public final void a(CharSequence r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        PinAnswerProcessor.u(this.a, r4.toString(), this.b, null);
    }

    public g(PinAnswerProcessor r1, j42.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
