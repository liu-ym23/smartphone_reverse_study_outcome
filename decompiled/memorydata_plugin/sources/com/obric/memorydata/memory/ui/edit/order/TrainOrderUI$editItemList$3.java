package com.obric.memorydata.memory.ui.edit.order;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.ui.edit.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class TrainOrderUI$editItemList$3 extends FunctionReferenceImpl implements Function2<MemoryEntity, String, j> {
    TrainOrderUI$editItemList$3(Object r8) {
        super(2, r8, f.class, "validateCheckOutDate", "validateCheckOutDate(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/String;)Lcom/obric/memorydata/memory/ui/edit/ValidationResult;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j invoke2(MemoryEntity r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return f.a((f) ZeusTransformUtils.preCheckCast(this.receiver, f.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ j invoke(MemoryEntity r3, String r4) {
        return invoke2((MemoryEntity) ZeusTransformUtils.preCheckCast(r3, MemoryEntity.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }
}
