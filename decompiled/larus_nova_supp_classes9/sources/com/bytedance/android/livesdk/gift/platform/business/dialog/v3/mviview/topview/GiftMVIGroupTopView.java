package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.GiftCommonHintView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.AnimMoveType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickGroupItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.FirstSendType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftGroupViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenBuffGroupConfirmDialog;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenGroupConfirmDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIGroupTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftGroupViewState, GiftAction> {
    public static final /* synthetic */ int u = 0;
    public final Lazy m;
    public View n;
    public View o;
    public Disposable p;
    public boolean q;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel.e r;
    public int s;
    public final DataCenter t;

    public static final class a {
    }

    public static final class b extends LinearLayoutManager {
        public boolean a;

        public final boolean canScrollHorizontally() {
            if (this.a == true) goto L5;
        L7:
            return false;
        L5:
            if (super.canScrollHorizontally() == false) goto L7;
            return true;
        }

        public b(Context r2) {
            super(r2, 0, false);
            this.a = true;
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ GiftMVIGroupTopView a;
        public final /* synthetic */ Long b;
        public final /* synthetic */ FirstSendType c;
        public final /* synthetic */ int d;

        public c(GiftMVIGroupTopView r1, Long r2, FirstSendType r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            GiftMVIGroupTopView r9 = this.a;
            Long r0 = this.b;
            FirstSendType r1 = this.c;
            r9.getClass();
            com.bytedance.tools.kcp.spongepreference.runtime.a r10 = ay1.b.u;
            KProperty[] r2 = ay1.b.a;
            KProperty r3 = r2[23];
            Boolean r4 = Boolean.TRUE;
            r10.setValue(null, r3, r4);
            if (r1 != FirstSendType.INCREASE_CARD_DIALOG) goto L8;
            Map r11 = MapsKt.toMutableMap(ay1.b.m());
            if (r0 == null) goto L7;
            r0.longValue();
            r11.put(String.valueOf(r0.longValue()), r4);
        L7:
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            ay1.b.v.setValue(null, r2[24], r11);
        L8:
            r7.dismiss();
            this.a.o(new ClickGroupItem(this.d));
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567543;
    }

    public final RecyclerView u() {
        return (RecyclerView) this.m.getValue();
    }

    public final void i() {
        Disposable r0 = this.p;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.r.a();
    }

    public final void t() {
        Disposable r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r0.dispose();
        return;
    }

    public final boolean v() {
        Boolean r0 = (Boolean) this.t.get("data_is_portrait", Boolean.TRUE);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final void g() {
        this.n = r().findViewById(2131387207);
        this.o = r().findViewById(2131371622);
        boolean r0 = v();
        int r1 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r0) == false) goto L16;
        View r2 = this.n;
        if (r2 == null) goto L7;
        r2.setVisibility(8);
    L7:
        View r3 = this.o;
        if (r3 == null) goto L10;
        r3.setVisibility(0);
    L10:
        RecyclerView r4 = u();
        if (r4 == null) goto L13;
        r4.setFadingEdgeLength(s1.f(40.0f));
    L13:
        RecyclerView r5 = u();
        if (r5 == null) goto L16;
        r5.setHorizontalFadingEdgeEnabled(true);
    L16:
        this.q = true;
        u().setVisibility(0);
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIGroupTopView$bindToParent$1 r0 = GiftMVIGroupTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r8) {
        Intrinsics.checkNotNullParameter(r8, "e");
        if ((r8 instanceof OpenGroupConfirmDialog) == false) goto L7;
        Context r0 = getContext();
        OpenGroupConfirmDialog r9 = (OpenGroupConfirmDialog) r8;
        com.bytedance.android.livesdk.gift.platform.business.config.j r2 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r4 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        w(r0.getString(2131919165, new Object[]{Integer.valueOf(r9.getGroupCount() * r9.getIconModel().a.getDiamondCount()), ((DiamondConfig) r2.c(r4, DiamondConfig.a.a())).b}), r9.getPosition(), null, FirstSendType.NORMAL_DIALOG);
        return true;
    L7:
        if ((r8 instanceof OpenBuffGroupConfirmDialog) == false) goto L10;
        Context r1 = getContext();
        OpenBuffGroupConfirmDialog r10 = (OpenBuffGroupConfirmDialog) r8;
        com.bytedance.android.livesdk.gift.platform.business.config.j r3 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r5 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        w(r1.getString(2131918913, new Object[]{Integer.valueOf(r10.getGroupCount()), r10.getHintText(), Long.valueOf(r10.getTotalDiamond()), ((DiamondConfig) r3.c(r5, DiamondConfig.a.a())).b}), r10.getPosition(), Long.valueOf(r10.getGiftId()), r10.getSendCheck());
        return true;
    L10:
        return false;
    }

    public final void k(com.bytedance.android.anya.dsl.a<GiftGroupViewState, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$registerListAdapters");
        r5.a(GiftMVIGroupTopView$registerListAdapters$1.INSTANCE, new GiftMVIGroupTopView$registerListAdapters$2(this), u(), new GiftMVIGroupTopView$registerListAdapters$3(this));
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final void p(int r3) {
        super.p(r3);
        RecyclerView.LayoutManager r0 = u().getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L5;
        r0 = null;
    L5:
        LinearLayoutManager r1 = (LinearLayoutManager) r0;
        if (r1 == null) goto L8;
        r1.scrollToPosition(0);
    L8:
        this.s = r3;
    }

    public final void b(com.bytedance.android.anya.k r10, MVIState r11) {
        GiftGroupViewState r13 = (GiftGroupViewState) r11;
        Intrinsics.checkNotNullParameter(r10, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r13, "state");
        r0<GiftGroupViewState, Integer> r0 = r13.getSelectedPosition();
        Object r1 = r10.c.a(r0);
        int r3 = 0;
        LinearLayoutManager r5 = null;
        if (r1 == null) goto L28;
        r10.b.a.invoke(r0);
        int r2 = ((Number) r1).intValue();
        RecyclerView.LayoutManager r4 = u().getLayoutManager();
        if ((r4 instanceof b) == true) goto L7;
        r4 = null;
    L7:
        b r6 = (b) r4;
        if (r2 != (-1)) goto L20;
        boolean r7 = v();
        int r8 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r7) == true) goto L18;
        if (r6 == null) goto L18;
        int r9 = r6.findFirstCompletelyVisibleItemPosition();
        View r14 = this.n;
        if (r14 == null) goto L18;
        if (r9 != 0) goto L16;
        int r15 = 8;
    L17:
        r14.setVisibility(r15);
        goto L18
    L16:
        r15 = 0;
    L18:
        if (r6 == null) goto L28;
        r6.a = true;
        goto L28
    L20:
        boolean r16 = v();
        int r17 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r16) == true) goto L25;
        View r18 = this.n;
        if (r18 == null) goto L25;
        r18.setVisibility(0);
    L25:
        u().scrollToPosition(r2);
        if (r6 == null) goto L28;
        r6.a = false;
    L28:
        r0<GiftGroupViewState, vz1.e> r19 = r13.getIconModel();
        Object r20 = r10.c.a(r19);
        if (r20 == null) goto L41;
        r10.b.a.invoke(r19);
        vz1.e r21 = (vz1.e) r20;
        if (this.s == 8) goto L41;
        this.r.a();
        this.q = true;
        Ref.IntRef r23 = new Ref.IntRef();
        r23.element = 0;
        t();
        LinearLayoutManager r24 = u().getLayoutManager();
        if ((r24 instanceof LinearLayoutManager) == false) goto L37;
        r5 = r24;
    L37:
        LinearLayoutManager r25 = r5;
        if (r25 == null) goto L40;
        r25.scrollToPosition(0);
    L40:
        com.bytedance.android.live.core.utils.rxutils.j.a r26 = com.bytedance.android.live.core.utils.rxutils.j.a;
        com.bytedance.android.live.core.utils.rxutils.j.a(100, 100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b0(this, r23));
    L41:
        r0<GiftGroupViewState, Integer> r27 = r13.getComboStartAnimPosition();
        Object r28 = r10.c.a(r27);
        if (r28 == null) goto L60;
        r10.b.a.invoke(r27);
        int r29 = ((Number) r28).intValue();
        if (r29 == (-1)) goto L60;
        RecyclerView.Adapter r30 = u().getAdapter();
        if (r30 == null) goto L60;
        int r31 = r30.getItemCount();
        int r33 = 0;
    L50:
        if (r33 >= r31) goto L60;
        RecyclerView.ViewHolder r34 = u().findViewHolderForAdapterPosition(r33);
        if (r34 == null) goto L59;
        View r35 = r34.itemView;
        if (r35 == null) goto L59;
        if (r33 >= r29) goto L57;
        this.r.d(r35, AnimMoveType.Left);
        goto L59
    L57:
        if (r33 <= r29) goto L59;
        this.r.d(r35, AnimMoveType.Right);
    L59:
        r33 = r33 + 1;
    L60:
        r0<GiftGroupViewState, Integer> r110 = r13.getComboEndAnimPosition();
        Object r36 = r10.c.a(r110);
        if (r36 == null) goto L79;
        r10.b.a.invoke(r110);
        int r111 = ((Number) r36).intValue();
        if (r111 == (-1)) goto L92;
        RecyclerView.Adapter r112 = u().getAdapter();
        if (r112 == null) goto L93;
        int r113 = r112.getItemCount();
    L69:
        if (r3 >= r113) goto L94;
        RecyclerView.ViewHolder r37 = u().findViewHolderForAdapterPosition(r3);
        if (r37 == null) goto L78;
        View r38 = r37.itemView;
        if (r38 == null) goto L78;
        if (r3 >= r111) goto L76;
        this.r.c(r38, AnimMoveType.Left);
        goto L78
    L76:
        if (r3 <= r111) goto L78;
        this.r.c(r38, AnimMoveType.Right);
    L78:
        r3 = r3 + 1;
        goto L69
    L94:
        return;
    L93:
        return;
    L92:
        return;
    }

    public GiftMVIGroupTopView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, r3);
        this.t = r4;
        this.m = LazyKt.lazy(new GiftMVIGroupTopView$mGiftGroupRecyclerView$2(this, r2));
        this.r = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel.e();
        this.s = 8;
    }

    public final void w(String r4, int r5, Long r6, FirstSendType r7) {
        Intrinsics.checkNotNullParameter(r7, "firstSendType");
        GiftCommonHintView r0 = new GiftCommonHintView(getContext());
        r0.setTitle(r4);
        com.bytedance.android.livesdk.e.b().a();
        cs2.b r8 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(getContext(), 6);
        r8.a.setContentView(r0);
        c r1 = new c(this, r6, r7, r5);
        r8.a.a(0, 2131919094, r1);
        d r9 = d.a;
        r8.a.a(1, 2131919085, r9);
        r8.h();
    }
}
