package com.obric.memorydata.middleware.impl.env;

import android.net.Uri;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.env.IEnvManager;
import com.obric.memorydata.middleware.api.env.NetEnv;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0000H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010!\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0016J\f\u0010/\u001a\u00020\u0005*\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0005H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u00103\u001a\u00020\u00192\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u001bH\u0002J\u0010\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0005H\u0002J\u0010\u00109\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0005H\u0002J\u0010\u0010:\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0005H\u0002J\b\u0010;\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/memorydata/middleware/impl/env/EnvManagerImpl;", "Lcom/obric/memorydata/middleware/api/env/IEnvManager;", "<init>", "()V", "TAG", "", "BUILD_CONFIG_PPE", "FLAG_ADMIN_USE_PPE", "FLAG_ADMIN_USER_ONLINE", "FLAG_ADMIN_USER_BOE", "SP_ENV_SWITCH_GROUP", "SP_ENV_HEADER_VALUE", "SP_FEATURE_HEADER_VALUE", "SP_WEBVIEW_ENV_HEADER_VALUE", "SP_SAAS_LIVE_ENV_HEADER_VALUE", "SP_TIKTOK_LIVE_SDK_ENV_DIST_VALUE", "SP_AB_LIVE_VALUE", "SP_ENV_VALUE", "SP_CURRENT_REGION_VALUE", "SP_ENV_RPC_HEADER_VALUE", "cacheMap", "", "", "getInstance", "saveAdminNetEnv", "", "env", "Lcom/obric/memorydata/middleware/api/env/NetEnv;", "removeEnv", "getAdminTTEnvHeader", "defaultTTEnvHeader", "defaultWebEnvHeader", "saveAdminTTEnvHeader", "header", "getAdminTTFeatureHeader", "saveAdminTTFeatureHeader", "saveAdminWebViewEnvHeader", "saveAdminSaaSLiveEnvHeader", "saveTikTokLiveSdkDistEnvHeader", "saveAbDebugHeader", "", "getAbDebugHeader", "getTikTokLiveSdkDistEnvHeader", "getAdminWebViewEnvHeader", "getAdminSaaSLiveEnvHeader", "applyAdminWebViewEnvHeader", "url", "envFlag", "getAdminNetEnv", "saveRpcResponseEnvHeader", "getMockCurrentRegion", "saveMockCurrentRegion", "currentRegion", "getRpcResponseEnvHeader", "defaultNetEnv", "addEnvFlag", "targetValue", "removeEnvFlag", "hasEnvFlag", "isAdminMode", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11711a = null;

        static {
            int[] r0 = new int[NetEnv.values().length];
            r0[NetEnv.PPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[NetEnv.BOE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11711a = r0;
        }
    }

    static {
        INSTANCE = new EnvManagerImpl();
        cacheMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private EnvManagerImpl() {
    }

    private final void addEnvFlag(String r5) {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_ENV_VALUE, r5);
        cacheMap.put(r5, true);
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

    private final String envFlag(NetEnv r1) {
        int r0 = a.f11711a[r1.ordinal()];
        if (r0 != 1) goto L5;
        return FLAG_ADMIN_USE_PPE;
    L5:
        if (r0 == 2) goto L7;
        return FLAG_ADMIN_USER_ONLINE;
    L7:
        return FLAG_ADMIN_USER_BOE;
    }

    @JvmStatic
    public static final EnvManagerImpl getInstance() {
        return INSTANCE;
    }

    private final boolean hasEnvFlag(String r8) {
        Map<String, Boolean> r1 = cacheMap;     // Catch: Exception -> L12
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(r1.get(r8), Boolean.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        if (r2 == null) goto L8;
        return r2.booleanValue();
    L8:
        if (Intrinsics.areEqual(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_ENV_VALUE, ""), r8) == false) goto L11;
        r1.put(r8, true);     // Catch: Exception -> L12
        return true;
    L11:
        return false;
    L12:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "hasEnvFlag " + e, null, 4, null);
        return false;
    }

    private final boolean isAdminMode() {
        return AppContext.INSTANCE.isAdminMode();
    }

    private final void removeEnvFlag(String r5) {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_ENV_VALUE, "");
        cacheMap.put(r5, false);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String applyAdminWebViewEnvHeader(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        String r2 = getAdminWebViewEnvHeader();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        return r3;
    L12:
        Uri.Builder r4 = Uri.parse(r3).buildUpon();
        r4.appendQueryParameter("x-tt-env", r2);
        String r5 = r4.build().toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    L11:
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public int getAbDebugHeader() {
        if (isAdminMode() == true) goto L5;
        return -1;
    L5:
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getInt(SP_AB_LIVE_VALUE, -1);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
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

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getAdminSaaSLiveEnvHeader() {
        CharSequence r0 = "";
        if (isAdminMode() == false) goto L12;
        boolean r5 = false;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_SAAS_LIVE_ENV_HEADER_VALUE, ""), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6.length() != 0) goto L7;
        r5 = true;
    L7:
        if (r5 == true) goto L11;
        r0 = r6;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L12:
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getAdminTTEnvHeader() {
        if (isAdminMode() == false) goto L11;
        boolean r5 = false;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_ENV_HEADER_VALUE, ""), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6.length() != 0) goto L7;
        r5 = true;
    L7:
        if (r5 == false) goto L10;
        r6 = INSTANCE.defaultTTEnvHeader();
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L11:
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getAdminTTFeatureHeader() {
        if (isAdminMode() == true) goto L5;
        return "";
    L5:
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_FEATURE_HEADER_VALUE, "");
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getAdminWebViewEnvHeader() {
        if (isAdminMode() == false) goto L11;
        boolean r5 = false;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_WEBVIEW_ENV_HEADER_VALUE, ""), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6.length() != 0) goto L7;
        r5 = true;
    L7:
        if (r5 == false) goto L10;
        r6 = INSTANCE.defaultWebEnvHeader();
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L11:
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getMockCurrentRegion() {
        if (isAdminMode() == true) goto L5;
        return null;
    L5:
        String r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_CURRENT_REGION_VALUE);
        if (Intrinsics.areEqual(r4, "") == false) goto L9;
        return null;
    L9:
        return r4;
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getRpcResponseEnvHeader() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_ENV_RPC_HEADER_VALUE);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getTikTokLiveSdkDistEnvHeader() {
        CharSequence r0 = "";
        if (isAdminMode() == false) goto L12;
        boolean r5 = false;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).getString(SP_TIKTOK_LIVE_SDK_ENV_DIST_VALUE, ""), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6.length() != 0) goto L7;
        r5 = true;
    L7:
        if (r5 == true) goto L11;
        r0 = r6;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L12:
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void removeEnv() {
        removeEnvFlag(envFlag(getAdminNetEnv()));
        saveAdminTTEnvHeader("");
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAbDebugHeader(int r5) {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_AB_LIVE_VALUE, r5);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminNetEnv(NetEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        if (isAdminMode() == true) goto L5;
        return;
    L5:
        removeEnvFlag(envFlag(getAdminNetEnv()));
        int r3 = a.f11711a[r2.ordinal()];
        if (r3 != 1) goto L8;
        String r4 = FLAG_ADMIN_USE_PPE;
    L12:
        INSTANCE.addEnvFlag(r4);
        saveAdminTTEnvHeader("");
        return;
    L8:
        if (r3 == 2) goto L10;
        r4 = FLAG_ADMIN_USER_ONLINE;
        goto L12
    L10:
        r4 = FLAG_ADMIN_USER_BOE;
        goto L12
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminSaaSLiveEnvHeader(String r5) {
        Intrinsics.checkNotNullParameter(r5, "header");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_SAAS_LIVE_ENV_HEADER_VALUE, r5);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminTTEnvHeader(String r5) {
        Intrinsics.checkNotNullParameter(r5, "header");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_ENV_HEADER_VALUE, r5);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminTTFeatureHeader(String r5) {
        Intrinsics.checkNotNullParameter(r5, "header");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_FEATURE_HEADER_VALUE, r5);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminWebViewEnvHeader(String r5) {
        Intrinsics.checkNotNullParameter(r5, "header");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_WEBVIEW_ENV_HEADER_VALUE, r5);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveMockCurrentRegion(String r8) {
        if (r8 != null) goto L5;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).remove(new String[]{SP_CURRENT_REGION_VALUE});
        return;
    L5:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_CURRENT_REGION_VALUE, r8);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveRpcResponseEnvHeader(String r5) {
        Intrinsics.checkNotNullParameter(r5, "header");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_ENV_RPC_HEADER_VALUE, r5);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveTikTokLiveSdkDistEnvHeader(String r5) {
        Intrinsics.checkNotNullParameter(r5, "header");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), SP_ENV_SWITCH_GROUP, 0, 2, null).save(SP_TIKTOK_LIVE_SDK_ENV_DIST_VALUE, r5);
    }
}
