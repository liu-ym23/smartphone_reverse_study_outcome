package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$OpenChatIdsToChatIdsRequest extends LKBaseRequestModel {

    @JSONField(name = "openChatIds")
    public List<String> mOpenChatIds;

    public Messenger$OpenChatIdsToChatIdsRequest() {
        this.mOpenChatIds = new ArrayList();
    }
}
