package ssc;

import android.graphics.drawable.Drawable;
import io.noties.markwon.ext.tasklist.TaskListItem;
import java.util.ArrayList;
import lsc.l;
import lsc.p$a;
import vvc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c extends lsc.a {
    public final Drawable a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // lsc.a, lsc.j
    public final void c(p$a r3) {
        r3.a(TaskListItem.class, new b());
    }

    @Override // lsc.a, lsc.j
    public final void h(l.a r4) {
        r4.a(TaskListItem.class, new g(this.a));
    }

    @Override // lsc.a, lsc.j
    public final void k(e.a r2) {
        d r0 = new d();
        ((ArrayList) r2.c).add(r0);
    }
}
