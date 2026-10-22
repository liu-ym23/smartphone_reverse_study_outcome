package com.ss.android.lark.passport.signinsdk_api.account;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ResponseUser implements Serializable {

    @JSONField(name = "current_env")
    private String currentEnv;

    @JSONField(name = "device_login_id")
    private String deviceLoginId;

    @JSONField(name = "is_anonymous")
    private boolean isAnonymous;

    @JSONField(name = "is_new_active")
    public boolean isNewActive;

    @JSONField(name = "logout_token")
    private String logoutToken;
    private Map<String, SessionInfo> sessionMap;

    @JSONField(name = "session_uuid")
    private String sessionUuid;

    @JSONField(name = "suite_session_key_with_domains")
    private Map<String, SessionInfo> sessionWithDomainMap;

    @JSONField(alternateNames = {"slSession"}, name = "sl_session")
    private String slSession;

    @JSONField(name = "suite_session_key")
    private String suiteSessionKey;

    @JSONField(name = "user")
    private User user;

    public ResponseUser() {
        this.sessionMap = new HashMap();
    }

    public String getCurrentEnv() {
        return this.currentEnv;
    }

    public String getDeviceLoginId() {
        return this.deviceLoginId;
    }

    public String getLogoutToken() {
        return this.logoutToken;
    }

    public String getSession() {
        return this.suiteSessionKey;
    }

    public Map<String, SessionInfo> getSessionMap() {
        return this.sessionMap;
    }

    public String getSessionUuid() {
        return this.sessionUuid;
    }

    public Map<String, SessionInfo> getSessionWithDomainMap() {
        return this.sessionWithDomainMap;
    }

    public String getSlSession() {
        return this.slSession;
    }

    public String getSuiteSessionKey() {
        return this.suiteSessionKey;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    public void setCurrentEnv(String r1) {
        this.currentEnv = r1;
    }

    public void setDeviceLoginId(String r1) {
        this.deviceLoginId = r1;
    }

    public void setLogoutToken(String r1) {
        this.logoutToken = r1;
    }

    public void setSession(String r1) {
        this.suiteSessionKey = r1;
    }

    public void setSessionMap(Map<String, SessionInfo> r1) {
        this.sessionMap = r1;
    }

    public void setSessionUuid(String r1) {
        this.sessionUuid = r1;
    }

    public void setSessionWithDomainMap(Map<String, SessionInfo> r1) {
        this.sessionWithDomainMap = r1;
    }

    public void setSlSession(String r1) {
        this.slSession = r1;
    }

    public void setSuiteSessionKey(String r1) {
        this.suiteSessionKey = r1;
    }

    public void setUser(User r1) {
        this.user = r1;
    }

    public ResponseUser(String r2, String r3) {
        this(r2, r3, null);
    }

    public ResponseUser(String r2, String r3, Map<String, SessionInfo> r4) {
        this.sessionMap = new HashMap();
        this.suiteSessionKey = r3;
        if (r4 == null) goto L11;
        Iterator<Map.Entry<String, SessionInfo>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L17;
        Map.Entry<String, SessionInfo> r6 = r5.next();
        SessionInfo r7 = r6.getValue();
        if (r7 == null) goto L7;
        r7.setHostUrl(r6.getKey());
        this.sessionMap.put(r6.getKey(), r7);
        goto L7
    L17:
        return;
    }
}
