package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements eh0.b {
    public boolean a;
    public final CopyOnWriteArrayList<eh0.c> b;
    public final BehaviorSubject<List<ch0.e>> c;
    public final LifecycleOwner d;
    public final d e;

    @Override // eh0.b
    public void i(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "seiTalkingData");
    }

    @Override // eh0.b
    public void n(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcTalkingData");
    }

    @Override // eh0.b
    public void p(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcLastTalkingTimeData");
    }

    @Override // eh0.b
    public final List<ch0.e> d() {
        Object r0 = this.c.getValue();
        if (r0 == null) goto L7;
        return (List) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void detach() {
        Iterator<eh0.c> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r0.next().detach();
        goto L4
    L7:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L9;
        q();
    L9:
        this.a = false;
    }

    public void q() {
        this.c.onNext(CollectionsKt.emptyList());
    }

    @Override // eh0.b
    public BehaviorSubject<Map<String, Boolean>> j() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // eh0.b
    public BehaviorSubject<Map<String, Long>> l() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // eh0.b
    public BehaviorSubject<Map<String, Boolean>> o() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final d P1() {
        return this.e;
    }

    @Override // eh0.b
    public final BehaviorSubject<List<ch0.e>> h() {
        return this.c;
    }

    @Override // eh0.b
    public final void m(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r4) {
        Intrinsics.checkNotNullParameter(r4, "updateResult");
        gh0.a.b(null, "notifyUpdateResult", 5);
        if (r4.a == false) goto L6;
        this.c.onNext(r4.b);
        return;
    }

    public a(LifecycleOwner r1, d r2) {
        this.d = r1;
        this.e = r2;
        this.b = new CopyOnWriteArrayList();
        this.c = BehaviorSubject.createDefault(CollectionsKt.emptyList());
    }
}
