package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class JsDriverBridgeFactory implements wy0.f {

    public static final class a extends com.bytedance.android.annie.lynx.f {
        public final /* synthetic */ Disposable b;

        public final void onRelease() {
            this.b.dispose();
        }

        public a(Disposable r1) {
            this.b = r1;
            super(null);
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ RevenueJsDriver a;

        public b(RevenueJsDriver r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            com.bytedance.platform.aio.channel.js.c r0 = this.a.d;
            KProperty[] r1 = e0.a;
            Intrinsics.checkNotNullParameter(r0, "$this$convertToStatefulMethod");
            return new d0(r0);
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ RevenueJsDriver a;

        public c(RevenueJsDriver r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            com.bytedance.platform.aio.channel.js.c r0 = this.a.e;
            KProperty[] r1 = e0.a;
            Intrinsics.checkNotNullParameter(r0, "$this$convertToStatefulMethod");
            return new d0(r0);
        }
    }

    public JsDriverBridgeFactory() {
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r9) {
        Intrinsics.checkNotNullParameter(r9, "manager");
        final BaseHybridComponent r0 = r9.c();
        if (r0 == null) goto L5;
        IHybridComponent.HybridType r1 = r0.hybridType();
    L7:
        if (r1 == IHybridComponent.HybridType.LYNX) goto L11;
        return MapsKt.emptyMap();
    L11:
        if ((r0 instanceof BaseHybridComponent) == false) goto L15;
        Pair r10 = w.b(new o0(new az0.a(r9), new JsDriverBridgeFactory$provideStatefulMethods$1(r0)), new com.bytedance.android.live.revenue.platform.hybrid.impl.component.b(r0), r9.getActivity(), null, new JsDriverBridgeFactory$provideStatefulMethods$2(r0), 8);
        Disposable r2 = (Disposable) r10.component1();
        RevenueJsDriver r12 = (RevenueJsDriver) r10.component2();
        r0.registerLifecycleCallback(new a(r2));
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("rpcChannelMessage", new b(r12)), TuplesKt.to("rpcChannelMessageV2", new c(r12))});
    L15:
        return MapsKt.emptyMap();
    L5:
        r1 = null;
        goto L7
    }

    @Override // wy0.d
    public final Map<String, wy0.h<Object, ?>> c(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.a(r2);
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> d(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.emptyMap();
    }

    @Override // wy0.d
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.b(r2);
    }
}
