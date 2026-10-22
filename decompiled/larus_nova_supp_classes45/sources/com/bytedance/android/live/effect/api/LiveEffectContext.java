package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.core.utils.FileUtils;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveEffectContext {
    public static final List<String> h = null;
    public Boolean a;
    public boolean b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final LiveEffectContextFactoryDelegate$Type g;

    public static final class a {
        @JvmStatic
        public static LiveEffectContext a(LiveEffectContextFactoryDelegate$Type r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Map<LiveEffectContextFactoryDelegate$Type, LiveEffectContext> r1 = b0.a;
            Intrinsics.checkNotNullParameter(r2, "type");
            EnumMap r0 = (EnumMap) b0.a;
            if (r0.containsKey(r2) == true) goto L5;
        L6:
            r0.put(r2, new LiveEffectContext(r2));
        L7:
            Object r3 = r0.get(r2);
            Intrinsics.checkNotNull(r3);
            return (LiveEffectContext) r3;
        L5:
            if (r0.get(r2) != null) goto L7;
            goto L6
        }
    }

    @JvmStatic
    public static final LiveEffectContext f(LiveEffectContextFactoryDelegate$Type r0) {
        return a.a(r0);
    }

    public final e c() {
        return (e) this.d.getValue();
    }

    public final EffectManager d() {
        return (EffectManager) this.c.getValue();
    }

    static {
        h = CollectionsKt.listOf(new String[]{d0.i, FileUtils.BEAUTY, d0.a, d0.k, "livebody", d0.c});
    }

    public final j b() {
        Map<LiveEffectContextFactoryDelegate$Type, LiveEffectContext> r0 = b0.a;
        LiveEffectContextFactoryDelegate$Type r1 = this.g;
        Intrinsics.checkNotNullParameter(r1, "type");
        EnumMap r2 = (EnumMap) b0.b;
        if (r2.containsKey(r1) == true) goto L5;
    L6:
        r2.put(r1, new com.bytedance.android.live.effect.j(r1));
    L7:
        Object r3 = r2.get(r1);
        Intrinsics.checkNotNull(r3);
        return (j) r3;
    L5:
        if (r2.get(r1) != null) goto L7;
        goto L6
    }

    public final ILiveEffectComposerManager a() {
        return c().c();
    }

    public final c e() {
        return c().hostService();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.g;
    }

    public LiveEffectContext(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.g = r2;
        this.b = true;
        this.c = LazyKt.lazy(new LiveEffectContext$effectManager$2(this));
        this.d = LazyKt.lazy(new LiveEffectContext$baseEffectContext$2(this));
        this.e = LazyKt.lazy(new LiveEffectContext$baseEffectService$2(this));
        this.f = LazyKt.lazy(LiveEffectContext$baseProxy$2.INSTANCE);
    }
}
