package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$GetChatInfoResponse extends LKBaseResponseModel {

    @JSONField(name = "atCount")
    public int mAtCount;

    @JSONField(name = "avatarUrls")
    public List<String> mAvatarUrls;

    @JSONField(name = "badge")
    public int mBadge;

    @JSONField(name = "i18nNames")
    public JSONObject mI18nNames;

    @JSONField(name = "name")
    public String mName;

    public Messenger$GetChatInfoResponse() {
        this.mAvatarUrls = new ArrayList();
    }
}
