package com.qualcomm.qti.qesdk;

import com.qualcomm.qti.qesdkIntf.IQesdkFunctionType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class QesdkApiData {
    private static final String TAG = "com.qualcomm.qti.qesdk.QesdkApiData";
    private boolean isGoodData;
    private JSONObject jsnApiData;
    private String rawApiData;

    public QesdkApiData(String r8) {
        this.rawApiData = r8;
        this.jsnApiData = null;
        this.isGoodData = false;
    }

    private int getSubsystemIdFromName(JSONObject r8, String r10) {
        return -1;
    }

    private String getSubsystemNameFromId(JSONObject r8, int r10) {
        return null;
    }

    public JSONArray apiExists(IQesdkFunctionType r8) {
        if (this.isGoodData == true) goto L5;
        return null;
    L5:
        JSONObject r10 = findApi(r8);
        if (r10 == null) goto L14;
        return r10.getJSONArray(QesdkUtils.TAGS.JSON_TAG_ARGS);
    L9:
        e = move-exception;
        String r11 = TAG;
        defpackage.a.k(e, new StringBuilder("apiExists: "), r11);
        return null;
    L14:
        return null;
    }

    public JSONObject findApi(IQesdkFunctionType r10) {
        JSONArray r8 = getOpcodes();
        if (r8 != null) goto L5;
        return null;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r8.length()) goto L22;
        JSONObject r12 = r8.getJSONObject(r11);     // Catch: JSONException -> L20
        if (r12 == null) goto L21;
        String r13 = r12.getString(QesdkUtils.TAGS.JSON_TAG_OPCODE);     // Catch: JSONException -> L13
    L15:
        if (r13 == null) goto L21;
        if (r13.equals(r10.getOpCode()) == false) goto L21;
        return findApiFromSubsystems(getSubsystems(r12), r10);
    L13:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findAPI: "), TAG);
        r13 = null;
    L21:
        r11 = r11 + 1;
    L20:
        QesdkUtils.LOG.e(TAG, "Failed to get opcode at index " + r11);
        goto L21
    L22:
        return null;
    }

    public JSONObject findApiFromFunctions(JSONArray r10, IQesdkFunctionType r11) {
        int r8 = 0;
        JSONObject r12 = null;
    L4:
        if (r8 >= r10.length()) goto L28;
        r12 = r10.getJSONObject(r8);     // Catch: JSONException -> L7
    L9:
        if (r12 == null) goto L27;
        int r13 = r12.getInt(QesdkUtils.TAGS.JSON_TAG_NUM_OF_ARGS);     // Catch: JSONException -> L17
        String r14 = r12.getString(QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: JSONException -> L15
    L20:
        if (r13 == (-1)) goto L27;
        if (r14 == null) goto L27;
        if (r14.equals(r11.getFunctionName()) == false) goto L27;
        if (r13 != r11.getNumberOfArgs()) goto L27;
        return r12;
    L15:
        JSONException e10 = e;
    L19:
        defpackage.a.k(e10, new StringBuilder("findApiFromFunctions: "), TAG);
        r14 = null;
    L17:
        e = move-exception;
        e10 = e;
        r13 = -1;
    L27:
        r8 = r8 + 1;
    L7:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findApiFromFunctions: "), TAG);
        goto L9
    L28:
        return r12;
    }

    public JSONObject findApiFromSubsystems(JSONArray r10, IQesdkFunctionType r11) {
        int r8 = 0;
        JSONObject r12 = null;
    L4:
        if (r8 >= r10.length()) goto L34;
        r12 = r10.getJSONObject(r8);     // Catch: JSONException -> L7
    L9:
        if (r12 == null) goto L33;
        String r13 = r12.getString(QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: JSONException -> L17
        int r14 = r12.getInt("id");     // Catch: JSONException -> L15
    L20:
        if (r13 == null) goto L33;
        if (r14 == (-1)) goto L33;
        if (r13.equals(r11.getSSName()) == false) goto L33;
        if (r14 != r11.getSSId()) goto L33;
        JSONArray r15 = r12.getJSONArray(QesdkUtils.TAGS.JSON_TAG_FUNCS);     // Catch: JSONException -> L28
    L30:
        if (r15 == null) goto L33;
        return findApiFromFunctions(r15, r11);
    L28:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findApiFromSubsystems: "), TAG);
        r15 = null;
    L15:
        JSONException e10 = e;
    L19:
        defpackage.a.k(e10, new StringBuilder("findApiFromSubsystems: "), TAG);
        r14 = -1;
    L17:
        e = move-exception;
        e10 = e;
        r13 = null;
    L33:
        r8 = r8 + 1;
    L7:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findApiFromSubsystems: "), TAG);
        goto L9
    L34:
        return null;
    }

    public JSONObject findElementFromLstOfElements(String r8, JSONArray r10) {
        int r11 = 0;
        JSONObject r12 = null;
    L4:
        if (r11 >= r10.length()) goto L20;
        r12 = r10.getJSONObject(r11);     // Catch: JSONException -> L7
    L9:
        if (r12 == null) goto L19;
        String r13 = r12.getString(QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: JSONException -> L13
    L15:
        if (r13 == null) goto L19;
        if (r8.equals(r13) == false) goto L19;
        return r12;
    L13:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findVectorFromVectors: "), TAG);
        r13 = null;
    L19:
        r11 = r11 + 1;
    L7:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findVectorFromVectors: "), TAG);
        goto L9
    L20:
        return null;
    }

    public JSONObject findJSONObjectFromSubsystems(String r10, JSONArray r11, IQesdkFunctionType r12, String r13) {
        int r8 = 0;
        JSONObject r14 = null;
    L4:
        if (r8 >= r11.length()) goto L34;
        r14 = r11.getJSONObject(r8);     // Catch: JSONException -> L7
    L9:
        if (r14 == null) goto L33;
        String r15 = r14.getString(QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: JSONException -> L17
        int r16 = r14.getInt("id");     // Catch: JSONException -> L15
    L20:
        if (r15 == null) goto L33;
        if (r16 == (-1)) goto L33;
        if (r15.equals(r12.getSSName()) == false) goto L33;
        if (r16 != r12.getSSId()) goto L33;
        JSONArray r17 = r14.getJSONArray(r13);     // Catch: JSONException -> L28
    L30:
        if (r17 == null) goto L33;
        return findElementFromLstOfElements(r10, r17);
    L28:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findApiFromSubsystems: "), TAG);
        r17 = null;
    L15:
        JSONException e10 = e;
    L19:
        defpackage.a.k(e10, new StringBuilder("findVectorFromSubsystems: "), TAG);
        r16 = -1;
    L17:
        e = move-exception;
        e10 = e;
        r15 = null;
    L33:
        r8 = r8 + 1;
    L7:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findApiVectorSubsystems: "), TAG);
        goto L9
    L34:
        return null;
    }

    public JSONObject findJSONObjectWithTag(String r10, IQesdkFunctionType r11, String r12) {
        JSONArray r8 = getOpcodes();
        if (r8 != null) goto L5;
        return null;
    L5:
        int r13 = 0;
    L7:
        if (r13 >= r8.length()) goto L22;
        JSONObject r14 = r8.getJSONObject(r13);     // Catch: JSONException -> L20
        if (r14 == null) goto L21;
        String r15 = r14.getString(QesdkUtils.TAGS.JSON_TAG_OPCODE);     // Catch: JSONException -> L13
    L15:
        if (r15 == null) goto L21;
        if (r15.equals(r11.getOpCode()) == false) goto L21;
        return findJSONObjectFromSubsystems(r10, getSubsystems(r14), r11, r12);
    L13:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("findJSONObjectFromTag: "), TAG);
        r15 = null;
    L21:
        r13 = r13 + 1;
    L20:
        QesdkUtils.LOG.e(TAG, "Failed to get opcode at index " + r13);
        goto L21
    L22:
        return null;
    }

    public JSONObject findStruct(String r8, IQesdkFunctionType r10) {
        return findJSONObjectWithTag(r8, r10, QesdkUtils.TAGS.JSON_TAG_STRUCTS);
    }

    public JSONObject findVector(String r8, IQesdkFunctionType r10) {
        return findJSONObjectWithTag(r8, r10, QesdkUtils.TAGS.JSON_TAG_VECTORS);
    }

    public JSONObject getAPIFromName(String r8) {
        return null;
    }

    public JSONObject getCapabilities() {
        return this.jsnApiData.getJSONObject(QesdkUtils.TAGS.JSON_TAG_CAPABILITY);
    L4:
        e = move-exception;
        String r8 = TAG;
        defpackage.a.k(e, new StringBuilder("getCapabilities: "), r8);
        return null;
    }

    public JSONObject getFullData() {
        if (this.isGoodData == true) goto L7;
        return null;
    L7:
        return this.jsnApiData;
    }

    public JSONObject getFunctionalArea(String r8) {
        return null;
    }

    public JSONArray getGroups() {
        return (JSONArray) this.jsnApiData.get(QesdkUtils.TAGS.JSON_TAG_GROUPS);
    }

    public int getNumOfArgsFromApi(JSONObject r8) {
        return ((Integer) r8.get(QesdkUtils.TAGS.JSON_TAG_NUM_OF_ARGS)).intValue();
    }

    public JSONArray getOpcodes() {
        return getCapabilities().getJSONArray(QesdkUtils.TAGS.JSON_TAG_OPCODES);
    L4:
        e = move-exception;
        String r8 = TAG;
        defpackage.a.k(e, new StringBuilder("getOpcodes: "), r8);
        return null;
    }

    public String getRawData() {
        return this.rawApiData;
    }

    public String getRawDataFromJson() {
        if (this.isGoodData == true) goto L7;
        return null;
    L7:
        return this.jsnApiData.toString();
    }

    public JSONArray getSubsystems(JSONObject r8) {
        return r8.getJSONArray(QesdkUtils.TAGS.JSON_TAG_SUBSYSTEMS);
    L4:
        e = move-exception;
        String r10 = TAG;
        defpackage.a.k(e, new StringBuilder("getSubsystems: "), r10);
        return null;
    }

    public JSONObject getVector(String r8, IQesdkFunctionType r10) {
        if (this.isGoodData == true) goto L7;
        return null;
    L7:
        return findVector(r8, r10);
    }

    public boolean isGoodData() {
        return this.isGoodData;
    }

    public boolean parseApiData() {
        this.jsnApiData = new JSONObject(this.rawApiData);     // Catch: JSONException -> L6
        this.isGoodData = true;
        QesdkUtils.LOG.e(TAG, "full api data: " + this.jsnApiData.toString());
    L5:
        return this.isGoodData;
    L6:
        e = move-exception;
        QesdkUtils.LOG.e(TAG, e.getMessage());
        goto L5
    }
}
