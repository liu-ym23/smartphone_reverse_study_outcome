package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 32\u00020\u0001:\u00013B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Be\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011HÆ\u0001J\b\u0010*\u001a\u00020\u0006H\u0016J\u0013\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\t\u0010/\u001a\u00020\bHÖ\u0001J\u0018\u00100\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0006H\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00064"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "requestType", "", Params.CONTENT, "", "refMessageId", "taskType", "timeOut", "", "isInIsland", "", "startWithAsr", "ext", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZLjava/util/Map;)V", "getContent", "()Ljava/lang/String;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "()Z", "getRefMessageId", "getRequestType", "()I", "getStartWithAsr", "getTaskType", "getTimeOut", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StateInfo implements Parcelable {
    public static final a CREATOR = null;
    private final String content;
    private Map<String, String> ext;
    private final boolean isInIsland;
    private final String refMessageId;
    private final int requestType;
    private final boolean startWithAsr;
    private final String taskType;
    private final long timeOut;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/StateInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<StateInfo> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public StateInfo a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new StateInfo(r1);
        }

        public StateInfo[] a(int r1) {
            return new StateInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ StateInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ StateInfo[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public StateInfo(int r3, String r4, String r5, String r6, long r7, boolean r9, boolean r10, Map<String, String> r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        this.requestType = r3;
        this.content = r4;
        this.refMessageId = r5;
        this.taskType = r6;
        this.timeOut = r7;
        this.isInIsland = r9;
        this.startWithAsr = r10;
        this.ext = r12;
    }

    public /* synthetic */ StateInfo(int r15, String r16, String r17, String r18, long r19, boolean r21, boolean r22, Map r23, int r24, DefaultConstructorMarker r25) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        if ((r24 & 2) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r24 & 8) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r24 & 16) == 0) goto L13;
        long r9 = 0;
    L15:
        if ((r24 & 32) == 0) goto L17;
        boolean r11 = false;
    L19:
        if ((r24 & 64) == 0) goto L21;
        boolean r12 = false;
    L23:
        if ((r24 & 128) == 0) goto L25;
        Map r13 = null;
    L26:
        this(r15, r6, r17, r8, r9, r11, r12, r13);
        return;
    L25:
        r13 = r1;
        goto L26
    L21:
        r12 = r22;
        goto L23
    L17:
        r11 = r21;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public StateInfo(Parcel r15) {
        Intrinsics.checkNotNullParameter(r15, "parcel");
        this(r15.readInt(), r15.readString(), r15.readString(), r15.readString(), r15.readLong(), r15.readBoolean(), r15.readBoolean(), null, 128, null);
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r1 = new LinkedHashMap();
        r15.readMap(r1, StateInfo.class.getClassLoader(), String.class, String.class);
        if ((!r1.isEmpty()) == false) goto L21;
        this.ext = r1;
        return;
    L21:
        return;
    L7:
        Bundle r16 = r15.readBundle(StateInfo.class.getClassLoader());
        if (r16 == null) goto L23;
        LinkedHashMap r0 = new LinkedHashMap();
        Set<String> r2 = r16.keySet();
        Intrinsics.checkNotNullExpressionValue(r2, "it.keySet()");
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        String r5 = r16.getString(r4);
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        Intrinsics.checkNotNullExpressionValue(r5, "it.getString(key) ?: \"\"");
        r0.put(r4, r5);
        goto L11
    L16:
        this.ext = r0;
        return;
    }

    public static /* synthetic */ StateInfo copy$default(StateInfo r11, int r12, String r13, String r14, String r15, long r16, boolean r18, boolean r19, Map r20, int r21, Object r22) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        if ((r21 & 1) == 0) goto L5;
        int r3 = r11.requestType;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r4 = r11.content;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r5 = r11.refMessageId;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r6 = r11.taskType;
    L19:
        if ((r21 & 16) == 0) goto L21;
        long r7 = r11.timeOut;
    L23:
        if ((r21 & 32) == 0) goto L25;
        boolean r9 = r11.isInIsland;
    L27:
        if ((r21 & 64) == 0) goto L29;
        boolean r10 = r11.startWithAsr;
    L31:
        if ((r21 & 128) == 0) goto L33;
        Map<String, String> r1 = r11.ext;
    L35:
        return r11.copy(r3, r4, r5, r6, r7, r9, r10, r1);
    L33:
        r1 = r2;
        goto L35
    L29:
        r10 = r19;
        goto L31
    L25:
        r9 = r18;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public final int component1() {
        return this.requestType;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.refMessageId;
    }

    public final String component4() {
        return this.taskType;
    }

    public final long component5() {
        return this.timeOut;
    }

    public final boolean component6() {
        return this.isInIsland;
    }

    public final boolean component7() {
        return this.startWithAsr;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final StateInfo copy(int r12, String r13, String r14, String r15, long r16, boolean r18, boolean r19, Map<String, String> r20) {
        return new StateInfo(r12, r13, r14, r15, r16, r18, r19, (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, StateInfo.class) == true) goto L8;
        return false;
    L8:
        StateInfo r10 = (StateInfo) ZeusTransformUtils.preCheckCast(r9, StateInfo.class, "com.obric.memorydata.plugin");
        if (this.requestType == r10.requestType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refMessageId, r10.refMessageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskType, r10.taskType) == true) goto L21;
        return false;
    L21:
        if (this.timeOut == r10.timeOut) goto L24;
        return false;
    L24:
        if (this.isInIsland == r10.isInIsland) goto L27;
        return false;
    L27:
        if (this.startWithAsr == r10.startWithAsr) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r10.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getRefMessageId() {
        return this.refMessageId;
    }

    public final int getRequestType() {
        return this.requestType;
    }

    public final boolean getStartWithAsr() {
        return this.startWithAsr;
    }

    public final String getTaskType() {
        return this.taskType;
    }

    public final long getTimeOut() {
        return this.timeOut;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.requestType) * 31;
        String r1 = this.content;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.refMessageId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.taskType;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + Long.hashCode(this.timeOut)) * 31;
        boolean r11 = this.isInIsland;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L17;
        r13 = 1;
    L17:
        int r14 = (r10 + r13) * 31;
        boolean r15 = this.startWithAsr;
        if (r15 == true) goto L21;
        r12 = r15;
    L21:
        int r16 = (r14 + r12) * 31;
        Map<String, String> r17 = this.ext;
        if (r17 == null) goto L26;
        r2 = r17.hashCode();
    L26:
        return r16 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final boolean isInIsland() {
        return this.isInIsland;
    }

    public final void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return "StateInfo(requestType=" + this.requestType + ", content=" + this.content + ", refMessageId=" + this.refMessageId + ", taskType=" + this.taskType + ", timeOut=" + this.timeOut + ", isInIsland=" + this.isInIsland + ", startWithAsr=" + this.startWithAsr + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeInt(this.requestType);
        r5.writeString(this.content);
        r5.writeString(this.refMessageId);
        r5.writeString(this.taskType);
        r5.writeLong(this.timeOut);
        r5.writeBoolean(this.isInIsland);
        r5.writeBoolean(this.startWithAsr);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r5.writeMap(this.ext);
        return;
    L5:
        Bundle r7 = new Bundle();
        Map<String, String> r4 = this.ext;
        if (r4 == null) goto L11;
        Iterator<Map.Entry<String, String>> r8 = r4.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r7.putString((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin"));
    L11:
        r5.writeBundle(r7);
    }
}
