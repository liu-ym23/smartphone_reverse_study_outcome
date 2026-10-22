package pi8;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.search.adapter.SearchTinyCardAdapter;
import com.larus.bmhome.chat.search.view.LastItemDecoration;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r implements d {
    public final boolean a;
    public final int b;
    public final int c;

    @Override // pi8.d
    public final RecyclerView.ItemDecoration a() {
        return new LastItemDecoration(i5.l0());
    }

    @Override // pi8.d
    public final a d() {
        return new si8.d();
    }

    @Override // pi8.d
    public final RecyclerView.LayoutManager b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new LinearLayoutManager(r3, 0, false);
    }

    public r(boolean r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // pi8.d
    public final ListAdapter c(b4 r5, SearchListBox.c r6, Map r7) {
        Intrinsics.checkNotNullParameter(r5, "holderCallback");
        return new SearchTinyCardAdapter(r5, new q(this.a, this.b, this.c), r7);
    }
}
