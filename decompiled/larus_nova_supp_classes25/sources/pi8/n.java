package pi8;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.search.adapter.SearchMixedMediaCardAdapter;
import com.larus.bmhome.chat.search.view.FixedColumnGridItemDecoration;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements d {
    public n() {
    }

    @Override // pi8.d
    public final RecyclerView.ItemDecoration a() {
        Lazy r0 = com.larus.bmhome.video.b.a;
        int r5 = com.larus.bmhome.video.b.b(false);
        return new FixedColumnGridItemDecoration(r5, 0, 0, r5, 16);
    }

    @Override // pi8.d
    public final a d() {
        return new si8.b();
    }

    @Override // pi8.d
    public final RecyclerView.LayoutManager b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new GridLayoutManager(r5, 2, 1, false);
    }

    @Override // pi8.d
    public final ListAdapter c(b4 r1, SearchListBox.c r2, Map r3) {
        Intrinsics.checkNotNullParameter(r1, "holderCallback");
        return new SearchMixedMediaCardAdapter(r1, r2);
    }
}
