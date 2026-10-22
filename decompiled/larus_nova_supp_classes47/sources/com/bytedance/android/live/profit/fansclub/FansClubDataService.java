package com.bytedance.android.live.profit.fansclub;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult;
import com.bytedance.android.live.profit.fansclub.transfer.FansClubIMDataSource;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.message.model.f7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FansClubDataService implements com.bytedance.android.scope.o {
    public static final /* synthetic */ int h = 0;
    public final CompositeDisposable a;
    public boolean b;
    public final PublishSubject c;
    public final Observable<com.bytedance.android.live.profit.fansclub.c> d;
    public final yz0.k e;
    public final FansClubRepository f;
    public final com.bytedance.android.live.revenue.core.a g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FansClubDataService a;

        public b(FansClubDataService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            com.bytedance.android.live.base.model.user.t r0 = r3.getUser().getFansClub();
            if (r0 == null) goto L7;
            py.h r1 = r0.getData();
            if (r1 == null) goto L7;
            String r4 = r1.getClubName();
        L9:
            if (TextUtils.isEmpty(r4) == true) goto L11;
            this.a.f.n(r3.getUser());
        L11:
            IRoomAuthStatus r5 = this.a.getRoom().getRoomAuthStatus();
            if (r5 != null) goto L14;
            return;
        L14:
            if (r5.isShopFansClubMode() != true) goto L18;
            this.a.f.k();
            return;
        L18:
            return;
        L7:
            r4 = null;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FansClubDataService a;

        public c(FansClubDataService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IBaseUser r4 = (IBaseUser) r3;
            FansClubRepository r0 = this.a.f;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "user");
            com.bytedance.android.live.base.model.user.t r1 = r4.getFansClub();
            if (r1 == null) goto L5;
            r0.h.a(com.bytedance.android.live.profit.fansclub.transfer.m.e(r1));
        L5:
            int r2 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
            com.bytedance.android.live.base.model.user.t r5 = r4.getFansClub();
            if (r5 == null) goto L10;
            py.h r6 = r5.getData();
            if (r6 == null) goto L10;
            com.bytedance.android.live.profit.fansclub.b r7 = com.bytedance.android.live.profit.fansclub.transfer.m.c(r6);
        L11:
            com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.h(r7);
            return;
        L10:
            r7 = null;
            goto L11
        }
    }

    public static final class d<T> implements Predicate {
        public final /* synthetic */ FansClubDataService a;

        public d(FansClubDataService r1) {
            this.a = r1;
        }

        public final boolean test(Object r3) {
            IFollowPair r4 = (IFollowPair) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            boolean r0 = vh6.c.b(br2.a.class).nk(this.a.getRoom(), r4);
            if (Intrinsics.areEqual(r4.getUserIdString(), this.a.getRoom().getOwnerUserIdString()) == false) goto L8;
            if (r0 == false) goto L8;
            if (this.a.b == true) goto L8;
            return true;
        L8:
            return false;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ FansClubDataService a;

        public e(FansClubDataService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IFollowPair r3 = (IFollowPair) r2;
            FansClubDataService r4 = this.a;
            r4.b = true;
            r4.c();
        }
    }

    public final class f implements Consumer {
        public final /* synthetic */ Function1 a;

        public f(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final class g implements Predicate {
        public final /* synthetic */ Function1 a;

        public g(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ boolean test(Object r2) {
            return ((Boolean) this.a.invoke(r2)).booleanValue();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.fansclub.FansClubDataService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/c$b;", "p1", "", "invoke", "(Lcom/bytedance/android/live/profit/fansclub/c$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.profit.fansclub.c.b, Unit> {
        public AnonymousClass1(FansClubDataService r8) {
            super(1, r8, FansClubDataService.class, "processFansClubMessage", "processFansClubMessage(Lcom/bytedance/android/live/profit/fansclub/FansClubEvent$FansClubMessageEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.profit.fansclub.c.b r5) {
            Intrinsics.checkNotNullParameter(r5, "p1");
            FansClubDataService r0 = (FansClubDataService) ((CallableReference) this).receiver;
            int r1 = FansClubDataService.h;
            r0.getClass();
            if ((r5 instanceof com.bytedance.android.live.profit.fansclub.c.d) == false) goto L6;
            r0.f.j(10);
        L12:
            Long r2 = r5.b;
            if (r2 == null) goto L28;
            r2.longValue();
            if (((Boolean) i.o.getValue(null, i.a[12])).booleanValue() == true) goto L17;
        L21:
            boolean r6 = false;
        L22:
            if (r6 == true) goto L25;
            r2 = null;
        L25:
            if (r2 == null) goto L29;
            ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter().setAvailableDiamonds(r2.longValue());
            return;
        L29:
            return;
        L17:
            if ((r5 instanceof com.bytedance.android.live.profit.fansclub.c.C0019c) == false) goto L19;
        L20:
            r6 = true;
            goto L22
        L19:
            if ((r5 instanceof com.bytedance.android.live.profit.fansclub.c.d) == false) goto L21;
        L28:
            return;
        L6:
            if (iy0.e.b(r0.getRoom()) == false) goto L8;
        L11:
            r0.f.j(8);
            goto L12
        L8:
            if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).isTalkRoomLoaded() == true) goto L11;
            r0.f.n(r5.a);
            goto L12
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.profit.fansclub.c.b) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.fansclub.FansClubDataService$onStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/c$a;", "p1", "", "invoke", "(Lcom/bytedance/android/live/profit/fansclub/c$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.profit.fansclub.c.a, Unit> {
        public AnonymousClass2(FansClubDataService r8) {
            super(1, r8, FansClubDataService.class, "processEcomFansClubMessage", "processEcomFansClubMessage(Lcom/bytedance/android/live/profit/fansclub/FansClubEvent$EcomFansClubEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.profit.fansclub.c.a r5) {
            Intrinsics.checkNotNullParameter(r5, "p1");
            FansClubRepository r0 = ((FansClubDataService) ((CallableReference) this).receiver).f;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r5, "event");
            s r1 = new s();
            f7.b r2 = r5.a;
            boolean r3 = false;
            if (r2 == null) goto L5;
            int r4 = r2.getLevel();
        L6:
            r1.level = r4;
            s r6 = ((r) r0.k.a).userData;
            if (r6 == null) goto L9;
            int r7 = r6.intimacy;
        L10:
            r1.intimacy = r7;
            if (r5.b == 3) goto L13;
            r3 = true;
        L13:
            r1.joinStatus = r3;
            r r8 = new r();
            r8.userData = r1;
            r r9 = (r) r0.k.a;
            r8.fansClubSchema = r9.fansClubSchema;
            r8.fansClubSwitch = r9.fansClubSwitch;
            r0.j.a(r8);
            return;
        L9:
            r7 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.profit.fansclub.c.a) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void a() {
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).m().subscribe(new b(this)), this.a);
        RxUtilKt.c(this.e.L0().take(1).subscribe(new c(this)), this.a);
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).followStateChanged().filter(new d(this)).subscribe(new e(this)), this.a);
    }

    public final void c() {
        IRoomAuthStatus r1 = getRoom().getRoomAuthStatus();
        if (r1 == null) goto L8;
        if (r1.isShopFansClubMode() != true) goto L8;
        return;
    L8:
        if (i.d() != 0) goto L17;
        final FansClubRepository r2 = this.f;
        com.bytedance.android.live.profit.fansclub.transfer.b r12 = r2.u;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("apiDataSource");
    L12:
        r12.getClass();
        String r13 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        String r14 = r12.a.a();
        long r15 = r12.a.b();
        com.bytedance.android.live.revenue.common.g r10 = new com.bytedance.android.live.revenue.common.g("FansClubApiDataSource", "queryFansClubData anchorId=" + r14);
        long r4 = SystemClock.uptimeMillis();
        r12.a(false, 0);
        int r3 = com.bytedance.android.live.profit.fansclub.transfer.a.a;
        tz0.b r5 = tz0.b.a;
        uz0.c r6 = new uz0.c();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "$this$beforeConfigureRequest");
        Map<String, String> r7 = r6.b;
        Intrinsics.checkNotNullParameter(r7, "queriesMap");
        if (r14 != null) goto L15;
        String r8 = "";
    L16:
        Intrinsics.checkNotNullParameter("anchor_open_id", "$this$setTo");
        r7.put("anchor_open_id", r8);
        Intrinsics.checkNotNullParameter(r6, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.o(RxUtilKt.i(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/fansclub/me/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.fansclub.transfer.n.class)), Extra.class, r6.d, r6.a, r6.b, r6.c).map(com.bytedance.android.live.profit.fansclub.transfer.f.a).singleOrError()).doOnSuccess(new com.bytedance.android.live.profit.fansclub.transfer.g(r12, r4, r13, r14, r15, r10)).doOnError(new com.bytedance.android.live.profit.fansclub.transfer.h(r12, r13, r14, r15, r10)), new FansClubRepository$fetchFansClubMe$1(r2)), r2.a);
        return;
    L15:
        r8 = r14;
        goto L16
    L17:
        this.f.j(3);
    }

    public final IRoom getRoom() {
        return this.e.getRoom();
    }

    public final void onStart() {
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).isLogin() == true) goto L5;
        a();
    L17:
        RxUtilKt.c(this.d.ofType(com.bytedance.android.live.profit.fansclub.c.b.class).subscribe(new f(new AnonymousClass1(this))), this.a);
        RxUtilKt.c(this.d.ofType(com.bytedance.android.live.profit.fansclub.c.a.class).subscribe(new f(new AnonymousClass2(this))), this.a);
        return;
    L5:
        if (i.d() != 2) goto L8;
        com.bytedance.android.livesdk.revenue.service.room.b.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class), getRoom().getRoomId(), IGetFansclubHomepageResult.class, null, new FansClubDataService$runWithBackendData$1(this), new FansClubDataService$runWithBackendData$2(this), null, this.a, 36);
    L11:
        IRoomAuthStatus r0 = getRoom().getRoomAuthStatus();
        if (r0 == null) goto L17;
        if (r0.isShopFansClubMode() != true) goto L17;
        this.f.k();
        goto L17
    L8:
        if (i.d() != 1) goto L10;
        vh6.c.b(br2.a.class).Cc(getRoom().getOwner(), "FansClubDataService", getRoom(), new FansClubDataService$runInFollowed$1(this));
        goto L11
    L10:
        c();
        goto L11
    }

    public final void onStop() {
        this.a.dispose();
    }

    public FansClubDataService(yz0.k r2, yz0.l r3, FansClubRepository r4, com.bytedance.android.live.revenue.core.a r5) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "roomMessageService");
        Intrinsics.checkNotNullParameter(r4, "repository");
        Intrinsics.checkNotNullParameter(r5, "inst");
        this.e = r2;
        this.f = r4;
        this.g = r5;
        CompositeDisposable r6 = new CompositeDisposable();
        this.a = r6;
        FansClubIMDataSource r7 = new FansClubIMDataSource(r3);
        RxUtilKt.c(r7, r6);
        PublishSubject r8 = r7.c;
        this.c = r8;
        this.d = r8.filter(new g(new FansClubDataService$onSelfEvent$1(this)));
    }
}
