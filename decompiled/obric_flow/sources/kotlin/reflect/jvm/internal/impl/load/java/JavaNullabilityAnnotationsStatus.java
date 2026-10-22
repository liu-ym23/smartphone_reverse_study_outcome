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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final JavaNullabilityAnnotationsStatus getDEFAULT() {
            return JavaNullabilityAnnotationsStatus.access$getDEFAULT$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        KotlinVersion r5 = null;
        ReportLevel r10 = null;
        DEFAULT = new JavaNullabilityAnnotationsStatus(ReportLevel.STRICT, r5, r10, 6, null);
    }

    public JavaNullabilityAnnotationsStatus(ReportLevel r5, KotlinVersion r10, ReportLevel r11) {
        Intrinsics.checkNotNullParameter(r5, "reportLevelBefore");
        Intrinsics.checkNotNullParameter(r11, "reportLevelAfter");
        this.reportLevelBefore = r5;
        this.sinceVersion = r10;
        this.reportLevelAfter = r11;
    }

    public static final /* synthetic */ JavaNullabilityAnnotationsStatus access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JavaNullabilityAnnotationsStatus) == true) goto L8;
        return false;
    L8:
        JavaNullabilityAnnotationsStatus r10 = (JavaNullabilityAnnotationsStatus) r5;
        if (this.reportLevelBefore == r10.reportLevelBefore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sinceVersion, r10.sinceVersion) == true) goto L15;
        return false;
    L15:
        if (this.reportLevelAfter == r10.reportLevelAfter) goto L17;
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
        int r5 = this.reportLevelBefore.hashCode() * 31;
        KotlinVersion r10 = this.sinceVersion;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = this.reportLevelAfter.hashCode();
        return r12 + ((r5 + r11) * 31);
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.reportLevelBefore + ", sinceVersion=" + this.sinceVersion + ", reportLevelAfter=" + this.reportLevelAfter + ')';
    }

    public /* synthetic */ JavaNullabilityAnnotationsStatus(ReportLevel r5, KotlinVersion r10, ReportLevel r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = new KotlinVersion(1, 0);
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = r5;
    L8:
        this(r5, r10, r11);
    }
}
