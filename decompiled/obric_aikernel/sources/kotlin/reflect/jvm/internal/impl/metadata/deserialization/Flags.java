package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* JADX INFO: loaded from: classes3.dex */
public class Flags {
    public static final FlagField<ProtoBuf.Class.Kind> CLASS_KIND = null;
    public static final BooleanFlagField DECLARES_DEFAULT_VALUE = null;
    public static final BooleanFlagField DEFINITELY_NOT_NULL_TYPE = null;
    public static final BooleanFlagField HAS_ANNOTATIONS = null;
    public static final BooleanFlagField HAS_CONSTANT = null;
    public static final BooleanFlagField HAS_GETTER = null;
    public static final BooleanFlagField HAS_SETTER = null;
    public static final BooleanFlagField IS_CONST = null;
    public static final BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = null;
    public static final BooleanFlagField IS_CROSSINLINE = null;
    public static final BooleanFlagField IS_DATA = null;
    public static final BooleanFlagField IS_DELEGATED = null;
    public static final BooleanFlagField IS_EXPECT_CLASS = null;
    public static final BooleanFlagField IS_EXPECT_FUNCTION = null;
    public static final BooleanFlagField IS_EXPECT_PROPERTY = null;
    public static final BooleanFlagField IS_EXTERNAL_ACCESSOR = null;
    public static final BooleanFlagField IS_EXTERNAL_CLASS = null;
    public static final BooleanFlagField IS_EXTERNAL_FUNCTION = null;
    public static final BooleanFlagField IS_EXTERNAL_PROPERTY = null;
    public static final BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = null;
    public static final BooleanFlagField IS_FUN_INTERFACE = null;
    public static final BooleanFlagField IS_INFIX = null;
    public static final BooleanFlagField IS_INLINE = null;
    public static final BooleanFlagField IS_INLINE_ACCESSOR = null;
    public static final BooleanFlagField IS_INNER = null;
    public static final BooleanFlagField IS_LATEINIT = null;
    public static final BooleanFlagField IS_NEGATED = null;
    public static final BooleanFlagField IS_NOINLINE = null;
    public static final BooleanFlagField IS_NOT_DEFAULT = null;
    public static final BooleanFlagField IS_NULL_CHECK_PREDICATE = null;
    public static final BooleanFlagField IS_OPERATOR = null;
    public static final BooleanFlagField IS_SECONDARY = null;
    public static final BooleanFlagField IS_SUSPEND = null;
    public static final BooleanFlagField IS_TAILREC = null;
    public static final BooleanFlagField IS_UNSIGNED = null;
    public static final BooleanFlagField IS_VALUE_CLASS = null;
    public static final BooleanFlagField IS_VAR = null;
    public static final FlagField<ProtoBuf.MemberKind> MEMBER_KIND = null;
    public static final FlagField<ProtoBuf.Modality> MODALITY = null;
    public static final BooleanFlagField SUSPEND_TYPE = null;
    public static final FlagField<ProtoBuf.Visibility> VISIBILITY = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class BooleanFlagField extends FlagField<Boolean> {
        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"}));
        }

        public BooleanFlagField(int r10) {
            super(r10, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public Boolean get(int r10) {
            boolean r11 = true;
            if (((1 << this.offset) & r10) != 0) goto L6;
            r11 = false;
        L6:
            Boolean r12 = Boolean.valueOf(r11);
            if (r12 != null) goto L9;
            $$$reportNull$$$0(0);
        L9:
            return r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ Boolean get(int r10) {
            return get(r10);
        }

        /* JADX INFO: renamed from: toFlags, reason: avoid collision after fix types in other method */
        public int toFlags2(Boolean r10) {
            if (r10.booleanValue() == true) goto L7;
            return 0;
        L7:
            return 1 << this.offset;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Boolean r10) {
            return toFlags2(r10);
        }
    }

    private static class EnumLiteFlagField<E extends Internal.EnumLite> extends FlagField<E> {
        private final E[] values;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"}));
        }

        public EnumLiteFlagField(int r10, E[] r11) {
            super(r10, bitWidth(r11), null);
            this.values = r11;
        }

        private static <E> int bitWidth(E[] r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            int r11 = r10.length - 1;
            if (r11 != 0) goto L7;
            return 1;
        L7:
            int r12 = 31;
        L8:
            if (r12 < 0) goto L15;
            if (((1 << r12) & r11) != 0) goto L12;
            r12 = r12 - 1;
            goto L8
        L12:
            return r12 + 1;
        L15:
            throw new IllegalStateException("Empty enum: " + r10.getClass());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public E get(int r10) {
            int r11 = (1 << this.bitWidth) - 1;
            int r12 = this.offset;
            int r13 = (r10 & (r11 << r12)) >> r12;
            E[] r14 = this.values;
            int r15 = r14.length;
            int r16 = 0;
        L3:
            if (r16 >= r15) goto L8;
            E r17 = r14[r16];
            if (r17.getNumber() == r13) goto L6;
            r16 = r16 + 1;
            goto L3
        L6:
            return r17;
        L8:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Object r10) {
            return toFlags((Internal.EnumLite) r10);
        }

        public int toFlags(E r10) {
            return r10.getNumber() << this.offset;
        }
    }

    public static abstract class FlagField<E> {
        public final int bitWidth;
        public final int offset;

        private FlagField(int r10, int r11) {
            this.offset = r10;
            this.bitWidth = r11;
        }

        /* synthetic */ FlagField(int r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$EnumLite;>(Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<*>;[TE;)Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<TE;>; */
        public static FlagField after(FlagField r10, Internal.EnumLite[] r11) {
            return new EnumLiteFlagField(r10.offset + r10.bitWidth, r11);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> r10) {
            return new BooleanFlagField(r10.offset + r10.bitWidth);
        }

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public abstract E get(int r10);

        public abstract int toFlags(E r10);
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        if (r10 == 1) goto L18;
        if (r10 != 2) goto L6;
        r11[0] = "kind";
    L19:
        r11[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch(r10) {
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L24;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L23;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L22;
            default: goto L21;
        };
    L21:
        r11[2] = "getClassFlags";
    L27:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L22:
        r11[2] = "getAccessorFlags";
        goto L27
    L23:
        r11[2] = "getPropertyFlags";
        goto L27
    L24:
        r11[2] = "getFunctionFlags";
        goto L27
    L25:
        r11[2] = "getConstructorFlags";
        goto L27
    L6:
        if (r10 == 5) goto L18;
        if (r10 != 6) goto L10;
    L16:
        r11[0] = "memberKind";
        goto L19
    L10:
        if (r10 == 8) goto L18;
        if (r10 == 9) goto L16;
        if (r10 == 11) goto L18;
        r11[0] = "visibility";
    L18:
        r11[0] = "modality";
        goto L19
    }

    static {
        BooleanFlagField r10 = FlagField.booleanFirst();
        SUSPEND_TYPE = r10;
        DEFINITELY_NOT_NULL_TYPE = FlagField.booleanAfter(r10);
        BooleanFlagField r11 = FlagField.booleanFirst();
        HAS_ANNOTATIONS = r11;
        FlagField<ProtoBuf.Visibility> r12 = FlagField.after(r11, ProtoBuf.Visibility.values());
        VISIBILITY = r12;
        FlagField<ProtoBuf.Modality> r13 = FlagField.after(r12, ProtoBuf.Modality.values());
        MODALITY = r13;
        FlagField<ProtoBuf.Class.Kind> r14 = FlagField.after(r13, ProtoBuf.Class.Kind.values());
        CLASS_KIND = r14;
        BooleanFlagField r15 = FlagField.booleanAfter(r14);
        IS_INNER = r15;
        BooleanFlagField r16 = FlagField.booleanAfter(r15);
        IS_DATA = r16;
        BooleanFlagField r17 = FlagField.booleanAfter(r16);
        IS_EXTERNAL_CLASS = r17;
        BooleanFlagField r18 = FlagField.booleanAfter(r17);
        IS_EXPECT_CLASS = r18;
        BooleanFlagField r19 = FlagField.booleanAfter(r18);
        IS_VALUE_CLASS = r19;
        IS_FUN_INTERFACE = FlagField.booleanAfter(r19);
        BooleanFlagField r20 = FlagField.booleanAfter(r12);
        IS_SECONDARY = r20;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(r20);
        FlagField<ProtoBuf.MemberKind> r21 = FlagField.after(r13, ProtoBuf.MemberKind.values());
        MEMBER_KIND = r21;
        BooleanFlagField r22 = FlagField.booleanAfter(r21);
        IS_OPERATOR = r22;
        BooleanFlagField r23 = FlagField.booleanAfter(r22);
        IS_INFIX = r23;
        BooleanFlagField r24 = FlagField.booleanAfter(r23);
        IS_INLINE = r24;
        BooleanFlagField r25 = FlagField.booleanAfter(r24);
        IS_TAILREC = r25;
        BooleanFlagField r26 = FlagField.booleanAfter(r25);
        IS_EXTERNAL_FUNCTION = r26;
        BooleanFlagField r27 = FlagField.booleanAfter(r26);
        IS_SUSPEND = r27;
        BooleanFlagField r28 = FlagField.booleanAfter(r27);
        IS_EXPECT_FUNCTION = r28;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(r28);
        BooleanFlagField r29 = FlagField.booleanAfter(r21);
        IS_VAR = r29;
        BooleanFlagField r30 = FlagField.booleanAfter(r29);
        HAS_GETTER = r30;
        BooleanFlagField r31 = FlagField.booleanAfter(r30);
        HAS_SETTER = r31;
        BooleanFlagField r32 = FlagField.booleanAfter(r31);
        IS_CONST = r32;
        BooleanFlagField r33 = FlagField.booleanAfter(r32);
        IS_LATEINIT = r33;
        BooleanFlagField r34 = FlagField.booleanAfter(r33);
        HAS_CONSTANT = r34;
        BooleanFlagField r35 = FlagField.booleanAfter(r34);
        IS_EXTERNAL_PROPERTY = r35;
        BooleanFlagField r36 = FlagField.booleanAfter(r35);
        IS_DELEGATED = r36;
        IS_EXPECT_PROPERTY = FlagField.booleanAfter(r36);
        BooleanFlagField r37 = FlagField.booleanAfter(r11);
        DECLARES_DEFAULT_VALUE = r37;
        BooleanFlagField r38 = FlagField.booleanAfter(r37);
        IS_CROSSINLINE = r38;
        IS_NOINLINE = FlagField.booleanAfter(r38);
        BooleanFlagField r39 = FlagField.booleanAfter(r13);
        IS_NOT_DEFAULT = r39;
        BooleanFlagField r40 = FlagField.booleanAfter(r39);
        IS_EXTERNAL_ACCESSOR = r40;
        IS_INLINE_ACCESSOR = FlagField.booleanAfter(r40);
        BooleanFlagField r41 = FlagField.booleanFirst();
        IS_NEGATED = r41;
        IS_NULL_CHECK_PREDICATE = FlagField.booleanAfter(r41);
        IS_UNSIGNED = FlagField.booleanFirst();
    }

    public static int getAccessorFlags(boolean r10, ProtoBuf.Visibility r11, ProtoBuf.Modality r12, boolean r13, boolean r14, boolean r15) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r12 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        return ((((HAS_ANNOTATIONS.toFlags2(Boolean.valueOf(r10)) | MODALITY.toFlags(r12)) | VISIBILITY.toFlags(r11)) | IS_NOT_DEFAULT.toFlags2(Boolean.valueOf(r13))) | IS_EXTERNAL_ACCESSOR.toFlags2(Boolean.valueOf(r14))) | IS_INLINE_ACCESSOR.toFlags2(Boolean.valueOf(r15));
    }
}
