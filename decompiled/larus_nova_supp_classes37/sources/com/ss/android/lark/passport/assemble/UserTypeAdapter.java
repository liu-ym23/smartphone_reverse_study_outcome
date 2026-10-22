package com.ss.android.lark.passport.assemble;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.I18Name;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0002J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/passport/assemble/UserTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "<init>", "()V", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "user", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "writeSessionInfoMap", "sessionMap", "", "", "Lcom/ss/android/lark/passport/signinsdk_api/account/SessionInfo;", "writeSessionInfo", "sessionInfo", "readSessionInfoMap", "readSessionInfo", "writeI18Name", "i18Name", "Lcom/ss/android/lark/passport/signinsdk_api/account/I18Name;", "readI18Name", "writeTenant", "tenant", "Lcom/ss/android/lark/passport/signinsdk_api/account/Tenant;", "readTenant", "Companion", "passport-officesdk-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class UserTypeAdapter extends TypeAdapter<User> {

    public static final class a {
    }

    static {
    }

    public UserTypeAdapter() {
    }

    public static I18Name a(JsonReader r4) {
        if (r4.peek() != JsonToken.NULL) goto L6;
        r4.nextNull();
        return null;
    L6:
        I18Name r0 = new I18Name();
        r4.beginObject();
    L8:
        if (r4.hasNext() == false) goto L31;
        String r1 = r4.nextName();
        if (r1 == null) goto L30;
        int r2 = r1.hashCode();
        if (r2 != 3117351) goto L14;
        if (r1.equals("enUs") == false) goto L30;
        r0.enUs = r4.nextString();
        goto L8
    L14:
        if (r2 != 3253469) goto L16;
        if (r1.equals("jaJp") == false) goto L30;
        r0.jaJp = r4.nextString();
        goto L8
    L16:
        if (r2 != 3736633) goto L30;
        if (r1.equals("zhCn") == false) goto L30;
        r0.zhCn = r4.nextString();
    L30:
        r4.skipValue();
        goto L8
    L31:
        r4.endObject();
        return r0;
    }

    public final Object read(JsonReader r11) {
        Intrinsics.checkNotNullParameter(r11, "reader");
        if (r11.peek() != JsonToken.NULL) goto L5;
        r11.nextNull();
        return null;
    L5:
        User r0 = new User();
        r11.beginObject();
    L7:
        if (r11.hasNext() == false) goto L252;
        String r1 = r11.nextName();
        JsonToken r3 = r11.peek();
        JsonToken r4 = JsonToken.NULL;
        if (r3 == r4) goto L10;
        if (r1 == null) goto L251;
        switch(r1.hashCode()) {
            case -2095811475: goto L248;
            case -1882959080: goto L244;
            case -1373324881: goto L240;
            case -1088998220: goto L236;
            case -1042763398: goto L232;
            case -1015178243: goto L228;
            case -917391773: goto L225;
            case -892481550: goto L221;
            case -877336406: goto L160;
            case -836030906: goto L156;
            case -835063588: goto L95;
            case -776171730: goto L92;
            case -686204988: goto L88;
            case -428656058: goto L84;
            case -428646058: goto L80;
            case -266445841: goto L73;
            case -147156090: goto L69;
            case -22433935: goto L66;
            case 3373707: goto L62;
            case 155571963: goto L58;
            case 601559335: goto L55;
            case 888049560: goto L52;
            case 1026270683: goto L48;
            case 1195763197: goto L44;
            case 1287442096: goto L41;
            case 1369213417: goto L37;
            case 1714148973: goto L33;
            case 1719507599: goto L29;
            case 1741059462: goto L26;
            case 1984987798: goto L22;
            case 2059605615: goto L19;
            case 2084791044: goto L16;
            default: goto L251;
        };
    L19:
        if (r1.equals("suite_session_key") == false) goto L251;
    L24:
        r0.setSession(r11.nextString());
        goto L7
    L22:
        if (r1.equals(AppbrandHostConstants.SCHEMA_INSPECT.SESSION) == true) goto L24;
    L26:
        if (r1.equals("suite_session_key_with_domains") == false) goto L251;
    L98:
        if (r11.peek() != r4) goto L100;
        r11.nextNull();
        LinkedHashMap r2 = null;
    L154:
        r0.setSessionWithDomainMap(r2);
        goto L7
    L100:
        r2 = new LinkedHashMap();
        r11.beginObject();
    L102:
        if (r11.hasNext() == false) goto L153;
        String r5 = r11.nextName();
        if (r11.peek() != JsonToken.NULL) goto L106;
        r11.nextNull();
        SessionInfo r6 = null;
    L142:
        if (r6 == null) goto L102;
        String r7 = r6.getHostUrl();
        if (r7 != null) goto L146;
    L149:
        boolean r8 = true;
    L150:
        if (r8 == false) goto L152;
        r6.setHostUrl(r5);
    L152:
        r2.put(r5, r6);
        goto L102
    L146:
        if (StringsKt.isBlank(r7) == true) goto L149;
        r8 = false;
        goto L150
    L106:
        r6 = new SessionInfo();
        r11.beginObject();
    L108:
        if (r11.hasNext() == false) goto L141;
        String r9 = r11.nextName();
        if (r11.peek() == JsonToken.NULL) goto L111;
        if (r9 == null) goto L140;
        switch(r9.hashCode()) {
            case -686432620: goto L137;
            case -300231080: goto L133;
            case -22661567: goto L130;
            case 3373707: goto L127;
            case 111972721: goto L123;
            case 1098684071: goto L120;
            case 1984987798: goto L117;
            default: goto L140;
        };
    L120:
        if (r9.equals("hostUrl") == false) goto L140;
    L135:
        r6.setHostUrl(r11.nextString());
        goto L108
    L127:
        if (r9.equals(AppbrandHostConstants.Schema_Meta.NAME) == false) goto L140;
    L139:
        r6.setSessionName(r11.nextString());
        goto L108
    L130:
        if (r9.equals("sessionName") == true) goto L139;
    L133:
        if (r9.equals("host_url") == true) goto L135;
    L137:
        if (r9.equals("session_name") == true) goto L139;
    L117:
        if (r9.equals(AppbrandHostConstants.SCHEMA_INSPECT.SESSION) == false) goto L140;
    L125:
        r6.setSession(r11.nextString());
        goto L108
    L123:
        if (r9.equals("value") == true) goto L125;
    L140:
        r11.skipValue();
        goto L108
    L111:
        r11.nextNull();
        goto L108
    L141:
        r11.endObject();
        goto L142
    L153:
        r11.endObject();
        goto L154
    L33:
        if (r1.equals("displayName") == false) goto L251;
        r0.displayName = r11.nextString();
        goto L7
    L37:
        if (r1.equals("createTime") == false) goto L251;
        r0.createTime = r11.nextLong();
        goto L7
    L41:
        if (r1.equals("sl_session") == false) goto L251;
    L46:
        r0.setSlSession(r11.nextString());
        goto L7
    L44:
        if (r1.equals("slSession") == true) goto L46;
    L48:
        if (r1.equals("loginCredentialId") == false) goto L251;
        r0.setLoginCredentialId(r11.nextString());
        goto L7
    L52:
        if (r1.equals("is_anonymous") == false) goto L251;
    L250:
        r0.setAnonymous(r11.nextBoolean());
        goto L7
    L55:
        if (r1.equals("current_env") == false) goto L251;
    L238:
        r0.setCurrentEnv(r11.nextString());
        goto L7
    L58:
        if (r1.equals("i18Name") == false) goto L251;
        r0.i18Name = a(r11);
        goto L7
    L62:
        if (r1.equals(AppbrandHostConstants.Schema_Meta.NAME) == false) goto L251;
        r0.name = r11.nextString();
        goto L7
    L66:
        if (r1.equals("sessionUuid") == false) goto L251;
    L90:
        r0.setSessionUuid(r11.nextString());
        goto L7
    L69:
        if (r1.equals("userGeo") == false) goto L251;
        r0.userGeo = r11.nextString();
        goto L7
    L73:
        if (r1.equals("userUnit") == false) goto L251;
        String r10 = r11.nextString();
        PassportLog.d("UserListService", "read eu_nc6 2 eu_nc");
        if (Intrinsics.areEqual(r10, "eu_nc6") == false) goto L78;
        r10 = "eu_nc";
    L78:
        r0.userUnit = r10;
        goto L7
    L80:
        if (r1.equals("avatarUrl") == false) goto L251;
        r0.avatarUrl = r11.nextString();
        goto L7
    L84:
        if (r1.equals("avatarKey") == false) goto L251;
        r0.avatarKey = r11.nextString();
        goto L7
    L88:
        if (r1.equals("session_uuid") == true) goto L90;
    L92:
        if (r1.equals("deviceLoginId") == false) goto L251;
    L234:
        r0.setDeviceLoginId(r11.nextString());
        goto L7
    L95:
        if (r1.equals("sessionWithDomainMap") == true) goto L98;
    L156:
        if (r1.equals("userId") == false) goto L251;
        r0.userId = r11.nextString();
        goto L7
    L160:
        if (r1.equals("tenant") == false) goto L251;
        if (r11.peek() != r4) goto L165;
        r11.nextNull();
        Tenant r12 = null;
    L219:
        r0.tenant = r12;
        goto L7
    L165:
        r12 = new Tenant();
        r11.beginObject();
    L167:
        if (r11.hasNext() == false) goto L218;
        String r13 = r11.nextName();
        if (r13 == null) goto L217;
        switch(r13.hashCode()) {
            case -2141485979: goto L214;
            case -1852803513: goto L210;
            case -1306693787: goto L206;
            case -734439093: goto L202;
            case -366484489: goto L198;
            case 114586: goto L194;
            case 3373707: goto L190;
            case 155571963: goto L186;
            case 1638765110: goto L182;
            case 1863011581: goto L178;
            case 1973617166: goto L174;
            default: goto L217;
        };
    L178:
        if (r13.equals("tenantBrand") == false) goto L217;
        r12.setTenantBrand(r11.nextString());
        goto L167
    L182:
        if (r13.equals("iconUrl") == false) goto L217;
        r12.iconUrl = r11.nextString();
        goto L167
    L186:
        if (r13.equals("i18Name") == false) goto L217;
        r12.i18Name = a(r11);
        goto L167
    L190:
        if (r13.equals(AppbrandHostConstants.Schema_Meta.NAME) == false) goto L217;
        r12.name = r11.nextString();
        goto L167
    L194:
        if (r13.equals("tag") == false) goto L217;
        r12.tag = r11.nextInt();
        goto L167
    L198:
        if (r13.equals("isCertificated") == false) goto L217;
        r12.isCertificated = r11.nextBoolean();
        goto L167
    L202:
        if (r13.equals("suiteFullDomain") == false) goto L217;
        r12.suiteFullDomain = r11.nextString();
        goto L167
    L206:
        if (r13.equals("tenantId") == false) goto L217;
        r12.tenantId = r11.nextString();
        goto L167
    L210:
        if (r13.equals("tenantGeo") == false) goto L217;
        r12.setTenantGeo(r11.nextString());
        goto L167
    L214:
        if (r13.equals("fromSource") == false) goto L217;
        r12.fromSource = r11.nextInt();
        goto L167
    L174:
        if (r13.equals("tenantDomain") == false) goto L217;
        r12.tenantDomain = r11.nextString();
    L217:
        r11.skipValue();
        goto L167
    L218:
        r11.endObject();
        goto L219
    L221:
        if (r1.equals("status") == false) goto L251;
        r0.setStatus(r11.nextInt());
        goto L7
    L225:
        if (r1.equals("isAnonymous") == true) goto L250;
    L228:
        if (r1.equals("i18DisplayName") == false) goto L251;
        r0.i18DisplayName = a(r11);
        goto L7
    L232:
        if (r1.equals("device_login_id") == true) goto L234;
    L236:
        if (r1.equals("currentEnv") == true) goto L238;
    L240:
        if (r1.equals("excludeLogin") == false) goto L251;
        r0.setExcludeLogin(r11.nextBoolean());
        goto L7
    L244:
        if (r1.equals("isTenantCreator") == false) goto L251;
        r0.isTenantCreator = r11.nextBoolean();
        goto L7
    L248:
        if (r1.equals("anonymous") == true) goto L250;
    L16:
        if (r1.equals("logout_token") == false) goto L251;
    L31:
        r0.setLogoutToken(r11.nextString());
        goto L7
    L29:
        if (r1.equals("logoutToken") == true) goto L31;
    L251:
        r11.skipValue();
        goto L7
    L10:
        r11.nextNull();
        goto L7
    L252:
        r11.endObject();
        return r0;
    }

    public static void b(JsonWriter r2, I18Name r3) {
        if (r3 != null) goto L5;
        r2.nullValue();
        return;
    L5:
        r2.beginObject();
        r2.name("zhCn").value(r3.zhCn);
        r2.name("enUs").value(r3.enUs);
        r2.name("jaJp").value(r3.jaJp);
        r2.endObject();
    }

    public final void write(JsonWriter r6, Object r7) {
        User r8 = (User) r7;
        Intrinsics.checkNotNullParameter(r6, "out");
        if (r8 != null) goto L5;
        r6.nullValue();
        return;
    L5:
        r6.beginObject();
        r6.name("userId").value(r8.userId);
        r6.name(AppbrandHostConstants.Schema_Meta.NAME).value(r8.name);
        if (r8.i18Name == null) goto L8;
        r6.name("i18Name");
        b(r6, r8.i18Name);
    L8:
        r6.name("displayName").value(r8.displayName);
        if (r8.i18DisplayName == null) goto L11;
        r6.name("i18DisplayName");
        b(r6, r8.i18DisplayName);
    L11:
        r6.name("avatarUrl").value(r8.avatarUrl);
        r6.name("status").value(Integer.valueOf(r8.getStatus()));
        if (r8.tenant == null) goto L20;
        r6.name("tenant");
        Tenant r1 = r8.tenant;
        if (r1 != null) goto L16;
        r6.nullValue();
        goto L20
    L16:
        r6.beginObject();
        r6.name("tenantId").value(r1.tenantId);
        r6.name(AppbrandHostConstants.Schema_Meta.NAME).value(r1.name);
        if (r1.i18Name == null) goto L19;
        r6.name("i18Name");
        b(r6, r1.i18Name);
    L19:
        r6.name("iconUrl").value(r1.iconUrl);
        r6.name("tag").value(Integer.valueOf(r1.tag));
        r6.name("tenantDomain").value(r1.tenantDomain);
        r6.name("suiteFullDomain").value(r1.suiteFullDomain);
        r6.name("tenantBrand").value(r1.getTenantBrand());
        r6.name("isCertificated").value(r1.isCertificated);
        r6.name("tenantGeo").value(r1.getTenantGeo());
        r6.name("fromSource").value(Integer.valueOf(r1.fromSource));
        r6.endObject();
    L20:
        r6.name("avatarKey").value(r8.avatarKey);
        r6.name("createTime").value(r8.createTime);
        r6.name("loginCredentialId").value(r8.getLoginCredentialId());
        r6.name(AppbrandHostConstants.SCHEMA_INSPECT.SESSION).value(r8.getSession());
        r6.name("slSession").value(r8.getSlSession());
        r6.name("sessionUuid").value(r8.getSessionUuid());
        r6.name("currentEnv").value(r8.getCurrentEnv());
        r6.name("logoutToken").value(r8.getLogoutToken());
        r6.name("deviceLoginId").value(r8.getDeviceLoginId());
        r6.name("anonymous").value(r8.isAnonymous());
        Map<String, SessionInfo> r2 = r8.getSessionWithDomainMap();
        if (r2 != null) goto L23;
    L26:
        boolean r3 = true;
    L27:
        if (r3 == true) goto L39;
        r6.name("sessionWithDomainMap");
        Map<String, SessionInfo> r4 = r8.getSessionWithDomainMap();
        if (r4 != null) goto L31;
        r6.nullValue();
        goto L39
    L31:
        r6.beginObject();
        Iterator<Map.Entry<String, SessionInfo>> r5 = r4.entrySet().iterator();
    L33:
        if (r5.hasNext() == false) goto L38;
        Map.Entry<String, SessionInfo> r9 = r5.next();
        String r10 = r9.getKey();
        SessionInfo r11 = r9.getValue();
        r6.name(r10);
        if (r11 == null) goto L36;
        r6.beginObject();
        r6.name("hostUrl").value(r11.getHostUrl());
        r6.name("sessionName").value(r11.getSessionName());
        r6.name(AppbrandHostConstants.SCHEMA_INSPECT.SESSION).value(r11.getSession());
        r6.endObject();
        goto L33
    L36:
        r6.nullValue();
        goto L33
    L38:
        r6.endObject();
    L39:
        r6.name("userUnit").value(r8.userUnit);
        r6.name("userGeo").value(r8.userGeo);
        r6.name("excludeLogin").value(r8.isExcludeLogin());
        r6.name("isTenantCreator").value(r8.isTenantCreator);
        r6.endObject();
        return;
    L23:
        if (r2.isEmpty() == true) goto L26;
        r3 = false;
        goto L27
    }
}
