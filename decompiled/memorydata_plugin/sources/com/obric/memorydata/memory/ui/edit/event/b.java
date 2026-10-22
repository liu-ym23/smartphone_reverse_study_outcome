package com.obric.memorydata.memory.ui.edit.event;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.ui.edit.f;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u000b\u0012\u0002\b\u00030\n0\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/edit/event/TodoEventUI;", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditUI;", "entity", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "<init>", "(Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;)V", "getEntity", "()Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "editItemList", "", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditItem;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EventTodoMemoryEntity f10903a;

    public b(EventTodoMemoryEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        this.f10903a = r2;
    }

    public List<com.obric.memorydata.memory.ui.edit.b<? extends MemoryEntity, ?>> a() {
        return CollectionsKt.listOf(new com.obric.memorydata.memory.ui.edit.b[]{new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_EVENT_TODO_content, TypedValues.Custom.S_STRING, "MEMORY_EVENT_TODO_content"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TodoEventUI$editItemList$1.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10903a.getContent(), 0, false, 0, null, 120, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_EVENT_TODO_endDate, TypedValues.Custom.S_STRING, "MEMORY_EVENT_TODO_endDate"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TodoEventUI$editItemList$2.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10903a.getEndDate(), 2, false, 0, null, 96, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_EVENT_TODO_endTime, TypedValues.Custom.S_STRING, "MEMORY_EVENT_TODO_endTime"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TodoEventUI$editItemList$3.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10903a.getEndTime(), 3, false, 0, null, 96, null)});
    }
}
