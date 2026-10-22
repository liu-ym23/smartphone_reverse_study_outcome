package com.obric.sva.sdk.effectplatform;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.KtUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\b\u0010:\u001a\u00020\u0005H\u0007J\b\u0010;\u001a\u00020\u0005H\u0007J\u000e\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\bR\u0011\u0010\u001d\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050#8F¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\bR\u0011\u0010+\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010\bR\u0011\u0010-\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010\bR\u0011\u0010/\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b0\u0010\bR\u0011\u00101\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b2\u0010\bR\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000506X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020=X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020=X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020=X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020=X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020=X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020=X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020=X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00050F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010K\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0086T¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectConstant;", "", "<init>", "()V", "TAG", "", "baseRoot", "getBaseRoot", "()Ljava/lang/String;", "setBaseRoot", "(Ljava/lang/String;)V", "authBaseRoot", "getAuthBaseRoot", "setAuthBaseRoot", "sdkCacheRoot", "getSdkCacheRoot", "setSdkCacheRoot", "updateDir", "getUpdateDir", "sdkAlgorithmDir", "getSdkAlgorithmDir", "sdkEffectDir", "getSdkEffectDir", "alternativeDir", "getAlternativeDir", "latestRoot", "getLatestRoot", "prevRoot", "getPrevRoot", "latestRelative", "getLatestRelative", "DOUBAO_OBRIC_VOICE_AUTH_NAME_LEGACY_V1", "DOUBAO_OBRIC_VOICE_AUTH_NAME_LEGACY_KWS", "DOUBAO_OBRIC_VOICE_AUTH_NAME", "DEPRECATED_DOUBAO_OBRIC_VOICE_AUTH_NAMES", "", "getDEPRECATED_DOUBAO_OBRIC_VOICE_AUTH_NAMES", "()Ljava/util/List;", "DEPRECATED_AUTH_MODEL_ROOTS", "getDEPRECATED_AUTH_MODEL_ROOTS", "authNamespaceRoot", "getAuthNamespaceRoot", "modelName", "authUpdateDir", "getAuthUpdateDir", "authLatestRoot", "getAuthLatestRoot", "authPrevRoot", "getAuthPrevRoot", "authZipCacheDir", "getAuthZipCacheDir", "DOUBAO_OBRIC_VOICE_SID_NAME_DEFAULT", "DOUBAO_OBRIC_VOICE_SID_NAME_GENESIS_R", "modelNameMaps", "", "MODEL_MANIFEST_FILE_NAME", "AUTH_MODEL_MANIFEST_FILE_NAME", "CURRENT_CONFIG_JSON", "getDownloadModelName", "getDownloadAuthModelName", "ERROR_CODE_OK", "", "ERROR_CODE_EXTRACT", "ERROR_CODE_MODEL_NOT_EXIST", "ERROR_CODE_BAD_MANIFEST", "ERROR_CODE_BAD_DIGEST_ROLLBACK", "ERROR_CODE_RELOAD_FAILED", "ERROR_CODE_FILE_NOT_COPY", "ERROR_CODE_NO_NEED_UPDATE", "ERROR_MAP", "", "getERROR_MAP", "()Ljava/util/Map;", "findError", "code", "USER_LOGIN_INTENT", "ONE_SECOND", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EffectConstant {
    public static final String AUTH_MODEL_MANIFEST_FILE_NAME = "auth_manifest.json";
    public static final String CURRENT_CONFIG_JSON = "current.json";
    private static final List<String> DEPRECATED_DOUBAO_OBRIC_VOICE_AUTH_NAMES = null;
    public static final String DOUBAO_OBRIC_VOICE_AUTH_NAME = "db_obric_wakeup_auth_opt_compress";
    private static final String DOUBAO_OBRIC_VOICE_AUTH_NAME_LEGACY_KWS = "db_obric_wakeup_kws_auth_compress";
    private static final String DOUBAO_OBRIC_VOICE_AUTH_NAME_LEGACY_V1 = "db_obric_wakeup_auth_compress";
    public static final String DOUBAO_OBRIC_VOICE_SID_NAME_DEFAULT = "db_obric_wakeup_kws_sid_compress";
    public static final String DOUBAO_OBRIC_VOICE_SID_NAME_GENESIS_R = "db_obric_wakeup_kws_sid_genesis_r_compress";
    public static final int ERROR_CODE_BAD_DIGEST_ROLLBACK = -4;
    public static final int ERROR_CODE_BAD_MANIFEST = -3;
    public static final int ERROR_CODE_EXTRACT = -1;
    public static final int ERROR_CODE_FILE_NOT_COPY = -6;
    public static final int ERROR_CODE_MODEL_NOT_EXIST = -2;
    public static final int ERROR_CODE_NO_NEED_UPDATE = -7;
    public static final int ERROR_CODE_OK = 0;
    public static final int ERROR_CODE_RELOAD_FAILED = -5;
    private static final Map<Integer, String> ERROR_MAP = null;
    public static final EffectConstant INSTANCE = null;
    public static final String MODEL_MANIFEST_FILE_NAME = "manifest.json";
    public static final long ONE_SECOND = 1000;
    public static final String TAG = "EffectConstant";
    public static final String USER_LOGIN_INTENT = "com.obric.wakeup.user.login.intent";
    public static String authBaseRoot;
    public static String baseRoot;
    private static final Map<String, String> modelNameMaps = null;
    public static String sdkCacheRoot;

    private EffectConstant() {
    }

    @JvmStatic
    public static final String getDownloadAuthModelName() {
        return DOUBAO_OBRIC_VOICE_AUTH_NAME;
    }

    static {
        INSTANCE = new EffectConstant();
        DEPRECATED_DOUBAO_OBRIC_VOICE_AUTH_NAMES = CollectionsKt.listOf(new String[]{DOUBAO_OBRIC_VOICE_AUTH_NAME_LEGACY_V1, DOUBAO_OBRIC_VOICE_AUTH_NAME_LEGACY_KWS});
        modelNameMaps = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("default", DOUBAO_OBRIC_VOICE_SID_NAME_DEFAULT), TuplesKt.to("genesis-r", DOUBAO_OBRIC_VOICE_SID_NAME_GENESIS_R)});
        ERROR_MAP = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, "ok"), TuplesKt.to(-1, "extract error"), TuplesKt.to(-2, "model not exist"), TuplesKt.to(-3, "bad manifest"), TuplesKt.to(-4, "bad digest rollback"), TuplesKt.to(-5, "reload failed"), TuplesKt.to(-6, "file not copy"), TuplesKt.to(-7, "no need update")});
    }

    private final String getAlternativeDir() {
        return File.separator + "alternative";
    }

    private final String getAuthNamespaceRoot() {
        return getAuthNamespaceRoot(DOUBAO_OBRIC_VOICE_AUTH_NAME);
    }

    @JvmStatic
    public static final String getDownloadModelName() {
        String r0 = modelNameMaps.get(KtUtils.INSTANCE.getPlatformName());
        if (r0 != null) goto L6;
        return DOUBAO_OBRIC_VOICE_SID_NAME_DEFAULT;
    L6:
        return r0;
    }

    public final String getAuthBaseRoot() {
        String r0 = authBaseRoot;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("authBaseRoot");
        return null;
    }

    public final String getAuthLatestRoot() {
        return getAuthNamespaceRoot() + File.separator + "latest";
    }

    public final String getAuthPrevRoot() {
        return getAuthNamespaceRoot() + File.separator + "previous";
    }

    public final String getAuthUpdateDir() {
        String r0 = getAuthNamespaceRoot() + File.separator + "obric_model_update_auth";
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0);
        if (r1.exists() == false) goto L8;
        if (r1.isDirectory() == false) goto L8;
        return r0;
    L8:
        if (r1.exists() == false) goto L13;
        if (r1.isFile() == false) goto L13;
        r1.delete();
    L13:
        if (r1.exists() == true) goto L15;
        r1.mkdirs();
    L15:
        return r0;
    }

    public final String getAuthZipCacheDir() {
        String r0 = getAuthNamespaceRoot() + File.separator + "zip_cache";
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0);
        if (r1.exists() == false) goto L8;
        if (r1.isFile() == false) goto L8;
        r1.delete();
    L8:
        if (r1.exists() == true) goto L10;
        r1.mkdirs();
    L10:
        return r0;
    }

    public final String getBaseRoot() {
        String r0 = baseRoot;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("baseRoot");
        return null;
    }

    public final List<String> getDEPRECATED_AUTH_MODEL_ROOTS() {
        List<String> r0 = DEPRECATED_DOUBAO_OBRIC_VOICE_AUTH_NAMES;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(INSTANCE.getAuthNamespaceRoot((String) r2.next()));
        goto L4
    L6:
        StringBuilder r3 = new StringBuilder();
        r3.append(getBaseRoot());
        r3.append(getAlternativeDir());
        String r4 = File.separator;
        r3.append(r4);
        r3.append("auth_latest");
        return CollectionsKt.plus(r1, CollectionsKt.distinct(CollectionsKt.listOf(new String[]{r3.toString(), getBaseRoot() + getAlternativeDir() + r4 + "auth_previous", getBaseRoot() + r4 + "obric_model_update_auth", getBaseRoot() + r4 + "zip_cache", getAuthBaseRoot() + getAlternativeDir() + r4 + "auth_latest", getAuthBaseRoot() + getAlternativeDir() + r4 + "auth_previous", getAuthBaseRoot() + r4 + "obric_model_update_auth", getAuthBaseRoot() + r4 + "zip_cache"})));
    }

    public final String getLatestRelative() {
        return "." + getAlternativeDir() + File.separator + "latest";
    }

    public final String getLatestRoot() {
        return getBaseRoot() + getAlternativeDir() + File.separator + "latest";
    }

    public final String getPrevRoot() {
        return getBaseRoot() + getAlternativeDir() + File.separator + "previous";
    }

    public final String getSdkAlgorithmDir() {
        String r0 = getSdkCacheRoot() + File.separator + "effectmodel";
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0);
        if (r1.exists() == false) goto L8;
        if (r1.isFile() == false) goto L8;
        r1.delete();
    L8:
        if (r1.exists() == true) goto L10;
        r1.mkdirs();
    L10:
        return r0;
    }

    public final String getSdkCacheRoot() {
        String r0 = sdkCacheRoot;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("sdkCacheRoot");
        return null;
    }

    public final String getSdkEffectDir() {
        String r0 = getSdkCacheRoot() + File.separator + "effect";
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0);
        if (r1.exists() == false) goto L8;
        if (r1.isFile() == false) goto L8;
        r1.delete();
    L8:
        if (r1.exists() == true) goto L10;
        r1.mkdirs();
    L10:
        return r0;
    }

    public final String getUpdateDir() {
        String r0 = getBaseRoot() + File.separator + "obric_model_update";
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0);
        if (r1.exists() == false) goto L8;
        if (r1.isDirectory() == false) goto L8;
        return r0;
    L8:
        if (r1.exists() == false) goto L13;
        if (r1.isFile() == false) goto L13;
        r1.delete();
    L13:
        if (r1.exists() == true) goto L15;
        r1.mkdirs();
    L15:
        return r0;
    }

    public final List<String> getDEPRECATED_DOUBAO_OBRIC_VOICE_AUTH_NAMES() {
        return DEPRECATED_DOUBAO_OBRIC_VOICE_AUTH_NAMES;
    }

    public final Map<Integer, String> getERROR_MAP() {
        return ERROR_MAP;
    }

    public final String findError(int r2) {
        String r3 = ERROR_MAP.get(Integer.valueOf(r2));
        if (r3 != null) goto L6;
        return "Unknown error";
    L6:
        return r3;
    }

    public final String getAuthNamespaceRoot(String r3) {
        Intrinsics.checkNotNullParameter(r3, "modelName");
        return getAuthBaseRoot() + getAlternativeDir() + File.separator + r3;
    }

    public final void setAuthBaseRoot(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        authBaseRoot = r2;
    }

    public final void setBaseRoot(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        baseRoot = r2;
    }

    public final void setSdkCacheRoot(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        sdkCacheRoot = r2;
    }
}
