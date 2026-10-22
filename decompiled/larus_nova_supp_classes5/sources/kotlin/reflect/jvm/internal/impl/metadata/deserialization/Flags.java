package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Flags {
    public static final FlagField<ProtoBuf$Class.Kind> CLASS_KIND = null;
    public static final BooleanFlagField DECLARES_DEFAULT_VALUE = null;
    public static final BooleanFlagField DEFINITELY_NOT_NULL_TYPE = null;
    public static final BooleanFlagField HAS_ANNOTATIONS = null;
    public static final BooleanFlagField HAS_CONSTANT = null;
    public static final BooleanFlagField HAS_ENUM_ENTRIES = null;
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
    public static final FlagField<ProtoBuf$MemberKind> MEMBER_KIND = null;
    public static final FlagField<ProtoBuf$Modality> MODALITY = null;
    public static final BooleanFlagField SUSPEND_TYPE = null;
    public static final FlagField<ProtoBuf$Visibility> VISIBILITY = null;

    public static class BooleanFlagField extends FlagField<Boolean> {
        private static /* synthetic */ void $$$reportNull$$$0(int r2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"}));
        }

        public BooleanFlagField(int r3) {
            super(r3, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public Boolean get(int r3) {
            boolean r1 = true;
            if ((r3 & (1 << this.offset)) != 0) goto L6;
            r1 = false;
        L6:
            Boolean r4 = Boolean.valueOf(r1);
            if (r4 != null) goto L9;
            $$$reportNull$$$0(0);
        L9:
            return r4;
        }

        /* JADX INFO: renamed from: toFlags, reason: avoid collision after fix types in other method */
        public int toFlags2(Boolean r2) {
            if (r2.booleanValue() == true) goto L7;
            return 0;
        L7:
            return 1 << this.offset;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ Boolean get(int r1) {
            return get(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Boolean r1) {
            return toFlags2(r1);
        }
    }

    public static class EnumLiteFlagField<E extends Internal$EnumLite> extends FlagField<E> {
        private final E[] values;

        private static /* synthetic */ void $$$reportNull$$$0(int r2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"}));
        }

        private static <E> int bitWidth(E[] r4) {
            if (r4 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            int r0 = r4.length - 1;
            if (r0 != 0) goto L7;
            return 1;
        L7:
            int r2 = 31;
        L8:
            if (r2 < 0) goto L15;
            if (((1 << r2) & r0) != 0) goto L12;
            r2 = r2 - 1;
            goto L8
        L12:
            return r2 + 1;
        L15:
            throw new IllegalStateException("Empty enum: " + r4.getClass());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public E get(int r6) {
            int r0 = (1 << this.bitWidth) - 1;
            int r1 = this.offset;
            int r7 = (r6 & (r0 << r1)) >> r1;
            E[] r2 = this.values;
            int r3 = r2.length;
            int r4 = 0;
        L3:
            if (r4 >= r3) goto L8;
            E r5 = r2[r4];
            if (r5.getNumber() == r7) goto L6;
            r4 = r4 + 1;
            goto L3
        L6:
            return r5;
        L8:
            return null;
        }

        public int toFlags(E r2) {
            return r2.getNumber() << this.offset;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Object r1) {
            return toFlags((Internal$EnumLite) r1);
        }

        public EnumLiteFlagField(int r3, E[] r4) {
            super(r3, bitWidth(r4), null);
            this.values = r4;
        }
    }

    public static abstract class FlagField<E> {
        public final int bitWidth;
        public final int offset;

        public abstract E get(int r1);

        public abstract int toFlags(E r1);

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> r1) {
            return new BooleanFlagField(r1.offset + r1.bitWidth);
        }

        private FlagField(int r1, int r2) {
            this.offset = r1;
            this.bitWidth = r2;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$EnumLite;>(Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<*>;[TE;)Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<TE;>; */
        public static FlagField after(FlagField r1, Internal$EnumLite[] r2) {
            return new EnumLiteFlagField(r1.offset + r1.bitWidth, r2);
        }

        public /* synthetic */ FlagField(int r1, int r2, 1 r3) {
            this(r1, r2);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r5) {
        Object[] r0 = new Object[3];
        if (r5 == 1) goto L18;
        if (r5 != 2) goto L6;
        r0[0] = "kind";
    L19:
        r0[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
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
        r0[2] = "getClassFlags";
    L27:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L22:
        r0[2] = "getAccessorFlags";
        goto L27
    L23:
        r0[2] = "getPropertyFlags";
        goto L27
    L24:
        r0[2] = "getFunctionFlags";
        goto L27
    L25:
        r0[2] = "getConstructorFlags";
        goto L27
    L6:
        if (r5 == 5) goto L18;
        if (r5 != 6) goto L10;
    L16:
        r0[0] = "memberKind";
        goto L19
    L10:
        if (r5 == 8) goto L18;
        if (r5 == 9) goto L16;
        if (r5 == 11) goto L18;
        r0[0] = "visibility";
    L18:
        r0[0] = "modality";
        goto L19
    }

    static {
        BooleanFlagField r0 = FlagField.booleanFirst();
        SUSPEND_TYPE = r0;
        DEFINITELY_NOT_NULL_TYPE = FlagField.booleanAfter(r0);
        BooleanFlagField r1 = FlagField.booleanFirst();
        HAS_ANNOTATIONS = r1;
        FlagField<ProtoBuf$Visibility> r2 = FlagField.after(r1, ProtoBuf$Visibility.values());
        VISIBILITY = r2;
        FlagField<ProtoBuf$Modality> r3 = FlagField.after(r2, ProtoBuf$Modality.values());
        MODALITY = r3;
        FlagField<ProtoBuf$Class.Kind> r4 = FlagField.after(r3, ProtoBuf$Class.Kind.values());
        CLASS_KIND = r4;
        BooleanFlagField r5 = FlagField.booleanAfter(r4);
        IS_INNER = r5;
        BooleanFlagField r6 = FlagField.booleanAfter(r5);
        IS_DATA = r6;
        BooleanFlagField r7 = FlagField.booleanAfter(r6);
        IS_EXTERNAL_CLASS = r7;
        BooleanFlagField r8 = FlagField.booleanAfter(r7);
        IS_EXPECT_CLASS = r8;
        BooleanFlagField r9 = FlagField.booleanAfter(r8);
        IS_VALUE_CLASS = r9;
        BooleanFlagField r10 = FlagField.booleanAfter(r9);
        IS_FUN_INTERFACE = r10;
        HAS_ENUM_ENTRIES = FlagField.booleanAfter(r10);
        BooleanFlagField r11 = FlagField.booleanAfter(r2);
        IS_SECONDARY = r11;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(r11);
        FlagField<ProtoBuf$MemberKind> r12 = FlagField.after(r3, ProtoBuf$MemberKind.values());
        MEMBER_KIND = r12;
        BooleanFlagField r13 = FlagField.booleanAfter(r12);
        IS_OPERATOR = r13;
        BooleanFlagField r14 = FlagField.booleanAfter(r13);
        IS_INFIX = r14;
        BooleanFlagField r15 = FlagField.booleanAfter(r14);
        IS_INLINE = r15;
        BooleanFlagField r16 = FlagField.booleanAfter(r15);
        IS_TAILREC = r16;
        BooleanFlagField r17 = FlagField.booleanAfter(r16);
        IS_EXTERNAL_FUNCTION = r17;
        BooleanFlagField r18 = FlagField.booleanAfter(r17);
        IS_SUSPEND = r18;
        BooleanFlagField r19 = FlagField.booleanAfter(r18);
        IS_EXPECT_FUNCTION = r19;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(r19);
        BooleanFlagField r20 = FlagField.booleanAfter(r12);
        IS_VAR = r20;
        BooleanFlagField r21 = FlagField.booleanAfter(r20);
        HAS_GETTER = r21;
        BooleanFlagField r22 = FlagField.booleanAfter(r21);
        HAS_SETTER = r22;
        BooleanFlagField r23 = FlagField.booleanAfter(r22);
        IS_CONST = r23;
        BooleanFlagField r24 = FlagField.booleanAfter(r23);
        IS_LATEINIT = r24;
        BooleanFlagField r25 = FlagField.booleanAfter(r24);
        HAS_CONSTANT = r25;
        BooleanFlagField r26 = FlagField.booleanAfter(r25);
        IS_EXTERNAL_PROPERTY = r26;
        BooleanFlagField r27 = FlagField.booleanAfter(r26);
        IS_DELEGATED = r27;
        IS_EXPECT_PROPERTY = FlagField.booleanAfter(r27);
        BooleanFlagField r28 = FlagField.booleanAfter(r1);
        DECLARES_DEFAULT_VALUE = r28;
        BooleanFlagField r29 = FlagField.booleanAfter(r28);
        IS_CROSSINLINE = r29;
        IS_NOINLINE = FlagField.booleanAfter(r29);
        BooleanFlagField r30 = FlagField.booleanAfter(r3);
        IS_NOT_DEFAULT = r30;
        BooleanFlagField r31 = FlagField.booleanAfter(r30);
        IS_EXTERNAL_ACCESSOR = r31;
        IS_INLINE_ACCESSOR = FlagField.booleanAfter(r31);
        BooleanFlagField r32 = FlagField.booleanFirst();
        IS_NEGATED = r32;
        IS_NULL_CHECK_PREDICATE = FlagField.booleanAfter(r32);
        IS_UNSIGNED = FlagField.booleanFirst();
    }

    public static int getAccessorFlags(boolean r1, ProtoBuf$Visibility r2, ProtoBuf$Modality r3, boolean r4, boolean r5, boolean r6) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        return ((((HAS_ANNOTATIONS.toFlags2(Boolean.valueOf(r1)) | MODALITY.toFlags(r3)) | VISIBILITY.toFlags(r2)) | IS_NOT_DEFAULT.toFlags2(Boolean.valueOf(r4))) | IS_EXTERNAL_ACCESSOR.toFlags2(Boolean.valueOf(r5))) | IS_INLINE_ACCESSOR.toFlags2(Boolean.valueOf(r6));
    }
}
