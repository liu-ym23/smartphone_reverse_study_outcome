package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.u;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends a {
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.e f;
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.d g;
    public final BehaviorSubject<Map<String, Boolean>> h;
    public final BehaviorSubject<Map<String, Boolean>> i;
    public final BehaviorSubject<Map<String, Long>> j;
    public final BehaviorSubject<Map<String, Boolean>> k;
    public eg6.b l;
    public final DataCenter m;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void O1() {
        if (this.a == false) goto L6;
        ALogger.i("LinkRoomFightDataMergeCenter", "LinkRoomFightDataMergeCenterV2=" + hashCode() + ", isInitDefaultHandler=" + this.a);
        return;
    L6:
        this.a = true;
        ArrayList r0 = new ArrayList();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.e r1 = new com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.e(this.l, this.e);
        this.f = r1;
        Intrinsics.checkNotNullParameter(this, "proxy");
        r1.a = this;
        r0.add(r1);
        d r2 = this.e;
        if (r2 != null) goto L9;
    L13:
        this.b.addAllAbsent(r0);
        CopyOnWriteArrayList<eh0.c> r3 = this.b;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.b r4 = new com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.b(r0, this.e);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r4.a = this;
        r3.add(r4);
        Iterator<eh0.c> r5 = this.b.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r5.next().attach();
        goto L15
    L17:
        return;
    L9:
        if (r2.getShowFrom() != 0) goto L13;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.d r6 = new com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.d(this.m, this.l, this.e);
        this.g = r6;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r6.a = this;
        r0.add(r6);
        DataCenter r7 = this.m;
        if (r7 == null) goto L13;
        u r8 = new u(r7);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r8.a = this;
        r0.add(r8);
        goto L13
    }

    @Override // eh0.b
    public final void e() {
        d r0 = this.e;
        if (r0 == null) goto L8;
        List<ILinkPlayerInfoBridge> r1 = r0.c();
        if (r1 == null) goto L9;
        r1.clear();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.a
    public final void q() {
        super.q();
        this.h.onNext(MapsKt.emptyMap());
        this.i.onNext(MapsKt.emptyMap());
        this.j.onNext(MapsKt.emptyMap());
        this.k.onNext(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.a, eh0.b
    public final BehaviorSubject<Map<String, Boolean>> j() {
        return this.h;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.a, eh0.b
    public final BehaviorSubject<Map<String, Long>> l() {
        return this.j;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.a, eh0.b
    public final BehaviorSubject<Map<String, Boolean>> o() {
        return this.k;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void N1(hg6.g r4) {
        this.l = r4;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.e r0 = this.f;
        if (r0 == null) goto L11;
        eg6.b r1 = r0.k;
        if (r1 == null) goto L7;
        r1.s(r0.j);
    L7:
        r0.k = r4;
        if (r0.h == false) goto L11;
        if (r4 == null) goto L11;
        r4.h0(r0.j);
    L11:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.d r2 = this.g;
        if (r2 == null) goto L21;
        eg6.b r3 = r2.m;
        if (r3 == null) goto L16;
        r3.s(r2.k);
    L16:
        r2.m = r4;
        if (r2.j == false) goto L22;
        if (r4 == null) goto L23;
        r4.h0(r2.k);
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.a, eh0.b
    public final void i(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "seiTalkingData");
        this.h.onNext(r2);
        this.k.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.a, eh0.b
    public final void n(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcTalkingData");
        this.i.onNext(r2);
        this.k.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.a, eh0.b
    public final void p(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcLastTalkingTimeData");
        this.j.onNext(r2);
    }

    @Override // eh0.b
    public final void t0(SeiAppData r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.e r0 = this.f;
        if (r0 == null) goto L8;
        r0.d(r2);
        return;
    }

    public f(LifecycleOwner r1, eg6.b r2, DataCenter r3, int r4, d r5) {
        super(r1, r5);
        this.l = r2;
        this.m = r3;
        this.h = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.i = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.j = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.k = BehaviorSubject.createDefault(MapsKt.emptyMap());
    }
}
