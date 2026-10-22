package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class SetMsgCardSummaryPluginModel$SetMsgCardSummaryRequestModel extends LKBaseRequestModel {

    @JSONField(name = "summary")
    @LKRequiredParam
    public String summary;

    @JSONField(name = "translateSummary")
    public String translateSummary;

    public SetMsgCardSummaryPluginModel$SetMsgCardSummaryRequestModel() {
        this.translateSummary = "";
    }
}
