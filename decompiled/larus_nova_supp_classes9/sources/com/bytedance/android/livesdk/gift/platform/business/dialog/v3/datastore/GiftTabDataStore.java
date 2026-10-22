package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.TabChangeSource;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListPanelRepository;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.sequences.SequencesKt;
import oc6.h0;
import oc6.n0;
import oc6.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftTabDataStore extends BaseMVIDataStore<GiftTabDataStore> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] p = null;
    public final BehaviorSubject<h0> e;
    public final ReadOnlyProperty f;
    public final ReadOnlyProperty g;
    public final com.bytedance.android.anya.t h;
    public final BehaviorSubject<vz1.j> i;
    public Map<String, String> j;
    public final GiftListPanelRepository k;
    public final PropListService l;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f m;
    public final GiftDefaultLocationInfoDataStore n;
    public final GiftListRepository o;

    static {
        p = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTabDataStore.class, "currentTab", "getCurrentTab()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabDataStore.class, "orderRule", "getOrderRule()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabDataStore.class, "_currentTab", "get_currentTab()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/TabDataModel;", 0))};
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final com.bytedance.android.anya.t<GiftTabDataStore, vz1.j> s() {
        return (com.bytedance.android.anya.t) this.f.getValue(this, p[0]);
    }

    public final oc6.a k() {
        com.bytedance.android.livesdk.gift.platform.core.model.d r0 = this.o.j0();
        String r1 = null;
        if (r0 == null) goto L16;
        oc6.a r2 = new oc6.a();
        py.k r3 = r0.getIcon();
        if (r3 == null) goto L14;
        List r4 = r3.getUrls();
        if (r4 == null) goto L14;
        if ((!r4.isEmpty()) == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L14;
        r1 = (String) ListProtector.get(r4, 0);
    L14:
        r2.a(r1);
        r2.b(r0.getSchema());
        Unit r5 = Unit.INSTANCE;
        return r2;
    L16:
        return null;
    }

    public final n0 n() {
        GiftListRepository r0 = this.o;
        String r1 = null;
        if (r0 == null) goto L28;
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r2 = r0.k;
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.model.m r3 = r2.d;
    L8:
        if (r3 == null) goto L29;
        n0 r4 = new n0();
        py.k r5 = r3.getIcon();
        boolean r6 = false;
        if (r5 == null) goto L19;
        List r7 = r5.getUrls();
        if (r7 == null) goto L19;
        if ((!r7.isEmpty()) == true) goto L17;
        r7 = null;
    L17:
        if (r7 == null) goto L19;
        r1 = (String) ListProtector.get(r7, 0);
    L19:
        r4.b(r1);
        r4.d(r3.getSchema());
        Boolean r8 = r3.getCloseGiftPanel();
        if (r8 == null) goto L22;
        boolean r9 = r8.booleanValue();
    L23:
        r4.a(r9);
        Boolean r10 = r3.isNormalSearch();
        if (r10 == null) goto L26;
        r6 = r10.booleanValue();
    L26:
        r4.c(r6);
        Unit r11 = Unit.INSTANCE;
        return r4;
    L22:
        r9 = false;
        goto L23
    L29:
        return null;
    L7:
        r3 = null;
        goto L8
    L28:
        return null;
    }

    public final List<o0> o() {
        return SequencesKt.toList(SequencesKt.map(CollectionsKt.asSequence(this.k.Mn(this.m.b).c), new GiftTabDataStore$captureTabListFromPage$1(this)));
    }

    public final vz1.j q() {
        LocateGiftInfo r0 = this.n.a;
        h0 r1 = (h0) this.e.getValue();
        int r2 = -1;
        if (r1 == null) goto L17;
        List r3 = r1.a();
        if (r3 == null) goto L17;
        Iterator r4 = r3.iterator();
        int r5 = 0;
    L8:
        if (r4.hasNext() == false) goto L17;
        if (((o0) r4.next()).getType() != r0.getTargetPageType()) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L14;
        r5 = r5 + 1;
        goto L8
    L14:
        r2 = r5;
        goto L17
    L12:
        r6 = false;
    L17:
        return new vz1.j(r2, r0.getTargetPageType(), TabChangeSource.Default);
    }

    public final int w() {
        LocateGiftInfo r0 = this.n.a;
        h0 r1 = (h0) this.e.getValue();
        if (r1 == null) goto L20;
        List r2 = r1.a();
        if (r2 == null) goto L21;
        Iterator r3 = r2.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L16;
        if (((o0) r3.next()).getType() != r0.getTargetPageType()) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L22;
        r4 = r4 + 1;
        goto L8
    L22:
        return r4;
    L12:
        r5 = false;
        goto L13
    L16:
        return -1;
    L21:
        return 0;
    L20:
        return 0;
    }

    public final void I() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == true) goto L5;
        return;
    L5:
        BehaviorSubject<h0> r0 = this.e;
        h0 r1 = new h0();
        r1.d(o());
        r1.c(n());
        r1.b(k());
        Unit r2 = Unit.INSTANCE;
        r0.onNext(r1);
    }

    public final void y(final int r4, final int r5) {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == true) goto L5;
        return;
    L5:
        this.i.onNext(new vz1.j(r4, r5, TabChangeSource.Slide));
        g("updateCurrentTab", new GiftTabDataStore$slideTab$1(this, r4, r5));
    }

    public final void F(final vz1.j r3, Map<String, String> r4, final int r5) {
        Intrinsics.checkNotNullParameter(r3, "newTab");
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == true) goto L5;
        return;
    L5:
        int r0 = r3.b;
        vz1.j r1 = (vz1.j) this.i.getValue();
        if (r1 != null) goto L8;
    L10:
        this.i.onNext(r3);
        g("updateCurrentTab", new GiftTabDataStore$updateCurrentTab$2(this, r3));
    L11:
        this.j = r4;
        return;
    L8:
        if (r0 != r1.b) goto L10;
        g("updateOrder", new GiftTabDataStore$updateCurrentTab$1(this, r5));
        goto L11
    }

    public GiftTabDataStore(GiftListPanelRepository r2, PropListService r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r4, GiftDefaultLocationInfoDataStore r5, GiftListRepository r6) {
        Intrinsics.checkNotNullParameter(r2, "giftPanelListRepository");
        Intrinsics.checkNotNullParameter(r3, "propListService");
        Intrinsics.checkNotNullParameter(r4, "receiverService");
        Intrinsics.checkNotNullParameter(r5, "giftDefaultLocationInfoDataStore");
        Intrinsics.checkNotNullParameter(r6, "giftListRepository");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        h0 r7 = new h0();
        r7.d(o());
        r7.c(n());
        r7.b(k());
        Unit r8 = Unit.INSTANCE;
        this.e = BehaviorSubject.createDefault(r7);
        com.bytedance.android.anya.internal.k r9 = j(q()).a();
        KProperty[] r10 = p;
        this.f = r9.a(r10[0]);
        this.g = i(0).a().a(r10[1]);
        this.h = s();
        this.i = BehaviorSubject.createDefault(q());
    }
}
