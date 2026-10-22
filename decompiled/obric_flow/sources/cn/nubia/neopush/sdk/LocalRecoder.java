package cn.nubia.neopush.sdk;

import ai.j0;
import android.text.TextUtils;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import java.io.Serializable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocalRecoder implements Serializable {
    private String alias;
    private long aliasSetTime;
    private String appId;
    private String appKey;
    private long lastTopicGetTime;
    private String packageName;
    private String regId;
    private long registerTime;
    private long topicSetTime;
    private List<String> topics;

    public LocalRecoder() {
        this.aliasSetTime = -1;
        this.topicSetTime = -1;
        this.lastTopicGetTime = -1;
        this.registerTime = -1;
    }

    public static LocalRecoder parserFromSp(String r10) {
        LocalRecoder r5 = null;
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return null;
    L15:
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L10
        LocalRecoder r12 = new LocalRecoder();     // Catch: JSONException -> L10
        r12.setAlias(r11.optString(Constant.ALIAS));     // Catch: JSONException -> L8
        r12.setAliasSetTime(r11.optLong(Constant.ALIAS_SET_TIME, -1));     // Catch: JSONException -> L8
        r12.setAppId(r11.optString(Constant.APPID));     // Catch: JSONException -> L8
        r12.setAppKey(r11.optString(Constant.APPKEY));     // Catch: JSONException -> L8
        r12.setRegisterTime(r11.optLong(Constant.REGISTER_SET_TIME, -1));     // Catch: JSONException -> L8
        r12.setTopics(SDKUtils.parseTopicJSONToList(r11.optString(Constant.TOPICS)));     // Catch: JSONException -> L8
        r12.setTopicSetTime(r11.optLong(Constant.TOPIC_SET_TIME, -1));     // Catch: JSONException -> L8
        r12.setLastTopicGetTime(r11.optLong(Constant.LAST_TOPIC_GET_TIME, -1));     // Catch: JSONException -> L8
        r12.setRegId(r11.optString(Constant.REG_ID));     // Catch: JSONException -> L8
        r12.setPackageName(r11.optString(Constant.PACKAGE_NAME));     // Catch: JSONException -> L8
        return r12;
    L8:
        e = e;
        r5 = r12;
    L11:
        e.printStackTrace();
        return r5;
    L10:
        e = e;
        goto L11
    }

    public String buildToSp() {
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L4
        r5.put(Constant.APPID, getAppId());     // Catch: Exception -> L4
        r5.put(Constant.APPKEY, getAppKey());     // Catch: Exception -> L4
        r5.put(Constant.ALIAS, getAlias());     // Catch: Exception -> L4
        r5.put(Constant.ALIAS_SET_TIME, getAliasSetTime());     // Catch: Exception -> L4
        r5.put(Constant.TOPICS, SDKUtils.generateTopicListToJSON(getTopics()));     // Catch: Exception -> L4
        r5.put(Constant.TOPIC_SET_TIME, getTopicSetTime());     // Catch: Exception -> L4
        r5.put(Constant.LAST_TOPIC_GET_TIME, getLastTopicGetTime());     // Catch: Exception -> L4
        r5.put(Constant.REGISTER_SET_TIME, getRegisterTime());     // Catch: Exception -> L4
        r5.put(Constant.PACKAGE_NAME, getPackageName());     // Catch: Exception -> L4
        r5.put(Constant.REG_ID, getRegId());     // Catch: Exception -> L4
        return r5.toString();
    L4:
        e = move-exception;
        NeoLog.i("buildToSp =" + e.getMessage());
        return null;
    }

    public String getAlias() {
        return this.alias;
    }

    public long getAliasSetTime() {
        return this.aliasSetTime;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public long getLastTopicGetTime() {
        return this.lastTopicGetTime;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getRegId() {
        return this.regId;
    }

    public long getRegisterTime() {
        return this.registerTime;
    }

    public long getTopicSetTime() {
        return this.topicSetTime;
    }

    public List<String> getTopics() {
        return this.topics;
    }

    public void setAlias(String r5) {
        this.alias = r5;
    }

    public void setAliasSetTime(long r5) {
        this.aliasSetTime = r5;
    }

    public void setAppId(String r5) {
        this.appId = r5;
    }

    public void setAppKey(String r5) {
        this.appKey = r5;
    }

    public void setLastTopicGetTime(long r5) {
        this.lastTopicGetTime = r5;
    }

    public void setPackageName(String r5) {
        this.packageName = r5;
    }

    public void setRegId(String r5) {
        this.regId = r5;
    }

    public void setRegisterTime(long r5) {
        this.registerTime = r5;
    }

    public void setTopicSetTime(long r5) {
        this.topicSetTime = r5;
    }

    public void setTopics(List<String> r5) {
        this.topics = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("LocalRecoder{appId='");
        r5.append(this.appId);
        r5.append("'appkey='");
        r5.append(this.appKey);
        r5.append("', alias='");
        r5.append(this.alias);
        r5.append("', aliasSetTime=");
        r5.append(this.aliasSetTime);
        r5.append(", topics=");
        r5.append(this.topics);
        r5.append(", topicSetTime=");
        r5.append(this.topicSetTime);
        r5.append(", lastTopicGetTime=");
        r5.append(this.lastTopicGetTime);
        r5.append(", registerTime=");
        r5.append(this.registerTime);
        r5.append(", packageName='");
        r5.append(this.packageName);
        r5.append("', regId='");
        return j0.q(r5, this.regId, "'}");
    }
}
