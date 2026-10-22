package com.bytedance.android.live.componentsmarket.impl.components.title;

import android.graphics.Paint;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.common.MatchMarqueeTextView;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ TitleTetris a;

    public c(TitleTetris r1) {
        this.a = r1;
    }

    public final void onChanged(Object r12) {
        String r13 = (String) r12;
        final TitleTetris r0 = this.a;
        boolean r2 = false;
        if (r0.k0() == false) goto L92;
        TextView r1 = r0.x;
        if (r1 == null) goto L7;
        r1.setVisibility(8);
    L7:
        com.bytedance.android.livesdk.common.j r3 = r0.A;
        com.bytedance.live.datacontext.h r4 = null;
        if ((r3 instanceof FrameLayout) == true) goto L10;
        r3 = null;
    L10:
        FrameLayout r5 = (FrameLayout) r3;
        if (r5 == null) goto L14;
        r5.setVisibility(0);
    L14:
        if (r0.F == false) goto L31;
        com.bytedance.android.livesdk.common.j r6 = r0.A;
        if (r6 == null) goto L18;
        r6.setSpeed(UtilityKotlinExtentionsKt.i(38));
    L18:
        com.bytedance.android.livesdk.common.j r7 = r0.A;
        if (r7 == null) goto L21;
        r7.setScrollEnd(true);
    L21:
        com.bytedance.android.livesdk.common.j r8 = r0.A;
        if (r8 == null) goto L24;
        r8.setTextColor(-1);
    L24:
        com.bytedance.live.datacontext.h r9 = r0.A;
        if ((r9 instanceof FrameLayout) == false) goto L28;
        r4 = r9;
    L28:
        FrameLayout r11 = (FrameLayout) r4;
        if (r11 == null) goto L98;
        r11.post(new g(r0));
    L98:
        r0.o0(r13);
        return;
    L31:
        com.bytedance.android.livesdk.common.j r14 = r0.A;
        if (r14 == null) goto L34;
        r14.setIncludeFontPadding(true);
    L34:
        com.bytedance.android.livesdk.common.j r15 = r0.A;
        if (r15 == null) goto L38;
        r15.setSpeed(UtilityKotlinExtentionsKt.i(38));
    L38:
        if ((r0.A instanceof MatchMarqueeTextView) == true) goto L40;
    L46:
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, ((d90.a) r0.K()).h, 0, 2);
        if (r16 == null) goto L53;
        m r17 = r16.isRoomTitleMarqueed();
        if (r17 == null) goto L53;
        Boolean r18 = (Boolean) r17.getValue();
        if (r18 == null) goto L53;
        r2 = r18.booleanValue();
    L53:
        if (r2 == false) goto L71;
        com.bytedance.android.livesdk.common.j r19 = r0.A;
        if (r19 == null) goto L65;
        Paint r21 = r19.getPaint();
        String r22 = r0.j0();
        if (r21 != null) goto L59;
        String r23 = null;
    L64:
        r19.setTextWithEllipsis(r23);
        goto L65
    L59:
        float r24 = r21.measureText(r22);
        StringBuilder r25 = new StringBuilder();
    L61:
        if (r21.measureText(r25.toString()) >= r24) goto L63;
        r25.append(' ');
        goto L61
    L63:
        r23 = r25.toString();
    L65:
        com.bytedance.android.livesdk.common.j r26 = r0.A;
        if ((r26 instanceof FrameLayout) == true) goto L68;
        r26 = null;
    L68:
        FrameLayout r27 = (FrameLayout) r26;
        if (r27 == null) goto L82;
        r27.post(new i(r0));
    L82:
        RoomContext r28 = RoomContext.a.c(RoomContext.Companion, ((d90.a) r0.K()).h, 0, 2);
        if (r28 == null) goto L85;
        r4 = r28.getRoomTitleAndAnchorNameTimer();
    L85:
        if (r4 != null) goto L87;
    L88:
        if (r4 == null) goto L90;
        final long r29 = 111;
        final long r31 = 1000;
        r4.e(new TitleTetris$startAnimationListener$1(r29, r31));
    L90:
        if (r4 == null) goto L98;
        r4.c(new TitleTetris$startAnimationListener$2(r0));
        goto L98
    L87:
        if (r4.hasValue() == true) goto L90;
    L71:
        com.bytedance.android.livesdk.common.j r32 = r0.A;
        if (r32 == null) goto L75;
        r32.setTextWithFading(r0.j0());
    L75:
        if (r0.k0() == false) goto L82;
        com.bytedance.android.livesdk.common.j r33 = r0.A;
        if (r33 == null) goto L79;
        r33.setTextColor(-1);
    L79:
        com.bytedance.android.livesdk.common.j r34 = r0.A;
        if (r34 == null) goto L82;
        r34.setTextWithEllipsisImmediately(r0.j0());
        goto L82
    L40:
        if (r0.isScreenPortrait() == true) goto L46;
        MatchMarqueeTextView r35 = r0.A;
        if (r35 == null) goto L45;
        r35.post(new h(r0));
        goto L46
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.common.MatchMarqueeTextView");
    L92:
        TextView r36 = r0.x;
        if (r36 == null) goto L95;
        r36.setVisibility(0);
    L95:
        TextView r37 = r0.x;
        if (r37 == null) goto L98;
        r37.setText(r13);
        goto L98
    }
}
