package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftScrollDataStore extends BaseMVIDataStore<GiftScrollDataStore> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] h = null;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final com.bytedance.android.anya.t g;

    static {
        h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftScrollDataStore.class, "currentIsFirstScreen", "getCurrentIsFirstScreen()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftScrollDataStore.class, "currentSelectedGiftIsShow", "getCurrentSelectedGiftIsShow()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftScrollDataStore.class, "_currentSelectedGiftIsShow", "get_currentSelectedGiftIsShow()Z", 0))};
    }

    public final com.bytedance.android.anya.t<GiftScrollDataStore, HashMap<Integer, Boolean>> k() {
        return (com.bytedance.android.anya.t) this.e.getValue(this, h[0]);
    }

    public final com.bytedance.android.anya.t<GiftScrollDataStore, Boolean> n() {
        return (com.bytedance.android.anya.t) this.f.getValue(this, h[1]);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean f() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.a();
    }

    public GiftScrollDataStore() {
        com.bytedance.android.anya.internal.k r0 = i(new HashMap()).a();
        KProperty[] r1 = h;
        this.e = r0.a(r1[0]);
        this.f = i(Boolean.TRUE).a().a(r1[1]);
        this.g = n();
    }

    public final void q(final boolean r4) {
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.A.E8() == true) goto L5;
    L7:
        g("onGiftShowRangeChanged", new GiftScrollDataStore$onSelectedGiftIsShowChanged$1(this, r4));
        return;
    L5:
        if (((Boolean) this.g.getValue(this, h[2])).booleanValue() != r4) goto L7;
    }

    public final void o(final int r2, final boolean r3) {
        g("onFirstScreenChanged", new GiftScrollDataStore$onFirstScreenChanged$1(this, r3, r2));
    }
}
