package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\t\u00100\u001a\u00020\u000fHÆ\u0003J\u0095\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fHÆ\u0001J\u0013\u00102\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!¨\u00068"}, d2 = {"Lcom/ss/android/lark/chat/cot/ToolCallExtra;", "Lcom/ss/android/lark/chat/cot/CotBlockExtra;", "toolCallName", BuildConfig.FLAVOR, "icon", "args", "argsJson", ChameleonOpenTracker.ParamKey.RESULT, "resultJson", "parentMessageId", "resultAreas", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/cot/ToolCallResultArea;", "Lkotlin/collections/ArrayList;", "onlyText", BuildConfig.FLAVOR, "onlyCapsule", "onlyCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZZZ)V", "getToolCallName", "()Ljava/lang/String;", "getIcon", "getArgs", "getArgsJson", "getResult", "getResultJson", "getParentMessageId", "getResultAreas", "()Ljava/util/ArrayList;", "getOnlyText", "()Z", "setOnlyText", "(Z)V", "getOnlyCapsule", "setOnlyCapsule", "getOnlyCode", "setOnlyCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolCallExtra implements CotBlockExtra {
    private final String args;
    private final String argsJson;
    private final String icon;
    private boolean onlyCapsule;
    private boolean onlyCode;
    private boolean onlyText;
    private final String parentMessageId;
    private final String result;
    private final ArrayList<ToolCallResultArea> resultAreas;
    private final String resultJson;
    private final String toolCallName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolCallExtra copy$default(ToolCallExtra r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, ArrayList r20, boolean r21, boolean r22, boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.toolCallName;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.icon;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.args;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.argsJson;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.result;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.resultJson;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.parentMessageId;
    L31:
        if ((r24 & 128) == 0) goto L33;
        ArrayList r9 = r12.resultAreas;
    L35:
        if ((r24 & 256) == 0) goto L37;
        boolean r10 = r12.onlyText;
    L39:
        if ((r24 & 512) == 0) goto L41;
        boolean r11 = r12.onlyCapsule;
    L43:
        if ((r24 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        boolean r1 = r12.onlyCode;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.toolCallName;
    }

    public final boolean component10() {
        return this.onlyCapsule;
    }

    public final boolean component11() {
        return this.onlyCode;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.args;
    }

    public final String component4() {
        return this.argsJson;
    }

    public final String component5() {
        return this.result;
    }

    public final String component6() {
        return this.resultJson;
    }

    public final String component7() {
        return this.parentMessageId;
    }

    public final ArrayList<ToolCallResultArea> component8() {
        return this.resultAreas;
    }

    public final boolean component9() {
        return this.onlyText;
    }

    public final ToolCallExtra copy(String r14, String r15, String r16, String r17, String r18, String r19, String r20, ArrayList<ToolCallResultArea> r21, boolean r22, boolean r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r21, "resultAreas");
        return new ToolCallExtra(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ToolCallExtra) == true) goto L8;
        return false;
    L8:
        ToolCallExtra r6 = (ToolCallExtra) r5;
        if (Intrinsics.areEqual(this.toolCallName, r6.toolCallName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.args, r6.args) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.argsJson, r6.argsJson) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.result, r6.result) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resultJson, r6.resultJson) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.parentMessageId, r6.parentMessageId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.resultAreas, r6.resultAreas) == true) goto L33;
        return false;
    L33:
        if (this.onlyText == r6.onlyText) goto L36;
        return false;
    L36:
        if (this.onlyCapsule == r6.onlyCapsule) goto L39;
        return false;
    L39:
        if (this.onlyCode == r6.onlyCode) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r0 = this.toolCallName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.icon;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.args;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.argsJson;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.result;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.resultJson;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.parentMessageId;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        int r20 = (((r18 + r1) * 31) + this.resultAreas.hashCode()) * 31;
        int r21 = 1231;
        if (this.onlyText == false) goto L33;
        int r22 = 1231;
    L34:
        int r23 = (r20 + r22) * 31;
        if (this.onlyCapsule == false) goto L37;
        int r24 = 1231;
    L38:
        int r25 = (r23 + r24) * 31;
        if (this.onlyCode == true) goto L43;
        r21 = 1237;
    L43:
        return r25 + r21;
    L37:
        r24 = 1237;
        goto L38
    L33:
        r22 = 1237;
        goto L34
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
        return "ToolCallExtra(toolCallName=" + this.toolCallName + ", icon=" + this.icon + ", args=" + this.args + ", argsJson=" + this.argsJson + ", result=" + this.result + ", resultJson=" + this.resultJson + ", parentMessageId=" + this.parentMessageId + ", resultAreas=" + this.resultAreas + ", onlyText=" + this.onlyText + ", onlyCapsule=" + this.onlyCapsule + ", onlyCode=" + this.onlyCode + ')';
    }

    public final String getArgs() {
        return this.args;
    }

    public final String getArgsJson() {
        return this.argsJson;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final boolean getOnlyCapsule() {
        return this.onlyCapsule;
    }

    public final boolean getOnlyCode() {
        return this.onlyCode;
    }

    public final boolean getOnlyText() {
        return this.onlyText;
    }

    public final String getParentMessageId() {
        return this.parentMessageId;
    }

    public final String getResult() {
        return this.result;
    }

    public final ArrayList<ToolCallResultArea> getResultAreas() {
        return this.resultAreas;
    }

    public final String getResultJson() {
        return this.resultJson;
    }

    public final String getToolCallName() {
        return this.toolCallName;
    }

    public final void setOnlyCapsule(boolean r1) {
        this.onlyCapsule = r1;
    }

    public final void setOnlyCode(boolean r1) {
        this.onlyCode = r1;
    }

    public final void setOnlyText(boolean r1) {
        this.onlyText = r1;
    }

    public ToolCallExtra(String r2, String r3, String r4, String r5, String r6, String r7, String r8, ArrayList<ToolCallResultArea> r9, boolean r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "resultAreas");
        this.toolCallName = r2;
        this.icon = r3;
        this.args = r4;
        this.argsJson = r5;
        this.result = r6;
        this.resultJson = r7;
        this.parentMessageId = r8;
        this.resultAreas = r9;
        this.onlyText = r10;
        this.onlyCapsule = r11;
        this.onlyCode = r12;
    }

    public /* synthetic */ ToolCallExtra(String r15, String r16, String r17, String r18, String r19, String r20, String r21, ArrayList r22, boolean r23, boolean r24, boolean r25, int r26, DefaultConstructorMarker r27) {
        if ((r26 & 128) == 0) goto L5;
        ArrayList r10 = new ArrayList();
    L7:
        if ((r26 & 256) == 0) goto L9;
        boolean r11 = true;
    L11:
        if ((r26 & 512) == 0) goto L13;
        boolean r12 = false;
    L15:
        if ((r26 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L17;
        boolean r13 = false;
    L18:
        this(r15, r16, r17, r18, r19, r20, r21, r10, r11, r12, r13);
        return;
    L17:
        r13 = r25;
        goto L18
    L13:
        r12 = r24;
        goto L15
    L9:
        r11 = r23;
        goto L11
    L5:
        r10 = r22;
        goto L7
    }
}
