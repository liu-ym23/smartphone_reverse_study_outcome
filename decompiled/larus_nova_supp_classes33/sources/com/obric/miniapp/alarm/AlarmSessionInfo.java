package com.obric.miniapp.alarm;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jh\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006+"}, d2 = {"Lcom/obric/miniapp/alarm/AlarmSessionInfo;", "", "left_btn", "Lcom/obric/miniapp/alarm/LeftBtn;", "location", "", "calendarType", "timestamp", "", "timestamp_end", "title", "type", "time", "<init>", "(Lcom/obric/miniapp/alarm/LeftBtn;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLeft_btn", "()Lcom/obric/miniapp/alarm/LeftBtn;", "getLocation", "()Ljava/lang/String;", "getCalendarType", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimestamp_end", "getTitle", "getType", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/obric/miniapp/alarm/LeftBtn;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/miniapp/alarm/AlarmSessionInfo;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlarmSessionInfo {
    private final String calendarType;
    private final LeftBtn left_btn;
    private final String location;
    private final String time;
    private final Long timestamp;
    private final Long timestamp_end;
    private final String title;
    private final String type;

    public static /* synthetic */ AlarmSessionInfo copy$default(AlarmSessionInfo r9, LeftBtn r10, String r11, String r12, Long r13, Long r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        LeftBtn r2 = r9.left_btn;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.location;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.calendarType;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Long r5 = r9.timestamp;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Long r6 = r9.timestamp_end;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.title;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.type;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.time;
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

    public final LeftBtn component1() {
        return this.left_btn;
    }

    public final String component2() {
        return this.location;
    }

    public final String component3() {
        return this.calendarType;
    }

    public final Long component4() {
        return this.timestamp;
    }

    public final Long component5() {
        return this.timestamp_end;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.type;
    }

    public final String component8() {
        return this.time;
    }

    public final AlarmSessionInfo copy(LeftBtn r11, String r12, String r13, Long r14, Long r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "left_btn");
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "type");
        return new AlarmSessionInfo(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AlarmSessionInfo) == true) goto L8;
        return false;
    L8:
        AlarmSessionInfo r6 = (AlarmSessionInfo) r5;
        if (Intrinsics.areEqual(this.left_btn, r6.left_btn) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.location, r6.location) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.calendarType, r6.calendarType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timestamp, r6.timestamp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.timestamp_end, r6.timestamp_end) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.left_btn.hashCode() * 31;
        String r1 = this.location;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.calendarType;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.timestamp;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.timestamp_end;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((r10 + r12) * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31;
        String r14 = this.time;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
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

    public String toString() {
        return "AlarmSessionInfo(left_btn=" + this.left_btn + ", location=" + this.location + ", calendarType=" + this.calendarType + ", timestamp=" + this.timestamp + ", timestamp_end=" + this.timestamp_end + ", title=" + this.title + ", type=" + this.type + ", time=" + this.time + ')';
    }

    public final String getCalendarType() {
        return this.calendarType;
    }

    public final LeftBtn getLeft_btn() {
        return this.left_btn;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getTime() {
        return this.time;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final Long getTimestamp_end() {
        return this.timestamp_end;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public AlarmSessionInfo(LeftBtn r2, String r3, String r4, Long r5, Long r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "left_btn");
        Intrinsics.checkNotNullParameter(r7, "title");
        Intrinsics.checkNotNullParameter(r8, "type");
        this.left_btn = r2;
        this.location = r3;
        this.calendarType = r4;
        this.timestamp = r5;
        this.timestamp_end = r6;
        this.title = r7;
        this.type = r8;
        this.time = r9;
    }

    public /* synthetic */ AlarmSessionInfo(LeftBtn r11, String r12, String r13, Long r14, Long r15, String r16, String r17, String r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 128) == 0) goto L5;
        String r9 = null;
    L6:
        this(r11, r12, r13, r14, r15, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }
}
