package com.bytedance.android.live.revlink.impl.service;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.RevStreamLayoutBizManager;
import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.service.RevLinkPreloadService;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kc0.m;
import kc0.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements p11.e, m {
    public final HashMap<p11.f, a> a;

    public final d b() {
        return new d();
    }

    public final k31.e c() {
        return new k31.e();
    }

    public final RevLinkPreloadService e() {
        return new RevLinkPreloadService();
    }

    public final int g() {
        y11.a r0 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).Yk();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.g();
    }

    @Override // p11.e
    public final o21.b p() {
        return new o21.b();
    }

    public e() {
        this.a = new HashMap();
    }

    public final boolean blockDigg() {
        if (com.bytedance.android.live.revlink.impl.global.b.w() == null) goto L15;
        p21.b r0 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.a(7) == false) goto L11;
        y41.d r1 = y41.d.j;
        r1.getClass();
        if (((Boolean) y41.d.g.getValue(r1, y41.d.a[5])).booleanValue() == false) goto L11;
        boolean r2 = true;
    L12:
        if (r2 != true) goto L17;
        return true;
    L17:
        return false;
    L11:
        r2 = false;
        goto L12
    L15:
        return false;
    }

    public final int currentRoomLayoutType() {
        w r0 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r0 == null) goto L6;
        UILayout r1 = r0.b();
        if (r1 == null) goto L6;
    L8:
        return r1.ordinal();
    L6:
        r1 = UILayout.Normal;
        goto L8
    }

    public final List<k> d() {
        i11.b r0 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    @Override // p11.e
    public final boolean h() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L33;
        int r2 = com.bytedance.android.live.utils.c.a;
        com.bytedance.android.live.revlink.impl.global.c r1 = r0.c;
        q11.b r3 = null;
        if (r1 == null) goto L7;
        com.bytedance.android.live.revlink.impl.service.internal.a r4 = r1.Do();
    L8:
        if (r4 == null) goto L10;
        int r5 = r4.getCurrentMode();
    L12:
        if (com.bytedance.android.live.utils.c.a(r5, 64) != true) goto L33;
        d51.c r6 = d51.c.A0;
        r6.getClass();
        if (((Boolean) d51.c.L.getValue(r6, d51.c.a[36])).booleanValue() == false) goto L16;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r7 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r7 == null) goto L25;
        PkBaseStateMachine.c r8 = r7.getCurPKBaseState();
        if (r8 == null) goto L25;
        if (com.bytedance.android.live.revlink.impl.global.b.r() == null) goto L25;
        r3 = d21.d.f(r8);
    L25:
        if (Intrinsics.areEqual(r3, q11.b.d.b) == true) goto L32;
        if (Intrinsics.areEqual(r3, q11.b.c.b) == true) goto L32;
        return l51.a.e();
    L32:
        return l51.a.r();
    L16:
        return l51.a.e();
    L10:
        r5 = 0;
        goto L12
    L7:
        r4 = null;
    L33:
        return false;
    }

    public final n i() {
        b0 r0 = com.bytedance.android.live.revlink.impl.global.b.L();
        n r1 = null;
        if (r0 == null) goto L10;
        n r2 = r0.a();
        if ((r2 instanceof n) == false) goto L9;
        r1 = r2;
    L9:
        return r1;
    L10:
        return null;
    }

    public final List<p> j() {
        com.bytedance.android.live.revlink.impl.multianchor.service.d r0 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r0 != null) goto L7;
        return new ArrayList();
    L7:
        return r0.getLinkUserCenter().getOnlineUserList();
    }

    @Override // p11.b
    public final p11.g k() {
        b0 r0 = com.bytedance.android.live.revlink.impl.global.b.L();
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r1 = null;
        if (r0 == null) goto L10;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r2 = r0.a();
        if ((r2 instanceof p11.g) == false) goto L9;
        r1 = r2;
    L9:
        return (p11.g) r1;
    L10:
        return null;
    }

    @Override // p11.b
    public final String q() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTeamModeStr();
    }

    public final boolean a(String r2) {
        y11.a r0 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).Yk();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r2);
    }

    public final void f(Observer<Long> r4) {
        Intrinsics.checkNotNullParameter(r4, "newObserver");
        com.bytedance.android.scope.m r0 = com.bytedance.android.scope.m.e;
        r0.getClass();
        o11.a r1 = r0.a(com.bytedance.android.scope.m.d, o11.a.class);
        if (r1 == null) goto L5;
        MultiPkScopeProviderService r2 = (MultiPkScopeProviderService) r0.d(r1, MultiPkScopeProviderService.class);
    L6:
        if (r2 == null) goto L11;
        MutableLiveData<Long> r3 = r2.c;
        if (r3 == null) goto L12;
        r3.removeObserver(r4);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // p11.b
    public final void l(GiftReceiverRepoService.g r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (this.a.containsKey(r3) == false) goto L5;
        return;
    L5:
        a r0 = new a(new c(r3));
        i11.b r1 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r1 != null) goto L8;
        return;
    L8:
        r1.i(r0);
        this.a.put(r3, r0);
    }

    public final StreamLayoutManager m(final Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "requestLayout");
        return new StreamLayoutManager(new MultiAnchorOutServiceImp$createRevStreamLayoutManager$1(r3));
    }

    @Override // p11.b
    public final boolean n(IRoom r3) {
        ProfitInteractionDataContext r0 = com.bytedance.android.live.revlink.impl.global.b.X();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.canShowScore() == false) goto L32;
        if (r3 != null) goto L9;
    L11:
        PkBaseStateMachine.c r1 = null;
        q11.b r2 = null;
        if (y.d() == false) goto L19;
        q r4 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r4 == null) goto L17;
        r2 = r4.a();
    L17:
        return r2 instanceof q11.b.C0295b;
    L19:
        if (y.c() == false) goto L30;
        b0 r5 = com.bytedance.android.live.revlink.impl.global.b.L();
        if (r5 == null) goto L24;
        r1 = r5.e();
    L24:
        if (r1 != null) goto L26;
    L27:
        return true;
    L26:
        if (r1.a() != true) goto L27;
        return false;
    L30:
        return false;
    L9:
        if (r3.isLiveTypeAudio() == false) goto L11;
        return false;
    L32:
        return false;
    }

    @Override // p11.b
    public final void o(GiftReceiverRepoService.g r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (this.a.containsKey(r3) == true) goto L5;
        return;
    L5:
        a r0 = this.a.get(r3);
        this.a.remove(r3);
        com.bytedance.android.live.revlink.impl.multianchor.service.d r4 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r4 == null) goto L11;
        i11.b r5 = r4.getLinkUserCenter();
        if (r5 == null) goto L12;
        r5.l(r0);
        return;
    L12:
        return;
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.transfer.c r(DataCenter r3) {
        return new com.bytedance.android.live.revlink.impl.multianchor.transfer.c(r3, Boolean.FALSE);
    }

    public final RevStreamLayoutBizManager s(DataCenter r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r3, "playerViewProducer");
        if (r2 == null) goto L8;
        IRoom r4 = a0.n(r2);
        if (r4 == null) goto L8;
        r4.getId();
    L8:
        return new RevStreamLayoutBizManager(r3);
    }
}
