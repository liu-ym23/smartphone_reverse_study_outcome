package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$GetChatInfoRequest extends LKBaseRequestModel {

    @JSONField(name = "chatType")
    public int mChatType;

    @JSONField(name = "openChatId")
    public String mOpenChatId;

    @JSONField(name = "userType")
    public int mUserType;

    public Messenger$GetChatInfoRequest() {
        this.mChatType = -1;
    }
}
