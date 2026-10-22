package org.threeten.bp.temporal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes8.dex */
public final class TemporalAdjusters {

    /* JADX INFO: renamed from: org.threeten.bp.temporal.TemporalAdjusters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class RelativeDayOfWeek implements TemporalAdjuster {
        private final int dowValue;
        private final int relative;

        private RelativeDayOfWeek(int r2, DayOfWeek r3) {
            Jdk8Methods.requireNonNull(r3, "dayOfWeek");
            this.relative = r2;
            this.dowValue = r3.getValue();
        }

        /* synthetic */ RelativeDayOfWeek(int r1, DayOfWeek r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal adjustInto(Temporal r4) {
            Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin");
            int r0 = r5.get(ChronoField.DAY_OF_WEEK);
            int r1 = this.relative;
            if (r1 < 2) goto L5;
        L7:
            int r2 = r1 & 1;
            int r3 = this.dowValue;
            if (r2 != 0) goto L15;
            int r6 = r0 - r3;
            if (r6 < 0) goto L12;
            int r7 = 7 - r6;
        L14:
            return r5.plus(r7, ChronoUnit.DAYS);
        L12:
            r7 = -r6;
            goto L14
        L15:
            int r8 = r3 - r0;
            if (r8 < 0) goto L18;
            int r9 = 7 - r8;
        L20:
            return r5.minus(r9, ChronoUnit.DAYS);
        L18:
            r9 = -r8;
            goto L20
        L5:
            if (r0 != this.dowValue) goto L7;
            return r5;
        }
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek r3) {
        return new RelativeDayOfWeek(0, r3, null);
    }

    public static TemporalAdjuster previousOrSame(DayOfWeek r3) {
        return new RelativeDayOfWeek(1, r3, null);
    }
}
