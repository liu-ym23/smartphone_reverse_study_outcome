package e7a;

import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.UIListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m extends RecyclerView.OnScrollListener {
    public final /* synthetic */ UIList a;

    public m(UIList r1) {
        this.a = r1;
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        super.onScrolled(r1, r2, r3);
        UIList r4 = this.a;
        UIListAdapter r5 = r4.c;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.y == false) goto L12;
        com.lynx.tasm.behavior.ui.list.a r6 = r4.P;
        if (r6 == null) goto L9;
        r6.c();
    L9:
        this.a.c.y = false;
        return;
    }
}
