package rn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;
import pn0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements sn0.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ LayoutConfigModel b;
    public final /* synthetic */ ProducerResStep c;
    public final /* synthetic */ on0.a d;

    @Override // sn0.a
    public final void c(pn0.d r9, g r10) {
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "modifiedRequestParams");
        this.a.e(r9, this.b, null, r10, this.c, this.d);
    }

    public d(b r1, LayoutConfigModel r2, ProducerResStep r3, on0.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // sn0.a
    public final void b(pn0.d r8, g r9, LayoutConfigModel r10, ProducerResStep r11) {
        Intrinsics.checkNotNullParameter(r8, "request");
        Intrinsics.checkNotNullParameter(r9, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r10, "offsetLayoutConfigModel");
        Intrinsics.checkNotNullParameter(r11, "offsetStep");
        b r12 = this.a;
        String r0 = r12.g.d.c().b(r8, r9);
        if (r12.f.containsKey(r0) == true) goto L5;
        LayoutConfigModel r1 = r10.a();
        r12.f.put(r0, r1);
    L5:
        zg0.a r13 = this.a.g.d.c();
        LayoutConfigModel r2 = this.b;
        r13.f(r8, r9, r2, r10);
        this.a.e(r8, r2, r10, r9, this.c, this.d);
    }
}
