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
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BooleanFlagField extends FlagField<Boolean> {
        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            throw new IllegalStateException("@NotNull method kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField.get must not return null");
        }

        public BooleanFlagField(int r5) {
            super(r5, 1, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ Boolean get(int r5) {
            return get(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Boolean r5) {
            return toFlags2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public Boolean get(int r5) {
            boolean r10 = true;
            if (((1 << this.offset) & r5) != 0) goto L7;
            r10 = false;
        L7:
            return Boolean.valueOf(r10);
        }

        /* JADX INFO: renamed from: toFlags, reason: avoid collision after fix types in other method */
        public int toFlags2(Boolean r5) {
            if (r5.booleanValue() == true) goto L7;
            return 0;
        L7:
            return 1 << this.offset;
        }
    }

    public static class EnumLiteFlagField<E extends Internal.EnumLite> extends FlagField<E> {
        private final E[] values;

        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'enumEntries' of kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField.bitWidth must not be null");
        }

        public EnumLiteFlagField(int r5, E[] r10) {
            super(r5, bitWidth(r10), null);
            this.values = r10;
        }

        private static <E> int bitWidth(E[] r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            int r10 = r5.length - 1;
            if (r10 != 0) goto L7;
            return 1;
        L7:
            int r11 = 31;
        L8:
            if (r11 < 0) goto L15;
            if (((1 << r11) & r10) != 0) goto L12;
            r11 = r11 - 1;
            goto L8
        L12:
            return r11 + 1;
        L15:
            throw new IllegalStateException("Empty enum: " + r5.getClass());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ Object get(int r5) {
            return get(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Object r5) {
            return toFlags((Internal.EnumLite) r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public E get(int r5) {
            int r10 = (1 << this.bitWidth) - 1;
            int r11 = this.offset;
            int r12 = (r5 & (r10 << r11)) >> r11;
            E[] r13 = this.values;
            int r14 = r13.length;
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L8;
            E r16 = r13[r15];
            if (r16.getNumber() == r12) goto L6;
            r15 = r15 + 1;
            goto L3
        L6:
            return r16;
        L8:
            return null;
        }

        public int toFlags(E r5) {
            return r5.getNumber() << this.offset;
        }
    }

    public static abstract class FlagField<E> {
        public final int bitWidth;
        public final int offset;

        public /* synthetic */ FlagField(int r5, int r10, AnonymousClass1 r11) {
            this(r5, r10);
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$EnumLite;>(Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<*>;[TE;)Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<TE;>; */
        public static FlagField after(FlagField r5, Internal.EnumLite[] r10) {
            return new EnumLiteFlagField(r5.offset + r5.bitWidth, r10);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> r5) {
            return new BooleanFlagField(r5.offset + r5.bitWidth);
        }

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public abstract E get(int r5);

        public abstract int toFlags(E r5);

        private FlagField(int r5, int r10) {
            this.offset = r5;
            this.bitWidth = r10;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r5) {
        Object[] r10 = new Object[3];
        if (r5 == 1) goto L18;
        if (r5 != 2) goto L6;
        r10[0] = "kind";
    L19:
        r10[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch(r5) {
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
        r10[2] = "getClassFlags";
    L27:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r10));
    L22:
        r10[2] = "getAccessorFlags";
        goto L27
    L23:
        r10[2] = "getPropertyFlags";
        goto L27
    L24:
        r10[2] = "getFunctionFlags";
        goto L27
    L25:
        r10[2] = "getConstructorFlags";
        goto L27
    L6:
        if (r5 == 5) goto L18;
        if (r5 != 6) goto L10;
    L16:
        r10[0] = "memberKind";
        goto L19
    L10:
        if (r5 == 8) goto L18;
        if (r5 == 9) goto L16;
        if (r5 == 11) goto L18;
        r10[0] = "visibility";
    L18:
        r10[0] = "modality";
        goto L19
    }

    static {
        BooleanFlagField r5 = FlagField.booleanFirst();
        SUSPEND_TYPE = r5;
        DEFINITELY_NOT_NULL_TYPE = FlagField.booleanAfter(r5);
        BooleanFlagField r10 = FlagField.booleanFirst();
        HAS_ANNOTATIONS = r10;
        FlagField<ProtoBuf.Visibility> r11 = FlagField.after(r10, ProtoBuf.Visibility.values());
        VISIBILITY = r11;
        FlagField<ProtoBuf.Modality> r12 = FlagField.after(r11, ProtoBuf.Modality.values());
        MODALITY = r12;
        FlagField<ProtoBuf.Class.Kind> r13 = FlagField.after(r12, ProtoBuf.Class.Kind.values());
        CLASS_KIND = r13;
        BooleanFlagField r14 = FlagField.booleanAfter(r13);
        IS_INNER = r14;
        BooleanFlagField r15 = FlagField.booleanAfter(r14);
        IS_DATA = r15;
        BooleanFlagField r16 = FlagField.booleanAfter(r15);
        IS_EXTERNAL_CLASS = r16;
        BooleanFlagField r17 = FlagField.booleanAfter(r16);
        IS_EXPECT_CLASS = r17;
        BooleanFlagField r18 = FlagField.booleanAfter(r17);
        IS_VALUE_CLASS = r18;
        IS_FUN_INTERFACE = FlagField.booleanAfter(r18);
        BooleanFlagField r19 = FlagField.booleanAfter(r11);
        IS_SECONDARY = r19;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(r19);
        FlagField<ProtoBuf.MemberKind> r20 = FlagField.after(r12, ProtoBuf.MemberKind.values());
        MEMBER_KIND = r20;
        BooleanFlagField r21 = FlagField.booleanAfter(r20);
        IS_OPERATOR = r21;
        BooleanFlagField r22 = FlagField.booleanAfter(r21);
        IS_INFIX = r22;
        BooleanFlagField r23 = FlagField.booleanAfter(r22);
        IS_INLINE = r23;
        BooleanFlagField r24 = FlagField.booleanAfter(r23);
        IS_TAILREC = r24;
        BooleanFlagField r25 = FlagField.booleanAfter(r24);
        IS_EXTERNAL_FUNCTION = r25;
        BooleanFlagField r26 = FlagField.booleanAfter(r25);
        IS_SUSPEND = r26;
        BooleanFlagField r27 = FlagField.booleanAfter(r26);
        IS_EXPECT_FUNCTION = r27;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(r27);
        BooleanFlagField r28 = FlagField.booleanAfter(r20);
        IS_VAR = r28;
        BooleanFlagField r29 = FlagField.booleanAfter(r28);
        HAS_GETTER = r29;
        BooleanFlagField r30 = FlagField.booleanAfter(r29);
        HAS_SETTER = r30;
        BooleanFlagField r31 = FlagField.booleanAfter(r30);
        IS_CONST = r31;
        BooleanFlagField r32 = FlagField.booleanAfter(r31);
        IS_LATEINIT = r32;
        BooleanFlagField r33 = FlagField.booleanAfter(r32);
        HAS_CONSTANT = r33;
        BooleanFlagField r34 = FlagField.booleanAfter(r33);
        IS_EXTERNAL_PROPERTY = r34;
        BooleanFlagField r35 = FlagField.booleanAfter(r34);
        IS_DELEGATED = r35;
        IS_EXPECT_PROPERTY = FlagField.booleanAfter(r35);
        BooleanFlagField r36 = FlagField.booleanAfter(r10);
        DECLARES_DEFAULT_VALUE = r36;
        BooleanFlagField r37 = FlagField.booleanAfter(r36);
        IS_CROSSINLINE = r37;
        IS_NOINLINE = FlagField.booleanAfter(r37);
        BooleanFlagField r38 = FlagField.booleanAfter(r12);
        IS_NOT_DEFAULT = r38;
        BooleanFlagField r39 = FlagField.booleanAfter(r38);
        IS_EXTERNAL_ACCESSOR = r39;
        IS_INLINE_ACCESSOR = FlagField.booleanAfter(r39);
        BooleanFlagField r40 = FlagField.booleanFirst();
        IS_NEGATED = r40;
        IS_NULL_CHECK_PREDICATE = FlagField.booleanAfter(r40);
        IS_UNSIGNED = FlagField.booleanFirst();
    }

    public static int getAccessorFlags(boolean r5, ProtoBuf.Visibility r10, ProtoBuf.Modality r11, boolean r12, boolean r13, boolean r14) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        return ((((HAS_ANNOTATIONS.toFlags2(Boolean.valueOf(r5)) | MODALITY.toFlags(r11)) | VISIBILITY.toFlags(r10)) | IS_NOT_DEFAULT.toFlags2(Boolean.valueOf(r12))) | IS_EXTERNAL_ACCESSOR.toFlags2(Boolean.valueOf(r13))) | IS_INLINE_ACCESSOR.toFlags2(Boolean.valueOf(r14));
    }
}
