package com.bytedance.android.live.broadcast.effect;

import am2.w;
import am2.z;
import com.bytedance.android.live.broadcast.api.model.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.n;
import com.bytedance.android.live.effect.api.t;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import java.util.HashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class EffectHostLiveService implements com.bytedance.android.live.effect.api.c {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final String f;
    public final Lazy g;

    @Override // com.bytedance.android.live.effect.api.c
    public final DownloadableModelConfig b() {
        IDownloadableModelConfigService r0 = (IDownloadableModelConfigService) k.f(IDownloadableModelConfigService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadModelConfig();
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final t c() {
        return (a) this.b.getValue();
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final n e() {
        return (b) this.a.getValue();
    }

    public EffectHostLiveService() {
        this.a = LazyKt.lazy(new EffectHostLiveService$touchHandler$2(this));
        this.b = LazyKt.lazy(new EffectHostLiveService$composerHandler$2(this));
        this.c = LazyKt.lazy(EffectHostLiveService$liveStickerEffect$2.INSTANCE);
        this.d = LazyKt.lazy(EffectHostLiveService$liveTouchEffect$2.INSTANCE);
        this.e = LazyKt.lazy(EffectHostLiveService$stickerReportUtil$2.INSTANCE);
        this.f = "";
        this.g = LazyKt.lazy(EffectHostLiveService$commerceEffectService$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        xs2.b.a().post(new c(r3));
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void d(boolean r4) {
        q00.a r0 = (q00.a) this.g.getValue();
        if (r0 == null) goto L5;
        r0.d(r4);
    L5:
        q00.a r5 = (q00.a) this.g.getValue();
        Boolean r1 = null;
        if (r5 == null) goto L8;
        Boolean r6 = Boolean.valueOf(r5.c());
    L9:
        boolean r7 = r6.booleanValue();
        q00.a r2 = (q00.a) this.g.getValue();
        if (r2 == null) goto L12;
        r1 = Boolean.valueOf(r2.a());
    L12:
        ALogger.d("COMMODITY_NO_FILTER", "post liveCommerceEffectEvent, unUsedEffect: " + r7 + ", commerceNoFilter: " + r1.booleanValue());
        xs2.b.a().post(new q0());
        return;
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void sendLog(String r5, HashMap<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "map");
        if (r6.get("event_page") != null) goto L5;
        r6.put("event_page", this.f);
    L5:
        u.l().sendLog(r5, r6, new Object[]{Room.class, new z(), w.class});
    }
}
