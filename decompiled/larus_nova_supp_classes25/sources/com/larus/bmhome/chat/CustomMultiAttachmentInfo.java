package com.larus.bmhome.chat;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.NestedFileContent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "Ljava/io/Serializable;", "fromScene", "", "enterMethod", "nestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "isSkipUpload", "", "preHandleV2Check", "onlyRegisterCheck", "overrideSinceId", "localMsgId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/NestedFileContent;ZZZZLjava/lang/String;)V", "getFromScene", "()Ljava/lang/String;", "getEnterMethod", "getNestedFileContent", "()Lcom/larus/im/bean/message/NestedFileContent;", "()Z", "getPreHandleV2Check", "getOnlyRegisterCheck", "getOverrideSinceId", "getLocalMsgId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CustomMultiAttachmentInfo implements Serializable {
    private final String enterMethod;
    private final String fromScene;
    private final boolean isSkipUpload;
    private final String localMsgId;
    private final NestedFileContent nestedFileContent;
    private final boolean onlyRegisterCheck;
    private final boolean overrideSinceId;
    private final boolean preHandleV2Check;

    public static /* synthetic */ CustomMultiAttachmentInfo copy$default(CustomMultiAttachmentInfo r9, String r10, String r11, NestedFileContent r12, boolean r13, boolean r14, boolean r15, boolean r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.fromScene;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.enterMethod;
    L11:
        if ((r18 & 4) == 0) goto L13;
        NestedFileContent r4 = r9.nestedFileContent;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.isSkipUpload;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.preHandleV2Check;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = r9.onlyRegisterCheck;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.overrideSinceId;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.localMsgId;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.fromScene;
    }

    public final String component2() {
        return this.enterMethod;
    }

    public final NestedFileContent component3() {
        return this.nestedFileContent;
    }

    public final boolean component4() {
        return this.isSkipUpload;
    }

    public final boolean component5() {
        return this.preHandleV2Check;
    }

    public final boolean component6() {
        return this.onlyRegisterCheck;
    }

    public final boolean component7() {
        return this.overrideSinceId;
    }

    public final String component8() {
        return this.localMsgId;
    }

    public final CustomMultiAttachmentInfo copy(String r11, String r12, NestedFileContent r13, boolean r14, boolean r15, boolean r16, boolean r17, String r18) {
        return new CustomMultiAttachmentInfo(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CustomMultiAttachmentInfo) == true) goto L8;
        return false;
    L8:
        CustomMultiAttachmentInfo r6 = (CustomMultiAttachmentInfo) r5;
        if (Intrinsics.areEqual(this.fromScene, r6.fromScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nestedFileContent, r6.nestedFileContent) == true) goto L18;
        return false;
    L18:
        if (this.isSkipUpload == r6.isSkipUpload) goto L21;
        return false;
    L21:
        if (this.preHandleV2Check == r6.preHandleV2Check) goto L24;
        return false;
    L24:
        if (this.onlyRegisterCheck == r6.onlyRegisterCheck) goto L27;
        return false;
    L27:
        if (this.overrideSinceId == r6.overrideSinceId) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.localMsgId, r6.localMsgId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.fromScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.enterMethod;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        NestedFileContent r7 = this.nestedFileContent;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        int r10 = 1231;
        if (this.isSkipUpload == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.preHandleV2Check == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        if (this.onlyRegisterCheck == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.overrideSinceId == true) goto L30;
        r10 = 1237;
    L30:
        int r17 = (r16 + r10) * 31;
        String r18 = this.localMsgId;
        if (r18 == null) goto L35;
        r1 = r18.hashCode();
    L35:
        return r17 + r1;
    L25:
        r15 = 1237;
        goto L26
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = 1237;
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
        return "CustomMultiAttachmentInfo(fromScene=" + this.fromScene + ", enterMethod=" + this.enterMethod + ", nestedFileContent=" + this.nestedFileContent + ", isSkipUpload=" + this.isSkipUpload + ", preHandleV2Check=" + this.preHandleV2Check + ", onlyRegisterCheck=" + this.onlyRegisterCheck + ", overrideSinceId=" + this.overrideSinceId + ", localMsgId=" + this.localMsgId + ')';
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    public final NestedFileContent getNestedFileContent() {
        return this.nestedFileContent;
    }

    public final boolean getOnlyRegisterCheck() {
        return this.onlyRegisterCheck;
    }

    public final boolean getOverrideSinceId() {
        return this.overrideSinceId;
    }

    public final boolean getPreHandleV2Check() {
        return this.preHandleV2Check;
    }

    public final boolean isSkipUpload() {
        return this.isSkipUpload;
    }

    public CustomMultiAttachmentInfo(String r1, String r2, NestedFileContent r3, boolean r4, boolean r5, boolean r6, boolean r7, String r8) {
        this.fromScene = r1;
        this.enterMethod = r2;
        this.nestedFileContent = r3;
        this.isSkipUpload = r4;
        this.preHandleV2Check = r5;
        this.onlyRegisterCheck = r6;
        this.overrideSinceId = r7;
        this.localMsgId = r8;
    }

    public /* synthetic */ CustomMultiAttachmentInfo(String r13, String r14, NestedFileContent r15, boolean r16, boolean r17, boolean r18, boolean r19, String r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 8) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r21 & 16) == 0) goto L9;
        boolean r8 = false;
    L11:
        if ((r21 & 32) == 0) goto L13;
        boolean r9 = false;
    L15:
        if ((r21 & 64) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r21 & 128) == 0) goto L21;
        String r11 = null;
    L22:
        this(r13, r14, r15, r7, r8, r9, r10, r11);
        return;
    L21:
        r11 = r20;
        goto L22
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }
}
