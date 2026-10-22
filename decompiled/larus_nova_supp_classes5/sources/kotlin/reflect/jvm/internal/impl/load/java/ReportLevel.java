package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum ReportLevel extends Enum<ReportLevel> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ReportLevel[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ReportLevel IGNORE = null;
    public static final ReportLevel STRICT = null;
    public static final ReportLevel WARN = null;
    private final String description;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    private static final /* synthetic */ ReportLevel[] $values() {
        return new ReportLevel[]{IGNORE, WARN, STRICT};
    }

    static {
        IGNORE = new ReportLevel("IGNORE", 0, "ignore");
        WARN = new ReportLevel("WARN", 1, "warn");
        STRICT = new ReportLevel("STRICT", 2, "strict");
        ReportLevel[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }

    public static ReportLevel[] values() {
        return (ReportLevel[]) $VALUES.clone();
    }

    public final boolean isIgnore() {
        if (this != IGNORE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isWarning() {
        if (this != WARN) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public static ReportLevel valueOf(String r1) {
        return (ReportLevel) a.a(ReportLevel.class, r1);
    }

    private ReportLevel(String r1, int r2, String r3) {
        super(r1, r2);
        this.description = r3;
    }
}
