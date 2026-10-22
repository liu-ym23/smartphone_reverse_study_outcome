package pi8;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.search.adapter.SearchRichVideoCardAdapter;
import com.larus.bmhome.chat.search.view.FixedColumnGridItemDecoration;
import com.larus.platform.service.z2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements d {
    public p() {
    }

    @Override // pi8.d
    public final RecyclerView.ItemDecoration a() {
        z2.a.w3();
        return new FixedColumnGridItemDecoration(i5.h(), i5.r0(), i5.r0(), 0, 8);
    }

    @Override // pi8.d
    public final a d() {
        return new si8.c();
    }

    @Override // pi8.d
    public final RecyclerView.LayoutManager b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new GridLayoutManager(r5, 2, 1, false);
    }

    @Override // pi8.d
    public final ListAdapter c(b4 r2, SearchListBox.c r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "holderCallback");
        return new SearchRichVideoCardAdapter(r2, r3, r4);
    }
}
