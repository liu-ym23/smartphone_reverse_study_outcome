package kotlin.reflect.jvm.internal.impl.load.java;

import ai.j0;
import kotlin.KotlinVersion;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJavaNullabilityAnnotationSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaNullabilityAnnotationSettings.kt\norg/jetbrains/kotlin/load/java/JavaNullabilityAnnotationSettingsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class JavaNullabilityAnnotationSettingsKt {
    private static final FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = null;
    private static final FqName JSPECIFY_ANNOTATIONS_PACKAGE = null;
    private static final FqName JSPECIFY_OLD_ANNOTATIONS_PACKAGE = null;
    private static final JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS = null;
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS = null;
    private static final FqName[] RXJAVA3_ANNOTATIONS = null;
    private static final FqName RXJAVA3_ANNOTATIONS_PACKAGE = null;
    private static final String RXJAVA3_ANNOTATIONS_PACKAGE_NAME = null;

    static {
        FqName r5 = new FqName("org.jspecify.nullness");
        JSPECIFY_OLD_ANNOTATIONS_PACKAGE = r5;
        FqName r10 = new FqName("org.jspecify.annotations");
        JSPECIFY_ANNOTATIONS_PACKAGE = r10;
        FqName r11 = new FqName("io.reactivex.rxjava3.annotations");
        RXJAVA3_ANNOTATIONS_PACKAGE = r11;
        FqName r12 = new FqName("org.checkerframework.checker.nullness.compatqual");
        CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = r12;
        String r13 = r11.asString();
        RXJAVA3_ANNOTATIONS_PACKAGE_NAME = r13;
        RXJAVA3_ANNOTATIONS = new FqName[]{new FqName(j0.j(r13, ".Nullable")), new FqName(j0.j(r13, ".NonNull"))};
        FqName r14 = new FqName("org.jetbrains.annotations");
        JavaNullabilityAnnotationsStatus.Companion r15 = JavaNullabilityAnnotationsStatus.Companion;
        Pair r16 = TuplesKt.to(r14, r15.getDEFAULT());
        Pair r17 = TuplesKt.to(new FqName("androidx.annotation"), r15.getDEFAULT());
        Pair r18 = TuplesKt.to(new FqName("android.support.annotation"), r15.getDEFAULT());
        Pair r19 = TuplesKt.to(new FqName("android.annotation"), r15.getDEFAULT());
        Pair r110 = TuplesKt.to(new FqName("com.android.annotations"), r15.getDEFAULT());
        Pair r111 = TuplesKt.to(new FqName("org.eclipse.jdt.annotation"), r15.getDEFAULT());
        Pair r112 = TuplesKt.to(new FqName("org.checkerframework.checker.nullness.qual"), r15.getDEFAULT());
        Pair r113 = TuplesKt.to(r12, r15.getDEFAULT());
        Pair r114 = TuplesKt.to(new FqName("javax.annotation"), r15.getDEFAULT());
        Pair r115 = TuplesKt.to(new FqName("edu.umd.cs.findbugs.annotations"), r15.getDEFAULT());
        Pair r116 = TuplesKt.to(new FqName("io.reactivex.annotations"), r15.getDEFAULT());
        FqName r20 = new FqName("androidx.annotation.RecentlyNullable");
        ReportLevel r21 = ReportLevel.WARN;
        Pair r117 = TuplesKt.to(r20, new JavaNullabilityAnnotationsStatus(r21, null, null, 4, null));
        Pair r22 = TuplesKt.to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(r21, null, null, 4, null));
        Pair r23 = TuplesKt.to(new FqName("lombok"), r15.getDEFAULT());
        KotlinVersion r24 = new KotlinVersion(1, 9);
        ReportLevel r25 = ReportLevel.STRICT;
        NULLABILITY_ANNOTATION_SETTINGS = new NullabilityAnnotationStatesImpl(MapsKt.mapOf(new Pair[]{r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r22, r23, TuplesKt.to(r5, new JavaNullabilityAnnotationsStatus(r21, r24, r25)), TuplesKt.to(r10, new JavaNullabilityAnnotationsStatus(r21, new KotlinVersion(1, 9), r25)), TuplesKt.to(r11, new JavaNullabilityAnnotationsStatus(r21, new KotlinVersion(1, 8), r25))}));
        JSR_305_DEFAULT_SETTINGS = new JavaNullabilityAnnotationsStatus(r21, null, null, 4, null);
    }

    public static final Jsr305Settings getDefaultJsr305Settings(KotlinVersion r10) {
        Intrinsics.checkNotNullParameter(r10, "configuredKotlinVersion");
        JavaNullabilityAnnotationsStatus r5 = JSR_305_DEFAULT_SETTINGS;
        if (r5.getSinceVersion() != null) goto L5;
    L8:
        ReportLevel r11 = r5.getReportLevelBefore();
    L7:
        ReportLevel r12 = r11;
        return new Jsr305Settings(r12, getDefaultMigrationJsr305ReportLevelForGivenGlobal(r12), null, 4, null);
    L5:
        if (r5.getSinceVersion().compareTo2(r10) > 0) goto L8;
        r11 = r5.getReportLevelAfter();
        goto L7
    }

    public static /* synthetic */ Jsr305Settings getDefaultJsr305Settings$default(KotlinVersion r5, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r5 = KotlinVersion.CURRENT;
    L6:
        return getDefaultJsr305Settings(r5);
    }

    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(ReportLevel r5) {
        Intrinsics.checkNotNullParameter(r5, "globalReportLevel");
        if (r5 != ReportLevel.WARN) goto L6;
        return null;
    L6:
        return r5;
    }

    public static final ReportLevel getDefaultReportLevelForAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationFqName");
        return getReportLevelForAnnotation$default(r5, NullabilityAnnotationStates.Companion.getEMPTY(), null, 4, null);
    }

    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    public static final FqName[] getRXJAVA3_ANNOTATIONS() {
        return RXJAVA3_ANNOTATIONS;
    }

    public static final ReportLevel getReportLevelForAnnotation(FqName r5, NullabilityAnnotationStates<? extends ReportLevel> r10, KotlinVersion r11) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        Intrinsics.checkNotNullParameter(r10, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(r11, "configuredKotlinVersion");
        ReportLevel r12 = r10.get(r5);
        if (r12 == null) goto L5;
        return r12;
    L5:
        JavaNullabilityAnnotationsStatus r13 = NULLABILITY_ANNOTATION_SETTINGS.get(r5);
        if (r13 != null) goto L10;
        return ReportLevel.IGNORE;
    L10:
        if (r13.getSinceVersion() == null) goto L15;
        if (r13.getSinceVersion().compareTo2(r11) > 0) goto L15;
        return r13.getReportLevelAfter();
    L15:
        return r13.getReportLevelBefore();
    }

    public static /* synthetic */ ReportLevel getReportLevelForAnnotation$default(FqName r5, NullabilityAnnotationStates r10, KotlinVersion r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = new KotlinVersion(1, 7, 20);
    L6:
        return getReportLevelForAnnotation(r5, r10, r11);
    }
}
