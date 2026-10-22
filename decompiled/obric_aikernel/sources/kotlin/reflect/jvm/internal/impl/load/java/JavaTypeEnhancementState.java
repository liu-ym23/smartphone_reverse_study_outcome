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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final JavaTypeEnhancementState getDEFAULT() {
            return JavaTypeEnhancementState.access$getDEFAULT$cp();
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new JavaTypeEnhancementState(JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings$default(null, 1, null), JavaTypeEnhancementState$Companion$DEFAULT$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(Jsr305Settings r10, Function1<? super FqName, ? extends ReportLevel> r11) {
        Intrinsics.checkNotNullParameter(r10, "jsr305");
        Intrinsics.checkNotNullParameter(r11, "getReportLevelForAnnotation");
        this.jsr305 = r10;
        this.getReportLevelForAnnotation = r11;
        if (r10.isDisabled() == false) goto L5;
    L8:
        boolean r12 = true;
    L9:
        this.disabledDefaultAnnotations = r12;
        return;
    L5:
        if (r11.invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.IGNORE) goto L8;
        r12 = false;
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
