package com.bytedance.android.livesdk.interactivity.comment.record.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragContainer;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragParentView;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.q;
import com.bytedance.android.livesdk.interactivity.comment.record.viewmodel.HighlightRecordContext;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LiveHighlightRecordController {
    public boolean a;
    public int b;
    public final View c;
    public final View d;
    public final TextView e;
    public final ImageView f;
    public final ImageView g;
    public final q h;
    public final q4.b i;
    public final q4.b j;
    public final HighlightRecordContext k;
    public final RecordDragParentView l;
    public final RecordDragContainer m;

    public final void a() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        this.m.setEnableDrag(true);
        int r1 = this.b;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L13;
        u4.c(new LiveHighlightRecordController$createRightBallCollapseAnimator$1(this)).c();
        return;
    L13:
        return;
    L10:
        u4.c(new LiveHighlightRecordController$createLeftBallCollapseAnimator$1(this)).c();
    }

    public LiveHighlightRecordController(HighlightRecordContext r7, RecordDragParentView r8, RecordDragContainer r9) {
        Intrinsics.checkNotNullParameter(r8, "dragParentView");
        Intrinsics.checkNotNullParameter(r9, "handleBall");
        this.k = r7;
        this.l = r8;
        this.m = r9;
        this.a = true;
        View r1 = r9.findViewById(2131383985);
        this.c = r1;
        View r2 = r9.findViewById(2131363861);
        this.d = r2;
        this.e = (TextView) r9.findViewById(2131391255);
        ImageView r3 = (ImageView) r9.findViewById(2131376543);
        this.f = r3;
        this.g = (ImageView) r9.findViewById(2131376542);
        q r4 = new q();
        r4.setAlpha(128);
        r4.a(UtilityKotlinExtentionsKt.i(40));
        Unit r5 = Unit.INSTANCE;
        this.h = r4;
        this.i = u4.c(new LiveHighlightRecordController$showAnimator$1(this));
        u4.c(new LiveHighlightRecordController$hideAnimator$1(this));
        this.j = u4.c(new LiveHighlightRecordController$redDotBreathAnimator$1(this));
        r2.setBackground(r4);
        r1.setOnClickListener(x0.a(new AnonymousClass1(this)));
        r3.setOnClickListener(x0.a(new AnonymousClass2(this)));
        r9.setOnMoveToSideListener(new AnonymousClass3(this));
        r8.setOnOtherAreaTouchListener(new AnonymousClass4(this));
        if (r7 == null) goto L10;
        DataCenter r10 = r7.getDataCenter();
        if (r10 != null) goto L7;
        return;
    L7:
        if (gb2.a.c(r10, true) == true) goto L12;
        r9.setEnableDrag(false);
        return;
    L12:
        return;
    }
}
