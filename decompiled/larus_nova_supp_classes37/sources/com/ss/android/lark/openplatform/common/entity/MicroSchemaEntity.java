package com.ss.android.lark.openplatform.common.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.LevelTypes;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class MicroSchemaEntity {
    private static final String SCHEMA_VERSION = "v2";
    private static final String TAG = "MicroSchemaEntity";
    private String appId;
    private Map<String, Object> bdpLog;
    private Map<String, Object> customFields;
    private Host host;
    private Map<String, Object> inspect;
    private LaunchMode launchMode;
    private Map<String, Object> meta;
    private String path;
    private String protocol;
    private Map<String, Object> query;
    private Map<String, Object> refererInfo;
    private String scene;
    private String token;
    private VersionType versionType;

    public static final enum BdpsumCheckResult extends Enum<BdpsumCheckResult> {
        public static final BdpsumCheckResult ERROR = null;
        public static final BdpsumCheckResult NONE = null;
        public static final BdpsumCheckResult NORMAL = null;
        public static final /* synthetic */ BdpsumCheckResult[] a = null;
        private String name;

        static {
            BdpsumCheckResult r0 = new BdpsumCheckResult("NORMAL", 0, "normal");
            NORMAL = r0;
            BdpsumCheckResult r1 = new BdpsumCheckResult("NONE", 1, "none");
            NONE = r1;
            BdpsumCheckResult r2 = new BdpsumCheckResult(LevelTypes.TYPE_ERROR, 2, "error");
            ERROR = r2;
            a = new BdpsumCheckResult[]{r0, r1, r2};
        }

        public static BdpsumCheckResult[] values() {
            return (BdpsumCheckResult[]) a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static BdpsumCheckResult valueOf(String r1) {
            return (BdpsumCheckResult) r27.a.a(BdpsumCheckResult.class, r1);
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public BdpsumCheckResult(String r1, int r2, String r3) {
            super(r1, r2);
            this.name = r3;
        }
    }

    public static final class Builder {
        private String appId;
        private Map<String, Object> bdpLog;
        private Map<String, Object> customFields;
        private Host host;
        private Map<String, Object> inspect;
        private LaunchMode launchMode;
        private Map<String, Object> meta;
        private String path;
        private String protocol;
        private Map<String, Object> query;
        private Map<String, Object> refererInfo;
        private String scene;
        private String token;
        private VersionType versionType;

        public MicroSchemaEntity build() {
            return new MicroSchemaEntity(this, null);
        }

        public Builder() {
        }

        public static /* synthetic */ String access$000(Builder r0) {
            return r0.protocol;
        }

        public static /* synthetic */ Host access$100(Builder r0) {
            return r0.host;
        }

        public static /* synthetic */ Map access$1000(Builder r0) {
            return r0.customFields;
        }

        public static /* synthetic */ LaunchMode access$1100(Builder r0) {
            return r0.launchMode;
        }

        public static /* synthetic */ Map access$1200(Builder r0) {
            return r0.refererInfo;
        }

        public static /* synthetic */ Map access$1300(Builder r0) {
            return r0.inspect;
        }

        public static /* synthetic */ String access$200(Builder r0) {
            return r0.appId;
        }

        public static /* synthetic */ VersionType access$300(Builder r0) {
            return r0.versionType;
        }

        public static /* synthetic */ String access$400(Builder r0) {
            return r0.token;
        }

        public static /* synthetic */ Map access$500(Builder r0) {
            return r0.meta;
        }

        public static /* synthetic */ String access$600(Builder r0) {
            return r0.scene;
        }

        public static /* synthetic */ String access$700(Builder r0) {
            return r0.path;
        }

        public static /* synthetic */ Map access$800(Builder r0) {
            return r0.query;
        }

        public static /* synthetic */ Map access$900(Builder r0) {
            return r0.bdpLog;
        }

        public Builder appId(String r1) {
            this.appId = r1;
            return this;
        }

        public Builder bdpLog(Map<String, Object> r1) {
            this.bdpLog = r1;
            return this;
        }

        public Builder customFields(Map<String, Object> r1) {
            this.customFields = r1;
            return this;
        }

        public Builder host(Host r1) {
            this.host = r1;
            return this;
        }

        public Builder inspect(Map<String, Object> r1) {
            this.inspect = r1;
            return this;
        }

        public Builder launchMode(LaunchMode r1) {
            this.launchMode = r1;
            return this;
        }

        public Builder meta(Map<String, Object> r1) {
            this.meta = r1;
            return this;
        }

        public Builder path(String r1) {
            this.path = r1;
            return this;
        }

        public Builder protocol(String r1) {
            this.protocol = r1;
            return this;
        }

        public Builder query(Map<String, Object> r1) {
            this.query = r1;
            return this;
        }

        public Builder refererInfo(Map<String, Object> r1) {
            this.refererInfo = r1;
            return this;
        }

        public Builder scene(String r1) {
            this.scene = r1;
            return this;
        }

        public Builder token(String r1) {
            this.token = r1;
            return this;
        }

        public Builder versionType(VersionType r1) {
            this.versionType = r1;
            return this;
        }
    }

    public static final enum Host extends Enum<Host> {
        public static final Host MICROAPP = null;
        public static final Host MICROGAME = null;
        public static final /* synthetic */ Host[] a = null;
        private String name;

        static {
            Host r0 = new Host("MICROAPP", 0, AppbrandHostConstants.Micro_Host.HOST_APPBRAND);
            MICROAPP = r0;
            Host r1 = new Host("MICROGAME", 1, AppbrandHostConstants.Micro_Host.HOST_GAME);
            MICROGAME = r1;
            a = new Host[]{r0, r1};
        }

        public static Host[] values() {
            return (Host[]) a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static /* synthetic */ String access$1400(Host r0) {
            return r0.name;
        }

        public static Host fromString(String r6) {
            if (TextUtils.isEmpty(r6) == false) goto L5;
            return null;
        L5:
            Host[] r0 = values();
            int r2 = r0.length;
            int r3 = 0;
        L6:
            if (r3 >= r2) goto L11;
            Host r4 = r0[r3];
            if (r4.name.equalsIgnoreCase(r6) == true) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return r4;
        L11:
            return null;
        }

        public static Host valueOf(String r1) {
            return (Host) r27.a.a(Host.class, r1);
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public Host(String r1, int r2, String r3) {
            super(r1, r2);
            this.name = r3;
        }
    }

    public static final enum LaunchFromCheckResult extends Enum<LaunchFromCheckResult> {
        public static final LaunchFromCheckResult BOTH = null;
        public static final LaunchFromCheckResult INNER = null;
        public static final LaunchFromCheckResult NEITHER = null;
        public static final LaunchFromCheckResult OUTER = null;
        public static final /* synthetic */ LaunchFromCheckResult[] a = null;
        private String name;

        static {
            LaunchFromCheckResult r0 = new LaunchFromCheckResult("INNER", 0, "inner");
            INNER = r0;
            LaunchFromCheckResult r1 = new LaunchFromCheckResult("OUTER", 1, "outer");
            OUTER = r1;
            LaunchFromCheckResult r2 = new LaunchFromCheckResult("BOTH", 2, "both");
            BOTH = r2;
            LaunchFromCheckResult r4 = new LaunchFromCheckResult("NEITHER", 3, "neither");
            NEITHER = r4;
            a = new LaunchFromCheckResult[]{r0, r1, r2, r4};
        }

        public static LaunchFromCheckResult[] values() {
            return (LaunchFromCheckResult[]) a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static LaunchFromCheckResult valueOf(String r1) {
            return (LaunchFromCheckResult) r27.a.a(LaunchFromCheckResult.class, r1);
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public LaunchFromCheckResult(String r1, int r2, String r3) {
            super(r1, r2);
            this.name = r3;
        }
    }

    public static final enum LaunchMode extends Enum<LaunchMode> {
        public static final LaunchMode HOST_STACK = null;
        public static final /* synthetic */ LaunchMode[] a = null;
        private String mode;

        static {
            LaunchMode r0 = new LaunchMode();
            HOST_STACK = r0;
            a = new LaunchMode[]{r0};
        }

        public LaunchMode() {
            super("HOST_STACK", 0);
            this.mode = "hostStack";
        }

        public static LaunchMode[] values() {
            return (LaunchMode[]) a.clone();
        }

        public String getMode() {
            return this.mode;
        }

        public static /* synthetic */ String access$1500(LaunchMode r0) {
            return r0.mode;
        }

        public static LaunchMode fromString(String r6) {
            if (TextUtils.isEmpty(r6) == false) goto L5;
            return null;
        L5:
            LaunchMode[] r0 = values();
            int r2 = r0.length;
            int r3 = 0;
        L6:
            if (r3 >= r2) goto L11;
            LaunchMode r4 = r0[r3];
            if (r4.mode.equalsIgnoreCase(r6) == true) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return r4;
        L11:
            return null;
        }

        public static LaunchMode valueOf(String r1) {
            return (LaunchMode) r27.a.a(LaunchMode.class, r1);
        }

        public void setMode(String r1) {
            this.mode = r1;
        }
    }

    public static final enum SceneCheckResult extends Enum<SceneCheckResult> {
        public static final SceneCheckResult DEFAULT = null;
        public static final SceneCheckResult NONE = null;
        public static final SceneCheckResult NORMAL = null;
        public static final /* synthetic */ SceneCheckResult[] a = null;
        private String name;

        static {
            SceneCheckResult r0 = new SceneCheckResult("NORMAL", 0, "normal");
            NORMAL = r0;
            SceneCheckResult r1 = new SceneCheckResult("NONE", 1, "none");
            NONE = r1;
            SceneCheckResult r2 = new SceneCheckResult("DEFAULT", 2, UserInfo.NONE_NAME_CARD_ID);
            DEFAULT = r2;
            a = new SceneCheckResult[]{r0, r1, r2};
        }

        public static SceneCheckResult[] values() {
            return (SceneCheckResult[]) a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static SceneCheckResult valueOf(String r1) {
            return (SceneCheckResult) r27.a.a(SceneCheckResult.class, r1);
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public SceneCheckResult(String r1, int r2, String r3) {
            super(r1, r2);
            this.name = r3;
        }
    }

    public static final enum TTidCheckResult extends Enum<TTidCheckResult> {
        public static final TTidCheckResult BOTH = null;
        public static final TTidCheckResult INNER = null;
        public static final TTidCheckResult NEITHER = null;
        public static final TTidCheckResult OUTER = null;
        public static final /* synthetic */ TTidCheckResult[] a = null;
        private String name;

        static {
            TTidCheckResult r0 = new TTidCheckResult("INNER", 0, "inner");
            INNER = r0;
            TTidCheckResult r1 = new TTidCheckResult("OUTER", 1, "outer");
            OUTER = r1;
            TTidCheckResult r2 = new TTidCheckResult("BOTH", 2, "both");
            BOTH = r2;
            TTidCheckResult r4 = new TTidCheckResult("NEITHER", 3, "neither");
            NEITHER = r4;
            a = new TTidCheckResult[]{r0, r1, r2, r4};
        }

        public static TTidCheckResult[] values() {
            return (TTidCheckResult[]) a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static TTidCheckResult valueOf(String r1) {
            return (TTidCheckResult) r27.a.a(TTidCheckResult.class, r1);
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public TTidCheckResult(String r1, int r2, String r3) {
            super(r1, r2);
            this.name = r3;
        }
    }

    public static final enum VersionType extends Enum<VersionType> {
        public static final VersionType AUDIT = null;
        public static final VersionType CURRENT = null;
        public static final VersionType LATEST = null;
        public static final VersionType LOCAL_DEV = null;
        public static final VersionType PREVIEW = null;
        public static final /* synthetic */ VersionType[] a = null;
        private String name;

        static {
            VersionType r0 = new VersionType("CURRENT", 0, "current");
            CURRENT = r0;
            VersionType r1 = new VersionType("LATEST", 1, "latest");
            LATEST = r1;
            VersionType r2 = new VersionType("AUDIT", 2, "audit");
            AUDIT = r2;
            VersionType r4 = new VersionType("PREVIEW", 3, "preview");
            PREVIEW = r4;
            VersionType r6 = new VersionType("LOCAL_DEV", 4, "local_dev");
            LOCAL_DEV = r6;
            a = new VersionType[]{r0, r1, r2, r4, r6};
        }

        public static VersionType[] values() {
            return (VersionType[]) a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static /* synthetic */ String access$1600(VersionType r0) {
            return r0.name;
        }

        public static VersionType fromString(String r6) {
            if (TextUtils.isEmpty(r6) == false) goto L5;
            return null;
        L5:
            VersionType[] r0 = values();
            int r2 = r0.length;
            int r3 = 0;
        L6:
            if (r3 >= r2) goto L11;
            VersionType r4 = r0[r3];
            if (r4.name.equalsIgnoreCase(r6) == true) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return r4;
        L11:
            return null;
        }

        public static VersionType valueOf(String r1) {
            return (VersionType) r27.a.a(VersionType.class, r1);
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public VersionType(String r1, int r2, String r3) {
            super(r1, r2);
            this.name = r3;
        }
    }

    public static /* synthetic */ class a {
    }

    public String toSchema() {
        if (TextUtils.isEmpty(this.appId) == false) goto L5;
        return null;
    L5:
        StringBuilder r4 = new StringBuilder();
        if (TextUtils.isEmpty(this.protocol) == false) goto L9;
        this.protocol = "sslocal";
    L9:
        if (this.host != null) goto L106;
        this.host = Host.MICROAPP;
    L106:
        r4.append(this.protocol);     // Catch: Exception -> L102
        r4.append("://");     // Catch: Exception -> L102
        r4.append(Host.access$1400(this.host));     // Catch: Exception -> L102
        r4.append("?");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(SCHEMA_VERSION);     // Catch: Exception -> L102
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.APP_ID);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(this.appId);     // Catch: Exception -> L102
        if (TextUtils.isEmpty(this.scene) == true) goto L16;
        r4.append("&");     // Catch: Exception -> L102
        r4.append("scene");     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(Uri.encode(this.scene));     // Catch: Exception -> L102
    L18:
        if (this.launchMode == null) goto L20;
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(LaunchMode.access$1500(this.launchMode));     // Catch: Exception -> L102
    L20:
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION_TYPE);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        VersionType r7 = this.versionType;     // Catch: Exception -> L102
        if (r7 == null) goto L23;
        r4.append(VersionType.access$1600(r7));     // Catch: Exception -> L102
    L25:
        if (TextUtils.isEmpty(this.token) == true) goto L28;
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(this.token);     // Catch: Exception -> L102
    L28:
        if (this.host != Host.MICROGAME) goto L37;
        Map<String, Object> r0 = this.query;     // Catch: Exception -> L102
        if (r0 != null) goto L32;
    L59:
        Map<String, Object> r1 = this.bdpLog;     // Catch: Exception -> L102
        if (r1 != null) goto L62;
    L67:
        Map<String, Object> r2 = this.meta;     // Catch: Exception -> L102
        if (r2 != null) goto L70;
    L72:
        Map<String, Object> r3 = this.inspect;     // Catch: Exception -> L102
        if (r3 != null) goto L75;
    L77:
        Map<String, Object> r5 = this.refererInfo;     // Catch: Exception -> L102
        if (r5 != null) goto L80;
    L82:
        Map<String, Object> r6 = this.customFields;     // Catch: Exception -> L102
        if (r6 != null) goto L85;
    L98:
        String r8 = genBdpSum(r4.toString());     // Catch: Exception -> L102
        if (TextUtils.isEmpty(r8) == true) goto L105;
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(r8);     // Catch: Exception -> L102
    L105:
        return r4.toString();
    L85:
        if (r6.size() <= 0) goto L98;
        Iterator<String> r9 = this.customFields.keySet().iterator();     // Catch: Exception -> L102
    L88:
        if (r9.hasNext() == false) goto L98;
        String r10 = r9.next();     // Catch: Exception -> L102
        if (isReservedField(r10) == true) goto L88;
        Object r11 = this.customFields.get(r10);     // Catch: Exception -> L102
        if ((r11 instanceof Map) == true) goto L93;
        if (r11 == null) goto L88;
        if (TextUtils.isEmpty(r11.toString()) == true) goto L88;
        r4.append("&");     // Catch: Exception -> L102
        r4.append(r10);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(Uri.encode(r11.toString()));     // Catch: Exception -> L102
        goto L88
    L93:
        r4.append("&");     // Catch: Exception -> L102
        r4.append(r10);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(Uri.encode(getJsonFromMap((Map) r11).toJSONString()));     // Catch: Exception -> L102
        goto L88
    L80:
        if (r5.size() <= 0) goto L82;
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.REFERER_INFO);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(Uri.encode(getJsonFromMap(this.refererInfo).toJSONString()));     // Catch: Exception -> L102
        goto L82
    L75:
        if (r3.size() <= 0) goto L77;
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(Uri.encode(getJsonFromMap(this.inspect).toJSONString()));     // Catch: Exception -> L102
        goto L77
    L70:
        if (r2.size() <= 0) goto L72;
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.META);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(Uri.encode(getJsonFromMap(this.meta).toJSONString()));     // Catch: Exception -> L102
        goto L72
    L62:
        if (r1.size() <= 0) goto L67;
        r4.append("&");     // Catch: Exception -> L65
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.BDP_LOG);     // Catch: Exception -> L65
        r4.append("=");     // Catch: Exception -> L65
        r4.append(Uri.encode(getJsonFromMap(this.bdpLog).toJSONString()));     // Catch: Exception -> L65
    L65:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());     // Catch: Exception -> L102
        goto L67
    L32:
        if (r0.size() <= 0) goto L59;
        JSONObject r12 = getJsonFromMap(this.query);     // Catch: Exception -> L102
        if (r12 == null) goto L59;
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(Uri.encode(r12.toJSONString()));     // Catch: Exception -> L102
        goto L59
    L37:
        if (TextUtils.isEmpty(this.path) == true) goto L57;
        String r13 = this.path;     // Catch: Exception -> L102
        if (this.query == null) goto L55;
        String r14 = r13 + "?";     // Catch: Exception -> L102
        JSONObject r15 = getJsonFromMap(this.query);     // Catch: Exception -> L52
        Iterator r16 = r15.keySet().iterator();     // Catch: Exception -> L52
    L42:
        if (r16.hasNext() == false) goto L54;
        String r17 = (String) r16.next();     // Catch: Exception -> L52
        Object r18 = r15.get(r17);     // Catch: Exception -> L52
        if ((r18 instanceof JSONObject) == true) goto L50;
        if ((r18 instanceof JSONArray) == true) goto L50;
        r14 = r14 + r17 + "=" + Uri.encode(r18.toString()) + "&";     // Catch: Exception -> L52
    L50:
        r14 = r14 + r17 + "=" + Uri.encode(((JSONAware) r18).toJSONString()) + "&";     // Catch: Exception -> L52
    L54:
        r13 = r14.substring(0, r14.length() - 1);     // Catch: Exception -> L102
        goto L55
    L52:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());     // Catch: Exception -> L102
    L55:
        r4.append("&");     // Catch: Exception -> L102
        r4.append(AppbrandHostConstants.Schema_RESERVED_FIELD.START_PAGE);     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(Uri.encode(r13));     // Catch: Exception -> L102
        goto L59
    L57:
        if (this.query == null) goto L59;
        return null;
    L23:
        r4.append(VersionType.access$1600(VersionType.CURRENT));     // Catch: Exception -> L102
        goto L25
    L16:
        r4.append("&");     // Catch: Exception -> L102
        r4.append("scene");     // Catch: Exception -> L102
        r4.append("=");     // Catch: Exception -> L102
        r4.append(UserInfo.NONE_NAME_CARD_ID);     // Catch: Exception -> L102
    L102:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        goto L105
    }

    public String getAppId() {
        return this.appId;
    }

    public Map<String, Object> getBdpLog() {
        return this.bdpLog;
    }

    public Map<String, Object> getCustomFields() {
        return this.customFields;
    }

    public Host getHost() {
        return this.host;
    }

    public Map<String, Object> getInspect() {
        return this.inspect;
    }

    public LaunchMode getLaunchMode() {
        return this.launchMode;
    }

    public Map<String, Object> getMeta() {
        return this.meta;
    }

    public String getPath() {
        return this.path;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Map<String, Object> getQuery() {
        return this.query;
    }

    public Map<String, Object> getRefererInfo() {
        return this.refererInfo;
    }

    public String getScene() {
        return this.scene;
    }

    public String getToken() {
        return this.token;
    }

    public VersionType getVersionType() {
        return this.versionType;
    }

    private MicroSchemaEntity(Builder r2) {
        if (TextUtils.isEmpty(Builder.access$000(r2)) == false) goto L5;
        this.protocol = "sslocal";
    L7:
        if (Builder.access$100(r2) != null) goto L9;
        this.host = Host.MICROAPP;
    L10:
        this.appId = Builder.access$200(r2);
        if (Builder.access$300(r2) != null) goto L13;
        this.versionType = VersionType.CURRENT;
    L14:
        this.token = Builder.access$400(r2);
        this.meta = Builder.access$500(r2);
        if (TextUtils.isEmpty(Builder.access$600(r2)) == false) goto L17;
        this.scene = UserInfo.NONE_NAME_CARD_ID;
    L18:
        this.path = Builder.access$700(r2);
        this.query = Builder.access$800(r2);
        this.bdpLog = Builder.access$900(r2);
        if (Builder.access$1000(r2) != null) goto L21;
        this.customFields = new HashMap();
    L22:
        this.launchMode = Builder.access$1100(r2);
        this.refererInfo = Builder.access$1200(r2);
        this.inspect = Builder.access$1300(r2);
        return;
    L21:
        this.customFields = Builder.access$1000(r2);
        goto L22
    L17:
        this.scene = Builder.access$600(r2);
        goto L18
    L13:
        this.versionType = Builder.access$300(r2);
        goto L14
    L9:
        this.host = Builder.access$100(r2);
        goto L10
    L5:
        this.protocol = Builder.access$000(r2);
        goto L7
    }

    public static BdpsumCheckResult checkBdpsum(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        String[] r3 = r2.split("&bdpsum=");
        if (r3.length < 2) goto L9;
        String r0 = r3[1];
        String r4 = genBdpSum(r3[0]);
        if (TextUtils.isEmpty(r0) == false) goto L15;
        return BdpsumCheckResult.NONE;
    L15:
        if (TextUtils.isEmpty(r4) == false) goto L19;
        return BdpsumCheckResult.ERROR;
    L19:
        if (r0.equals(r4) == false) goto L23;
        return BdpsumCheckResult.NORMAL;
    L23:
        return BdpsumCheckResult.ERROR;
    L9:
        return BdpsumCheckResult.NONE;
    L5:
        return BdpsumCheckResult.NONE;
    }

    public static LaunchFromCheckResult checkLaunchFrom(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        MicroSchemaEntity r4 = parseFromSchema(r3);
        if (r4 != null) goto L10;
        return null;
    L10:
        Map<String, Object> r0 = r4.customFields;
        boolean r2 = false;
        if (r0 == null) goto L13;
        boolean r1 = r0.containsKey("launch_from");
    L14:
        Map<String, Object> r5 = r4.bdpLog;
        if (r5 == null) goto L17;
        r2 = r5.containsKey("launch_from");
    L17:
        if (r2 == false) goto L21;
        if (r1 == false) goto L21;
        return LaunchFromCheckResult.BOTH;
    L21:
        if (r2 == false) goto L25;
        if (r1 == true) goto L25;
        return LaunchFromCheckResult.INNER;
    L25:
        if (r2 == true) goto L29;
        if (r1 == false) goto L29;
        return LaunchFromCheckResult.OUTER;
    L29:
        if (r2 == true) goto L34;
        if (r1 == true) goto L34;
        return LaunchFromCheckResult.NEITHER;
    L34:
        return LaunchFromCheckResult.NEITHER;
    L13:
        r1 = false;
        goto L14
    L5:
        return LaunchFromCheckResult.NEITHER;
    }

    public static SceneCheckResult checkScene(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
        MicroSchemaEntity r2 = parseFromSchema(r1);
        if (r2 != null) goto L10;
        return null;
    L10:
        String r3 = r2.getScene();
        if (TextUtils.isEmpty(r3) == false) goto L15;
        return SceneCheckResult.NONE;
    L15:
        if (r3.equals(UserInfo.NONE_NAME_CARD_ID) == false) goto L19;
        return SceneCheckResult.DEFAULT;
    L19:
        return SceneCheckResult.NORMAL;
    L5:
        return SceneCheckResult.NONE;
    }

    public static boolean checkSchemaV2valid(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        String[] r5 = r4.split("&bdpsum=");
        if (r5.length >= 2) goto L8;
        return false;
    L8:
        String r2 = r5[1];
        String r6 = genBdpSum(r5[0]);
        if (TextUtils.isEmpty(r2) == false) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r6) == false) goto L13;
        return false;
    L13:
        if (r2.equals(r6) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public static TTidCheckResult checkTTid(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        MicroSchemaEntity r4 = parseFromSchema(r3);
        if (r4 != null) goto L10;
        return null;
    L10:
        Map<String, Object> r0 = r4.customFields;
        boolean r2 = false;
        if (r0 == null) goto L13;
        boolean r1 = r0.containsKey(AppbrandHostConstants.Schema_BDP_LOG.FIELD_TTID);
    L14:
        Map<String, Object> r5 = r4.bdpLog;
        if (r5 == null) goto L17;
        r2 = r5.containsKey(AppbrandHostConstants.Schema_BDP_LOG.FIELD_TTID);
    L17:
        if (r2 == false) goto L21;
        if (r1 == false) goto L21;
        return TTidCheckResult.BOTH;
    L21:
        if (r2 == false) goto L25;
        if (r1 == true) goto L25;
        return TTidCheckResult.INNER;
    L25:
        if (r2 == true) goto L29;
        if (r1 == false) goto L29;
        return TTidCheckResult.OUTER;
    L29:
        if (r2 == true) goto L34;
        if (r1 == true) goto L34;
        return TTidCheckResult.NEITHER;
    L34:
        return TTidCheckResult.NEITHER;
    L13:
        r1 = false;
        goto L14
    L5:
        return TTidCheckResult.NEITHER;
    }

    private static String genBdpSum(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return "";
    L6:
        if (r5.contains("://") == false) goto L14;
        String[] r6 = r5.split("://");
        if (r6 != null) goto L10;
    L13:
        return "";
    L10:
        if (r6.length < 2) goto L13;
        r5 = r6[1];
    L14:
        String r7 = md5Hex(r5.substring(0, 10) + AppbrandHostConstants.Schema_BDP_SUM.MD5_SALT + r5.substring(10));
        if (TextUtils.isEmpty(r7) == false) goto L18;
        return "";
    L18:
        return r7.substring(2, 6) + r7.substring(20, 23);
    }

    private static List<Object> getArrayFromJsonArray(JSONArray r4) throws Exception {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L12;
        Object r2 = r4.get(r1);
        if ((r2 instanceof JSONArray) == false) goto L9;
        r2 = getArrayFromJsonArray((JSONArray) r2);
    L11:
        r0.add(r2);
        r1 = r1 + 1;
        goto L4
    L9:
        if ((r2 instanceof JSONObject) == false) goto L11;
        r2 = getMapFromJson((JSONObject) r2);
        goto L11
    L12:
        return r0;
    }

    private static JSONObject getJsonFromMap(Map r3) {
        if (r3 != null) goto L10;
        return null;
    L10:
        return (JSONObject) new JSONParser().parse(JSONValue.toJSONString(r3));
    L7:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e.toString()});
        return null;
    }

    private static Map<String, Object> getMapFromJson(JSONObject r5) throws Exception {
        if (r5 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator r1 = r5.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        String r2 = (String) r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONArray) == false) goto L12;
        r3 = getArrayFromJsonArray((JSONArray) r3);
    L14:
        r0.put(r2, r3);
        goto L7
    L12:
        if ((r3 instanceof JSONObject) == false) goto L14;
        r3 = getMapFromJson((JSONObject) r3);
        goto L14
    L15:
        return r0;
    }

    private static boolean isNormalUri(String r0) {
        UriProtector.getQueryParameterNames(UriProtector.parse(r0));     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    private static boolean isReservedField(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return true;
    L6:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION) == false) goto L8;
        return true;
    L8:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.APP_ID) == false) goto L10;
        return true;
    L10:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.META) == false) goto L12;
        return true;
    L12:
        if (r2.equals("scene") == false) goto L14;
        return true;
    L14:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION_TYPE) == false) goto L16;
        return true;
    L16:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN) == false) goto L18;
        return true;
    L18:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.START_PAGE) == false) goto L20;
        return true;
    L20:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY) == false) goto L22;
        return true;
    L22:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.BDP_LOG) == false) goto L24;
        return true;
    L24:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD) == false) goto L26;
        return true;
    L26:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT) == false) goto L28;
        return true;
    L28:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.REFERER_INFO) == false) goto L30;
        return true;
    L30:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.PATH) == false) goto L32;
        return true;
    L32:
        if (r2.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM) == true) goto L49;
        return false;
    L49:
        return true;
    }

    private static boolean isjson(String r2) {
        Object r3 = new JSONParser().parse(r2);     // Catch: Exception -> L11
        if ((r3 instanceof JSONObject) == true) goto L9;
        if ((r3 instanceof JSONArray) == true) goto L14;
        return false;
    L14:
        return true;
    L9:
        return true;
    L11:
        return false;
    }

    private static String md5Hex(String r3) {
        if (r3 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        goto L11
    L5:
        if (r3.length() == 0) goto L11;
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        r1.update(r3.getBytes("UTF-8"));     // Catch: Exception -> L9
        return toHexString(r1.digest());
    }

    public static MicroSchemaEntity parseFromSchema(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return null;
    L6:
        if (isNormalUri(r8) == true) goto L8;
        return null;
    L8:
        Uri r9 = UriProtector.parse(r8);
        JSONParser r4 = new JSONParser();
        Builder r6 = new Builder().protocol(r9.getScheme()).host(Host.fromString(r9.getHost())).appId(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.APP_ID)).versionType(VersionType.fromString(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION_TYPE))).token(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN)).scene(UriProtector.getQueryParameter(r9, "scene"));     // Catch: Exception -> L72
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT)) == true) goto L13;
        r6.inspect(getMapFromJson((JSONObject) r4.parse(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT))));     // Catch: Exception -> L72
    L13:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.REFERER_INFO)) == true) goto L16;
        r6.refererInfo(getMapFromJson((JSONObject) r4.parse(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.REFERER_INFO))));     // Catch: Exception -> L72
    L16:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.META)) == true) goto L19;
        r6.meta(getMapFromJson((JSONObject) r4.parse(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.META))));     // Catch: Exception -> L72
    L19:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD)) == true) goto L21;
        r6.launchMode(LaunchMode.fromString(UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD)));     // Catch: Exception -> L72
    L21:
        String r0 = UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.BDP_LOG);     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r0) == true) goto L24;
        r6.bdpLog(getMapFromJson((JSONObject) r4.parse(r0)));     // Catch: Exception -> L72
    L24:
        Set r1 = UriProtector.getQueryParameterNames(r9);     // Catch: Exception -> L72
        HashMap r2 = new HashMap();     // Catch: Exception -> L72
        Iterator r3 = r1.iterator();     // Catch: Exception -> L72
    L26:
        if (r3.hasNext() == false) goto L39;
        String r5 = (String) r3.next();     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r5) == true) goto L26;
        if (isReservedField(r5) == true) goto L26;
        String r7 = UriProtector.getQueryParameter(r9, r5);     // Catch: Exception -> L72
        if (isjson(r7) == true) goto L33;
        r2.put(r5, r7);     // Catch: Exception -> L72
        goto L26
    L33:
        Object r10 = r4.parse(r7);     // Catch: Exception -> L72
        if ((r10 instanceof JSONObject) == true) goto L35;
        if (r10 == null) goto L26;
        r2.put(r5, ((JSONArray) r10).toArray());     // Catch: Exception -> L72
        goto L26
    L35:
        r2.put(r5, getMapFromJson((JSONObject) r10));     // Catch: Exception -> L72
        goto L26
    L39:
        r6.customFields(r2);     // Catch: Exception -> L72
        if (Host.fromString(r9.getHost()) != Host.MICROAPP) goto L60;
        String r11 = UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.START_PAGE);     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r11) == true) goto L70;
        String[] r12 = r11.split("\\?");     // Catch: Exception -> L72
        if (r12.length <= 1) goto L59;
        HashMap r13 = new HashMap();     // Catch: Exception -> L72
        r6.path(r12[0]);     // Catch: Exception -> L72
        if (isNormalUri(r11) == false) goto L70;
        Uri r14 = UriProtector.parse(r11);     // Catch: Exception -> L72
        Iterator r15 = UriProtector.getQueryParameterNames(r14).iterator();     // Catch: Exception -> L72
    L49:
        if (r15.hasNext() == false) goto L58;
        String r16 = (String) r15.next();     // Catch: Exception -> L72
        String r17 = UriProtector.getQueryParameter(r14, r16);     // Catch: Exception -> L72
        if (isjson(r17) == true) goto L52;
        r13.put(r16, r17);     // Catch: Exception -> L72
        goto L49
    L52:
        Object r18 = r4.parse(r17);     // Catch: Exception -> L72
        if ((r18 instanceof JSONObject) == true) goto L54;
        if (r18 == null) goto L49;
        r13.put(r16, getArrayFromJsonArray((JSONArray) r18));     // Catch: Exception -> L72
        goto L49
    L54:
        r13.put(r16, getMapFromJson((JSONObject) r18));     // Catch: Exception -> L72
        goto L49
    L58:
        r6.query(r13);     // Catch: Exception -> L72
        goto L70
    L59:
        r6.path(r12[0]);     // Catch: Exception -> L72
    L70:
        return new MicroSchemaEntity(r6);
    L60:
        String r19 = UriProtector.getQueryParameter(r9, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r19) == true) goto L70;
        if (isjson(r19) == true) goto L66;
        r19 = Uri.decode(r19);     // Catch: Exception -> L72
    L66:
        if (isjson(r19) == false) goto L70;
        Object r20 = r4.parse(r19);     // Catch: Exception -> L72
        if ((r20 instanceof JSONObject) == false) goto L70;
        r6.query(getMapFromJson((JSONObject) r20));     // Catch: Exception -> L72
    L72:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        return null;
    }

    private static String toHexString(byte... r7) {
        char[] r0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] r1 = new char[r7.length * 2];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r7.length) goto L10;
        int r4 = r7[r2];
        if (r4 >= 0) goto L8;
        r4 = r4 + 256;
    L8:
        int r5 = r3 + 1;
        r1[r3] = r0[r4 >>> 4];
        r3 = r5 + 1;
        r1[r5] = r0[r4 & 15];
        r2 = r2 + 1;
        goto L4
    L10:
        return new String(r1);
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof MicroSchemaEntity) == true) goto L5;
        return false;
    L5:
        MicroSchemaEntity r5 = (MicroSchemaEntity) r4;
        String r0 = this.protocol;
        if (r0 != null) goto L11;
        if (r5.protocol != null) goto L99;
    L12:
        Host r1 = this.host;
        if (r1 != null) goto L18;
        if (r5.host == null) goto L20;
        return false;
    L20:
        if (Objects.equals(this.appId, r5.appId) == false) goto L103;
        VersionType r2 = this.versionType;
        if (r2 != null) goto L27;
        if (r5.versionType != null) goto L104;
    L28:
        String r3 = this.token;
        if (r3 != null) goto L34;
        if (r5.token != null) goto L106;
    L35:
        Map<String, Object> r6 = this.meta;
        if (r6 != null) goto L41;
        if (r5.meta != null) goto L108;
    L42:
        String r7 = this.scene;
        if (r7 != null) goto L48;
        if (r5.scene != null) goto L110;
    L49:
        LaunchMode r8 = this.launchMode;
        if (r8 != null) goto L55;
        if (r5.launchMode != null) goto L112;
    L56:
        Map<String, Object> r9 = this.refererInfo;
        if (r9 != null) goto L62;
        if (r5.refererInfo != null) goto L114;
    L63:
        String r10 = this.path;
        if (r10 != null) goto L69;
        if (r5.path != null) goto L116;
    L70:
        Map<String, Object> r11 = this.query;
        if (r11 != null) goto L76;
        if (r5.query != null) goto L118;
    L77:
        Map<String, Object> r12 = this.bdpLog;
        if (r12 != null) goto L83;
        if (r5.bdpLog != null) goto L120;
    L84:
        Map<String, Object> r13 = this.inspect;
        if (r13 != null) goto L90;
        if (r5.inspect != null) goto L122;
    L91:
        Map<String, Object> r14 = this.customFields;
        Map<String, Object> r15 = r5.customFields;
        if (r14 != null) goto L96;
        if (r15 != null) goto L124;
    L97:
        return true;
    L124:
        return false;
    L96:
        if (r14.equals(r15) == true) goto L97;
        return false;
    L122:
        return false;
    L90:
        if (r13.equals(r5.inspect) == true) goto L91;
        return false;
    L120:
        return false;
    L83:
        if (r12.equals(r5.bdpLog) == true) goto L84;
        return false;
    L118:
        return false;
    L76:
        if (r11.equals(r5.query) == true) goto L77;
        return false;
    L116:
        return false;
    L69:
        if (r10.equals(r5.path) == true) goto L70;
        return false;
    L114:
        return false;
    L62:
        if (r9.equals(r5.refererInfo) == true) goto L63;
        return false;
    L112:
        return false;
    L55:
        if (r8.equals(r5.launchMode) == true) goto L56;
        return false;
    L110:
        return false;
    L48:
        if (r7.equals(r5.scene) == true) goto L49;
        return false;
    L108:
        return false;
    L41:
        if (r6.equals(r5.meta) == true) goto L42;
        return false;
    L106:
        return false;
    L34:
        if (r3.equals(r5.token) == true) goto L35;
        return false;
    L104:
        return false;
    L27:
        if (r2.equals(r5.versionType) == true) goto L28;
        return false;
    L103:
        return false;
    L18:
        if (r1.equals(r5.host) == true) goto L20;
        return false;
    L99:
        return false;
    L11:
        if (r0.equals(r5.protocol) == true) goto L12;
        return false;
    }

    public boolean removeBdpLogField(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r0 = this.bdpLog;
        if (r0 != null) goto L9;
        return true;
    L9:
        r0.remove(r3);
        return true;
    }

    public boolean removeCustomField(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r0 = this.customFields;
        if (r0 != null) goto L9;
        return true;
    L9:
        r0.remove(r3);
        return true;
    }

    public boolean removeInspectField(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r0 = this.inspect;
        if (r0 != null) goto L9;
        return true;
    L9:
        r0.remove(r3);
        return true;
    }

    public boolean removeMetaField(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r0 = this.meta;
        if (r0 != null) goto L9;
        return true;
    L9:
        r0.remove(r3);
        return true;
    }

    public boolean removeQueryField(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r0 = this.query;
        if (r0 != null) goto L9;
        return true;
    L9:
        r0.remove(r3);
        return true;
    }

    public boolean removeRefererInfoField(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r0 = this.refererInfo;
        if (r0 != null) goto L9;
        return true;
    L9:
        r0.remove(r3);
        return true;
    }

    public void setAppId(String r1) {
        this.appId = r1;
    }

    public void setBdpLog(Map<String, Object> r1) {
        this.bdpLog = r1;
    }

    public void setCustomFields(Map<String, Object> r1) {
        this.customFields = r1;
    }

    public void setHost(Host r1) {
        this.host = r1;
    }

    public void setInspect(Map<String, Object> r1) {
        this.inspect = r1;
    }

    public void setLaunchMode(LaunchMode r1) {
        this.launchMode = r1;
    }

    public void setMeta(Map<String, Object> r1) {
        this.meta = r1;
    }

    public void setPath(String r1) {
        this.path = r1;
    }

    public void setProtocol(String r1) {
        this.protocol = r1;
    }

    public void setQuery(Map<String, Object> r1) {
        this.query = r1;
    }

    public void setRefererInfo(Map<String, Object> r1) {
        this.refererInfo = r1;
    }

    public void setScene(String r1) {
        this.scene = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setVersionType(VersionType r1) {
        this.versionType = r1;
    }

    public /* synthetic */ MicroSchemaEntity(Builder r1, a r2) {
        this(r1);
    }

    public boolean addBdpLogField(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (this.bdpLog != null) goto L9;
        this.bdpLog = new HashMap();
    L9:
        this.bdpLog.put(r2, r3);
        return true;
    }

    public boolean addCustomField(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (this.customFields != null) goto L9;
        this.customFields = new HashMap();
    L9:
        this.customFields.put(r2, r3);
        return true;
    }

    public boolean addInspectField(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (this.inspect != null) goto L9;
        this.inspect = new HashMap();
    L9:
        this.inspect.put(r2, r3);
        return true;
    }

    public boolean addMetaField(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (this.meta != null) goto L9;
        this.meta = new HashMap();
    L9:
        this.meta.put(r2, r3);
        return true;
    }

    public boolean addQueryField(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (this.query != null) goto L9;
        this.query = new HashMap();
    L9:
        this.query.put(r2, r3);
        return true;
    }

    public boolean addRefererInfoField(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (this.refererInfo != null) goto L9;
        this.refererInfo = new HashMap();
    L9:
        this.refererInfo.put(r2, r3);
        return true;
    }
}
