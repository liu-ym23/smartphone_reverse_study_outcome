package io.noties.markwon.ext.tables;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import lsc.m$c;
import org.commonmark.ext.gfm.tables.TableRow;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k<N extends b> implements m$c<TableRow> {
    public final /* synthetic */ g.c a;

    public k(g.c r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(lsc.m r4, b r5) {
        g.c r0 = this.a;
        r0.getClass();
        r4.c((TableRow) r5);
        ((ArrayList) r0.b).add(new g.b(r0.d, CollectionsKt.toList(r0.a), r0.c));
        r0.d++;
        ((ArrayList) r0.a).clear();
    }
}
