package com.qualcomm.qti.qesdk;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class QesdkOutputDataParser extends QesdkDataParser {
    private JSONObject data;

    public QesdkOutputDataParser() {
        super(null);
        this.data = null;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public JSONArray getArgs() {
        return null;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public String getCallType() {
        return null;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public int getNumberOfArgs() {
        return -1;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public int getNumberOfOutputs() {
        JSONObject r8 = getFunction();
        if (r8 != null) goto L7;
        return -1;
    L7:
        return getIntFromJSONObject(QesdkUtils.TAGS.JSON_TAG_NUM_OF_OUTPUTS, r8);
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public JSONArray getOutputs() {
        JSONObject r8 = getFunction();
        if (r8 != null) goto L7;
        return null;
    L7:
        return getJSONArrayFromJSONObject(QesdkUtils.TAGS.JSON_TAG_OUTPUTS, r8);
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public int getStatus() {
        return getIntFromJSONObject("status", null);
    }

    public boolean isRetCb() {
        if (getIntFromJSONObject(-1, QesdkUtils.TAGS.JSON_TAG_RETURN, null) != 0) goto L5;
        return false;
    L5:
        return true;
    }

    public QesdkOutputDataParser(String r8) {
        super(r8);
        this.data = getData();
    }

    public QesdkOutputDataParser(JSONObject r8) {
        super(r8);
        this.data = getData();
    }
}
