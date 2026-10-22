package com.obric.sva.sdk.effectplatform;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0005J(\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0005J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007J\u001a\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007J$\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/AuthModelConfig;", "", "<init>", "()V", "TAG", "", "manifest", "Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;", "ready", "", "authModelPath", "authKeyInfoPath", "qnnLibDir", "isReady", "getAuthModelVersion", "getAuthRawFileMd5", "getAuthModelPath", "getAuthKeyInfoPath", "getQnnLibDir", "refreshBuiltinQnn", "context", "Landroid/content/Context;", "source", "loadFromLatestIfExists", "", "cleanupDeprecatedAuthModels", "updateFromLatest", "invalidate", "reason", "applyIfValid", "dir", "mf", "loadManifest", "loadManifestWithStatus", "Lcom/obric/sva/sdk/effectplatform/AuthModelConfig$ManifestLoadResult;", "checkAuthDigest", "isSameAuthPackage", "left", "right", "compareMd5", "baseDir", "file", "md5", "ManifestLoadResult", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AuthModelConfig {
    public static final AuthModelConfig INSTANCE = null;
    private static final String TAG = "AuthModelConfig";
    private static volatile String authKeyInfoPath;
    private static volatile String authModelPath;
    private static volatile AuthModelManifest manifest;
    private static volatile String qnnLibDir;
    private static volatile boolean ready;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/AuthModelConfig$ManifestLoadResult;", "", "manifest", "Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;", "code", "", "<init>", "(Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;I)V", "getManifest", "()Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;", "getCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class ManifestLoadResult {
        private final int code;
        private final AuthModelManifest manifest;

        public static /* synthetic */ ManifestLoadResult copy$default(ManifestLoadResult r0, AuthModelManifest r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.manifest;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.code;
        L9:
            return r0.copy(r1, r2);
        }

        public final AuthModelManifest component1() {
            return this.manifest;
        }

        public final int component2() {
            return this.code;
        }

        public final ManifestLoadResult copy(AuthModelManifest r2, int r3) {
            return new ManifestLoadResult(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ManifestLoadResult) == true) goto L8;
            return false;
        L8:
            ManifestLoadResult r6 = (ManifestLoadResult) r5;
            if (Intrinsics.areEqual(this.manifest, r6.manifest) == true) goto L12;
            return false;
        L12:
            if (this.code == r6.code) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            AuthModelManifest r0 = this.manifest;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.code;
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ManifestLoadResult(manifest=" + this.manifest + ", code=" + this.code + ')';
        }

        public final int getCode() {
            return this.code;
        }

        public final AuthModelManifest getManifest() {
            return this.manifest;
        }

        public ManifestLoadResult(AuthModelManifest r1, int r2) {
            this.manifest = r1;
            this.code = r2;
        }
    }

    private AuthModelConfig() {
    }

    static {
        INSTANCE = new AuthModelConfig();
        authModelPath = "";
        authKeyInfoPath = "";
        qnnLibDir = "";
    }

    public final void cleanupDeprecatedAuthModels() {
        Iterator<T> r0 = EffectConstant.INSTANCE.getDEPRECATED_AUTH_MODEL_ROOTS().iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        PolarisFileWrapper r2 = new PolarisFileWrapper((String) r0.next());
        if (r2.exists() == false) goto L4;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        Object r3 = Result.constructor-impl(Boolean.valueOf(FilesKt.deleteRecursively(r2)));     // Catch: Throwable -> L10
    L12:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L15;
        LogUtils.w(TAG, "cleanupDeprecatedAuthModels delete exception path=" + r2.getAbsolutePath() + " error=" + r4.getMessage(), new Object[0]);
    L15:
        Boolean r5 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L19;
        r3 = r5;
    L19:
        if (((Boolean) r3).booleanValue() == true) goto L24;
        if (r2.exists() == false) goto L24;
        LogUtils.w(TAG, "cleanupDeprecatedAuthModels delete failed path=" + r2.getAbsolutePath(), new Object[0]);
    L24:
        LogUtils.i(TAG, "cleanupDeprecatedAuthModels deleted path=" + r2.getAbsolutePath(), new Object[0]);
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final String getAuthKeyInfoPath() {
        if (ready == true) goto L7;
        return "";
    L7:
        return authKeyInfoPath;
    }

    public final String getAuthModelPath() {
        if (ready == true) goto L7;
        return "";
    L7:
        return authModelPath;
    }

    public final String getAuthModelVersion() {
        AuthModelManifest r0 = manifest;
        if (r0 == null) goto L5;
        String r1 = r0.getAuthModelVersion();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getAuthRawFileMd5() {
        AuthModelManifest r0 = manifest;
        if (r0 == null) goto L5;
        String r1 = r0.getAuthRawFileMd5();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getQnnLibDir() {
        return qnnLibDir;
    }

    public final boolean isReady() {
        return ready;
    }

    public final void invalidate(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        LogUtils.w(TAG, "invalidate auth config: " + r4, new Object[0]);
        ready = false;
        manifest = null;
        authModelPath = "";
        authKeyInfoPath = "";
    }

    public final void loadFromLatestIfExists(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        String r0 = EffectConstant.INSTANCE.getAuthLatestRoot();
        AuthModelManifest r1 = loadManifest(r0);
        if (r1 != null) goto L6;
        LogUtils.i(TAG, "loadFromLatestIfExists no manifest under " + r0, new Object[0]);
        return;
    L6:
        applyIfValid(r4.getApplicationContext(), r0, r1, "loadFromLatestIfExists");
    }

    public final AuthModelManifest loadManifest(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        return loadManifestWithStatus(r2).getManifest();
    }

    public final ManifestLoadResult loadManifestWithStatus(String r9) {
        Intrinsics.checkNotNullParameter(r9, "dir");
        PolarisFileWrapper r3 = new PolarisFileWrapper(r9, EffectConstant.AUTH_MODEL_MANIFEST_FILE_NAME);
        if (r3.exists() == false) goto L31;
        if (r3.isFile() == false) goto L31;
        JsonElement r4 = JsonParser.parseString(FilesKt.readText(r3, Charsets.UTF_8));     // Catch: Exception -> L27
        if (r4 != null) goto L11;
    L25:
        LogUtils.e(TAG, "loadManifest root not object dir=" + r9, new Object[0]);     // Catch: Exception -> L27
        return new ManifestLoadResult(null, -3);
    L11:
        if (r4.isJsonObject() == false) goto L25;
        JsonElement r2 = r4.getAsJsonObject();     // Catch: Exception -> L27
        JsonElement r5 = r2.get("model_info");     // Catch: Exception -> L27
        if (r5 != null) goto L17;
    L21:
        AuthModelManifest r1 = (AuthModelManifest) new Gson().fromJson(r2, AuthModelManifest.class);     // Catch: Exception -> L27
        if (r1 != null) goto L34;
        return new ManifestLoadResult(null, -3);
    L34:
        return new ManifestLoadResult(r1, 0);
    L17:
        if (r5.isJsonObject() == true) goto L20;
        LogUtils.e(TAG, "loadManifest bad model_info dir=" + r9, new Object[0]);     // Catch: Exception -> L27
        return new ManifestLoadResult(null, -3);
    L20:
        r2 = r5.getAsJsonObject();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        LogUtils.e(TAG, "loadManifest fail dir=" + r9 + " error=" + e.getMessage(), new Object[0]);
        return new ManifestLoadResult(null, -3);
    L31:
        return new ManifestLoadResult(null, -2);
    }

    public final boolean updateFromLatest(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        String r0 = EffectConstant.INSTANCE.getAuthLatestRoot();
        AuthModelManifest r1 = loadManifest(r0);
        if (r1 != null) goto L7;
        LogUtils.w(TAG, "updateFromLatest manifest missing under " + r0, new Object[0]);
        invalidate("manifest missing");
        return false;
    L7:
        return applyIfValid(r4.getApplicationContext(), r0, r1, "updateFromLatest");
    }

    public final boolean checkAuthDigest(String r8, AuthModelManifest r9) {
        Intrinsics.checkNotNullParameter(r8, "dir");
        if (r9 != null) goto L5;
        return false;
    L5:
        String r1 = r9.getAuthRawFileMd5();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
    L16:
        boolean r3 = false;
    L17:
        boolean r4 = compareMd5(r8, r9.getAuthModelFile(), r9.getAuthModelMd5());
        boolean r5 = compareMd5(r8, r9.getAuthKeyFile(), r9.getAuthKeyMd5());
        LogUtils.d(TAG, "checkAuthDigest dir=" + r8 + " version=" + r9.getVersion() + " modelMd5=" + r4 + " keyMd5=" + r5 + " rawMd5=" + r3 + " qnn=builtin", new Object[0]);
        if (r3 == false) goto L23;
        if (r4 == false) goto L24;
        if (r5 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L14:
        if (r9.getAuthRawFileMd5().length() != 32) goto L16;
        r3 = true;
        goto L17
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public final boolean isSameAuthPackage(AuthModelManifest r5, AuthModelManifest r6) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r6 != null) goto L7;
        return false;
    L7:
        String r1 = r5.getVersion();
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r5.getVersion(), r6.getVersion()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r5.getAuthModelVersion(), r6.getAuthModelVersion()) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(r5.getAuthRawFileMd5(), r6.getAuthRawFileMd5()) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r5.getAuthModelMd5(), r6.getAuthModelMd5()) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(r5.getAuthKeyMd5(), r6.getAuthKeyMd5()) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(r5.getAuthModelFile(), r6.getAuthModelFile()) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(r5.getAuthKeyFile(), r6.getAuthKeyFile()) == false) goto L38;
        return true;
    L38:
        return false;
    L10:
        if (r1.length() == 0) goto L13;
        r2 = false;
        goto L14
    }

    public final boolean refreshBuiltinQnn(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "source");
        String r8 = r6.getApplicationInfo().nativeLibraryDir;
        if (r8 != null) goto L6;
        r8 = "";
    L6:
        if (r8.length() != 0) goto L8;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
    L16:
        LogUtils.w(TAG, "refreshBuiltinQnn native lib dir missing source=" + r7 + " dir=" + r8, new Object[0]);
        qnnLibDir = "";
        return false;
    L12:
        if (new PolarisFileWrapper(r8).isDirectory() == false) goto L16;
        qnnLibDir = r8;
        LogUtils.i(TAG, "refreshBuiltinQnn ready source=" + r7 + " qnnDir=" + qnnLibDir, new Object[0]);
        return true;
    L8:
        r1 = false;
        goto L10
    }

    private final boolean compareMd5(String r4, String r5, String r6) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L18;
        if (r6 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        return true;
    L12:
        if (r6.length() == 0) goto L15;
        r3 = false;
    L18:
        if (r5 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L37;
        if (r6 != null) goto L27;
    L30:
        if (r0 == true) goto L37;
        if (r6.length() == 32) goto L35;
        return false;
    L35:
        String r8 = KtUtils.md5(r4 + File.separator + r5);
        Locale r9 = Locale.ROOT;
        return Intrinsics.areEqual(r6.toLowerCase(r9), r8.toLowerCase(r9));
    L27:
        if (r6.length() == 0) goto L30;
        r0 = false;
    L37:
        return false;
    L20:
        if (r5.length() == 0) goto L23;
        r7 = false;
        goto L24
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final boolean applyIfValid(Context r10, String r11, AuthModelManifest r12, String r13) {
        if (checkAuthDigest(r11, r12) == true) goto L6;
        LogUtils.w(TAG, "applyIfValid digest fail source=" + r13 + " dir=" + r11 + " version=" + r12.getVersion(), new Object[0]);
        StringBuilder r14 = new StringBuilder("digest fail from ");
        r14.append(r13);
        invalidate(r14.toString());
        return false;
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append(r11);
        String r4 = File.separator;
        r0.append(r4);
        String r5 = r12.getAuthModelFile();
        String r6 = "";
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r0.append(r5);
        String r1 = r0.toString();
        StringBuilder r7 = new StringBuilder();
        r7.append(r11);
        r7.append(r4);
        String r15 = r12.getAuthKeyFile();
        if (r15 == null) goto L13;
        r6 = r15;
    L13:
        r7.append(r6);
        String r16 = r7.toString();
        String r8 = r12.getAuthModelFile();
        if (r8 != null) goto L16;
    L19:
        boolean r9 = true;
    L21:
        if (r9 == true) goto L37;
        String r17 = r12.getAuthKeyFile();
        if (r17 != null) goto L25;
    L28:
        boolean r18 = true;
    L29:
        if (r18 == true) goto L37;
        if (new PolarisFileWrapper(r1).isFile() == false) goto L37;
        if (new PolarisFileWrapper(r16).isFile() == false) goto L37;
        refreshBuiltinQnn(r10, "applyIfValid:" + r13);
        manifest = r12;
        authModelPath = r1;
        authKeyInfoPath = r16;
        ready = true;
        LogUtils.i(TAG, "applyIfValid ready source=" + r13 + " version=" + r12.getVersion() + " model=" + r1 + " key=" + r16 + " qnnDir=" + qnnLibDir, new Object[0]);
        return true;
    L25:
        if (r17.length() == 0) goto L28;
        r18 = false;
    L37:
        LogUtils.w(TAG, "applyIfValid file missing source=" + r13 + " model=" + r1 + " key=" + r16, new Object[0]);
        StringBuilder r19 = new StringBuilder("file missing from ");
        r19.append(r13);
        invalidate(r19.toString());
        return false;
    L16:
        if (r8.length() == 0) goto L19;
        r9 = false;
        goto L21
    }
}
