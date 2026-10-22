package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.v;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b implements com.bytedance.android.live.liveinteract.plantform.datamerge.d {
    public boolean a;
    public final BehaviorSubject<List<ch0.e>> b;
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> c;
    public final BehaviorSubject<ch0.m> d;
    public final BehaviorSubject<List<LinkmicPositionItem>> e;
    public final BehaviorSubject<ch0.d> f;
    public final BehaviorSubject<IVoiceLiveTheme> g;
    public final BehaviorSubject<ch0.b> h;
    public final BehaviorSubject<Boolean> i;
    public final BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a> j;
    public final BehaviorSubject<ch0.c> k;
    public final CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> l;
    public final CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> m;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b n;
    public final LifecycleOwner o;
    public final d p;
    public final int q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void A0(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void B0(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void J0(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcTalkingData");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void U0(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcLastTalkingTimeData");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void Y0(ch0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "endEvent");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void Z0(List<ILinkPlayerInfoBridge> r2) {
        Intrinsics.checkNotNullParameter(r2, "leavedPaidUserList");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void c(wg0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "playModeStateItem");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void c1(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void h1(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "seiTalkingData");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void k1(ch0.l r2) {
        Intrinsics.checkNotNullParameter(r2, "voiceAnchorGuideInfo");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void n0(v r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public v s0() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public void y0(ch0.i r2) {
        Intrinsics.checkNotNullParameter(r2, "dynamicData");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void detach() {
        Iterator<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().detach();
        goto L4
    L6:
        this.l.clear();
        this.m.clear();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L9;
        r();
    L9:
        this.a = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final ch0.d l1() {
        Object r0 = this.f.getValue();
        if (r0 == null) goto L7;
        return (ch0.d) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void r() {
        this.b.onNext(CollectionsKt.emptyList());
        this.c.onNext(CollectionsKt.emptyList());
        BehaviorSubject<ch0.m> r0 = this.d;
        int r1 = ch0.m.d;
        r0.onNext(ch0.m.a.a());
        this.e.onNext(CollectionsKt.emptyList());
        BehaviorSubject<ch0.d> r2 = this.f;
        int r3 = ch0.d.e;
        r2.onNext(ch0.d.a.a());
        this.g.onNext(vh7.f.c(IVoiceLiveTheme.class));
        this.h.onNext(new ch0.b(null, false));
        this.i.onNext(Boolean.FALSE);
        this.j.onNext(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(0, 0, 0, 0));
        this.k.onNext(new ch0.c());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<List<ILinkPlayerInfoBridge>> u0() {
        return BehaviorSubject.createDefault(new ArrayList());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<Boolean> F0() {
        return BehaviorSubject.create();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<Boolean> H0() {
        return BehaviorSubject.create();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<ch0.i> I0() {
        return BehaviorSubject.create();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<Map<String, Boolean>> Q0() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<Map<String, Boolean>> S0() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<wg0.a> b() {
        return BehaviorSubject.create();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<ch0.k> e1() {
        return BehaviorSubject.create();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<Boolean> f1() {
        return BehaviorSubject.create();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<Map<String, Boolean>> j1() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<Map<String, Long>> m1() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final ch0.e n1() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L8;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L8;
        String r2 = r1.getOwnerUserIdString();
        if (r2 == null) goto L8;
    L9:
        List r3 = (List) this.b.getValue();
        Object r4 = null;
        if (r3 == null) goto L26;
        Iterator r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L22;
        Object r6 = r5.next();
        IBaseUser r7 = ((ch0.e) r6).a.getUser();
        if (r7 == null) goto L17;
        String r8 = r7.getIdString();
    L19:
        if (Intrinsics.areEqual(r8, r2) == false) goto L13;
        r4 = r6;
        goto L22
    L17:
        r8 = null;
    L22:
        return (ch0.e) r4;
    L26:
        return null;
    L8:
        r2 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public BehaviorSubject<ch0.l> w0() {
        return BehaviorSubject.create();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<IVoiceLiveTheme> G0() {
        return this.g;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> N0() {
        return this.c;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<ch0.m> P0() {
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final d P1() {
        return this.p;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Boolean> V0() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<ch0.d> a1() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<ch0.d> b1() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<List<ch0.e>> f() {
        return this.b;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<List<LinkmicPositionItem>> g() {
        return this.e;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final int getShowFrom() {
        return this.q;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final LifecycleOwner k() {
        return this.o;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<ch0.b> o1() {
        return this.h;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a> p1() {
        return this.j;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<ch0.c> x0() {
        return this.k;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void C0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "seiBaseInfo");
        this.j.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void D0(ch0.m r2) {
        Intrinsics.checkNotNullParameter(r2, "waitingListMergeData");
        q("notifyUpdateWaitingList");
        this.d.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void E0(boolean r2) {
        this.i.onNext(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void L0(IVoiceLiveTheme r2) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        q("notifyUpdateTheme");
        this.g.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void M0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(this, "proxy");
        r2.a = this;
        this.l.add(r2);
        r2.attach();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void O0(ch0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "friendOnlineInfo");
        q("notifyUpdateFriendOnline");
        this.h.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void T0(List<? extends LinkmicPositionItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        q("notityUpdateSpecialStubList");
        this.e.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void W0(ch0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvBusinessMergeData");
        this.k.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final ILinkPlayerInfoBridge X0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        List r0 = (List) this.b.getValue();
        if (r0 == null) goto L19;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        IBaseUser r3 = ((ch0.e) r2).a.getUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
    L12:
        if (Intrinsics.areEqual(r4, r5) == false) goto L6;
    L15:
        ch0.e r6 = (ch0.e) r2;
        if (r6 == null) goto L19;
        return r6.a;
    L10:
        r4 = null;
        goto L12
    L14:
        r2 = null;
    L19:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void a(List<? extends ILinkPlayerInfoBridge> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        q("notifyUpdateServerOnlineUserList");
        this.c.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void d1(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.l.remove(r2);
        r2.detach();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void g1(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        M0(r2);
        this.m.add(r2);
    }

    public final void q(String r7) {
        d r0 = this.p;
        if (r0 == null) goto L5;
        d.a.a(r0, "AbsLinkUserDataMergeCenter", hashCode(), r7, false, 24);
        return;
    L5:
        gh0.a.b(null, r7, 5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void t0(SeiAppData r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b r0 = this.n;
        if (r0 == null) goto L8;
        r0.d(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void v0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r5) {
        Intrinsics.checkNotNullParameter(r5, "updateResult");
        q("notifyUpdateResult, this=" + this + ", hasModified=" + r5.a);
        if (r5.a == false) goto L5;
        this.b.onNext(r5.b);
    L5:
        ch0.e r6 = r5.c;
        if (r6 == null) goto L26;
        Intrinsics.checkNotNullParameter(r6, "selfMergeData");
        ch0.d r0 = (ch0.d) this.f.getValue();
        ch0.d r1 = null;
        if (r0 == null) goto L10;
        r1 = ch0.d.a(r0, r6.a.getLinkStatus(), r6.a.getSilenceStatus(), null, 9);
    L10:
        if (r1 == null) goto L27;
        ch0.d r7 = (ch0.d) this.f.getValue();
        if (r7 == r1) goto L21;
        if (r7 != null) goto L16;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L28;
        this.f.onNext(r1);
        return;
    L28:
        return;
    L16:
        if (r7.b != r1.b) goto L22;
        if (r7.c != r1.c) goto L22;
    L21:
        r8 = true;
        goto L23
    L27:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void z0(ch0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "currentUser");
        q("notifyUpdateLocalUser");
        this.f.onNext(r2);
    }

    public b(LifecycleOwner r1, d r2, int r3) {
        this.o = r1;
        this.p = r2;
        this.q = r3;
        this.b = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.c = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        int r4 = ch0.m.d;
        this.d = BehaviorSubject.createDefault(ch0.m.a.a());
        this.e = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        int r5 = ch0.d.e;
        this.f = BehaviorSubject.createDefault(ch0.d.a.a());
        this.g = BehaviorSubject.createDefault(vh7.f.c(IVoiceLiveTheme.class));
        this.h = BehaviorSubject.createDefault(new ch0.b(null, false));
        this.i = BehaviorSubject.createDefault(Boolean.FALSE);
        this.j = BehaviorSubject.createDefault(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(0, 0, 0, 0));
        this.k = BehaviorSubject.createDefault(new ch0.c());
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
    }
}
