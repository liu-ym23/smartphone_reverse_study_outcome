package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rHÆ\u0003Jo\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rHÆ\u0001J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u00060"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;", "Landroid/os/Parcelable;", "id", "", "sessionId", "", "execTime", "packageName", "appName", "detailText", "detailType", "", "ext", "", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "getAppName", "()Ljava/lang/String;", "getDetailText", "getDetailType", "()I", "getExecTime", "()J", "getExt", "()Ljava/util/Map;", "getId", "getPackageName", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EventTaskExecutionDetailRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskExecutionDetailRecord> CREATOR = null;
    private final String appName;
    private final String detailText;
    private final int detailType;
    private final long execTime;
    private final Map<String, String> ext;
    private final long id;
    private final String packageName;
    private final String sessionId;

    static {
        CREATOR = new a();
    }

    public EventTaskExecutionDetailRecord(long r1, String r3, long r4, String r6, String r7, String r8, int r9, Map<String, String> r10) {
        this.id = r1;
        this.sessionId = r3;
        this.execTime = r4;
        this.packageName = r6;
        this.appName = r7;
        this.detailText = r8;
        this.detailType = r9;
        this.ext = r10;
    }

    public /* synthetic */ EventTaskExecutionDetailRecord(long r14, String r16, long r17, String r19, String r20, String r21, int r22, Map r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 1) == 0) goto L5;
        long r3 = 0;
    L6:
        this(r3, r16, r17, r19, r20, r21, r22, r23);
        return;
    L5:
        r3 = r14;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTaskExecutionDetailRecord copy$default(EventTaskExecutionDetailRecord r11, long r12, String r14, long r15, String r17, String r18, String r19, int r20, Map r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r2 = r11.id;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r4 = r11.sessionId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r5 = r11.execTime;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r7 = r11.packageName;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r8 = r11.appName;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r9 = r11.detailText;
    L27:
        if ((r22 & 64) == 0) goto L29;
        int r10 = r11.detailType;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Map r1 = r11.ext;
    L35:
        return r11.copy(r2, r4, r5, r7, r8, r9, r10, r1);
    L33:
        r1 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final long component3() {
        return this.execTime;
    }

    public final String component4() {
        return this.packageName;
    }

    public final String component5() {
        return this.appName;
    }

    public final String component6() {
        return this.detailText;
    }

    public final int component7() {
        return this.detailType;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final EventTaskExecutionDetailRecord copy(long r13, String r15, long r16, String r18, String r19, String r20, int r21, Map<String, String> r22) {
        return new EventTaskExecutionDetailRecord(r13, r15, r16, r18, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof EventTaskExecutionDetailRecord) == true) goto L8;
        return false;
    L8:
        EventTaskExecutionDetailRecord r9 = (EventTaskExecutionDetailRecord) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r9.sessionId) == true) goto L15;
        return false;
    L15:
        if (this.execTime == r9.execTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.packageName, r9.packageName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.appName, r9.appName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.detailText, r9.detailText) == true) goto L27;
        return false;
    L27:
        if (this.detailType == r9.detailType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r9.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getDetailText() {
        return this.detailText;
    }

    public final int getDetailType() {
        return this.detailType;
    }

    public final long getExecTime() {
        return this.execTime;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final long getId() {
        return this.id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.sessionId;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        long r5 = this.execTime;
        int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.packageName;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.appName;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (r9 + r11) * 31;
        String r13 = this.detailText;
        if (r13 != null) goto L17;
        int r14 = 0;
    L18:
        int r15 = (((r12 + r14) * 31) + this.detailType) * 31;
        Map<String, String> r16 = this.ext;
        if (r16 == null) goto L23;
        r3 = r16.hashCode();
    L23:
        return r15 + r3;
    L17:
        r14 = r13.hashCode();
        goto L18
    L13:
        r11 = r10.hashCode();
        goto L14
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskExecutionDetailRecord(id=" + this.id + ", sessionId=" + this.sessionId + ", execTime=" + this.execTime + ", packageName=" + this.packageName + ", appName=" + this.appName + ", detailText=" + this.detailText + ", detailType=" + this.detailType + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeLong(this.id);
        r3.writeString(this.sessionId);
        r3.writeLong(this.execTime);
        r3.writeString(this.packageName);
        r3.writeString(this.appName);
        r3.writeString(this.detailText);
        r3.writeInt(this.detailType);
        Map<String, String> r0 = this.ext;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.size());
        Iterator<Map.Entry<String, String>> r5 = r0.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Map.Entry<String, String> r1 = r5.next();
        r3.writeString(r1.getKey());
        r3.writeString(r1.getValue());
        goto L7
    }
}
