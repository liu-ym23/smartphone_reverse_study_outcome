package com.obric.aikernel.middleware.impl.env;

import android.net.Uri;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.env.IEnvManager;
import com.obric.aikernel.middleware.api.env.NetEnv;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.store.IStoreManager;
import com.obric.aikernel.middleware.api.store.StoreManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class EnvManagerImpl implements IEnvManager {
    private static final String BUILD_CONFIG_PPE = "ppe";
    private static final String FLAG_ADMIN_USER_BOE = "admin_user_boe";
    private static final String FLAG_ADMIN_USER_ONLINE = "admin_user_online";
    private static final String FLAG_ADMIN_USE_PPE = "admin_use_ppe";
    public static final EnvManagerImpl INSTANCE = null;
    private static final String SP_AB_LIVE_VALUE = "env_ab_live_value";
    private static final String SP_CURRENT_REGION_VALUE = "current_region_value";
    private static final String SP_ENV_HEADER_VALUE = "env_header_value";
    private static final String SP_ENV_RPC_HEADER_VALUE = "env_header_rpc_value";
    private static final String SP_ENV_SWITCH_GROUP = "sp_env_switch";
    private static final String SP_ENV_VALUE = "env_value";
    private static final String SP_FEATURE_HEADER_VALUE = "feature_header_value";
    private static final String SP_SAAS_LIVE_ENV_HEADER_VALUE = "env_saas_live_header_value";
    private static final String SP_TIKTOK_LIVE_SDK_ENV_DIST_VALUE = "env_tiktok_live_sdk_dist_value";
    private static final String SP_WEBVIEW_ENV_HEADER_VALUE = "env_webview_header_value";
    private static final String TAG = "EnvManager";
    private static final Map<String, Boolean> cacheMap = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4557a = null;

        static {
            int[] r10 = new int[NetEnv.values().length];
            r10[NetEnv.PPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[NetEnv.BOE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f4557a = r10;
        }
    }

    static {
        INSTANCE = new EnvManagerImpl();
        cacheMap = new LinkedHashMap();
    }

    private EnvManagerImpl() {
    }

    private final void addEnvFlag(String r10) {
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_ENV_VALUE, r10);     // Catch: Exception -> L4
        cacheMap.put(r10, Boolean.TRUE);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "addEnvFlag " + e);
    }

    private final NetEnv defaultNetEnv() {
        if (Intrinsics.areEqual(AppContext.INSTANCE.appEnv(), BUILD_CONFIG_PPE) == false) goto L7;
        return NetEnv.PPE;
    L7:
        return NetEnv.ONLINE;
    }

    private final String defaultTTEnvHeader() {
        return AppContext.INSTANCE.defaultTTEnvHeader();
    }

    private final String defaultWebEnvHeader() {
        return AppContext.INSTANCE.defaultWebEnvHeader();
    }

    private final String envFlag(NetEnv r10) {
        int r11 = a.f4557a[r10.ordinal()];
        if (r11 != 1) goto L5;
        return FLAG_ADMIN_USE_PPE;
    L5:
        if (r11 == 2) goto L7;
        return FLAG_ADMIN_USER_ONLINE;
    L7:
        return FLAG_ADMIN_USER_BOE;
    }

    @JvmStatic
    public static final EnvManagerImpl getInstance() {
        return INSTANCE;
    }

    private final boolean hasEnvFlag(String r10) {
        Map<String, Boolean> r11 = cacheMap;     // Catch: Exception -> L12
        Boolean r12 = r11.get(r10);     // Catch: Exception -> L12
        if (r12 == null) goto L8;
        return r12.booleanValue();
    L8:
        if (Intrinsics.areEqual(IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_ENV_VALUE, ""), r10) == false) goto L16;
        r11.put(r10, Boolean.TRUE);     // Catch: Exception -> L12
        return true;
    L16:
        return false;
    L12:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "hasEnvFlag " + e);
        return false;
    }

    private final boolean isAdminMode() {
        return AppContext.INSTANCE.isAdminMode();
    }

    private final void removeEnvFlag(String r10) {
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_ENV_VALUE, "");     // Catch: Exception -> L4
        cacheMap.put(r10, Boolean.FALSE);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "removeEnvFlag " + e);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String applyAdminWebViewEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        String r11 = getAdminWebViewEnvHeader();
        if (r11.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L12;
        return r10;
    L12:
        Uri.Builder r13 = Uri.parse(r10).buildUpon();
        r13.appendQueryParameter("x-tt-env", r11);
        String r14 = r13.build().toString();
        Intrinsics.checkNotNullExpressionValue(r14, "uri.buildUpon().apply {\n…     }.build().toString()");
        return r14;
    L11:
        return r10;
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public int getAbDebugHeader() {
        if (isAdminMode() == true) goto L5;
        return -1;
    L5:
        return IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).getInt(SP_AB_LIVE_VALUE, -1);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public NetEnv getAdminNetEnv() {
        if (isAdminMode() == true) goto L7;
        return NetEnv.ONLINE;
    L7:
        if (hasEnvFlag(FLAG_ADMIN_USE_PPE) == false) goto L10;
        return NetEnv.PPE;
    L10:
        if (hasEnvFlag(FLAG_ADMIN_USER_BOE) == false) goto L13;
        return NetEnv.BOE;
    L13:
        if (hasEnvFlag(FLAG_ADMIN_USER_ONLINE) == false) goto L16;
        return NetEnv.ONLINE;
    L16:
        return defaultNetEnv();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getAdminSaaSLiveEnvHeader() {
        if (isAdminMode() == false) goto L11;
        boolean r10 = false;
        String r11 = IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_SAAS_LIVE_ENV_HEADER_VALUE, "");
        if (r11.length() != 0) goto L7;
        r10 = true;
    L7:
        if (r10 == false) goto L10;
        return "";
    L10:
        return r11;
    L11:
        return "";
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getAdminTTEnvHeader() {
        if (isAdminMode() == false) goto L11;
        boolean r10 = false;
        String r11 = IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_ENV_HEADER_VALUE, "");
        if (r11.length() != 0) goto L7;
        r10 = true;
    L7:
        if (r10 == false) goto L10;
        r11 = INSTANCE.defaultTTEnvHeader();
    L10:
        return r11;
    L11:
        return "";
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getAdminTTFeatureHeader() {
        if (isAdminMode() == true) goto L5;
        return "";
    L5:
        return IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_FEATURE_HEADER_VALUE, "");
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getAdminWebViewEnvHeader() {
        if (isAdminMode() == false) goto L11;
        boolean r10 = false;
        String r11 = IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_WEBVIEW_ENV_HEADER_VALUE, "");
        if (r11.length() != 0) goto L7;
        r10 = true;
    L7:
        if (r10 == false) goto L10;
        r11 = INSTANCE.defaultWebEnvHeader();
    L10:
        return r11;
    L11:
        return "";
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getMockCurrentRegion() {
        if (isAdminMode() == true) goto L5;
        return null;
    L5:
        String r10 = IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).a(SP_CURRENT_REGION_VALUE);
        if (Intrinsics.areEqual(r10, "") == false) goto L9;
        return null;
    L9:
        return r10;
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getRpcResponseEnvHeader() {
        return IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).a(SP_ENV_RPC_HEADER_VALUE);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getTikTokLiveSdkDistEnvHeader() {
        if (isAdminMode() == false) goto L11;
        boolean r10 = false;
        String r11 = IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_TIKTOK_LIVE_SDK_ENV_DIST_VALUE, "");
        if (r11.length() != 0) goto L7;
        r10 = true;
    L7:
        if (r10 == false) goto L10;
        return "";
    L10:
        return r11;
    L11:
        return "";
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAbDebugHeader(int r10) {
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).d(SP_AB_LIVE_VALUE, r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminNetEnv(NetEnv r10) {
        Intrinsics.checkNotNullParameter(r10, "env");
        if (isAdminMode() == true) goto L5;
        return;
    L5:
        removeEnvFlag(envFlag(getAdminNetEnv()));
        int r11 = a.f4557a[r10.ordinal()];
        if (r11 != 1) goto L8;
        String r12 = FLAG_ADMIN_USE_PPE;
    L12:
        INSTANCE.addEnvFlag(r12);
        saveAdminTTEnvHeader("");
        return;
    L8:
        if (r11 == 2) goto L10;
        r12 = FLAG_ADMIN_USER_ONLINE;
        goto L12
    L10:
        r12 = FLAG_ADMIN_USER_BOE;
        goto L12
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminSaaSLiveEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_SAAS_LIVE_ENV_HEADER_VALUE, r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminTTEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_ENV_HEADER_VALUE, r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminTTFeatureHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_FEATURE_HEADER_VALUE, r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminWebViewEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_WEBVIEW_ENV_HEADER_VALUE, r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveMockCurrentRegion(String r10) {
        if (r10 != null) goto L5;
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).f(new String[]{SP_CURRENT_REGION_VALUE});
        return;
    L5:
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_CURRENT_REGION_VALUE, r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveRpcResponseEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_ENV_RPC_HEADER_VALUE, r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveTikTokLiveSdkDistEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        IStoreManager.a.a(StoreManager.INSTANCE, SP_ENV_SWITCH_GROUP, 0, 2, null).b(SP_TIKTOK_LIVE_SDK_ENV_DIST_VALUE, r10);
    }
}
