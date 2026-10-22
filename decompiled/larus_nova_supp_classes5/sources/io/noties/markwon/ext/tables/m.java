package io.noties.markwon.ext.tables;

import java.util.ArrayList;
import java.util.List;
import lsc.m$c;
import org.commonmark.ext.gfm.tables.TableCell;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m<N extends b> implements m$c<TableCell> {
    public final /* synthetic */ g.c a;

    public m(g.c r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(lsc.m r5, b r6) {
        TableCell r7 = (TableCell) r6;
        int r0 = r5.length();
        r5.c(r7);
        List<g.a> r1 = this.a.a;
        TableCell.Alignment r8 = r7.i;
        if (r8 == null) goto L8;
        int r9 = b.a[r8.ordinal()];
        int r3 = 1;
        if (r9 == 1) goto L9;
        r3 = 2;
        if (r9 != 2) goto L8;
    L9:
        ArrayList r2 = (ArrayList) r1;
        r2.add(new g.a(r3, r5.builder().e(r0)));
        return;
    L8:
        r3 = 0;
        goto L9
    }
}
