package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$ChatBadgeChangeResponse extends LKBaseResponseModel {

    @JSONField(name = "badge")
    public int mBadge;

    @JSONField(name = "chatId")
    public String mChatId;

    @JSONField(name = "isRemind")
    public boolean mIsRemind;

    public Messenger$ChatBadgeChangeResponse() {
    }
}
