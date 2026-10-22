package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
public final enum ReportLevel extends Enum<ReportLevel> {
    private static final /* synthetic */ ReportLevel[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ReportLevel IGNORE = null;
    public static final ReportLevel STRICT = null;
    public static final ReportLevel WARN = null;
    private final String description;

    @SourceDebugExtension({"SMAP\nReportLevel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportLevel.kt\norg/jetbrains/kotlin/load/java/ReportLevel$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,20:1\n1282#2,2:21\n*S KotlinDebug\n*F\n+ 1 ReportLevel.kt\norg/jetbrains/kotlin/load/java/ReportLevel$Companion\n*L\n15#1:21,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
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

    private ReportLevel(String r5, int r10, String r11) {
        super(r5, r10);
        this.description = r11;
    }

    public static ReportLevel valueOf(String r5) {
        return (ReportLevel) Enum.valueOf(ReportLevel.class, r5);
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
