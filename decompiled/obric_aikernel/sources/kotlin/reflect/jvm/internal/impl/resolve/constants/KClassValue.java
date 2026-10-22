package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
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
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final ConstantValue<?> create(KotlinType r10) {
            Intrinsics.checkNotNullParameter(r10, "argumentType");
            if (KotlinTypeKt.isError(r10) == false) goto L5;
            return null;
        L5:
            int r11 = 0;
            KotlinType r12 = r10;
        L7:
            if (KotlinBuiltIns.isArray(r12) == false) goto L9;
            r12 = ((TypeProjection) CollectionsKt.single(r12.getArguments())).getType();
            Intrinsics.checkNotNullExpressionValue(r12, "type.arguments.single().type");
            r11 = r11 + 1;
            goto L7
        L9:
            ClassifierDescriptor r13 = r12.getConstructor().mo1323getDeclarationDescriptor();
            if ((r13 instanceof ClassDescriptor) == false) goto L17;
            ClassId r14 = DescriptorUtilsKt.getClassId(r13);
            if (r14 != null) goto L21;
            return new KClassValue(new Value.LocalClass(r10));
        L21:
            return new KClassValue(r14, r11);
        L17:
            if ((r13 instanceof TypeParameterDescriptor) == false) goto L22;
            ClassId r15 = ClassId.topLevel(StandardNames.FqNames.any.toSafe());
            Intrinsics.checkNotNullExpressionValue(r15, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new KClassValue(r15, 0);
        L22:
            return null;
        }
    }

    public static abstract class Value {

        public static final class LocalClass extends Value {
            private final KotlinType type;

            public LocalClass(KotlinType r10) {
                Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
                super(null);
                this.type = r10;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof LocalClass) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.type, ((LocalClass) r10).type) == true) goto L11;
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

            public NormalClass(ClassLiteralValue r10) {
                Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
                super(null);
                this.value = r10;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof NormalClass) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.value, ((NormalClass) r10).value) == true) goto L11;
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

        private Value() {
        }

        public /* synthetic */ Value(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KClassValue(ClassId r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        this(new ClassLiteralValue(r10, r11));
    }

    public KClassValue(ClassLiteralValue r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        this(new Value.NormalClass(r10));
    }

    public KClassValue(Value r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        super(r10);
    }

    public final KotlinType getArgumentType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        Value r11 = getValue();
        if ((r11 instanceof Value.LocalClass) == false) goto L7;
        return ((Value.LocalClass) getValue()).getType();
    L7:
        if ((r11 instanceof Value.NormalClass) == false) goto L17;
        ClassLiteralValue r12 = ((Value.NormalClass) getValue()).getValue();
        ClassId r13 = r12.component1();
        int r14 = r12.component2();
        ClassDescriptor r15 = FindClassInModuleKt.findClassAcrossModuleDependencies(r10, r13);
        int r16 = 0;
        if (r15 != null) goto L12;
        ErrorTypeKind r17 = ErrorTypeKind.UNRESOLVED_KCLASS_CONSTANT_VALUE;
        String r18 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "classId.toString()");
        return ErrorUtils.createErrorType(r17, new String[]{r18, String.valueOf(r14)});
    L12:
        SimpleType r19 = r15.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r19, "descriptor.defaultType");
        KotlinType r20 = TypeUtilsKt.replaceArgumentsWithStarProjections(r19);
    L13:
        if (r16 >= r14) goto L15;
        r20 = r10.getBuiltIns().getArrayType(Variance.INVARIANT, r20);
        Intrinsics.checkNotNullExpressionValue(r20, "module.builtIns.getArray…Variance.INVARIANT, type)");
        r16 = r16 + 1;
        goto L13
    L15:
        return r20;
    L17:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        TypeAttributes r11 = TypeAttributes.Companion.getEmpty();
        ClassDescriptor r12 = r10.getBuiltIns().getKClass();
        Intrinsics.checkNotNullExpressionValue(r12, "module.builtIns.kClass");
        return KotlinTypeFactory.simpleNotNullType(r11, r12, CollectionsKt.listOf(new TypeProjectionImpl(getArgumentType(r10))));
    }
}
