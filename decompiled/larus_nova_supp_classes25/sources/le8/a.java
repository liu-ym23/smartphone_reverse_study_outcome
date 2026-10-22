package le8;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import ie8.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a<STATE extends ie8.a> extends FrameLayout implements b {
    public RecyclerView a;

    public void b() {
        this.a = null;
    }

    public RecyclerView getAttachedRecyclerView() {
        return this.a;
    }

    public final RecyclerView getRecyclerView() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void setRecyclerView(RecyclerView r1) {
        this.a = r1;
    }
}
