package com.larus.bmhome.chat.component.list.pipeline;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import td8.b;
import td8.d;
import xd8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/list/pipeline/NeedTraversalStageProvider;", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineStageProvider;", "<init>", "()V", "providerStage", "Lcom/larus/bmhome/chat/component/list/pipeline/IStage;", "context", "Lcom/larus/bmhome/chat/component/list/pipeline/ITaskContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NeedTraversalStageProvider implements PipelineStageProvider {
    public NeedTraversalStageProvider() {
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineStageProvider
    public final b a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new c(r2);
    }
}
