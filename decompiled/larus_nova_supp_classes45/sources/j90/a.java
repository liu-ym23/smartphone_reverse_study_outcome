package j90;

import com.bytedance.android.live.broadcast.effect.IDownloadableModelConfigService;
import com.bytedance.android.live.effect.api.n;
import com.bytedance.android.live.effect.api.t;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements com.bytedance.android.live.effect.api.c {
    public b a;
    public d b;

    public a() {
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void d(boolean r1) {
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void sendLog(String r2, HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "map");
    }

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
        if (this.a != null) goto L5;
        this.a = new b();
    L5:
        b r0 = this.a;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final n e() {
        if (this.b != null) goto L5;
        this.b = new d();
    L5:
        d r0 = this.b;
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
