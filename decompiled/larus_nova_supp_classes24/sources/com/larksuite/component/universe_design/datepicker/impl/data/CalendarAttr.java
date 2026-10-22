package com.larksuite.component.universe_design.datepicker.impl.data;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CalendarAttr {
    public SelectState a;
    public DateState b;
    public MonthState c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/data/CalendarAttr$DateState;", "", "<init>", "(Ljava/lang/String;I)V", "PAST_DATE", "FUTURE_DATE", "CURRENT_DATE", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DateState extends Enum<DateState> {
        public static final DateState CURRENT_DATE = null;
        public static final DateState FUTURE_DATE = null;
        public static final DateState PAST_DATE = null;
        public static final /* synthetic */ DateState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DateState> getEntries() {
            return b;
        }

        static {
            DateState r0 = new DateState("PAST_DATE", 0);
            PAST_DATE = r0;
            DateState r1 = new DateState("FUTURE_DATE", 1);
            FUTURE_DATE = r1;
            DateState r3 = new DateState("CURRENT_DATE", 2);
            CURRENT_DATE = r3;
            DateState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DateState[] values() {
            return (DateState[]) a.clone();
        }

        public static DateState valueOf(String r1) {
            return (DateState) a.a(DateState.class, r1);
        }

        public DateState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/data/CalendarAttr$MonthState;", "", "<init>", "(Ljava/lang/String;I)V", "CURRENT_MONTH", "LAST_MONTH", "NEXT_MONTH", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum MonthState extends Enum<MonthState> {
        public static final MonthState CURRENT_MONTH = null;
        public static final MonthState LAST_MONTH = null;
        public static final MonthState NEXT_MONTH = null;
        public static final /* synthetic */ MonthState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<MonthState> getEntries() {
            return b;
        }

        static {
            MonthState r0 = new MonthState("CURRENT_MONTH", 0);
            CURRENT_MONTH = r0;
            MonthState r1 = new MonthState("LAST_MONTH", 1);
            LAST_MONTH = r1;
            MonthState r3 = new MonthState("NEXT_MONTH", 2);
            NEXT_MONTH = r3;
            MonthState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static MonthState[] values() {
            return (MonthState[]) a.clone();
        }

        public static MonthState valueOf(String r1) {
            return (MonthState) a.a(MonthState.class, r1);
        }

        public MonthState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/data/CalendarAttr$SelectState;", "", "<init>", "(Ljava/lang/String;I)V", "SELECT", "UN_SELECT", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SelectState extends Enum<SelectState> {
        public static final SelectState SELECT = null;
        public static final SelectState UN_SELECT = null;
        public static final /* synthetic */ SelectState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SelectState> getEntries() {
            return b;
        }

        static {
            SelectState r0 = new SelectState("SELECT", 0);
            SELECT = r0;
            SelectState r1 = new SelectState("UN_SELECT", 1);
            UN_SELECT = r1;
            SelectState[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static SelectState[] values() {
            return (SelectState[]) a.clone();
        }

        public static SelectState valueOf(String r1) {
            return (SelectState) a.a(SelectState.class, r1);
        }

        public SelectState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CalendarAttr) == true) goto L8;
        return false;
    L8:
        CalendarAttr r6 = (CalendarAttr) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "CalendarAttr(selectState=" + this.a + ", dateState=" + this.b + ", monthState=" + this.c + ')';
    }

    public CalendarAttr(SelectState r2, DateState r3, MonthState r4) {
        Intrinsics.checkNotNullParameter(r2, "selectState");
        Intrinsics.checkNotNullParameter(r3, "dateState");
        Intrinsics.checkNotNullParameter(r4, "monthState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
