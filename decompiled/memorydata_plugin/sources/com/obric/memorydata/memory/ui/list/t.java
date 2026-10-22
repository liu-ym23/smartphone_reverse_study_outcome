package com.obric.memorydata.memory.ui.list;

import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryDetailFooterBinding;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryFooterViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder;", "Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailFooterBinding;", "binding", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailFooterBinding;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t extends MemoryListItemViewHolder<ItemMemoryDetailFooterBinding> {
    /* JADX WARN: Multi-variable type inference failed */
    public t(ItemMemoryDetailFooterBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"), null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r3) {
        Intrinsics.checkNotNullParameter(r3, "memoryItem");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.g.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.g r4 = (com.obric.memorydata.memory.ui.data.a.g) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.g.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L9;
        ((ItemMemoryDetailFooterBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryDetailFooterBinding.class, "com.obric.memorydata.plugin")).memoryDetailFooterText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
