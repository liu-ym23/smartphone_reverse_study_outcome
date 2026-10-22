package io.noties.markwon.ext.tables;

import android.text.Spanned;
import android.widget.TextView;
import ctc.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.SetsKt;
import lsc.a;
import lsc.p$a;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g extends a {
    public final c a;
    public final u b;
    public final e c;
    public final f d;

    public final class c {
        public final List<a> a;
        public final List<b> b;
        public boolean c;
        public int d;
        public final /* synthetic */ g e;

        public c(g r1) {
            this.e = r1;
            this.a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r5) {
        a[] r0 = q.a(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length > 0) goto L7;
        return;
    L7:
        if (r5.getTag(2131379637) != null) goto L9;
        o r2 = new o(r5);
        r5.addOnAttachStateChangeListener(r2);
        r5.setTag(2131379637, r2);
    L9:
        p r1 = new p(r5);
        int r6 = r0.length;
        int r3 = 0;
    L10:
        if (r3 >= r6) goto L15;
        r0[r3].a = r1;
        r3 = r3 + 1;
        goto L10
    }

    @Override // lsc.a, lsc.j
    public final void c(p$a r4) {
        c r0 = this.a;
        r0.getClass();
        r4.a(TableBlock.class, new h(r0));
        r4.a(TableTitle.class, i.a);
        r4.a(TableBody.class, j.a);
        r4.a(TableRow.class, new k(r0));
        r4.a(TableHead.class, new l(r0));
        r4.a(TableCell.class, new m(r0));
    }

    @Override // lsc.a, lsc.j
    public final void k(vvc.e.a r3) {
        r3.b(SetsKt.setOf(new v(this.d)));
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r4, Spanned r5) {
        a[] r6 = q.a(r4);
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length <= 0) goto L11;
        int r7 = r6.length;
        int r0 = 0;
    L7:
        if (r0 >= r7) goto L12;
        r6[r0].a = null;
        r0 = r0 + 1;
        goto L7
    L12:
        return;
    }

    public g(u r1, e r2, f r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = new c(this);
    }
}
