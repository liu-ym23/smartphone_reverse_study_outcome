package io.noties.markwon.ext.tables;

import ctc.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import lsc.m$c;
import lsc.y;
import org.commonmark.ext.gfm.tables.TableBlock;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h<N extends b> implements m$c<TableBlock> {
    public final /* synthetic */ g.c a;

    public h(g.c r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(lsc.m r23, b r24) {
        TableBlock r2 = (TableBlock) r24;
        g.c r3 = this.a;
        ((ArrayList) r3.a).clear();
        ((ArrayList) r3.b).clear();
        r3.c = false;
        r3.d = 0;
        r23.C(r2);
        g.c r4 = this.a;
        r4.getClass();
        int r5 = r23.length();
        r23.c(r2);
        a r12 = new a(0.0f);
        List r13 = CollectionsKt.toList(r4.b);
        Iterator r14 = ((ArrayList) r4.b).iterator();
    L4:
        if (r14.hasNext() == false) goto L16;
        g.b r10 = (g.b) r14.next();
        int r15 = r23.length();
        if (r4.e.b.q != 1) goto L11;
        Iterator r6 = r10.b.iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        g.a r9 = (g.a) r6.next();
        int r11 = r23.length();
        y r7 = r23.builder();
        String r8 = StringsKt.replace$default(r9.e.toString(), "\n", " ", false, 4, null);
        Iterator r16 = r6;
        r7.a.append(r8);
        r7.c(" ");
        r9.a = r11;
        r9.b = r23.length() - 1;
        r6 = r16;
    L15:
        r23.a();
        g r17 = r4.e;
        r23.o(r15, new TableRowSpan2(r17.b, r17.c, r13, r10, r12));
        goto L4
    L11:
        r23.builder().c("|");
        Iterator r18 = r10.b.iterator();
    L13:
        if (r18.hasNext() == false) goto L15;
        g.a r19 = (g.a) r18.next();
        int r20 = r23.length();
        y r21 = r23.builder();
        r21.a.append(" ");
        String r110 = StringsKt.replace$default(r19.e.toString(), "\n", " ", false, 4, null);
        Iterator r111 = r18;
        r21.a.append(r110);
        r21.c(" |");
        r19.a = r20;
        r19.b = r23.length() - 1;
        r18 = r111;
        goto L13
    L16:
        r23.o(r5, r12);
        r23.o(r5, new s());
        r23.q(r2);
        g.c r1 = this.a;
        ((ArrayList) r1.a).clear();
        ((ArrayList) r1.b).clear();
        r1.c = false;
        r1.d = 0;
    }
}
