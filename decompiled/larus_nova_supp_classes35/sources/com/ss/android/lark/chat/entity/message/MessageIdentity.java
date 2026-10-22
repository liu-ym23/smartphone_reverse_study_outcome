package com.ss.android.lark.chat.entity.message;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MessageIdentity implements Serializable {
    private String chatId;
    private long createTime;
    private boolean hideCopy;
    private boolean hideEditor;
    private boolean hideForward;
    private boolean hideImageOCR;
    private boolean hideJumpChat;
    private boolean hideSaveToDriver;
    private boolean hideStickerSave;
    private boolean mergeForwardRootMessageIsRestricted;
    private String messageId;
    private ArrayList<String> riskObjectKeys;
    private String senderId;
    private String senderTenantId;
    private String sourceId;
    private Message.SourceType sourceType;
    private String threadId;
    private int threadPosition;

    public Message.SourceType getSourceType() {
        Message.SourceType r0 = this.sourceType;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Message.SourceType.TYPE_FROM_MESSAGE;
    }

    public String toString() {
        return "MessageIdentity{messageId='" + this.messageId + "', sourceId='" + this.sourceId + "', chatId='" + this.chatId + "', sourceType=" + this.sourceType + ", createTime=" + this.createTime + ", threadId='" + this.threadId + "', threadPosition=" + this.threadPosition + ", hideForward=" + this.hideForward + ", hideEditor=" + this.hideEditor + ", hideJumpChat=" + this.hideJumpChat + ", hideSaveToDriver=" + this.hideSaveToDriver + ", hideStickerSave=" + this.hideStickerSave + ", hideCopy=" + this.hideCopy + ", hideImageOCR=" + this.hideImageOCR + ", senderId=" + this.senderId + ", senderTenantId=" + this.senderTenantId + '}';
    }

    public String getChatId() {
        return this.chatId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public List<String> getRiskObjectKeys() {
        return this.riskObjectKeys;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getSenderTenantId() {
        return this.senderTenantId;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public int getThreadPosition() {
        return this.threadPosition;
    }

    public boolean isHideCopy() {
        return this.hideCopy;
    }

    public boolean isHideEditor() {
        return this.hideEditor;
    }

    public boolean isHideForward() {
        return this.hideForward;
    }

    public boolean isHideImageOCR() {
        return this.hideImageOCR;
    }

    public boolean isHideJumpChat() {
        return this.hideJumpChat;
    }

    public boolean isHideSaveToDriver() {
        return this.hideSaveToDriver;
    }

    public boolean isHideStickerSave() {
        return this.hideStickerSave;
    }

    public boolean isMergeForwardRootMessageIsRestricted() {
        return this.mergeForwardRootMessageIsRestricted;
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setHideCopy(boolean r1) {
        this.hideCopy = r1;
    }

    public void setHideEditor(boolean r1) {
        this.hideEditor = r1;
    }

    public void setHideForward(boolean r1) {
        this.hideForward = r1;
    }

    public void setHideImageOCR(boolean r1) {
        this.hideImageOCR = r1;
    }

    public void setHideJumpChat(boolean r1) {
        this.hideJumpChat = r1;
    }

    public void setHideSaveToDriver(boolean r1) {
        this.hideSaveToDriver = r1;
    }

    public void setHideStickerSave(boolean r1) {
        this.hideStickerSave = r1;
    }

    public void setMergeForwardRootMessageIsRestricted(boolean r1) {
        this.mergeForwardRootMessageIsRestricted = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setRiskObjectKeys(List<String> r2) {
        if (r2 == null) goto L5;
        this.riskObjectKeys = new ArrayList(r2);
        return;
    }

    public void setSenderId(String r1) {
        this.senderId = r1;
    }

    public void setSenderTenantId(String r1) {
        this.senderTenantId = r1;
    }

    public void setSourceId(String r1) {
        this.sourceId = r1;
    }

    public void setSourceType(Message.SourceType r1) {
        this.sourceType = r1;
    }

    public void setThreadId(String r1) {
        this.threadId = r1;
    }

    public void setThreadPosition(int r1) {
        this.threadPosition = r1;
    }

    public MessageIdentity(String r2, String r3) {
        this.hideStickerSave = true;
        this.hideCopy = false;
        this.hideImageOCR = false;
        this.messageId = r2;
        this.chatId = r3;
        this.sourceId = r2;
        this.sourceType = Message.SourceType.TYPE_FROM_MESSAGE;
        setRiskObjectKeys(new ArrayList());
    }

    public MessageIdentity(String r2, String r3, String r4, Message.SourceType r5) {
        this.hideStickerSave = true;
        this.hideCopy = false;
        this.hideImageOCR = false;
        this.messageId = r2;
        this.chatId = r3;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.sourceId = r2;
    L6:
        this.sourceType = r5;
        setRiskObjectKeys(new ArrayList());
        return;
    L5:
        this.sourceId = r4;
        goto L6
    }
}
