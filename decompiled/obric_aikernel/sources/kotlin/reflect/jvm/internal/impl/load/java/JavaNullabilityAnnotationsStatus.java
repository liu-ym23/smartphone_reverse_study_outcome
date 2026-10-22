package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaNullabilityAnnotationsStatus {
    public static final Companion Companion = null;
    private static final JavaNullabilityAnnotationsStatus DEFAULT = null;
    private final ReportLevel reportLevelAfter;
    private final ReportLevel reportLevelBefore;
    private final KotlinVersion sinceVersion;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final JavaNullabilityAnnotationsStatus getDEFAULT() {
            return JavaNullabilityAnnotationsStatus.access$getDEFAULT$cp();
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new JavaNullabilityAnnotationsStatus(ReportLevel.STRICT, null, null, 6, null);
    }

    public JavaNullabilityAnnotationsStatus(ReportLevel r10, KotlinVersion r11, ReportLevel r12) {
        Intrinsics.checkNotNullParameter(r10, "reportLevelBefore");
        Intrinsics.checkNotNullParameter(r12, "reportLevelAfter");
        this.reportLevelBefore = r10;
        this.sinceVersion = r11;
        this.reportLevelAfter = r12;
    }

    public /* synthetic */ JavaNullabilityAnnotationsStatus(ReportLevel r10, KotlinVersion r11, ReportLevel r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = new KotlinVersion(1, 0);
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = r10;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ JavaNullabilityAnnotationsStatus access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof JavaNullabilityAnnotationsStatus) == true) goto L8;
        return false;
    L8:
        JavaNullabilityAnnotationsStatus r11 = (JavaNullabilityAnnotationsStatus) r10;
        if (this.reportLevelBefore == r11.reportLevelBefore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sinceVersion, r11.sinceVersion) == true) goto L15;
        return false;
    L15:
        if (this.reportLevelAfter == r11.reportLevelAfter) goto L17;
        return false;
    L17:
        return true;
    }

    public final ReportLevel getReportLevelAfter() {
        return this.reportLevelAfter;
    }

    public final ReportLevel getReportLevelBefore() {
        return this.reportLevelBefore;
    }

    public final KotlinVersion getSinceVersion() {
        return this.sinceVersion;
    }

    public int hashCode() {
        int r10 = this.reportLevelBefore.hashCode() * 31;
        KotlinVersion r11 = this.sinceVersion;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return ((r10 + r12) * 31) + this.reportLevelAfter.hashCode();
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.reportLevelBefore + ", sinceVersion=" + this.sinceVersion + ", reportLevelAfter=" + this.reportLevelAfter + ')';
    }
}
