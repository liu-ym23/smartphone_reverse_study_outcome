package i12;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profit.privilege.model.touch.GrowthTouchData;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements wt0.a, com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final BehaviorSubject<com.bytedance.android.live.profit.privilege.model.touch.j> b;
    public final BehaviorSubject<com.bytedance.android.live.profit.privilege.model.paygrade.a> c;
    public final yz0.g d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.b.onNext(((ExtraResponse) r2).data);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((Throwable) r2, "t");
            this.a.b.onNext(vh7.f.c(com.bytedance.android.live.profit.privilege.model.touch.j.class));
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (com.bytedance.android.live.profit.privilege.model.paygrade.a) r3.data;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ j a;

        public d(j r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.profit.privilege.model.paygrade.a r6 = (com.bytedance.android.live.profit.privilege.model.paygrade.a) r5;
            j r0 = this.a;
            py.d r1 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getUserHonor();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "$this$updateToUserHonor");
            if (r1 == null) goto L5;
            r1.setScore(r6.getScore());
            r1.setLevel((int) r6.getLevel());
            r1.setThisGradeMaxDiamond(r6.getThisGradeMaxDiamond());
            r1.setThisGradeMinDiamond(r6.getThisGradeMinDiamond());
            r1.setGradeDescribe(r6.getGradeDescribe());
            r1.setNewImIconWithLevel(r6.getNewImIconWithLevel());
            r1.setBuffInfo(r6.getBuffInfo());
            r1.setNewLiveIcon(r6.getNewLiveIcon());
            r1.setGradeDescribeShining(r6.getGradeDescribeShining());
        L5:
            this.a.c.onNext(r6);
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

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void si() {
        List r1 = CollectionsKt.mutableListOf(new Long[]{Long.valueOf(GrowthTouchData.Position.PositionGiftPanelTop.getValue()), Long.valueOf(GrowthTouchData.Position.PositionGiftPanelEntrance.getValue())});
        com.bytedance.android.live.profit.privilege.a r2 = yt0.c.i();
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m r3 = r2.getBubbleRefId();
        if (r3 == null) goto L9;
        Long r4 = (Long) r3.getValue();
        if (r4 == null) goto L9;
        long r5 = r4.longValue();
    L10:
        IBaseUser r6 = this.d.getRoom().getOwnerKt();
        if (r6 == null) goto L14;
        String r7 = r6.getIdString();
        if (r7 == null) goto L14;
    L15:
        String r8 = this.d.getRoom().getIdStr();
        String r9 = r1.toString();
        Intrinsics.checkNotNullParameter(r7, "anchorId");
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Intrinsics.checkNotNullParameter(r9, "positions");
        tz0.b r10 = tz0.b.a;
        uz0.c r11 = new uz0.c();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "$this$beforeConfigureRequest");
        Map r13 = ((uz0.a) r11).b;
        Intrinsics.checkNotNullParameter(r13, "queriesMap");
        Intrinsics.checkNotNullParameter("anchor_open_id", "$this$setTo");
        r13.put("anchor_open_id", r7);
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r8 == null) goto L18;
        r13.put("room_id", r8);
    L18:
        Intrinsics.checkNotNullParameter("positions", "$this$setTo");
        if (r9 == null) goto L21;
        r13.put("positions", r9);
    L21:
        String r14 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("ref_id", "$this$setTo");
        if (r14 == null) goto L24;
        r13.put("ref_id", r14);
    L24:
        Intrinsics.checkNotNullParameter(r11, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.h(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/growth/touch_position/list/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.privilege.model.touch.j.class)), Extra.class, ((uz0.a) r11).d, ((uz0.a) r11).a, ((uz0.a) r11).b, ((uz0.a) r11).c).subscribeOn(Schedulers.io())).subscribe(new a(this), new b(this)), this.a);
        return;
    L14:
        r7 = BuildConfig.FLAVOR;
    L9:
        r5 = 0;
        goto L10
    }

    public final Observable<com.bytedance.android.live.profit.privilege.model.paygrade.a> observePayGrade() {
        return this.c;
    }

    public final BehaviorSubject ue() {
        return this.b;
    }

    public j(yz0.g r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.d = r2;
        this.a = new CompositeDisposable();
        int r3 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.b = BehaviorSubject.createDefault(vh7.f.c(com.bytedance.android.live.profit.privilege.model.touch.j.class));
        this.c = BehaviorSubject.createDefault(vh7.f.c(com.bytedance.android.live.profit.privilege.model.paygrade.a.class));
    }

    public final void k0(int r11) {
        String r13 = this.d.getRoom().getIdStr();
        Intrinsics.checkNotNullParameter(r13, "roomId");
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r13 == null) goto L5;
        r2.put("room_id", r13);
    L5:
        Integer r14 = 2;
        String r15 = r14.toString();
        Intrinsics.checkNotNullParameter("request_from", "$this$setTo");
        if (r15 == null) goto L8;
        r2.put("request_from", r15);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.h(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/privilege/paygrade/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.privilege.model.paygrade.a.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c).subscribeOn(Schedulers.io())).map(c.a).subscribe(new d(this), e.a), this.a);
    }
}
