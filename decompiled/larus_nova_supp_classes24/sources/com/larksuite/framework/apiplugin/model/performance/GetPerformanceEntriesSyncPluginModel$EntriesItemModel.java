package com.larksuite.framework.apiplugin.model.performance;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class GetPerformanceEntriesSyncPluginModel$EntriesItemModel implements Serializable {

    @JSONField(name = "duration")
    public long duration;

    @JSONField(name = "entryType")
    @LKRequiredParam
    public String entryType;

    @JSONField(name = "fileName")
    public String fileName;

    @JSONField(name = "isPreload")
    public boolean isPreload;

    @JSONField(name = "name")
    @LKRequiredParam
    public String name;

    @JSONField(name = "startTime")
    @LKRequiredParam
    public long startTime;

    @JSONField(name = "webviewId")
    public int webviewId;

    public GetPerformanceEntriesSyncPluginModel$EntriesItemModel() {
    }
}
