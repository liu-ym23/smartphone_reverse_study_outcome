package com.obric.memorydata.memory.calendar;

import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J^\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/calendar/CalendarJsonItem;", "", "start_datetime", "", "end_datetime", "type", "", "title", "location", "description", "rrule", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStart_datetime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnd_datetime", "getType", "()Ljava/lang/String;", "getTitle", "getLocation", "getDescription", "getRrule", "isValid", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/memorydata/memory/calendar/CalendarJsonItem;", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CalendarJsonItem {
    private final String description;
    private final Long end_datetime;
    private final String location;
    private final String rrule;
    private final Long start_datetime;
    private final String title;
    private final String type;

    public CalendarJsonItem(Long r2, Long r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "title");
        this.start_datetime = r2;
        this.end_datetime = r3;
        this.type = r4;
        this.title = r5;
        this.location = r6;
        this.description = r7;
        this.rrule = r8;
    }

    public static /* synthetic */ CalendarJsonItem copy$default(CalendarJsonItem r5, Long r6, Long r7, String r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.start_datetime;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.end_datetime;
    L8:
        Long r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.type;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.title;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.location;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.description;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.rrule;
    L23:
        Long r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Long component1() {
        return this.start_datetime;
    }

    public final Long component2() {
        return this.end_datetime;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.location;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.rrule;
    }

    public final CalendarJsonItem copy(Long r9, Long r10, String r11, String r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "title");
        return new CalendarJsonItem(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CalendarJsonItem.class) == true) goto L8;
        return false;
    L8:
        CalendarJsonItem r6 = (CalendarJsonItem) ZeusTransformUtils.preCheckCast(r5, CalendarJsonItem.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.start_datetime, r6.start_datetime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.end_datetime, r6.end_datetime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.location, r6.location) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.rrule, r6.rrule) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Long getEnd_datetime() {
        return this.end_datetime;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final Long getStart_datetime() {
        return this.start_datetime;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        Long r0 = this.start_datetime;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.end_datetime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((r3 + r5) * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31;
        String r7 = this.location;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.description;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.rrule;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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

    public final boolean isValid() {
        if (at.a(this.title) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(this.type, PendingMemoryCalendar.TYPE_EVENT) == false) goto L7;
    L8:
        return true;
    L7:
        if (Intrinsics.areEqual(this.type, PendingMemoryCalendar.TYPE_TODO) == false) goto L9;
        goto L8
    }

    public String toString() {
        return "CalendarJsonItem(start_datetime=" + this.start_datetime + ", end_datetime=" + this.end_datetime + ", type=" + this.type + ", title=" + this.title + ", location=" + this.location + ", description=" + this.description + ", rrule=" + this.rrule + ')';
    }
}
