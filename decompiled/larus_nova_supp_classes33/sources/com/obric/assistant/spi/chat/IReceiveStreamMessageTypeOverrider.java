package com.obric.assistant.spi.chat;

import com.larus.im.bean.message.Message;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/spi/chat/IReceiveStreamMessageTypeOverrider;", "", "overrideMessageType", "", "msg", "Lcom/larus/im/bean/message/Message;", "defaultType", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IReceiveStreamMessageTypeOverrider {
    String a(Message r1, String r2);
}
