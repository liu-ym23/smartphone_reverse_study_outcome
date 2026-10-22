package u28;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements b {
    public a() {
    }

    public final int a(RecyclerView r2) {
        LinearLayoutManager r3 = r2.getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == false) goto L7;
        return r3.getOrientation();
    L7:
        throw new IllegalStateException("StickyListHeadersDecoration can only be used with a LinearLayoutManager.");
    }

    public final boolean b(RecyclerView r2) {
        LinearLayoutManager r3 = r2.getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == false) goto L7;
        return r3.getReverseLayout();
    L7:
        throw new IllegalStateException("StickyListHeadersDecoration can only be used with a LinearLayoutManager.");
    }
}
