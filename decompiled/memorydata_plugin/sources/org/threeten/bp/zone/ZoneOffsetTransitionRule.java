package org.threeten.bp.zone;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: loaded from: classes8.dex */
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

    /* JADX INFO: renamed from: org.threeten.bp.zone.ZoneOffsetTransitionRule$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition = null;

        static {
            int[] r0 = new int[TimeDefinition.values().length];
            $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition = r0;
            r0[TimeDefinition.UTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition[TimeDefinition.STANDARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum TimeDefinition extends Enum<TimeDefinition> {
        private static final /* synthetic */ TimeDefinition[] $VALUES = null;
        public static final TimeDefinition STANDARD = null;
        public static final TimeDefinition UTC = null;
        public static final TimeDefinition WALL = null;

        static {
            TimeDefinition r0 = new TimeDefinition("UTC", 0);
            UTC = r0;
            TimeDefinition r1 = new TimeDefinition("WALL", 1);
            WALL = r1;
            TimeDefinition r3 = new TimeDefinition("STANDARD", 2);
            STANDARD = r3;
            $VALUES = new TimeDefinition[]{r0, r1, r3};
        }

        private TimeDefinition(String r1, int r2) {
            super(r1, r2);
        }

        public static TimeDefinition valueOf(String r2) {
            return (TimeDefinition) ZeusTransformUtils.preCheckCast(Enum.valueOf(TimeDefinition.class, r2), TimeDefinition.class, "com.obric.memorydata.plugin");
        }

        public static TimeDefinition[] values() {
            return (TimeDefinition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TimeDefinition[].class, "com.obric.memorydata.plugin");
        }

        public LocalDateTime createDateTime(LocalDateTime r2, ZoneOffset r3, ZoneOffset r4) {
            int r1 = AnonymousClass1.$SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition[ordinal()];
            if (r1 != 1) goto L5;
            int r5 = r4.getTotalSeconds();
            r3 = ZoneOffset.UTC;
        L9:
            return r2.plusSeconds(r5 - r3.getTotalSeconds());
        L5:
            if (r1 == 2) goto L7;
            return r2;
        L7:
            r5 = r4.getTotalSeconds();
            goto L9
        }
    }

    ZoneOffsetTransitionRule(Month r1, int r2, DayOfWeek r3, LocalTime r4, boolean r5, TimeDefinition r6, ZoneOffset r7, ZoneOffset r8, ZoneOffset r9) {
        this.month = r1;
        this.dom = (byte) r2;
        this.dow = r3;
        this.time = r4;
        this.timeEndOfDay = r5;
        this.timeDefinition = r6;
        this.standardOffset = r7;
        this.offsetBefore = r8;
        this.offsetAfter = r9;
    }

    public static ZoneOffsetTransitionRule of(Month r11, int r12, DayOfWeek r13, LocalTime r14, boolean r15, TimeDefinition r16, ZoneOffset r17, ZoneOffset r18, ZoneOffset r19) {
        Jdk8Methods.requireNonNull(r11, "month");
        Jdk8Methods.requireNonNull(r14, OaidModel.KEY_TIME);
        Jdk8Methods.requireNonNull(r16, "timeDefnition");
        Jdk8Methods.requireNonNull(r17, "standardOffset");
        Jdk8Methods.requireNonNull(r18, "offsetBefore");
        Jdk8Methods.requireNonNull(r19, "offsetAfter");
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

    static ZoneOffsetTransitionRule readExternal(DataInput r13) {
        DataInput r14 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r13, DataInput.class, "com.obric.memorydata.plugin");
        int r0 = r14.readInt();
        Month r2 = Month.of(r0 >>> 28);
        int r3 = ((264241152 & r0) >>> 22) - 32;
        int r1 = (3670016 & r0) >>> 19;
        if (r1 != 0) goto L5;
        DayOfWeek r4 = null;
    L6:
        DayOfWeek r5 = r4;
        int r6 = (507904 & r0) >>> 14;
        TimeDefinition r7 = TimeDefinition.values()[(r0 & 12288) >>> 12];
        int r8 = (r0 & 4080) >>> 4;
        int r9 = (r0 & 12) >>> 2;
        int r10 = r0 & 3;
        if (r6 != 31) goto L9;
        LocalTime r11 = LocalTime.ofSecondOfDay(r14.readInt());
    L11:
        if (r8 != 255) goto L13;
        int r12 = r14.readInt();
    L14:
        ZoneOffset r15 = ZoneOffset.ofTotalSeconds(r12);
        if (r9 != 3) goto L17;
        int r16 = r14.readInt();
    L18:
        ZoneOffset r17 = ZoneOffset.ofTotalSeconds(r16);
        if (r10 != 3) goto L21;
        int r18 = r14.readInt();
    L22:
        ZoneOffset r19 = ZoneOffset.ofTotalSeconds(r18);
        if (r6 != 24) goto L25;
        boolean r20 = true;
    L27:
        return of(r2, r3, r5, r11, r20, r7, r15, r17, r19);
    L25:
        r20 = false;
        goto L27
    L21:
        r18 = r15.getTotalSeconds() + (r10 * 1800);
        goto L22
    L17:
        r16 = r15.getTotalSeconds() + (r9 * 1800);
        goto L18
    L13:
        r12 = (r8 - 128) * 900;
        goto L14
    L9:
        r11 = LocalTime.of(r6 % 24, 0);
        goto L11
    L5:
        r4 = DayOfWeek.of(r1);
        goto L6
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public ZoneOffsetTransition createTransition(int r5) {
        byte r0 = this.dom;
        if (r0 >= 0) goto L7;
        Month r1 = this.month;
        LocalDate r6 = LocalDate.of(r5, r1, (r1.length(IsoChronology.INSTANCE.isLeapYear(r5)) + 1) + this.dom);
        DayOfWeek r2 = this.dow;
        if (r2 == null) goto L12;
        TemporalAdjuster r3 = TemporalAdjusters.previousOrSame(r2);
    L10:
        r6 = r6.with(r3);
    L12:
        if (this.timeEndOfDay == false) goto L15;
        r6 = r6.plusDays(1);
    L15:
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.of(r6, this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    L7:
        r6 = LocalDate.of(r5, this.month, r0);
        DayOfWeek r4 = this.dow;
        if (r4 == null) goto L12;
        r3 = TemporalAdjusters.nextOrSame(r4);
        goto L10
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ZoneOffsetTransitionRule.class) == false) goto L28;
        ZoneOffsetTransitionRule r6 = (ZoneOffsetTransitionRule) ZeusTransformUtils.preCheckCast(r5, ZoneOffsetTransitionRule.class, "com.obric.memorydata.plugin");
        if (this.month != r6.month) goto L27;
        if (this.dom != r6.dom) goto L27;
        if (this.dow != r6.dow) goto L27;
        if (this.timeDefinition != r6.timeDefinition) goto L27;
        if (this.time.equals(r6.time) == false) goto L27;
        if (this.timeEndOfDay != r6.timeEndOfDay) goto L27;
        if (this.standardOffset.equals(r6.standardOffset) == false) goto L27;
        if (this.offsetBefore.equals(r6.offsetBefore) == false) goto L27;
        if (this.offsetAfter.equals(r6.offsetAfter) == false) goto L27;
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
        int r0 = (((this.time.toSecondOfDay() + (this.timeEndOfDay ? 1 : 0)) << 15) + (this.month.ordinal() << 11)) + ((this.dom + 32) << 5);
        DayOfWeek r1 = this.dow;
        if (r1 != null) goto L5;
        int r2 = 7;
    L6:
        int r3 = (((r0 + (r2 << 2)) + this.timeDefinition.ordinal()) ^ this.standardOffset.hashCode()) ^ this.offsetBefore.hashCode();
        return this.offsetAfter.hashCode() ^ r3;
    L5:
        r2 = r1.ordinal();
        goto L6
    }

    public boolean isMidnightEndOfDay() {
        return this.timeEndOfDay;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = r0.append("TransitionRule[");
        if (this.offsetBefore.compareTo2(this.offsetAfter) <= 0) goto L5;
        String r2 = "Gap ";
    L6:
        r1.append(r2).append(this.offsetBefore).append(" to ").append(this.offsetAfter).append(", ");
        DayOfWeek r3 = this.dow;
        if (r3 == null) goto L15;
        byte r4 = this.dom;
        StringBuilder r5 = r0.append(r3.name());
        if (r4 != (-1)) goto L12;
        String r6 = " on or before last day of ";
    L11:
        r5.append(r6).append(this.month.name());
    L17:
        StringBuilder r7 = r0.append(" at ");
        if (this.timeEndOfDay == false) goto L20;
        String r8 = "24:00";
    L21:
        r7.append(r8).append(" ").append(this.timeDefinition).append(", standard offset ").append(this.standardOffset).append(']');
        return r0.toString();
    L20:
        r8 = this.time.toString();
        goto L21
    L12:
        if (r4 >= 0) goto L14;
        r5 = r5.append(" on or before last day minus ").append((-this.dom) - 1);
        r6 = " of ";
        goto L11
    L14:
        StringBuilder r9 = r5.append(" on or after ").append(this.month.name());
    L16:
        r9.append(' ').append(this.dom);
        goto L17
    L15:
        r9 = r0.append(this.month.name());
        goto L16
    L5:
        r2 = "Overlap ";
        goto L6
    }

    void writeExternal(DataOutput r13) {
        DataOutput r14 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r13, DataOutput.class, "com.obric.memorydata.plugin");
        if (this.timeEndOfDay == false) goto L5;
        int r0 = 86400;
    L6:
        int r1 = this.standardOffset.getTotalSeconds();
        int r2 = this.offsetBefore.getTotalSeconds() - r1;
        int r3 = this.offsetAfter.getTotalSeconds() - r1;
        if ((r0 % 3600) == 0) goto L9;
        int r4 = 31;
    L14:
        if ((r1 % 900) != 0) goto L16;
        int r6 = (r1 / 900) + 128;
    L18:
        if (r2 == 0) goto L23;
        if (r2 == 1800) goto L23;
        if (r2 == 3600) goto L23;
        int r5 = 3;
    L24:
        if (r3 == 0) goto L29;
        if (r3 == 1800) goto L29;
        if (r3 == 3600) goto L29;
        int r7 = 3;
    L30:
        DayOfWeek r8 = this.dow;
        if (r8 != null) goto L33;
        int r9 = 0;
    L34:
        r14.writeInt((((((((this.month.getValue() << 28) + ((this.dom + 32) << 22)) + (r9 << 19)) + (r4 << 14)) + (this.timeDefinition.ordinal() << 12)) + (r6 << 4)) + (r5 << 2)) + r7);
        if (r4 != 31) goto L37;
        r14.writeInt(r0);
    L37:
        if (r6 != 255) goto L39;
        r14.writeInt(r1);
    L39:
        if (r5 != 3) goto L41;
        r14.writeInt(this.offsetBefore.getTotalSeconds());
    L41:
        if (r7 != 3) goto L44;
        r14.writeInt(this.offsetAfter.getTotalSeconds());
        return;
    L44:
        return;
    L33:
        r9 = r8.getValue();
    L29:
        r7 = r3 / 1800;
    L23:
        r5 = r2 / 1800;
        goto L24
    L16:
        r6 = 255;
        goto L18
    L9:
        if (this.timeEndOfDay == false) goto L11;
        r4 = 24;
        goto L14
    L11:
        r4 = this.time.getHour();
        goto L14
    L5:
        r0 = this.time.toSecondOfDay();
        goto L6
    }
}
