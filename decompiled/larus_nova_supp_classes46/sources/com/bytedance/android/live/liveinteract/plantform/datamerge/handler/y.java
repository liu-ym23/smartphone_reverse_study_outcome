package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.model.u0;
import com.bytedance.android.live.liveinteract.plantform.model.v0;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b {
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a b;
    public final List<ch0.j> c;
    public final long d;
    public SeiAppData e;
    public final AtomicLong f;
    public final BehaviorSubject<SeiAppData> g;
    public final CompositeDisposable h;
    public boolean i;
    public final c j;
    public eg6.b k;
    public final DataCenter l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ y a;

        public b(y r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ch0.d r2 = (ch0.d) r1;
            this.a.a().l1().getClass();
        }
    }

    public static final class c extends eg6.a {
        public final /* synthetic */ y a;

        public c(y r1) {
            this.a = r1;
        }

        public final void i(String r4) {
            y r5 = this.a;
            if ((!((ArrayList) r5.c).isEmpty()) == false) goto L6;
            gh0.a.b("SeiHandlerV2", "clear", 4);
            ((ArrayList) r5.c).clear();
            r5.c();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.h.clear();
        eg6.b r0 = this.k;
        if (r0 == null) goto L5;
        r0.s(this.j);
    L5:
        this.i = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        RxUtilKt.c(a().a1().subscribe(new b(this)), this.h);
        eg6.b r0 = this.k;
        if (r0 == null) goto L5;
        r0.h0(this.j);
    L5:
        Observable r1 = this.g.distinctUntilChanged().map(new d0(this)).share();
        this.h.add(Observable.merge(r1.filter(b0.a).map(c0.a), r1.filter(e0.a).map(f0.a).sample(this.d, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())).filter(new z(this)).subscribe(new a0(this)));
        IRoomModuleService r2 = jc1.k.f(IRoomModuleService.class);
        long r3 = 0;
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.room.backend.g r4 = r2.getLiveRoomBackendUtils();
        if (r4 == null) goto L14;
        Room r5 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.l, null, 2).getCurrentRoom();
        if (r5 == null) goto L12;
        long r6 = r5.getId();
    L13:
        r4.f(r6, u0.class, new SeiHandlerV2$initSeiAppData$1(this));
        goto L14
    L12:
        r6 = 0;
    L14:
        IRoomModuleService r7 = jc1.k.f(IRoomModuleService.class);
        if (r7 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.room.backend.g r8 = r7.getLiveRoomBackendUtils();
        if (r8 == null) goto L24;
        com.bytedance.live.datacontext.m r9 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.l, null, 2).getRoom();
        if (r9 == null) goto L23;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L23;
        r3 = r10.getId();
    L23:
        r8.f(r3, v0.class, new SeiHandlerV2$initSeiAppData$2(this));
    L24:
        this.i = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "oldMergeDataList");
        List<ch0.j> r0 = this.c;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = ((ArrayList) r0).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r2 = r1.next();
        r3.put(((ch0.j) r2).a, r2);
        goto L4
    L6:
        List<ch0.e> r14 = r13;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
        boolean r5 = false;
        ch0.e r6 = null;
    L8:
        if (r15.hasNext() == false) goto L23;
        ch0.e r7 = (ch0.e) r15.next();
        ch0.j r9 = (ch0.j) r3.get(r7.a.getInteractId());
        if (r7.d(r9) == false) goto L12;
        boolean r8 = r5;
        ch0.e r10 = r7;
    L13:
        IBaseUser r11 = r10.a.getUser();
        if (r11 == null) goto L16;
        String r12 = r11.getIdString();
    L18:
        if (Intrinsics.areEqual(r12, gh0.a.c()) == false) goto L21;
        if (r10 == r7) goto L21;
        r6 = r10;
    L21:
        r4.add(r10);
        r5 = r8;
        goto L8
    L16:
        r12 = null;
        goto L18
    L12:
        r10 = ch0.e.a(r7, null, null, r9, null, 11);
        r8 = true;
        goto L13
    L23:
        return new h.a(r5, r4, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void d(SeiAppData r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        this.g.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void e(eg6.b r3) {
        eg6.b r0 = this.k;
        if (r0 == null) goto L5;
        r0.s(this.j);
    L5:
        this.k = r3;
        if (this.i == false) goto L10;
        if (r3 == null) goto L11;
        r3.h0(this.j);
        return;
    L11:
        return;
    }

    public y(eg6.b r3, DataCenter r4) {
        this.k = r3;
        this.l = r4;
        this.b = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(0, 0, 0, 0);
        this.c = new ArrayList();
        this.d = ((MultiLinkFrequencyOptConfig) v2.a.getValue()).getSeiHandlerSamplingIntervalMs();
        this.f = new AtomicLong(-1);
        this.g = BehaviorSubject.create();
        this.h = new CompositeDisposable();
        this.j = new c(this);
    }
}
