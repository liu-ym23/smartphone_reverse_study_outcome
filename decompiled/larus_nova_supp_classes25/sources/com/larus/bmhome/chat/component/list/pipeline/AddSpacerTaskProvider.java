package com.larus.bmhome.chat.component.list.pipeline;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import td8.c;
import td8.d;
import vd8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/list/pipeline/AddSpacerTaskProvider;", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskProvider;", "<init>", "()V", "stage", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskStageEnum;", "order", "", "type", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskType;", "providerPipelineTask", "Lcom/larus/bmhome/chat/component/list/pipeline/ITask;", "context", "Lcom/larus/bmhome/chat/component/list/pipeline/ITaskContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AddSpacerTaskProvider implements PipelineTaskProvider {
    public AddSpacerTaskProvider() {
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final int order() {
        return 350;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.DIRECT_ADD;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final PipelineTaskType type() {
        return PipelineTaskType.FOR_EACH;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final c a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new a(r2);
    }
}
