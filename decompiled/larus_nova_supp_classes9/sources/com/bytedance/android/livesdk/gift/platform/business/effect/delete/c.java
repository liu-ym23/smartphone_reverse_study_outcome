package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements dy0.c, com.bytedance.android.scope.o {
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.delete.a> a;
    public com.bytedance.android.livesdk.gift.configmodel.m b;
    public boolean c;
    public final a d;
    public final ResourceRecordService e;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.j f;
    public final GiftResourceFileCacheService g;

    public static final class a implements sq2.a {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void a(boolean r5) {
            Iterator r0 = ((ArrayList) this.a.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            com.bytedance.android.livesdk.gift.platform.business.effect.delete.a r1 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) r0.next();
            if (r5 == false) goto L10;
            if (this.a.c == true) goto L10;
            r1.a(CleanOpportunity.EXIT_THE_BACKGROUND, null);
        L10:
            r1.e(CleanOpportunity.EXIT_THE_BACKGROUND);
            goto L4
        }
    }

    public final long a() {
        List<com.bytedance.android.livesdk.gift.platform.business.effect.delete.a> r0 = this.a;
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.gift.platform.business.effect.delete.a r1 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) CollectionsKt.first(r0);
        if (r1 == null) goto L10;
        return r1.c();
    L10:
        return 0;
    }

    public final void onStop() {
        com.bytedance.android.live.revenue.core.util.f.a(ly0.a.class).o5(this.d);
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) r0.next()).destroy();
        goto L4
    }

    public final void onStart() {
        com.bytedance.android.livesdk.gift.configmodel.m r0 = com.bytedance.android.livesdk.gift.platform.business.i.i();
        this.b = r0;
        if (r0.getEnable() == false) goto L11;
        jy0.b.c("GiftAssetClean", "enable is true, " + this.b.K8().size(), null, 4);
        com.bytedance.android.live.revenue.core.util.f.a(ly0.a.class).y0(this.d);
        if (this.b.getEnable() == false) goto L14;
        ((ArrayList) this.a).add(new LRUCleanStrategy(this.e, this.f, this.g));
        Iterator r1 = ((ArrayList) this.a).iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) r1.next()).init();
        goto L9
    L15:
        return;
    L14:
        return;
    L11:
        jy0.b.c("GiftAssetClean", "enable is false, " + this.b.K8().size(), null, 4);
    }

    public final void f(List<? extends com.bytedance.android.live.core.resources.e> r3) {
        Intrinsics.checkNotNullParameter(r3, "assetList");
        if (this.b.getEnable() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.a).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) r0.next()).d(r3);
        goto L7
    }

    public final void g(Map<String, ? extends com.bytedance.android.live.core.resources.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        if (this.b.getEnable() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.a).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) r0.next()).b(r3);
        goto L7
    }

    public c(ResourceRecordService r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r3, GiftResourceFileCacheService r4) {
        Intrinsics.checkNotNullParameter(r2, "resourceRecordService");
        Intrinsics.checkNotNullParameter(r3, "assetsService");
        Intrinsics.checkNotNullParameter(r4, "resourceFileCacheService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = new ArrayList();
        Class r5 = com.bytedance.android.livesdk.gift.configmodel.m.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r6 = vh7.b.a;
        Object r7 = r6.get(r5);
        if (r7 != null) goto L12;
        r7 = r5.getConstructor(new Class[0]);
        if (r7 == null) goto L11;
        Object r8 = r6.putIfAbsent(r5, r7);
        if (r8 == null) goto L12;
        r7 = r8;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r9 = ((SerializableObjectJsonAdapterBase) ((Constructor) r7).newInstance(new Object[0])).createInstance();
        if (r9 == null) goto L17;
        this.b = (com.bytedance.android.livesdk.gift.configmodel.m) r9;
        this.d = new a(this);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.CleanStrategyConfig");
    }
}
