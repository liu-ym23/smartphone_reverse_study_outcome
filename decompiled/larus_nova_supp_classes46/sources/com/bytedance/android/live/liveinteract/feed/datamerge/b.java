package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.service.MessageHub;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements k {
    public final BehaviorSubject<List<ch0.e>> a;
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> b;
    public final BehaviorSubject<List<ch0.e>> c;
    public final BehaviorSubject<List<LinkmicPositionItem>> d;
    public final BehaviorSubject<ConcurrentHashMap<String, pf0.a>> e;
    public final BehaviorSubject<cj> f;
    public final BehaviorSubject<wg0.a> g;
    public final BehaviorSubject<ch0.a> h;
    public final BehaviorSubject<SeiAppData> i;
    public final CopyOnWriteArrayList<j> j;
    public final MessageHub k;
    public final int l;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final List<ch0.e> d() {
        Object r0 = this.c.getValue();
        if (r0 == null) goto L7;
        return (List) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final ch0.a e() {
        Object r0 = this.h.getValue();
        if (r0 == null) goto L7;
        return (ch0.a) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final wg0.a j() {
        Object r0 = this.g.getValue();
        if (r0 == null) goto L7;
        return (wg0.a) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final List<LinkmicPositionItem> k() {
        Object r0 = this.d.getValue();
        if (r0 == null) goto L7;
        return (List) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final List<ch0.e> o() {
        Object r0 = this.a.getValue();
        if (r0 == null) goto L7;
        return (List) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final Map<String, pf0.a> r() {
        Object r0 = this.e.getValue();
        if (r0 == null) goto L7;
        return (Map) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<wg0.a> b() {
        return this.g;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<List<ch0.e>> f() {
        return this.a;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<List<LinkmicPositionItem>> g() {
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final MessageHub getMessageHub() {
        return this.k;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final int getShowFrom() {
        return this.l;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<List<ch0.e>> h() {
        return this.c;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<ConcurrentHashMap<String, pf0.a>> i() {
        return this.e;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<ch0.a> s() {
        return this.h;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void a(List<? extends ILinkPlayerInfoBridge> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.b.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void c(wg0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "playModeStateItem");
        this.g.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void l(ch0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "roomState");
        this.h.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void n(j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "updateResult");
        if (r2.a == false) goto L6;
        this.c.onNext(r2.b);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void p(List<? extends LinkmicPositionItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.d.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void q(cj r2) {
        Intrinsics.checkNotNullParameter(r2, "radioGiftCommentMessage");
        this.f.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void t(j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "updateResult");
        if (r2.a == false) goto L6;
        this.a.onNext(r2.b);
        return;
    }

    public final void u(a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.j.add(r2);
        r2.attach();
    }

    public b(MessageHub r2, int r3) {
        this.k = r2;
        this.l = r3;
        this.a = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.b = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.c = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.d = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.e = BehaviorSubject.createDefault(new ConcurrentHashMap());
        this.f = BehaviorSubject.create();
        this.g = BehaviorSubject.createDefault(new wg0.a(0));
        this.h = BehaviorSubject.createDefault(new ch0.a(0, 0, CollectionsKt.emptyList()));
        this.i = BehaviorSubject.createDefault(new SeiAppData());
        this.j = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void m(String r2, pf0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "item");
        ConcurrentHashMap r0 = (ConcurrentHashMap) this.e.getValue();
        if (r0 == null) goto L6;
        pf0.a r4 = (pf0.a) r0.put(r2, r3);
        return;
    }
}
