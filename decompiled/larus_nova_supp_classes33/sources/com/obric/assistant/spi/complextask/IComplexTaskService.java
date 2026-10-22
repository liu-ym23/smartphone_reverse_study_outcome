package com.obric.assistant.spi.complextask;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.ThinkingBlock;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0011H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/spi/complextask/IComplexTaskService;", "", "shouldDelayUpdate", "", "message", "Lcom/larus/im/bean/message/Message;", "block", "Lcom/larus/im/bean/message/block/Block;", "getUpdateDelayTime", "", "isComplexTask", "appendLoadingTitle", "", "isDeepThinkingTyping", "thinkingBlock", "Lcom/larus/im/bean/message/block/ThinkingBlock;", "updateComplexTaskHeaderStatus", "Lcom/obric/assistant/spi/complextask/ComplexTaskFoldStatus;", "status", "isHideExpandAllThinkViewStreaming", "getComplexTaskLinkMsgId", "shouldUpdateClickTargetFoldStatus", "getClickTargetFoldStatus", "defaultFoldStatus", "needForceShowDivider", "isNotShowStreamingAnimation", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IComplexTaskService {
    boolean a(Message r1, Block r2);

    boolean b(Message r1, Block r2);

    boolean c(Message r1, Block r2);

    boolean d(Message r1, Block r2);

    String e(Message r1, Block r2);

    boolean f(Message r1);

    ComplexTaskFoldStatus g(ComplexTaskFoldStatus r1, Message r2, Block r3);

    ComplexTaskFoldStatus h(ComplexTaskFoldStatus r1, Message r2, Block r3, ComplexTaskFoldStatus r4);

    boolean i(Message r1, Block r2);

    long j(Message r1);

    String k(Message r1, boolean r2, ThinkingBlock r3);
}
