package com.obric.assistant.spi.complextask;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.ThinkingBlock;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0001J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J!\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/spi/complextask/ComplexTaskDelegate;", "Lcom/obric/assistant/spi/complextask/IComplexTaskService;", "<init>", "()V", "appendLoadingTitle", "", "message", "Lcom/larus/im/bean/message/Message;", "isDeepThinkingTyping", "", "thinkingBlock", "Lcom/larus/im/bean/message/block/ThinkingBlock;", "getClickTargetFoldStatus", "Lcom/obric/assistant/spi/complextask/ComplexTaskFoldStatus;", "status", "block", "Lcom/larus/im/bean/message/block/Block;", "defaultFoldStatus", "getComplexTaskLinkMsgId", "getUpdateDelayTime", "", "isComplexTask", "isHideExpandAllThinkViewStreaming", "isNotShowStreamingAnimation", "needForceShowDivider", "shouldDelayUpdate", "shouldUpdateClickTargetFoldStatus", "updateComplexTaskHeaderStatus", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskDelegate implements IComplexTaskService {
    public static final ComplexTaskDelegate b = null;
    public final /* synthetic */ IComplexTaskService a;

    static {
        b = new ComplexTaskDelegate();
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return this.a.a(r2, r3);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean b(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return this.a.b(r2, r3);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean c(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return this.a.c(r2, r3);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean d(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return this.a.d(r2, r3);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final String e(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return this.a.e(r2, r3);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean f(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return this.a.f(r2);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final ComplexTaskFoldStatus g(ComplexTaskFoldStatus r2, Message r3, Block r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "block");
        return this.a.g(r2, r3, r4);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final ComplexTaskFoldStatus h(ComplexTaskFoldStatus r2, Message r3, Block r4, ComplexTaskFoldStatus r5) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "block");
        Intrinsics.checkNotNullParameter(r5, "defaultFoldStatus");
        return this.a.h(r2, r3, r4, r5);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final boolean i(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return this.a.i(r2, r3);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final long j(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        return this.a.j(r3);
    }

    @Override // com.obric.assistant.spi.complextask.IComplexTaskService
    public final String k(Message r2, boolean r3, ThinkingBlock r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return this.a.k(r2, r3, r4);
    }

    private ComplexTaskDelegate() {
        IComplexTaskService r0 = (IComplexTaskService) ServiceManager.get().getService(IComplexTaskService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultComplexTaskServiceImpl();
    L5:
        this.a = r0;
    }
}
