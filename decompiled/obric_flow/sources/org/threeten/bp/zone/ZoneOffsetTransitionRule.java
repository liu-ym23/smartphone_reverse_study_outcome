package org.threeten.bp.zone;

import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.obric.oui.orecyclerview.widget.f0;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.h;

/* JADX INFO: loaded from: classes3.dex */
public final class ZoneOffsetTransitionRule implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final TimeDefinition timeDefinition;
    private final boolean timeEndOfDay;

    public static final enum TimeDefinition extends Enum<TimeDefinition> {
        public static final TimeDefinition STANDARD = null;
        public static final TimeDefinition UTC = null;
        public static final TimeDefinition WALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeDefinition[] f21295a = null;

        static {
            TimeDefinition r5 = new TimeDefinition("UTC", 0);
            UTC = r5;
            TimeDefinition r10 = new TimeDefinition("WALL", 1);
            WALL = r10;
            TimeDefinition r11 = new TimeDefinition("STANDARD", 2);
            STANDARD = r11;
            f21295a = new TimeDefinition[]{r5, r10, r11};
        }

        public static TimeDefinition valueOf(String r5) {
            return (TimeDefinition) Enum.valueOf(TimeDefinition.class, r5);
        }

        public static TimeDefinition[] values() {
            return (TimeDefinition[]) f21295a.clone();
        }

        public LocalDateTime createDateTime(LocalDateTime r5, ZoneOffset r10, ZoneOffset r11) {
            int r12 = c.f21302a[ordinal()];
            if (r12 == 1) goto L10;
            if (r12 == 2) goto L8;
            return r5;
        L8:
            return r5.plusSeconds(r11.getTotalSeconds() - r10.getTotalSeconds());
        L10:
            return r5.plusSeconds(r11.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
        }
    }

    public ZoneOffsetTransitionRule(Month r5, int r10, DayOfWeek r11, LocalTime r12, boolean r13, TimeDefinition r14, ZoneOffset r15, ZoneOffset r16, ZoneOffset r17) {
        this.month = r5;
        this.dom = (byte) r10;
        this.dow = r11;
        this.time = r12;
        this.timeEndOfDay = r13;
        this.timeDefinition = r14;
        this.standardOffset = r15;
        this.offsetBefore = r16;
        this.offsetAfter = r17;
    }

    public static ZoneOffsetTransitionRule of(Month r11, int r12, DayOfWeek r13, LocalTime r14, boolean r15, TimeDefinition r16, ZoneOffset r17, ZoneOffset r18, ZoneOffset r19) {
        jm.c.p(r11, "month");
        jm.c.p(r14, "time");
        jm.c.p(r16, "timeDefnition");
        jm.c.p(r17, "standardOffset");
        jm.c.p(r18, "offsetBefore");
        jm.c.p(r19, "offsetAfter");
        if (r12 < (-28)) goto L16;
        if (r12 > 31) goto L16;
        if (r12 == 0) goto L16;
        if (r15 == false) goto L14;
        if (r14.equals(LocalTime.MIDNIGHT) == true) goto L14;
        throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
    L14:
        return new ZoneOffsetTransitionRule(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L16:
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }

    public static ZoneOffsetTransitionRule readExternal(DataInput r13) throws IOException {
        int r5 = r13.readInt();
        Month r10 = Month.of(r5 >>> 28);
        int r11 = ((264241152 & r5) >>> 22) - 32;
        int r12 = (3670016 & r5) >>> 19;
        if (r12 != 0) goto L6;
        DayOfWeek r14 = null;
    L5:
        DayOfWeek r15 = r14;
        int r16 = (507904 & r5) >>> 14;
        TimeDefinition r17 = TimeDefinition.values()[(r5 & 12288) >>> 12];
        int r18 = (r5 & 4080) >>> 4;
        int r19 = (r5 & 12) >>> 2;
        int r20 = r5 & 3;
        if (r16 != 31) goto L10;
        LocalTime r21 = LocalTime.ofSecondOfDay(r13.readInt());
    L12:
        if (r18 != 255) goto L15;
        int r22 = r13.readInt();
    L14:
        ZoneOffset r23 = ZoneOffset.ofTotalSeconds(r22);
        if (r19 != 3) goto L19;
        ZoneOffset r24 = ZoneOffset.ofTotalSeconds(r13.readInt());
    L18:
        ZoneOffset r110 = r24;
        if (r20 != 3) goto L22;
        ZoneOffset r111 = ZoneOffset.ofTotalSeconds(r13.readInt());
    L24:
        if (r16 != 24) goto L26;
        boolean r25 = true;
    L28:
        return of(r10, r11, r15, r21, r25, r17, r23, r110, r111);
    L26:
        r25 = false;
        goto L28
    L22:
        r111 = ZoneOffset.ofTotalSeconds((r20 * 1800) + r23.getTotalSeconds());
        goto L24
    L19:
        r24 = ZoneOffset.ofTotalSeconds((r19 * 1800) + r23.getTotalSeconds());
        goto L18
    L15:
        r22 = (r18 - 128) * LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST;
        goto L14
    L10:
        r21 = LocalTime.of(r16 % 24, 0);
        goto L12
    L6:
        r14 = DayOfWeek.of(r12);
        goto L5
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public ZoneOffsetTransition createTransition(int r5) {
        byte r10 = this.dom;
        if (r10 >= 0) goto L7;
        Month r11 = this.month;
        LocalDate r12 = LocalDate.of(r5, r11, (r11.length(IsoChronology.INSTANCE.isLeapYear(r5)) + 1) + this.dom);
        DayOfWeek r13 = this.dow;
        if (r13 == null) goto L11;
        r12 = r12.with(new f0(r13, 1));
    L11:
        if (this.timeEndOfDay == false) goto L14;
        r12 = r12.plusDays(1);
    L14:
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.of(r12, this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    L7:
        r12 = LocalDate.of(r5, this.month, r10);
        DayOfWeek r14 = this.dow;
        if (r14 == null) goto L11;
        r12 = r12.with(h.a(r14));
        goto L11
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ZoneOffsetTransitionRule) == false) goto L28;
        ZoneOffsetTransitionRule r10 = (ZoneOffsetTransitionRule) r5;
        if (this.month != r10.month) goto L27;
        if (this.dom != r10.dom) goto L27;
        if (this.dow != r10.dow) goto L27;
        if (this.timeDefinition != r10.timeDefinition) goto L27;
        if (this.time.equals(r10.time) == false) goto L27;
        if (this.timeEndOfDay != r10.timeEndOfDay) goto L27;
        if (this.standardOffset.equals(r10.standardOffset) == false) goto L27;
        if (this.offsetBefore.equals(r10.offsetBefore) == false) goto L27;
        if (this.offsetAfter.equals(r10.offsetAfter) == false) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
    }

    public int getDayOfMonthIndicator() {
        return this.dom;
    }

    public DayOfWeek getDayOfWeek() {
        return this.dow;
    }

    public LocalTime getLocalTime() {
        return this.time;
    }

    public Month getMonth() {
        return this.month;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getStandardOffset() {
        return this.standardOffset;
    }

    public TimeDefinition getTimeDefinition() {
        return this.timeDefinition;
    }

    public int hashCode() {
        int r5 = (((this.time.toSecondOfDay() + (this.timeEndOfDay ? 1 : 0)) << 15) + (this.month.ordinal() << 11)) + ((this.dom + 32) << 5);
        DayOfWeek r10 = this.dow;
        if (r10 != null) goto L5;
        int r11 = 7;
    L6:
        int r12 = r5 + (r11 << 2);
        int r13 = this.timeDefinition.ordinal() + r12;
        int r14 = (this.standardOffset.hashCode() ^ r13) ^ this.offsetBefore.hashCode();
        return this.offsetAfter.hashCode() ^ r14;
    L5:
        r11 = r10.ordinal();
        goto L6
    }

    public boolean isMidnightEndOfDay() {
        return this.timeEndOfDay;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("TransitionRule[");
        if (this.offsetBefore.compareTo2(this.offsetAfter) <= 0) goto L5;
        String r10 = "Gap ";
    L6:
        r5.append(r10);
        r5.append(this.offsetBefore);
        r5.append(" to ");
        r5.append(this.offsetAfter);
        r5.append(", ");
        DayOfWeek r11 = this.dow;
        if (r11 == null) goto L14;
        byte r12 = this.dom;
        if (r12 != (-1)) goto L11;
        r5.append(r11.name());
        r5.append(" on or before last day of ");
        r5.append(this.month.name());
    L15:
        r5.append(" at ");
        if (this.timeEndOfDay == false) goto L18;
        String r13 = "24:00";
    L19:
        r5.append(r13);
        r5.append(" ");
        r5.append(this.timeDefinition);
        r5.append(", standard offset ");
        r5.append(this.standardOffset);
        r5.append(']');
        return r5.toString();
    L18:
        r13 = this.time.toString();
        goto L19
    L11:
        if (r12 >= 0) goto L13;
        r5.append(r11.name());
        r5.append(" on or before last day minus ");
        r5.append((-this.dom) - 1);
        r5.append(" of ");
        r5.append(this.month.name());
        goto L15
    L13:
        r5.append(r11.name());
        r5.append(" on or after ");
        r5.append(this.month.name());
        r5.append(' ');
        r5.append(this.dom);
        goto L15
    L14:
        r5.append(this.month.name());
        r5.append(' ');
        r5.append(this.dom);
        goto L15
    L5:
        r10 = "Overlap ";
        goto L6
    }

    public void writeExternal(DataOutput r13) throws IOException {
        if (this.timeEndOfDay == false) goto L5;
        int r5 = 86400;
    L6:
        int r10 = this.standardOffset.getTotalSeconds();
        int r11 = this.offsetBefore.getTotalSeconds() - r10;
        int r12 = this.offsetAfter.getTotalSeconds() - r10;
        if ((r5 % 3600) == 0) goto L9;
        int r14 = 31;
    L14:
        if ((r10 % LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST) != 0) goto L16;
        int r15 = (r10 / LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST) + 128;
    L18:
        if (r11 == 0) goto L23;
        if (r11 == 1800) goto L23;
        if (r11 == 3600) goto L23;
        int r16 = 3;
    L24:
        if (r12 == 0) goto L29;
        if (r12 == 1800) goto L29;
        if (r12 == 3600) goto L29;
        int r17 = 3;
    L30:
        DayOfWeek r18 = this.dow;
        if (r18 != null) goto L33;
        int r19 = 0;
    L34:
        r13.writeInt((((((((this.month.getValue() << 28) + ((this.dom + 32) << 22)) + (r19 << 19)) + (r14 << 14)) + (this.timeDefinition.ordinal() << 12)) + (r15 << 4)) + (r16 << 2)) + r17);
        if (r14 != 31) goto L37;
        r13.writeInt(r5);
    L37:
        if (r15 != 255) goto L39;
        r13.writeInt(r10);
    L39:
        if (r16 != 3) goto L41;
        r13.writeInt(this.offsetBefore.getTotalSeconds());
    L41:
        if (r17 != 3) goto L44;
        r13.writeInt(this.offsetAfter.getTotalSeconds());
        return;
    L44:
        return;
    L33:
        r19 = r18.getValue();
    L29:
        r17 = r12 / 1800;
    L23:
        r16 = r11 / 1800;
        goto L24
    L16:
        r15 = 255;
        goto L18
    L9:
        if (this.timeEndOfDay == false) goto L11;
        r14 = 24;
        goto L14
    L11:
        r14 = this.time.getHour();
        goto L14
    L5:
        r5 = this.time.toSecondOfDay();
        goto L6
    }
}
