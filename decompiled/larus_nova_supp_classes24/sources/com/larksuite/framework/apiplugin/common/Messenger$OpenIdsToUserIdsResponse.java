package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$OpenIdsToUserIdsResponse extends LKBaseResponseModel {

    @JSONField(name = "userIds")
    public ArrayList<String> mUserIds;

    public Messenger$OpenIdsToUserIdsResponse() {
        this.mUserIds = new ArrayList();
    }
}
