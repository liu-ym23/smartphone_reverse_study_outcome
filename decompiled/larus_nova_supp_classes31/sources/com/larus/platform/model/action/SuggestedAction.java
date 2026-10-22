package com.larus.platform.model.action;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0017\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0017\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J³\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0001J\u0013\u00109\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(¨\u0006>"}, d2 = {"Lcom/larus/platform/model/action/SuggestedAction;", "Ljava/io/Serializable;", "suggestedActionKey", "", "suggestedActionType", "", "row", "displayName", "displayHighlight", "", "promptReplacementCfg", "Lcom/larus/platform/model/action/PromptReplacementCfg;", "displayExtList", "", "chatAbility", "ext", "Lcom/larus/platform/model/action/SuggestedExt;", "eventExtra", "", "redirectionCfg", "Lcom/larus/platform/model/action/RedirectionCfg;", "msgExt", "<init>", "(Ljava/lang/String;IILjava/lang/String;ZLcom/larus/platform/model/action/PromptReplacementCfg;Ljava/util/List;Ljava/lang/String;Lcom/larus/platform/model/action/SuggestedExt;Ljava/util/Map;Lcom/larus/platform/model/action/RedirectionCfg;Ljava/util/Map;)V", "getSuggestedActionKey", "()Ljava/lang/String;", "getSuggestedActionType", "()I", "getRow", "getDisplayName", "getDisplayHighlight", "()Z", "getPromptReplacementCfg", "()Lcom/larus/platform/model/action/PromptReplacementCfg;", "getDisplayExtList", "()Ljava/util/List;", "getChatAbility", "getExt", "()Lcom/larus/platform/model/action/SuggestedExt;", "getEventExtra", "()Ljava/util/Map;", "getRedirectionCfg", "()Lcom/larus/platform/model/action/RedirectionCfg;", "getMsgExt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SuggestedAction implements Serializable {

    @SerializedName("chat_ability")
    private final String chatAbility;

    @SerializedName("display_ext_list")
    private final List<String> displayExtList;

    @SerializedName("display_highlight")
    private final boolean displayHighlight;

    @SerializedName("display_name")
    private final String displayName;

    @SerializedName("event_extra")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> eventExtra;

    @SerializedName("extra")
    private final SuggestedExt ext;

    @SerializedName("msg_ext")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> msgExt;

    @SerializedName("prompt_replacement_cfg")
    private final PromptReplacementCfg promptReplacementCfg;

    @SerializedName("redirection_cfg")
    private final RedirectionCfg redirectionCfg;

    @SerializedName("row")
    private final int row;

    @SerializedName("suggested_action_key")
    private final String suggestedActionKey;

    @SerializedName("suggested_action_type")
    private final int suggestedActionType;

    public SuggestedAction() {
        this(null, 0, 0, null, false, null, null, null, null, null, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuggestedAction copy$default(SuggestedAction r13, String r14, int r15, int r16, String r17, boolean r18, PromptReplacementCfg r19, List r20, String r21, SuggestedExt r22, Map r23, RedirectionCfg r24, Map r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.suggestedActionKey;
    L7:
        if ((r26 & 2) == 0) goto L9;
        int r3 = r13.suggestedActionType;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r4 = r13.row;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.displayName;
    L19:
        if ((r26 & 16) == 0) goto L21;
        boolean r6 = r13.displayHighlight;
    L23:
        if ((r26 & 32) == 0) goto L25;
        PromptReplacementCfg r7 = r13.promptReplacementCfg;
    L27:
        if ((r26 & 64) == 0) goto L29;
        List r8 = r13.displayExtList;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = r13.chatAbility;
    L35:
        if ((r26 & 256) == 0) goto L37;
        SuggestedExt r10 = r13.ext;
    L39:
        if ((r26 & 512) == 0) goto L41;
        Map r11 = r13.eventExtra;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        RedirectionCfg r12 = r13.redirectionCfg;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        Map r1 = r13.msgExt;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.suggestedActionKey;
    }

    public final Map<String, String> component10() {
        return this.eventExtra;
    }

    public final RedirectionCfg component11() {
        return this.redirectionCfg;
    }

    public final Map<String, String> component12() {
        return this.msgExt;
    }

    public final int component2() {
        return this.suggestedActionType;
    }

    public final int component3() {
        return this.row;
    }

    public final String component4() {
        return this.displayName;
    }

    public final boolean component5() {
        return this.displayHighlight;
    }

    public final PromptReplacementCfg component6() {
        return this.promptReplacementCfg;
    }

    public final List<String> component7() {
        return this.displayExtList;
    }

    public final String component8() {
        return this.chatAbility;
    }

    public final SuggestedExt component9() {
        return this.ext;
    }

    public final SuggestedAction copy(String r15, int r16, int r17, String r18, boolean r19, PromptReplacementCfg r20, List<String> r21, String r22, SuggestedExt r23, Map<String, String> r24, RedirectionCfg r25, Map<String, String> r26) {
        return new SuggestedAction(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SuggestedAction) == true) goto L8;
        return false;
    L8:
        SuggestedAction r6 = (SuggestedAction) r5;
        if (Intrinsics.areEqual(this.suggestedActionKey, r6.suggestedActionKey) == true) goto L12;
        return false;
    L12:
        if (this.suggestedActionType == r6.suggestedActionType) goto L15;
        return false;
    L15:
        if (this.row == r6.row) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.displayName, r6.displayName) == true) goto L21;
        return false;
    L21:
        if (this.displayHighlight == r6.displayHighlight) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.promptReplacementCfg, r6.promptReplacementCfg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.displayExtList, r6.displayExtList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.chatAbility, r6.chatAbility) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.eventExtra, r6.eventExtra) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.redirectionCfg, r6.redirectionCfg) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.msgExt, r6.msgExt) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r0 = this.suggestedActionKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.suggestedActionType) * 31) + this.row) * 31;
        String r4 = this.displayName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.displayHighlight == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        PromptReplacementCfg r9 = this.promptReplacementCfg;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        List<String> r12 = this.displayExtList;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.chatAbility;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        SuggestedExt r18 = this.ext;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        Map<String, String> r21 = this.eventExtra;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        RedirectionCfg r24 = this.redirectionCfg;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        Map<String, String> r27 = this.msgExt;
        if (r27 == null) goto L43;
        r1 = r27.hashCode();
    L43:
        return r26 + r1;
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SuggestedAction(suggestedActionKey=" + this.suggestedActionKey + ", suggestedActionType=" + this.suggestedActionType + ", row=" + this.row + ", displayName=" + this.displayName + ", displayHighlight=" + this.displayHighlight + ", promptReplacementCfg=" + this.promptReplacementCfg + ", displayExtList=" + this.displayExtList + ", chatAbility=" + this.chatAbility + ", ext=" + this.ext + ", eventExtra=" + this.eventExtra + ", redirectionCfg=" + this.redirectionCfg + ", msgExt=" + this.msgExt + ')';
    }

    public final String getChatAbility() {
        return this.chatAbility;
    }

    public final List<String> getDisplayExtList() {
        return this.displayExtList;
    }

    public final boolean getDisplayHighlight() {
        return this.displayHighlight;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Map<String, String> getEventExtra() {
        return this.eventExtra;
    }

    public final SuggestedExt getExt() {
        return this.ext;
    }

    public final Map<String, String> getMsgExt() {
        return this.msgExt;
    }

    public final PromptReplacementCfg getPromptReplacementCfg() {
        return this.promptReplacementCfg;
    }

    public final RedirectionCfg getRedirectionCfg() {
        return this.redirectionCfg;
    }

    public final int getRow() {
        return this.row;
    }

    public final String getSuggestedActionKey() {
        return this.suggestedActionKey;
    }

    public final int getSuggestedActionType() {
        return this.suggestedActionType;
    }

    public SuggestedAction(String r1, int r2, int r3, String r4, boolean r5, PromptReplacementCfg r6, List<String> r7, String r8, SuggestedExt r9, Map<String, String> r10, RedirectionCfg r11, Map<String, String> r12) {
        this.suggestedActionKey = r1;
        this.suggestedActionType = r2;
        this.row = r3;
        this.displayName = r4;
        this.displayHighlight = r5;
        this.promptReplacementCfg = r6;
        this.displayExtList = r7;
        this.chatAbility = r8;
        this.ext = r9;
        this.eventExtra = r10;
        this.redirectionCfg = r11;
        this.msgExt = r12;
    }

    public /* synthetic */ SuggestedAction(String r14, int r15, int r16, String r17, boolean r18, PromptReplacementCfg r19, List r20, String r21, SuggestedExt r22, Map r23, RedirectionCfg r24, Map r25, int r26, DefaultConstructorMarker r27) {
        RedirectionCfg r2 = null;
        if ((r26 & 1) == 0) goto L5;
        String r1 = null;
    L6:
        boolean r4 = false;
        if ((r26 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r26 & 16) != 0) goto L23;
        r4 = r18;
    L23:
        if ((r26 & 32) == 0) goto L25;
        PromptReplacementCfg r7 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r26 & 256) == 0) goto L37;
        SuggestedExt r10 = null;
    L39:
        if ((r26 & 512) == 0) goto L41;
        Map r11 = new LinkedHashMap();
    L43:
        if ((r26 & 1024) != 0) goto L47;
        r2 = r24;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        Map r0 = new LinkedHashMap();
    L50:
        this(r1, r3, r5, r6, r4, r7, r8, r9, r10, r11, r2, r0);
        return;
    L49:
        r0 = r25;
        goto L50
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L6
    }
}
