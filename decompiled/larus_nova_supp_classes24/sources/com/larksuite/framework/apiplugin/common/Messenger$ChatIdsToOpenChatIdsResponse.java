package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$ChatIdsToOpenChatIdsResponse extends LKBaseResponseModel {

    @JSONField(name = "data")
    public List<Messenger$ChatInfo> mChatInfos;

    public Messenger$ChatIdsToOpenChatIdsResponse() {
        this.mChatInfos = new ArrayList();
    }
}
