package com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends MVIState<e> {
    public static final /* synthetic */ KProperty[] c = null;
    public final r a;
    public final r b;

    static {
        c = new KProperty[]{Reflection.property1(new PropertyReference1Impl(e.class, "effectPath", "getEffectPath()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "effectInformation", "getEffectInformation()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public e() {
        Function1 r1 = ((MVIState) this).propertyChangeCallback;
        Function1 r2 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(BuildConfig.FLAVOR, r1, r2);
        KCallable[] r3 = c;
        ((com.bytedance.android.anya.internal.c) r0).a = r3[0].getName();
        r2.invoke(r0);
        this.a = r0;
        Map r4 = MapsKt.emptyMap();
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r4, r5, r6);
        ((com.bytedance.android.anya.internal.c) r7).a = r3[1].getName();
        r6.invoke(r7);
        this.b = r7;
    }
}
