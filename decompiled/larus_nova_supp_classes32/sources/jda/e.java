package jda;

import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import hda.e1;
import hda.s0;
import hda.t0;
import hda.t1;
import hda.u;
import hda.u0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
        return r3.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r14) {
        g r15 = (g) r14;
        Intrinsics.checkNotNullParameter(r15, "record");
        e1 r0 = r15.g;
        Intrinsics.checkNotNullParameter(r0, "uiModel");
        String r1 = r0.h;
        if (r1 == null) goto L20;
        Function1 r3 = null;
        if ((!StringsKt.isBlank(r1)) == false) goto L7;
        String r5 = r1;
    L8:
        if (r5 == null) goto L20;
        CardTemplateTagTone r6 = CardTemplateTagTone.NEUTRAL;
        int r7 = 2131235865;
        final String r2 = r0.i;
        if (r2 != null) goto L13;
    L19:
        List r4 = CollectionsKt.listOf(new com.obric.assistant.cocreationreview.c(r5, r6, r7, r3, 94, null, null, 196));
    L22:
        return CollectionsKt.plus(r4, u0.b(r15.g));
    L13:
        if ((!StringsKt.isBlank(r2)) == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L19;
        r3 = new t0(r2);
        goto L19
    L7:
        r5 = null;
    L20:
        r4 = CollectionsKt.emptyList();
        goto L22
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
        return r3.e;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.d;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r14, a5 r15) {
        g r16 = (g) r14;
        Intrinsics.checkNotNullParameter(r16, "record");
        Intrinsics.checkNotNullParameter(r15, "feedback");
        int r0 = u.a;
        l5 r1 = c.a;
        String r2 = r16.a;
        String r3 = r16.e;
        String r4 = r16.c;
        e1 r6 = r16.g;
        return u.f(r1, r2, r3, r4, r15, r6, false, t1.a(r4, r6.h), null, null, null, 7808);
    }
}
