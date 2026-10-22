package com.obric.sva.sdk.config;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import com.obric.sva.sdk.effectplatform.EffectUtils;
import com.obric.sva.sdk.effectplatform.ModelManifest;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.File;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import zna.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u001d*\u0004\u0018\u00010#H\u0002J\u0006\u0010$\u001a\u00020\u0019J\b\u0010*\u001a\u0004\u0018\u00010\u0005J\u0006\u0010+\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010%\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010'¨\u0006-"}, d2 = {"Lcom/obric/sva/sdk/config/ConfigManager;", "", "<init>", "()V", "TAG", "", "CURRENT_PATH", "DEFAULT_FILE_PATH", "defaultCurrentModelConfig", "Lcom/obric/sva/sdk/config/ConfigManager$CurrentModelConfig;", "getDefaultCurrentModelConfig", "()Lcom/obric/sva/sdk/config/ConfigManager$CurrentModelConfig;", "defaultCurrentModelConfig$delegate", "Lkotlin/Lazy;", "modelConfig", "getModelConfig", "setModelConfig", "(Lcom/obric/sva/sdk/config/ConfigManager$CurrentModelConfig;)V", "stage2Config", "Lcom/obric/sva/sdk/config/Stage2Config;", "getStage2Config", "()Lcom/obric/sva/sdk/config/Stage2Config;", "setStage2Config", "(Lcom/obric/sva/sdk/config/Stage2Config;)V", "init", "", "rootDir", "reLoadCurrentJson", "readAlternativeConfig", "", "readDefaultConfig", "context", "Landroid/content/Context;", "canOverwriteByManifest", "isNotNullOrEmpty", "", "overwriteByManifest", "engineVersion", "getEngineVersion", "()Ljava/lang/String;", "voicePrintEngineVersion", "getVoicePrintEngineVersion", "getEffectSdkVersion", "dump", "CurrentModelConfig", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ConfigManager {
    private static final String CURRENT_PATH = "current.json";
    private static final String DEFAULT_FILE_PATH = "speech_kws_model/default_config.json";
    public static final ConfigManager INSTANCE = null;
    public static final String TAG = "ConfigManager";
    private static final Lazy defaultCurrentModelConfig$delegate = null;
    public static CurrentModelConfig modelConfig;
    public static Stage2Config stage2Config;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/obric/sva/sdk/config/ConfigManager$CurrentModelConfig;", "", "owner", "", "config", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getOwner", "()Ljava/lang/String;", "setOwner", "(Ljava/lang/String;)V", "getConfig", "setConfig", "isAlternative", "", "isConfigExist", "isDefault", "getConfigFile", "manifest", "Lcom/obric/sva/sdk/effectplatform/ModelManifest;", "getManifest", "()Lcom/obric/sva/sdk/effectplatform/ModelManifest;", "setManifest", "(Lcom/obric/sva/sdk/effectplatform/ModelManifest;)V", "toString", "component1", "component2", "copy", "equals", "other", "hashCode", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CurrentModelConfig {

        @SerializedName("config")
        private String config;
        private ModelManifest manifest;

        @SerializedName("owner")
        private String owner;

        public CurrentModelConfig() {
            String r0 = null;
            this(r0, r0, 3, r0);
        }

        public static /* synthetic */ CurrentModelConfig copy$default(CurrentModelConfig r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.owner;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.config;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.owner;
        }

        public final String component2() {
            return this.config;
        }

        public final CurrentModelConfig copy(String r2, String r3) {
            return new CurrentModelConfig(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CurrentModelConfig) == true) goto L8;
            return false;
        L8:
            CurrentModelConfig r6 = (CurrentModelConfig) r5;
            if (Intrinsics.areEqual(this.owner, r6.owner) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.config, r6.config) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.owner;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.config;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String getConfigFile() {
            String r0 = this.config;
            if (r0 != null) goto L6;
            return "./default_config.json";
        L6:
            return r0;
        }

        public final boolean isAlternative() {
            return Intrinsics.areEqual(this.owner, "alternative");
        }

        public final boolean isDefault() {
            return Intrinsics.areEqual(this.owner, "default");
        }

        public String toString() {
            return super.toString() + " manifest = " + this.manifest;
        }

        public final boolean isConfigExist() {
            if (isAlternative() == false) goto L7;
            return new PolarisFileWrapper(EffectConstant.INSTANCE.getBaseRoot() + File.separator + getConfigFile()).exists();
        L7:
            if (isDefault() == true) goto L9;
            return false;
        L9:
            return new PolarisFileWrapper(EffectConstant.INSTANCE.getBaseRoot() + File.separator + "default_config.json").exists();
        }

        public final String getConfig() {
            return this.config;
        }

        public final ModelManifest getManifest() {
            return this.manifest;
        }

        public final String getOwner() {
            return this.owner;
        }

        public final void setConfig(String r1) {
            this.config = r1;
        }

        public final void setManifest(ModelManifest r1) {
            this.manifest = r1;
        }

        public final void setOwner(String r1) {
            this.owner = r1;
        }

        public CurrentModelConfig(String r1, String r2) {
            this.owner = r1;
            this.config = r2;
        }

        public /* synthetic */ CurrentModelConfig(String r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = "default";
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = "./default_config.json";
        L8:
            this(r1, r2);
        }
    }

    private ConfigManager() {
    }

    public static /* synthetic */ CurrentModelConfig a() {
        return defaultCurrentModelConfig_delegate$lambda$0();
    }

    static {
        INSTANCE = new ConfigManager();
        defaultCurrentModelConfig$delegate = LazyKt.lazy(new a());
        LogUtils.d(TAG, "init", new Object[0]);
    }

    private static final CurrentModelConfig defaultCurrentModelConfig_delegate$lambda$0() {
        String r1 = null;
        return new CurrentModelConfig(r1, r1, 3, r1);
    }

    private final CurrentModelConfig getDefaultCurrentModelConfig() {
        return (CurrentModelConfig) defaultCurrentModelConfig$delegate.getValue();
    }

    public final void dump() {
        LogUtils.d(TAG, "dump config: " + getStage2Config() + " @_@ modelConfig " + getModelConfig(), new Object[0]);
    }

    public final String getEffectSdkVersion() {
        String r1 = null;
        if (modelConfig != null) goto L6;
        LogUtils.w(TAG, "getEffectSdkVersion called before modelConfig initialized", new Object[0]);
        return null;
    L6:
        ModelManifest r0 = getModelConfig().getManifest();
        if (r0 == null) goto L9;
        r1 = r0.getVersion();
    L9:
        LogUtils.d(TAG, "getEffectSdkVersion " + r1, new Object[0]);
        return r1;
    }

    public final CurrentModelConfig getModelConfig() {
        CurrentModelConfig r0 = modelConfig;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("modelConfig");
        return null;
    }

    public final Stage2Config getStage2Config() {
        Stage2Config r0 = stage2Config;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("stage2Config");
        return null;
    }

    public final void overwriteByManifest() {
        String r0 = EffectConstant.INSTANCE.getLatestRelative() + File.separator;
        Stage2Config r1 = getStage2Config();
        ConfigManager r2 = INSTANCE;
        if (r2.getModelConfig().getManifest() == null) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L64;
        ModelManifest r4 = r2.getModelConfig().getManifest();
        LogUtils.d(TAG, "overwriteByManifest now !!", new Object[0]);
        if (r4 != null) goto L13;
        return;
    L13:
        if (r2.isNotNullOrEmpty(r4.getDescription()) == false) goto L16;
        r1.setDescription(r4.getDescription());
    L16:
        if (r2.isNotNullOrEmpty(r4.getDate()) == false) goto L19;
        r1.setDate(r4.getDate());
    L19:
        if (r2.isNotNullOrEmpty(r4.getVersion()) == false) goto L22;
        r1.setVersion(r4.getVersion());
    L22:
        if (r2.isNotNullOrEmpty(r4.getKwsModelFile()) == false) goto L25;
        r1.setKwsfile(r0 + r4.getKwsModelFile());
    L25:
        if (r2.isNotNullOrEmpty(r4.getKwsModelMd5()) == false) goto L28;
        r1.setKwsmd5(r4.getKwsModelMd5());
    L28:
        if (r2.isNotNullOrEmpty(r4.getKwsKeyFile()) == false) goto L31;
        r1.setKws_key(r0 + r4.getKwsKeyFile());
    L31:
        if (r2.isNotNullOrEmpty(r4.getKwsKeyMd5()) == false) goto L34;
        r1.setKws_key_md5(r4.getKwsKeyMd5());
    L34:
        if (r2.isNotNullOrEmpty(r4.getKwsRawFileMd5()) == false) goto L37;
        r1.setKws_rawfile_md5(r4.getKwsRawFileMd5());
    L37:
        if (r2.isNotNullOrEmpty(r4.getKwsModelVersion()) == false) goto L40;
        r1.setKwsmodelVersion(r4.getKwsModelVersion());
    L40:
        if (r2.isNotNullOrEmpty(r4.getKwsEngineVersion()) == false) goto L43;
        r1.setKwsengineVersion(r4.getKwsEngineVersion());
    L43:
        if (r2.isNotNullOrEmpty(r4.getSidModelFile()) == false) goto L46;
        r1.setVoiceprint_file(r0 + r4.getSidModelFile());
    L46:
        if (r2.isNotNullOrEmpty(r4.getSidModelMd5()) == false) goto L49;
        r1.setVoiceprint_md5(r4.getSidModelMd5());
    L49:
        if (r2.isNotNullOrEmpty(r4.getSidKeyFile()) == false) goto L52;
        r1.setVoiceprint_key(r0 + r4.getSidKeyFile());
    L52:
        if (r2.isNotNullOrEmpty(r4.getSidKeyMd5()) == false) goto L55;
        r1.setVoiceprint_key_md5(r4.getSidKeyMd5());
    L55:
        if (r2.isNotNullOrEmpty(r4.getSidRawFileMd5()) == false) goto L58;
        r1.setVoiceprint_rawfile_md5(r4.getSidRawFileMd5());
    L58:
        if (r2.isNotNullOrEmpty(r4.getSidModelVersion()) == false) goto L61;
        r1.setVoiceprint_modelVersion(r4.getSidModelVersion());
    L61:
        if (r2.isNotNullOrEmpty(r4.getSidEngineVersion()) == false) goto L66;
        r1.setVoiceprint_engineVersion(r4.getSidEngineVersion());
        return;
    L66:
        return;
    L64:
        return;
    L5:
        r3 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.obric.sva.sdk.config.ConfigManager] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final boolean readAlternativeConfig() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(EffectConstant.INSTANCE.getBaseRoot() + File.separator + getModelConfig().getConfigFile());
        if (r0.exists() == true) goto L6;
        return false;
    L6:
        if (r0.isFile() == true) goto L60;
        return false;
    L60:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L44
        ?? r4 = INSTANCE;     // Catch: Throwable -> L44
        CurrentModelConfig r5 = r4.getModelConfig();     // Catch: Throwable -> L44
        if (Intrinsics.areEqual(r5.getOwner(), "alternative") == true) goto L57;
        r5 = null;
    L57:
        if (r5 == null) goto L39;
        PolarisFileReaderWrapper r6 = new PolarisFileReaderWrapper(r0);     // Catch: Throwable -> L44
    L33:
        th = th;
        r4 = 0;
    L62:
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L64:
        r4.getModelConfig().setManifest((ModelManifest) new Gson().fromJson(r6, ModelManifest.class));     // Catch: Throwable -> L18
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        if (Result.isSuccess-impl(r1) == false) goto L24;
        Unit r7 = (Unit) r1;     // Catch: Throwable -> L33
        r4 = 1;
    L55:
        ?? r8 = r4;
        if (Result.exceptionOrNull-impl(r1) == null) goto L29;
        ConfigManager r9 = INSTANCE;     // Catch: Throwable -> L31
        r9.setModelConfig(r9.getDefaultCurrentModelConfig());     // Catch: Throwable -> L31
        r9.getModelConfig().setManifest(null);     // Catch: Throwable -> L31
        r8 = 0;
    L29:
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L42
        Result r2 = Result.box-impl(r1);     // Catch: Throwable -> L42
        ?? r10 = r8;
    L40:
        Object r11 = Result.constructor-impl(r2);     // Catch: Throwable -> L42
        ?? r12 = r10;
    L47:
        Throwable r13 = Result.exceptionOrNull-impl(r11);
        if (r13 == null) goto L51;
        StringBuilder r14 = new StringBuilder("readAlternativeConfig ");
        r13.printStackTrace();
        r14.append(Unit.INSTANCE);
        LogUtils.d(TAG, r14.toString(), new Object[0]);
        ConfigManager r15 = INSTANCE;
        r15.setModelConfig(r15.getDefaultCurrentModelConfig());
        r15.getModelConfig().setManifest(null);
    L51:
        if (Result.isSuccess-impl(r11) == false) goto L53;
        Result r16 = (Result) r11;
        LogUtils.d(TAG, "readAlternativeConfig success", new Object[0]);
    L53:
        LogUtils.d(TAG, "readAlternativeConfig modelConfig is " + getModelConfig() + " and result is " + r12, new Object[0]);
        return r12;
    L31:
        th = th;
        goto L62
    L24:
        r4 = 0;
    L18:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L33
        r1 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L21
    L39:
        r2 = null;
        r10 = 0;
    L42:
        th = th;
    L46:
        Result.Companion r18 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        r12 = r4;
    L44:
        th = th;
        r4 = 0;
        goto L46
    }

    public final boolean canOverwriteByManifest() {
        String r0 = getStage2Config().getVersion();
        String r1 = "0.0.0";
        if (r0 != null) goto L5;
        r0 = "0.0.0";
    L5:
        ModelManifest r2 = getModelConfig().getManifest();
        if (r2 == null) goto L11;
        String r3 = r2.getVersion();
        if (r3 == null) goto L11;
        r1 = r3;
    L11:
        int r4 = EffectUtils.INSTANCE.compareVersion(r1, r0);
        LogUtils.d(TAG, "canOverwriteByManifest " + getStage2Config() + " by " + getModelConfig().getManifest() + " 【 VersionNote：】 updateVersion " + r1 + " defaultVersion " + r0 + " compare " + r4, new Object[0]);
        if (r4 > 0) goto L15;
        LogUtils.d(TAG, "canOverwriteByManifest is false , due to version is not large than default version", new Object[0]);
        return false;
    L15:
        return true;
    }

    public final String getEngineVersion() {
        return getStage2Config().getKwsengineVersion();
    }

    public final String getVoicePrintEngineVersion() {
        return getStage2Config().getVoiceprint_engineVersion();
    }

    private final boolean isNotNullOrEmpty(CharSequence r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.length() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void init(String r3) {
        Intrinsics.checkNotNullParameter(r3, "rootDir");
        reLoadCurrentJson(r3);
        LogUtils.d(TAG, "init modelConfig is " + getModelConfig(), new Object[0]);
    }

    public final void reLoadCurrentJson(String r7) {
        Intrinsics.checkNotNullParameter(r7, "rootDir");
        setModelConfig(getDefaultCurrentModelConfig());
        PolarisFileWrapper r1 = new PolarisFileWrapper(r7 + File.separator + "current.json");
        if (r1.exists() == true) goto L5;
    L24:
        LogUtils.d(TAG, "init currentFile not found , use default config ", new Object[0]);
        return;
    L5:
        if (r1.isFile() == false) goto L24;
        Gson r8 = new Gson();
        PolarisFileReaderWrapper r4 = new PolarisFileReaderWrapper(r1);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        INSTANCE.setModelConfig((CurrentModelConfig) r8.fromJson(r4, CurrentModelConfig.class));     // Catch: Throwable -> L9
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.isSuccess-impl(r9) == false) goto L15;
        Unit r3 = (Unit) r9;     // Catch: Throwable -> L19
    L15:
        if (Result.exceptionOrNull-impl(r9) == null) goto L17;
        ConfigManager r5 = INSTANCE;     // Catch: Throwable -> L19
        r5.setModelConfig(r5.getDefaultCurrentModelConfig());     // Catch: Throwable -> L19
    L17:
        LogUtils.d(TAG, "init currentFile " + Result.toString-impl(r9), new Object[0]);     // Catch: Throwable -> L19
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r4, null);
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
        goto L12
    }

    public final Stage2Config readDefaultConfig(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        LogUtils.d(TAG, "readDefaultConfig now", new Object[0]);
        InputStream r8 = r7.getAssets().open(DEFAULT_FILE_PATH);
        byte[] r2 = new byte[r8.available()];     // Catch: Throwable -> L6
        r8.read(r2);     // Catch: Throwable -> L6
        String r4 = new String(r2, Charsets.UTF_8);     // Catch: Throwable -> L6
        LogUtils.d(TAG, "read config raw: ".concat(r4), new Object[0]);     // Catch: Throwable -> L6
        Stage2Config r0 = Stage2Config.Companion.fromJson(r4);     // Catch: Throwable -> L6
        INSTANCE.setStage2Config(r0);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r8, null);
        return r0;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    }

    public final void setModelConfig(CurrentModelConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        modelConfig = r2;
    }

    public final void setStage2Config(Stage2Config r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        stage2Config = r2;
    }
}
