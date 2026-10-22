package e7a;

import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.ui.list.ListViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements d {
    public final EventEmitter a;
    public final RecyclerView b;
    public d c;
    public boolean d;

    @Override // e7a.d
    public final void b() {
        this.c.b();
    }

    @Override // e7a.d
    public final void dispose() {
        d r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // e7a.d
    public final void a(ListViewHolder r2) {
        this.c.a(r2);
    }

    @Override // e7a.d
    public final void c(ListViewHolder r2) {
        this.c.c(r2);
    }

    @Override // e7a.d
    public final void d(ListViewHolder r2) {
        this.c.d(r2);
    }

    public a(EventEmitter r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
        this.d = false;
        this.c = new b(r1);
    }
}
