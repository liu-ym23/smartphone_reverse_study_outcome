package com.obric.sva.sdk.config;

import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bM\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 V2\u00020\u0001:\u0001VBß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003Já\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020THÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001aR \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001aR \u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001a¨\u0006W"}, d2 = {"Lcom/obric/sva/sdk/config/Stage2Config;", "", "model", "", "date", "version", "description", "Kwsfile", "KwsmodelVersion", "KwsengineVersion", "Kwsmd5", "Kws_key", "Kws_key_md5", "Voiceprint_file", "Voiceprint_modelVersion", "Voiceprint_engineVersion", "Voiceprint_md5", "Voiceprint_key", "Voiceprint_key_md5", "Kws_rawfile_md5", "Voiceprint_rawfile_md5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "setModel", "(Ljava/lang/String;)V", "getDate", "setDate", "getVersion", "setVersion", "getDescription", "setDescription", "getKwsfile", "setKwsfile", "getKwsmodelVersion", "setKwsmodelVersion", "getKwsengineVersion", "setKwsengineVersion", "getKwsmd5", "setKwsmd5", "getKws_key", "setKws_key", "getKws_key_md5", "setKws_key_md5", "getVoiceprint_file", "setVoiceprint_file", "getVoiceprint_modelVersion", "setVoiceprint_modelVersion", "getVoiceprint_engineVersion", "setVoiceprint_engineVersion", "getVoiceprint_md5", "setVoiceprint_md5", "getVoiceprint_key", "setVoiceprint_key", "getVoiceprint_key_md5", "setVoiceprint_key_md5", "getKws_rawfile_md5", "setKws_rawfile_md5", "getVoiceprint_rawfile_md5", "setVoiceprint_rawfile_md5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class Stage2Config {
    public static final Companion Companion = null;

    @SerializedName("kws-key")
    private String Kws_key;

    @SerializedName("kws-key-md5")
    private String Kws_key_md5;

    @SerializedName("kws-rawfile-md5")
    private String Kws_rawfile_md5;

    @SerializedName("kws-engine-version")
    private String KwsengineVersion;

    @SerializedName("kws-file")
    private String Kwsfile;

    @SerializedName("kws-md5")
    private String Kwsmd5;

    @SerializedName("kws-model-version")
    private String KwsmodelVersion;

    @SerializedName("voiceprint-engine-version")
    private String Voiceprint_engineVersion;

    @SerializedName("voiceprint-file")
    private String Voiceprint_file;

    @SerializedName("voiceprint-key")
    private String Voiceprint_key;

    @SerializedName("voiceprint-key-md5")
    private String Voiceprint_key_md5;

    @SerializedName("voiceprint-md5")
    private String Voiceprint_md5;

    @SerializedName("voiceprint-model-version")
    private String Voiceprint_modelVersion;

    @SerializedName("voiceprint-rawfile-md5")
    private String Voiceprint_rawfile_md5;

    @SerializedName("date")
    private String date;

    @SerializedName("description")
    private String description;

    @SerializedName("model")
    private String model;

    @SerializedName("version")
    private String version;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/config/Stage2Config$Companion;", "", "<init>", "()V", "fromJson", "Lcom/obric/sva/sdk/config/Stage2Config;", "_json", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Stage2Config fromJson(String r3) {
            Intrinsics.checkNotNullParameter(r3, "_json");
            return (Stage2Config) GsonProtectorUtils.fromJson(new Gson(), r3, Stage2Config.class);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Stage2Config() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public static /* synthetic */ Stage2Config copy$default(Stage2Config r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        String r2 = r17.model;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = r17.date;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r4 = r17.version;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r5 = r17.description;
    L19:
        if ((r36 & 16) == 0) goto L21;
        String r6 = r17.Kwsfile;
    L23:
        if ((r36 & 32) == 0) goto L25;
        String r7 = r17.KwsmodelVersion;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r8 = r17.KwsengineVersion;
    L31:
        if ((r36 & 128) == 0) goto L33;
        String r9 = r17.Kwsmd5;
    L35:
        if ((r36 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = r17.Kws_key;
    L39:
        if ((r36 & ISmModel.VERSION_0200) == 0) goto L41;
        String r11 = r17.Kws_key_md5;
    L43:
        if ((r36 & ISmModel.VERSION_0400) == 0) goto L45;
        String r12 = r17.Voiceprint_file;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        String r13 = r17.Voiceprint_modelVersion;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        String r14 = r17.Voiceprint_engineVersion;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        String r15 = r17.Voiceprint_md5;
    L58:
        String r38 = r15;
        if ((r36 & 16384) == 0) goto L61;
        String r16 = r17.Voiceprint_key;
    L62:
        String r39 = r16;
        if ((r36 & 32768) == 0) goto L65;
        String r110 = r17.Voiceprint_key_md5;
    L66:
        String r310 = r110;
        if ((r36 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        String r111 = r17.Kws_rawfile_md5;
    L71:
        if ((r36 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) == 0) goto L73;
        String r1 = r17.Voiceprint_rawfile_md5;
    L75:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r38, r39, r310, r111, r1);
    L73:
        r1 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.model;
    }

    public final String component10() {
        return this.Kws_key_md5;
    }

    public final String component11() {
        return this.Voiceprint_file;
    }

    public final String component12() {
        return this.Voiceprint_modelVersion;
    }

    public final String component13() {
        return this.Voiceprint_engineVersion;
    }

    public final String component14() {
        return this.Voiceprint_md5;
    }

    public final String component15() {
        return this.Voiceprint_key;
    }

    public final String component16() {
        return this.Voiceprint_key_md5;
    }

    public final String component17() {
        return this.Kws_rawfile_md5;
    }

    public final String component18() {
        return this.Voiceprint_rawfile_md5;
    }

    public final String component2() {
        return this.date;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.Kwsfile;
    }

    public final String component6() {
        return this.KwsmodelVersion;
    }

    public final String component7() {
        return this.KwsengineVersion;
    }

    public final String component8() {
        return this.Kwsmd5;
    }

    public final String component9() {
        return this.Kws_key;
    }

    public final Stage2Config copy(String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38) {
        return new Stage2Config(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Stage2Config) == true) goto L8;
        return false;
    L8:
        Stage2Config r6 = (Stage2Config) r5;
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.Kwsfile, r6.Kwsfile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.KwsmodelVersion, r6.KwsmodelVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.KwsengineVersion, r6.KwsengineVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.Kwsmd5, r6.Kwsmd5) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.Kws_key, r6.Kws_key) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.Kws_key_md5, r6.Kws_key_md5) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.Voiceprint_file, r6.Voiceprint_file) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.Voiceprint_modelVersion, r6.Voiceprint_modelVersion) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.Voiceprint_engineVersion, r6.Voiceprint_engineVersion) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.Voiceprint_md5, r6.Voiceprint_md5) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.Voiceprint_key, r6.Voiceprint_key) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.Voiceprint_key_md5, r6.Voiceprint_key_md5) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.Kws_rawfile_md5, r6.Kws_rawfile_md5) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.Voiceprint_rawfile_md5, r6.Voiceprint_rawfile_md5) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        String r0 = this.model;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.date;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.version;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.description;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.Kwsfile;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.KwsmodelVersion;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.KwsengineVersion;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.Kwsmd5;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.Kws_key;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.Kws_key_md5;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.Voiceprint_file;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.Voiceprint_modelVersion;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.Voiceprint_engineVersion;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.Voiceprint_md5;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.Voiceprint_key;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.Voiceprint_key_md5;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.Kws_rawfile_md5;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.Voiceprint_rawfile_md5;
        if (r52 == null) goto L75;
        r1 = r52.hashCode();
    L75:
        return r51 + r1;
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Stage2Config(model=" + this.model + ", date=" + this.date + ", version=" + this.version + ", description=" + this.description + ", Kwsfile=" + this.Kwsfile + ", KwsmodelVersion=" + this.KwsmodelVersion + ", KwsengineVersion=" + this.KwsengineVersion + ", Kwsmd5=" + this.Kwsmd5 + ", Kws_key=" + this.Kws_key + ", Kws_key_md5=" + this.Kws_key_md5 + ", Voiceprint_file=" + this.Voiceprint_file + ", Voiceprint_modelVersion=" + this.Voiceprint_modelVersion + ", Voiceprint_engineVersion=" + this.Voiceprint_engineVersion + ", Voiceprint_md5=" + this.Voiceprint_md5 + ", Voiceprint_key=" + this.Voiceprint_key + ", Voiceprint_key_md5=" + this.Voiceprint_key_md5 + ", Kws_rawfile_md5=" + this.Kws_rawfile_md5 + ", Voiceprint_rawfile_md5=" + this.Voiceprint_rawfile_md5 + ')';
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKws_key() {
        return this.Kws_key;
    }

    public final String getKws_key_md5() {
        return this.Kws_key_md5;
    }

    public final String getKws_rawfile_md5() {
        return this.Kws_rawfile_md5;
    }

    public final String getKwsengineVersion() {
        return this.KwsengineVersion;
    }

    public final String getKwsfile() {
        return this.Kwsfile;
    }

    public final String getKwsmd5() {
        return this.Kwsmd5;
    }

    public final String getKwsmodelVersion() {
        return this.KwsmodelVersion;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getVoiceprint_engineVersion() {
        return this.Voiceprint_engineVersion;
    }

    public final String getVoiceprint_file() {
        return this.Voiceprint_file;
    }

    public final String getVoiceprint_key() {
        return this.Voiceprint_key;
    }

    public final String getVoiceprint_key_md5() {
        return this.Voiceprint_key_md5;
    }

    public final String getVoiceprint_md5() {
        return this.Voiceprint_md5;
    }

    public final String getVoiceprint_modelVersion() {
        return this.Voiceprint_modelVersion;
    }

    public final String getVoiceprint_rawfile_md5() {
        return this.Voiceprint_rawfile_md5;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final void setDescription(String r1) {
        this.description = r1;
    }

    public final void setKws_key(String r1) {
        this.Kws_key = r1;
    }

    public final void setKws_key_md5(String r1) {
        this.Kws_key_md5 = r1;
    }

    public final void setKws_rawfile_md5(String r1) {
        this.Kws_rawfile_md5 = r1;
    }

    public final void setKwsengineVersion(String r1) {
        this.KwsengineVersion = r1;
    }

    public final void setKwsfile(String r1) {
        this.Kwsfile = r1;
    }

    public final void setKwsmd5(String r1) {
        this.Kwsmd5 = r1;
    }

    public final void setKwsmodelVersion(String r1) {
        this.KwsmodelVersion = r1;
    }

    public final void setModel(String r1) {
        this.model = r1;
    }

    public final void setVersion(String r1) {
        this.version = r1;
    }

    public final void setVoiceprint_engineVersion(String r1) {
        this.Voiceprint_engineVersion = r1;
    }

    public final void setVoiceprint_file(String r1) {
        this.Voiceprint_file = r1;
    }

    public final void setVoiceprint_key(String r1) {
        this.Voiceprint_key = r1;
    }

    public final void setVoiceprint_key_md5(String r1) {
        this.Voiceprint_key_md5 = r1;
    }

    public final void setVoiceprint_md5(String r1) {
        this.Voiceprint_md5 = r1;
    }

    public final void setVoiceprint_modelVersion(String r1) {
        this.Voiceprint_modelVersion = r1;
    }

    public final void setVoiceprint_rawfile_md5(String r1) {
        this.Voiceprint_rawfile_md5 = r1;
    }

    public Stage2Config(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20) {
        this.model = r3;
        this.date = r4;
        this.version = r5;
        this.description = r6;
        this.Kwsfile = r7;
        this.KwsmodelVersion = r8;
        this.KwsengineVersion = r9;
        this.Kwsmd5 = r10;
        this.Kws_key = r11;
        this.Kws_key_md5 = r12;
        this.Voiceprint_file = r13;
        this.Voiceprint_modelVersion = r14;
        this.Voiceprint_engineVersion = r15;
        this.Voiceprint_md5 = r16;
        this.Voiceprint_key = r17;
        this.Voiceprint_key_md5 = r18;
        this.Kws_rawfile_md5 = r19;
        this.Voiceprint_rawfile_md5 = r20;
    }

    public /* synthetic */ Stage2Config(String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, int r38, DefaultConstructorMarker r39) {
        if ((r38 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r38 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r38 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r38 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r38 & ISmModel.VERSION_0200) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r38 & ISmModel.VERSION_0400) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r38 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r38 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r38 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r38 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) == 0) goto L73;
        String r0 = null;
    L74:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r0);
        return;
    L73:
        r0 = r37;
        goto L74
    L69:
        r17 = r36;
        goto L71
    L65:
        r16 = r35;
        goto L67
    L61:
        r2 = r34;
        goto L63
    L57:
        r15 = r33;
        goto L59
    L53:
        r14 = r32;
        goto L55
    L49:
        r13 = r31;
        goto L51
    L45:
        r12 = r30;
        goto L47
    L41:
        r11 = r29;
        goto L43
    L37:
        r10 = r28;
        goto L39
    L33:
        r9 = r27;
        goto L35
    L29:
        r8 = r26;
        goto L31
    L25:
        r7 = r25;
        goto L27
    L21:
        r6 = r24;
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
