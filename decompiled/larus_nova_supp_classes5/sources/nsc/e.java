package nsc;

import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.CustomCitationSpan;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.core.spans.CustomMentionSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.t;
import msc.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e extends i {
    public final hw8.b a;
    public final tsc.n b;

    public e(hw8.b r1, tsc.n r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // nsc.i, lsc.x
    public final Object a(lsc.h r8, t r9) {
        Intrinsics.checkNotNullParameter(r8, "configuration");
        Intrinsics.checkNotNullParameter(r9, "props");
        String r4 = (String) CoreProps.g.b(r9);
        String r10 = p.d.b(r9);     // Catch: Exception -> L5
    L6:
        String r3 = r10;
        hw8.b r11 = this.a;
        if (r11 == null) goto L11;
        boolean r1 = true;
        if (r11.c(r3) != true) goto L11;
    L12:
        if (r1 == false) goto L15;
        return new CustomCitationSpan(r8.a, r3, r4, r8.c, this.a);
    L15:
        if (StringsKt.startsWith$default(r4, "mention://", false, 2, null) == true) goto L25;
        tsc.n r12 = this.b;
        if (r12 == null) goto L21;
        r12.d("CustomLinkSpanFactory", "link: " + r4 + ",title: " + r3);
    L21:
        return new CustomLinkSpan(r8.a, r4, r8.c);
    L25:
        return new CustomMentionSpan();
    L11:
        r1 = false;
    L5:
        r10 = "";
        goto L6
    }
}
