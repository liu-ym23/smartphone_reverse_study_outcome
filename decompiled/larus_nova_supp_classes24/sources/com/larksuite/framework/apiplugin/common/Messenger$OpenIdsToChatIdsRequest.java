package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$OpenIdsToChatIdsRequest extends LKBaseRequestModel {

    @JSONField(name = "openIds")
    @LKRequiredParam
    public ArrayList<String> mOpenIds;

    public Messenger$OpenIdsToChatIdsRequest() {
        this.mOpenIds = new ArrayList();
    }
}
