package com.obric.memorydata.memory.ui.list;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryTimeBinding;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryTimeViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder;", "Lcom/obric/memorydata/memory/databinding/ItemMemoryTimeBinding;", "binding", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryTimeBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "updateTime", "item", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ak extends MemoryListItemViewHolder<ItemMemoryTimeBinding> {
    public ak(ItemMemoryTimeBinding r3, SelectionStateManager r4) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r7) {
        Intrinsics.checkNotNullParameter(r7, "memoryItem");
        com.obric.memorydata.memory.ui.data.a.d r2 = null;
        if (p() != 0) goto L11;
        ViewGroup.LayoutParams r0 = ((ItemMemoryTimeBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTimeBinding.class, "com.obric.memorydata.plugin")).getRoot().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L18;
        int r4 = 8;
    L10:
        r1.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics()));
    L18:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L20;
        com.obric.memorydata.memory.ui.data.a.k r3 = (com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin");
    L21:
        if (r3 == null) goto L24;
        ((ItemMemoryTimeBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTimeBinding.class, "com.obric.memorydata.plugin")).tvMemoryTime.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.memorydata.plugin"));
    L24:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L26;
        r2 = (com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin");
    L26:
        if (r2 == null) goto L29;
        ((ItemMemoryTimeBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTimeBinding.class, "com.obric.memorydata.plugin")).tvMemoryTime.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.utils.f.f11537a.a(r2.b(), true), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L29:
        return;
    L20:
        r3 = null;
        goto L21
    L7:
        r1 = null;
        goto L8
    L11:
        ViewGroup.LayoutParams r5 = ((ItemMemoryTimeBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTimeBinding.class, "com.obric.memorydata.plugin")).getRoot().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == false) goto L14;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L15:
        if (r1 == null) goto L18;
        r4 = 18;
        goto L10
    L14:
        r1 = null;
        goto L15
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder
    public void d(com.obric.memorydata.memory.ui.data.a r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.d r5 = (com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 == null) goto L9;
        ((ItemMemoryTimeBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTimeBinding.class, "com.obric.memorydata.plugin")).tvMemoryTime.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.utils.f.f11537a.a(r5.b(), true), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
