package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.g0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.n;
import com.bytedance.android.live.profit.fansclub.r;
import com.bytedance.android.live.profit.fansclub.s;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.android.live.revenue.common.s0;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import j40.k0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements o {
    public DataCenter a;
    public Context b;
    public final CompositeDisposable c;
    public boolean d;
    public final boolean e;
    public final com.bytedance.android.live.revenue.core.a f;
    public final yz0.k g;
    public final com.bytedance.android.livesdk.revenue.service.room.c h;

    public final void onStart() {
    }

    public final boolean A() {
        if (((Boolean) k0.a.getValue()).booleanValue() == false) goto L14;
        String r0 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (TextUtils.equals(r0, f()) == true) goto L10;
    L12:
        return false;
    L10:
        if (TextUtils.isEmpty(f()) == true) goto L12;
        return true;
    L14:
        return this.g.isAnchor();
    }

    public final Context getContext() {
        Context r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }

    public final IRoom getRoom() {
        return this.g.getRoom();
    }

    public final com.bytedance.android.live.profit.fansclub.b i() {
        com.bytedance.android.live.profit.fansclub.o r0 = yt0.d.a(this.f).a();
        if (r0 == null) goto L9;
        m<? extends com.bytedance.android.live.profit.fansclub.g> r1 = r0.getProfile();
        if (r1 == null) goto L9;
        com.bytedance.android.live.profit.fansclub.g r2 = (com.bytedance.android.live.profit.fansclub.g) r1.getValue();
        if (r2 == null) goto L9;
        return r2.a;
    L9:
        return null;
    }

    public final com.bytedance.android.livesdk.revenue.service.user.a n() {
        return vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
    }

    public final void onStop() {
        this.c.clear();
    }

    public final com.bytedance.android.live.profit.vip.h q() {
        com.bytedance.android.live.profit.vip.e r0 = yt0.d.a(this.f).b();
        if (r0 == null) goto L7;
        m<? extends com.bytedance.android.live.profit.vip.h> r1 = r0.getSubscribeInfo();
        if (r1 == null) goto L7;
        return (com.bytedance.android.live.profit.vip.h) r1.getValue();
    L7:
        return null;
    }

    public final boolean w() {
        com.bytedance.android.live.profit.fansclub.o r0 = yt0.d.a(this.f).a();
        if (r0 == null) goto L7;
        m<? extends r> r1 = r0.getShopFansClubData();
        if (r1 == null) goto L7;
        r r2 = (r) r1.getValue();
    L8:
        if (r2 == null) goto L14;
        s r3 = r2.userData;
        if (r3 == null) goto L14;
        if (r3.joinStatus != true) goto L14;
        return true;
    L14:
        return false;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean x() {
        if (this.e == false) goto L5;
    L21:
        return false;
    L5:
        if (getRoom().isMergeVSRoom() == true) goto L21;
        if (A() == false) goto L12;
        Boolean r0 = (Boolean) ((Map) wt0.c.c.getValue(null, wt0.c.a[1])).get(f());
        if (r0 == null) goto L21;
        return r0.booleanValue();
    L12:
        IBaseUser r1 = getRoom().getOwner();
        if (r1 == null) goto L17;
        g0 r2 = r1.getSubscribe();
        if (r2 == null) goto L17;
        long r3 = r2.getOpen();
    L19:
        if (r3 != 1) goto L21;
        return true;
    L17:
        r3 = 0;
        goto L19
    }

    public final boolean E() {
        if (x() == true) goto L6;
        return false;
    L6:
        if (F() == false) goto L8;
        boolean r0 = w();
    L15:
        if (c() == true) goto L17;
        if (r0 == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        com.bytedance.android.live.profit.fansclub.o r1 = yt0.d.a(this.f).a();
        if (r1 != null) goto L11;
    L13:
        r0 = false;
        goto L15
    L11:
        if (r1.isMember() != true) goto L13;
        r0 = true;
        goto L15
    }

    public final boolean F() {
        IRoomAuthStatus r0 = getRoom().getRoomAuthStatus();
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.getEcomFansClubAuth());
    L7:
        if (((int) r1.longValue()) != 1) goto L13;
        boolean r2 = com.bytedance.android.live.revenue.core.util.h.a;
        if (((n) com.bytedance.android.live.revenue.core.util.h.d(n.class)).enableEcomFansClubReverse() == true) goto L13;
        if (getRoom().isMergeVSRoom() == true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean I() {
        if (A() == false) goto L6;
        return true;
    L6:
        return vh6.c.b(br2.a.class).Tg(getRoom().getOwner(), getRoom());
    }

    public final boolean K() {
        if (x() == true) goto L5;
    L7:
        return false;
    L5:
        if (E() == true) goto L7;
        return true;
    }

    public final boolean L() {
        if (getRoom().isMergeVSRoom() == false) goto L15;
        com.bytedance.android.live.profit.fansclub.o r0 = yt0.d.a(this.f).a();
        if (r0 == null) goto L11;
        m<? extends Integer> r1 = r0.getScene();
        if (r1 == null) goto L11;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L11;
        int r3 = r2.intValue();
    L13:
        if (r3 != 2) goto L15;
        return true;
    L11:
        r3 = 1;
    L15:
        return false;
    }

    public final boolean N() {
        com.bytedance.android.live.profit.vip.h r0 = q();
        if (r0 == null) goto L5;
        int r1 = r0.k;
    L6:
        if (r1 != 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = 0;
        goto L6
    }

    public final boolean c() {
        IRoom r0 = getRoom();
        Intrinsics.checkNotNullParameter(r0, "$this$allowFansClub");
        if (r0.getRoomAuthStatus() == null) goto L8;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        Intrinsics.checkNotNull(r1);
        if (r1.enableFansClub() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final boolean d() {
        if (A() == false) goto L5;
        return false;
    L5:
        u0 r0 = u0.f;
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = com.bytedance.android.live.profit.fansclub.f.c;
        KProperty[] r2 = com.bytedance.android.live.profit.fansclub.f.a;
        if (s0.c(new u0(((Number) r1.getValue(null, r2[1])).longValue())) == true) goto L9;
        long r8 = t0.b().a;
        r1.setValue(null, r2[1], Long.valueOf(r8));
        ArrayList r3 = new ArrayList();
        r3.add(f());
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        com.bytedance.android.live.profit.fansclub.f.d.setValue(null, r2[2], r3);
        return true;
    L9:
        com.bytedance.tools.kcp.spongepreference.runtime.a r4 = com.bytedance.android.live.profit.fansclub.f.d;
        List r5 = (List) r4.getValue(null, r2[2]);
        if (r5.size() < 3) goto L12;
        return false;
    L12:
        if (r5.contains(f()) == true) goto L17;
        r5.add(f());
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.setValue(null, r2[2], r5);
        return true;
    L17:
        return false;
    }

    public final String f() {
        IBaseUser r0 = getRoom().getOwner();
        if (r0 == null) goto L6;
        String r1 = r0.getIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final com.bytedance.android.live.base.model.user.j g() {
        IBaseUser r0 = getRoom().getOwner();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCommonVipInfo();
    }

    public final long h() {
        com.bytedance.android.live.base.model.user.j r0 = g();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getType();
    }

    public final com.bytedance.android.live.profit.fansclub.j j() {
        com.bytedance.android.live.profit.fansclub.b r0 = i();
        if (r0 == null) goto L7;
        com.bytedance.android.live.profit.fansclub.j r1 = r0.c;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new com.bytedance.android.live.profit.fansclub.j(0);
    }

    public final long k() {
        return getRoom().getId();
    }

    public final long o() {
        com.bytedance.android.live.profit.vip.h r0 = q();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.j;
    }

    public final int s() {
        com.bytedance.android.live.profit.vip.h r0 = q();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d;
    }

    public static final /* synthetic */ DataCenter a(i r1) {
        DataCenter r2 = r1.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r2;
    }

    public final void y(Context r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.b = r4;
        this.a = r5;
        com.bytedance.android.live.profit.fansclub.o r6 = yt0.d.a(this.f).a();
        if (r6 == null) goto L5;
        RxUtilKt.c(r6.getProfile().a().subscribe(new a(this)), this.c);
        RxUtilKt.c(r6.getShopFansClubData().a().subscribe(new b(this)), this.c);
    L5:
        com.bytedance.android.live.profit.vip.e r7 = yt0.d.a(this.f).b();
        if (r7 == null) goto L8;
        RxUtilKt.c(r7.getSubscribeInfo().a().subscribe(new c(this)), this.c);
    L8:
        RxUtilKt.c(n().followStateChanged().filter(new d(this)).subscribe(new e(this)), this.c);
        RxUtilKt.c(n().m().subscribe(new f(this)), this.c);
        if (((Boolean) com.bytedance.android.live.profit.fansclub.i.g.getValue(null, com.bytedance.android.live.profit.fansclub.i.a[5])).booleanValue() == false) goto L17;
        com.bytedance.live.datacontext.n r8 = this.h.getRoomContext().getInteractionDataPrepared();
        EntranceDataSource$subscribeEvent$6 r0 = new EntranceDataSource$subscribeEvent$6(this);
        IRoom r1 = (IRoom) r8.getValue();
        if (r1 == null) goto L13;
        r0.invoke(r1);
        goto L17
    L13:
        Disposable r9 = RxUtilKt.h(r8.a()).subscribe(new g(r0));
        if (r9 == null) goto L17;
        RxUtilKt.c(r9, this.c);
    L17:
        if (g() == null) goto L25;
        l r10 = (l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), l.class);
        if (r10 == null) goto L25;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r12 = yz0.h.a.a(r10, com.bytedance.android.live.revenue.common.message.b.O, false, 6);
        if (r12 == null) goto L25;
        Disposable r13 = r12.subscribe(new h(this));
        if (r13 == null) goto L25;
        RxUtilKt.c(r13, this.c);
    L25:
        EntranceMVIFacade r14 = fu0.b.b(r5);
        if (r14 == null) goto L29;
        r14.a(new eu0.k(r5));
        return;
    }

    public i(com.bytedance.android.live.revenue.core.a r2, yz0.k r3, com.bytedance.android.livesdk.revenue.service.room.c r4) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "revRoomService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.c = new CompositeDisposable();
        this.e = true;
    }

    public final void J(IBaseUser r2, String r3, boolean r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (A() == false) goto L5;
        r5.invoke(Boolean.TRUE);
        return;
    L5:
        vh6.c.b(br2.a.class).Cc(r2, r3, getRoom(), r5);
    }
}
