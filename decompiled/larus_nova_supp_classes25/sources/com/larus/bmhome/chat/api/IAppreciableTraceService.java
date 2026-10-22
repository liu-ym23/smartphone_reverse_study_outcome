package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.MessageTrackContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH&J6\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J'\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/api/IAppreciableTraceService;", "", "onStartSendMsg", "", "localSendMsgId", "", "cvsId", "scene", "contentType", "", "onSendFailedBeforeACK", "errorType", "status", "onMessageShowOnScreen", "msg", "Lcom/larus/im/bean/message/Message;", "createMessageTrackContext", "Lcom/larus/im/bean/message/MessageTrackContext;", "businessSendStartTimestamp", "", "agentMode", "(JLjava/lang/String;Ljava/lang/Integer;)Lcom/larus/im/bean/message/MessageTrackContext;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IAppreciableTraceService {

    public static final class a {
        public static /* synthetic */ void a(AppreciableTraceDelegate r6, String r7, String r8, int r9, String r10, int r11, int r12) {
            if ((r12 & 4) == 0) goto L5;
            int r3 = 1;
        L7:
            if ((r12 & 8) == 0) goto L9;
            r10 = null;
        L9:
            r6.b(r7, r8, r3, r10, r11);
            return;
        L5:
            r3 = r9;
            goto L7
        }
    }

    MessageTrackContext a(long r1, Integer r3);

    void b(String r1, String r2, int r3, String r4, int r5);

    void c(String r1, String r2, String r3, int r4);
}
