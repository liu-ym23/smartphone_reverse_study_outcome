package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.model.x1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q2;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVICarnivalDataStore extends BaseMVIDataStore<GiftMVICarnivalDataStore> implements z {
    public static final /* synthetic */ KProperty[] l = null;
    public final BehaviorSubject<sh6.b<x1>> e;
    public final ReadOnlyProperty f;
    public final String g;
    public final CompositeDisposable h;
    public vz1.e i;
    public int j;
    public final q2 k;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GiftMVICarnivalDataStore a;

        public a(GiftMVICarnivalDataStore r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final x1 r4 = (x1) r3;
            this.a.g("giftPanelTopBarChanged", new GiftMVICarnivalDataStore$onStart$1$1(this, r4));
        }
    }

    static {
        l = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftMVICarnivalDataStore.class, "giftPanelTopBarMessage", "getGiftPanelTopBarMessage()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0))};
    }

    public final boolean f() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.a();
    }

    public final void k() {
        vz1.e r0 = this.i;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.e == true) goto L8;
        String r2 = String.valueOf(Long.valueOf(r0.b));
    L9:
        vz1.e r1 = this.i;
        if (r1 != null) goto L12;
    L14:
        String r3 = null;
    L15:
        this.k.bh().onNext(new q2.a(r2, r3, this.j, false, 0, null, 56));
        this.i = null;
        this.j = 0;
        return;
    L12:
        if (r1.e != true) goto L14;
        r3 = String.valueOf(Long.valueOf(r1.b));
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    public final x1 n() {
        final x1 r0 = this.k.getGiftPanelTopBar();
        if (r0 != null) goto L7;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.A.u2() == false) goto L7;
        return r0;
    L7:
        g("getLatestTopBarMessage", new GiftMVICarnivalDataStore$getLatestTopBarMessage$1(this, r0));
        return r0;
    }

    public final void onStart() {
        RxUtilKt.c(this.k.rj().subscribe(new a(this)), this.h);
    }

    public final void onStop() {
        k();
        this.h.dispose();
        this.i = null;
    }

    public GiftMVICarnivalDataStore(q2 r3) {
        Intrinsics.checkNotNullParameter(r3, "carnivalInRoomMessageService");
        this.k = r3;
        this.e = BehaviorSubject.createDefault(sh6.c.a(r3.getGiftPanelTopBar()));
        this.f = i(vh7.f.c(x1.class)).a().a(l[0]);
        this.g = "嘉年华";
        this.h = new CompositeDisposable();
    }

    public final void o(vz1.e r2) {
        Intrinsics.checkNotNullParameter(r2, "iconModel");
        if (Intrinsics.areEqual(r2, this.i) == false) goto L5;
        return;
    L5:
        this.i = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.z
    public final void vc(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "currentReceiver");
        this.e.onNext(sh6.c.a(this.k.getGiftPanelTopBar()));
    }
}
