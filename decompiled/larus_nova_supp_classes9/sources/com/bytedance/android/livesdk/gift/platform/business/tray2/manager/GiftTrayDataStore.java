package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.gift.tray.DialogStatus;
import com.bytedance.android.live.gift.tray.RelativeEnterAnimPos;
import com.bytedance.android.live.gift.tray.TrayMode;
import com.bytedance.android.scope.o;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftTrayDataStore extends BaseMVIDataStore<GiftTrayDataStore> implements ia0.b, o {
    public static final /* synthetic */ KProperty[] k = null;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final ReadOnlyProperty g;
    public final t h;
    public final k i;
    public final com.bytedance.android.live.revenue.core.a j;

    static {
        k = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTrayDataStore.class, "currentTrayMode", "getCurrentTrayMode()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTrayDataStore.class, "currentDialogStatus", "getCurrentDialogStatus()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTrayDataStore.class, "defaultTrayMargin", "getDefaultTrayMargin()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTrayDataStore.class, "_trayMode", "get_trayMode()Ljava/util/Map;", 0))};
    }

    public final t<GiftTrayDataStore, Map<TrayMode, Pair<Integer, RelativeEnterAnimPos>>> k() {
        return (t) this.e.getValue(this, k[0]);
    }

    public final Map<TrayMode, Pair<Integer, RelativeEnterAnimPos>> n() {
        return (Map) this.h.getValue(this, k[3]);
    }

    public final void onStop() {
    }

    public final void onStart() {
        com.bytedance.android.live.revenue.core.a r0 = this.j;
        r0.b(ia0.b.class, r0.getScope());
    }

    public final Pair<Integer, RelativeEnterAnimPos> Y5() {
        Map.Entry r0 = z0.a(n());
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Pair) r0.getValue();
    }

    public final void ba(final TrayMode r2) {
        Intrinsics.checkNotNullParameter(r2, "trayMode");
        g("removeTrayMode", new GiftTrayDataStore$removeCurrentTrayMode$1(this, r2));
    }

    public final void m2(final int r2) {
        g("changeMargin", new GiftTrayDataStore$changeDefaultTrayMargin$1(this, r2));
    }

    public GiftTrayDataStore(k r3, com.bytedance.android.live.revenue.core.a r4) {
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "inst");
        this.i = r3;
        this.j = r4;
        com.bytedance.android.anya.internal.k r5 = i(MapsKt.emptyMap()).a();
        KProperty[] r6 = k;
        this.e = r5.a(r6[0]);
        this.f = i(TuplesKt.to(DialogStatus.DIALOG_CLOSE, 0)).a().a(r6[1]);
        this.g = i(Integer.valueOf((int) s1.getContext().getResources().getDimension(2131168683))).a().a(r6[2]);
        this.h = k();
    }

    public final void Gh(final DialogStatus r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "status");
        g("changeDialogStatus", new GiftTrayDataStore$changeCurrentDialogStatus$1(this, r2, r3));
    }

    public final boolean K1(final TrayMode r9, final int r10, final RelativeEnterAnimPos r11) {
        Intrinsics.checkNotNullParameter(r9, "trayMode");
        Intrinsics.checkNotNullParameter(r11, "relativeEnterAnimPos");
        if (n().isEmpty() == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
    L20:
        if (r0 == true) goto L22;
        return false;
    L22:
        g("changeMode", new GiftTrayDataStore$changeCurrentMode$1(this, r9, r10, r11));
        if (n().size() <= 1) goto L27;
        return false;
    L27:
        return true;
    L13:
        if (v.a() == true) goto L15;
    L19:
        jy0.b.c("current GiftTray Mode is conflicted, currentTrayMode has " + n().keySet() + ", and try to addMode " + r9, null, null, 6);
        goto L20
    L15:
        if (((Boolean) e.b.getValue(null, e.a[0])).booleanValue() == false) goto L19;
        throw new IllegalStateException("current GiftTray Mode is conflicted, currentTrayMode has " + n().keySet() + ", and try to addMode " + r9);
    L5:
        if (n().containsKey(r9) == true) goto L7;
    L9:
        r0 = false;
        goto L11
    L7:
        if (n().size() != 1) goto L9;
        goto L9
    }
}
