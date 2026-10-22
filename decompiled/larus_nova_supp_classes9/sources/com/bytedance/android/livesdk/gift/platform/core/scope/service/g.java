package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.AssetsFileCacheFactory;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements SingleOnSubscribe {
    public final /* synthetic */ d a;
    public final /* synthetic */ com.bytedance.android.live.core.resources.e b;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e c;

    public g(d r1, com.bytedance.android.live.core.resources.e r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        HashMap<String, d.a> r9 = this.a.a;
        monitor-enter(r9);
        com.bytedance.android.live.core.resources.b r0 = this.b.getCleanStrategy();     // Catch: Throwable -> L28
        if (r0 == null) goto L8;
        String r1 = r0.getAssetType();     // Catch: Throwable -> L28
        if (r1 == null) goto L8;
    L9:
        String r2 = new AssetsFileCacheFactory().b(this.c);     // Catch: Throwable -> L28
        int r3 = com.bytedance.android.live.revenue.common.c0.a;     // Catch: Throwable -> L28
        long r4 = com.bytedance.android.live.revenue.common.c0.a(new PolarisFileWrapper(r2)) / ((long) 1024);     // Catch: Throwable -> L28
        if (r4 > 0) goto L12;
    L25:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r9);
        return;
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.c().get(r1) == null) goto L25;
        d.a r6 = this.a.a.get(r1);     // Catch: Throwable -> L28
        if (r6 != null) goto L20;
        com.bytedance.android.livesdk.gift.configmodel.g1 r7 = com.bytedance.android.livesdk.gift.platform.business.effect.a.c().get(r1);     // Catch: Throwable -> L28
        if (r7 == null) goto L18;
        int r10 = r7.b();     // Catch: Throwable -> L28
    L19:
        r6 = new d.a(r10);     // Catch: Throwable -> L28
        goto L20
    L18:
        r10 = 1;
    L20:
        com.bytedance.android.livesdk.gift.configmodel.g1 r11 = com.bytedance.android.livesdk.gift.platform.business.effect.a.c().get(r1);     // Catch: Throwable -> L28
        if (r11 == null) goto L23;
        int r13 = r11.a();     // Catch: Throwable -> L28
    L24:
        r6.a = r13;     // Catch: Throwable -> L28
        r6.put(Long.valueOf(this.c.i), new Pair(Integer.valueOf((int) r4), r2));     // Catch: Throwable -> L28
        this.a.a.put(r1, r6);     // Catch: Throwable -> L28
        this.a.c("updateCachePool");     // Catch: Throwable -> L28
        d.a(this.a);     // Catch: Throwable -> L28
        goto L25
    L23:
        r13 = 0;
    L8:
        r1 = BuildConfig.FLAVOR;
    L28:
        th = move-exception;
        throw th;
    }
}
