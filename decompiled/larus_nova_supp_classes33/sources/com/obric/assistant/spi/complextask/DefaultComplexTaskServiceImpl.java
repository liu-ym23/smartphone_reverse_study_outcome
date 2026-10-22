package com.obric.assistant.spi.complextask;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.ThinkingBlock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/spi/complextask/DefaultComplexTaskServiceImpl;", "Lcom/obric/assistant/spi/complextask/IComplexTaskService;", "<init>", "()V", "shouldDelayUpdate", "", "message", "Lcom/larus/im/bean/message/Message;", "block", "Lcom/larus/im/bean/message/block/Block;", "getUpdateDelayTime", "", "isComplexTask", "appendLoadingTitle", "", "isDeepThinkingTyping", "thinkingBlock", "Lcom/larus/im/bean/message/block/ThinkingBlock;", "updateComplexTaskHeaderStatus", "Lcom/obric/assistant/spi/complextask/ComplexTaskFoldStatus;", "status", "isHideExpandAllThinkViewStreaming", "getComplexTaskLinkMsgId", "shouldUpdateClickTargetFoldStatus", "getClickTargetFoldStatus", "defaultFoldStatus", "needForceShowDivider", "isNotShowStreamingAnimation", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultComplexTaskServiceImpl implements IComplexTaskService {
    public DefaultComplexTaskServiceImpl() {
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return false;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean b(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return false;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean c(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return false;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean d(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return false;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final String e(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return null;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean f(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return false;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final ComplexTaskFoldStatus g(ComplexTaskFoldStatus r2, Message r3, Block r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "block");
        return r2;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final ComplexTaskFoldStatus h(ComplexTaskFoldStatus r2, Message r3, Block r4, ComplexTaskFoldStatus r5) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "block");
        Intrinsics.checkNotNullParameter(r5, "defaultFoldStatus");
        return r5;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean i(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return false;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final long j(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        return 0;
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final String k(Message r1, boolean r2, ThinkingBlock r3) {
        Intrinsics.checkNotNullParameter(r1, "message");
        return null;
    }
}
