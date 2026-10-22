package com.obric.memorydata.memory.ui.list;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryTimeLineBinding;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryTimeLineViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder;", "Lcom/obric/memorydata/memory/databinding/ItemMemoryTimeLineBinding;", "binding", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryTimeLineBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aj extends MemoryListItemViewHolder<ItemMemoryTimeLineBinding> {
    public aj(ItemMemoryTimeLineBinding r3, SelectionStateManager r4) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r6) {
        Intrinsics.checkNotNullParameter(r6, "memoryItem");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.l r7 = (com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L17;
        ((ItemMemoryTimeLineBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTimeLineBinding.class, "com.obric.memorydata.plugin")).tvMemoryTime.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        View r0 = ((ItemMemoryTimeLineBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTimeLineBinding.class, "com.obric.memorydata.plugin")).timeLineUp;
        Intrinsics.checkNotNullExpressionValue(r0, "timeLineUp");
        int r3 = 0;
        if ((!r7.c()) == false) goto L10;
        int r2 = 0;
    L11:
        r0.setVisibility(r2);
        View r5 = ((ItemMemoryTimeLineBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTimeLineBinding.class, "com.obric.memorydata.plugin")).timeLineUpBackgroundView;
        Intrinsics.checkNotNullExpressionValue(r5, "timeLineUpBackgroundView");
        if ((!r7.c()) == true) goto L15;
        r3 = 8;
    L15:
        r5.setVisibility(r3);
        return;
    L10:
        r2 = 8;
        goto L11
    L17:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
