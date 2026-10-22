package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoEnumFlags {
    public static final ProtoEnumFlags INSTANCE = null;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7 = null;

        static {
            int[] r0 = new int[ProtoBuf$Modality.values().length];
            r0[ProtoBuf$Modality.FINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L54
        L109:
            r0[ProtoBuf$Modality.OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L55
        L121:
            r0[ProtoBuf$Modality.ABSTRACT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L56
        L135:
            r0[ProtoBuf$Modality.SEALED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L57
        L10:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[Modality.values().length];
            r1[Modality.FINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L157:
            r1[Modality.OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L93:
            r1[Modality.ABSTRACT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L103:
            r1[Modality.SEALED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L15:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[ProtoBuf$Visibility.values().length];
            r2[ProtoBuf$Visibility.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L62
        L127:
            r2[ProtoBuf$Visibility.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L63
        L139:
            r2[ProtoBuf$Visibility.PRIVATE_TO_THIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L64
        L149:
            r2[ProtoBuf$Visibility.PROTECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L65
        L159:
            r2[ProtoBuf$Visibility.PUBLIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L66
        L95:
            r2[ProtoBuf$Visibility.LOCAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L67
        L24:
            $EnumSwitchMapping$2 = r2;
            int[] r3 = new int[ProtoBuf$Class.Kind.values().length];
            r3[ProtoBuf$Class.Kind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L68
        L129:
            r3[ProtoBuf$Class.Kind.INTERFACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L69
        L141:
            r3[ProtoBuf$Class.Kind.ENUM_CLASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L70
        L151:
            r3[ProtoBuf$Class.Kind.ENUM_ENTRY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L71
        L161:
            r3[ProtoBuf$Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L72
        L97:
            r3[ProtoBuf$Class.Kind.OBJECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L73
        L107:
            r3[ProtoBuf$Class.Kind.COMPANION_OBJECT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L74
        L32:
            $EnumSwitchMapping$3 = r3;
            int[] r4 = new int[ClassKind.values().length];
            r4[ClassKind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L75
        L131:
            r4[ClassKind.INTERFACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L76
        L143:
            r4[ClassKind.ENUM_CLASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L77
        L153:
            r4[ClassKind.ENUM_ENTRY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L78
        L163:
            r4[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L79
        L99:
            r4[ClassKind.OBJECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L80
        L39:
            $EnumSwitchMapping$4 = r4;
            int[] r5 = new int[ProtoBuf$TypeParameter.Variance.values().length];
            r5[ProtoBuf$TypeParameter.Variance.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L81
        L123:
            r5[ProtoBuf$TypeParameter.Variance.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L82
        L133:
            r5[ProtoBuf$TypeParameter.Variance.INV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L83
        L43:
            $EnumSwitchMapping$5 = r5;
            int[] r6 = new int[ProtoBuf$Type.Argument.Projection.values().length];
            r6[ProtoBuf$Type.Argument.Projection.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L84
        L155:
            r6[ProtoBuf$Type.Argument.Projection.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L85
        L91:
            r6[ProtoBuf$Type.Argument.Projection.INV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L86
        L101:
            r6[ProtoBuf$Type.Argument.Projection.STAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L87
        L48:
            $EnumSwitchMapping$6 = r6;
            int[] r7 = new int[Variance.values().length];
            r7[Variance.IN_VARIANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L88
        L125:
            r7[Variance.OUT_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L89
        L137:
            r7[Variance.INVARIANT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L90
        L52:
            $EnumSwitchMapping$7 = r7;
        }
    }

    static {
        INSTANCE = new ProtoEnumFlags();
    }

    private ProtoEnumFlags() {
    }

    public final ClassKind classKind(ProtoBuf$Class.Kind r2) {
        if (r2 != null) goto L4;
        int r3 = -1;
    L5:
        switch(r3) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L15;
            default: goto L14;
        };
    L14:
        return ClassKind.CLASS;
    L15:
        return ClassKind.OBJECT;
    L16:
        return ClassKind.ANNOTATION_CLASS;
    L17:
        return ClassKind.ENUM_ENTRY;
    L18:
        return ClassKind.ENUM_CLASS;
    L19:
        return ClassKind.INTERFACE;
    L13:
        return ClassKind.CLASS;
    L4:
        r3 = WhenMappings.$EnumSwitchMapping$3[r2.ordinal()];
        goto L5
    }

    public final Modality modality(ProtoBuf$Modality r2) {
        if (r2 != null) goto L4;
        int r3 = -1;
    L6:
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L21;
        if (r3 == 4) goto L20;
        return Modality.FINAL;
    L20:
        return Modality.SEALED;
    L21:
        return Modality.ABSTRACT;
    L22:
        return Modality.OPEN;
    L18:
        return Modality.FINAL;
    L4:
        r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        goto L6
    }

    public final Variance variance(ProtoBuf$Type.Argument.Projection r4) {
        Intrinsics.checkNotNullParameter(r4, "projection");
        int r0 = WhenMappings.$EnumSwitchMapping$6[r4.ordinal()];
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        if (r0 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + r4);
    L18:
        return Variance.INVARIANT;
    L19:
        return Variance.OUT_VARIANCE;
    L17:
        return Variance.IN_VARIANCE;
    }

    public final Variance variance(ProtoBuf$TypeParameter.Variance r2) {
        Intrinsics.checkNotNullParameter(r2, "variance");
        int r3 = WhenMappings.$EnumSwitchMapping$5[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return Variance.INVARIANT;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return Variance.OUT_VARIANCE;
    L13:
        return Variance.IN_VARIANCE;
    }
}
