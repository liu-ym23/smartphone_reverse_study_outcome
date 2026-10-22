package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaNullabilityAnnotationSettingsKt {
    private static final FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = null;
    private static final FqName JSPECIFY_ANNOTATIONS_PACKAGE = null;
    private static final JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS = null;
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS = null;

    static {
        FqName r10 = new FqName("org.jspecify.nullness");
        JSPECIFY_ANNOTATIONS_PACKAGE = r10;
        FqName r11 = new FqName("org.checkerframework.checker.nullness.compatqual");
        CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = r11;
        FqName r12 = new FqName("org.jetbrains.annotations");
        JavaNullabilityAnnotationsStatus.Companion r13 = JavaNullabilityAnnotationsStatus.Companion;
        FqName r14 = new FqName("androidx.annotation.RecentlyNullable");
        ReportLevel r15 = ReportLevel.WARN;
        KotlinVersion r16 = new KotlinVersion(1, 8);
        ReportLevel r17 = ReportLevel.STRICT;
        NULLABILITY_ANNOTATION_SETTINGS = new NullabilityAnnotationStatesImpl(MapsKt.mapOf(new Pair[]{TuplesKt.to(r12, r13.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation"), r13.getDEFAULT()), TuplesKt.to(new FqName("android.support.annotation"), r13.getDEFAULT()), TuplesKt.to(new FqName("android.annotation"), r13.getDEFAULT()), TuplesKt.to(new FqName("com.android.annotations"), r13.getDEFAULT()), TuplesKt.to(new FqName("org.eclipse.jdt.annotation"), r13.getDEFAULT()), TuplesKt.to(new FqName("org.checkerframework.checker.nullness.qual"), r13.getDEFAULT()), TuplesKt.to(r11, r13.getDEFAULT()), TuplesKt.to(new FqName("javax.annotation"), r13.getDEFAULT()), TuplesKt.to(new FqName("edu.umd.cs.findbugs.annotations"), r13.getDEFAULT()), TuplesKt.to(new FqName("io.reactivex.annotations"), r13.getDEFAULT()), TuplesKt.to(r14, new JavaNullabilityAnnotationsStatus(r15, null, null, 4, null)), TuplesKt.to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(r15, null, null, 4, null)), TuplesKt.to(new FqName("lombok"), r13.getDEFAULT()), TuplesKt.to(r10, new JavaNullabilityAnnotationsStatus(r15, r16, r17)), TuplesKt.to(new FqName("io.reactivex.rxjava3.annotations"), new JavaNullabilityAnnotationsStatus(r15, new KotlinVersion(1, 8), r17))}));
        JSR_305_DEFAULT_SETTINGS = new JavaNullabilityAnnotationsStatus(r15, null, null, 4, null);
    }

    public static final Jsr305Settings getDefaultJsr305Settings(KotlinVersion r10) {
        Intrinsics.checkNotNullParameter(r10, "configuredKotlinVersion");
        JavaNullabilityAnnotationsStatus r11 = JSR_305_DEFAULT_SETTINGS;
        if (r11.getSinceVersion() != null) goto L5;
    L7:
        ReportLevel r12 = r11.getReportLevelBefore();
    L8:
        ReportLevel r13 = r12;
        return new Jsr305Settings(r13, getDefaultMigrationJsr305ReportLevelForGivenGlobal(r13), null, 4, null);
    L5:
        if (r11.getSinceVersion().compareTo2(r10) > 0) goto L7;
        r12 = r11.getReportLevelAfter();
        goto L8
    }

    public static /* synthetic */ Jsr305Settings getDefaultJsr305Settings$default(KotlinVersion r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = KotlinVersion.CURRENT;
    L6:
        return getDefaultJsr305Settings(r10);
    }

    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(ReportLevel r10) {
        Intrinsics.checkNotNullParameter(r10, "globalReportLevel");
        if (r10 != ReportLevel.WARN) goto L6;
        return null;
    L6:
        return r10;
    }

    public static final ReportLevel getDefaultReportLevelForAnnotation(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "annotationFqName");
        return getReportLevelForAnnotation$default(r10, NullabilityAnnotationStates.Companion.getEMPTY(), null, 4, null);
    }

    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    public static final ReportLevel getReportLevelForAnnotation(FqName r10, NullabilityAnnotationStates<? extends ReportLevel> r11, KotlinVersion r12) {
        Intrinsics.checkNotNullParameter(r10, "annotation");
        Intrinsics.checkNotNullParameter(r11, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(r12, "configuredKotlinVersion");
        ReportLevel r13 = r11.get(r10);
        if (r13 == null) goto L5;
        return r13;
    L5:
        JavaNullabilityAnnotationsStatus r14 = NULLABILITY_ANNOTATION_SETTINGS.get(r10);
        if (r14 != null) goto L10;
        return ReportLevel.IGNORE;
    L10:
        if (r14.getSinceVersion() == null) goto L15;
        if (r14.getSinceVersion().compareTo2(r12) > 0) goto L15;
        return r14.getReportLevelAfter();
    L15:
        return r14.getReportLevelBefore();
    }

    public static /* synthetic */ ReportLevel getReportLevelForAnnotation$default(FqName r10, NullabilityAnnotationStates r11, KotlinVersion r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = new KotlinVersion(1, 7, 20);
    L6:
        return getReportLevelForAnnotation(r10, r11, r12);
    }
}
