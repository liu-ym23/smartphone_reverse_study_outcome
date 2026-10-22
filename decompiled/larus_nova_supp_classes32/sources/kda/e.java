package kda;

import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import hda.e1;
import hda.s0;
import hda.t1;
import hda.u;
import hda.u0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends s0<g> {
    public static final e b = null;

    static {
        b = new e();
    }

    public e() {
        super(c.a);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.i;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return u0.b(r3.h);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.c;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.f;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.d;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String l(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.e;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r14, a5 r15) {
        g r16 = (g) r14;
        Intrinsics.checkNotNullParameter(r16, "record");
        Intrinsics.checkNotNullParameter(r15, "feedback");
        int r0 = u.a;
        l5 r1 = c.a;
        String r2 = r16.a;
        String r3 = r16.f;
        String r4 = r16.c;
        e1 r6 = r16.h;
        return u.f(r1, r2, r3, r4, r15, r6, false, t1.a(r4, r6.h), null, null, null, 7808);
    }
}
