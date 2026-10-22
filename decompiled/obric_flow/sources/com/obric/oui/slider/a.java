package com.obric.oui.slider;

import android.content.Context;
import android.util.Log;
import android.widget.SeekBar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TickMarkSeekBar f14553b;

    public /* synthetic */ a(TickMarkSeekBar r5, int r10) {
        this.f14552a = r10;
        this.f14553b = r5;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r13, int r14, boolean r15) {
        switch(this.f14552a) {
            case 0: goto L56;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r13, "seekBar");
        TickMarkSeekBar r12 = this.f14553b;
        if (r12.isHapticFeedbackEnabled() == false) goto L48;
        Context r5 = r12.getContext();
        int r10 = r12.f14531a;
        boolean r11 = r12.f14550y;
        al.a r16 = r12.f14551z;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r13, "seekBar");
        if (r15 == true) goto L9;
        r16.f314b = Integer.valueOf(r14);
        r16.f313a = Integer.MAX_VALUE;
        goto L48
    L9:
        r16.f313a = 0;
        int r17 = r13.getMin();
        int r18 = r13.getMax();
        if (r14 != r17) goto L12;
        r16.f(r5, 5, "hit minProgress", true, null);
        goto L48
    L12:
        if (r14 != r18) goto L14;
        r16.f(r5, 4, "hit maxProgress", true, null);
        goto L48
    L14:
        int r19 = r10 - 1;
        if (r11 == false) goto L48;
        if (r19 <= 1) goto L48;
        if (((Integer) r16.f314b) == null) goto L46;
        float r20 = (r18 - r17) / r19;
        if (1 > r19) goto L46;
        int r21 = 1;
    L22:
        int r22 = r21 + 1;
        int r23 = MathKt.roundToInt((r21 * r20) - (r20 / 2)) + r17;
        Integer r110 = (Integer) r16.f314b;
        Intrinsics.checkNotNull(r110);
        if (r110.intValue() >= r23) goto L26;
        if (r14 < r23) goto L26;
        boolean r111 = true;
    L27:
        Integer r112 = (Integer) r16.f314b;
        Intrinsics.checkNotNull(r112);
        if (r112.intValue() <= r23) goto L31;
        if (r14 > r23) goto L31;
        boolean r24 = true;
    L32:
        if (r21 == 1) goto L41;
        if (r21 != r19) goto L36;
        r111 = r24;
        goto L41
    L36:
        if (r111 == true) goto L40;
        if (r24 == true) goto L40;
        r111 = false;
    L40:
        r111 = true;
    L41:
        if (r111 == true) goto L42;
        if (r21 == r19) goto L46;
        r21 = r22;
        goto L22
    L42:
        r16.f(r5, 26, "passed boundary: " + r21 + '/' + r19 + ", progress: " + r14, false, r13);
    L31:
        r24 = false;
    L26:
        r111 = false;
    L46:
        r16.f314b = Integer.valueOf(r14);
    L48:
        if (r12.S == false) goto L51;
        StringBuilder r25 = new StringBuilder("[listener-progress][");
        r25.append(Integer.toHexString(System.identityHashCode(r12)));
        r25.append("] ");
        r25.append("progress=" + r14 + ", fromUser=" + r15 + ", currentProgress=" + TickMarkSeekBar.b(r12) + ", currentTargetProgress=" + r12.f14537k + ", tickMarkCount=" + r12.f14531a);
        ps.a.a("TickSeekBar", r25.toString());
    L51:
        b r113 = r12.V;
        if (r113 == null) goto L63;
        ((we.a) r113).h(r13, TickMarkSeekBar.q(r14), r15);
        return;
    L63:
        return;
    L56:
        Log.i("SeekBarCompat", String.valueOf(r14));
        SeekBarCompat r114 = (SeekBarCompat) this.f14553b;
        SeekBar.OnSeekBarChangeListener r26 = r114.f14530b0;
        if (r26 == null) goto L64;
        r26.onProgressChanged(r13, r14 + r114.f14529a0, r15);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r5) {
        TickMarkSeekBar r10 = this.f14553b;
        switch(this.f14552a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        int r11 = TickMarkSeekBar.W;
        r10.getClass();
        b r12 = r10.V;
        if (r12 == null) goto L14;
        ((we.a) r12).j(r5);
        return;
    L14:
        return;
    L9:
        SeekBar.OnSeekBarChangeListener r13 = ((SeekBarCompat) r10).f14530b0;
        if (r13 == null) goto L15;
        r13.onStartTrackingTouch(r5);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r5) {
        switch(this.f14552a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        TickMarkSeekBar r10 = this.f14553b;
        b r11 = r10.V;
        if (r11 == null) goto L14;
        ((we.a) r11).k(r10);
        return;
    L14:
        return;
    L9:
        SeekBar.OnSeekBarChangeListener r12 = ((SeekBarCompat) this.f14553b).f14530b0;
        if (r12 == null) goto L15;
        r12.onStopTrackingTouch(r5);
        return;
    }
}
