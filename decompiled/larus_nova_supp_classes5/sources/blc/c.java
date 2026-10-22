package blc;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.download.DownloadType;
import com.ss.ugc.effectplatform.download.f;
import com.ss.ugc.effectplatform.download.h;
import com.ss.ugc.effectplatform.download.i;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.task.o1;
import com.ss.ugc.effectplatform.task.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c implements a {
    public final EffectConfig a;

    public c(EffectConfig r1) {
        this.a = r1;
    }

    @Override // blc.a
    public final o1<nlc.a> a(b r4) {
        f.a r0 = new f.a();
        Object r1 = this.a.u.a;
        if (r1 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r0.b = (INetworkClient) r1;
        r0.d = new h(r4, this.a);
        Effect r2 = r4.a;
        r0.a = new i(r2);
        r0.e = r2.getZipPath();
        r0.c = DownloadType.EFFECT;
        return new y(r4, r0.a(), this.a);
    }
}
