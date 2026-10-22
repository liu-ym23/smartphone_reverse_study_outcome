package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends eh0.a {
    public final List<ch0.j> b;
    public final Map<String, Boolean> c;
    public final long d;
    public SeiAppData e;
    public final AtomicLong f;
    public final BehaviorSubject<SeiAppData> g;
    public boolean h;
    public final CompositeDisposable i;
    public final b j;
    public eg6.b k;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d l;

    public static final class a {
    }

    public static final class b extends eg6.a {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void i(String r8) {
            e r9 = this.a;
            if ((!((ArrayList) r9.b).isEmpty()) == false) goto L9;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = r9.l;
            if (r1 == null) goto L7;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteSeiHandlerV2", r9.hashCode(), "clear", false, 24);
        L7:
            ((ArrayList) r9.b).clear();
            ((LinkedHashMap) r9.c).clear();
            r9.c();
            return;
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        eg6.b r0 = this.k;
        if (r0 == null) goto L5;
        r0.h0(this.j);
    L5:
        this.h = true;
        Observable r1 = this.g.distinctUntilChanged().map(new l(this)).share();
        Observable r2 = r1.filter(j.a).map(k.a);
        Observable r3 = r1.filter(m.a).map(n.a).sample(this.d, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        Disposable r4 = r2.filter(new f(this)).subscribe(new g(this));
        this.i.add(r4);
        Disposable r5 = r3.filter(new h(this)).subscribe(new i(this));
        this.i.add(r5);
    }

    @Override // eh0.c
    public final void detach() {
        this.i.clear();
        eg6.b r0 = this.k;
        if (r0 == null) goto L5;
        r0.s(this.j);
    L5:
        this.h = false;
    }

    @Override // eh0.a, eh0.c
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a a(List<ch0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "oldMergeDataList");
        List<ch0.j> r0 = this.b;
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
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r5, r4, r6);
    }

    public final void d(SeiAppData r6) {
        Intrinsics.checkNotNullParameter(r6, "sei");
        String r0 = r6.getChannelId();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.l;
        Long r2 = null;
        if (r1 == null) goto L7;
        IRoom r3 = r1.getRoom();
        if (r3 == null) goto L7;
        Long r4 = Long.valueOf(r3.getId());
    L9:
        if ((!Intrinsics.areEqual(r0, String.valueOf(r4))) == false) goto L17;
        StringBuilder r5 = new StringBuilder("sei channel id wrong ");
        r5.append(r6.getChannelId());
        r5.append(" room ");
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r7 = this.l;
        if (r7 == null) goto L15;
        IRoom r8 = r7.getRoom();
        if (r8 == null) goto L15;
        r2 = Long.valueOf(r8.getId());
    L15:
        r5.append(r2);
        ALogger.d("RemoteSeiHandlerV2", r5.toString());
        return;
    L17:
        this.g.onNext(r6);
        return;
    L7:
        r4 = null;
        goto L9
    }

    public e(eg6.b r3, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r4) {
        this.k = r3;
        this.l = r4;
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
        this.d = ((MultiLinkFrequencyOptConfig) v2.a.getValue()).getSeiHandlerSamplingIntervalMs();
        this.f = new AtomicLong(-1);
        this.g = BehaviorSubject.create();
        this.i = new CompositeDisposable();
        this.j = new b(this);
    }
}
