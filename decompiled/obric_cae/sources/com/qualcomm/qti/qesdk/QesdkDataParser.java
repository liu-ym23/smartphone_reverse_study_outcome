package com.qualcomm.qti.qesdk;

import defpackage.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
abstract class QesdkDataParser {
    protected static final String LOG_TAG = "com.qualcomm.qti.qesdk.QesdkDataParser";
    private JSONObject data;
    private boolean isDataSafe;

    public QesdkDataParser() {
        this(null);
    }

    private JSONObject getObjectToUse(JSONObject r8) {
        if (r8 == null) goto L4;
        return r8;
    L4:
        return this.data;
    }

    private void initialize(String r8) {
        if (r8 == null) goto L4;
        JSONObject r10 = parseData(r8);
    L5:
        this.data = r10;
        if (this.data == null) goto L8;
        boolean r11 = true;
    L9:
        this.isDataSafe = r11;
        return;
    L8:
        r11 = false;
        goto L9
    L4:
        r10 = null;
        goto L5
    }

    private JSONObject parseData(String r8) {
        return new JSONObject(r8);
    L4:
        e = move-exception;
        String r10 = LOG_TAG;
        defpackage.a.k(e, new StringBuilder("Failed to parse: "), r10);
        return null;
    }

    public abstract JSONArray getArgs();

    public String getBlobValue() {
        return null;
    }

    public boolean getBooleanFromJSONObject(String r8, JSONObject r10) {
        return getObjectToUse(r10).getBoolean(r8);
    L5:
        e = move-exception;
        String r11 = LOG_TAG;
        defpackage.a.k(e, b.h("Failed to get ", r8, " "), r11);
        return false;
    }

    public boolean getBooleanValue(JSONObject r8) {
        return getBooleanFromJSONObject("value", r8);
    }

    public abstract String getCallType();

    public JSONObject getData() {
        return this.data;
    }

    public double getDoubleValue() {
        return 0.0d;
    }

    public int getEnumValue() {
        return -1;
    }

    public float getFloatValue() {
        return 0.0f;
    }

    public JSONObject getFunction() {
        return getJSONObjectFromJSONObject(QesdkUtils.TAGS.JSON_TAG_FUNC, null);
    }

    public String getFunctionName() {
        JSONObject r8 = getFunction();
        if (r8 != null) goto L7;
        return null;
    L7:
        return getStringFromJSONObject(QesdkUtils.TAGS.JSON_TAG_NAME, r8);
    }

    public int getId(JSONObject r8) {
        return getIntFromJSONObject("id", r8);
    }

    public int getIntFromJSONObject(int r8, String r10, JSONObject r11) {
        return getObjectToUse(r11).getInt(r10);
    L5:
        e = move-exception;
        String r12 = LOG_TAG;
        defpackage.a.k(e, b.h("Failed to get ", r10, " "), r12);
        return r8;
    }

    public int getIntValue(int r8, JSONObject r10) {
        return r10.getInt("value");
    L4:
        e = move-exception;
        String r11 = LOG_TAG;
        defpackage.a.k(e, new StringBuilder("Failed to get value "), r11);
        return r8;
    }

    public JSONArray getJSONArrayFromJSONObject(String r8, JSONObject r10) {
        return getObjectToUse(r10).getJSONArray(r8);
    L5:
        e = move-exception;
        String r11 = LOG_TAG;
        defpackage.a.k(e, b.h("Failed to get ", r8, " "), r11);
        return null;
    }

    public JSONObject getJSONObjectFromJSONObject(String r8, JSONObject r10) {
        return getObjectToUse(r10).getJSONObject(r8);
    L5:
        e = move-exception;
        String r11 = LOG_TAG;
        defpackage.a.k(e, b.h("Failed to get ", r8, " "), r11);
        return null;
    }

    public long getLongFromJSONObject(long r8, String r10, JSONObject r11) {
        return getObjectToUse(r11).getLong(r10);
    L5:
        e = move-exception;
        String r12 = LOG_TAG;
        defpackage.a.k(e, b.h("Failed to get ", r10, " "), r12);
        return r8;
    }

    public String getName() {
        return getStringFromJSONObject(QesdkUtils.TAGS.JSON_TAG_NAME, null);
    }

    public abstract int getNumberOfArgs();

    public abstract int getNumberOfOutputs();

    public String getOpcode() {
        return getStringFromJSONObject(QesdkUtils.TAGS.JSON_TAG_OPCODE, null);
    }

    public abstract JSONArray getOutputs();

    public abstract int getStatus();

    public String getStringFromJSONObject(String r8, JSONObject r10) {
        return getObjectToUse(r10).getString(r8);
    L5:
        e = move-exception;
        String r11 = LOG_TAG;
        defpackage.a.k(e, b.h("Failed to get ", r8, " "), r11);
        return null;
    }

    public String getStringValue(JSONObject r8) {
        return getStringFromJSONObject("value", r8);
    }

    public int getSubsystemId() {
        return getIntFromJSONObject(QesdkUtils.TAGS.JSON_TAG_TRANSAC_ID, null);
    }

    public int getTransactionId() {
        return getIntFromJSONObject(QesdkUtils.TAGS.JSON_TAG_TRANSAC_ID, null);
    }

    public String getType(JSONObject r8) {
        return getStringFromJSONObject("type", r8);
    }

    public JSONArray getVectorValue() {
        return null;
    }

    public boolean isDataSafe() {
        return this.isDataSafe;
    }

    public QesdkDataParser(String r8) {
        initialize(r8);
    }

    public QesdkDataParser(JSONObject r8) {
        this.data = r8;
    }

    public int getIntFromJSONObject(String r8, JSONObject r10) {
        return getObjectToUse(r10).getInt(r8);
    L5:
        e = move-exception;
        String r11 = LOG_TAG;
        defpackage.a.k(e, b.h("Failed to get ", r8, " "), r11);
        return -1;
    }

    public long getLongFromJSONObject(String r8, JSONObject r10) {
        return getObjectToUse(r10).getLong(r8);
    L5:
        e = move-exception;
        String r11 = LOG_TAG;
        defpackage.a.k(e, b.h("Failed to get ", r8, " "), r11);
        return -1;
    }
}
