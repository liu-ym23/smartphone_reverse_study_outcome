package com.larus.platform.model.action;

import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003Js\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/larus/platform/model/action/DirectSendData;", "", "displayName", "", "enterMethod", "msgExtMap", "", "sceneForText", "eventExtra", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "needPrepareNestedFileMsg", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Lcom/larus/ui/arch/context/external/VContext;Z)V", "getDisplayName", "()Ljava/lang/String;", "getEnterMethod", "getMsgExtMap", "()Ljava/util/Map;", "getSceneForText", "getEventExtra", "getVContext", "()Lcom/larus/ui/arch/context/external/VContext;", "getNeedPrepareNestedFileMsg", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DirectSendData {
    private final String displayName;
    private final String enterMethod;
    private final Map<String, String> eventExtra;
    private final Map<String, String> msgExtMap;
    private final boolean needPrepareNestedFileMsg;
    private final String sceneForText;
    private final b vContext;

    public DirectSendData() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DirectSendData copy$default(DirectSendData r5, String r6, String r7, Map r8, String r9, Map r10, b r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.displayName;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.enterMethod;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.msgExtMap;
    L11:
        Map r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.sceneForText;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.eventExtra;
    L17:
        Map r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.vContext;
    L20:
        b r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.needPrepareNestedFileMsg;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.displayName;
    }

    public final String component2() {
        return this.enterMethod;
    }

    public final Map<String, String> component3() {
        return this.msgExtMap;
    }

    public final String component4() {
        return this.sceneForText;
    }

    public final Map<String, String> component5() {
        return this.eventExtra;
    }

    public final b component6() {
        return this.vContext;
    }

    public final boolean component7() {
        return this.needPrepareNestedFileMsg;
    }

    public final DirectSendData copy(String r10, String r11, Map<String, String> r12, String r13, Map<String, String> r14, b r15, boolean r16) {
        return new DirectSendData(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DirectSendData) == true) goto L8;
        return false;
    L8:
        DirectSendData r6 = (DirectSendData) r5;
        if (Intrinsics.areEqual(this.displayName, r6.displayName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.msgExtMap, r6.msgExtMap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sceneForText, r6.sceneForText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.eventExtra, r6.eventExtra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.vContext, r6.vContext) == true) goto L27;
        return false;
    L27:
        if (this.needPrepareNestedFileMsg == r6.needPrepareNestedFileMsg) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.displayName;
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
        Map<String, String> r7 = this.msgExtMap;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.sceneForText;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.eventExtra;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        b r16 = this.vContext;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        int r17 = (r15 + r1) * 31;
        if (this.needPrepareNestedFileMsg == false) goto L29;
        int r18 = 1231;
    L31:
        return r17 + r18;
    L29:
        r18 = 1237;
        goto L31
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
        return "DirectSendData(displayName=" + this.displayName + ", enterMethod=" + this.enterMethod + ", msgExtMap=" + this.msgExtMap + ", sceneForText=" + this.sceneForText + ", eventExtra=" + this.eventExtra + ", vContext=" + this.vContext + ", needPrepareNestedFileMsg=" + this.needPrepareNestedFileMsg + ')';
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Map<String, String> getEventExtra() {
        return this.eventExtra;
    }

    public final Map<String, String> getMsgExtMap() {
        return this.msgExtMap;
    }

    public final boolean getNeedPrepareNestedFileMsg() {
        return this.needPrepareNestedFileMsg;
    }

    public final String getSceneForText() {
        return this.sceneForText;
    }

    public final b getVContext() {
        return this.vContext;
    }

    public DirectSendData(String r1, String r2, Map<String, String> r3, String r4, Map<String, String> r5, b r6, boolean r7) {
        this.displayName = r1;
        this.enterMethod = r2;
        this.msgExtMap = r3;
        this.sceneForText = r4;
        this.eventExtra = r5;
        this.vContext = r6;
        this.needPrepareNestedFileMsg = r7;
    }

    public /* synthetic */ DirectSendData(String r6, String r7, Map r8, String r9, Map r10, b r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        b r0 = null;
        if ((r13 & 1) == 0) goto L5;
        String r15 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        Map r2 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r13 & 16) == 0) goto L21;
        Map r4 = null;
    L23:
        if ((r13 & 32) != 0) goto L27;
        r0 = r11;
    L27:
        if ((r13 & 64) == 0) goto L29;
        boolean r16 = true;
    L30:
        this(r15, r1, r2, r3, r4, r0, r16);
        return;
    L29:
        r16 = r12;
        goto L30
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r15 = r6;
        goto L7
    }
}
