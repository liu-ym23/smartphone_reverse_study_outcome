package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class MsgCardShowOverflowPluginModel$OptionsItemModel implements Serializable {

    @JSONField(name = "actions")
    @LKRequiredParam
    public ArrayList<MsgCardShowOverflowPluginModel$ActionsItemModel> actions;

    @JSONField(name = "text")
    @LKRequiredParam
    public String text;

    public MsgCardShowOverflowPluginModel$OptionsItemModel() {
    }
}
