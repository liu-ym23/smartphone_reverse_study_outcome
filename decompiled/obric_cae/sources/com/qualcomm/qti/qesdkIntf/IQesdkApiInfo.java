package com.qualcomm.qti.qesdkIntf;

import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IQesdkApiInfo {
    List<String> getApiNameList(String r8);

    List<Pair<String, Integer>> getFeatureList();

    List<String> getFullInfo(String r8);
}
