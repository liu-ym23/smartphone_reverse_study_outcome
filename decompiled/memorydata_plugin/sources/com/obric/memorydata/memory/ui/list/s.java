package com.obric.memorydata.memory.ui.list;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryTopicBinding;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryEpisodicTopicViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder;", "Lcom/obric/memorydata/memory/databinding/ItemMemoryTopicBinding;", "binding", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryTopicBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s extends MemoryListItemViewHolder<ItemMemoryTopicBinding> {
    public s(ItemMemoryTopicBinding r3, SelectionStateManager r4) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final boolean a(com.obric.memorydata.memory.ui.data.a.f r6, View r7) {
        String r8 = r6.b().c();
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "LongClick episodic topic: " + r6.b().a());
        com.obric.memorydata.utils.ba.a(r8, "memory_memory_logId", "memory Topic LogId 已复制到剪贴板", null, 8, null);
        return true;
    }

    public static /* synthetic */ boolean lambda$MxP_ofqYccLFaeozrvDuOdAxtYQ(com.obric.memorydata.memory.ui.data.a.f r0, View r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r5) {
        Intrinsics.checkNotNullParameter(r5, "memoryItem");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.f.class) == false) goto L5;
        final com.obric.memorydata.memory.ui.data.a.f r6 = (com.obric.memorydata.memory.ui.data.a.f) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.f.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L11;
        ((ItemMemoryTopicBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTopicBinding.class, "com.obric.memorydata.plugin")).tvMemoryTopic.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6.b().a(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (AppContext.INSTANCE.isDebug() == false) goto L12;
        ((ItemMemoryTopicBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryTopicBinding.class, "com.obric.memorydata.plugin")).tvMemoryTopic.setOnLongClickListener(new $$Lambda$s$MxP_ofqYccLFaeozrvDuOdAxtYQ(r6));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
