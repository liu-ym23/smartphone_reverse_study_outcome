package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel extends LKBaseRequestModel {

    @JSONField(name = "elementID")
    @LKRequiredParam
    public String elementID;

    @JSONField(name = "options")
    @LKRequiredParam
    public ArrayList<MsgCardShowOverflowPluginModel$OptionsItemModel> options;

    public MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel() {
    }
}
