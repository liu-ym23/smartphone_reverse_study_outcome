package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0001:Bg\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013¢\u0006\u0004\b6\u00107B\u0011\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b6\u00108J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0010HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0010HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013HÆ\u0003Jm\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013HÆ\u0001J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\"\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b)\u0010(R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b*\u0010(R\u0017\u0010\u0019\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u001a\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b\u001a\u0010/R\u0017\u0010\u001b\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b0\u0010/R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "component1", "", "component2", "component3", "component4", "", "component5", "", "component6", "component7", "", "component8", "requestType", "content", "refMessageId", "taskType", "timeOut", "isInIsland", "startWithAsr", "ext", "copy", "toString", "hashCode", "", "other", "equals", "I", "getRequestType", "()I", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "getRefMessageId", "getTaskType", "J", "getTimeOut", "()J", "Z", "()Z", "getStartWithAsr", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZLjava/util/Map;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
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

    static {
        CREATOR = new a();
    }

    public StateInfo(int r1, String r2, String r3, String r4, long r5, boolean r7, boolean r8, Map<String, String> r9) {
        this.requestType = r1;
        this.content = r2;
        this.refMessageId = r3;
        this.taskType = r4;
        this.timeOut = r5;
        this.isInIsland = r7;
        this.startWithAsr = r8;
        this.ext = r9;
    }

    public /* synthetic */ StateInfo(int r14, String r15, String r16, String r17, long r18, boolean r20, boolean r21, Map r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r23 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r23 & 16) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r23 & 32) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r23 & 64) == 0) goto L21;
        boolean r11 = false;
    L23:
        if ((r23 & 128) == 0) goto L25;
        Map r12 = null;
    L26:
        this(r14, r5, r16, r7, r8, r10, r11, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public StateInfo(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        this(r14.readInt(), r14.readString(), r14.readString(), r14.readString(), r14.readLong(), r14.readBoolean(), r14.readBoolean(), null, 128, null);
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r0 = new LinkedHashMap();
        r14.readMap(r0, StateInfo.class.getClassLoader(), String.class, String.class);
        if ((!r0.isEmpty()) == false) goto L16;
    L6:
        this.ext = r0;
        return;
    L16:
        return;
    L7:
        Bundle r15 = r14.readBundle(StateInfo.class.getClassLoader());
        if (r15 == null) goto L21;
        r0 = new LinkedHashMap();
        Iterator<T> r1 = r15.keySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L6;
        String r2 = (String) r1.next();
        String r3 = r15.getString(r2);
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r0.put(r2, r3);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StateInfo copy$default(StateInfo r10, int r11, String r12, String r13, String r14, long r15, boolean r17, boolean r18, Map r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.requestType;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.content;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.refMessageId;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.taskType;
    L19:
        if ((r20 & 16) == 0) goto L21;
        long r6 = r10.timeOut;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r8 = r10.isInIsland;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r9 = r10.startWithAsr;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Map r1 = r10.ext;
    L35:
        return r10.copy(r2, r3, r4, r5, r6, r8, r9, r1);
    L33:
        r1 = r19;
        goto L35
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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
        return new StateInfo(r12, r13, r14, r15, r16, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof StateInfo) == true) goto L8;
        return false;
    L8:
        StateInfo r9 = (StateInfo) r8;
        if (this.requestType == r9.requestType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r9.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refMessageId, r9.refMessageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskType, r9.taskType) == true) goto L21;
        return false;
    L21:
        if (this.timeOut == r9.timeOut) goto L24;
        return false;
    L24:
        if (this.isInIsland == r9.isInIsland) goto L27;
        return false;
    L27:
        if (this.startWithAsr == r9.startWithAsr) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r9.ext) == true) goto L32;
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
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = this.requestType * 31;
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
        long r10 = this.timeOut;
        int r11 = (((r7 + r9) * 31) + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        boolean r12 = this.isInIsland;
        ?? r13 = 1;
        ?? r14 = r12;
        if (r12 == false) goto L17;
        r14 = 1;
    L17:
        int r15 = (r11 + r14) * 31;
        boolean r16 = this.startWithAsr;
        if (r16 == true) goto L21;
        r13 = r16;
    L21:
        int r17 = (r15 + r13) * 31;
        Map<String, String> r18 = this.ext;
        if (r18 == null) goto L26;
        r2 = r18.hashCode();
    L26:
        return r17 + r2;
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

    public final void setExt(Map<String, String> r1) {
        this.ext = r1;
    }

    public String toString() {
        return "StateInfo(requestType=" + this.requestType + ", content=" + this.content + ", refMessageId=" + this.refMessageId + ", taskType=" + this.taskType + ", timeOut=" + this.timeOut + ", isInIsland=" + this.isInIsland + ", startWithAsr=" + this.startWithAsr + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeInt(this.requestType);
        r4.writeString(this.content);
        r4.writeString(this.refMessageId);
        r4.writeString(this.taskType);
        r4.writeLong(this.timeOut);
        r4.writeBoolean(this.isInIsland);
        r4.writeBoolean(this.startWithAsr);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r4.writeMap(this.ext);
        return;
    L5:
        Bundle r6 = new Bundle();
        Map<String, String> r0 = this.ext;
        if (r0 == null) goto L11;
        Iterator<Map.Entry<String, String>> r1 = r0.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        Map.Entry<String, String> r2 = r1.next();
        r6.putString(r2.getKey(), r2.getValue());
    L11:
        r4.writeBundle(r6);
    }
}
