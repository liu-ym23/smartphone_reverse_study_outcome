package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R$\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000f¨\u0006-"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "Landroid/os/Parcelable;", "isEnable", "", ObricMemoryConstants.KEY_SESSION_ID, "", Params.CONTENT, "clarifyCount", "", "learningSwitch", "evolutionInfo", "(ZLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V", "getClarifyCount", "()I", "getContent", "()Ljava/lang/String;", "getEvolutionInfo$annotations", "()V", "getEvolutionInfo", "setEvolutionInfo", "(Ljava/lang/String;)V", "()Z", "getLearningSwitch$annotations", "getLearningSwitch", "setLearningSwitch", "(Z)V", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskKnowledge implements Parcelable {
    public static final Parcelable.Creator<TaskKnowledge> CREATOR = null;
    private final int clarifyCount;
    private final String content;
    public String evolutionInfo;
    private final boolean isEnable;
    public boolean learningSwitch;
    private final String sessionId;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<TaskKnowledge> {
        public a() {
        }

        public final TaskKnowledge a(Parcel r12) {
            int r11 = r12.readInt();
            Intrinsics.checkNotNullParameter(r12, "parcel");
            if (r12.readInt() == 0) goto L5;
            boolean r2 = true;
        L6:
            TaskKnowledge r0 = new TaskKnowledge(r2, r12.readString(), r12.readString(), r12.readInt(), false, null, 48, null);
            int r3 = Math.min(r11, 2);
            ClassLoader r4 = a.class.getClassLoader();
            int r5 = 1;
        L7:
            if (r5 > r3) goto L18;
            if (r5 != 1) goto L13;
            Object r6 = com.obric.b.a.b(r12, r4);
            if (r6 == null) goto L17;
            r0.learningSwitch = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        L17:
            r5 = r5 + 1;
            goto L7
        L13:
            if (r5 != 2) goto L17;
            Object r7 = com.obric.b.a.b(r12, r4);
            if (r7 == null) goto L17;
            r0.evolutionInfo = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        L18:
            if (r5 > r11) goto L20;
            com.obric.b.a.a(r12, r4);
            r5 = r5 + 1;
            goto L18
        L20:
            return r0;
        L5:
            r2 = false;
            goto L6
        }

        public final TaskKnowledge[] a(int r1) {
            return new TaskKnowledge[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TaskKnowledge createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TaskKnowledge[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskKnowledge(boolean r1, String r2, String r3, int r4, boolean r5, String r6) {
        this.isEnable = r1;
        this.sessionId = r2;
        this.content = r3;
        this.clarifyCount = r4;
        this.learningSwitch = r5;
        this.evolutionInfo = r6;
    }

    public /* synthetic */ TaskKnowledge(boolean r8, String r9, String r10, int r11, boolean r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = 0;
    L5:
        int r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = true;
    L8:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L11;
        r13 = null;
    L11:
        this(r8, r9, r10, r4, r5, r13);
    }

    public static /* synthetic */ TaskKnowledge copy$default(TaskKnowledge r4, boolean r5, String r6, String r7, int r8, boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.isEnable;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.sessionId;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.content;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.clarifyCount;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.learningSwitch;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.evolutionInfo;
    L20:
        boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public static /* synthetic */ void getEvolutionInfo$annotations() {
    }

    public static /* synthetic */ void getLearningSwitch$annotations() {
    }

    public final boolean component1() {
        return this.isEnable;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.content;
    }

    public final int component4() {
        return this.clarifyCount;
    }

    public final boolean component5() {
        return this.learningSwitch;
    }

    public final String component6() {
        return this.evolutionInfo;
    }

    public final TaskKnowledge copy(boolean r8, String r9, String r10, int r11, boolean r12, String r13) {
        return new TaskKnowledge(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TaskKnowledge.class) == true) goto L8;
        return false;
    L8:
        TaskKnowledge r6 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(r5, TaskKnowledge.class, "com.obric.memorydata.plugin");
        if (this.isEnable == r6.isEnable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r6.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (this.clarifyCount == r6.clarifyCount) goto L21;
        return false;
    L21:
        if (this.learningSwitch == r6.learningSwitch) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.evolutionInfo, r6.evolutionInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getClarifyCount() {
        return this.clarifyCount;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getEvolutionInfo() {
        return this.evolutionInfo;
    }

    public final boolean getLearningSwitch() {
        return this.learningSwitch;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r0 = this.isEnable;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        String r4 = this.sessionId;
        int r5 = 0;
        if (r4 != null) goto L8;
        int r6 = 0;
    L9:
        int r7 = (r3 + r6) * 31;
        String r8 = this.content;
        if (r8 != null) goto L12;
        int r9 = 0;
    L13:
        int r10 = (((r7 + r9) * 31) + Integer.hashCode(this.clarifyCount)) * 31;
        boolean r11 = this.learningSwitch;
        if (r11 == true) goto L17;
        r1 = r11;
    L17:
        int r12 = (r10 + r1) * 31;
        String r13 = this.evolutionInfo;
        if (r13 == null) goto L22;
        r5 = r13.hashCode();
    L22:
        return r12 + r5;
    L12:
        r9 = r8.hashCode();
        goto L13
    L8:
        r6 = r4.hashCode();
        goto L9
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final void setEvolutionInfo(String r1) {
        this.evolutionInfo = r1;
    }

    public final void setLearningSwitch(boolean r1) {
        this.learningSwitch = r1;
    }

    public String toString() {
        return "TaskKnowledge(isEnable=" + this.isEnable + ", sessionId=" + this.sessionId + ", content=" + this.content + ", clarifyCount=" + this.clarifyCount + ", learningSwitch=" + this.learningSwitch + ", evolutionInfo=" + this.evolutionInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeInt(this.isEnable ? 1 : 0);
        r1.writeString(this.sessionId);
        r1.writeString(this.content);
        r1.writeInt(this.clarifyCount);
        r1.writeValue(Boolean.valueOf(this.learningSwitch));
        r1.writeValue(this.evolutionInfo);
    }
}
