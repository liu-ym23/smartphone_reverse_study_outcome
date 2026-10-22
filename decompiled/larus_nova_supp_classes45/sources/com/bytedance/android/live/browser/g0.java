package com.bytedance.android.live.browser;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 extends BaseJsBridgeMethodFactory {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
    }

    public final Map<String, n56.c> provideLegacyMethods(IJsBridgeManager r5) {
        Intrinsics.checkNotNullParameter(r5, "manager");
        e30.d r1 = new e30.d(new WeakReference(r5.getActivity()));
        r1.b = new WeakReference(r5.getJsBridge2());
        Unit r6 = Unit.INSTANCE;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("openHotsoon", new e30.d(new WeakReference(r5.getActivity()))), TuplesKt.to("openLive", r1)});
    }
}
