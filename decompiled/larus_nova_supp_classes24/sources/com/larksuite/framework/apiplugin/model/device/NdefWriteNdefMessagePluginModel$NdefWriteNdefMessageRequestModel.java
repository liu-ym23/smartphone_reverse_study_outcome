package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class NdefWriteNdefMessagePluginModel$NdefWriteNdefMessageRequestModel extends LKBaseRequestModel {

    @JSONField(name = "records")
    public ArrayList<NdefWriteNdefMessagePluginModel$RecordsItemModel> records;

    @JSONField(name = "texts")
    public ArrayList<String> texts;

    @JSONField(name = "uris")
    public ArrayList<String> uris;

    public NdefWriteNdefMessagePluginModel$NdefWriteNdefMessageRequestModel() {
    }
}
