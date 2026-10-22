package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageRequestModel extends LKBaseRequestModel {

    @JSONField(name = "channel")
    @LKRequiredParam
    public String channel;

    @JSONField(name = "elementID")
    public String elementID;

    @JSONField(name = "expiredTime")
    public String expiredTime;

    @JSONField(name = "expiredTips")
    public String expiredTips;

    @JSONField(name = "name")
    public String name;

    @JSONField(name = "platformConfig")
    public UniversalCardSendClientMessagePluginModel$PlatformConfig platformConfig;

    @JSONField(name = "tag")
    public String tag;

    @JSONField(name = "value")
    public String value;

    public UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageRequestModel() {
    }
}
