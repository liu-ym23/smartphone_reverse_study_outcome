package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001aJn\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u000eHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00069"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEvent;", "Ljava/io/Serializable;", "eventName", "", "dumpedDumpedEventParams", "", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventKey;", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventParam;", "stackTrace", "timeStamp", "", "dumpedClassInfo", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;", "localIndex", "", "eventClassVersion", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;JLcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDumpedClassInfo", "()Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;", "setDumpedClassInfo", "(Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;)V", "getDumpedDumpedEventParams", "()Ljava/util/Map;", "setDumpedDumpedEventParams", "(Ljava/util/Map;)V", "getEventClassVersion", "()Ljava/lang/Integer;", "setEventClassVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "getLocalIndex", "setLocalIndex", "getStackTrace", "setStackTrace", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;JLcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEvent;", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DumpedEvent implements Serializable {

    @SerializedName("event_class_info")
    private DumpedClassInfo dumpedClassInfo;

    @SerializedName("event_params")
    private Map<DumpedEventKey, DumpedEventParam> dumpedDumpedEventParams;

    @SerializedName("event_class_version")
    private Integer eventClassVersion;

    @SerializedName("event_name")
    private String eventName;

    @SerializedName("local_index")
    private Integer localIndex;

    @SerializedName("stack_trace")
    private String stackTrace;

    @SerializedName("time_stamp")
    private long timeStamp;

    public DumpedEvent() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DumpedEvent copy$default(DumpedEvent r10, String r11, Map r12, String r13, long r14, DumpedClassInfo r15, Integer r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r10.eventName;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Map r20 = r10.dumpedDumpedEventParams;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r21 = r10.stackTrace;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r22 = r10.timeStamp;
    L19:
        if ((r18 & 16) == 0) goto L21;
        DumpedClassInfo r23 = r10.dumpedClassInfo;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r24 = r10.localIndex;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r25 = r10.eventClassVersion;
    L31:
        return r10.copy(r1, r20, r21, r22, r23, r24, r25);
    L29:
        r25 = r17;
        goto L31
    L25:
        r24 = r16;
        goto L27
    L21:
        r23 = r15;
        goto L23
    L17:
        r22 = r14;
        goto L19
    L13:
        r21 = r13;
        goto L15
    L9:
        r20 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final String component1() {
        return this.eventName;
    }

    public final Map<DumpedEventKey, DumpedEventParam> component2() {
        return this.dumpedDumpedEventParams;
    }

    public final String component3() {
        return this.stackTrace;
    }

    public final long component4() {
        return this.timeStamp;
    }

    public final DumpedClassInfo component5() {
        return this.dumpedClassInfo;
    }

    public final Integer component6() {
        return this.localIndex;
    }

    public final Integer component7() {
        return this.eventClassVersion;
    }

    public final DumpedEvent copy(String r11, Map<DumpedEventKey, DumpedEventParam> r12, String r13, long r14, DumpedClassInfo r16, Integer r17, Integer r18) {
        return new DumpedEvent(r11, r12, r13, r14, r16, r17, r18);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof DumpedEvent) == false) goto L20;
        DumpedEvent r11 = (DumpedEvent) r10;
        if (Intrinsics.areEqual(this.eventName, r11.eventName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dumpedDumpedEventParams, r11.dumpedDumpedEventParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.stackTrace, r11.stackTrace) == true) goto L12;
        return false;
    L12:
        if (this.timeStamp == r11.timeStamp) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.dumpedClassInfo, r11.dumpedClassInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.localIndex, r11.localIndex) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventClassVersion, r11.eventClassVersion) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.eventName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Map<DumpedEventKey, DumpedEventParam> r12 = this.dumpedDumpedEventParams;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.stackTrace;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        long r18 = this.timeStamp;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        DumpedClassInfo r20 = this.dumpedClassInfo;
        if (r20 == null) goto L17;
        int r21 = r20.hashCode();
    L18:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.localIndex;
        if (r23 == null) goto L21;
        int r24 = r23.hashCode();
    L22:
        int r25 = (r22 + r24) * 31;
        Integer r26 = this.eventClassVersion;
        if (r26 == null) goto L26;
        r1 = r26.hashCode();
    L26:
        return r25 + r1;
    L21:
        r24 = 0;
        goto L22
    L17:
        r21 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "DumpedEvent(eventName=" + this.eventName + ", dumpedDumpedEventParams=" + this.dumpedDumpedEventParams + ", stackTrace=" + this.stackTrace + ", timeStamp=" + this.timeStamp + ", dumpedClassInfo=" + this.dumpedClassInfo + ", localIndex=" + this.localIndex + ", eventClassVersion=" + this.eventClassVersion + ")";
    }

    public final DumpedClassInfo getDumpedClassInfo() {
        return this.dumpedClassInfo;
    }

    public final Map<DumpedEventKey, DumpedEventParam> getDumpedDumpedEventParams() {
        return this.dumpedDumpedEventParams;
    }

    public final Integer getEventClassVersion() {
        return this.eventClassVersion;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Integer getLocalIndex() {
        return this.localIndex;
    }

    public final String getStackTrace() {
        return this.stackTrace;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final void setDumpedClassInfo(DumpedClassInfo r1) {
        this.dumpedClassInfo = r1;
    }

    public final void setDumpedDumpedEventParams(Map<DumpedEventKey, DumpedEventParam> r1) {
        this.dumpedDumpedEventParams = r1;
    }

    public final void setEventClassVersion(Integer r1) {
        this.eventClassVersion = r1;
    }

    public final void setEventName(String r1) {
        this.eventName = r1;
    }

    public final void setLocalIndex(Integer r1) {
        this.localIndex = r1;
    }

    public final void setStackTrace(String r1) {
        this.stackTrace = r1;
    }

    public final void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }

    public DumpedEvent(String r1, Map<DumpedEventKey, DumpedEventParam> r10, String r11, long r12, DumpedClassInfo r13, Integer r14, Integer r15) {
        this.eventName = r1;
        this.dumpedDumpedEventParams = r10;
        this.stackTrace = r11;
        this.timeStamp = r12;
        this.dumpedClassInfo = r13;
        this.localIndex = r14;
        this.eventClassVersion = r15;
    }

    public /* synthetic */ DumpedEvent(String r10, Map r11, String r12, long r13, DumpedClassInfo r15, Integer r16, Integer r17, int r18, DefaultConstructorMarker r19) {
        Integer r1 = null;
        if ((r18 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Map r14 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r20 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r21 = System.currentTimeMillis();
    L19:
        if ((r18 & 16) == 0) goto L21;
        DumpedClassInfo r22 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r23 = null;
    L27:
        if ((r18 & 64) != 0) goto L30;
        r1 = r17;
    L30:
        this(r0, r14, r20, r21, r22, r23, r1);
        return;
    L25:
        r23 = r16;
        goto L27
    L21:
        r22 = r15;
        goto L23
    L17:
        r21 = r13;
        goto L19
    L13:
        r20 = r12;
        goto L15
    L9:
        r14 = r11;
        goto L11
    L5:
        r0 = r10;
        goto L7
    }
}
