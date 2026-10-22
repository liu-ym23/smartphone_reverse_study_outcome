package com.ss.android.lark.contact.base.dto;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatBotsResponse implements Serializable {
    public List<Chatter> chatters;
    public boolean hasMore;

    public ChatBotsResponse(List<Chatter> r1, boolean r2) {
        this.chatters = r1;
        this.hasMore = r2;
    }
}
