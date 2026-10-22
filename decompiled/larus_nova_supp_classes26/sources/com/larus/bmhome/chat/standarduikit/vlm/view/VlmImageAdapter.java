package com.larus.bmhome.chat.standarduikit.vlm.view;

import android.util.Size;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.standarduikit.vlm.view.viewholder.VlmImageViewHolder;
import com.larus.bmhome.chat.standarduikit.vlm.view.viewholder.VlmItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0018\u001a\u00020\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0015\u0010\u0019\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001aJ@\u0010\u001b\u001a\u00020\u001028\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tJ\u0016\u0010\u001c\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J@\u0010\u001d\u001a\u00020\u001028\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\nJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/vlm/view/VlmImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/viewholder/VlmImageViewHolder;", "<init>", "()V", "vlmVlmRenderInfoList", "", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/VlmRenderInfo;", "onClickCard", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Landroid/util/Size;", "size", "", "onLongClickCard", "Lkotlin/Function0;", "", "onCardShow", "itemSize", "enableShimmer", "Ljava/lang/Boolean;", "setupRenderInfoList", "setupEnableShimmer", "(Ljava/lang/Boolean;)V", "setupOnClickCard", "setupOnLongClickCard", "setupOnCardShow", "getDataByPosition", "index", "getRenderList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VlmImageAdapter extends RecyclerView.Adapter<VlmImageViewHolder> {
    public List<l> a;
    public Function2<? super Integer, ? super Size, Unit> b;
    public Function0<Boolean> c;
    public Function2<? super Integer, ? super Size, Unit> d;
    public Boolean e;

    public final int getItemCount() {
        return this.a.size();
    }

    public VlmImageAdapter() {
        this.a = CollectionsKt.emptyList();
        this.e = Boolean.FALSE;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        VlmImageViewHolder r11 = (VlmImageViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        l r3 = (l) CollectionsKt.getOrNull(this.a, r10);
        Boolean r4 = this.e;
        Function2<? super Integer, ? super Size, Unit> r5 = this.b;
        Function0<Boolean> r6 = this.c;
        Function2<? super Integer, ? super Size, Unit> r7 = this.d;
        r11.a.n6(r10, r3, r4, r5, r6, r7);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new VlmImageViewHolder(new VlmItemView(r4.getContext(), null, 6, 0));
    }
}
