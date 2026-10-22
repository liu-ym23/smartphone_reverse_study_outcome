package com.obric.memorydata.memory.tracker;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemorySwitchReportGate;", "", "<init>", "()V", "SIX_HOURS_MILLIS", "", "evaluate", "Lcom/obric/memorydata/memory/tracker/MemorySwitchReportGate$Decision;", "lastReportTimestamp", "currentTimestamp", "timeZone", "Ljava/util/TimeZone;", "isSameDay", "", "first", "second", "Reason", "Decision", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemorySwitchReportGate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemorySwitchReportGate f10526a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemorySwitchReportGate$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_REPORT", "CLOCK_ROLLBACK", "CALENDAR_DAY_CHANGED", "SIX_HOURS_ELAPSED", "WITHIN_INTERVAL", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Reason[] $VALUES = null;
        public static final Reason CALENDAR_DAY_CHANGED = null;
        public static final Reason CLOCK_ROLLBACK = null;
        public static final Reason FIRST_REPORT = null;
        public static final Reason SIX_HOURS_ELAPSED = null;
        public static final Reason WITHIN_INTERVAL = null;

        private static final /* synthetic */ Reason[] $values() {
            return new Reason[]{FIRST_REPORT, CLOCK_ROLLBACK, CALENDAR_DAY_CHANGED, SIX_HOURS_ELAPSED, WITHIN_INTERVAL};
        }

        static {
            FIRST_REPORT = new Reason("FIRST_REPORT", 0);
            CLOCK_ROLLBACK = new Reason("CLOCK_ROLLBACK", 1);
            CALENDAR_DAY_CHANGED = new Reason("CALENDAR_DAY_CHANGED", 2);
            SIX_HOURS_ELAPSED = new Reason("SIX_HOURS_ELAPSED", 3);
            WITHIN_INTERVAL = new Reason("WITHIN_INTERVAL", 4);
            Reason[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Reason(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Reason> getEntries() {
            return $ENTRIES;
        }

        public static Reason valueOf(String r2) {
            return (Reason) ZeusTransformUtils.preCheckCast(Enum.valueOf(Reason.class, r2), Reason.class, "com.obric.memorydata.plugin");
        }

        public static Reason[] values() {
            return (Reason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Reason[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemorySwitchReportGate$Decision;", "", "shouldReport", "", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/memorydata/memory/tracker/MemorySwitchReportGate$Reason;", "<init>", "(ZLcom/obric/memorydata/memory/tracker/MemorySwitchReportGate$Reason;)V", "getShouldReport", "()Z", "getReason", "()Lcom/obric/memorydata/memory/tracker/MemorySwitchReportGate$Reason;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f10527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Reason f10528b;

        public a(boolean r2, Reason r3) {
            Intrinsics.checkNotNullParameter(r3, InfoRequestQPSOptTraceLogger.REASON);
            this.f10527a = r2;
            this.f10528b = r3;
        }

        public final boolean a() {
            return this.f10527a;
        }

        public final Reason b() {
            return this.f10528b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f10527a == r6.f10527a) goto L12;
            return false;
        L12:
            if (this.f10528b == r6.f10528b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f10527a) * 31) + this.f10528b.hashCode();
        }

        public String toString() {
            return "Decision(shouldReport=" + this.f10527a + ", reason=" + this.f10528b + ')';
        }
    }

    static {
        f10526a = new MemorySwitchReportGate();
    }

    private MemorySwitchReportGate() {
    }

    public static /* synthetic */ a a(MemorySwitchReportGate r6, long r7, long r9, TimeZone r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = TimeZone.getDefault();
    L6:
        return r6.a(r7, r9, r11);
    }

    private final boolean b(long r1, long r3, TimeZone r5) {
        Calendar r0 = Calendar.getInstance(r5);
        r0.setTimeInMillis(r1);
        Calendar r2 = Calendar.getInstance(r5);
        r2.setTimeInMillis(r3);
        if (r0.get(0) == r2.get(0)) goto L5;
        return false;
    L5:
        if (r0.get(1) == r2.get(1)) goto L7;
        return false;
    L7:
        if (r0.get(6) == r2.get(6)) goto L9;
        return false;
    L9:
        return true;
    }

    public final a a(long r3, long r5, TimeZone r7) {
        Intrinsics.checkNotNullParameter(r7, "timeZone");
        if (r3 > 0) goto L7;
        return new a(true, Reason.FIRST_REPORT);
    L7:
        if (r5 >= r3) goto L11;
        return new a(true, Reason.CLOCK_ROLLBACK);
    L11:
        if (b(r3, r5, r7) == true) goto L15;
        return new a(true, Reason.CALENDAR_DAY_CHANGED);
    L15:
        if ((r5 - r3) < 21600000) goto L19;
        return new a(true, Reason.SIX_HOURS_ELAPSED);
    L19:
        return new a(false, Reason.WITHIN_INTERVAL);
    }
}
