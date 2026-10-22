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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[Variance.values().length];
            r10[Variance.IN_VARIANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[Variance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        Companion = new Companion(null);
        boolean r10 = false;
        boolean r11 = false;
        boolean r12 = false;
        boolean r13 = false;
        TypeMappingMode r14 = null;
        boolean r15 = false;
        TypeMappingMode r16 = null;
        TypeMappingMode r17 = null;
        boolean r18 = false;
        DefaultConstructorMarker r19 = null;
        TypeMappingMode r20 = new TypeMappingMode(r10, false, r11, r12, r13, r14, r15, r16, r17, r18, 1023, r19);
        GENERIC_ARGUMENT = r20;
        boolean r110 = false;
        boolean r111 = false;
        boolean r112 = false;
        boolean r113 = false;
        boolean r21 = false;
        boolean r22 = false;
        TypeMappingMode r23 = null;
        TypeMappingMode r24 = null;
        boolean r25 = true;
        DefaultConstructorMarker r27 = null;
        TypeMappingMode r26 = new TypeMappingMode(r110, r111, r112, r113, r21, null, r22, r23, r24, r25, FrameMetricsAggregator.EVERY_DURATION, r27);
        GENERIC_ARGUMENT_UAST = r26;
        RETURN_TYPE_BOXED = new TypeMappingMode(r10, true, r11, r12, r13, r14, r15, r16, r17, r18, PointerIconCompat.TYPE_GRABBING, r19);
        int r114 = 988;
        DEFAULT = new TypeMappingMode(r10, false, r11, r12, r13, r20, r15, r16, r17, r18, r114, r19);
        DEFAULT_UAST = new TypeMappingMode(r110, r111, r112, r113, r21, r26, r22, r23, r24, r25, 476, r27);
        CLASS_DECLARATION = new TypeMappingMode(r10, true, r11, r12, r13, r20, r15, r16, r17, r18, r114, r19);
        boolean r28 = false;
        boolean r29 = true;
        SUPER_TYPE = new TypeMappingMode(r10, r28, r11, r29, r13, r20, r15, r16, r17, r18, 983, r19);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(r10, r28, r11, r29, r13, r20, r15, r16, r17, r18, 919, r19);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(r10, r28, true, false, r13, r20, r15, r16, r17, r18, 984, r19);
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public TypeMappingMode(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, TypeMappingMode r15, boolean r16, TypeMappingMode r17, TypeMappingMode r18, boolean r19) {
        this.needPrimitiveBoxing = r10;
        this.needInlineClassWrapping = r11;
        this.isForAnnotationParameter = r12;
        this.skipDeclarationSiteWildcards = r13;
        this.skipDeclarationSiteWildcardsIfPossible = r14;
        this.genericArgumentMode = r15;
        this.kotlinCollectionsToJavaCollections = r16;
        this.genericContravariantArgumentMode = r17;
        this.genericInvariantArgumentMode = r18;
        this.mapTypeAliases = r19;
    }

    public /* synthetic */ TypeMappingMode(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, TypeMappingMode r15, boolean r16, TypeMappingMode r17, TypeMappingMode r18, boolean r19, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r10 = true;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r11 = true;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r12 = false;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r13 = false;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r14 = false;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r16 = true;
    L24:
        if ((r110 & 128) == 0) goto L27;
        r17 = r15;
    L27:
        if ((r110 & 256) == 0) goto L30;
        r18 = r15;
    L30:
        if ((r110 & 512) == 0) goto L32;
        r19 = false;
    L32:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
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

    public final TypeMappingMode toGenericArgumentMode(Variance r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "effectiveVariance");
        if (r11 == true) goto L5;
    L7:
        int r12 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r12 != 1) goto L10;
        TypeMappingMode r13 = this.genericContravariantArgumentMode;
        if (r13 != null) goto L21;
        return this;
    L21:
        return r13;
    L10:
        if (r12 == 2) goto L14;
        r13 = this.genericArgumentMode;
        if (r13 != null) goto L21;
        return this;
    L14:
        r13 = this.genericInvariantArgumentMode;
        if (r13 != null) goto L21;
        return this;
    L5:
        if (this.isForAnnotationParameter == false) goto L7;
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        boolean r10 = true;
        return new TypeMappingMode(this.needPrimitiveBoxing, r10, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, null);
    }
}
