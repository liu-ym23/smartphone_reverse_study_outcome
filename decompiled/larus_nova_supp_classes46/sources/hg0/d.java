package hg0;

import androidx.recyclerview.widget.RecyclerView;
import jg0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public final RecyclerView a;

    public static final class a {
    }

    static {
    }

    public d(RecyclerView r1) {
        this.a = r1;
    }

    public final bd0.c a(int r3) {
        RecyclerView r0 = this.a;
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r4 = r0.findViewHolderForAdapterPosition(r3);
    L7:
        if ((r4 instanceof b) == false) goto L12;
        g r5 = ((b) r4).l();
        if (r5 != null) goto L11;
        return null;
    L11:
        return r5.f();
    L12:
        return null;
    L5:
        r4 = null;
        goto L7
    }
}
