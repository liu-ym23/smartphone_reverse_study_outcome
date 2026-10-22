package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.GuestBattleSeatAnimTask;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimTaskState;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.o;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.v;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.w;
import com.bytedance.android.live.liveinteract.view.MicSeatSponsorView;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/SeatAnimationView;", "Landroid/widget/FrameLayout;", "Lke0/a;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/o;", "taskChain", "", "setTaskChain", "Landroid/widget/ImageView;", "guestAvatar", "setGuestAvatar", "Landroid/widget/TextView;", "guestName", "setGuestName", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/SeatAnimTaskState;", "getTaskState", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LinkSucAnimationView$a;", "linkSucCallback", "setLinkSucCallback", "Lcom/bytedance/android/livesdk/chatroom/ui/e6;", "emojiCallback", "setEmojiCallback", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/e;", "listener", "setSeatAnimTaskListener", "getLinkSucAnimCallback", "", "enable", "setEnableShowKtvSeatAnimation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeatAnimationView extends FrameLayout implements ke0.a {
    public static final /* synthetic */ int t = 0;
    public v a;
    public View b;
    public LinkSucAnimationView.a c;
    public LinkSucAnimationView d;
    public DynamicEmojiView e;
    public HSImageView f;
    public ViewGroup g;
    public ViewGroup h;
    public HSImageView i;
    public MicSeatSponsorView j;
    public HSImageView k;
    public KtvSeatAnimationView l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;

    public SeatAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SeatAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void e() {
        int r0 = this.m;
        if (r0 == 0) goto L7;
        int r1 = this.n;
        if (r1 == 0) goto L7;
        f(this.d, r0, r1);
    L7:
        int r2 = this.o;
        if (r2 == 0) goto L12;
        int r3 = this.p;
        if (r3 == 0) goto L12;
        f(this.e, r2, r3);
        f(this.i, this.o, this.p);
        f(this.k, this.o, this.p);
    L12:
        Integer r4 = je0.d.h();
        if (r4 != null) goto L16;
    L20:
        int r5 = this.q;
        if (r5 == 0) goto L26;
        int r6 = this.r;
        if (r6 == 0) goto L27;
        f(this.f, r5, r6);
        return;
    L27:
        return;
    L26:
        return;
    L16:
        if (r4.intValue() != 24) goto L20;
        HSImageView r7 = this.i;
        if (r7 == null) goto L20;
        r7.setPadding(s1.f(10.0f), s1.f(10.0f), s1.f(10.0f), 0);
        goto L20
    }

    public final SeatAnimTaskState getTaskState() {
        v r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final LinkSucAnimationView.a getLinkSucAnimCallback() {
        return this.c;
    }

    public final void a(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.h r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.s == true) goto L5;
        return;
    L5:
        v r0 = this.a;
        if (r0 == null) goto L9;
        r0.c(r2);
        return;
    }

    @Override // ke0.a
    public final void b(w r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        ALogger.i("TAG", "handleWidgetInfo taskEngine: " + this.a);
        v r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r3);
        return;
    L6:
        if ((r3 instanceof com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b) == false) goto L14;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r4 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b) r3;
        if (r4.b == false) goto L15;
        Function0<Unit> r5 = r4.i;
        if (r5 == null) goto L16;
        Unit r6 = (Unit) r5.invoke();
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void setEmojiCallback(e6 r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiCallback");
        DynamicEmojiView r0 = this.e;
        if (r0 == null) goto L6;
        r0.setEmojiAnimCallback(r2);
        return;
    }

    public final void setEnableShowKtvSeatAnimation(boolean r2) {
        this.s = r2;
        if (r2 == true) goto L6;
        a(new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.h(false));
        return;
    }

    public final void setGuestAvatar(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "guestAvatar");
        LinkSucAnimationView r0 = this.d;
        if (r0 == null) goto L6;
        r0.setGuestAvatar(r2);
        return;
    }

    public final void setGuestName(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "guestName");
        LinkSucAnimationView r0 = this.d;
        if (r0 == null) goto L6;
        r0.setGuestName(r2);
        return;
    }

    public final void setLinkSucCallback(LinkSucAnimationView.a r2) {
        Intrinsics.checkNotNullParameter(r2, "linkSucCallback");
        this.c = r2;
        LinkSucAnimationView r0 = this.d;
        if (r0 == null) goto L6;
        r0.setCallback(r2);
        return;
    }

    public final void setSeatAnimTaskListener(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.e r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        v r1 = this.a;
        if (r1 == null) goto L10;
        Intrinsics.checkNotNullParameter(r4, "listener");
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d r2 = r1.b;
    L5:
        if (r2 == null) goto L14;
        if ((r2 instanceof GuestBattleSeatAnimTask) == false) goto L9;
        Intrinsics.checkNotNullParameter(r4, "listener");
        ((GuestBattleSeatAnimTask) r2).c = r4;
    L9:
        r2 = r2.a();
        goto L5
    L14:
        return;
    }

    public final void setTaskChain(o r3) {
        Intrinsics.checkNotNullParameter(r3, "taskChain");
        v r0 = this.a;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "chain");
        r0.b = r3;
        return;
    }

    public SeatAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.s = true;
    }

    public static int d(int r1, MicSeatScene r2, boolean r3) {
        if (r1 != 4) goto L5;
        return 2131567606;
    L5:
        if (r1 == 5) goto L27;
        if (r1 != 8) goto L9;
        if (r3 == false) goto L24;
        return 2131567916;
    L24:
        return 2131567921;
    L9:
        if (r1 != 9) goto L11;
        return 2131567735;
    L11:
        if (r1 == 12) goto L15;
        return 2131567834;
    L15:
        if (d0.d() == false) goto L18;
        return 2131567917;
    L18:
        return 2131567918;
    L27:
        if (r2 != MicSeatScene.AUDIO_LINK_HAMLET_AVATAR_C_POSITION) goto L29;
        return 2131565186;
    L29:
        return 2131567645;
    }

    public static void f(View r1, int r2, int r3) {
        if (r1 == null) goto L6;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = r2;
    L6:
        if (r1 == null) goto L11;
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        if (r4 == null) goto L12;
        r4.height = r3;
        return;
    L12:
        return;
    }

    public /* synthetic */ SeatAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void c(int r16, MicSeatScene r17, boolean r18, boolean r19, int r20, int r21) {
        Intrinsics.checkNotNullParameter(r17, "micSeatScene");
        View r5 = FrameLayout.inflate(getContext(), 2131567777, this);
        this.b = r5;
        ViewGroup r6 = null;
        if (r5 == null) goto L5;
        ViewGroup r7 = (ViewGroup) r5.findViewById(2131389552);
    L6:
        this.g = r7;
        Integer r8 = je0.d.h();
        if (r8 != null) goto L10;
    L14:
        ViewGroup r9 = this.g;
        if (r9 == null) goto L17;
        a1.j(r9, 1);
    L17:
        ViewGroup r10 = this.g;
        if (r10 == null) goto L20;
        r10.removeAllViews();
    L20:
        int r11 = -1;
        if (r20 <= 0) goto L24;
        if (r21 <= 0) goto L24;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(r20, r21);
    L25:
        ViewGroup r3 = this.g;
        if (r3 == null) goto L28;
        r3.setLayoutParams(r12);
    L28:
        View r2 = FrameLayout.inflate(getContext(), d(r16, r17, r19), this.g);
        Integer r4 = je0.d.h();
        if (r4 != null) goto L32;
    L38:
        ViewGroup.LayoutParams r13 = r2.getLayoutParams();
        if (r13 == null) goto L88;
        ((FrameLayout.LayoutParams) r13).gravity = 1;
    L41:
        ViewGroup r14 = this.g;
        if (r14 == null) goto L44;
        LinkSucAnimationView r15 = (LinkSucAnimationView) r14.findViewById(2131378017);
    L45:
        this.d = r15;
        ViewGroup r22 = this.g;
        if (r22 == null) goto L48;
        DynamicEmojiView r23 = (DynamicEmojiView) r22.findViewById(2131370473);
    L49:
        this.e = r23;
        ViewGroup r24 = this.g;
        if (r24 == null) goto L52;
        HSImageView r25 = (HSImageView) r24.findViewById(2131371535);
    L53:
        this.f = r25;
        ViewGroup r26 = this.g;
        if (r26 == null) goto L56;
        HSImageView r27 = (HSImageView) r26.findViewById(2131374073);
    L57:
        this.i = r27;
        ViewGroup r28 = this.g;
        if (r28 == null) goto L60;
        MicSeatSponsorView r29 = (MicSeatSponsorView) r28.findViewById(2131378753);
    L61:
        this.j = r29;
        ViewGroup r30 = this.g;
        if (r30 == null) goto L64;
        HSImageView r31 = (HSImageView) r30.findViewById(2131388568);
    L65:
        this.k = r31;
        ViewGroup r32 = this.g;
        if (r32 == null) goto L68;
        KtvSeatAnimationView r33 = (KtvSeatAnimationView) r32.findViewById(2131377075);
    L69:
        this.l = r33;
        e();
        if (r16 == 5) goto L75;
        int r34 = 0;
        if (r16 != 9) goto L79;
        r11 = (int) UIUtils.dip2Px(getContext(), 52.0f);
    L79:
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(r11, r11);
        r1.gravity = 17;
        if (r34 == 0) goto L82;
        r1.topMargin = r34;
    L82:
        View r35 = this.b;
        if (r35 == null) goto L85;
        r6 = (ViewGroup) r35.findViewById(2131389547);
    L85:
        this.h = r6;
        v r36 = new v();
        this.a = r36;
        Intrinsics.checkNotNull(r36);
        r36.b(this.i, this.j, this.k, this.d, this.e, this.f, this.l);
        return;
    L75:
        if (r18 == false) goto L77;
        int r37 = getResources().getDimensionPixelSize(2131169249);
        float r38 = UIUtils.dip2Px(getContext(), 2.0f);
    L78:
        r11 = r37;
        r34 = (int) r38;
        goto L79
    L77:
        r37 = getResources().getDimensionPixelSize(2131169246);
        r38 = UIUtils.dip2Px(getContext(), -4.0f);
        goto L78
    L68:
        r33 = null;
        goto L69
    L64:
        r31 = null;
        goto L65
    L60:
        r29 = null;
        goto L61
    L56:
        r27 = null;
        goto L57
    L52:
        r25 = null;
        goto L53
    L48:
        r23 = null;
        goto L49
    L44:
        r15 = null;
        goto L45
    L88:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L32:
        if (r4.intValue() != 24) goto L38;
        ViewGroup.LayoutParams r39 = r2.getLayoutParams();
        if (r39 == null) goto L37;
        ((FrameLayout.LayoutParams) r39).gravity = 17;
        goto L41
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L24:
        r12 = new FrameLayout.LayoutParams(-1, -1);
        goto L25
    L10:
        if (r8.intValue() != 24) goto L14;
        ViewGroup r40 = this.g;
        if (r40 == null) goto L17;
        a1.j(r40, 17);
        goto L17
    L5:
        r7 = null;
        goto L6
    }
}
