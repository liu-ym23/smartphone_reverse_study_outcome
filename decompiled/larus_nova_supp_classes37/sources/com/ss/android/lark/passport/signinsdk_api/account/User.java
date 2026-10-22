package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.signinsdk_api.account.config.AccountSecurityConfig;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class User implements Serializable, Parcelable {
    public static final Parcelable.Creator<User> CREATOR = null;

    @JSONField(name = "account_security_config")
    public AccountSecurityConfig accountSecurityConfig;

    @JSONField(name = "avatar_key")
    public String avatarKey;

    @JSONField(name = "avatar_url")
    public String avatarUrl;

    @JSONField(name = "user_env")
    public String configEnv;

    @JSONField(name = "create_time")
    public long createTime;
    private String currentEnv;
    private String deviceLoginId;

    @JSONField(name = "display_name")
    public String displayName;

    @JSONField(name = "en_name")
    public String enName;

    @JSONField(name = "exclude_login")
    private boolean excludeLogin;

    @JSONField(name = "i18n_display_names")
    public I18Name i18DisplayName;

    @JSONField(name = "i18n_names")
    public I18Name i18Name;
    private boolean isAnonymous;

    @JSONField(name = "is_guest")
    public boolean isGuest;

    @JSONField(name = "is_idp")
    public boolean isIdp;
    private boolean isNewActive;
    private boolean isSessionValid;
    private boolean isSessionValidOrForeground;

    @JSONField(name = "is_tenant_creator")
    public boolean isTenantCreator;
    private long lastUseTimestamp;

    @JSONField(name = "lean_mode_info")
    public LeanModeInfo leanModeInfo;

    @JSONField(name = "login_credential_id")
    private String loginCredentialId;
    private String logoutToken;
    public String name;
    private String session;
    private String sessionUuid;

    @JSONField(name = "suite_session_key_with_domains")
    private Map<String, SessionInfo> sessionWithDomainMap;
    private String slSession;
    private int status;
    public Tenant tenant;

    @JSONField(name = "tenant_tag")
    private int tenantTag;

    @JSONField(name = "user_custom_attr")
    public JSONArray userCustomAttr;

    @JSONField(name = "geo")
    public String userGeo;

    @JSONField(alternateNames = {"id"}, name = "user_id")
    public String userId;

    @JSONField(name = "unit")
    public String userUnit;

    public class a implements Parcelable.Creator<User> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final User createFromParcel(Parcel r2) {
            return new User(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final User[] newArray(int r1) {
            return new User[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String a() {
        if (TextUtils.isEmpty(this.userUnit) == false) goto L6;
        return "";
    L6:
        String r0 = this.userUnit;
        r0.getClass();
        byte r2 = -1;
        switch(r0.hashCode()) {
            case 93912099: goto L30;
            case 93912675: goto L26;
            case 96855691: goto L22;
            case 96855972: goto L18;
            case 878174793: goto L14;
            case 886218363: goto L10;
            default: goto L33;
        };
    L33:
        String r1 = "feishu";
        switch(r2) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L36;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L36;
            default: goto L38;
        };
    L36:
        r1 = "lark";
    L38:
        return r1;
    L10:
        if (r0.equals("larksgaws") == false) goto L33;
        r2 = 5;
        goto L33
    L14:
        if (r0.equals("larkjpaws") == false) goto L33;
        r2 = 4;
        goto L33
    L18:
        if (r0.equals("eu_nc") == false) goto L33;
        r2 = 3;
        goto L33
    L22:
        if (r0.equals("eu_ea") == false) goto L33;
        r2 = 2;
        goto L33
    L26:
        if (r0.equals(EnvConst$UNIT.BOE_VA) == false) goto L33;
        r2 = 1;
        goto L33
    L30:
        if (r0.equals(EnvConst$UNIT.BOE_CN) == false) goto L33;
        r2 = 0;
        goto L33
    }

    public String getTenantBrand() {
        Tenant r0 = this.tenant;
        if (r0 != null) goto L7;
        return a();
    L7:
        if (TextUtils.isEmpty(r0.getTenantBrand()) == true) goto L11;
        return this.tenant.getTenantBrand();
    L11:
        return a();
    }

    public String getTenantCode() {
        Tenant r0 = this.tenant;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.tenantDomain;
    }

    public String getTenantGeo() {
        Tenant r0 = this.tenant;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTenantGeo();
    }

    public String getTenantIconUrl() {
        Tenant r0 = this.tenant;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.iconUrl;
    }

    public String getTenantId() {
        Tenant r0 = this.tenant;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.tenantId;
    }

    public String getTenantName() {
        Tenant r0 = this.tenant;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.name;
    }

    public int getTenantTag() {
        Tenant r0 = this.tenant;
        if (r0 == null) goto L7;
        return r0.tag;
    L7:
        return this.tenantTag;
    }

    public JSONArray getUserCustomAttr() {
        JSONArray r0 = this.userCustomAttr;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new JSONArray();
    }

    public String getUserGeo() {
        if (TextUtils.isEmpty(this.userGeo) == false) goto L5;
        String r1 = "";
        if (TextUtils.isEmpty(this.userUnit) == true) goto L45;
        String r0 = this.userUnit;
        r0.getClass();
        byte r3 = -1;
        switch(r0.hashCode()) {
            case 93912099: goto L33;
            case 93912675: goto L29;
            case 96855691: goto L25;
            case 96855972: goto L21;
            case 878174793: goto L17;
            case 886218363: goto L13;
            default: goto L36;
        };
    L36:
        switch(r3) {
            case 0: goto L43;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            default: goto L45;
        };
    L38:
        r1 = EnvConst$GEO.SG;
        goto L45
    L39:
        r1 = EnvConst$GEO.JP;
        goto L45
    L40:
        r1 = EnvConst$GEO.CN;
        goto L45
    L41:
        r1 = EnvConst$GEO.US;
        goto L45
    L42:
        r1 = EnvConst$GEO.BOE_US;
        goto L45
    L43:
        r1 = EnvConst$GEO.BOE_CN;
        goto L45
    L13:
        if (r0.equals("larksgaws") == false) goto L36;
        r3 = 5;
        goto L36
    L17:
        if (r0.equals("larkjpaws") == false) goto L36;
        r3 = 4;
        goto L36
    L21:
        if (r0.equals("eu_nc") == false) goto L36;
        r3 = 3;
        goto L36
    L25:
        if (r0.equals("eu_ea") == false) goto L36;
        r3 = 2;
        goto L36
    L29:
        if (r0.equals(EnvConst$UNIT.BOE_VA) == false) goto L36;
        r3 = 1;
        goto L36
    L33:
        if (r0.equals(EnvConst$UNIT.BOE_CN) == false) goto L36;
        r3 = 0;
    L45:
        return r1;
    L5:
        return this.userGeo;
    }

    public String getUserNameEn() {
        I18Name r0 = this.i18Name;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.enUs;
    }

    public boolean hasValidSession() {
        if (TextUtils.isEmpty(this.session) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.isAnonymous == true) goto L9;
        if (this.isSessionValid == false) goto L9;
        return true;
    }

    public boolean hasValidSessionOrForeground() {
        if (TextUtils.isEmpty(this.session) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.isAnonymous == true) goto L9;
        if (this.isSessionValidOrForeground == false) goto L9;
        return true;
    }

    public boolean isC() {
        return UserInfo.NONE_NAME_CARD_ID.equals(getTenantId());
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("userId:");
        r0.append(this.userId);
        r0.append(", avatarKey:");
        String r1 = this.avatarKey;
        String r2 = "null";
        if (r1 != null) goto L6;
        String r3 = "null";
    L12:
        r0.append(r3);
        r0.append(", tenantId:");
        r0.append(getTenantId());
        r0.append(", tenantCode:");
        r0.append(getTenantCode());
        r0.append(", configEnv:");
        r0.append(this.configEnv);
        r0.append(", tenantTag:");
        r0.append(this.tenantTag);
        r0.append(", userCustomAttr:");
        r0.append(this.userCustomAttr);
        r0.append(", leanModeInfo:");
        LeanModeInfo r4 = this.leanModeInfo;
        if (r4 == null) goto L16;
        r2 = r4.toString();
    L16:
        r0.append(r2);
        return r0.toString();
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r3 = "empty";
        goto L12
    L9:
        if (r1.length() > 24) goto L11;
        r3 = "less 24";
        goto L12
    L11:
        String r5 = r1.substring(0, 12);
        String r6 = r1.substring(r1.length() - 12);
        r3 = r5 + new Regex("[\\s\\S]").replace(r1.substring(12, r1.length() - 12), "*") + r6;
        goto L12
    }

    public User() {
        this.isTenantCreator = false;
        this.isSessionValid = true;
        this.isSessionValidOrForeground = true;
        this.isNewActive = false;
        this.tenantTag = 0;
    }

    public boolean isSmallB() {
        if (isC() == false) goto L5;
        return false;
    L5:
        int r0 = getTenantTag();
        if (r0 != 1) goto L8;
    L9:
        return true;
    L8:
        if (r0 == 2) goto L9;
        return false;
    }

    public String getConfigEnv() {
        return this.configEnv;
    }

    public String getCurrentEnv() {
        return this.currentEnv;
    }

    public String getDeviceLoginId() {
        return this.deviceLoginId;
    }

    public long getLastUseTimestamp() {
        return this.lastUseTimestamp;
    }

    public String getLoginCredentialId() {
        return this.loginCredentialId;
    }

    public String getLogoutToken() {
        return this.logoutToken;
    }

    public String getSession() {
        return this.session;
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

    public int getStatus() {
        return this.status;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.name;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isExcludeLogin() {
        return this.excludeLogin;
    }

    public boolean isIdp() {
        return this.isIdp;
    }

    public boolean isNewActive() {
        return this.isNewActive;
    }

    public User(Parcel r5) {
        boolean r0 = false;
        this.isTenantCreator = false;
        this.isSessionValid = true;
        this.isSessionValidOrForeground = true;
        this.isNewActive = false;
        this.tenantTag = 0;
        this.userId = r5.readString();
        this.name = r5.readString();
        this.i18Name = (I18Name) r5.readParcelable(I18Name.class.getClassLoader());
        this.displayName = r5.readString();
        this.i18DisplayName = (I18Name) r5.readParcelable(I18Name.class.getClassLoader());
        this.status = r5.readInt();
        this.tenant = (Tenant) r5.readParcelable(Tenant.class.getClassLoader());
        this.avatarUrl = r5.readString();
        this.avatarKey = r5.readString();
        this.createTime = r5.readLong();
        this.loginCredentialId = r5.readString();
        this.userUnit = r5.readString();
        if (r5.readByte() == 0) goto L5;
        boolean r2 = true;
    L6:
        this.excludeLogin = r2;
        this.configEnv = r5.readString();
        this.lastUseTimestamp = r5.readLong();
        this.session = r5.readString();
        this.slSession = r5.readString();
        this.currentEnv = r5.readString();
        this.logoutToken = r5.readString();
        this.deviceLoginId = r5.readString();
        if (r5.readByte() == 0) goto L9;
        boolean r3 = true;
    L10:
        this.isAnonymous = r3;
        if (r5.readByte() == 0) goto L13;
        boolean r4 = true;
    L14:
        this.isSessionValid = r4;
        if (r5.readByte() == 0) goto L17;
        boolean r6 = true;
    L18:
        this.isSessionValidOrForeground = r6;
        this.userGeo = r5.readString();
        if (r5.readByte() == 0) goto L21;
        boolean r7 = true;
    L22:
        this.isIdp = r7;
        if (r5.readByte() == 0) goto L25;
        boolean r8 = true;
    L26:
        this.isGuest = r8;
        if (r5.readByte() == 0) goto L29;
        boolean r9 = true;
    L30:
        this.isTenantCreator = r9;
        if (r5.readByte() == 0) goto L33;
        r0 = true;
    L33:
        this.isNewActive = r0;
        this.tenantTag = r5.readInt();
        this.enName = r5.readString();
        HashMap r1 = new HashMap();
        this.sessionWithDomainMap = r1;
        r5.readMap(r1, getClass().getClassLoader());
        String r10 = r5.readString();
        Intrinsics.checkNotNullParameter(r10, "str");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L36
        Object r12 = Result.constructor-impl(JSON.parseArray(r10));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r12) == false) goto L41;
        r12 = null;
    L41:
        JSONArray r13 = (JSONArray) r12;
        if (r13 != null) goto L44;
        r13 = new JSONArray();
    L44:
        this.userCustomAttr = r13;
        this.leanModeInfo = (LeanModeInfo) r5.readParcelable(LeanModeInfo.class.getClassLoader());
        return;
    L36:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L29:
        r9 = false;
        goto L30
    L25:
        r8 = false;
        goto L26
    L21:
        r7 = false;
        goto L22
    L17:
        r6 = false;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public String localizedDisplayName(Locale r4) {
        if (Objects.equals(this.displayName, this.name) == true) goto L5;
        if (r4 == null) goto L8;
        String r0 = this.displayName;
        if (this.i18DisplayName != null) goto L12;
    L24:
        if (r0 == null) goto L28;
        if (r0.length() == 0) goto L28;
        return r0;
    L28:
        return localizedName(r4);
    L12:
        if (r4.getLanguage().equals(Locale.CHINESE.getLanguage()) == false) goto L17;
        if (TextUtils.isEmpty(this.i18DisplayName.zhCn) == true) goto L24;
        r0 = this.i18DisplayName.zhCn;
        goto L24
    L17:
        if (r4.getLanguage().equals(Locale.JAPANESE.getLanguage()) == false) goto L22;
        if (TextUtils.isEmpty(this.i18DisplayName.jaJp) == true) goto L22;
        r0 = this.i18DisplayName.jaJp;
    L22:
        if (TextUtils.isEmpty(this.i18DisplayName.enUs) == true) goto L24;
        r0 = this.i18DisplayName.enUs;
        goto L24
    L8:
        return this.displayName;
    L5:
        return localizedName(r4);
    }

    public String localizedName(Locale r4) {
        if (r4 == null) goto L4;
        String r0 = this.name;
        if (this.i18Name != null) goto L8;
        return r0;
    L8:
        if (r4.getLanguage().equals(Locale.CHINESE.getLanguage()) == false) goto L13;
        if (TextUtils.isEmpty(this.i18Name.zhCn) == false) goto L23;
        return r0;
    L23:
        return this.i18Name.zhCn;
    L13:
        if (r4.getLanguage().equals(Locale.JAPANESE.getLanguage()) == false) goto L18;
        if (TextUtils.isEmpty(this.i18Name.jaJp) == true) goto L18;
        return this.i18Name.jaJp;
    L18:
        if (TextUtils.isEmpty(this.i18Name.enUs) == false) goto L20;
        return r0;
    L20:
        return this.i18Name.enUs;
    L4:
        return this.name;
    }

    public void mergeWithResponseUser(ResponseUser r4) {
        setSession(r4.getSession());
        if (TextUtils.isEmpty(r4.getSlSession()) == true) goto L5;
        setSlSession(r4.getSlSession());
    L5:
        setSessionUuid(r4.getSessionUuid());
        setLogoutToken(r4.getLogoutToken());
        setCurrentEnv(r4.getCurrentEnv());
        setAnonymous(r4.isAnonymous());
        setDeviceLoginId(r4.getDeviceLoginId());
        this.isNewActive = r4.isNewActive;
        Map<String, SessionInfo> r0 = r4.getSessionWithDomainMap();
        if (r0 == null) goto L13;
        Iterator<Map.Entry<String, SessionInfo>> r1 = r0.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        Map.Entry<String, SessionInfo> r2 = r1.next();
        if (r2.getValue() == null) goto L9;
        r2.getValue().setHostUrl(r2.getKey());
    L13:
        setSessionWithDomainMap(r4.getSessionWithDomainMap());
    }

    public void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    public void setConfigEnv(String r1) {
        this.configEnv = r1;
    }

    public void setCurrentEnv(String r1) {
        this.currentEnv = r1;
    }

    public void setDeviceLoginId(String r1) {
        this.deviceLoginId = r1;
    }

    public void setExcludeLogin(boolean r1) {
        this.excludeLogin = r1;
    }

    public void setIdp(boolean r1) {
        this.isIdp = r1;
    }

    public void setLastUseTimestamp(long r1) {
        this.lastUseTimestamp = r1;
    }

    public void setLoginCredentialId(String r1) {
        this.loginCredentialId = r1;
    }

    public void setLogoutToken(String r1) {
        this.logoutToken = r1;
    }

    public void setSession(String r1) {
        this.session = r1;
    }

    public void setSessionUuid(String r1) {
        this.sessionUuid = r1;
    }

    public void setSessionValid(boolean r1) {
        this.isSessionValid = r1;
    }

    public void setSessionValidOrForeground(boolean r1) {
        this.isSessionValidOrForeground = r1;
    }

    public void setSessionWithDomainMap(Map<String, SessionInfo> r1) {
        this.sessionWithDomainMap = r1;
    }

    public void setSlSession(String r1) {
        this.slSession = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    public void setTenantBrand(String r2) {
        if (this.tenant != null) goto L5;
        this.tenant = new Tenant();
    L5:
        this.tenant.setTenantBrand(r2);
    }

    public void setTenantName(String r2) {
        if (this.tenant != null) goto L5;
        this.tenant = new Tenant();
    L5:
        this.tenant.name = r2;
    }

    public void setTenantTag(int r2) {
        this.tenantTag = r2;
        Tenant r0 = this.tenant;
        if (r0 == null) goto L6;
        r0.tag = r2;
        return;
    }

    public void setUserGeo(String r1) {
        this.userGeo = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.userId);
        r3.writeString(this.name);
        r3.writeParcelable(this.i18Name, r4);
        r3.writeString(this.displayName);
        r3.writeParcelable(this.i18DisplayName, r4);
        r3.writeInt(this.status);
        r3.writeParcelable(this.tenant, r4);
        r3.writeString(this.avatarUrl);
        r3.writeString(this.avatarKey);
        r3.writeLong(this.createTime);
        r3.writeString(this.loginCredentialId);
        r3.writeString(this.userUnit);
        r3.writeByte(this.excludeLogin ? 1 : 0);
        r3.writeString(this.configEnv);
        r3.writeLong(this.lastUseTimestamp);
        r3.writeString(this.session);
        r3.writeString(this.slSession);
        r3.writeString(this.currentEnv);
        r3.writeString(this.logoutToken);
        r3.writeString(this.deviceLoginId);
        r3.writeByte(this.isAnonymous ? 1 : 0);
        r3.writeByte(this.isSessionValid ? 1 : 0);
        r3.writeByte(this.isSessionValidOrForeground ? 1 : 0);
        r3.writeString(this.userGeo);
        r3.writeByte(this.isIdp ? 1 : 0);
        r3.writeByte(this.isGuest ? 1 : 0);
        r3.writeByte(this.isTenantCreator ? 1 : 0);
        r3.writeByte(this.isNewActive ? 1 : 0);
        r3.writeInt(this.tenantTag);
        r3.writeString(this.enName);
        r3.writeMap(this.sessionWithDomainMap);
        r3.writeString(getUserCustomAttr().toJSONString());
        r3.writeParcelable(this.leanModeInfo, r4);
    }
}
