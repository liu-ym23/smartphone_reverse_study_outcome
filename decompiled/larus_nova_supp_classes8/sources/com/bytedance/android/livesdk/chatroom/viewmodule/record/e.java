package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.ReverseHorizontalLinearLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public boolean a;
    public int b;
    public final ReverseHorizontalLinearLayout c;
    public final View d;
    public final View e;
    public final TextView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final q j;
    public final q4.b k;
    public final c l;
    public final RecordDragParentView m;
    public final RecordDragContainer n;

    public final void b() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        this.n.setEnableDrag(true);
        int r1 = this.b;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L13;
        u4.c(new LiveRecordHandleBallController$createRightBallCollapseAnimator$1(this)).c();
        return;
    L13:
        return;
    L10:
        u4.c(new LiveRecordHandleBallController$createLeftBallCollapseAnimator$1(this)).c();
    }

    public static final void a(e r2) {
        boolean r0 = r2.a;
        if (r0 == false) goto L17;
        if (r0 == false) goto L21;
        r2.a = false;
        r2.n.setEnableDrag(false);
        UtilityKotlinExtentionsKt.t(r2.i);
        if (((LiveRecordWidget) r2.l).r == false) goto L9;
        r2.g.setImageResource(2131251398);
    L10:
        r2.k.a();
        r2.g.setAlpha(0.0f);
        r2.h.setAlpha(0.0f);
        UtilityKotlinExtentionsKt.w(r2.g);
        UtilityKotlinExtentionsKt.w(r2.h);
        int r1 = r2.b;
        if (r1 != 0) goto L13;
        u4.c(new LiveRecordHandleBallController$createLeftBallExpandAnimator$1(r2, r2.i.getAlpha())).c();
        return;
    L13:
        if (r1 != 1) goto L22;
        u4.c(new LiveRecordHandleBallController$createRightBallExpandAnimator$1(r2, r2.i.getAlpha())).c();
        return;
    L22:
        return;
    L9:
        r2.g.setImageResource(2131251397);
        goto L10
    L21:
        return;
    L17:
        r2.b();
    }

    public e(LiveRecordWidget r8, RecordDragParentView r9, RecordDragContainer r10) {
        Intrinsics.checkNotNullParameter(r8, "bridge");
        Intrinsics.checkNotNullParameter(r9, "dragParentView");
        Intrinsics.checkNotNullParameter(r10, "handleBall");
        this.l = r8;
        this.m = r9;
        this.n = r10;
        this.a = true;
        ReverseHorizontalLinearLayout r0 = r10.findViewById(2131383998);
        this.c = r0;
        View r1 = r10.findViewById(2131383985);
        this.d = r1;
        View r2 = r10.findViewById(2131363861);
        this.e = r2;
        this.f = (TextView) r10.findViewById(2131391255);
        ImageView r3 = (ImageView) r10.findViewById(2131376104);
        this.g = r3;
        ImageView r4 = (ImageView) r10.findViewById(2131376543);
        this.h = r4;
        this.i = (ImageView) r10.findViewById(2131376542);
        q r5 = new q();
        r5.setAlpha(128);
        r5.a(UtilityKotlinExtentionsKt.i(40));
        Unit r6 = Unit.INSTANCE;
        this.j = r5;
        u4.c(new LiveRecordHandleBallController$showAnimator$1(this));
        u4.c(new LiveRecordHandleBallController$hideAnimator$1(this));
        this.k = u4.c(new LiveRecordHandleBallController$redDotBreathAnimator$1(this));
        r0.setReverse(false);
        r2.setBackground(r5);
        r1.setOnClickListener(x0.a(new LiveRecordHandleBallController$1(this)));
        r3.setOnClickListener(x0.a(new LiveRecordHandleBallController$2(this)));
        r4.setOnClickListener(x0.a(new LiveRecordHandleBallController$3(this)));
        r10.setOnMoveToSideListener(new LiveRecordHandleBallController$4(this));
        r9.setOnOtherAreaTouchListener(new LiveRecordHandleBallController$5(this));
        if (r8.isScreenPortrait() == true) goto L6;
        r10.setEnableDrag(false);
        return;
    }
}
