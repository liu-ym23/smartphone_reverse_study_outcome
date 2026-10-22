package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.paging.LoadState;
import com.obric.memorydata.memory.databinding.ItemMemoryLoadingBinding;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/LoadingStateAdapter;", "Lcom/obric/memorydata/ui/recyclerview/OuiLoadStateAdapter;", "Lcom/obric/memorydata/memory/ui/list/LoadingStateViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "loadState", "Landroidx/paging/LoadState;", "onBindViewHolder", "", "holder", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i extends com.obric.memorydata.ui.recyclerview.a<j> {
    public i() {
    }

    public j a(ViewGroup r3, LoadState r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "loadState");
        ItemMemoryLoadingBinding r5 = ItemMemoryLoadingBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r3, false);
        Intrinsics.checkNotNullExpressionValue(r5, "inflate(...)");
        return new j(r5);
    }

    public void a(j r1, LoadState r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "loadState");
        r1.a(r2);
    }

    @Override // com.obric.memorydata.ui.recyclerview.a
    public /* synthetic */ void a(RecyclerView.v r3, LoadState r4) {
        a((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.ui.recyclerview.a
    public /* synthetic */ RecyclerView.v b(ViewGroup r1, LoadState r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(a(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }
}
