package e7a;

import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.behavior.ui.list.ListViewHolder;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.UIListAdapter;
import com.lynx.tasm.behavior.ui.view.UIComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j extends RecyclerView.RecycledViewPool {
    public final /* synthetic */ UIList a;

    public j(UIList r1) {
        this.a = r1;
    }

    public final void putRecycledView(RecyclerView.ViewHolder r10) {
        if (this.a.W() == true) goto L5;
    L45:
        super.putRecycledView(r10);
        return;
    L5:
        if ((r10 instanceof ListViewHolder) == false) goto L45;
        ListViewHolder r0 = (ListViewHolder) r10;
        if (r0.a.b == null) goto L45;
        UIList r1 = this.a;
        com.lynx.tasm.behavior.ui.list.a r2 = r1.P;
        if (r2 != null) goto L11;
    L44:
        r1.c.H2(r0);
        goto L45
    L11:
        if (r1.Q <= 0) goto L44;
        UIList r3 = r2.a;
        if (r3 == null) goto L45;
        UIListAdapter r4 = r3.c;
        if (r4 == null) goto L45;
        if (r4.u == null) goto L45;
        if (r2.b <= 0) goto L45;
        int r5 = r3.T();
        int r6 = r2.a.U();
        UIComponent r7 = r0.a.b;
        if (r7 == null) goto L45;
        if (r4.u.containsKey(r7.b) == false) goto L43;
        int r8 = r4.u.get(r0.a.b.b).intValue();
        int r9 = r2.b;
        int r11 = r5 - r9;
        int r12 = r9 + r6;
        if (r8 < r11) goto L28;
        if (r8 > r12) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L43;
        if (r5 != (-1)) goto L33;
    L37:
        if (r6 == (-1)) goto L45;
        if (r0.getLayoutPosition() < r6) goto L45;
        if (r2.b(r0.a.b.b) == true) goto L45;
        r2.a(r0.a.b, false);
        goto L45
    L33:
        if (r0.getLayoutPosition() > r5) goto L37;
        if (r2.b(r0.a.b.b) == true) goto L45;
        r2.a(r0.a.b, true);
    L28:
        r13 = false;
    L43:
        r2.a.c.I2(r0.a.b);
        goto L45
    }
}
