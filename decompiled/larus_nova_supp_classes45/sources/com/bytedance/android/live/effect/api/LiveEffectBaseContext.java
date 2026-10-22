package com.bytedance.android.live.effect.api;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.kq;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.link.model.host.Host;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveEffectBaseContext implements e {
    public static final List<Host> e = null;
    public final Lazy a;
    public c b;
    public String c;
    public final LiveEffectContextFactoryDelegate$Type d;

    public static final class a {
    }

    @Override // com.bytedance.android.live.effect.api.e
    public final EffectManager getEffectManager() {
        return (EffectManager) this.a.getValue();
    }

    static {
        e = CollectionsKt.listOf(new Host("https://effect.snssdk.com"));
    }

    public static EffectConfiguration.Builder e() {
        final IHostContext r0 = jc1.k.n(IHostContext.class);
        final Context r1 = r0.context();
        final EffectConfiguration.Builder r2 = new EffectConfiguration.Builder();
        final kjc.c r3 = new kjc.c();
        com.bytedance.android.livesdk.paas.a.a(r3, new LiveEffectBaseContext$getEffectConfigurationBuilder$$inlined$call$lambda$1(r3, r0, r2, r1));
        if (r3.b == true) goto L9;
        kjc.b r4 = r3.a;
        if (((Boolean) kq.a.getValue()).booleanValue() == false) goto L7;
        String r5 = "online";
    L8:
        r2.accessKey("142710f02c3a11e8b42429f14557854a").appVersion(jc1.k.n(IHostContext.class).getVersionName()).sdkVersion("16.5.0").channel(r5).effectDir(new PolarisFileWrapper(r1.getFilesDir(), "effect/")).effectNetWorker(new com.bytedance.android.live.effect.utils.d()).hosts(e);
        r4.a = Unit.INSTANCE;
        goto L9
    L7:
        r5 = jc1.k.n(IHostContext.class).getChannel();
    L9:
        Object r6 = r3.a.a;
        r2.platform("android").deviceType(Build.MODEL).retryCount(3).JsonConverter(new com.bytedance.android.live.effect.utils.l()).context(r1);
        return r2;
    }

    @Override // com.bytedance.android.live.effect.api.e
    public final String a() {
        if (this.c != null) goto L5;
        this.c = s1.getContext().getDir("ttlive_effect_model", 0).getAbsolutePath() + File.separator;
    L5:
        String r0 = this.c;
        if (r0 != null) goto L9;
        return "";
    L9:
        return r0;
    }

    @Override // com.bytedance.android.live.effect.api.e
    public final ILiveEffectComposerManager c() {
        Map<LiveEffectContextFactoryDelegate$Type, e> r0 = u.a;
        return u.c(this.d);
    }

    @Override // com.bytedance.android.live.effect.api.e
    public final g d() {
        Map<LiveEffectContextFactoryDelegate$Type, e> r0 = u.a;
        return u.b(this.d);
    }

    @Override // com.bytedance.android.live.effect.api.e
    public final c hostService() {
        if (this.b != null) goto L5;
        this.b = new j90.a();
    L5:
        c r0 = this.b;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public LiveEffectBaseContext(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.d = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new LiveEffectBaseContext$effectManager$2(this));
    }

    @Override // com.bytedance.android.live.effect.api.e
    public final void b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        this.b = r2;
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_BEAUTY_OUTER_TEST.getValue().booleanValue() == false) goto L6;
        d().e().k(this.d);
        return;
    }
}
