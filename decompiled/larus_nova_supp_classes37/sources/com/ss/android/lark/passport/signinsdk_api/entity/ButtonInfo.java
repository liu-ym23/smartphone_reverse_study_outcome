package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.signinsdk_api.base.BaseStepData;
import com.ss.android.lark.passport.signinsdk_api.contants.ButtonType;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ButtonInfo implements Serializable {

    @JSONField(name = "action_type")
    public int actionType;

    @JSONField(name = "collection_info")
    public CollectionInfo collectionInfo;

    @JSONField(name = "desc")
    public String desc;

    @JSONField(name = "next")
    public BaseStepData next;

    @JSONField(name = "subtitle")
    public String subtitle;
    public String text;

    public ButtonInfo() {
    }

    public ButtonType getButtonType() {
        return ButtonType.fromValue(this.actionType);
    }
}
