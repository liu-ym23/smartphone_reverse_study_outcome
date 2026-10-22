package com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere;

import android.view.ViewGroup;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.internal.MVIBindingImpl;
import com.bytedance.android.anya.internal.h;
import com.bytedance.android.anya.internal.k;
import com.bytedance.android.anya.t;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.message.model.l6;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.n;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AtmosphereDataStore extends BaseMVIDataStore<AtmosphereDataStore> implements o {
    public static final /* synthetic */ KProperty[] n = null;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final ReadOnlyProperty g;
    public final ReadOnlyProperty h;
    public MVIBindingImpl i;
    public AtmosphereFacade j;
    public final t k;
    public final t l;
    public final i12.e m;

    static {
        n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AtmosphereDataStore.class, "currentPlayEffect", "getCurrentPlayEffect()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(AtmosphereDataStore.class, "activityInformation", "getActivityInformation()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(AtmosphereDataStore.class, "playEndTime", "getPlayEndTime()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(AtmosphereDataStore.class, "currentLogInformation", "getCurrentLogInformation()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(AtmosphereDataStore.class, "_currentPlayData", "get_currentPlayData()Lkotlin/Pair;", 0)), Reflection.property1(new PropertyReference1Impl(AtmosphereDataStore.class, "_currentLogData", "get_currentLogData()Ljava/util/Map;", 0))};
    }

    public final t<AtmosphereDataStore, Pair<Long, String>> n() {
        return (t) this.e.getValue(this, n[0]);
    }

    public final Pair<Long, String> o() {
        return (Pair) this.k.getValue(this, n[4]);
    }

    public final void onStart() {
    }

    public final void onStop() {
        MVIBindingImpl r0 = this.i;
        if (r0 == null) goto L5;
        r0.unbind();
    L5:
        this.i = null;
    }

    public AtmosphereDataStore(i12.e r4) {
        Intrinsics.checkNotNullParameter(r4, "giftScope");
        this.m = r4;
        k r5 = i(new Pair(-1L, BuildConfig.FLAVOR)).a();
        KProperty[] r0 = n;
        this.e = r5.a(r0[0]);
        this.f = i(BuildConfig.FLAVOR).a().a(r0[1]);
        this.g = i(0L).a().a(r0[2]);
        h r6 = i(MapsKt.emptyMap()).a().a(r0[3]);
        this.h = r6;
        this.k = n();
        this.l = (t) r6.getValue(this, r0[3]);
    }

    public final void k(long r4, boolean r6) {
        if (((Number) o().getFirst()).longValue() == r4) goto L5;
        if (r6 == true) goto L5;
        return;
    L5:
        g(null, new AtmosphereDataStore$closeEffect$1(this));
    }

    public final void q(final l6 r8, final String r9) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        Intrinsics.checkNotNullParameter(r9, "path");
        final Pair<Long, String> r0 = o();
        if (r8.getAssetId() > 0) goto L5;
    L20:
        g(null, new AtmosphereDataStore$updatePlayEffect$2(this, r0, r8, r9));
        return;
    L5:
        if (this.i != null) goto L20;
        this.j = (AtmosphereFacade) m.e.d(this.m, AtmosphereFacade.class);
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L11;
        n<ViewGroup> r2 = r1.getAtmosphereContainer();
        if (r2 == null) goto L11;
        ViewGroup r3 = (ViewGroup) r2.getValue();
    L12:
        if (r3 == null) goto L20;
        c r4 = new c(r3.getContext());
        r3.addView(r4.h);
        AtmosphereFacade r5 = this.j;
        if (r5 == null) goto L16;
        MVIBindingImpl r6 = r5.c(r4, f.class);
    L17:
        this.i = r6;
        if (r6 == null) goto L20;
        r6.a();
        goto L20
    L16:
        r6 = null;
    L11:
        r3 = null;
        goto L12
    }
}
