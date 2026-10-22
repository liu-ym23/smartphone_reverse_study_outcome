package com.ss.android.lark.passport.signinsdk_api.entity;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class LoginInfo implements Serializable {
    private String avatarKey;
    private String avatarUrl;
    private String idpType;
    private String session;
    private Map<String, SessionInfo> sessionInfoMap;
    private String sessionUuid;
    private String tenantCode;
    private String tenantIconUrl;
    private String tenantId;
    private String tenantName;
    private String userId;
    private String userName;
    private String userNameEn;

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, this.tenantId, this.session});
    }

    public String toString() {
        return "userId:" + this.userId + ", tenantId:" + this.tenantId + ", idpType:" + this.idpType;
    }

    public LoginInfo() {
        this.sessionInfoMap = new HashMap();
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getIdpType() {
        return this.idpType;
    }

    public String getSession() {
        return this.session;
    }

    public Map<String, SessionInfo> getSessionInfoMap() {
        return this.sessionInfoMap;
    }

    public String getSessionUuid() {
        return this.sessionUuid;
    }

    public String getTenantCode() {
        return this.tenantCode;
    }

    public String getTenantIconUrl() {
        return this.tenantIconUrl;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserNameEn() {
        return this.userNameEn;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        LoginInfo r6 = (LoginInfo) r5;
        if (Objects.equals(this.userId, r6.userId) == true) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.tenantId, r6.tenantId) == false) goto L17;
        if (Objects.equals(this.session, r6.session) == false) goto L17;
        return true;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setIdpType(String r1) {
        this.idpType = r1;
    }

    public void setSession(String r1) {
        this.session = r1;
    }

    public void setSessionInfoMap(Map<String, SessionInfo> r1) {
        this.sessionInfoMap = r1;
    }

    public void setSessionUuid(String r1) {
        this.sessionUuid = r1;
    }

    public void setTenantCode(String r3) {
        Log.i("LoginInfo", "tenantCode=" + r3);
        this.tenantCode = r3;
    }

    public void setTenantIconUrl(String r1) {
        this.tenantIconUrl = r1;
    }

    public void setTenantId(String r3) {
        Log.i("LoginInfo", "tenantId=" + r3);
        this.tenantId = r3;
    }

    public void setTenantName(String r1) {
        this.tenantName = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }

    public void setUserName(String r1) {
        this.userName = r1;
    }

    public void setUserNameEn(String r1) {
        this.userNameEn = r1;
    }

    public static LoginInfo fromUser(User r3, Locale r4, String r5) {
        LoginInfo r0 = new LoginInfo();
        r0.session = r3.getSession();
        r0.sessionInfoMap = r3.getSessionWithDomainMap();
        r0.userId = r3.userId;
        r0.userName = r3.localizedDisplayName(r4);
        r0.userNameEn = r3.getUserNameEn();
        r0.avatarUrl = r3.avatarUrl;
        r0.avatarKey = r3.avatarKey;
        com.ss.android.lark.passport.signinsdk_api.account.Tenant r1 = r3.tenant;
        r0.tenantId = r1.tenantId;
        r0.tenantName = r1.localizedName(r4);
        r0.tenantIconUrl = r3.getTenantIconUrl();
        r0.tenantCode = r3.getTenantCode();
        r0.idpType = r5;
        return r0;
    }
}
