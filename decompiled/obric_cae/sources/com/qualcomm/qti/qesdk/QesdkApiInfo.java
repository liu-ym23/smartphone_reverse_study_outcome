package com.qualcomm.qti.qesdk;

import android.text.TextUtils;
import android.util.Pair;
import com.qualcomm.qti.qesdkIntf.IQesdkApiInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class QesdkApiInfo implements IQesdkApiInfo {
    private static final String TAG = "QesdkApiInfo";
    private final Map<String, QesdkFeatureInfo> featureMap;

    public QesdkApiInfo(Map<Pair<String, Integer>, String[]> r8) {
        if (r8 != null) goto L5;
    L7:
        Map r10 = Collections.emptyMap();
    L8:
        this.featureMap = parseApiData(r10);
        return;
    L5:
        if (r8.isEmpty() == true) goto L7;
        r10 = new HashMap(r8);
        goto L8
    }

    private static Map<String, QesdkFeatureInfo> parseApiData(Map<Pair<String, Integer>, String[]> r10) {
        HashMap r8 = new HashMap();
        Iterator<Map.Entry<Pair<String, Integer>, String[]>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L40;
        Map.Entry<Pair<String, Integer>, String[]> r12 = r11.next();
        Pair<String, Integer> r13 = r12.getKey();
        if (r13 == null) goto L4;
        String[] r14 = r12.getValue();
        String r15 = (String) r13.first;
        if (TextUtils.isEmpty(r15) == true) goto L4;
        Integer r16 = (Integer) r13.second;
        QesdkFeatureInfo r17 = (QesdkFeatureInfo) r8.get(r15);
        if (r17 != null) goto L14;
        r17 = new QesdkFeatureInfo(r15);
        r8.put(r15, r17);
    L14:
        if (r16 != null) goto L16;
    L20:
        List<String> r18 = r17.apiNameList;
        List<String> r19 = r17.apiJsonList;
        if (r14 == null) goto L4;
        if (r14.length <= 0) goto L4;
        int r20 = r14.length;
        int r21 = 0;
    L25:
        if (r21 >= r20) goto L4;
        String r22 = r14[r21];
        if (TextUtils.isEmpty(r22) == true) goto L39;
        JSONObject r23 = new JSONObject(r22);     // Catch: JSONException -> L37
        if (r23.has(QesdkUtils.TAGS.JSON_TAG_FUNC) == false) goto L39;
        String r24 = r23.getJSONObject(QesdkUtils.TAGS.JSON_TAG_FUNC).optString(QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: JSONException -> L37
        if (TextUtils.isEmpty(r24) == true) goto L39;
        r18.add(r24);     // Catch: JSONException -> L37
        r19.add(r22);     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L39:
        r21 = r21 + 1;
        goto L25
    L16:
        if (r17.version != null) goto L18;
    L19:
        r17.version = r16;
        goto L20
    L18:
        if (r16.intValue() < r17.version.intValue()) goto L20;
    L40:
        return r8;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkApiInfo
    public List<String> getApiNameList(String r8) {
        QesdkFeatureInfo r10 = this.featureMap.get(r8);
        if (r10 != null) goto L7;
        return Collections.emptyList();
    L7:
        return r10.apiNameList;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkApiInfo
    public List<Pair<String, Integer>> getFeatureList() {
        ArrayList r8 = new ArrayList();
        Map<String, QesdkFeatureInfo> r10 = this.featureMap;
        if (r10 != null) goto L5;
    L14:
        return r8;
    L5:
        if (r10.isEmpty() == true) goto L14;
        Iterator<Map.Entry<String, QesdkFeatureInfo>> r11 = this.featureMap.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L14;
        QesdkFeatureInfo r12 = r11.next().getValue();
        if (r12 == null) goto L9;
        r8.add(new Pair(r12.featureName, r12.version));
        goto L9
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkApiInfo
    public List<String> getFullInfo(String r8) {
        QesdkFeatureInfo r10 = this.featureMap.get(r8);
        if (r10 != null) goto L7;
        return Collections.emptyList();
    L7:
        return r10.apiJsonList;
    }
}
