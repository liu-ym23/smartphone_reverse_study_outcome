package ida;

import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import hda.e1;
import hda.s0;
import hda.t1;
import hda.u0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends s0<u> {
    public static final k b = null;

    static {
        b = new k();
    }

    public k() {
        super(c.a);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        u r3 = (u) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.n;
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [ida.h] */
    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r11) {
        final u r12 = (u) r11;
        Intrinsics.checkNotNullParameter(r12, "record");
        if (r12.l == false) goto L5;
        List r0 = CollectionsKt.listOf(new com.obric.assistant.cocreationreview.c("原始录音", CardTemplateTagTone.NEUTRAL, 2131235867, null, null, null, new h(r12), 116));
    L7:
        return CollectionsKt.plus(r0, u0.b(r12.m));
    L5:
        r0 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r2) {
        u r3 = (u) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.c;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r2) {
        u r3 = (u) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.f;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r2) {
        u r3 = (u) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.d;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String l(com.obric.assistant.cocreationreview.a r2) {
        Intrinsics.checkNotNullParameter((u) r2, "record");
        return null;
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [ida.g] */
    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r14, a5 r15) {
        final u r16 = (u) r14;
        Intrinsics.checkNotNullParameter(r16, "record");
        Intrinsics.checkNotNullParameter(r15, "feedback");
        int r0 = hda.u.a;
        l5 r1 = c.a;
        String r2 = r16.a;
        String r3 = r16.f;
        String r4 = r16.c;
        e1 r5 = r16.m;
        String r6 = r16.g;
        if ((!StringsKt.isBlank(r6)) == false) goto L5;
        String r8 = r6;
    L7:
        return hda.u.f(r1, r2, r3, r4, r15, e1.a(r5, r6, r16.g, r8, null, 1044455), true, t1.a(r16.c, null), null, new f(r16), new g(r16), 1664);
    L5:
        r8 = null;
        goto L7
    }
}
