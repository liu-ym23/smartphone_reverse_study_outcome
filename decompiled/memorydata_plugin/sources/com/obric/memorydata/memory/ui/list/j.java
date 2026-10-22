package com.obric.memorydata.memory.ui.list;

import android.view.View;
import androidx.paging.LoadState;
import com.obric.memorydata.memory.databinding.ItemMemoryLoadingBinding;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/LoadingStateViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemMemoryLoadingBinding;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryLoadingBinding;)V", "bind", "", "loadState", "Landroidx/paging/LoadState;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ItemMemoryLoadingBinding f11314a;

    public j(ItemMemoryLoadingBinding r4) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
        this.f11314a = r4;
    }

    public final void a(LoadState r2) {
        Intrinsics.checkNotNullParameter(r2, "loadState");
        if (ZeusTransformUtils.instanceOf(r2, LoadState.Loading.class) == false) goto L5;
        this.f11314a.loadingView.setVisibility(0);
        this.f11314a.loadingView.setCurrentState(0);
        return;
    L5:
        this.f11314a.loadingView.setVisibility(8);
    }
}
