package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = null;

    private static final enum ResultNullability extends Enum<ResultNullability> {
        private static final /* synthetic */ ResultNullability[] $VALUES = null;
        public static final ResultNullability ACCEPT_NULL = null;
        public static final ResultNullability NOT_NULL = null;
        public static final ResultNullability START = null;
        public static final ResultNullability UNKNOWN = null;

        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String r10, int r11) {
                super(r10, r11, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r10) {
                Intrinsics.checkNotNullParameter(r10, "nextType");
                return getResultNullability(r10);
            }
        }

        static final class NOT_NULL extends ResultNullability {
            NOT_NULL(String r10, int r11) {
                super(r10, r11, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public NOT_NULL combine(UnwrappedType r10) {
                Intrinsics.checkNotNullParameter(r10, "nextType");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public /* bridge */ /* synthetic */ ResultNullability combine(UnwrappedType r10) {
                return combine(r10);
            }
        }

        static final class START extends ResultNullability {
            START(String r10, int r11) {
                super(r10, r11, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r10) {
                Intrinsics.checkNotNullParameter(r10, "nextType");
                return getResultNullability(r10);
            }
        }

        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String r10, int r11) {
                super(r10, r11, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r10) {
                Intrinsics.checkNotNullParameter(r10, "nextType");
                ResultNullability r11 = getResultNullability(r10);
                if (r11 != ResultNullability.ACCEPT_NULL) goto L6;
                return this;
            L6:
                return r11;
            }
        }

        private static final /* synthetic */ ResultNullability[] $values() {
            return new ResultNullability[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        static {
            START = new START("START", 0);
            ACCEPT_NULL = new ACCEPT_NULL("ACCEPT_NULL", 1);
            UNKNOWN = new UNKNOWN("UNKNOWN", 2);
            NOT_NULL = new NOT_NULL("NOT_NULL", 3);
            $VALUES = $values();
        }

        private ResultNullability(String r10, int r11) {
            super(r10, r11);
        }

        public /* synthetic */ ResultNullability(String r10, int r11, DefaultConstructorMarker r12) {
            this(r10, r11);
        }

        public static ResultNullability valueOf(String r10) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, r10);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        public abstract ResultNullability combine(UnwrappedType r10);

        protected final ResultNullability getResultNullability(UnwrappedType r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            if (r10.isMarkedNullable() == false) goto L6;
            return ACCEPT_NULL;
        L6:
            if ((r10 instanceof DefinitelyNotNullType) == false) goto L11;
            if ((((DefinitelyNotNullType) r10).getOriginal() instanceof StubTypeForBuilderInference) == false) goto L11;
        L17:
            return NOT_NULL;
        L11:
            if ((r10 instanceof StubTypeForBuilderInference) == false) goto L14;
        L18:
            return UNKNOWN;
        L14:
            if (NullabilityChecker.INSTANCE.isSubtypeOfAny(r10) == false) goto L18;
            goto L17
        }
    }

    static {
        INSTANCE = new TypeIntersector();
    }

    private TypeIntersector() {
    }

    public static final /* synthetic */ boolean access$isStrictSupertype(TypeIntersector r10, KotlinType r11, KotlinType r12) {
        return r10.isStrictSupertype(r11, r12);
    }

    private final Collection<SimpleType> filterTypes(Collection<? extends SimpleType> r10, Function2<? super SimpleType, ? super SimpleType, Boolean> r11) {
        ArrayList r12 = new ArrayList(r10);
        Iterator r13 = r12.iterator();
        Intrinsics.checkNotNullExpressionValue(r13, "filteredTypes.iterator()");
    L4:
        if (r13.hasNext() == false) goto L20;
        SimpleType r14 = (SimpleType) r13.next();
        boolean r15 = true;
        if (r12.isEmpty() == false) goto L8;
    L7:
        r15 = false;
    L18:
        if (r15 == false) goto L4;
        r13.remove();
        goto L4
    L8:
        Iterator r16 = r12.iterator();
    L10:
        if (r16.hasNext() == false) goto L7;
        SimpleType r17 = (SimpleType) r16.next();
        if (r17 == r14) goto L16;
        Intrinsics.checkNotNullExpressionValue(r17, "lower");
        Intrinsics.checkNotNullExpressionValue(r14, "upper");
        if (r11.invoke(r17, r14).booleanValue() == false) goto L16;
        boolean r18 = true;
    L17:
        if (r18 == false) goto L10;
    L16:
        r18 = false;
        goto L17
    L20:
        return r12;
    }

    private final SimpleType intersectTypesWithoutIntersectionType(final Set<? extends SimpleType> r10) {
        if (r10.size() == 1) goto L5;
        new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(r10);
        Collection<SimpleType> r11 = filterTypes(r10, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        r11.isEmpty();
        SimpleType r12 = IntegerLiteralTypeConstructor.Companion.findIntersectionType(r11);
        if (r12 == null) goto L9;
        return r12;
    L9:
        Collection<SimpleType> r13 = filterTypes(r11, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
        r13.isEmpty();
        if (r13.size() >= 2) goto L14;
        return (SimpleType) CollectionsKt.single(r13);
    L14:
        return new IntersectionTypeConstructor(r10).createType();
    L5:
        return (SimpleType) CollectionsKt.single(r10);
    }

    private final boolean isStrictSupertype(KotlinType r10, KotlinType r11) {
        NewKotlinTypeCheckerImpl r12 = NewKotlinTypeChecker.Companion.getDefault();
        if (r12.isSubtypeOf(r10, r11) == true) goto L5;
    L7:
        return false;
    L5:
        if (r12.isSubtypeOf(r11, r10) == true) goto L7;
        return true;
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> r10) {
        Intrinsics.checkNotNullParameter(r10, "types");
        r10.size();
        ArrayList r11 = new ArrayList();
        Iterator<? extends SimpleType> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        SimpleType r13 = r12.next();
        if ((r13.getConstructor() instanceof IntersectionTypeConstructor) == true) goto L7;
        r11.add(r13);
        goto L4
    L7:
        Collection<KotlinType> r14 = r13.getConstructor().mo1324getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r14, "type.constructor.supertypes");
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L9:
        if (r16.hasNext() == false) goto L14;
        KotlinType r17 = (KotlinType) r16.next();
        Intrinsics.checkNotNullExpressionValue(r17, "it");
        SimpleType r18 = FlexibleTypesKt.upperIfFlexible(r17);
        if (r13.isMarkedNullable() == false) goto L13;
        r18 = r18.makeNullableAsSpecified(true);
    L13:
        r15.add(r18);
        goto L9
    L14:
        r11.addAll(r15);
        goto L4
    L16:
        ResultNullability r19 = ResultNullability.START;
        Iterator r20 = r11.iterator();
    L18:
        if (r20.hasNext() == false) goto L20;
        r19 = r19.combine((UnwrappedType) r20.next());
        goto L18
    L20:
        LinkedHashSet r21 = new LinkedHashSet();
        Iterator r22 = r11.iterator();
    L22:
        if (r22.hasNext() == false) goto L30;
        SimpleType r23 = (SimpleType) r22.next();
        if (r19 != ResultNullability.NOT_NULL) goto L29;
        if ((r23 instanceof NewCapturedType) == false) goto L28;
        r23 = SpecialTypesKt.withNotNullProjection((NewCapturedType) r23);
    L28:
        r23 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(r23, false, 1, null);
    L29:
        r21.add(r23);
        goto L22
    L30:
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r25 = r10.iterator();
    L32:
        if (r25.hasNext() == false) goto L34;
        r24.add(((SimpleType) r25.next()).getAttributes());
        goto L32
    L34:
        Iterator r26 = r24.iterator();
        if (r26.hasNext() == false) goto L43;
        Object r27 = r26.next();
    L38:
        if (r26.hasNext() == false) goto L40;
        TypeAttributes r28 = (TypeAttributes) r27;
        r27 = r28.intersect((TypeAttributes) r26.next());
        goto L38
    L40:
        SimpleType r29 = intersectTypesWithoutIntersectionType(r21);
        return r29.replaceAttributes((TypeAttributes) r27);
    L43:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
