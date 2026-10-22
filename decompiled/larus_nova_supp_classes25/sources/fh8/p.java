package fh8;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p extends uvc.a {
    public final /* synthetic */ List<lw8.k> a;

    public p(List<lw8.k> r1) {
        this.a = r1;
    }

    public final void D(Link r6) {
        Intrinsics.checkNotNullParameter(r6, "link");
        Iterator r0 = SequencesKt.generateSequence(((uvc.b) r6).a, new n()).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if ((((uvc.b) r0.next()) instanceof TableCell) == false) goto L4;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        List<lw8.k> r2 = this.a;
        String r3 = r6.h;
        StringBuilder r4 = new StringBuilder();
        o.b(r4, ((uvc.b) r6).b);
        r2.add(new lw8.k(r3, r4.toString(), null, null));
    L11:
        c(r6);
        return;
    L8:
        r1 = false;
        goto L9
    }
}
