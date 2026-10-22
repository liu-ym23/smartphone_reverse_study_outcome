package com.obric.sva.sdk.sami;

import androidx.profileinstaller.ProfileVerifier;
import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.controller.SvaSdkGlobal;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b@\b\u0086\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u001eJ\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\nHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\t\u0010U\u001a\u00020\nHÆ\u0003J\t\u0010V\u001a\u00020\u001aHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010X\u001a\u00020\u001eHÆ\u0003Jû\u0001\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eHÆ\u0001J\u0013\u0010Z\u001a\u00020\u001e2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\nHÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0011\u0010\u0018\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006^"}, d2 = {"Lcom/obric/sva/sdk/sami/WakeupParamSnapshot;", "", "sn", "", "did", "uid", "doubaoUid", "doubaoDid", "dbPath", "appStatus", "", "appVersion", "groupId", "engineVersion", "dumpDir", "appId", "modelMd5", "modelPath", "kwsEncKeyInfo", "sidModelMd5", "sidModelPath", "sidEncKeyInfo", "sidFilePath", "sidLevel", "sidBarginStatus", "sidVolume", "", "sidThresholds", "", "bypassAdaptiveSid", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIF[FZ)V", "getSn", "()Ljava/lang/String;", "getDid", "getUid", "getDoubaoUid", "getDoubaoDid", "getDbPath", "getAppStatus", "()I", "getAppVersion", "getGroupId", "getEngineVersion", "getDumpDir", "getAppId", "getModelMd5", "getModelPath", "getKwsEncKeyInfo", "getSidModelMd5", "getSidModelPath", "getSidEncKeyInfo", "getSidFilePath", "getSidLevel", "getSidBarginStatus", "getSidVolume", "()F", "getSidThresholds", "()[F", "getBypassAdaptiveSid", "()Z", "toJson", "businessType", "includeModelInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "other", "hashCode", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class WakeupParamSnapshot {
    private final String appId;
    private final int appStatus;
    private final String appVersion;
    private final boolean bypassAdaptiveSid;
    private final String dbPath;
    private final String did;
    private final String doubaoDid;
    private final String doubaoUid;
    private final String dumpDir;
    private final String engineVersion;
    private final String groupId;
    private final String kwsEncKeyInfo;
    private final String modelMd5;
    private final String modelPath;
    private final int sidBarginStatus;
    private final String sidEncKeyInfo;
    private final String sidFilePath;
    private final int sidLevel;
    private final String sidModelMd5;
    private final String sidModelPath;
    private final float[] sidThresholds;
    private final float sidVolume;
    private final String sn;
    private final String uid;

    public WakeupParamSnapshot() {
        this(null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, null, false, 16777215, null);
    }

    public static /* synthetic */ WakeupParamSnapshot copy$default(WakeupParamSnapshot r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, int r37, int r38, float r39, float[] r40, boolean r41, int r42, Object r43) {
        if ((r42 & 1) == 0) goto L5;
        String r2 = r17.sn;
    L7:
        if ((r42 & 2) == 0) goto L9;
        String r3 = r17.did;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = r17.uid;
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r5 = r17.doubaoUid;
    L19:
        if ((r42 & 16) == 0) goto L21;
        String r6 = r17.doubaoDid;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r7 = r17.dbPath;
    L27:
        if ((r42 & 64) == 0) goto L29;
        int r8 = r17.appStatus;
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r9 = r17.appVersion;
    L35:
        if ((r42 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = r17.groupId;
    L39:
        if ((r42 & ISmModel.VERSION_0200) == 0) goto L41;
        String r11 = r17.engineVersion;
    L43:
        if ((r42 & ISmModel.VERSION_0400) == 0) goto L45;
        String r12 = r17.dumpDir;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r13 = r17.appId;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r14 = r17.modelMd5;
    L55:
        if ((r42 & 8192) == 0) goto L57;
        String r15 = r17.modelPath;
    L58:
        String r310 = r15;
        if ((r42 & 16384) == 0) goto L61;
        String r16 = r17.kwsEncKeyInfo;
    L62:
        String r311 = r16;
        if ((r42 & 32768) == 0) goto L65;
        String r110 = r17.sidModelMd5;
    L66:
        String r312 = r110;
        if ((r42 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        String r111 = r17.sidModelPath;
    L70:
        String r313 = r111;
        if ((r42 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) == 0) goto L73;
        String r112 = r17.sidEncKeyInfo;
    L74:
        String r314 = r112;
        if ((r42 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION) == 0) goto L77;
        String r113 = r17.sidFilePath;
    L78:
        String r315 = r113;
        if ((r42 & 524288) == 0) goto L81;
        int r114 = r17.sidLevel;
    L82:
        int r316 = r114;
        if ((r42 & 1048576) == 0) goto L85;
        int r115 = r17.sidBarginStatus;
    L86:
        int r317 = r115;
        if ((r42 & 2097152) == 0) goto L89;
        float r116 = r17.sidVolume;
    L90:
        float r318 = r116;
        if ((r42 & 4194304) == 0) goto L93;
        float[] r117 = r17.sidThresholds;
    L95:
        if ((r42 & 8388608) == 0) goto L97;
        boolean r1 = r17.bypassAdaptiveSid;
    L99:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r117, r1);
    L97:
        r1 = r41;
        goto L99
    L93:
        r117 = r40;
        goto L95
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
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
        return this.sn;
    }

    public final String component10() {
        return this.engineVersion;
    }

    public final String component11() {
        return this.dumpDir;
    }

    public final String component12() {
        return this.appId;
    }

    public final String component13() {
        return this.modelMd5;
    }

    public final String component14() {
        return this.modelPath;
    }

    public final String component15() {
        return this.kwsEncKeyInfo;
    }

    public final String component16() {
        return this.sidModelMd5;
    }

    public final String component17() {
        return this.sidModelPath;
    }

    public final String component18() {
        return this.sidEncKeyInfo;
    }

    public final String component19() {
        return this.sidFilePath;
    }

    public final String component2() {
        return this.did;
    }

    public final int component20() {
        return this.sidLevel;
    }

    public final int component21() {
        return this.sidBarginStatus;
    }

    public final float component22() {
        return this.sidVolume;
    }

    public final float[] component23() {
        return this.sidThresholds;
    }

    public final boolean component24() {
        return this.bypassAdaptiveSid;
    }

    public final String component3() {
        return this.uid;
    }

    public final String component4() {
        return this.doubaoUid;
    }

    public final String component5() {
        return this.doubaoDid;
    }

    public final String component6() {
        return this.dbPath;
    }

    public final int component7() {
        return this.appStatus;
    }

    public final String component8() {
        return this.appVersion;
    }

    public final String component9() {
        return this.groupId;
    }

    public final WakeupParamSnapshot copy(String r28, String r29, String r30, String r31, String r32, String r33, int r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, int r47, int r48, float r49, float[] r50, boolean r51) {
        Intrinsics.checkNotNullParameter(r28, "sn");
        Intrinsics.checkNotNullParameter(r29, "did");
        Intrinsics.checkNotNullParameter(r30, "uid");
        Intrinsics.checkNotNullParameter(r31, "doubaoUid");
        Intrinsics.checkNotNullParameter(r32, "doubaoDid");
        Intrinsics.checkNotNullParameter(r33, "dbPath");
        Intrinsics.checkNotNullParameter(r35, "appVersion");
        Intrinsics.checkNotNullParameter(r36, "groupId");
        Intrinsics.checkNotNullParameter(r37, "engineVersion");
        Intrinsics.checkNotNullParameter(r38, "dumpDir");
        Intrinsics.checkNotNullParameter(r39, "appId");
        Intrinsics.checkNotNullParameter(r40, "modelMd5");
        Intrinsics.checkNotNullParameter(r41, "modelPath");
        Intrinsics.checkNotNullParameter(r42, "kwsEncKeyInfo");
        Intrinsics.checkNotNullParameter(r43, "sidModelMd5");
        Intrinsics.checkNotNullParameter(r44, "sidModelPath");
        Intrinsics.checkNotNullParameter(r45, "sidEncKeyInfo");
        Intrinsics.checkNotNullParameter(r46, "sidFilePath");
        return new WakeupParamSnapshot(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WakeupParamSnapshot) == true) goto L8;
        return false;
    L8:
        WakeupParamSnapshot r6 = (WakeupParamSnapshot) r5;
        if (Intrinsics.areEqual(this.sn, r6.sn) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.did, r6.did) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uid, r6.uid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.doubaoUid, r6.doubaoUid) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.doubaoDid, r6.doubaoDid) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dbPath, r6.dbPath) == true) goto L27;
        return false;
    L27:
        if (this.appStatus == r6.appStatus) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.appVersion, r6.appVersion) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.groupId, r6.groupId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.engineVersion, r6.engineVersion) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.dumpDir, r6.dumpDir) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.modelMd5, r6.modelMd5) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.modelPath, r6.modelPath) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.kwsEncKeyInfo, r6.kwsEncKeyInfo) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.sidModelMd5, r6.sidModelMd5) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.sidModelPath, r6.sidModelPath) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.sidEncKeyInfo, r6.sidEncKeyInfo) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.sidFilePath, r6.sidFilePath) == true) goto L66;
        return false;
    L66:
        if (this.sidLevel == r6.sidLevel) goto L69;
        return false;
    L69:
        if (this.sidBarginStatus == r6.sidBarginStatus) goto L72;
        return false;
    L72:
        if (Float.compare(this.sidVolume, r6.sidVolume) == 0) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.sidThresholds, r6.sidThresholds) == true) goto L78;
        return false;
    L78:
        if (this.bypassAdaptiveSid == r6.bypassAdaptiveSid) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((((((((((((((((((((((((this.sn.hashCode() * 31) + this.did.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.doubaoUid.hashCode()) * 31) + this.doubaoDid.hashCode()) * 31) + this.dbPath.hashCode()) * 31) + this.appStatus) * 31) + this.appVersion.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.engineVersion.hashCode()) * 31) + this.dumpDir.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.modelMd5.hashCode()) * 31) + this.modelPath.hashCode()) * 31) + this.kwsEncKeyInfo.hashCode()) * 31) + this.sidModelMd5.hashCode()) * 31) + this.sidModelPath.hashCode()) * 31) + this.sidEncKeyInfo.hashCode()) * 31) + this.sidFilePath.hashCode()) * 31) + this.sidLevel) * 31) + this.sidBarginStatus) * 31) + Float.floatToIntBits(this.sidVolume)) * 31;
        float[] r1 = this.sidThresholds;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.bypassAdaptiveSid == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = Arrays.hashCode(r1);
        goto L6
    }

    public String toString() {
        return "WakeupParamSnapshot(sn=" + this.sn + ", did=" + this.did + ", uid=" + this.uid + ", doubaoUid=" + this.doubaoUid + ", doubaoDid=" + this.doubaoDid + ", dbPath=" + this.dbPath + ", appStatus=" + this.appStatus + ", appVersion=" + this.appVersion + ", groupId=" + this.groupId + ", engineVersion=" + this.engineVersion + ", dumpDir=" + this.dumpDir + ", appId=" + this.appId + ", modelMd5=" + this.modelMd5 + ", modelPath=" + this.modelPath + ", kwsEncKeyInfo=" + this.kwsEncKeyInfo + ", sidModelMd5=" + this.sidModelMd5 + ", sidModelPath=" + this.sidModelPath + ", sidEncKeyInfo=" + this.sidEncKeyInfo + ", sidFilePath=" + this.sidFilePath + ", sidLevel=" + this.sidLevel + ", sidBarginStatus=" + this.sidBarginStatus + ", sidVolume=" + this.sidVolume + ", sidThresholds=" + Arrays.toString(this.sidThresholds) + ", bypassAdaptiveSid=" + this.bypassAdaptiveSid + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getAppStatus() {
        return this.appStatus;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final boolean getBypassAdaptiveSid() {
        return this.bypassAdaptiveSid;
    }

    public final String getDbPath() {
        return this.dbPath;
    }

    public final String getDid() {
        return this.did;
    }

    public final String getDoubaoDid() {
        return this.doubaoDid;
    }

    public final String getDoubaoUid() {
        return this.doubaoUid;
    }

    public final String getDumpDir() {
        return this.dumpDir;
    }

    public final String getEngineVersion() {
        return this.engineVersion;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getKwsEncKeyInfo() {
        return this.kwsEncKeyInfo;
    }

    public final String getModelMd5() {
        return this.modelMd5;
    }

    public final String getModelPath() {
        return this.modelPath;
    }

    public final int getSidBarginStatus() {
        return this.sidBarginStatus;
    }

    public final String getSidEncKeyInfo() {
        return this.sidEncKeyInfo;
    }

    public final String getSidFilePath() {
        return this.sidFilePath;
    }

    public final int getSidLevel() {
        return this.sidLevel;
    }

    public final String getSidModelMd5() {
        return this.sidModelMd5;
    }

    public final String getSidModelPath() {
        return this.sidModelPath;
    }

    public final float[] getSidThresholds() {
        return this.sidThresholds;
    }

    public final float getSidVolume() {
        return this.sidVolume;
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String toJson(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "businessType");
        boolean r0 = true;
        if (r11 == false) goto L16;
        JSONObject r2 = new JSONObject();
        r2.put("model_md5", this.modelMd5);
        r2.put("model_path", this.modelPath);
        r2.put("engine_backend", "flute");
        r2.put("kws_enc_key_info", this.kwsEncKeyInfo);
        r2.put("sid_model_md5", this.sidModelMd5);
        r2.put("sid_model_path", this.sidModelPath);
        r2.put("sid_enc_key_info", this.sidEncKeyInfo);
        if (this.sidFilePath.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r2.put("sid_file_path", this.sidFilePath);
    L10:
        r2.put("sid_level", this.sidLevel);
        r2.put("sid_bargin_status", this.sidBarginStatus);
        r2.put("sid_volume", Float.valueOf(this.sidVolume));
        JSONObject r4 = new JSONObject();
        r4.put("usage", "");
        Unit r5 = Unit.INSTANCE;
        r2.put("extra", r4.toString());
        float[] r6 = this.sidThresholds;
        if (r6 == null) goto L17;
        JSONArray r7 = new JSONArray();
        int r8 = r6.length;
        int r9 = 0;
    L13:
        if (r9 >= r8) goto L15;
        r7.put(r6[r9]);
        r9 = r9 + 1;
        goto L13
    L15:
        Unit r12 = Unit.INSTANCE;
        r2.put("sid_threshold", r7);
    L17:
        JSONObject r13 = new JSONObject();
        r13.put("proto-version", "v2");
        r13.put("Passport-Auth", "session");
        r13.put("sdk-version", "2");
        r13.put("X-tt-Token", "123");
        String r14 = r13.toString();
        JSONObject r15 = new JSONObject();
        r15.put("app_key", SvaSdkGlobal.APP_KEY);
        r15.put("business_type", r10);
        if (r11 == false) goto L20;
        r15.put("doubao_uid", this.doubaoUid);
        r15.put("doubao_did", this.doubaoDid);
    L20:
        r15.put("token", "123");
        r15.put("token_type", SAMICoreTokenType.TOKEN_TO_C_D.getValue());
        r15.put("header", r14);
        r15.put("url", "https://audio.doubao.com/internal");
        JSONObject r16 = new JSONObject();
        r16.put("sn", this.sn);
        r16.put("did", this.did);
        if (this.uid.length() <= 0) goto L23;
        boolean r17 = true;
    L24:
        if (r17 == false) goto L27;
        r16.put("uid", this.uid);
    L27:
        if (this.dbPath.length() <= 0) goto L29;
        boolean r18 = true;
    L30:
        if (r18 == false) goto L33;
        r16.put("db_path", this.dbPath);
    L33:
        if (this.appId.length() <= 0) goto L35;
        boolean r19 = true;
    L36:
        if (r19 == false) goto L38;
        r16.put("app_id", this.appId);
    L38:
        r16.put("app_status", this.appStatus);
        if (this.appVersion.length() <= 0) goto L41;
        boolean r20 = true;
    L42:
        if (r20 == false) goto L44;
        r16.put("app_version", this.appVersion);
    L44:
        if (r11 == true) goto L46;
    L51:
        r16.put("bypass_adaptive_sid", this.bypassAdaptiveSid);
        r16.put("engine_version", this.engineVersion);
        r16.put("model_info", r2);
        r16.put("server_param", r15);
        r16.put("dump_dir", this.dumpDir);
        return r16.toString();
    L46:
        if (this.groupId.length() > 0) goto L49;
        r0 = false;
    L49:
        if (r0 == false) goto L51;
        r16.put("group_id", this.groupId);
        goto L51
    L41:
        r20 = false;
        goto L42
    L35:
        r19 = false;
        goto L36
    L29:
        r18 = false;
        goto L30
    L23:
        r17 = false;
        goto L24
    L7:
        r3 = false;
        goto L8
    L16:
        r2 = new JSONObject();
        goto L17
    }

    public WakeupParamSnapshot(String r17, String r18, String r19, String r20, String r21, String r22, int r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, int r36, int r37, float r38, float[] r39, boolean r40) {
        Intrinsics.checkNotNullParameter(r17, "sn");
        Intrinsics.checkNotNullParameter(r18, "did");
        Intrinsics.checkNotNullParameter(r19, "uid");
        Intrinsics.checkNotNullParameter(r20, "doubaoUid");
        Intrinsics.checkNotNullParameter(r21, "doubaoDid");
        Intrinsics.checkNotNullParameter(r22, "dbPath");
        Intrinsics.checkNotNullParameter(r24, "appVersion");
        Intrinsics.checkNotNullParameter(r25, "groupId");
        Intrinsics.checkNotNullParameter(r26, "engineVersion");
        Intrinsics.checkNotNullParameter(r27, "dumpDir");
        Intrinsics.checkNotNullParameter(r28, "appId");
        Intrinsics.checkNotNullParameter(r29, "modelMd5");
        Intrinsics.checkNotNullParameter(r30, "modelPath");
        Intrinsics.checkNotNullParameter(r31, "kwsEncKeyInfo");
        Intrinsics.checkNotNullParameter(r32, "sidModelMd5");
        Intrinsics.checkNotNullParameter(r33, "sidModelPath");
        Intrinsics.checkNotNullParameter(r34, "sidEncKeyInfo");
        Intrinsics.checkNotNullParameter(r35, "sidFilePath");
        this.sn = r17;
        this.did = r18;
        this.uid = r19;
        this.doubaoUid = r20;
        this.doubaoDid = r21;
        this.dbPath = r22;
        this.appStatus = r23;
        this.appVersion = r24;
        this.groupId = r25;
        this.engineVersion = r26;
        this.dumpDir = r27;
        this.appId = r28;
        this.modelMd5 = r29;
        this.modelPath = r30;
        this.kwsEncKeyInfo = r31;
        this.sidModelMd5 = r32;
        this.sidModelPath = r33;
        this.sidEncKeyInfo = r34;
        this.sidFilePath = r35;
        this.sidLevel = r36;
        this.sidBarginStatus = r37;
        this.sidVolume = r38;
        this.sidThresholds = r39;
        this.bypassAdaptiveSid = r40;
    }

    public /* synthetic */ WakeupParamSnapshot(String r26, String r27, String r28, String r29, String r30, String r31, int r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, int r45, int r46, float r47, float[] r48, boolean r49, int r50, DefaultConstructorMarker r51) {
        if ((r50 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r50 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r50 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r50 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r50 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r50 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r50 & 64) == 0) goto L29;
        int r8 = 0;
    L31:
        if ((r50 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r50 & ISmModel.VERSION_0100) == 0) goto L37;
        String r11 = "";
    L39:
        if ((r50 & ISmModel.VERSION_0200) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r50 & ISmModel.VERSION_0400) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r50 & 2048) == 0) goto L49;
        String r14 = "";
    L51:
        if ((r50 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r50 & 8192) == 0) goto L57;
        String r9 = "";
    L59:
        if ((r50 & 16384) == 0) goto L61;
        String r2 = "";
    L63:
        if ((r50 & 32768) == 0) goto L65;
        String r16 = "";
    L67:
        if ((r50 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        String r17 = "";
    L71:
        if ((r50 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) == 0) goto L73;
        String r18 = "";
    L75:
        if ((r50 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION) == 0) goto L77;
        String r19 = "";
    L79:
        if ((r50 & 524288) == 0) goto L81;
        int r20 = 2;
    L83:
        if ((r50 & 1048576) == 0) goto L85;
        int r21 = 0;
    L87:
        if ((r50 & 2097152) == 0) goto L89;
        float r22 = 0.0f;
    L91:
        if ((r50 & 4194304) == 0) goto L93;
        float[] r23 = null;
    L95:
        if ((r50 & 8388608) == 0) goto L97;
        boolean r0 = true;
    L98:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r9, r2, r16, r17, r18, r19, r20, r21, r22, r23, r0);
        return;
    L97:
        r0 = r49;
        goto L98
    L93:
        r23 = r48;
        goto L95
    L89:
        r22 = r47;
        goto L91
    L85:
        r21 = r46;
        goto L87
    L81:
        r20 = r45;
        goto L83
    L77:
        r19 = r44;
        goto L79
    L73:
        r18 = r43;
        goto L75
    L69:
        r17 = r42;
        goto L71
    L65:
        r16 = r41;
        goto L67
    L61:
        r2 = r40;
        goto L63
    L57:
        r9 = r39;
        goto L59
    L53:
        r15 = r38;
        goto L55
    L49:
        r14 = r37;
        goto L51
    L45:
        r13 = r36;
        goto L47
    L41:
        r12 = r35;
        goto L43
    L37:
        r11 = r34;
        goto L39
    L33:
        r10 = r33;
        goto L35
    L29:
        r8 = r32;
        goto L31
    L25:
        r7 = r31;
        goto L27
    L21:
        r6 = r30;
        goto L23
    L17:
        r5 = r29;
        goto L19
    L13:
        r4 = r28;
        goto L15
    L9:
        r3 = r27;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }
}
