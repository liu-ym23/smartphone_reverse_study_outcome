package com.ss.android.lark.feed.shared.data.preview;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ThreadFeedPreview extends FeedPreview {
    private String chatId;
    private Chat.Type chatType;
    private boolean isMsgThread;
    private String p2pChatterId;

    public ThreadFeedPreview() {
        this.isMsgThread = false;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public ThreadFeedPreview clone() throws CloneNotSupportedException {
        ThreadFeedPreview r0 = (ThreadFeedPreview) super.clone();
        r0.chatId = this.chatId;
        r0.isMsgThread = this.isMsgThread;
        r0.p2pChatterId = this.p2pChatterId;
        r0.chatType = this.chatType;
        return r0;
    }

    public String getChatId() {
        return this.chatId;
    }

    public Chat.Type getChatType() {
        return this.chatType;
    }

    public String getP2pChatterId() {
        return this.p2pChatterId;
    }

    public boolean isMsgThread() {
        return this.isMsgThread;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ UIFeedCard clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ FeedPreview clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo1165clone() throws CloneNotSupportedException {
        return clone();
    }

    public ThreadFeedPreview(ThreadFeedPreview r2) {
        super(r2);
        this.isMsgThread = false;
        setChatId(r2.getChatId());
        setP2pChatterId(r2.getP2pChatterId());
        setChatType(r2.getChatType());
        setMsgThread(r2.isMsgThread());
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setChatType(Chat.Type r1) {
        this.chatType = r1;
    }

    public void setMsgThread(boolean r1) {
        this.isMsgThread = r1;
    }

    public void setP2pChatterId(String r1) {
        this.p2pChatterId = r1;
    }
}
