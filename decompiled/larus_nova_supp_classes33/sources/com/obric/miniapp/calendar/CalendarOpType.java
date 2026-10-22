package com.obric.miniapp.calendar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/miniapp/calendar/CalendarOpType;", "", "<init>", "(Ljava/lang/String;I)V", "QUERY_CALENDAR", "MODIFY_CALENDAR", "SYNC_CALENDAR", "DELETE_CALENDAR", "QUERY_EVENT", "ADD_EVENT", "UPDATE_EVENT", "DELETE_EVENT", "SYNC_EVENT", "ADD_ATTENDEE", "QUERY_REMINDER", "ADD_REMINDER", "UPDATE_REMINDER", "DELETE_REMINDER", "SYNC_REMINDER", "QUERY_INSTANCES", "QUERY_EVENT_IDS_OF_INSTANCES", "QUERY_INSTANCES_BETWEEN", "QUERY_ENABLE_EVENTS", "QUERY_BY_KEYWORD", "SYNC_COLORS", "MERGE_CALENDAR", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CalendarOpType extends Enum<CalendarOpType> {
    public static final CalendarOpType ADD_ATTENDEE = null;
    public static final CalendarOpType ADD_EVENT = null;
    public static final CalendarOpType ADD_REMINDER = null;
    public static final a Companion = null;
    public static final CalendarOpType DELETE_CALENDAR = null;
    public static final CalendarOpType DELETE_EVENT = null;
    public static final CalendarOpType DELETE_REMINDER = null;
    public static final CalendarOpType MERGE_CALENDAR = null;
    public static final CalendarOpType MODIFY_CALENDAR = null;
    public static final CalendarOpType QUERY_BY_KEYWORD = null;
    public static final CalendarOpType QUERY_CALENDAR = null;
    public static final CalendarOpType QUERY_ENABLE_EVENTS = null;
    public static final CalendarOpType QUERY_EVENT = null;
    public static final CalendarOpType QUERY_EVENT_IDS_OF_INSTANCES = null;
    public static final CalendarOpType QUERY_INSTANCES = null;
    public static final CalendarOpType QUERY_INSTANCES_BETWEEN = null;
    public static final CalendarOpType QUERY_REMINDER = null;
    public static final CalendarOpType SYNC_CALENDAR = null;
    public static final CalendarOpType SYNC_COLORS = null;
    public static final CalendarOpType SYNC_EVENT = null;
    public static final CalendarOpType SYNC_REMINDER = null;
    public static final CalendarOpType UPDATE_EVENT = null;
    public static final CalendarOpType UPDATE_REMINDER = null;
    public static final /* synthetic */ CalendarOpType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CalendarOpType> getEntries() {
        return b;
    }

    static {
        CalendarOpType r0 = new CalendarOpType("QUERY_CALENDAR", 0);
        QUERY_CALENDAR = r0;
        CalendarOpType r1 = new CalendarOpType("MODIFY_CALENDAR", 1);
        MODIFY_CALENDAR = r1;
        CalendarOpType r3 = new CalendarOpType("SYNC_CALENDAR", 2);
        SYNC_CALENDAR = r3;
        CalendarOpType r5 = new CalendarOpType("DELETE_CALENDAR", 3);
        DELETE_CALENDAR = r5;
        CalendarOpType r7 = new CalendarOpType("QUERY_EVENT", 4);
        QUERY_EVENT = r7;
        CalendarOpType r9 = new CalendarOpType("ADD_EVENT", 5);
        ADD_EVENT = r9;
        CalendarOpType r11 = new CalendarOpType("UPDATE_EVENT", 6);
        UPDATE_EVENT = r11;
        CalendarOpType r13 = new CalendarOpType("DELETE_EVENT", 7);
        DELETE_EVENT = r13;
        CalendarOpType r15 = new CalendarOpType("SYNC_EVENT", 8);
        SYNC_EVENT = r15;
        CalendarOpType r14 = new CalendarOpType("ADD_ATTENDEE", 9);
        ADD_ATTENDEE = r14;
        CalendarOpType r12 = new CalendarOpType("QUERY_REMINDER", 10);
        QUERY_REMINDER = r12;
        CalendarOpType r10 = new CalendarOpType("ADD_REMINDER", 11);
        ADD_REMINDER = r10;
        CalendarOpType r8 = new CalendarOpType("UPDATE_REMINDER", 12);
        UPDATE_REMINDER = r8;
        CalendarOpType r6 = new CalendarOpType("DELETE_REMINDER", 13);
        DELETE_REMINDER = r6;
        CalendarOpType r4 = new CalendarOpType("SYNC_REMINDER", 14);
        SYNC_REMINDER = r4;
        CalendarOpType r2 = new CalendarOpType("QUERY_INSTANCES", 15);
        QUERY_INSTANCES = r2;
        CalendarOpType r16 = new CalendarOpType("QUERY_EVENT_IDS_OF_INSTANCES", 16);
        QUERY_EVENT_IDS_OF_INSTANCES = r16;
        CalendarOpType r17 = new CalendarOpType("QUERY_INSTANCES_BETWEEN", 17);
        QUERY_INSTANCES_BETWEEN = r17;
        CalendarOpType r18 = new CalendarOpType("QUERY_ENABLE_EVENTS", 18);
        QUERY_ENABLE_EVENTS = r18;
        CalendarOpType r19 = new CalendarOpType("QUERY_BY_KEYWORD", 19);
        QUERY_BY_KEYWORD = r19;
        CalendarOpType r20 = new CalendarOpType("SYNC_COLORS", 20);
        SYNC_COLORS = r20;
        CalendarOpType r21 = new CalendarOpType("MERGE_CALENDAR", 21);
        MERGE_CALENDAR = r21;
        CalendarOpType[] r22 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21};
        a = r22;
        b = EnumEntriesKt.enumEntries(r22);
        Companion = new a();
    }

    public static CalendarOpType[] values() {
        return (CalendarOpType[]) a.clone();
    }

    public static CalendarOpType valueOf(String r1) {
        return (CalendarOpType) r27.a.a(CalendarOpType.class, r1);
    }

    public CalendarOpType(String r1, int r2) {
        super(r1, r2);
    }
}
