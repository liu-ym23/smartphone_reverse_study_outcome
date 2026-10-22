package com.obric.memorydata.recommend.ui.list;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryTimeBinding;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryTimeViewHolder;", "Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryItemViewHolder;", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryTimeBinding;", "binding", "<init>", "(Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryTimeBinding;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends j<ItemRecommendMemoryTimeBinding> {
    public h(ItemRecommendMemoryTimeBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.recommend.ui.list.j
    public void a(f r7) {
        Intrinsics.checkNotNullParameter(r7, "memoryItem");
        f.a r2 = null;
        if (p() != 0) goto L11;
        ViewGroup.LayoutParams r0 = ((ItemRecommendMemoryTimeBinding) ZeusTransformUtils.preCheckCast(a(), ItemRecommendMemoryTimeBinding.class, "com.obric.memorydata.plugin")).getRoot().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L18;
        int r4 = 4;
    L10:
        r1.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics()));
    L18:
        if (ZeusTransformUtils.instanceOf(r7, f.a.class) == false) goto L20;
        r2 = (f.a) ZeusTransformUtils.preCheckCast(r7, f.a.class, "com.obric.memorydata.plugin");
    L20:
        if (r2 == null) goto L23;
        ((ItemRecommendMemoryTimeBinding) ZeusTransformUtils.preCheckCast(a(), ItemRecommendMemoryTimeBinding.class, "com.obric.memorydata.plugin")).tvMemoryTime.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L23:
        return;
    L7:
        r1 = null;
        goto L8
    L11:
        ViewGroup.LayoutParams r3 = ((ItemRecommendMemoryTimeBinding) ZeusTransformUtils.preCheckCast(a(), ItemRecommendMemoryTimeBinding.class, "com.obric.memorydata.plugin")).getRoot().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L14;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L15:
        if (r1 == null) goto L18;
        r4 = 18;
        goto L10
    L14:
        r1 = null;
        goto L15
    }
}
