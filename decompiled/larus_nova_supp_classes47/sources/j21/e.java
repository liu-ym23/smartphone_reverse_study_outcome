package j21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.vm.LinkingInvitePreloadUtils;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements c {
    public Integer a;
    public final j b;
    public final g c;
    public List<? extends p> d;
    public List<? extends p> e;
    public List<? extends IBaseUser> f;
    public IRivalRankRecommendResponse g;
    public b h;
    public final CompositeDisposable i;
    public final com.bytedance.android.live.revlink.impl.global.c j;

    public static final class a implements j21.a {
        public final /* synthetic */ e a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        @Override // j21.a
        public final void a(IRivalRankRecommendResponse r10) {
            Intrinsics.checkNotNullParameter(r10, "resp");
            e r1 = this.a;
            r1.g = r10;
            b r2 = r1.h;
            if (r2 == null) goto L11;
            List<? extends p> r3 = r1.d;
            if (r3 != null) goto L7;
            r3 = CollectionsKt.emptyList();
        L7:
            List<? extends p> r4 = r3;
            List<? extends p> r5 = this.a.e;
            if (r5 != null) goto L10;
            r5 = CollectionsKt.emptyList();
        L10:
            List<? extends p> r6 = r5;
            e r7 = this.a;
            r2.onPageRecsFetch(r4, r6, r7.f, r7.g, this.b);
        L11:
            com.bytedance.android.live.revlink.impl.multianchor.vm.f r8 = com.bytedance.android.live.revlink.impl.global.b.p();
            if (r8 != null) goto L14;
            return;
        L14:
            if (r8.b() == true) goto L16;
            return;
        L16:
            if (this.c == 4) goto L23;
            this.a.getClass();
            LinkingInvitePreloadUtils r9 = e.d();
            if (r9 == null) goto L24;
            int r12 = this.c;
            long r13 = this.d;
            Intrinsics.checkNotNullParameter(r10, "resp");
            i97.a r14 = i97.a.a;
            r9.f = new com.bytedance.android.live.revlink.impl.multianchor.vm.h(r10, r12, r13, System.currentTimeMillis());
            return;
        L24:
            return;
        }

        public a(e r1, boolean r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static LinkingInvitePreloadUtils d() {
        com.bytedance.android.live.revlink.impl.multianchor.vm.f r0 = com.bytedance.android.live.revlink.impl.global.b.p();
        if (r0 == null) goto L13;
        com.bytedance.android.live.revlink.impl.global.c r1 = r0.a;
        if (r1 == null) goto L7;
        MultiAnchorPkLaunchContext r2 = r1.Ib();
    L8:
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.j<LinkingInvitePreloadUtils> r3 = r2.getLinkingInvitePreloadUtils();
        if (r3 != null) goto L12;
        return null;
    L12:
        return (LinkingInvitePreloadUtils) r3.getValue();
    L14:
        return null;
    L7:
        r2 = null;
        goto L8
    L13:
        return null;
    }

    public e(com.bytedance.android.live.revlink.impl.global.c r2) {
        this.j = r2;
        this.b = new j();
        this.c = new g(r2);
        this.f = CollectionsKt.emptyList();
        this.i = new CompositeDisposable();
    }

    @Override // j21.c
    public final void b(List<? extends IBaseUser> r2) {
        this.f = r2;
        b r0 = this.h;
        if (r0 == null) goto L6;
        r0.onInviteeOrApplicantListChanged(r2);
        return;
    }

    public final void c(boolean r14) {
        Integer r0 = this.a;
        if (r0 == null) goto L6;
        int r1 = r0.intValue();
    L9:
        long r5 = System.currentTimeMillis();
        g r8 = this.c;
        a r9 = new a(this, r14, r1, r5);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "callback");
        Disposable r10 = null;
        jy0.b.f("ttlive_anchor_link_panel", "fetchRecommendList tabType=" + r1 + " recommendType=3", null, 4);
        Disposable r15 = r8.a;
        if (r15 == null) goto L12;
        r15.dispose();
        r8.a = null;
    L12:
        i97.a r16 = i97.a.a;
        long r12 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r17 = r8.b;
        if (r17 == null) goto L15;
        r31.a r2 = r17.getLinkNetwork();
    L16:
        if (r2 == null) goto L24;
        Observable r18 = r2.c(3, false, r1, "", 3, IRivalRankRecommendResponse.LoadType.All.ordinal());
        if (r18 == null) goto L24;
        int r3 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r19 = r18.subscribeOn(Schedulers.io());
        if (r19 == null) goto L24;
        Observable r110 = r19.observeOn(AndroidSchedulers.mainThread());
        if (r110 == null) goto L24;
        r10 = r110.subscribe(new h(r8, r1, r12, r9), new i(r8, r1, r12));
    L24:
        r8.a = r10;
        return;
    L15:
        r2 = null;
        goto L16
    L6:
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L8;
        r1 = 3;
        goto L9
    L8:
        r1 = 6;
        goto L9
    }

    public final void e(IRivalRankRecommendResponse r7) {
        this.g = r7;
        b r0 = this.h;
        if (r0 == null) goto L11;
        List<? extends p> r8 = this.d;
        if (r8 != null) goto L7;
        r8 = CollectionsKt.emptyList();
    L7:
        List<? extends p> r1 = r8;
        List<? extends p> r9 = this.e;
        if (r9 != null) goto L10;
        r9 = CollectionsKt.emptyList();
    L10:
        r0.onPageRecsFetch(r1, r9, this.f, this.g, false);
    L11:
        LinkingInvitePreloadUtils r10 = d();
        if (r10 == null) goto L15;
        r10.b("cacheConsumed");
        return;
    }

    @Override // j21.c
    public final void a(List r7, List r8, List r9) {
        Intrinsics.checkNotNullParameter(r7, "anchorList");
        Intrinsics.checkNotNullParameter(r8, "waitingList");
        AnchorLinkOptUtils r3 = null;
        jy0.b.f("ttlive_anchor_link_panel", "onUserStatusFetch anchorList size=" + ((ArrayList) r7).size(), null, 4);
        this.d = r7;
        this.e = r8;
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        this.f = r9;
        com.bytedance.android.live.revlink.impl.global.c r10 = this.j;
        if (r10 == null) goto L8;
        r3 = r10.vk();
    L8:
        if (r3 != null) goto L10;
    L11:
        c(false);
    L12:
        b r0 = this.h;
        if (r0 == null) goto L22;
        List<? extends p> r12 = this.d;
        if (r12 != null) goto L17;
        r12 = CollectionsKt.emptyList();
    L17:
        List<? extends p> r1 = r12;
        List<? extends p> r13 = this.e;
        if (r13 != null) goto L20;
        r13 = CollectionsKt.emptyList();
    L20:
        r0.onPageUpdate(r1, r13, this.f, this.g, false);
        return;
    L22:
        return;
    L10:
        if (r3.d() == true) goto L12;
        goto L11
    }
}
