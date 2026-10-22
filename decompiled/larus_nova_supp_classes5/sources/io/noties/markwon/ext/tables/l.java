package io.noties.markwon.ext.tables;

import lsc.m$c;
import org.commonmark.ext.gfm.tables.TableHead;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l<N extends b> implements m$c<TableHead> {
    public final /* synthetic */ g.c a;

    public l(g.c r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(lsc.m r3, b r4) {
        this.a.c = true;
        r3.c((TableHead) r4);
        this.a.c = false;
    }
}
