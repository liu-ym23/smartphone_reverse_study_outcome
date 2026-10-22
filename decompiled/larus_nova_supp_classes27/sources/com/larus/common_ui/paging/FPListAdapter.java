package com.larus.common_ui.paging;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.larus.chat.search.impl.chat.section.SectionItemCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0013\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001#B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u001d\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u001cJ%\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006$"}, d2 = {"Lcom/larus/common_ui/paging/FPListAdapter;", "DATA", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/ListAdapter;", "config", "Lcom/larus/common_ui/paging/FPListAdapter$Config;", "callback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Lcom/larus/common_ui/paging/FPListAdapter$Config;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lastItemCount", "", "attachedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scrollListener", "com/larus/common_ui/paging/FPListAdapter$scrollListener$1", "Lcom/larus/common_ui/paging/FPListAdapter$scrollListener$1;", "onAttachedToRecyclerView", "", "recyclerView", "onDetachedFromRecyclerView", "onBindViewHolder", "holder", "position", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "data", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/lang/Object;I)V", "getItemData", "(I)Ljava/lang/Object;", "canLoadMore", "", "Config", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FPListAdapter<DATA, VH extends RecyclerView.ViewHolder> extends ListAdapter<DATA, VH> {
    public final CoroutineScope a;
    public int b;
    public final FPListAdapter$scrollListener$1 c;

    public static class a {
        public final int a;
        public final Function0<Unit> b;

        public a(com.larus.chat.search.impl.chat.a r2) {
            Intrinsics.checkNotNullParameter(r2, "loadMore");
            this.a = 10;
            this.b = r2;
        }
    }

    public abstract void y2(VH r1, DATA r2, int r3);

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        r2.addOnScrollListener(this.c);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r2);
        r2.removeOnScrollListener(this.c);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.common_ui.paging.FPListAdapter$scrollListener$1] */
    public FPListAdapter(final a r2, SectionItemCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r3);
        this.a = CoroutineScopeKt.MainScope();
        this.c = new FPListAdapter$scrollListener$1(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBindViewHolder(VH r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Object r0 = CollectionsKt.getOrNull(getCurrentList(), r3);
        if (r0 != null) goto L5;
        return;
    L5:
        y2(r2, r0, r3);
    }
}
