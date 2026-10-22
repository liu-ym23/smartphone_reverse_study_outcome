package msc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.m$c;
import lsc.x;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r<N extends uvc.b> implements m$c {
    public final /* synthetic */ p a;

    public r(p r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(lsc.m r13, uvc.b r14) {
        Image r15 = (Image) r14;
        Intrinsics.checkNotNullParameter(r13, "visitor");
        Intrinsics.checkNotNullParameter(r15, "image");
        x r0 = ((lsc.l) r13.B().e).a(Image.class);
        if (r0 != null) goto L5;
        r13.c(r15);
        return;
    L5:
        int r1 = r13.length();
        r13.c(r15);
        if (r1 != r13.length()) goto L8;
        r13.builder().a(65532);
    L8:
        lsc.h r2 = r13.B();
        boolean r3 = r15.a instanceof Link;
        xsc.a r4 = r2.d;
        String r16 = r15.h;
        ((xsc.a.C0033a) r4).getClass();
        lsc.t r5 = r13.r();
        wsc.n.a.c(r5, r16);
        wsc.n.b.c(r5, Boolean.valueOf(r3));
        lsc.q r6 = wsc.n.c;
        this.a.getClass();
        Matcher r17 = PatternProtector.compile(":(\\d+):(\\d+):(\\d+):(\\d+):(\\d+):(\\d+)").matcher(r16);
        if (r17.find() == false) goto L24;
        List r18 = StringsKt.split$default(r17.group(), new String[]{":"}, false, 0, 6, null);
        ArrayList r7 = new ArrayList();
        Iterator r19 = r18.iterator();
    L12:
        if (r19.hasNext() == false) goto L17;
        Integer r8 = StringsKt.toIntOrNull((String) r19.next());
        if (r8 == null) goto L12;
        r7.add(r8);
        goto L12
    L17:
        if (r7.size() < 4) goto L24;
        int r110 = ((Number) ListProtector.get(r7, 2)).intValue() - ((Number) ListProtector.get(r7, 0)).intValue();
        int r9 = ((Number) ListProtector.get(r7, 3)).intValue() - ((Number) ListProtector.get(r7, 1)).intValue();
        if (r110 <= 0) goto L24;
        if (r9 <= 0) goto L24;
        wsc.o r10 = new wsc.o(new wsc.o.a(r110, "px"), new wsc.o.a(r9, "px"));
    L25:
        r6.c(r5, r10);
        wsc.n.d.c(r5, Integer.valueOf(r1));
        wsc.n.e.c(r5, Integer.valueOf(r13.builder().length()));
        r13.o(r1, r0.a(r2, r5));
        return;
    L24:
        r10 = null;
        goto L25
    }
}
