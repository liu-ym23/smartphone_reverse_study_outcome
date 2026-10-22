package com.qualcomm.qti.qesdk;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class QesdkInputDataParser extends QesdkDataParser {
    private JSONObject data;

    public QesdkInputDataParser() {
        super(null);
        this.data = getData();
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
        return getFunction().getInt(QesdkUtils.TAGS.JSON_TAG_NUM_OF_ARGS);
    L5:
        e = move-exception;
        QesdkUtils.LOG.e(QesdkDataParser.LOG_TAG, e.getMessage());
        return -1;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public int getNumberOfOutputs() {
        return -1;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public JSONArray getOutputs() {
        return null;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkDataParser
    public int getStatus() {
        return 1;
    }

    public QesdkInputDataParser(String r8) {
        super(r8);
        this.data = getData();
    }

    public QesdkInputDataParser(JSONObject r8) {
        super(r8);
        this.data = getData();
    }
}
