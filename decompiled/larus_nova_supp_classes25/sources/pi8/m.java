package pi8;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.search.adapter.SearchImage4CardAdapter;
import com.larus.bmhome.chat.search.view.FixedColumnGridItemDecoration;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m implements d {
    public m() {
    }

    @Override // pi8.d
    public final RecyclerView.ItemDecoration a() {
        return new FixedColumnGridItemDecoration(i5.h(), i5.z(), i5.z(), 0, 24);
    }

    @Override // pi8.d
    public final a d() {
        return new si8.a();
    }

    @Override // pi8.d
    public final RecyclerView.LayoutManager b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new GridLayoutManager(r5, 2, 1, false);
    }

    @Override // pi8.d
    public final ListAdapter c(b4 r1, SearchListBox.c r2, Map r3) {
        Intrinsics.checkNotNullParameter(r1, "holderCallback");
        return new SearchImage4CardAdapter(r1, r3);
    }
}
