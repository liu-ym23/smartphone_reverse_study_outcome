package psc;

import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.c;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.d;
import ctc.a;
import ctc.e;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lsc.h;
import lsc.t;
import lsc.u;
import lsc.x;
import msc.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements x {
    public final int a;
    public final float b;
    public final boolean c;
    public final boolean d;
    public final e e;
    public final int f;
    public final int g;
    public final int h;
    public final float i;
    public final int j;
    public final boolean k;

    @Override // lsc.x
    public final Object a(h r17, t r18) {
        Intrinsics.checkNotNullParameter(r17, "configuration");
        Intrinsics.checkNotNullParameter(r18, "props");
        if (this.d == false) goto L11;
        s r1 = r17.a;
        u r2 = (u) r18;
        Integer r5 = (Integer) r2.a(d.a);
        Integer r6 = (Integer) r2.a(d.b);
        int r7 = this.a;
        float r8 = this.b;
        float r9 = this.i;
        int r10 = this.j;
        boolean r11 = this.k;
        com.larus.business.markdown.impl.markwon.core.spans.codeblock.b r12 = new com.larus.business.markdown.impl.markwon.core.spans.codeblock.b(this.c, (a) r2.a(d.c), this.e, this.h);
        Map r3 = (Map) r2.a(d.e);
        if (r3 != null) goto L7;
        r3 = MapsKt.emptyMap();
    L7:
        Integer r4 = (Integer) r2.a(d.d);
        if (r4 != null) goto L13;
        r4 = 0;
    L13:
        return new CodeBlockWithLineNumberScrollableSpan(r1, new c(r5, r6, r7, r8, r9, r10, r11, r12, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.a(r3, r4.intValue(), this.g)), this.f);
    L11:
        u r13 = (u) r18;
        return new a(r17.a, new c((Integer) r13.a(d.a), (Integer) r13.a(d.b), this.a, this.b, this.i, this.j, this.k, null, null));
    }

    public b(int r2, float r3, boolean r4, boolean r5, e r6, int r7, int r8, int r9, float r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r6, "scrollBarTheme");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
