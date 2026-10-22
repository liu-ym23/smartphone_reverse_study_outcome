package com.larus.bmhome.chat.list.cell.test;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskType;
import com.larus.bmhome.chat.component.list.pipeline.TimestampTaskProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/test/CrowdTestTaskProvider;", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskProvider;", "<init>", "()V", "stage", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskStageEnum;", "type", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskType;", "order", "", "providerPipelineTask", "Lcom/larus/bmhome/chat/component/list/pipeline/ITask;", "context", "Lcom/larus/bmhome/chat/component/list/pipeline/ITaskContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CrowdTestTaskProvider implements PipelineTaskProvider {
    public CrowdTestTaskProvider() {
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final int order() {
        return 300;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.NEED_TRAVERSAL;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final PipelineTaskType type() {
        return PipelineTaskType.PICK_FIRST;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final td8.c a(td8.d r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        TimestampTaskProvider r0 = (TimestampTaskProvider) ServiceManager.get().getService(TimestampTaskProvider.class);
        if (r0 == null) goto L6;
        td8.c r1 = r0.a(r3);
        if (r1 == null) goto L6;
    L8:
        return new CrowdTestTask(r3, r1);
    L6:
        r1 = new td8.a(r3);
        goto L8
    }
}
