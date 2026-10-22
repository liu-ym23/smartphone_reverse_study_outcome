package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class NdefWriteNdefMessagePluginModel$RecordsItemModel implements Serializable {

    @JSONField(name = "id")
    public String id;

    @JSONField(name = "payload")
    public String payload;

    @JSONField(name = "type")
    public String type;

    public NdefWriteNdefMessagePluginModel$RecordsItemModel() {
    }
}
