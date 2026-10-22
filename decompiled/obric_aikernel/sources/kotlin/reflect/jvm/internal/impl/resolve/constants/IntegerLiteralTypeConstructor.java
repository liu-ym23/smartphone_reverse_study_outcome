package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public static final Companion Companion = null;
    private final ModuleDescriptor module;
    private final Set<KotlinType> possibleTypes;
    private final Lazy supertypes$delegate;
    private final SimpleType type;
    private final long value;

    public static final class Companion {

        private static final enum Mode extends Enum<Mode> {
            private static final /* synthetic */ Mode[] $VALUES = null;
            public static final Mode COMMON_SUPER_TYPE = null;
            public static final Mode INTERSECTION_TYPE = null;

            private static final /* synthetic */ Mode[] $values() {
                return new Mode[]{COMMON_SUPER_TYPE, INTERSECTION_TYPE};
            }

            static {
                COMMON_SUPER_TYPE = new Mode("COMMON_SUPER_TYPE", 0);
                INTERSECTION_TYPE = new Mode("INTERSECTION_TYPE", 1);
                $VALUES = $values();
            }

            private Mode(String r10, int r11) {
                super(r10, r11);
            }

            public static Mode valueOf(String r10) {
                return (Mode) Enum.valueOf(Mode.class, r10);
            }

            public static Mode[] values() {
                return (Mode[]) $VALUES.clone();
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r10 = new int[Mode.values().length];
                r10[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r10[Mode.INTERSECTION_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r10;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> r10, Mode r11) {
            if (r10.isEmpty() == false) goto L6;
            return null;
        L6:
            Iterator<T> r12 = r10.iterator();
            if (r12.hasNext() == false) goto L15;
            Object r13 = r12.next();
        L10:
            if (r12.hasNext() == false) goto L13;
            SimpleType r14 = (SimpleType) r12.next();
            Companion r15 = IntegerLiteralTypeConstructor.Companion;
            r13 = r15.fold((SimpleType) r13, r14, r11);
            goto L10
        L13:
            return (SimpleType) r13;
        L15:
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor r10, IntegerLiteralTypeConstructor r11, Mode r12) {
            int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
            if (r13 != 1) goto L5;
            Set r14 = CollectionsKt.intersect(r10.getPossibleTypes(), r11.getPossibleTypes());
        L10:
            long r15 = IntegerLiteralTypeConstructor.access$getValue$p(r10);
            ModuleDescriptor r16 = IntegerLiteralTypeConstructor.access$getModule$p(r10);
            IntegerLiteralTypeConstructor r17 = new IntegerLiteralTypeConstructor(r15, r16, r14, null);
            return KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), r17, false);
        L5:
            if (r13 != 2) goto L8;
            r14 = CollectionsKt.union(r10.getPossibleTypes(), r11.getPossibleTypes());
            goto L10
        L8:
            throw new NoWhenBranchMatchedException();
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor r10, SimpleType r11) {
            if (r10.getPossibleTypes().contains(r11) == true) goto L7;
            return null;
        L7:
            return r11;
        }

        private final SimpleType fold(SimpleType r10, SimpleType r11, Mode r12) {
            if (r10 == null) goto L17;
            if (r11 == null) goto L21;
            TypeConstructor r13 = r10.getConstructor();
            TypeConstructor r14 = r11.getConstructor();
            boolean r15 = r13 instanceof IntegerLiteralTypeConstructor;
            if (r15 == true) goto L9;
        L11:
            if (r15 == false) goto L14;
            return fold((IntegerLiteralTypeConstructor) r13, r11);
        L14:
            if ((r14 instanceof IntegerLiteralTypeConstructor) == true) goto L16;
            return null;
        L16:
            return fold((IntegerLiteralTypeConstructor) r14, r10);
        L9:
            if ((r14 instanceof IntegerLiteralTypeConstructor) == false) goto L11;
            return fold((IntegerLiteralTypeConstructor) r13, (IntegerLiteralTypeConstructor) r14, r12);
        L21:
            return null;
        L17:
            return null;
        }

        public final SimpleType findIntersectionType(Collection<? extends SimpleType> r10) {
            Intrinsics.checkNotNullParameter(r10, "types");
            return findCommonSuperTypeOrIntersectionType(r10, Mode.INTERSECTION_TYPE);
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IntegerLiteralTypeConstructor(long r10, ModuleDescriptor r11, Set<? extends KotlinType> r12) {
        this.type = KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), this, false);
        this.supertypes$delegate = LazyKt.lazy(new IntegerLiteralTypeConstructor$supertypes$2(this));
        this.value = r10;
        this.module = r11;
        this.possibleTypes = r12;
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long r10, ModuleDescriptor r11, Set r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
    }

    public static final /* synthetic */ ModuleDescriptor access$getModule$p(IntegerLiteralTypeConstructor r10) {
        return r10.module;
    }

    public static final /* synthetic */ SimpleType access$getType$p(IntegerLiteralTypeConstructor r10) {
        return r10.type;
    }

    public static final /* synthetic */ long access$getValue$p(IntegerLiteralTypeConstructor r10) {
        return r10.value;
    }

    public static final /* synthetic */ boolean access$isContainsOnlyUnsignedTypes(IntegerLiteralTypeConstructor r10) {
        return r10.isContainsOnlyUnsignedTypes();
    }

    private final List<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    private final boolean isContainsOnlyUnsignedTypes() {
        Collection<KotlinType> r10 = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if ((!this.possibleTypes.contains((KotlinType) r11.next())) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return true;
    }

    private final String valueToString() {
        return '[' + CollectionsKt.joinToString$default(this.possibleTypes, ",", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null) + ']';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo1323getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    public final Set<KotlinType> getPossibleTypes() {
        return this.possibleTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes, reason: collision with other method in class */
    public Collection<KotlinType> mo1324getSupertypes() {
        return getSupertypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerLiteralType" + valueToString();
    }
}
