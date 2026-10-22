package pi8;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.search.adapter.SearchNormalCardAdapter;
import com.larus.bmhome.chat.search.view.LastItemDecoration;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements d {
    public i() {
    }

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

    @Override // pi8.d
    public final ListAdapter c(b4 r1, SearchListBox.c r2, Map r3) {
        Intrinsics.checkNotNullParameter(r1, "holderCallback");
        return new SearchNormalCardAdapter(r1, r3);
    }
}
