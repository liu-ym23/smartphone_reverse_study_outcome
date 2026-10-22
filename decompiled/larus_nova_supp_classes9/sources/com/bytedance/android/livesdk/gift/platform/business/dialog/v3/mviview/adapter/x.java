package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickReceiverItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ReceiverItemState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ReceiverUIType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x extends BaseMVIListItem<ReceiverItemState, GiftAction> {
    public final ImageView l;
    public final TextView m;
    public final TextView n;
    public final View o;
    public final ImageView p;
    public final ImageView q;
    public final View r;
    public final View s;
    public IBaseUser t;
    public ReceiverUIType u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ x a;

        public a(x r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            x r5 = this.a;
            if (r5.u != ReceiverUIType.MultiReceiver) goto L6;
            r5.o(new ClickReceiverItem(r5.p(), this.a.t));
            return;
        }
    }

    public x(View r2) {
        Intrinsics.checkNotNullParameter(r2, "inflateView");
        super(r2, new ReceiverItemState());
        this.l = (ImageView) ((BaseMVIListItem) this).j.findViewById(2131391990);
        this.m = (TextView) ((BaseMVIListItem) this).j.findViewById(2131392049);
        this.n = (TextView) ((BaseMVIListItem) this).j.findViewById(2131387303);
        this.o = ((BaseMVIListItem) this).j.findViewById(2131387304);
        this.p = (ImageView) ((BaseMVIListItem) this).j.findViewById(2131373778);
        this.q = (ImageView) ((BaseMVIListItem) this).j.findViewById(2131373777);
        this.r = ((BaseMVIListItem) this).j.findViewById(2131385822);
        this.s = ((BaseMVIListItem) this).j.findViewById(2131362515);
        this.u = ReceiverUIType.MultiReceiver;
        ((BaseMVIListItem) this).j.setOnClickListener(new a(this));
    }

    public final void b(com.bytedance.android.anya.k r10, MVIState r11) {
        ReceiverItemState r13 = (ReceiverItemState) r11;
        Intrinsics.checkNotNullParameter(r10, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r13, "state");
        r0<ReceiverItemState, IBaseUser> r0 = r13.getReceiver();
        Object r1 = r10.c.a(r0);
        if (r1 == null) goto L5;
        r10.b.a.invoke(r0);
        this.t = (IBaseUser) r1;
    L5:
        r0<ReceiverItemState, ReceiverUIType> r2 = r13.getReceiverUIType();
        Object r3 = r10.c.a(r2);
        if (r3 == null) goto L8;
        r10.b.a.invoke(r2);
        this.u = (ReceiverUIType) r3;
    L8:
        com.bytedance.android.anya.internal.c r4 = r13.getReceiverUIType();
        com.bytedance.android.anya.internal.c r5 = r13.isSelected();
        Object r6 = r10.c.a(r4);
        Object r7 = null;
        if (r6 == null) goto L11;
        r10.b.a.invoke(r4);
    L12:
        Object r8 = r10.c.a(r5);
        if (r8 == null) goto L15;
        r10.b.a.invoke(r5);
    L16:
        if (r6 != null) goto L18;
        if (r8 != null) goto L18;
    L28:
        com.bytedance.android.anya.internal.c r9 = r13.getReceiverUIType();
        com.bytedance.android.anya.internal.c r14 = r13.getAvatarImg();
        Object r15 = r10.c.a(r9);
        if (r15 == null) goto L31;
        r10.b.a.invoke(r9);
    L32:
        Object r16 = r10.c.a(r14);
        if (r16 == null) goto L35;
        r10.b.a.invoke(r14);
    L37:
        if (r15 != null) goto L39;
        if (r16 != null) goto L39;
    L65:
        com.bytedance.android.anya.internal.c r17 = r13.getReceiverUIType();
        com.bytedance.android.anya.internal.c r18 = r13.getReceiverName();
        Object r19 = r10.c.a(r17);
        if (r19 == null) goto L68;
        r10.b.a.invoke(r17);
    L69:
        Object r20 = r10.c.a(r18);
        if (r20 == null) goto L72;
        r10.b.a.invoke(r18);
    L73:
        if (r19 != null) goto L75;
        if (r20 != null) goto L75;
    L86:
        com.bytedance.android.anya.internal.c r21 = r13.getReceiverUIType();
        com.bytedance.android.anya.internal.c r23 = r13.getStatusImg();
        com.bytedance.android.anya.internal.c r24 = r13.isSelected();
        Object r25 = r10.c.a(r21);
        if (r25 == null) goto L89;
        r10.b.a.invoke(r21);
    L90:
        Object r26 = r10.c.a(r23);
        if (r26 == null) goto L93;
        r10.b.a.invoke(r23);
    L94:
        Object r27 = r10.c.a(r24);
        if (r27 == null) goto L97;
        r10.b.a.invoke(r24);
    L98:
        if (r25 != null) goto L101;
        if (r26 != null) goto L101;
        if (r27 != null) goto L101;
    L116:
        com.bytedance.android.anya.internal.c r28 = r13.getReceiverUIType();
        com.bytedance.android.anya.internal.c r29 = r13.getStatusLabel();
        com.bytedance.android.anya.internal.c r110 = r13.isSelected();
        Object r30 = r10.c.a(r28);
        if (r30 == null) goto L119;
        r10.b.a.invoke(r28);
    L120:
        Object r31 = r10.c.a(r29);
        if (r31 == null) goto L123;
        r10.b.a.invoke(r29);
    L124:
        Object r33 = r10.c.a(r110);
        if (r33 == null) goto L127;
        r10.b.a.invoke(r110);
        r7 = r33;
    L127:
        if (r30 != null) goto L130;
        if (r31 != null) goto L130;
        if (r7 != null) goto L130;
        return;
    L130:
        if (r30 != null) goto L132;
        r30 = r28.c();
    L132:
        if (r31 != null) goto L134;
        r31 = r29.c();
    L134:
        if (r7 != null) goto L136;
        r7 = r110.c();
    L136:
        boolean r111 = ((Boolean) r7).booleanValue();
        String r34 = (String) r31;
        if (((ReceiverUIType) r30) == ReceiverUIType.AllMic) goto L144;
        if (r111 == true) goto L144;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r34) == false) goto L143;
        UtilityKotlinExtentionsKt.w(this.n);
        UtilityKotlinExtentionsKt.w(this.o);
        this.n.setText(r34);
        return;
    L143:
        UtilityKotlinExtentionsKt.t(this.n);
        UtilityKotlinExtentionsKt.t(this.o);
        return;
    L144:
        UtilityKotlinExtentionsKt.t(this.n);
        UtilityKotlinExtentionsKt.t(this.o);
        return;
    L123:
        r31 = null;
        goto L124
    L119:
        r30 = null;
    L101:
        if (r25 != null) goto L103;
        r25 = r21.c();
    L103:
        if (r26 != null) goto L105;
        r26 = r23.c();
    L105:
        if (r27 != null) goto L107;
        r27 = r24.c();
    L107:
        boolean r35 = ((Boolean) r27).booleanValue();
        py.k r36 = (py.k) r26;
        if (((ReceiverUIType) r25) == ReceiverUIType.AllMic) goto L115;
        if (r35 == true) goto L115;
        if (r36.isValid() == false) goto L114;
        UtilityKotlinExtentionsKt.w(this.p);
        UtilityKotlinExtentionsKt.w(this.o);
        ImageView r37 = this.p;
        a1.x(r37, r36, r37.getWidth(), this.p.getHeight(), 2131250965);
        goto L116
    L114:
        UtilityKotlinExtentionsKt.t(this.p);
        UtilityKotlinExtentionsKt.t(this.o);
    L115:
        UtilityKotlinExtentionsKt.t(this.p);
        UtilityKotlinExtentionsKt.t(this.o);
        goto L116
    L97:
        r27 = null;
        goto L98
    L93:
        r26 = null;
        goto L94
    L89:
        r25 = null;
    L75:
        if (r19 != null) goto L77;
        r19 = r17.c();
    L77:
        if (r20 != null) goto L79;
        r20 = r18.c();
    L79:
        String r38 = (String) r20;
        if (((ReceiverUIType) r19) == ReceiverUIType.MultiReceiver) goto L83;
        UtilityKotlinExtentionsKt.t(this.m);
        goto L86
    L83:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r38) == false) goto L85;
        UtilityKotlinExtentionsKt.w(this.m);
        this.m.setText(r38);
        goto L86
    L85:
        UtilityKotlinExtentionsKt.t(this.m);
        goto L86
    L72:
        r20 = null;
        goto L73
    L68:
        r19 = null;
    L39:
        if (r15 != null) goto L41;
        r15 = r9.c();
    L41:
        if (r16 != null) goto L43;
        r16 = r14.c();
    L43:
        py.k r39 = (py.k) r16;
        ReceiverUIType r40 = (ReceiverUIType) r15;
        if (r40 != ReceiverUIType.MultiReceiver) goto L51;
        com.bytedance.android.livesdk.gift.platform.core.preview.view.s.a(this.l, s1.f(28.0f));
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(this.l, s1.f(28.0f));
        ImageView r41 = this.l;
        int r43 = s1.f(0.0f);
        Intrinsics.checkNotNullParameter(r41, "$this$setMarginTop");
        ViewGroup.LayoutParams r44 = r41.getLayoutParams();
        if ((r44 instanceof ConstraintLayout.LayoutParams) == true) goto L48;
        r44 = null;
    L48:
        ConstraintLayout.LayoutParams r45 = (ConstraintLayout.LayoutParams) r44;
        if (r45 == null) goto L58;
        ((ViewGroup.MarginLayoutParams) r45).topMargin = r43;
        r41.requestLayout();
    L58:
        if (r40 != ReceiverUIType.AllMic) goto L60;
        UtilityKotlinExtentionsKt.w(this.s);
    L62:
        if (r39.isValid() == false) goto L64;
        ImageView r46 = this.l;
        a1.x(r46, r39, r46.getWidth(), this.l.getHeight(), 2131250965);
        goto L65
    L64:
        ImageUtil.loadRoundResource(this.l, 2131250965, -1, -1);
        goto L65
    L60:
        UtilityKotlinExtentionsKt.t(this.s);
        goto L62
    L51:
        com.bytedance.android.livesdk.gift.platform.core.preview.view.s.a(this.l, s1.f(24.0f));
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(this.l, s1.f(24.0f));
        ImageView r47 = this.l;
        int r48 = s1.f(2.0f);
        Intrinsics.checkNotNullParameter(r47, "$this$setMarginTop");
        ViewGroup.LayoutParams r49 = r47.getLayoutParams();
        if ((r49 instanceof ConstraintLayout.LayoutParams) == true) goto L54;
        r49 = null;
    L54:
        ConstraintLayout.LayoutParams r50 = (ConstraintLayout.LayoutParams) r49;
        if (r50 == null) goto L58;
        ((ViewGroup.MarginLayoutParams) r50).topMargin = r48;
        r47.requestLayout();
        goto L58
    L35:
        r16 = null;
        goto L37
    L31:
        r15 = null;
    L18:
        if (r6 != null) goto L20;
        r6 = r4.c();
    L20:
        if (r8 != null) goto L22;
        r8 = r5.c();
    L22:
        boolean r51 = ((Boolean) r8).booleanValue();
        if (((ReceiverUIType) r6) == ReceiverUIType.MultiReceiver) goto L25;
        UtilityKotlinExtentionsKt.t(this.q);
        UtilityKotlinExtentionsKt.t(this.r);
        goto L28
    L25:
        if (r51 == false) goto L27;
        UtilityKotlinExtentionsKt.w(this.q);
        UtilityKotlinExtentionsKt.w(this.r);
        this.m.setTextColor(s1.h(2131107076));
        UtilityKotlinExtentionsKt.t(this.o);
        goto L28
    L27:
        UtilityKotlinExtentionsKt.t(this.q);
        UtilityKotlinExtentionsKt.t(this.r);
        this.m.setTextColor(s1.h(2131107082));
        goto L28
    L15:
        r8 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    }
}
