package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickFanClubView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopEmptyState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIFanClubTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopEmptyState, GiftAction> {
    public HSImageView m;
    public ImageView n;
    public RelativeLayout o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public final com.bytedance.android.livesdk.gift.configmodel.r t;
    public final com.bytedance.android.live.profit.fansclub.o u;
    public final CompositeDisposable v;
    public zy0.b w;
    public ViewGroup x;
    public ConstraintLayout y;
    public final DataCenter z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GiftMVIFanClubTopView a;

        public a(GiftMVIFanClubTopView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            GiftMVIFanClubTopView r14 = this.a;
            com.bytedance.android.live.profit.fansclub.o r0 = r14.u;
            if (r0 == null) goto L10;
            if (r0.R2() != FansClubUserStatus.Inactive.getValue()) goto L10;
            if (by0.b.a(r14.t.d()) == false) goto L10;
            com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(r14.getContext(), r14.t.d());
            return;
        L10:
            if (nz1.a.c() == false) goto L12;
            FansClubEntranceParams.Page r1 = FansClubEntranceParams.Page.FansClub;
        L13:
            FansClubEntranceParams.Page r2 = r1;
            i12.e r3 = i12.o.b();
            if (r3 == null) goto L16;
            Object r4 = com.bytedance.android.scope.m.e.d(r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class);
        L17:
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r5 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r4;
            if (r5 == null) goto L22;
            IBaseUser r6 = r5.a;
            if (r6 == null) goto L22;
            String r8 = r6.getIdString();
        L23:
            com.bytedance.android.live.profit.fansclub.o r7 = yt0.c.c();
            if (r7 == null) goto L28;
            com.bytedance.android.live.profit.fansclub.p r9 = r7.Z8(new FansClubEntranceParams(r2, false, "bar_guide", null, null, false, r8, 250));
            if (r9 == null) goto L28;
            r9.show();
        L28:
            r14.o(new ClickFanClubView());
            return;
        L22:
            r8 = null;
            goto L23
        L16:
            r4 = null;
            goto L17
        L12:
            r1 = FansClubEntranceParams.Page.Default;
            goto L13
        }
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131566124;
    }

    public final void i() {
        this.v.dispose();
        ViewGroup r0 = this.x;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        zy0.b r1 = this.w;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final void q() {
        this.x = (ViewGroup) r().findViewById(2131373755);
        this.y = r().findViewById(2131373756);
        this.m = r().findViewById(2131391990);
        this.n = (ImageView) r().findViewById(2131391996);
        this.o = (RelativeLayout) r().findViewById(2131372092);
        this.p = (ImageView) r().findViewById(2131372091);
        this.q = (TextView) r().findViewById(2131372094);
        this.s = (TextView) r().findViewById(2131377819);
        TextView r0 = (TextView) r().findViewById(2131384636);
        this.r = r0;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new a(this));
    L5:
        py.k r2 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.b0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[52])).booleanValue() == false) goto L76;
        ConstraintLayout r1 = this.y;
        if (r1 == null) goto L11;
        r1.setVisibility(8);
    L11:
        if (this.w != null) goto L154;
        vy0.c r3 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        Context r5 = getContext();
        x0 r7 = new x0(com.bytedance.android.livesdk.gift.platform.core.h.m().d());
        x0 r6 = r7.d("url");
        DataCenter r8 = this.z;
        if (r8 == null) goto L15;
        IRoom r4 = (IRoom) r8.get("data_room", null);
    L16:
        com.bytedance.android.live.profit.fansclub.o r9 = this.u;
        if (r9 == null) goto L19;
        Integer r10 = Integer.valueOf(r9.R2());
    L20:
        r6.b("fans_club_status", String.valueOf(r10));
        com.bytedance.android.live.profit.fansclub.o r11 = this.u;
        if (r11 == null) goto L31;
        com.bytedance.live.datacontext.m r13 = r11.getProfile();
        if (r13 == null) goto L31;
        com.bytedance.android.live.profit.fansclub.g r14 = (com.bytedance.android.live.profit.fansclub.g) r13.getValue();
        if (r14 == null) goto L31;
        com.bytedance.android.live.profit.fansclub.b r15 = r14.a;
        if (r15 == null) goto L29;
        int r16 = r15.b;
    L30:
        Integer r17 = Integer.valueOf(r16);
    L32:
        r6.b("fans_club_level", String.valueOf(r17));
        if (r4 == null) goto L41;
        IBaseUser r18 = r4.getOwner();
        if (r18 == null) goto L41;
        py.k r19 = r18.getAvatarThumbKt();
        if (r19 == null) goto L41;
        List r20 = r19.getUrls();
        if (r20 == null) goto L41;
        String r21 = (String) CollectionsKt.getOrNull(r20, 0);
    L42:
        r6.b("avatar_url", r21);
        String r23 = "1";
        if (r4 == null) goto L49;
        IRoomAuthStatus r24 = r4.getRoomAuthStatus();
        if (r24 == null) goto L49;
        if (r24.isShopFansClubMode() != true) goto L49;
        String r25 = "1";
    L50:
        r6.b("is_shop_fans", r25);
        GiftContext r26 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r26 == null) goto L57;
        com.bytedance.live.datacontext.m<Boolean> r27 = r26.isVS();
        if (r27 == null) goto L57;
        if (((Boolean) r27.getValue()).booleanValue() != true) goto L57;
    L58:
        r6.b("is_vs", r23);
        com.bytedance.android.live.profit.fansclub.o r28 = this.u;
        if (r28 == null) goto L67;
        com.bytedance.live.datacontext.m r29 = r28.getProfile();
        if (r29 == null) goto L67;
        com.bytedance.android.live.profit.fansclub.g r30 = (com.bytedance.android.live.profit.fansclub.g) r29.getValue();
        if (r30 == null) goto L67;
        com.bytedance.android.live.profit.fansclub.b r31 = r30.a;
        if (r31 == null) goto L67;
        com.bytedance.android.live.profit.fansclub.m r33 = r31.e;
    L68:
        r6.b("guard_info", JsonUtil.toJSONString(r33));
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r34 = r3.J8(r5, r7.c(), null);
        this.w = r34;
        if (r34 == null) goto L155;
        ViewGroup r35 = this.x;
        if (r35 == null) goto L73;
        r35.addView((View) ((BaseHybridComponentContainer) r34).d);
    L73:
        xy0.a r36 = r34.g();
        if (r36 == null) goto L156;
        r36.load(null, null);
        return;
    L156:
        return;
    L155:
        return;
    L67:
        r33 = null;
    L57:
        r23 = "0";
    L49:
        r25 = "0";
    L41:
        r21 = null;
        goto L42
    L29:
        r16 = 0;
    L31:
        r17 = null;
        goto L32
    L19:
        r10 = null;
        goto L20
    L15:
        r4 = null;
        goto L16
    L154:
        return;
    L76:
        ConstraintLayout r37 = this.y;
        if (r37 == null) goto L79;
        r37.setVisibility(0);
    L79:
        List<String> r38 = this.t.b();
        com.bytedance.android.live.profit.fansclub.o r39 = this.u;
        if (r39 == null) goto L88;
        com.bytedance.live.datacontext.m r40 = r39.getProfile();
        if (r40 == null) goto L88;
        com.bytedance.android.live.profit.fansclub.g r41 = (com.bytedance.android.live.profit.fansclub.g) r40.getValue();
        if (r41 == null) goto L88;
        com.bytedance.android.live.profit.fansclub.b r43 = r41.a;
        if (r43 == null) goto L88;
        int r44 = r43.b;
    L89:
        if (1 > r44) goto L95;
        if (10 < r44) goto L95;
        String r45 = (String) CollectionsKt.getOrNull(r38, 0);
    L107:
        com.bytedance.android.live.profit.fansclub.o r46 = this.u;
        if (r46 != null) goto L110;
    L135:
        RelativeLayout r47 = this.o;
        if (r47 == null) goto L138;
        r47.setVisibility(8);
    L138:
        DataCenter r48 = this.z;
        if (r48 == null) goto L141;
        IRoom r49 = (IRoom) r48.get("data_room", null);
    L142:
        if (r49 == null) goto L144;
        IBaseUser r50 = r49.getOwner();
    L146:
        if (com.bytedance.android.live.revenue.common.e0.a() == false) goto L148;
        String r51 = s1.B(2131917130);
    L149:
        t(r51, s1.B(2131917127), null);
        HSImageView r53 = this.m;
        if (r50 == null) goto L152;
        r2 = r50.getAvatarThumbKt();
    L152:
        a1.v(r53, r2, 2131251889);
        return;
    L148:
        r51 = s1.B(2131917129);
        goto L149
    L144:
        r50 = null;
        goto L146
    L141:
        r49 = null;
        goto L142
    L110:
        if (r46.R2() != FansClubUserStatus.Inactive.getValue()) goto L135;
        if (this.t.a() == false) goto L135;
        if (by0.b.a(r45) == false) goto L135;
        RelativeLayout r54 = this.o;
        if (r54 == null) goto L118;
        r54.setVisibility(0);
    L118:
        ImageView r55 = this.n;
        if (r55 == null) goto L121;
        r55.setVisibility(4);
    L121:
        HSImageView r56 = this.m;
        if (r56 == null) goto L124;
        r56.setVisibility(4);
    L124:
        t(r45, this.t.e(), 2131253184);
        com.bytedance.android.live.profit.fansclub.o r57 = this.u;
        if (r57 == null) goto L158;
        Observable r58 = r57.r1();
        if (r58 == null) goto L159;
        Observable r59 = r58.subscribeOn(Schedulers.io());
        if (r59 == null) goto L160;
        Observable r60 = RxUtilKt.h(r59);
        if (r60 == null) goto L161;
        Disposable r61 = r60.subscribe(new y(this));
        if (r61 == null) goto L162;
        RxUtilKt.c(r61, this.v);
        return;
    L162:
        return;
    L161:
        return;
    L160:
        return;
    L159:
        return;
    L158:
        return;
    L95:
        if (11 > r44) goto L101;
        if (15 < r44) goto L101;
        r45 = (String) CollectionsKt.getOrNull(r38, 1);
    L101:
        if (16 <= r44) goto L104;
    L106:
        r45 = null;
        goto L107
    L104:
        if (20 < r44) goto L106;
        r45 = (String) CollectionsKt.getOrNull(r38, 2);
    L88:
        r44 = 0;
        goto L89
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIFanClubTopView$bindToParent$1 r0 = GiftMVIFanClubTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter((GiftTopEmptyState) r3, "state");
    }

    public GiftMVIFanClubTopView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.z = r4;
        this.t = (com.bytedance.android.livesdk.gift.configmodel.r) nz1.a.p.getValue(null, nz1.a.a[14]);
        this.u = yt0.c.c();
        this.v = new CompositeDisposable();
    }

    public final void t(String r2, String r3, Integer r4) {
        if (r2 == null) goto L6;
        TextView r0 = this.s;
        if (r0 == null) goto L6;
        r0.setText(r2);
    L6:
        if (r3 == null) goto L10;
        TextView r5 = this.r;
        if (r5 == null) goto L10;
        r5.setText(r3);
    L10:
        if (r4 == null) goto L31;
        r4.intValue();
        ImageView r6 = this.p;
        if (r6 == null) goto L14;
        r6.setImageResource(r4.intValue());
    L14:
        TextView r7 = this.q;
        if (r7 == null) goto L27;
        com.bytedance.android.live.profit.fansclub.o r8 = this.u;
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.m r9 = r8.getProfile();
        if (r9 == null) goto L25;
        com.bytedance.android.live.profit.fansclub.g r10 = (com.bytedance.android.live.profit.fansclub.g) r9.getValue();
        if (r10 == null) goto L25;
        com.bytedance.android.live.profit.fansclub.b r11 = r10.a;
        if (r11 == null) goto L25;
        int r13 = r11.b;
    L26:
        r7.setText(String.valueOf(r13));
    L25:
        r13 = 0;
    L27:
        TextView r14 = this.r;
        if (r14 == null) goto L32;
        r14.setTextColor(s1.h(2131107447));
        return;
    L32:
        return;
    }
}
