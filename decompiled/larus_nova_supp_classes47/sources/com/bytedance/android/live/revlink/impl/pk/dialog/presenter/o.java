package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.g2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x31.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o extends x31.p {
    public int d;
    public long e;
    public final Lazy f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public int k;
    public Disposable l;
    public final com.bytedance.android.live.revenuelink.connect.f m;
    public final p n;
    public boolean o;
    public Disposable p;
    public final String q;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ o a;
        public final /* synthetic */ int b;

        public b(o r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            ExtraResponse r9 = (ExtraResponse) r8;
            o r0 = this.a;
            if (r9 == null) goto L7;
            g2 r1 = (g2) r9.data;
            if (r1 == null) goto L7;
            String r2 = r1.getNoRecordTip();
        L8:
            boolean r3 = false;
            if (r2 != null) goto L11;
        L14:
            boolean r4 = true;
        L15:
            r0.i = r4;
            o r5 = this.a;
            if (r9 == null) goto L22;
            g2 r6 = (g2) r9.data;
            if (r6 == null) goto L22;
            Long r7 = r6.getOffset();
            if (r7 == null) goto L22;
            long r10 = r7.longValue();
        L23:
            r5.e = r10;
            o r12 = this.a;
            r12.g = this.b;
            if (r12.h == 0) goto L26;
            r3 = true;
        L26:
            if (r3 == false) goto L30;
            long r13 = r12.e;
            if (r13 < 0) goto L30;
            r12.d = (int) r13;
        L31:
            if (r9 == null) goto L48;
            g2 r14 = (g2) r9.data;
            if (r14 == null) goto L48;
            List r15 = r14.getBattleRecordList();
            if (r15 == null) goto L48;
            Iterator<T> r16 = r15.iterator();
        L38:
            if (r16.hasNext() == false) goto L48;
            f2 r17 = (f2) r16.next();
            if (r17 == null) goto L38;
            IBattleUserInfo r18 = r17.getBattleUserInfo();
            if (r18 == null) goto L38;
            k0 r19 = r18.getUserInfo();
            if (r19 == null) goto L38;
            String r20 = r19.getUserId();
            if (r20 == null) goto L38;
            ConcurrentHashMap r22 = (ConcurrentHashMap) this.a.f.getValue();
            Intrinsics.checkNotNullParameter(r17, "$this$toBanSecondData");
            r22.put(r20, new u(r17.getFollowType(), r17.getIncreaseOrDecreaseInvite(), r17.getInviteRejectPermanent()));
        L48:
            o r23 = this.a;
            InteractDialogPkRecordContract$View r24 = (InteractDialogPkRecordContract$View) r23.c;
            if (r24 == null) goto L63;
            r24.ea0((g2) r9.data, r23.h);
            return;
        L63:
            return;
        L30:
            r12.d += 20;
        L22:
            r10 = -1;
            goto L23
        L11:
            if (r2.length() == 0) goto L14;
            r4 = false;
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.d(r4);
            o r0 = this.a;
            InteractDialogPkRecordContract$View r1 = (InteractDialogPkRecordContract$View) r0.c;
            if (r1 == null) goto L6;
            r1.da0(r4, r0.h);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function1 b;

        public d(String r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            g2 r5 = (g2) ((ExtraResponse) r4).data;
            if (r5 == null) goto L12;
            List r6 = r5.getBattleRecordList();
            if (r6 == null) goto L18;
            Iterator<T> r7 = r6.iterator();
        L8:
            if (r7.hasNext() == false) goto L19;
            f2 r0 = (f2) r7.next();
            if (Intrinsics.areEqual(r0.getBattleId(), this.a) == false) goto L8;
            this.b.invoke(r0);
            goto L8
        L19:
            return;
        L18:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public final void b() {
        ((com.bytedance.android.livesdk.common.c) this).a = null;
        com.bytedance.android.live.revenuelink.connect.f r0 = this.m;
        if (r0 == null) goto L6;
        r0.removeLinkOutListener(7, this.n);
        return;
    }

    @Override // x31.p
    public final void e() {
        this.o = true;
        k(this.d, false);
    }

    @Override // x31.p
    public final void m() {
        this.d = 0;
        Disposable r1 = this.p;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.i = true;
        this.o = false;
        Disposable r0 = this.l;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        ((ConcurrentHashMap) this.f.getValue()).clear();
    }

    @Override // x31.p
    public final int g() {
        return this.h;
    }

    @Override // x31.p
    public final boolean h() {
        return this.o;
    }

    @Override // x31.p
    public final int i() {
        return this.g;
    }

    public o(InteractDialogPkRecordContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter("", "activityName");
        super(r3);
        this.q = "";
        this.f = LazyKt.lazy(InteractDialogPkRecordPresenter$mPkBanSecondMap$2.INSTANCE);
        this.i = true;
        com.bytedance.android.live.revenuelink.connect.f r4 = com.bytedance.android.live.revlink.impl.global.b.a();
        this.m = r4;
        p r0 = new p(this);
        this.n = r0;
        if (r4 == null) goto L6;
        r4.addLinkOutListener(7, r0);
        return;
    }

    @Override // x31.p
    public final u f(String r2) {
        return (u) ((ConcurrentHashMap) this.f.getValue()).get(r2);
    }

    @Override // x31.p
    public final void n(int r2) {
        if (r2 != (-1)) goto L7;
        this.h = r2;
        return;
    L7:
        if (r2 == this.h) goto L10;
        this.h = r2;
        m();
        k(0, true);
        return;
    }

    @Override // x31.p
    public final void k(int r3, boolean r4) {
        if (r4 == false) goto L5;
        m();
    L5:
        if (this.i == false) goto L14;
        Observable r5 = r31.b.a(r31.a.a).r(r3, this.q, this.h);
        if (r5 == null) goto L11;
        ObservableSubscribeProxy r6 = (ObservableSubscribeProxy) r5.as(c());
        if (r6 == null) goto L11;
        Disposable r7 = r6.subscribe(new b(this, r3), new c(this));
    L12:
        this.l = r7;
        return;
    L11:
        r7 = null;
        goto L12
    }

    @Override // x31.p
    public final void l(Function1<? super f2, Unit> r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "getPkIdInfo");
        Intrinsics.checkNotNullParameter(r5, "battleId");
        Disposable r0 = this.p;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Observable r7 = r31.b.a(r31.a.a).r(r6, this.q, this.h);
        if (r7 == null) goto L10;
        ObservableSubscribeProxy r8 = (ObservableSubscribeProxy) r7.as(c());
        if (r8 == null) goto L10;
        Disposable r9 = r8.subscribe(new d(r5, r4), e.a);
    L11:
        this.p = r9;
        return;
    L10:
        r9 = null;
        goto L11
    }

    @Override // x31.p
    public final void j(int r37, f2 r38, int r39, int r40) {
        Intrinsics.checkNotNullParameter(r38, "battleRecord");
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        this.k = r39;
        v3 r5 = null;
        if (r40 != ILinkMicBattleSetting.BasePlayMode.BattlePlayMode_Season.getType()) goto L8;
        IBattleConfigSetting r4 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r4.setModType(PkBaseDataContext.PKModType.SeasonRank.getType());
        IBattleConfigSetting r13 = r4;
    L9:
        IPKLinkBizDataService r6 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r6 == null) goto L37;
        IRoom r7 = r38.getRivalLivingRoom();
        if (r7 != null) goto L26;
        r7 = (IRoom) vh7.f.c(IRoom.class);
        r7.setId(r38.getRivalLivingRoomId());
        IBaseUser r8 = vh7.f.c(IBaseUser.class);
        String r9 = r38.getRivalSecUserId();
        String r10 = "";
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        com.bytedance.android.live.base.model.user.o.c(r8, r9);
        IBattleUserInfo r12 = r38.getBattleUserInfo();
        if (r12 == null) goto L21;
        k0 r14 = r12.getUserInfo();
        if (r14 == null) goto L21;
        String r15 = r14.getUserId();
    L22:
        if (r15 == null) goto L25;
        r10 = r15;
    L25:
        r8.setIdString(r10);
        Unit r16 = Unit.INSTANCE;
        r7.setBaseOwner(r8);
    L21:
        r15 = null;
    L26:
        long r22 = r38.getRivalLivingRoomId();
        IBattleUserInfo r17 = r38.getBattleUserInfo();
        if (r17 == null) goto L31;
        k0 r18 = r17.getUserInfo();
        if (r18 == null) goto L31;
        String r24 = r18.getUserId();
    L32:
        String r25 = r38.getRivalSecUserId();
        String r19 = this.q;
        String r110 = r38.getBattleAttachedInfo();
        e21.b r28 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r28 == null) goto L35;
        r5 = e21.b.b(r28, new com.bytedance.android.live.revlink.impl.pk.utils.l.i(), null, null, String.valueOf(r39 + 1), null, null, 116);
    L35:
        IPKLinkBizDataService.b.b(r6, r7, r22, r24, r25, 0, r37, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, null, 0, r19, 0, r13, r110, 0, 0, r5, null, null, 6967));
        return;
    L31:
        r24 = null;
        goto L32
    L37:
        return;
    L8:
        r13 = null;
        goto L9
    }
}
