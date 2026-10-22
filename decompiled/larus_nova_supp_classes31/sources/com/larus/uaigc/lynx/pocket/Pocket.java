package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\bHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010!R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010!R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001c¨\u0006J"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/Pocket;", "", "pocketId", "", "configName", "iconUrl", "prompt", "pocketType", "", "sendMsgPocket", "Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;", "keyboardInputPocket", "Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;", "uploadInputPocket", "Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;", "jumpSomewherePocket", "Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;", "intentionType", "status", "supportedOSAndVersion", "Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;", "ext", "promptForModel", "operator", "updateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPocketId", "()Ljava/lang/String;", "getConfigName", "getIconUrl", "getPrompt", "getPocketType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSendMsgPocket", "()Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;", "getKeyboardInputPocket", "()Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;", "getUploadInputPocket", "()Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;", "getJumpSomewherePocket", "()Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;", "getIntentionType", "getStatus", "getSupportedOSAndVersion", "()Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;", "getExt", "getPromptForModel", "getOperator", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/uaigc/lynx/pocket/Pocket;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class Pocket {

    @SerializedName("config_name")
    private final String configName;

    @SerializedName("ext")
    private final String ext;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("intention_type")
    private final Integer intentionType;

    @SerializedName("jump_somewhere_pocket")
    private final JumpSomewherePocket jumpSomewherePocket;

    @SerializedName("keyboard_input_pocket")
    private final KeyboardInputPocket keyboardInputPocket;

    @SerializedName("operator")
    private final String operator;

    @SerializedName("pocket_id")
    private final String pocketId;

    @SerializedName("pocket_type")
    private final Integer pocketType;

    @SerializedName("prompt")
    private final String prompt;

    @SerializedName("prompt_for_model")
    private final String promptForModel;

    @SerializedName("send_msg_pocket")
    private final SendMsgPocket sendMsgPocket;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("supported_systems_and_versions")
    private final SupportedOSAndVersion supportedOSAndVersion;

    @SerializedName("update_time")
    private final String updateTime;

    @SerializedName("upload_input_pocket")
    private final UploadInputPocket uploadInputPocket;

    public Pocket() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ Pocket copy$default(Pocket r17, String r18, String r19, String r20, String r21, Integer r22, SendMsgPocket r23, KeyboardInputPocket r24, UploadInputPocket r25, JumpSomewherePocket r26, Integer r27, Integer r28, SupportedOSAndVersion r29, String r30, String r31, String r32, String r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = r17.pocketId;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = r17.configName;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = r17.iconUrl;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r5 = r17.prompt;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Integer r6 = r17.pocketType;
    L23:
        if ((r34 & 32) == 0) goto L25;
        SendMsgPocket r7 = r17.sendMsgPocket;
    L27:
        if ((r34 & 64) == 0) goto L29;
        KeyboardInputPocket r8 = r17.keyboardInputPocket;
    L31:
        if ((r34 & 128) == 0) goto L33;
        UploadInputPocket r9 = r17.uploadInputPocket;
    L35:
        if ((r34 & 256) == 0) goto L37;
        JumpSomewherePocket r10 = r17.jumpSomewherePocket;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Integer r11 = r17.intentionType;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        Integer r12 = r17.status;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        SupportedOSAndVersion r13 = r17.supportedOSAndVersion;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        String r14 = r17.ext;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r15 = r17.promptForModel;
    L58:
        String r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        String r16 = r17.operator;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r1 = r17.updateTime;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
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
        return this.pocketId;
    }

    public final Integer component10() {
        return this.intentionType;
    }

    public final Integer component11() {
        return this.status;
    }

    public final SupportedOSAndVersion component12() {
        return this.supportedOSAndVersion;
    }

    public final String component13() {
        return this.ext;
    }

    public final String component14() {
        return this.promptForModel;
    }

    public final String component15() {
        return this.operator;
    }

    public final String component16() {
        return this.updateTime;
    }

    public final String component2() {
        return this.configName;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.prompt;
    }

    public final Integer component5() {
        return this.pocketType;
    }

    public final SendMsgPocket component6() {
        return this.sendMsgPocket;
    }

    public final KeyboardInputPocket component7() {
        return this.keyboardInputPocket;
    }

    public final UploadInputPocket component8() {
        return this.uploadInputPocket;
    }

    public final JumpSomewherePocket component9() {
        return this.jumpSomewherePocket;
    }

    public final Pocket copy(String r19, String r20, String r21, String r22, Integer r23, SendMsgPocket r24, KeyboardInputPocket r25, UploadInputPocket r26, JumpSomewherePocket r27, Integer r28, Integer r29, SupportedOSAndVersion r30, String r31, String r32, String r33, String r34) {
        return new Pocket(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Pocket) == true) goto L8;
        return false;
    L8:
        Pocket r6 = (Pocket) r5;
        if (Intrinsics.areEqual(this.pocketId, r6.pocketId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.configName, r6.configName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pocketType, r6.pocketType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sendMsgPocket, r6.sendMsgPocket) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.keyboardInputPocket, r6.keyboardInputPocket) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.uploadInputPocket, r6.uploadInputPocket) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.jumpSomewherePocket, r6.jumpSomewherePocket) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.intentionType, r6.intentionType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.supportedOSAndVersion, r6.supportedOSAndVersion) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.promptForModel, r6.promptForModel) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.operator, r6.operator) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.updateTime, r6.updateTime) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r0 = this.pocketId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.configName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.iconUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.prompt;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.pocketType;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        SendMsgPocket r16 = this.sendMsgPocket;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        KeyboardInputPocket r19 = this.keyboardInputPocket;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        UploadInputPocket r22 = this.uploadInputPocket;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        JumpSomewherePocket r25 = this.jumpSomewherePocket;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.intentionType;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.status;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        SupportedOSAndVersion r34 = this.supportedOSAndVersion;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.ext;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.promptForModel;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.operator;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.updateTime;
        if (r46 == null) goto L67;
        r1 = r46.hashCode();
    L67:
        return r45 + r1;
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
        return "Pocket(pocketId=" + this.pocketId + ", configName=" + this.configName + ", iconUrl=" + this.iconUrl + ", prompt=" + this.prompt + ", pocketType=" + this.pocketType + ", sendMsgPocket=" + this.sendMsgPocket + ", keyboardInputPocket=" + this.keyboardInputPocket + ", uploadInputPocket=" + this.uploadInputPocket + ", jumpSomewherePocket=" + this.jumpSomewherePocket + ", intentionType=" + this.intentionType + ", status=" + this.status + ", supportedOSAndVersion=" + this.supportedOSAndVersion + ", ext=" + this.ext + ", promptForModel=" + this.promptForModel + ", operator=" + this.operator + ", updateTime=" + this.updateTime + ')';
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Integer getIntentionType() {
        return this.intentionType;
    }

    public final JumpSomewherePocket getJumpSomewherePocket() {
        return this.jumpSomewherePocket;
    }

    public final KeyboardInputPocket getKeyboardInputPocket() {
        return this.keyboardInputPocket;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getPocketId() {
        return this.pocketId;
    }

    public final Integer getPocketType() {
        return this.pocketType;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getPromptForModel() {
        return this.promptForModel;
    }

    public final SendMsgPocket getSendMsgPocket() {
        return this.sendMsgPocket;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final SupportedOSAndVersion getSupportedOSAndVersion() {
        return this.supportedOSAndVersion;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final UploadInputPocket getUploadInputPocket() {
        return this.uploadInputPocket;
    }

    public Pocket(String r3, String r4, String r5, String r6, Integer r7, SendMsgPocket r8, KeyboardInputPocket r9, UploadInputPocket r10, JumpSomewherePocket r11, Integer r12, Integer r13, SupportedOSAndVersion r14, String r15, String r16, String r17, String r18) {
        this.pocketId = r3;
        this.configName = r4;
        this.iconUrl = r5;
        this.prompt = r6;
        this.pocketType = r7;
        this.sendMsgPocket = r8;
        this.keyboardInputPocket = r9;
        this.uploadInputPocket = r10;
        this.jumpSomewherePocket = r11;
        this.intentionType = r12;
        this.status = r13;
        this.supportedOSAndVersion = r14;
        this.ext = r15;
        this.promptForModel = r16;
        this.operator = r17;
        this.updateTime = r18;
    }

    public /* synthetic */ Pocket(String r18, String r19, String r20, String r21, Integer r22, SendMsgPocket r23, KeyboardInputPocket r24, UploadInputPocket r25, JumpSomewherePocket r26, Integer r27, Integer r28, SupportedOSAndVersion r29, String r30, String r31, String r32, String r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        SendMsgPocket r7 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        KeyboardInputPocket r8 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        UploadInputPocket r9 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        JumpSomewherePocket r10 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        SupportedOSAndVersion r13 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r0 = null;
    L66:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r0);
        return;
    L65:
        r0 = r33;
        goto L66
    L61:
        r2 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
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
        r1 = r18;
        goto L7
    }
}
