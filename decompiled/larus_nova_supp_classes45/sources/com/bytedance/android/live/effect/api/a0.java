package com.bytedance.android.live.effect.api;

import com.ss.android.ugc.effectmanager.EffectManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 implements i {
    public final LiveEffectContextFactoryDelegate$Type a;

    @Override // com.bytedance.android.live.effect.api.i
    public final String a() {
        Map<LiveEffectContextFactoryDelegate$Type, e> r0 = u.a;
        return u.a(this.a).a();
    }

    @Override // com.bytedance.android.live.effect.api.i
    public final h0 b() {
        Map<LiveEffectContextFactoryDelegate$Type, e> r1 = u.a;
        return new h0(u.c(this.a));
    }

    @Override // com.bytedance.android.live.effect.api.i
    public final i0 c() {
        return new i0(this.a);
    }

    @Override // com.bytedance.android.live.effect.api.i
    public final EffectManager getEffectManager() {
        Map<LiveEffectContextFactoryDelegate$Type, e> r0 = u.a;
        return u.a(this.a).getEffectManager();
    }

    public a0(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
    }
}
