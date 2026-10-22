package com.bytedance.apm6.java_alloc.model;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ReportData {
    public JSONObject config;
    public long duration;
    public List<ReportInfo> infoList;

    public ReportData(List<ReportInfo> r10, long r11, JSONObject r12) {
        this.infoList = r10;
        this.duration = r11;
        this.config = r12;
    }
}
