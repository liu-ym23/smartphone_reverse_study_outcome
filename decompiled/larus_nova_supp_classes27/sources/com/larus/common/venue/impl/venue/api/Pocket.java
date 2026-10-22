package com.larus.common.venue.impl.venue.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\bHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b-\u0010\"R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b.\u0010\"R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d¨\u0006M"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/Pocket;", "", "pocketId", "", "configName", "iconUrl", "prompt", "pocketType", "", "pocketTag", "sendMsgPocket", "Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;", "keyboardInputPocket", "Lcom/larus/common/venue/impl/venue/api/KeyboardInputPocket;", "uploadInputPocket", "Lcom/larus/common/venue/impl/venue/api/UploadInputPocket;", "jumpSomewherePocket", "Lcom/larus/common/venue/impl/venue/api/JumpSomewherePocket;", "intentionType", "status", "supportedOSAndVersion", "Lcom/larus/common/venue/impl/venue/api/SupportedOSAndVersion;", "ext", "promptForModel", "operator", "updateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;Lcom/larus/common/venue/impl/venue/api/KeyboardInputPocket;Lcom/larus/common/venue/impl/venue/api/UploadInputPocket;Lcom/larus/common/venue/impl/venue/api/JumpSomewherePocket;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/common/venue/impl/venue/api/SupportedOSAndVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPocketId", "()Ljava/lang/String;", "getConfigName", "getIconUrl", "getPrompt", "getPocketType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPocketTag", "getSendMsgPocket", "()Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;", "getKeyboardInputPocket", "()Lcom/larus/common/venue/impl/venue/api/KeyboardInputPocket;", "getUploadInputPocket", "()Lcom/larus/common/venue/impl/venue/api/UploadInputPocket;", "getJumpSomewherePocket", "()Lcom/larus/common/venue/impl/venue/api/JumpSomewherePocket;", "getIntentionType", "getStatus", "getSupportedOSAndVersion", "()Lcom/larus/common/venue/impl/venue/api/SupportedOSAndVersion;", "getExt", "getPromptForModel", "getOperator", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;Lcom/larus/common/venue/impl/venue/api/KeyboardInputPocket;Lcom/larus/common/venue/impl/venue/api/UploadInputPocket;Lcom/larus/common/venue/impl/venue/api/JumpSomewherePocket;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/common/venue/impl/venue/api/SupportedOSAndVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/common/venue/impl/venue/api/Pocket;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Pocket {

    @SerializedName("prompt_for_display")
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

    @SerializedName("pocket_tag")
    private final Integer pocketTag;

    @SerializedName("pocket_type")
    private final Integer pocketType;

    @SerializedName("prompt")
    private final String prompt;

    @SerializedName("prompt_for_chat")
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
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ Pocket copy$default(Pocket r17, String r18, String r110, String r20, String r21, Integer r22, Integer r23, SendMsgPocket r24, KeyboardInputPocket r25, UploadInputPocket r26, JumpSomewherePocket r27, Integer r28, Integer r210, SupportedOSAndVersion r30, String r31, String r32, String r33, String r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        String r2 = r17.pocketId;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r3 = r17.configName;
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r4 = r17.iconUrl;
    L15:
        if ((r35 & 8) == 0) goto L17;
        String r5 = r17.prompt;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Integer r6 = r17.pocketType;
    L23:
        if ((r35 & 32) == 0) goto L25;
        Integer r7 = r17.pocketTag;
    L27:
        if ((r35 & 64) == 0) goto L29;
        SendMsgPocket r8 = r17.sendMsgPocket;
    L31:
        if ((r35 & 128) == 0) goto L33;
        KeyboardInputPocket r9 = r17.keyboardInputPocket;
    L35:
        if ((r35 & 256) == 0) goto L37;
        UploadInputPocket r10 = r17.uploadInputPocket;
    L39:
        if ((r35 & 512) == 0) goto L41;
        JumpSomewherePocket r11 = r17.jumpSomewherePocket;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        Integer r12 = r17.intentionType;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        Integer r13 = r17.status;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        SupportedOSAndVersion r14 = r17.supportedOSAndVersion;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        String r15 = r17.ext;
    L58:
        String r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        String r16 = r17.promptForModel;
    L62:
        String r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        String r111 = r17.operator;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        String r1 = r17.updateTime;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r111, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r111 = r33;
        goto L67
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
        r13 = r210;
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
        r3 = r110;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.pocketId;
    }

    public final JumpSomewherePocket component10() {
        return this.jumpSomewherePocket;
    }

    public final Integer component11() {
        return this.intentionType;
    }

    public final Integer component12() {
        return this.status;
    }

    public final SupportedOSAndVersion component13() {
        return this.supportedOSAndVersion;
    }

    public final String component14() {
        return this.ext;
    }

    public final String component15() {
        return this.promptForModel;
    }

    public final String component16() {
        return this.operator;
    }

    public final String component17() {
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

    public final Integer component6() {
        return this.pocketTag;
    }

    public final SendMsgPocket component7() {
        return this.sendMsgPocket;
    }

    public final KeyboardInputPocket component8() {
        return this.keyboardInputPocket;
    }

    public final UploadInputPocket component9() {
        return this.uploadInputPocket;
    }

    public final Pocket copy(String r20, String r21, String r22, String r23, Integer r24, Integer r25, SendMsgPocket r26, KeyboardInputPocket r27, UploadInputPocket r28, JumpSomewherePocket r210, Integer r30, Integer r31, SupportedOSAndVersion r32, String r33, String r34, String r35, String r36) {
        return new Pocket(r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33, r34, r35, r36);
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
        if (Intrinsics.areEqual(this.pocketTag, r6.pocketTag) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sendMsgPocket, r6.sendMsgPocket) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.keyboardInputPocket, r6.keyboardInputPocket) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.uploadInputPocket, r6.uploadInputPocket) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.jumpSomewherePocket, r6.jumpSomewherePocket) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.intentionType, r6.intentionType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.supportedOSAndVersion, r6.supportedOSAndVersion) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.promptForModel, r6.promptForModel) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.operator, r6.operator) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.updateTime, r6.updateTime) == true) goto L59;
        return false;
    L59:
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
        Integer r16 = this.pocketTag;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        SendMsgPocket r20 = this.sendMsgPocket;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        KeyboardInputPocket r23 = this.keyboardInputPocket;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        UploadInputPocket r26 = this.uploadInputPocket;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        JumpSomewherePocket r30 = this.jumpSomewherePocket;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r28 + r31) * 31;
        Integer r33 = this.intentionType;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        Integer r36 = this.status;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        SupportedOSAndVersion r40 = this.supportedOSAndVersion;
        if (r40 != null) goto L53;
        int r41 = 0;
    L54:
        int r42 = (r38 + r41) * 31;
        String r43 = this.ext;
        if (r43 != null) goto L57;
        int r44 = 0;
    L58:
        int r45 = (r42 + r44) * 31;
        String r46 = this.promptForModel;
        if (r46 != null) goto L61;
        int r47 = 0;
    L62:
        int r48 = (r45 + r47) * 31;
        String r50 = this.operator;
        if (r50 != null) goto L65;
        int r51 = 0;
    L66:
        int r52 = (r48 + r51) * 31;
        String r53 = this.updateTime;
        if (r53 == null) goto L71;
        r1 = r53.hashCode();
    L71:
        return r52 + r1;
    L65:
        r51 = r50.hashCode();
        goto L66
    L61:
        r47 = r46.hashCode();
        goto L62
    L57:
        r44 = r43.hashCode();
        goto L58
    L53:
        r41 = r40.hashCode();
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
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
        return "Pocket(pocketId=" + this.pocketId + ", configName=" + this.configName + ", iconUrl=" + this.iconUrl + ", prompt=" + this.prompt + ", pocketType=" + this.pocketType + ", pocketTag=" + this.pocketTag + ", sendMsgPocket=" + this.sendMsgPocket + ", keyboardInputPocket=" + this.keyboardInputPocket + ", uploadInputPocket=" + this.uploadInputPocket + ", jumpSomewherePocket=" + this.jumpSomewherePocket + ", intentionType=" + this.intentionType + ", status=" + this.status + ", supportedOSAndVersion=" + this.supportedOSAndVersion + ", ext=" + this.ext + ", promptForModel=" + this.promptForModel + ", operator=" + this.operator + ", updateTime=" + this.updateTime + ')';
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

    public final Integer getPocketTag() {
        return this.pocketTag;
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

    public Pocket(String r3, String r4, String r5, String r6, Integer r7, Integer r8, SendMsgPocket r9, KeyboardInputPocket r10, UploadInputPocket r11, JumpSomewherePocket r12, Integer r13, Integer r14, SupportedOSAndVersion r15, String r16, String r17, String r18, String r110) {
        this.pocketId = r3;
        this.configName = r4;
        this.iconUrl = r5;
        this.prompt = r6;
        this.pocketType = r7;
        this.pocketTag = r8;
        this.sendMsgPocket = r9;
        this.keyboardInputPocket = r10;
        this.uploadInputPocket = r11;
        this.jumpSomewherePocket = r12;
        this.intentionType = r13;
        this.status = r14;
        this.supportedOSAndVersion = r15;
        this.ext = r16;
        this.promptForModel = r17;
        this.operator = r18;
        this.updateTime = r110;
    }

    public /* synthetic */ Pocket(String r110, String r20, String r21, String r22, Integer r23, Integer r24, SendMsgPocket r25, KeyboardInputPocket r26, UploadInputPocket r27, JumpSomewherePocket r28, Integer r210, Integer r30, SupportedOSAndVersion r31, String r32, String r33, String r34, String r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r36 & 64) == 0) goto L29;
        SendMsgPocket r8 = null;
    L31:
        if ((r36 & 128) == 0) goto L33;
        KeyboardInputPocket r9 = null;
    L35:
        if ((r36 & 256) == 0) goto L37;
        UploadInputPocket r10 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        JumpSomewherePocket r11 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        SupportedOSAndVersion r14 = null;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        String r0 = null;
    L70:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r0);
        return;
    L69:
        r0 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r2 = r33;
        goto L63
    L57:
        r15 = r32;
        goto L59
    L53:
        r14 = r31;
        goto L55
    L49:
        r13 = r30;
        goto L51
    L45:
        r12 = r210;
        goto L47
    L41:
        r11 = r28;
        goto L43
    L37:
        r10 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r110;
        goto L7
    }
}
