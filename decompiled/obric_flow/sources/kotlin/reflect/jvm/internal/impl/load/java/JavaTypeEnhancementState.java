package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeEnhancementState {
    public static final Companion Companion = null;
    private static final JavaTypeEnhancementState DEFAULT = null;
    private final boolean disabledDefaultAnnotations;
    private final Function1<FqName, ReportLevel> getReportLevelForAnnotation;
    private final Jsr305Settings jsr305;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final JavaTypeEnhancementState getDEFAULT() {
            return JavaTypeEnhancementState.access$getDEFAULT$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new JavaTypeEnhancementState(JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings$default(null, 1, null), JavaTypeEnhancementState$Companion$DEFAULT$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(Jsr305Settings r5, Function1<? super FqName, ? extends ReportLevel> r10) {
        Intrinsics.checkNotNullParameter(r5, "jsr305");
        Intrinsics.checkNotNullParameter(r10, "getReportLevelForAnnotation");
        this.jsr305 = r5;
        this.getReportLevelForAnnotation = r10;
        if (r5.isDisabled() == false) goto L5;
    L8:
        boolean r11 = true;
    L9:
        this.disabledDefaultAnnotations = r11;
        return;
    L5:
        if (r10.invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.IGNORE) goto L8;
        r11 = false;
        goto L9
    }

    public static final /* synthetic */ JavaTypeEnhancementState access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.disabledDefaultAnnotations;
    }

    public final Function1<FqName, ReportLevel> getGetReportLevelForAnnotation() {
        return this.getReportLevelForAnnotation;
    }

    public final Jsr305Settings getJsr305() {
        return this.jsr305;
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.jsr305 + ", getReportLevelForAnnotation=" + this.getReportLevelForAnnotation + ')';
    }
}
