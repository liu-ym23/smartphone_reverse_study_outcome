package h98;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n extends LinearLayoutManager {
    public final boolean canScrollHorizontally() {
        return false;
    }

    public n(Context r2) {
        super(r2, 0, false);
    }
}
