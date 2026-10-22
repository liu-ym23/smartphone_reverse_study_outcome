package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickReceiverWidget;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverStateMachineState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ReceiverUIType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowReceiverDialog;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateReceiverInfo;
import com.bytedance.android.livesdk.r3;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftOnlineReceiverMVIView extends BaseGiftMVIViewChildNode<GiftReceiverViewState, GiftReceiverStateMachineState, GiftAction> {
    public final ImageView m;
    public final TextView n;
    public zy0.d o;
    public final ViewGroup p;
    public final View q;
    public final Lazy r;
    public final View s;
    public final View t;
    public final View u;
    public final Lazy v;
    public final Lazy w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GiftOnlineReceiverMVIView a;

        public a(GiftOnlineReceiverMVIView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            GiftOnlineReceiverMVIView r4 = this.a;
            r4.o(new ClickReceiverWidget(GiftOnlineReceiverMVIView.t(r4)));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ GiftOnlineReceiverMVIView a;

        public b(GiftOnlineReceiverMVIView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            GiftOnlineReceiverMVIView r4 = this.a;
            r4.o(new ClickReceiverWidget(GiftOnlineReceiverMVIView.t(r4)));
        }
    }

    public final void i() {
    }

    public final RecyclerView u() {
        return (RecyclerView) this.r.getValue();
    }

    public final void g() {
        r().setOnClickListener(new b(this));
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L5;
        return 2131565766;
    L5:
        return 2131565767;
    }

    public static final int t(GiftOnlineReceiverMVIView r3) {
        r3.getClass();
        if (nz1.a.j().c() == true) goto L11;
        int[] r0 = new int[2];
        r3.l.getLocationInWindow(r0);
        Point r1 = new Point();
        Context r2 = r3.getContext();
        if (r2 == null) goto L10;
        ((Activity) r2).getWindowManager().getDefaultDisplay().getSize(r1);
        return (int) s1.G((r1.y - r0[1]) - r3.l.getHeight());
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L11:
        return s1.j(2131168764);
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftReceiverViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftOnlineReceiverMVIView$bindToParent$1 r0 = GiftOnlineReceiverMVIView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        if ((r4 instanceof ShowReceiverDialog) == false) goto L12;
        Uri r5 = ((ShowReceiverDialog) r4).getDialogUri();
        this.o = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).U0(getContext(), r5, null);     // Catch: Exception -> L7
    L18:
        return true;
    L7:
        zy0.d r6 = this.o;
        if (r6 == null) goto L10;
        r6.dispose();
    L10:
        this.o = null;
        goto L18
    L12:
        if ((r4 instanceof UpdateReceiverInfo) == false) goto L19;
        zy0.d r0 = this.o;
        if (r0 == null) goto L18;
        xy0.a r1 = r0.g();
        if (r1 == null) goto L18;
        r1.sendJsEvent("H5_linkerContributeDidUpdate", ((UpdateReceiverInfo) r4).getData());
        goto L18
    L19:
        return false;
    }

    public final void k(com.bytedance.android.anya.dsl.a<GiftReceiverStateMachineState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$registerListAdapters");
        com.bytedance.android.anya.dsl.a.b(r4, this, GiftOnlineReceiverMVIView$registerListAdapters$1.INSTANCE, new GiftOnlineReceiverMVIView$registerListAdapters$2(this), u());
    }

    public GiftOnlineReceiverMVIView(final Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        super(r3, r4);
        this.m = (ImageView) r().findViewById(2131391990);
        this.n = (TextView) r().findViewById(2131392049);
        this.r = LazyKt.lazy(new GiftOnlineReceiverMVIView$receiverItemList$2(this, r3));
        this.v = LazyKt.lazy(new GiftOnlineReceiverMVIView$allMicItemDecoration$2(this));
        this.w = LazyKt.lazy(GiftOnlineReceiverMVIView$multiItemDecoration$2.INSTANCE);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L7;
        View r5 = r().findViewById(2131373776);
        this.s = r5;
        this.q = r().findViewById(2131383855);
        this.p = (ViewGroup) r().findViewById(2131383854);
        this.t = r().findViewById(2131384540);
        this.u = r().findViewById(2131387023);
        if (r5 == null) goto L9;
        r5.setOnClickListener(new a(this));
        return;
    L9:
        return;
    L7:
        this.p = (ViewGroup) r().findViewById(2131383854);
    }

    public final void b(com.bytedance.android.anya.k r8, MVIState r9) {
        GiftReceiverStateMachineState r10 = (GiftReceiverStateMachineState) r9;
        Intrinsics.checkNotNullParameter(r8, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r10, "state");
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, py.k> r0 = r10.getAvatarThumb();
        Object r1 = r8.c.a(r0);
        if (r1 == null) goto L8;
        r8.b.a.invoke(r0);
        py.k r2 = (py.k) r1;
        if (r2.isValid() == false) goto L7;
        ImageView r3 = this.m;
        com.bytedance.android.livesdk.chatroom.utils.a1.x(r3, r2, r3.getWidth(), this.m.getHeight(), 2131250965);
        goto L8
    L7:
        ImageUtil.loadRoundResource(this.m, 2131250965, -1, -1);
    L8:
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, String> r4 = r10.getNickname();
        Object r5 = r8.c.a(r4);
        if (r5 == null) goto L14;
        r8.b.a.invoke(r4);
        String r6 = (String) r5;
        this.n.setText(r6);
        ViewGroup r7 = this.p;
        if (r7 == null) goto L13;
        r7.setContentDescription(s1.C(2131919972, new Object[]{r6}));
    L13:
        r3.c(this.p, getContext().getString(2131919972, new Object[]{r6}), true);
    L14:
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, Integer> r11 = r10.getAvatarVisibility();
        Object r13 = r8.c.a(r11);
        if (r13 == null) goto L19;
        r8.b.a.invoke(r11);
        int r14 = ((Number) r13).intValue();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == true) goto L19;
        this.m.setVisibility(r14);
    L19:
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, py.k> r15 = r10.getBackground();
        Object r16 = r8.c.a(r15);
        if (r16 == null) goto L31;
        r8.b.a.invoke(r15);
        py.k r17 = (py.k) r16;
        if (r17.isValid() != true) goto L27;
        if (nz1.a.j().b() == false) goto L31;
        com.bytedance.android.livesdk.chatroom.utils.a1.k(r17).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i1(this), j1.a);
        goto L31
    L27:
        if (nz1.a.j().b() == false) goto L31;
        ViewGroup r18 = this.p;
        if (r18 == null) goto L31;
        r18.setBackgroundResource(2131249185);
    L31:
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, ReceiverUIType> r19 = r10.getReceiverUIType();
        Object r20 = r8.c.a(r19);
        if (r20 == null) goto L89;
        r8.b.a.invoke(r19);
        ReceiverUIType r21 = (ReceiverUIType) r20;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L92;
        int r23 = h1.a[r21.ordinal()];
        if (r23 != 1) goto L39;
        ViewGroup r24 = this.p;
        if (r24 == null) goto L78;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(r24, -2);
    L78:
        View r25 = this.s;
        if (r25 == null) goto L81;
        UtilityKotlinExtentionsKt.w(r25);
    L81:
        UtilityKotlinExtentionsKt.w(u());
        UtilityKotlinExtentionsKt.t(this.n);
        View r26 = this.t;
        if (r26 == null) goto L84;
        UtilityKotlinExtentionsKt.t(r26);
    L84:
        View r27 = this.q;
        if (r27 == null) goto L87;
        r27.setBackground(null);
    L87:
        RecyclerView r28 = u();
        r28.removeItemDecoration((RecyclerView.ItemDecoration) this.v.getValue());
        r28.addItemDecoration((RecyclerView.ItemDecoration) this.w.getValue());
        r28.setLayoutManager(new LinearLayoutManager(r28.getContext(), 0, false));
        return;
    L39:
        if (r23 != 2) goto L41;
        ViewGroup r29 = this.p;
        if (r29 == null) goto L62;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(r29, com.bytedance.android.live.revenue.common.i.b(200));
    L62:
        UtilityKotlinExtentionsKt.w(u());
        View r30 = this.u;
        if (r30 == null) goto L65;
        UtilityKotlinExtentionsKt.w(r30);
    L65:
        View r31 = this.t;
        if (r31 == null) goto L68;
        UtilityKotlinExtentionsKt.w(r31);
    L68:
        UtilityKotlinExtentionsKt.w(this.n);
        View r33 = this.q;
        if (r33 == null) goto L71;
        r33.setBackground(s1.m(2131248754));
    L71:
        View r34 = this.s;
        if (r34 == null) goto L74;
        UtilityKotlinExtentionsKt.t(r34);
    L74:
        RecyclerView r35 = u();
        r35.removeItemDecoration((RecyclerView.ItemDecoration) this.w.getValue());
        r35.removeItemDecoration((RecyclerView.ItemDecoration) this.v.getValue());
        return;
    L41:
        if (r23 != 3) goto L93;
        ViewGroup r36 = this.p;
        if (r36 == null) goto L46;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(r36, com.bytedance.android.live.revenue.common.i.b(200));
    L46:
        UtilityKotlinExtentionsKt.w(u());
        UtilityKotlinExtentionsKt.w(this.n);
        View r37 = this.u;
        if (r37 == null) goto L49;
        UtilityKotlinExtentionsKt.w(r37);
    L49:
        View r38 = this.t;
        if (r38 == null) goto L52;
        UtilityKotlinExtentionsKt.w(r38);
    L52:
        UtilityKotlinExtentionsKt.w(this.n);
        View r39 = this.q;
        if (r39 == null) goto L55;
        r39.setBackground(s1.m(2131248754));
    L55:
        View r40 = this.s;
        if (r40 == null) goto L58;
        UtilityKotlinExtentionsKt.t(r40);
    L58:
        RecyclerView r41 = u();
        r41.removeItemDecoration((RecyclerView.ItemDecoration) this.w.getValue());
        r41.addItemDecoration((RecyclerView.ItemDecoration) this.v.getValue());
        LinearLayoutManager r43 = new LinearLayoutManager(r41.getContext(), 0, false);
        r43.setStackFromEnd(true);
        r43.setReverseLayout(true);
        r41.setLayoutManager(r43);
        return;
    L93:
        return;
    L92:
        return;
    }
}
