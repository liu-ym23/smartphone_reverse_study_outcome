package com.bytedance.android.live.revenue.platform.container.impl.core;

import android.content.Context;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NativeHostServiceImpl extends com.bytedance.android.live.revenue.platform.container.impl.core.a implements f80.a {
    public final Lazy d;
    public final vy0.c e;

    public static final class a {
        public static final a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    public final void onStart() {
        if (v.a() == true) goto L6;
        com.bytedance.platform.aio.b.a r0 = com.bytedance.platform.aio.b.a;
        oy0.a r1 = oy0.a.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        com.bytedance.platform.aio.b.a.a = r1;
        return;
    }

    public NativeHostServiceImpl(vy0.c r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "hybridService");
        Intrinsics.checkNotNullParameter(r3, "centerDriverService");
        super(r3);
        this.e = r2;
        this.d = LazyKt.lazy(NativeHostServiceImpl$shareViewService$2.INSTANCE);
    }

    public final l b0(Context r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        l r0 = this.b;
        if (r0 != null) goto L18;
        vy0.c r1 = this.e;
        int r2 = com.bytedance.revenue.platform.api.core.e.a;
        ReadOnlyProperty r3 = b.c;
        KProperty[] r4 = b.a;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r10 = r1.q8(r8, com.bytedance.revenue.platform.api.core.e.a((String) r3.getValue(null, r4[1])).buildUpon().appendQueryParameter("revenue_service_urls", GsonProtectorUtils.toJson(l97.a.a, (List) b.d.getValue(null, r4[2]))).build(), new NativeHostServiceImpl$createAnnieXCard$center$1(this, r9));
        if (r10 == null) goto L17;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r12 = r10.d;
        Iterator<T> r5 = ((com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a) this.d.getValue()).getMethods().iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e r6 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e) r5.next();
        if ((r6 instanceof com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.a) == true) goto L11;
        if ((r6 instanceof com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b) == false) goto L8;
        String r7 = r6.a;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b r13 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b) r6;
        r12.registerMethod(r7, null);
        goto L8
    L11:
        r12.registerMethod(r6.a, ((com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.a) r6).b);
        goto L8
    L15:
        ReadOnlyProperty r14 = k.c;
        KProperty[] r15 = k.a;
        r12.b(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("live_service_center_reuse", Boolean.valueOf(k.a())), TuplesKt.to("live_service_center_aiolink_async", Boolean.valueOf(((Boolean) r14.getValue(null, r15[1])).booleanValue())), TuplesKt.to("live_redpacket_service_lazy_load", Boolean.valueOf(((Boolean) k.d.getValue(null, r15[2])).booleanValue()))}));
        g r16 = this.c;
        RevenueJsDriver r17 = r10.b;
        Intrinsics.checkNotNull(r17);
        r16.L0(r17);
        l r18 = new l(r10.b, r10);
        this.b = r18;
        return r18;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.hybrid.impl.ui.AnnieXCardImpl");
    L18:
        return r0;
    }

    public final void w0(h r2, com.bytedance.android.scope.j r3) {
        Intrinsics.checkNotNullParameter(r2, "centerServiceManager");
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a.put(r3, r2);
        if (k.a() == true) goto L8;
        zy0.b r4 = r2.D();
        if (r4 == null) goto L9;
        this.b = new l(r2.c(), r4);
        return;
    L9:
        return;
    }
}
