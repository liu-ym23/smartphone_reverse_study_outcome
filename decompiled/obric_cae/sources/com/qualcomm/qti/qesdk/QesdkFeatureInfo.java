package com.qualcomm.qti.qesdk;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class QesdkFeatureInfo {
    public final List<String> apiJsonList;
    public final List<String> apiNameList;
    public String featureName;
    public Integer version;

    public QesdkFeatureInfo(String r8) {
        this.featureName = r8;
        this.version = Integer.MIN_VALUE;
        this.apiNameList = new ArrayList();
        this.apiJsonList = new ArrayList();
    }
}
