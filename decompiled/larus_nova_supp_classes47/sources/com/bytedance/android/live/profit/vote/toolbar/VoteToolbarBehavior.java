package com.bytedance.android.live.profit.vote.toolbar;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.profit.vote.i;
import com.bytedance.android.live.profit.vote.l;
import com.bytedance.android.live.profit.vote.model.f;
import com.bytedance.android.live.profit.vote.transfer.c;
import com.bytedance.android.live.profit.vote.ui.VotePanelHandler;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.revenue.room.RevRoomPermission;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.livesdk.revenue.service.room.b;
import com.bytedance.android.livesdk.revenue.service.toolbar.e;
import com.bytedance.android.livesdk.revenue.toolbar.RevRedDot;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import cy0.j;
import dq2.m;
import dq2.s;
import dq2.v;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zr2.g;
import zr2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VoteToolbarBehavior extends k implements o {
    public Disposable b;
    public u0 c;
    public DataCenter d;
    public final c e;
    public final f f;
    public final VotePanelHandler g;
    public final yz0.k h;
    public final er2.a i;

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void onStart() {
        vh6.c.b(e.class).tg(this.h.getDataCenter()).e(RevToolbarButton.Vote, this);
    }

    public final void onStop() {
        vh6.c.b(e.class).tg(this.h.getDataCenter()).c(RevToolbarButton.Vote, this);
        this.b.dispose();
    }

    public final boolean showRedDot() {
        if (vh6.c.b(d.class).Z4() == false) goto L5;
        return false;
    L5:
        int r0 = a.a;
        if (this.i.q() == true) goto L8;
        return false;
    L8:
        if (((Boolean) i.b.getValue(null, i.a[0])).booleanValue() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public final RevRedDot h7() {
        return RevRedDot.AudienceRoomMoreVote;
    }

    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if (t0.a(new AnonymousClass1(this), new u0(500)) == true) goto L5;
        return;
    L5:
        this.b.dispose();
        int r7 = a.a;
        if (this.i.q() == true) goto L8;
    L10:
        boolean r8 = false;
    L11:
        if (r8 == false) goto L14;
        i.b.setValue(null, i.a[0], Boolean.TRUE);
        vh6.c.b(e.class).b9(this.h.getDataCenter()).a(RevToolbarButton.InteractGame, g.a);
    L14:
        if (((Boolean) l.c.getValue(null, l.a[1])).booleanValue() == true) goto L16;
    L19:
        d r9 = vh6.c.b(d.class);
        if (r9.getCurrentScene() != 10) goto L23;
        ToastUtil.a(2131911884, 0);
        return;
    L23:
        m r3 = r9.ig();
        if (r3 != null) goto L26;
    L29:
        dq2.i r4 = r9.getAdventureService();
        if (r4 != null) goto L32;
    L35:
        v r5 = r9.Ag();
        if (r5 != null) goto L38;
    L41:
        s r10 = r9.T9();
        if (r10 != null) goto L44;
    L47:
        b r12 = vh6.c.b(b.class);
        if (this.h.isAnchor() == false) goto L50;
    L55:
        com.bytedance.android.live.profit.vote.model.c r13 = (com.bytedance.android.live.profit.vote.model.c) PropertyOwnersKt.a(this.f.a);
        if (r13 != null) goto L58;
    L63:
        c r14 = this.e;
        r14.getClass();
        Intrinsics.checkNotNullParameter("click", "requestSource");
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r2 = com.bytedance.android.scope.m.b(r1).a(Reflection.getOrCreateKotlinClass(jy0.a.class));
        Intrinsics.checkNotNull(r2);
        ((jy0.a) ((f80.a) r2)).k("VoteApiClient", "getCurrentVoteType click");
        com.bytedance.android.live.profit.vote.transfer.b r15 = com.bytedance.android.live.profit.vote.transfer.b.c;
        long r16 = IRoomKtKt.getId(r14.a.mo444getRoom());
        r15.getClass();
        this.b = RxUtilKt.o(com.bytedance.android.live.profit.vote.transfer.b.a(r16, "click").map(com.bytedance.android.live.profit.vote.transfer.f.a).singleOrError(), new AnonymousClass2(this));
        return;
    L58:
        if (com.bytedance.android.live.profit.vote.d.a(r13) != true) goto L63;
        if (VoteUtilsKt.h(r13) == false) goto L62;
        VotePanelHandler r17 = this.g;
        int r0 = VotePanelHandler.f;
        r17.a(null);
        return;
    L62:
        ToastUtil.a(2131923228, 0);
        return;
    L50:
        if (r12.Tm() == false) goto L55;
        if (r12.Vm(this.d, RevRoomPermission.GiftVote) == true) goto L55;
        ToastUtil.a(2131922923, 0);
        return;
    L44:
        if (r10.b() != true) goto L47;
        int r18 = ToastUtil.a;
        ToastUtil.b(s1.C(2131918748, new Object[]{s1.B(2131918883)}), 0);
        return;
    L38:
        if (r5.e() != true) goto L41;
        int r19 = ToastUtil.a;
        ToastUtil.b(s1.C(2131922782, new Object[]{s1.B(2131918883)}), 0);
        return;
    L32:
        if (r4.a() != true) goto L35;
        ToastUtil.a(2131919161, 0);
        return;
    L26:
        if (r3.c() != true) goto L29;
        ToastUtil.a(2131919162, 0);
        return;
    L16:
        if (this.h.getRoom().getRoomAuthStatus().getEnableGift() == true) goto L19;
        ToastUtil.b("本场直播不支持送礼", 0);
        return;
    L8:
        if (((Boolean) i.b.getValue(null, i.a[0])).booleanValue() == true) goto L10;
        r8 = true;
        goto L11
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.d = r3;
    }

    public VoteToolbarBehavior(c r2, f r3, VotePanelHandler r4, yz0.k r5, er2.a r6) {
        Intrinsics.checkNotNullParameter(r2, "apiClient");
        Intrinsics.checkNotNullParameter(r3, "repo");
        Intrinsics.checkNotNullParameter(r4, "panelHandler");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        Intrinsics.checkNotNullParameter(r6, "ktvRoomService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.b = Disposables.disposed();
        this.c = u0.f;
    }
}
