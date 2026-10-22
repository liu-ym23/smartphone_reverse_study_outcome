package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeMappingMode {

    @JvmField
    public static final TypeMappingMode CLASS_DECLARATION = null;
    public static final Companion Companion = null;

    @JvmField
    public static final TypeMappingMode DEFAULT = null;

    @JvmField
    public static final TypeMappingMode DEFAULT_UAST = null;

    @JvmField
    public static final TypeMappingMode GENERIC_ARGUMENT = null;

    @JvmField
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST = null;

    @JvmField
    public static final TypeMappingMode RETURN_TYPE_BOXED = null;

    @JvmField
    public static final TypeMappingMode SUPER_TYPE = null;

    @JvmField
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = null;

    @JvmField
    public static final TypeMappingMode VALUE_FOR_ANNOTATION = null;
    private final TypeMappingMode genericArgumentMode;
    private final TypeMappingMode genericContravariantArgumentMode;
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Variance.values().length];
            r5[Variance.IN_VARIANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[Variance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        Companion = new Companion(null);
        DefaultConstructorMarker r14 = null;
        boolean r5 = false;
        boolean r10 = false;
        boolean r11 = false;
        boolean r12 = false;
        boolean r13 = false;
        TypeMappingMode r15 = null;
        boolean r16 = false;
        TypeMappingMode r17 = null;
        TypeMappingMode r18 = null;
        boolean r19 = false;
        TypeMappingMode r20 = new TypeMappingMode(r5, r10, r11, r12, r13, r15, r16, r17, r18, r19, 1023, r14);
        GENERIC_ARGUMENT = r20;
        DefaultConstructorMarker r27 = null;
        boolean r110 = false;
        boolean r111 = false;
        boolean r112 = false;
        boolean r113 = false;
        boolean r21 = false;
        TypeMappingMode r22 = null;
        boolean r23 = false;
        TypeMappingMode r24 = null;
        TypeMappingMode r25 = null;
        boolean r26 = true;
        TypeMappingMode r28 = new TypeMappingMode(r110, r111, r112, r113, r21, r22, r23, r24, r25, r26, FrameMetricsAggregator.EVERY_DURATION, r27);
        GENERIC_ARGUMENT_UAST = r28;
        boolean r29 = true;
        RETURN_TYPE_BOXED = new TypeMappingMode(r5, r29, r11, r12, r13, r15, r16, r17, r18, r19, PointerIconCompat.TYPE_GRABBING, r14);
        int r114 = 988;
        DEFAULT = new TypeMappingMode(r5, false, r11, r12, r13, r20, r16, r17, r18, r19, r114, r14);
        DEFAULT_UAST = new TypeMappingMode(r110, r111, r112, r113, r21, r28, r23, r24, r25, r26, 476, r27);
        CLASS_DECLARATION = new TypeMappingMode(r5, true, r11, r12, r13, r20, r16, r17, r18, r19, r114, r14);
        boolean r30 = false;
        boolean r31 = true;
        SUPER_TYPE = new TypeMappingMode(r5, r30, r11, r31, r13, r20, r16, r17, r18, r19, 983, r14);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(r5, r30, r11, r31, r13, r20, r16, r17, r18, r19, 919, r14);
        boolean r32 = true;
        boolean r33 = false;
        VALUE_FOR_ANNOTATION = new TypeMappingMode(r5, r30, r32, r33, r13, r20, r16, r17, r18, r19, 984, r14);
    }

    public TypeMappingMode() {
        boolean r5 = false;
        boolean r10 = false;
        boolean r11 = false;
        boolean r12 = false;
        boolean r13 = false;
        TypeMappingMode r14 = null;
        boolean r15 = false;
        TypeMappingMode r16 = null;
        TypeMappingMode r17 = null;
        boolean r18 = false;
        this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, 1023, null);
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final TypeMappingMode toGenericArgumentMode(Variance r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "effectiveVariance");
        if (r10 == true) goto L5;
    L7:
        int r11 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r11 != 1) goto L10;
        TypeMappingMode r12 = this.genericContravariantArgumentMode;
        if (r12 != null) goto L20;
        return this;
    L20:
        return r12;
    L10:
        if (r11 == 2) goto L15;
        r12 = this.genericArgumentMode;
        if (r12 != null) goto L20;
        return this;
    L15:
        r12 = this.genericInvariantArgumentMode;
        if (r12 != null) goto L20;
        return this;
    L5:
        if (this.isForAnnotationParameter == false) goto L7;
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        boolean r5 = true;
        boolean r10 = false;
        return new TypeMappingMode(this.needPrimitiveBoxing, r5, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, r10, 512, null);
    }

    public TypeMappingMode(boolean r5, boolean r10, boolean r11, boolean r12, boolean r13, TypeMappingMode r14, boolean r15, TypeMappingMode r16, TypeMappingMode r17, boolean r18) {
        this.needPrimitiveBoxing = r5;
        this.needInlineClassWrapping = r10;
        this.isForAnnotationParameter = r11;
        this.skipDeclarationSiteWildcards = r12;
        this.skipDeclarationSiteWildcardsIfPossible = r13;
        this.genericArgumentMode = r14;
        this.kotlinCollectionsToJavaCollections = r15;
        this.genericContravariantArgumentMode = r16;
        this.genericInvariantArgumentMode = r17;
        this.mapTypeAliases = r18;
    }

    public /* synthetic */ TypeMappingMode(boolean r5, boolean r10, boolean r11, boolean r12, boolean r13, TypeMappingMode r14, boolean r15, TypeMappingMode r16, TypeMappingMode r17, boolean r18, int r19, DefaultConstructorMarker r110) {
        if ((r19 & 1) == 0) goto L6;
        r5 = true;
    L6:
        if ((r19 & 2) == 0) goto L9;
        r10 = true;
    L9:
        if ((r19 & 4) == 0) goto L12;
        r11 = false;
    L12:
        if ((r19 & 8) == 0) goto L15;
        r12 = false;
    L15:
        if ((r19 & 16) == 0) goto L18;
        r13 = false;
    L18:
        if ((r19 & 32) == 0) goto L21;
        r14 = null;
    L21:
        if ((r19 & 64) == 0) goto L24;
        r15 = true;
    L24:
        if ((r19 & 128) == 0) goto L27;
        r16 = r14;
    L27:
        if ((r19 & 256) == 0) goto L30;
        r17 = r14;
    L30:
        if ((r19 & 512) == 0) goto L32;
        r18 = false;
    L32:
        this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
