package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.core.service.o;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorPositionSnapShot implements c<Map<String, ? extends Integer>> {
    public final CompositeDisposable a;
    public Map<String, Integer> b;
    public Map<String, Integer> c;
    public final AnchorPositionSnapShot$onPartnerEnableObserver$1 d;
    public final AnchorLinkUserCenterV2 e;
    public final d f;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g g;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.layoutstatus.AnchorPositionSnapShot$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<List<? extends p>, Integer, Unit> {
        public AnonymousClass1(AnchorPositionSnapShot r8) {
            super(2, r8, AnchorPositionSnapShot.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends p> r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "p1");
            AnchorPositionSnapShot r7 = (AnchorPositionSnapShot) ((CallableReference) this).receiver;
            r7.getClass();
            jy0.b.c("xuzr_position", r5.toString(), null, 4);
            if (r7.b(r5) == false) goto L7;
            r7.f.requestLayout();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.layoutstatus.AnchorPositionSnapShot$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/service/o;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/link/core/service/o;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<o, Unit> {
        public AnonymousClass2(AnchorPositionSnapShot r8) {
            super(1, r8, AnchorPositionSnapShot.class, "onLayoutDetailsChange", "onLayoutDetailsChange(Lcom/bytedance/android/live/revlink/link/core/service/LayoutDetails;)V", 0);
        }

        public final void invoke(o r2) {
            AnchorPositionSnapShot r0 = (AnchorPositionSnapShot) ((CallableReference) this).receiver;
            if (r2 != null) goto L6;
            r0.getClass();
            return;
        L6:
            if (r0.c(r2) == false) goto L11;
            r0.f.requestLayout();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((o) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(this.e.m(new AnonymousClass1(this)), this.a);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(this.g.b, new AnonymousClass2(this)), this.a);
        RevLinkWindowRegionContext r0 = this.g.P8();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r1 = r0.getPartnerService();
        if (r1 == null) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r2 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r1.getValue();
        if (r2 == null) goto L14;
        NextLiveData<Boolean> r3 = r2.getBattleStatus();
        if (r3 == null) goto L15;
        r3.observeForever(this.d);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        this.a.clear();
        this.b = MapsKt.emptyMap();
        RevLinkWindowRegionContext r0 = this.g.P8();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r1 = r0.getPartnerService();
        if (r1 == null) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r2 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r1.getValue();
        if (r2 == null) goto L14;
        NextLiveData<Boolean> r3 = r2.getBattleStatus();
        if (r3 == null) goto L15;
        r3.removeObserver(this.d);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final boolean b(List r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        o51.e r1 = this.f.getUiLayout();
        List r7 = r6;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r2.add(iz.a.a(((p) r8.next()).getUser()));
        goto L4
    L6:
        Iterator r9 = CollectionsKt.sortedWith(r2, new a(this, r1)).iterator();
        int r3 = 0;
    L8:
        if (r9.hasNext() == false) goto L17;
        Object r4 = r9.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        String r10 = (String) r4;
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        r0.put(r10, Integer.valueOf(r3));
        r3 = r5;
        goto L8
    L17:
        if (a(r0, this.b) == false) goto L19;
        return false;
    L19:
        this.b = r0;
        return true;
    }

    public final boolean c(o r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r8 = MapsKt.toMap(r7.a).entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) r8.next();
        r0.put((String) r1.getKey(), Integer.valueOf(((int) ((com.bytedance.android.livesdk.link.model.bridge.g) r1.getValue()).getPosition()) - 1));
        goto L4
    L7:
        if (a(r0, this.c) == false) goto L10;
        return false;
    L10:
        this.c = r0;
        return true;
    }

    public final boolean a(Map<String, Integer> r6, Map<String, Integer> r7) {
        if (r6 != null) goto L7;
        if (r7 != null) goto L7;
        return true;
    L7:
        if (r6 == null) goto L26;
        if (r7 == null) goto L26;
        if (r6.size() != r7.size()) goto L26;
        Iterator<Map.Entry<String, Integer>> r8 = r6.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L25;
        Map.Entry<String, Integer> r2 = r8.next();
        String r3 = r2.getKey();
        int r4 = r2.getValue().intValue();
        Intrinsics.checkNotNullParameter(r7, "$this$getOrNull");
        if (r7.containsKey(r3) == false) goto L18;
        Integer r5 = r7.get(r3);
    L19:
        Integer r9 = r5;
        if (r9 == null) goto L24;
        if (r9.intValue() == r4) goto L14;
    L24:
        return false;
    L18:
        r5 = null;
        goto L19
    L25:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.revlink.link.core.layoutstatus.AnchorPositionSnapShot$onPartnerEnableObserver$1] */
    public AnchorPositionSnapShot(AnchorLinkUserCenterV2 r2, h r3, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r4) {
        Intrinsics.checkNotNullParameter(r2, "anchorLinkUserCenterV2");
        Intrinsics.checkNotNullParameter(r3, "snapShotContext");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = new CompositeDisposable();
        this.b = MapsKt.emptyMap();
        this.c = MapsKt.emptyMap();
        this.d = new AnchorPositionSnapShot$onPartnerEnableObserver$1(this);
    }
}
