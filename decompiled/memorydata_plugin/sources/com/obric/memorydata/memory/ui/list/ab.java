package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.obric.memorydata.memory.databinding.MemoryLoadingTipsLayoutBinding;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryLoadingTipsAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/memorydata/memory/ui/list/MemoryLoadingTipViewHolder;", "<init>", "()V", "loadingTipsString", "", "setLoadingTipsString", "", "tipsString", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ab extends RecyclerView.Adapter<aa> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11173a;

    public ab() {
        this.f11173a = "";
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(aa r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        r1.a(this.f11173a);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((aa) ZeusTransformUtils.preCheckCast(r3, aa.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tipsString");
        this.f11173a = r2;
    }

    public aa b(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        MemoryLoadingTipsLayoutBinding r1 = MemoryLoadingTipsLayoutBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r2, false);
        Intrinsics.checkNotNullExpressionValue(r1, "inflate(...)");
        return new aa(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return 1;
    }
}
