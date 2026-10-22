package com.larus.bmhome.chat.search.factory;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.search.adapter.SearchSingleRowVideoAdapter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pi8.a;
import pi8.d;
import si8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NewVideoSingleRowRecyclerFactory implements d {
    public NewVideoSingleRowRecyclerFactory() {
    }

    @Override // pi8.d
    public final RecyclerView.ItemDecoration a() {
        return new NewVideoSingleRowRecyclerFactory$createItemDecoration$decoration$1();
    }

    @Override // pi8.d
    public final a d() {
        return new e();
    }

    @Override // pi8.d
    public final RecyclerView.LayoutManager b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new LinearLayoutManager(r3, 0, false);
    }

    @Override // pi8.d
    public final ListAdapter c(b4 r2, SearchListBox.c r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "holderCallback");
        return new SearchSingleRowVideoAdapter(r2, r3, r4);
    }
}
