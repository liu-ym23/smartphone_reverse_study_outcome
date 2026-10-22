package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends BaseMVIDataStore<d> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] f = null;
    public final ReadOnlyProperty e;

    static {
        f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(d.class, "currentSelectedCard", "getCurrentSelectedCard()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0))};
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public d() {
        this.e = i(vh7.f.c(com.bytedance.android.livesdk.gift.model.n.class)).a().a(f[0]);
    }
}
