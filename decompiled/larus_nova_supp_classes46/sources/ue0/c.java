package ue0;

import com.bytedance.android.live.liveinteract.feed.datamerge.j;
import com.bytedance.android.live.liveinteract.feed.datamerge.k;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
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
public final class c implements k {
    public final BehaviorSubject<IRoomLinkMicSyncData> a;
    public final BehaviorSubject<List<ch0.e>> b;
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> c;
    public final BehaviorSubject<List<ch0.e>> d;
    public final BehaviorSubject<List<LinkmicPositionItem>> e;
    public final BehaviorSubject<ConcurrentHashMap<String, pf0.a>> f;
    public final BehaviorSubject<wg0.a> g;
    public final BehaviorSubject<cj> h;
    public final BehaviorSubject<ch0.a> i;
    public final CopyOnWriteArrayList<j> j;
    public final MessageHub k;
    public final int l;
    public final IVoiceLiveTheme m;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final List<ch0.e> d() {
        Object r0 = this.d.getValue();
        if (r0 == null) goto L7;
        return (List) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final ch0.a e() {
        Object r0 = this.i.getValue();
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
        Object r0 = this.e.getValue();
        if (r0 == null) goto L7;
        return (List) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final List<ch0.e> o() {
        Object r0 = this.b.getValue();
        if (r0 == null) goto L7;
        return (List) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final Map<String, pf0.a> r() {
        Object r0 = this.f.getValue();
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
        return this.b;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<List<LinkmicPositionItem>> g() {
        return this.e;
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
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<ConcurrentHashMap<String, pf0.a>> i() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<ch0.a> s() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void a(List<? extends ILinkPlayerInfoBridge> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.c.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void c(wg0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "playModeStateItem");
        this.g.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void l(ch0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "roomState");
        this.i.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void n(j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "updateResult");
        if (r2.a == false) goto L6;
        this.d.onNext(r2.b);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void p(List<? extends LinkmicPositionItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.e.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void q(cj r2) {
        Intrinsics.checkNotNullParameter(r2, "radioGiftCommentMessage");
        this.h.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void t(j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "updateResult");
        if (r2.a == false) goto L6;
        this.b.onNext(r2.b);
        return;
    }

    public final void u(com.bytedance.android.live.liveinteract.feed.datamerge.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.j.add(r2);
        r2.attach();
    }

    public final void v(com.bytedance.android.live.liveinteract.feed.datamerge.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.j.remove(r2);
        r2.detach();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void m(String r2, pf0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "item");
        ConcurrentHashMap r0 = (ConcurrentHashMap) this.f.getValue();
        if (r0 == null) goto L6;
        pf0.a r4 = (pf0.a) r0.put(r2, r3);
        return;
    }

    public c(MessageHub r1, int r2, IVoiceLiveTheme r3) {
        this.k = r1;
        this.l = r2;
        this.m = r3;
        this.a = BehaviorSubject.create();
        this.b = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.c = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.d = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.e = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.f = BehaviorSubject.createDefault(new ConcurrentHashMap());
        this.g = BehaviorSubject.createDefault(new wg0.a(0));
        this.h = BehaviorSubject.create();
        this.i = BehaviorSubject.createDefault(new ch0.a(0, 0, CollectionsKt.emptyList()));
        BehaviorSubject.createDefault(new SeiAppData());
        this.j = new CopyOnWriteArrayList();
    }
}
