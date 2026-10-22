package com.ss.android.lark.forwardv2.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ThreadTarget implements Serializable {
    private String mAvatar;
    private String mChatId;
    private String mId;
    private boolean mIsReplyInThread;
    private String mName;

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getChatId() {
        return this.mChatId;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isReplyInThread() {
        return this.mIsReplyInThread;
    }

    public void setAvatar(String r1) {
        this.mAvatar = r1;
    }

    public void setChatId(String r1) {
        this.mChatId = r1;
    }

    public void setId(String r1) {
        this.mId = r1;
    }

    public void setName(String r1) {
        this.mName = r1;
    }

    public void setReplyInThread(boolean r1) {
        this.mIsReplyInThread = r1;
    }

    public ThreadTarget(String r7, String r8, String r9, String r10) {
        this(r7, r8, r9, r10, false);
    }

    public ThreadTarget(String r1, String r2, String r3, String r4, boolean r5) {
        this.mId = r1;
        this.mName = r2;
        this.mAvatar = r3;
        this.mChatId = r4;
        this.mIsReplyInThread = r5;
    }
}
