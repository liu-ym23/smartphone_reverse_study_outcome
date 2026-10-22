package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$GetChatInfoByChatIdRequest extends LKBaseRequestModel {

    @JSONField(name = "chatIds")
    @LKRequiredParam
    public List<String> mChatId;

    public Messenger$GetChatInfoByChatIdRequest() {
    }
}
