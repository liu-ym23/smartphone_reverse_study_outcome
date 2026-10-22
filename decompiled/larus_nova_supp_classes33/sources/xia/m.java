package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m implements c {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    @Override // xia.c
    public final int a(AppEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "instance");
        if ((r8 instanceof ScheduleEntity) == false) goto L66;
        ScheduleEntity r9 = (ScheduleEntity) r8;
        int r0 = ((((r9.getName().hashCode() + 0) * 31) + r9.getStartTime().hashCode()) * 31) + r9.getEndTime().hashCode();
        String r1 = r9.getAddress();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        List r2 = r9.getAttendees();
        if (r2 == null) goto L10;
        r0 = (r0 * 31) + r2.hashCode();
    L10:
        String r3 = r9.getRepeatDescription();
        if (r3 == null) goto L13;
        r0 = (r0 * 31) + r3.hashCode();
    L13:
        Long r4 = r9.getStartTimestamp();
        if (r4 == null) goto L16;
        long r5 = r4.longValue();
        r0 = (r0 * 31) + ((int) (r5 ^ (r5 >>> 32)));
    L16:
        Long r6 = r9.getEndTimestamp();
        if (r6 == null) goto L19;
        long r7 = r6.longValue();
        r0 = (r0 * 31) + ((int) (r7 ^ (r7 >>> 32)));
    L19:
        int r10 = r0 * 31;
        int r11 = 1231;
        if (r9.getAllDay() == false) goto L22;
        int r12 = 1231;
    L23:
        int r13 = r10 + r12;
        String r14 = r9.getNote();
        if (r14 == null) goto L26;
        r13 = (r13 * 31) + r14.hashCode();
    L26:
        Boolean r15 = r9.getCompleted();
        if (r15 == null) goto L33;
        int r16 = r13 * 31;
        if (r15.booleanValue() == false) goto L31;
        int r17 = 1231;
    L32:
        r13 = r16 + r17;
        goto L33
    L31:
        r17 = 1237;
    L33:
        int r18 = r13 * 31;
        if (r9.isFavorite() == true) goto L37;
        r11 = 1237;
    L37:
        int r19 = r18 + r11;
        String r20 = r9.getReminderDesc();
        if (r20 == null) goto L40;
        r19 = (r19 * 31) + r20.hashCode();
    L40:
        String r21 = r9.getTimeDescription();
        if (r21 == null) goto L43;
        r19 = (r19 * 31) + r21.hashCode();
    L43:
        String r22 = r9.getRruleDescription();
        if (r22 == null) goto L46;
        r19 = (r19 * 31) + r22.hashCode();
    L46:
        String r23 = r9.getIcsId();
        if (r23 == null) goto L49;
        r19 = (r19 * 31) + r23.hashCode();
    L49:
        String r24 = r9.getRecurrenceId();
        if (r24 == null) goto L52;
        r19 = (r19 * 31) + r24.hashCode();
    L52:
        CalendarTypeEnum r25 = r9.getCalendarType();
        if (r25 == null) goto L55;
        r19 = (r19 * 31) + r25.name().hashCode();
    L55:
        String r26 = r9.getICalendarText();
        if (r26 == null) goto L58;
        r19 = (r19 * 31) + r26.hashCode();
    L58:
        Long r27 = r9.getJumpCalendarPageStartTimeStamp();
        if (r27 == null) goto L61;
        long r28 = r27.longValue();
        r19 = (r19 * 31) + ((int) ((r28 >>> 32) ^ r28));
    L61:
        String r29 = r9.getRawRrule();
        if (r29 != null) goto L64;
        return r19;
    L64:
        return (r19 * 31) + r29.hashCode();
    L22:
        r12 = 1237;
        goto L23
    L66:
        throw new IllegalStateException("Check failed.".toString());
    }
}
