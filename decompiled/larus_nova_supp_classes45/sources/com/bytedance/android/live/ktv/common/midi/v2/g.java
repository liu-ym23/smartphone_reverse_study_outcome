package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.ValueAnimator;
import android.widget.TextView;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DecimalFormat a;
    public final /* synthetic */ KtvRoomMidiViewV2 b;
    public final /* synthetic */ boolean c;

    public g(DecimalFormat r1, KtvRoomMidiViewV2 r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L15;
        float r6 = ((Float) r5).floatValue();
        String r0 = this.a.format(Float.valueOf(r6));
        if (r6 <= 0.0f) goto L7;
    L10:
        TextView r7 = this.b.f;
        if (r7 == null) goto L18;
        r7.setText(r0 + 20998);
        return;
    L18:
        return;
    L7:
        if (r6 == 0.0f) goto L9;
        return;
    L9:
        if (this.c == true) goto L10;
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
