package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class KClassValue extends ConstantValue<Value> {
    public static final Companion Companion = null;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final ConstantValue<?> create(KotlinType r5) {
            Intrinsics.checkNotNullParameter(r5, "argumentType");
            if (KotlinTypeKt.isError(r5) == false) goto L5;
            return null;
        L5:
            int r10 = 0;
            KotlinType r11 = r5;
        L7:
            if (KotlinBuiltIns.isArray(r11) == false) goto L9;
            r11 = ((TypeProjection) CollectionsKt.single(r11.getArguments())).getType();
            r10 = r10 + 1;
            goto L7
        L9:
            ClassifierDescriptor r12 = r11.getConstructor().mo1402getDeclarationDescriptor();
            if ((r12 instanceof ClassDescriptor) == false) goto L17;
            ClassId r13 = DescriptorUtilsKt.getClassId(r12);
            if (r13 != null) goto L21;
            return new KClassValue(new Value.LocalClass(r5));
        L21:
            return new KClassValue(r13, r10);
        L17:
            if ((r12 instanceof TypeParameterDescriptor) == true) goto L19;
            return null;
        L19:
            return new KClassValue(ClassId.topLevel(StandardNames.FqNames.any.toSafe()), 0);
        }

        private Companion() {
        }
    }

    public static abstract class Value {

        public static final class LocalClass extends Value {
            private final KotlinType type;

            public LocalClass(KotlinType r5) {
                Intrinsics.checkNotNullParameter(r5, "type");
                super(null);
                this.type = r5;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof LocalClass) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.type, ((LocalClass) r5).type) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final KotlinType getType() {
                return this.type;
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.type + ')';
            }
        }

        public static final class NormalClass extends Value {
            private final ClassLiteralValue value;

            public NormalClass(ClassLiteralValue r5) {
                Intrinsics.checkNotNullParameter(r5, "value");
                super(null);
                this.value = r5;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof NormalClass) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.value, ((NormalClass) r5).value) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int getArrayDimensions() {
                return this.value.getArrayNestedness();
            }

            public final ClassId getClassId() {
                return this.value.getClassId();
            }

            public final ClassLiteralValue getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.value + ')';
            }
        }

        public /* synthetic */ Value(DefaultConstructorMarker r5) {
            this();
        }

        private Value() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KClassValue(Value r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        super(r5);
    }

    public final KotlinType getArgumentType(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "module");
        Value r10 = getValue();
        if ((r10 instanceof Value.LocalClass) == false) goto L7;
        return ((Value.LocalClass) getValue()).getType();
    L7:
        if ((r10 instanceof Value.NormalClass) == false) goto L17;
        ClassLiteralValue r11 = ((Value.NormalClass) getValue()).getValue();
        ClassId r12 = r11.component1();
        int r13 = r11.component2();
        ClassDescriptor r14 = FindClassInModuleKt.findClassAcrossModuleDependencies(r5, r12);
        if (r14 == null) goto L11;
        KotlinType r15 = TypeUtilsKt.replaceArgumentsWithStarProjections(r14.getDefaultType());
        int r16 = 0;
    L13:
        if (r16 >= r13) goto L15;
        r15 = r5.getBuiltIns().getArrayType(Variance.INVARIANT, r15);
        r16 = r16 + 1;
        goto L13
    L15:
        return r15;
    L11:
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_KCLASS_CONSTANT_VALUE, new String[]{r12.toString(), String.valueOf(r13)});
    L17:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "module");
        return KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), r5.getBuiltIns().getKClass(), CollectionsKt.listOf(new TypeProjectionImpl(getArgumentType(r5))));
    }

    public KClassValue(ClassLiteralValue r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        this(new Value.NormalClass(r5));
    }

    public KClassValue(ClassId r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        this(new ClassLiteralValue(r5, r10));
    }
}
