package e7a;

import androidx.recyclerview.widget.GridLayoutManager;
import com.lynx.tasm.behavior.ui.list.UIList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends GridLayoutManager.SpanSizeLookup {
    public final /* synthetic */ GridLayoutManager a;
    public final /* synthetic */ UIList b;

    public final int getSpanSize(int r2) {
        if (this.b.c.F2(r2) == true) goto L5;
    L8:
        return 1;
    L5:
        if (this.b.d <= 1) goto L8;
        return this.a.getSpanCount();
    }

    public k(UIList r1, GridLayoutManager r2) {
        this.b = r1;
        this.a = r2;
    }
}
