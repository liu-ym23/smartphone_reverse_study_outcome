package sn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements l {
    public final ProducerResStep a;
    public final n.c b;

    public k(n.c r2) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.b = r2;
        this.a = ProducerResStep.LocalCache;
    }

    public final void b(pn0.d.a r3, String r4) {
        StringBuilder r5 = r3.a;
        r5.append("\n");
        r5.append("step: " + this.a + ", content: " + r4);
    }

    @Override // sn0.l
    public final void a(pn0.d r6, pn0.g r7, a r8) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r8, "consumer");
        if (this.b.b.d().a == false) goto L8;
        String r0 = this.b.b.c().c().a(r6, r7);
        LayoutConfigModel r1 = this.b.a.get(r0);
        if (r1 == null) goto L7;
        b(r6.e(), "tryLoadFromCache success, found in localCache, cacheKey = " + r0);
        r8.b(r6, r7, r1.a(), this.a);
        return;
    L7:
        b(r6.e(), "tryLoadFromCache success, not found in localCache!!! cacheKey = " + r0);
        r8.c(r6, r7);
        return;
    L8:
        b(r6.e(), "localCacheProducer is banned by setting!!!");
        r8.c(r6, r7);
    }
}
