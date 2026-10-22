package com.ss.android.lark.chat.entity.favorite;

import com.bytedance.lark.pb.basic.v1.FavoritesType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FavoriteMessageInfo implements Serializable, Comparable<FavoriteMessageInfo> {
    private long createTime;
    private String id;
    private Chat sourceChat;
    private Chatter sourceChatter;
    private Message sourceMessage;
    private FavoritesType type;

    public FavoriteMessageInfo() {
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public Chat getSourceChat() {
        return this.sourceChat;
    }

    public Chatter getSourceChatter() {
        return this.sourceChatter;
    }

    public Message getSourceMessage() {
        return this.sourceMessage;
    }

    public FavoritesType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FavoriteMessageInfo r5) {
        if (this.createTime >= r5.createTime) goto L6;
        return -1;
    L6:
        return 1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setSourceChat(Chat r1) {
        this.sourceChat = r1;
    }

    public void setSourceChatter(Chatter r1) {
        this.sourceChatter = r1;
    }

    public void setSourceMessage(Message r1) {
        this.sourceMessage = r1;
    }

    public void setType(FavoritesType r1) {
        this.type = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FavoriteMessageInfo r1) {
        return compareTo2(r1);
    }
}
