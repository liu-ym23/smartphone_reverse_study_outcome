package com.bytedance.apm6.java_alloc.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ReportData {
    public JSONObject config;
    public long duration;
    public List<ReportInfo> infoList;

    public ReportData(List<ReportInfo> r3, long r4, JSONObject r6) {
        this.infoList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.duration = r4;
        this.config = r6;
    }
}
