package com.obric.memorydata.ui.recyclerview;

import android.view.ViewGroup;
import androidx.paging.LoadState;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.RecyclerView.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0010J\u001d\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u0019J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/ui/recyclerview/OuiLoadStateAdapter;", "VH", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "<init>", "()V", "loadState", "Landroidx/paging/LoadState;", "getLoadState", "()Landroidx/paging/LoadState;", "setLoadState", "(Landroidx/paging/LoadState;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "(Landroid/view/ViewGroup;I)Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "onBindViewHolder", "", "holder", "position", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemViewType", "getItemCount", "(Landroid/view/ViewGroup;Landroidx/paging/LoadState;)Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;Landroidx/paging/LoadState;)V", "getStateViewType", "displayLoadStateAsItem", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a<VH extends RecyclerView.v> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoadState f13021a;

    public a() {
        this.f13021a = (LoadState) ZeusTransformUtils.preCheckCast(new LoadState.NotLoading(false), LoadState.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public final int a(int r1) {
        return b(this.f13021a);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public final VH a(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return (VH) b(r1, this.f13021a);
    }

    public final void a(LoadState r4) {
        Intrinsics.checkNotNullParameter(r4, "loadState");
        if (Intrinsics.areEqual(this.f13021a, r4) == true) goto L16;
        boolean r0 = c(this.f13021a);
        boolean r1 = c(r4);
        if (r0 == false) goto L8;
        if (r1 == true) goto L8;
        g(0);
    L14:
        this.f13021a = r4;
        return;
    L8:
        if (r1 == false) goto L11;
        if (r0 == true) goto L11;
        f(0);
    L11:
        if (r0 == false) goto L14;
        if (r1 == false) goto L14;
        e(0);
        goto L14
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public final void a(VH r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        a(r1, this.f13021a);
    }

    public abstract void a(VH r1, LoadState r2);

    public int b(LoadState r1) {
        Intrinsics.checkNotNullParameter(r1, "loadState");
        return 0;
    }

    public abstract VH b(ViewGroup r1, LoadState r2);

    public boolean c(LoadState r1) {
        Intrinsics.checkNotNullParameter(r1, "loadState");
        if (ZeusTransformUtils.instanceOf(r1, LoadState.Loading.class) == false) goto L5;
    L8:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, LoadState.Error.class) == true) goto L8;
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public final int d() {
        return c(this.f13021a) ? 1 : 0;
    }
}
