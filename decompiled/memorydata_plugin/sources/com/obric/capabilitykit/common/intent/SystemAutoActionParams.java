package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJn\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u000205HÖ\u0001J\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\n\u00109\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010:\u001a\u000205HÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000108H\u0016J\t\u0010=\u001a\u00020\u0004HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000205HÖ\u0001R&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R(\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemAutoActionParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "instruction", "", "taskId", "taskScenario", "sourceFrom", "assistantHistory", "executionMode", "meta", "requestAuth", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAssistantHistory$annotations", "()V", "getAssistantHistory", "()Ljava/lang/String;", "setAssistantHistory", "(Ljava/lang/String;)V", "getExecutionMode$annotations", "getExecutionMode", "setExecutionMode", "getInstruction", "setInstruction", "getMeta$annotations", "getMeta", "setMeta", "getRequestAuth$annotations", "getRequestAuth", "()Ljava/lang/Boolean;", "setRequestAuth", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSourceFrom$annotations", "getSourceFrom", "setSourceFrom", "getTaskId", "setTaskId", "getTaskScenario$annotations", "getTaskScenario", "setTaskScenario", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/SystemAutoActionParams;", "describeContents", "", "equals", "other", "", "getSubActionValue", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemAutoActionParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemAutoActionParams> CREATOR = null;
    String assistantHistory;
    String executionMode;
    private String instruction;
    String meta;
    Boolean requestAuth;
    String sourceFrom;
    private String taskId;
    String taskScenario;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemAutoActionParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemAutoActionParams createFromParcel(Parcel r14) {
            int r0 = r14.readInt();
            Intrinsics.checkNotNullParameter(r14, "parcel");
            SystemAutoActionParams r1 = new SystemAutoActionParams(r14.readString(), r14.readString(), null, null, null, null, null, null, 252, null);
            int r3 = Math.min(r0, 6);
            ClassLoader r13 = getClass().getClassLoader();
            int r5 = 1;
        L3:
            if (r5 > r3) goto L34;
            if (r5 != 1) goto L10;
            Object r7 = a.b(r14, r13);
            if (r7 == null) goto L33;
            r1.taskScenario = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        L33:
            r5 = r5 + 1;
            goto L3
        L10:
            if (r5 != 2) goto L15;
            Object r8 = a.b(r14, r13);
            if (r8 == null) goto L33;
            r1.sourceFrom = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
            goto L33
        L15:
            if (r5 != 3) goto L20;
            Object r9 = a.b(r14, r13);
            if (r9 == null) goto L33;
            r1.assistantHistory = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");
            goto L33
        L20:
            if (r5 != 4) goto L25;
            Object r10 = a.b(r14, r13);
            if (r10 == null) goto L33;
            r1.executionMode = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
            goto L33
        L25:
            if (r5 != 5) goto L29;
            Object r11 = a.b(r14, r13);
            if (r11 == null) goto L33;
            r1.meta = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
            goto L33
        L29:
            if (r5 != 6) goto L33;
            Object r12 = a.b(r14, r13);
            if (r12 == null) goto L33;
            r1.requestAuth = (Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin");
        L34:
            if (r5 > r0) goto L36;
            a.a(r14, r13);
            r5 = r5 + 1;
            goto L34
        L36:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemAutoActionParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemAutoActionParams[] newArray(int r1) {
            return new SystemAutoActionParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemAutoActionParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public SystemAutoActionParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public SystemAutoActionParams(String r1, String r2, String r3, String r4, String r5, String r6, String r7, Boolean r8) {
        this.instruction = r1;
        this.taskId = r2;
        this.taskScenario = r3;
        this.sourceFrom = r4;
        this.assistantHistory = r5;
        this.executionMode = r6;
        this.meta = r7;
        this.requestAuth = r8;
    }

    public /* synthetic */ SystemAutoActionParams(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Boolean r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = null;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ SystemAutoActionParams copy$default(SystemAutoActionParams r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, Boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.instruction;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.taskId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.taskScenario;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.sourceFrom;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.assistantHistory;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.executionMode;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.meta;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Boolean r1 = r9.requestAuth;
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

    public static /* synthetic */ void getAssistantHistory$annotations() {
    }

    public static /* synthetic */ void getExecutionMode$annotations() {
    }

    public static /* synthetic */ void getMeta$annotations() {
    }

    public static /* synthetic */ void getRequestAuth$annotations() {
    }

    public static /* synthetic */ void getSourceFrom$annotations() {
    }

    public static /* synthetic */ void getTaskScenario$annotations() {
    }

    public final String component1() {
        return this.instruction;
    }

    public final String component2() {
        return this.taskId;
    }

    public final String component3() {
        return this.taskScenario;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final String component5() {
        return this.assistantHistory;
    }

    public final String component6() {
        return this.executionMode;
    }

    public final String component7() {
        return this.meta;
    }

    public final Boolean component8() {
        return this.requestAuth;
    }

    public final SystemAutoActionParams copy(String r11, String r12, String r13, String r14, String r15, String r16, String r17, Boolean r18) {
        return new SystemAutoActionParams(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemAutoActionParams.class) == true) goto L8;
        return false;
    L8:
        SystemAutoActionParams r6 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r5, SystemAutoActionParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.instruction, r6.instruction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskScenario, r6.taskScenario) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceFrom, r6.sourceFrom) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.assistantHistory, r6.assistantHistory) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.executionMode, r6.executionMode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.meta, r6.meta) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.requestAuth, r6.requestAuth) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getAssistantHistory() {
        return this.assistantHistory;
    }

    public final String getExecutionMode() {
        return this.executionMode;
    }

    public final String getInstruction() {
        return this.instruction;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final Boolean getRequestAuth() {
        return this.requestAuth;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        Boolean r0 = this.requestAuth;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskScenario() {
        return this.taskScenario;
    }

    public int hashCode() {
        String r0 = this.instruction;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.taskId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.taskScenario;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.sourceFrom;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.assistantHistory;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.executionMode;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.meta;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.requestAuth;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r13) {
        if (ZeusTransformUtils.instanceOf(r13, SystemAutoActionParams.class) == false) goto L5;
        String r1 = this.instruction;
        if (r1 != null) goto L9;
        r1 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.memorydata.plugin")).instruction;
    L9:
        String r4 = r1;
        String r2 = this.taskId;
        if (r2 != null) goto L12;
        r2 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.memorydata.plugin")).taskId;
    L12:
        String r5 = r2;
        String r3 = this.taskScenario;
        if (r3 != null) goto L15;
        r3 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.memorydata.plugin")).taskScenario;
    L15:
        String r6 = r3;
        String r7 = this.sourceFrom;
        if (r7 != null) goto L18;
        r7 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.memorydata.plugin")).sourceFrom;
    L18:
        String r8 = r7;
        String r9 = this.assistantHistory;
        if (r9 != null) goto L21;
        r9 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.memorydata.plugin")).assistantHistory;
    L21:
        String r10 = r9;
        String r11 = this.executionMode;
        if (r11 != null) goto L24;
        r11 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.memorydata.plugin")).executionMode;
    L24:
        String r12 = r11;
        String r14 = this.meta;
        if (r14 != null) goto L27;
        r14 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.memorydata.plugin")).meta;
    L27:
        String r15 = r14;
        Boolean r16 = this.requestAuth;
        if (r16 != null) goto L30;
        r16 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.memorydata.plugin")).requestAuth;
    L30:
        SystemAutoActionParams this = new SystemAutoActionParams(r4, r5, r6, r8, r10, r12, r15, r16);
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    }

    public final void setAssistantHistory(String r1) {
        this.assistantHistory = r1;
    }

    public final void setExecutionMode(String r1) {
        this.executionMode = r1;
    }

    public final void setInstruction(String r1) {
        this.instruction = r1;
    }

    public final void setMeta(String r1) {
        this.meta = r1;
    }

    public final void setRequestAuth(Boolean r1) {
        this.requestAuth = r1;
    }

    public final void setSourceFrom(String r1) {
        this.sourceFrom = r1;
    }

    public final void setTaskId(String r1) {
        this.taskId = r1;
    }

    public final void setTaskScenario(String r1) {
        this.taskScenario = r1;
    }

    public String toString() {
        return "SystemAutoActionParams(instruction=" + this.instruction + ", taskId=" + this.taskId + ", taskScenario=" + this.taskScenario + ", sourceFrom=" + this.sourceFrom + ", assistantHistory=" + this.assistantHistory + ", executionMode=" + this.executionMode + ", meta=" + this.meta + ", requestAuth=" + this.requestAuth + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(6);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.instruction);
        r1.writeString(this.taskId);
        r1.writeValue(this.taskScenario);
        r1.writeValue(this.sourceFrom);
        r1.writeValue(this.assistantHistory);
        r1.writeValue(this.executionMode);
        r1.writeValue(this.meta);
        r1.writeValue(this.requestAuth);
    }
}
