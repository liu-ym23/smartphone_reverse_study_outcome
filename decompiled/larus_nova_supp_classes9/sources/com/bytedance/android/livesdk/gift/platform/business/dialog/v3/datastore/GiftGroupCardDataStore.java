package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftGroupCardDataStore extends BaseMVIDataStore<GiftGroupCardDataStore> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] h = null;
    public final ReadOnlyProperty e;
    public final com.bytedance.android.anya.t f;
    public final BehaviorSubject<sh6.b<oc6.g>> g;

    static {
        h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftGroupCardDataStore.class, "selectGroupCard", "getSelectGroupCard()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupCardDataStore.class, "_selectGroupCard", "get_selectGroupCard()Lcom/bytedance/kmp/livesdk/gift/platform/aio/service/client/GroupCardInfo;", 0))};
    }

    public final com.bytedance.android.anya.t<GiftGroupCardDataStore, oc6.g> n() {
        return (com.bytedance.android.anya.t) this.e.getValue(this, h[0]);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean f() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.a() == false) goto L7;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.A.g4() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final oc6.g k() {
        return (oc6.g) this.f.getValue(this, h[1]);
    }

    public GiftGroupCardDataStore() {
        this.e = j(null).a().a(h[0]);
        this.f = n();
        this.g = BehaviorSubject.createDefault(sh6.a.a);
    }

    public final void o(final oc6.g r2) {
        g("updateSelectGroupCard", new GiftGroupCardDataStore$updateCurrentSelectGroupCard$1(this, r2));
    }
}
