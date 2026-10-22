package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.MessageTrackContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J2\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/api/AppreciableTraceServiceNoop;", "Lcom/larus/bmhome/chat/api/IAppreciableTraceService;", "<init>", "()V", "onStartSendMsg", "", "localSendMsgId", "", "cvsId", "scene", "contentType", "", "onSendFailedBeforeACK", "errorType", "status", "onMessageShowOnScreen", "msg", "Lcom/larus/im/bean/message/Message;", "createMessageTrackContext", "Lcom/larus/im/bean/message/MessageTrackContext;", "businessSendStartTimestamp", "", "agentMode", "(JLjava/lang/String;Ljava/lang/Integer;)Lcom/larus/im/bean/message/MessageTrackContext;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AppreciableTraceServiceNoop implements IAppreciableTraceService {
    public AppreciableTraceServiceNoop() {
    }

    @Override // com.larus.bmhome.chat.api.IAppreciableTraceService
    public final void b(String r1, String r2, int r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r2, "scene");
    }

    @Override // com.larus.bmhome.chat.api.IAppreciableTraceService
    public final void c(String r1, String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "scene");
    }

    @Override // com.larus.bmhome.chat.api.IAppreciableTraceService
    public final MessageTrackContext a(long r8, Integer r10) {
        Intrinsics.checkNotNullParameter("share_send", "scene");
        return new MessageTrackContext(r8, null, 2, null);
    }
}
