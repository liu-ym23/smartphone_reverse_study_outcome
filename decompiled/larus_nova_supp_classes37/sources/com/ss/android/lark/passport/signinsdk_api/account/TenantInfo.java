package com.ss.android.lark.passport.signinsdk_api.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.signinsdk_api.account.config.AccountSecurityConfig;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class TenantInfo implements Serializable {
    private AccountSecurityConfig accountSecurityConfig;
    private String avatarUrl;
    private int badgeCount;
    private String chatterAvatarKey;
    private String configEnv;
    private boolean isCurrentUser;
    private boolean isIdp;
    private boolean isSessionValid;
    private final boolean isToCUnRegistered;
    private long lastUseTimestamp;
    private int status;
    private String suitFullDomain;
    private String tenantCode;
    private String tenantId;
    private String tenantName;
    private int tenantTag;
    private String unitLeague;
    private boolean upgradeEnabled;
    private String userAvatarUrl;
    private String userId;
    private String userName;
    private String userNameEn;
    private String userUnit;

    public static class PendingUser implements Serializable {

        @JSONField(name = "user_env")
        public String configEnv;
        public String tenantIconUrl;
        public String tenantId;
        public String tenantName;
        public String userName;
        public String userUnit;

        public PendingUser() {
        }
    }

    public boolean isToCUnRegistered() {
        return false;
    }

    public void setActive(boolean r1) {
    }

    public boolean canSwitchTo() {
        int r0 = this.status;
        if (r0 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 3) goto L8;
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, Integer.valueOf(this.badgeCount), Boolean.valueOf(this.isCurrentUser), this.userName, this.userNameEn, this.chatterAvatarKey, this.avatarUrl, this.tenantId, this.tenantName, this.tenantCode, Boolean.FALSE, this.userUnit, Integer.valueOf(this.tenantTag), this.accountSecurityConfig, Boolean.valueOf(this.isIdp)});
    }

    public boolean isFrozen() {
        if (this.status != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNewUser() {
        if (this.status != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public void setUpgradeEnabled() {
        this.upgradeEnabled = this.upgradeEnabled;
    }

    public String toString() {
        return "TenantInfo{userId='" + this.userId + "', tenantId='" + this.tenantId + "', userUnit='" + this.userUnit + "', tenantTag='" + this.tenantTag + "', isIdp='" + this.isIdp + "', status='" + this.status + ", isSessionValid='" + isSessionValid() + "', isNewUser='" + isNewUser() + "', canSwitchTo='" + canSwitchTo() + "'}";
    }

    public TenantInfo() {
        this.isCurrentUser = false;
        this.upgradeEnabled = false;
        this.isToCUnRegistered = false;
    }

    public AccountSecurityConfig getAccountSecurityConfig() {
        return this.accountSecurityConfig;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    public String getChatterAvatarKey() {
        return this.chatterAvatarKey;
    }

    public String getConfigEnv() {
        return this.configEnv;
    }

    public long getLastUseTimestamp() {
        return this.lastUseTimestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSuitFullDomain() {
        return this.suitFullDomain;
    }

    public String getTenantCode() {
        return this.tenantCode;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public int getTenantTag() {
        return this.tenantTag;
    }

    public String getUnitLeague() {
        return this.unitLeague;
    }

    public String getUserAvatarUrl() {
        return this.userAvatarUrl;
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

    public String getUserUnit() {
        return this.userUnit;
    }

    public boolean isCurrentUser() {
        return this.isCurrentUser;
    }

    public boolean isIdp() {
        return this.isIdp;
    }

    public boolean isSessionValid() {
        return this.isSessionValid;
    }

    public boolean isUpgradeEnabled() {
        return this.upgradeEnabled;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L43:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L43;
        TenantInfo r6 = (TenantInfo) r5;
        if (this.badgeCount == r6.badgeCount) goto L13;
    L41:
        return false;
    L13:
        if (this.isCurrentUser != r6.isCurrentUser) goto L41;
        if (this.tenantTag != r6.tenantTag) goto L41;
        if (this.isIdp != r6.isIdp) goto L41;
        if (this.status != r6.status) goto L41;
        if (Objects.equals(this.userId, r6.userId) == false) goto L41;
        if (Objects.equals(this.userName, r6.userName) == false) goto L41;
        if (Objects.equals(this.userNameEn, r6.userNameEn) == false) goto L41;
        if (Objects.equals(this.chatterAvatarKey, r6.chatterAvatarKey) == false) goto L41;
        if (Objects.equals(this.avatarUrl, r6.avatarUrl) == false) goto L41;
        if (Objects.equals(this.tenantId, r6.tenantId) == false) goto L41;
        if (Objects.equals(this.tenantName, r6.tenantName) == false) goto L41;
        if (Objects.equals(this.tenantCode, r6.tenantCode) == false) goto L41;
        if (Objects.equals(this.userUnit, r6.userUnit) == false) goto L41;
        if (Objects.equals(this.accountSecurityConfig, r6.accountSecurityConfig) == false) goto L41;
        return true;
    }

    public void setAccountSecurityConfig(AccountSecurityConfig r1) {
        this.accountSecurityConfig = r1;
    }

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setBadgeCount(int r1) {
        this.badgeCount = r1;
    }

    public void setChatterAvatarKey(String r1) {
        this.chatterAvatarKey = r1;
    }

    public void setConfigEnv(String r1) {
        this.configEnv = r1;
    }

    public void setCurrentUser(boolean r1) {
        this.isCurrentUser = r1;
    }

    public void setIdp(boolean r1) {
        this.isIdp = r1;
    }

    public void setSessionValid(boolean r1) {
        this.isSessionValid = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    public void setSuitFullDomain(String r1) {
        this.suitFullDomain = r1;
    }

    public void setTenantCode(String r1) {
        this.tenantCode = r1;
    }

    public void setTenantId(String r1) {
        this.tenantId = r1;
    }

    public void setTenantName(String r1) {
        this.tenantName = r1;
    }

    public void setTenantTag(int r1) {
        this.tenantTag = r1;
    }

    public void setUnitLeague(String r1) {
        this.unitLeague = r1;
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

    public void setUserUnit(String r1) {
        this.userUnit = r1;
    }

    public static TenantInfo fromUser(User r26, Locale r27, boolean r28, boolean r29) {
        Tenant r1 = r26.tenant;
        if (r1 == null) goto L5;
        String r8 = r1.localizedName(r27);
    L6:
        String r4 = r26.userId;
        String r5 = r26.localizedDisplayName(r27);
        I18Name r3 = r26.i18Name;
        if (r3 != null) goto L9;
        String r6 = "";
    L10:
        String r7 = r26.getTenantId();
        String r9 = r26.getTenantCode();
        String r10 = r26.avatarKey;
        String r11 = r26.getTenantIconUrl();
        String r14 = r26.configEnv;
        String r15 = r26.userUnit;
        int r16 = r26.getTenantTag();
        AccountSecurityConfig r13 = r26.accountSecurityConfig;
        boolean r12 = r26.isIdp;
        String r17 = r26.avatarUrl;
        Tenant r2 = r26.tenant;
        if (r2 != null) goto L13;
        String r20 = "";
    L15:
        return new TenantInfo(r4, r5, r6, r7, r8, r9, r10, r11, 0, r28, r14, r15, r16, r13, r12, r17, r20, "", r26.getStatus(), r29, r26.getLastUseTimestamp());
    L13:
        r20 = r2.suiteFullDomain;
        goto L15
    L9:
        r6 = r3.enUs;
        goto L10
    L5:
        r8 = "";
        goto L6
    }

    public TenantInfo(String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, int r32, boolean r33, boolean r34, String r35, String r36, int r37, AccountSecurityConfig r38, boolean r39, String r40, String r41, String r42, long r43) {
        this(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r35, r36, r37, r38, r39, r40, r41, r42, 0, false, r43);
    }

    public TenantInfo(String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, int r12, boolean r13, String r14, String r15, int r16, AccountSecurityConfig r17, boolean r18, String r19, String r20, String r21, int r22, boolean r23, long r24) {
        this.upgradeEnabled = false;
        this.isToCUnRegistered = false;
        this.userId = r4;
        this.userName = r5;
        this.userNameEn = r6;
        this.tenantId = r7;
        this.tenantName = r8;
        this.tenantCode = r9;
        this.chatterAvatarKey = r10;
        this.avatarUrl = r11;
        this.badgeCount = r12;
        this.isCurrentUser = r13;
        this.configEnv = r14;
        this.userUnit = r15;
        this.tenantTag = r16;
        this.accountSecurityConfig = r17;
        this.isIdp = r18;
        this.userAvatarUrl = r19;
        this.suitFullDomain = r20;
        this.unitLeague = r21;
        this.status = r22;
        this.isSessionValid = r23;
        this.lastUseTimestamp = r24;
    }
}
