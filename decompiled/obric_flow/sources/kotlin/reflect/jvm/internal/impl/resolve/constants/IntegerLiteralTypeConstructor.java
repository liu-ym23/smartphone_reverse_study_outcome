package kotlin.reflect.jvm.internal.impl.resolve.constants;

import ai.j0;
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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nIntegerLiteralTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n1726#2,3:182\n1747#2,3:185\n*S KotlinDebug\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor\n*L\n132#1:182,3\n176#1:185,3\n*E\n"})
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public static final Companion Companion = null;
    private final ModuleDescriptor module;
    private final Set<KotlinType> possibleTypes;
    private final Lazy supertypes$delegate;
    private final SimpleType type;
    private final long value;

    @SourceDebugExtension({"SMAP\nIntegerLiteralTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n2661#2,7:182\n*S KotlinDebug\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor$Companion\n*L\n40#1:182,7\n*E\n"})
    public static final class Companion {

        public static final enum Mode extends Enum<Mode> {
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

            private Mode(String r5, int r10) {
                super(r5, r10);
            }

            public static Mode valueOf(String r5) {
                return (Mode) Enum.valueOf(Mode.class, r5);
            }

            public static Mode[] values() {
                return (Mode[]) $VALUES.clone();
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[Mode.values().length];
                r5[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r5[Mode.INTERSECTION_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> r5, Mode r10) {
            if (r5.isEmpty() == false) goto L6;
            return null;
        L6:
            Iterator<T> r11 = r5.iterator();
            if (r11.hasNext() == false) goto L15;
            Object r12 = r11.next();
        L10:
            if (r11.hasNext() == false) goto L13;
            SimpleType r13 = (SimpleType) r11.next();
            Companion r14 = IntegerLiteralTypeConstructor.Companion;
            r12 = r14.fold((SimpleType) r12, r13, r10);
            goto L10
        L13:
            return (SimpleType) r12;
        L15:
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final SimpleType fold(SimpleType r10, SimpleType r11, Mode r12) {
            if (r10 == null) goto L17;
            if (r11 == null) goto L21;
            TypeConstructor r5 = r10.getConstructor();
            TypeConstructor r13 = r11.getConstructor();
            boolean r14 = r5 instanceof IntegerLiteralTypeConstructor;
            if (r14 == true) goto L9;
        L11:
            if (r14 == false) goto L14;
            return fold((IntegerLiteralTypeConstructor) r5, r11);
        L14:
            if ((r13 instanceof IntegerLiteralTypeConstructor) == true) goto L16;
            return null;
        L16:
            return fold((IntegerLiteralTypeConstructor) r13, r10);
        L9:
            if ((r13 instanceof IntegerLiteralTypeConstructor) == false) goto L11;
            return fold((IntegerLiteralTypeConstructor) r5, (IntegerLiteralTypeConstructor) r13, r12);
        L21:
            return null;
        L17:
            return null;
        }

        public final SimpleType findIntersectionType(Collection<? extends SimpleType> r5) {
            Intrinsics.checkNotNullParameter(r5, "types");
            return findCommonSuperTypeOrIntersectionType(r5, Mode.INTERSECTION_TYPE);
        }

        private Companion() {
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor r10, IntegerLiteralTypeConstructor r11, Mode r12) {
            int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
            if (r13 != 1) goto L5;
            Set r14 = CollectionsKt.intersect(r10.getPossibleTypes(), r11.getPossibleTypes());
        L7:
            Set r5 = r14;
            IntegerLiteralTypeConstructor r15 = new IntegerLiteralTypeConstructor(IntegerLiteralTypeConstructor.access$getValue$p(r10), IntegerLiteralTypeConstructor.access$getModule$p(r10), r5, null);
            return KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), r15, false);
        L5:
            if (r13 != 2) goto L9;
            r14 = CollectionsKt.union(r10.getPossibleTypes(), r11.getPossibleTypes());
            goto L7
        L9:
            throw new NoWhenBranchMatchedException();
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor r5, SimpleType r10) {
            if (r5.getPossibleTypes().contains(r10) == true) goto L7;
            return null;
        L7:
            return r10;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long r5, ModuleDescriptor r10, Set r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    public static final /* synthetic */ ModuleDescriptor access$getModule$p(IntegerLiteralTypeConstructor r5) {
        return r5.module;
    }

    public static final /* synthetic */ SimpleType access$getType$p(IntegerLiteralTypeConstructor r5) {
        return r5.type;
    }

    public static final /* synthetic */ long access$getValue$p(IntegerLiteralTypeConstructor r5) {
        return r5.value;
    }

    public static final /* synthetic */ boolean access$isContainsOnlyUnsignedTypes(IntegerLiteralTypeConstructor r5) {
        return r5.isContainsOnlyUnsignedTypes();
    }

    private final List<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    private final boolean isContainsOnlyUnsignedTypes() {
        Collection<KotlinType> r5 = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r10 = r5.iterator();
    L9:
        if (r10.hasNext() == false) goto L18;
        KotlinType r11 = (KotlinType) r10.next();
        if (this.possibleTypes.contains(r11) == false) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return true;
    }

    private final String valueToString() {
        return j0.p(new StringBuilder("["), CollectionsKt.q(this.possibleTypes, ",", null, null, 0, null, AnonymousClass1.INSTANCE, 30), ']');
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo1402getDeclarationDescriptor() {
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
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerLiteralType" + valueToString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IntegerLiteralTypeConstructor(long r5, ModuleDescriptor r10, Set<? extends KotlinType> r11) {
        this.type = KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), this, false);
        this.supertypes$delegate = LazyKt.lazy(new IntegerLiteralTypeConstructor$supertypes$2(this));
        this.value = r5;
        this.module = r10;
        this.possibleTypes = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes, reason: collision with other method in class */
    public Collection<KotlinType> mo1403getSupertypes() {
        return getSupertypes();
    }
}
