package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$GetChatInfoByChatIdResponse extends LKBaseResponseModel {

    @JSONField(name = "data")
    public List<HashMap<String, Messenger$GetChatInfo>> chatInfos;

    @JSONField(name = "failChatIds")
    public List<String> mFailChatIds;

    public Messenger$GetChatInfoByChatIdResponse() {
        this.chatInfos = new ArrayList();
        this.mFailChatIds = new ArrayList();
    }
}
