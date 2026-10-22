package com.bytedance.android.livesdk.dslservice.gecko;

import android.os.SystemClock;
import com.bytedance.android.livesdk.dslservice.util.DSLMonitor;
import com.bytedance.android.livesdk.dslservice.util.f;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GeckoUtils$loadAsyncFromGecko$1 implements OfflineResourceClient.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Ref.ObjectRef e;

    @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.b
    public final void a(final d1 r9) {
        if (r9 == null) goto L4;
        String r0 = r9.b;
    L5:
        if (r0 != null) goto L8;
        com.bytedance.android.livesdk.dslservice.util.a.d.d(new GeckoUtils$loadAsyncFromGecko$1$onSuccess$1(this));
        return;
    L8:
        com.bytedance.android.livesdk.dslservice.util.a.d.d(new GeckoUtils$loadAsyncFromGecko$1$onSuccess$2(this, r9));
        ResourceFrom r1 = r9.d;
        if (r1 == ResourceFrom.GECKO) goto L11;
    L13:
        ResourceFrom r2 = ResourceFrom.CDN;
        if (r1 == r2) goto L16;
    L18:
        if (r1 != r2) goto L20;
        String r3 = "RemoteData";
    L21:
        DSLMonitor.g("ttlive_dsl_load_from_gecko_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", "0"), TuplesKt.to("from", r3), TuplesKt.to("dslType", this.a)}), 0, SystemClock.uptimeMillis() - this.c);
        GeckoUtils.a.remove(this.d);
        a r4 = (a) this.e.element;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r0);
        boolean r10 = r9.e;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "file");
        Intrinsics.checkNotNullParameter(r3, "loadFromType");
        Iterator<b> r6 = r4.a.iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        b r7 = r6.next();
        com.bytedance.android.livesdk.dslservice.util.a.d.d(GeckoLoadRequest$onSuccess$1$1.INSTANCE);
        r7.a.invoke(r5, Boolean.valueOf(r10), r3);
        goto L23
    L25:
        return;
    L20:
        r3 = "UnKnown";
        goto L21
    L16:
        if (r9.e == false) goto L18;
        r3 = "LocalCdnCacheData";
        goto L21
    L11:
        if (r9.e == false) goto L13;
        r3 = "LocalRawData";
        goto L21
    L4:
        r0 = null;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.b
    public final void onError(final Throwable r8) {
        com.bytedance.android.livesdk.dslservice.util.a r0 = com.bytedance.android.livesdk.dslservice.util.a.d;
        Map r2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("result", "1"), TuplesKt.to("dslType", this.a)});
        r0.getClass();
        DSLMonitor.g("ttlive_dsl_load_from_gecko_result", r2, 1, 0);
        Function1<f, Unit> r3 = new GeckoUtils$loadAsyncFromGecko$1$onError$1(this, r8);
        Intrinsics.checkNotNullParameter(r3, "initBlock");
        r0.e(2, r3);
        GeckoUtils.a.remove(this.d);
        Iterator<b> r1 = ((a) this.e.element).a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        b r4 = r1.next();
        com.bytedance.android.livesdk.dslservice.util.a.d.d(GeckoLoadRequest$onError$1$1.INSTANCE);
        r4.b.invoke(r8);
        goto L4
    }

    public GeckoUtils$loadAsyncFromGecko$1(String r1, String r2, long r3, String r5, Ref.ObjectRef r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
    }
}
