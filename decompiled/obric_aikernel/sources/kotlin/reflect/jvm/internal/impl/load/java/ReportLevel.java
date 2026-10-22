package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final enum ReportLevel extends Enum<ReportLevel> {
    private static final /* synthetic */ ReportLevel[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ReportLevel IGNORE = null;
    public static final ReportLevel STRICT = null;
    public static final ReportLevel WARN = null;
    private final String description;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
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
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private ReportLevel(String r10, int r11, String r12) {
        super(r10, r11);
        this.description = r12;
    }

    public static ReportLevel valueOf(String r10) {
        return (ReportLevel) Enum.valueOf(ReportLevel.class, r10);
    }

    public static ReportLevel[] values() {
        return (ReportLevel[]) $VALUES.clone();
    }

    public final String getDescription() {
        return this.description;
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
}
