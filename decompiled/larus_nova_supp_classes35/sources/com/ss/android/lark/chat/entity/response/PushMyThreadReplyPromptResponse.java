package com.ss.android.lark.chat.entity.response;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PushMyThreadReplyPromptResponse implements Serializable {
    public String groupId;
    public List<MessageInfo> lastAtMessages;
    public int newAtReplyCount;
    public int newReplyCount;

    public PushMyThreadReplyPromptResponse(String r1, int r2, int r3, List<MessageInfo> r4) {
        this.groupId = r1;
        this.newReplyCount = r2;
        this.newAtReplyCount = r3;
        this.lastAtMessages = r4;
    }
}
