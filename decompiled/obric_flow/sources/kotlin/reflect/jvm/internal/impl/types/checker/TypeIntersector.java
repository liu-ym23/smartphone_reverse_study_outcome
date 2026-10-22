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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nIntersectionType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/TypeIntersector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1549#2:184\n1620#2,2:185\n1622#2:188\n1789#2,3:189\n1620#2,3:192\n1549#2:195\n1620#2,3:196\n2661#2,7:199\n1747#2,3:206\n1#3:187\n*S KotlinDebug\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/TypeIntersector\n*L\n80#1:184\n80#1:185,2\n80#1:188\n87#1:189,3\n98#1:192,3\n104#1:195\n104#1:196,3\n104#1:199,7\n137#1:206,3\n*E\n"})
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = null;

    public static final enum ResultNullability extends Enum<ResultNullability> {
        private static final /* synthetic */ ResultNullability[] $VALUES = null;
        public static final ResultNullability ACCEPT_NULL = null;
        public static final ResultNullability NOT_NULL = null;
        public static final ResultNullability START = null;
        public static final ResultNullability UNKNOWN = null;

        public static final class ACCEPT_NULL extends ResultNullability {
            public ACCEPT_NULL(String r5, int r10) {
                super(r5, r10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r5) {
                Intrinsics.checkNotNullParameter(r5, "nextType");
                return getResultNullability(r5);
            }
        }

        public static final class NOT_NULL extends ResultNullability {
            public NOT_NULL(String r5, int r10) {
                super(r5, r10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public NOT_NULL combine(UnwrappedType r5) {
                Intrinsics.checkNotNullParameter(r5, "nextType");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public /* bridge */ /* synthetic */ ResultNullability combine(UnwrappedType r5) {
                return combine(r5);
            }
        }

        public static final class START extends ResultNullability {
            public START(String r5, int r10) {
                super(r5, r10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r5) {
                Intrinsics.checkNotNullParameter(r5, "nextType");
                return getResultNullability(r5);
            }
        }

        public static final class UNKNOWN extends ResultNullability {
            public UNKNOWN(String r5, int r10) {
                super(r5, r10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r5) {
                Intrinsics.checkNotNullParameter(r5, "nextType");
                ResultNullability r10 = getResultNullability(r5);
                if (r10 != ResultNullability.ACCEPT_NULL) goto L6;
                return this;
            L6:
                return r10;
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

        public /* synthetic */ ResultNullability(String r5, int r10, DefaultConstructorMarker r11) {
            this(r5, r10);
        }

        public static ResultNullability valueOf(String r5) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, r5);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        public abstract ResultNullability combine(UnwrappedType r5);

        public final ResultNullability getResultNullability(UnwrappedType r5) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            if (r5.isMarkedNullable() == false) goto L6;
            return ACCEPT_NULL;
        L6:
            if ((r5 instanceof DefinitelyNotNullType) == false) goto L11;
            if ((((DefinitelyNotNullType) r5).getOriginal() instanceof StubTypeForBuilderInference) == false) goto L11;
            return NOT_NULL;
        L11:
            if ((r5 instanceof StubTypeForBuilderInference) == false) goto L14;
            return UNKNOWN;
        L14:
            if (NullabilityChecker.INSTANCE.isSubtypeOfAny(r5) == false) goto L17;
            return NOT_NULL;
        L17:
            return UNKNOWN;
        }

        private ResultNullability(String r5, int r10) {
            super(r5, r10);
        }
    }

    static {
        INSTANCE = new TypeIntersector();
    }

    private TypeIntersector() {
    }

    public static final /* synthetic */ boolean access$isStrictSupertype(TypeIntersector r5, KotlinType r10, KotlinType r11) {
        return r5.isStrictSupertype(r10, r11);
    }

    private final Collection<SimpleType> filterTypes(Collection<? extends SimpleType> r5, Function2<? super SimpleType, ? super SimpleType, Boolean> r10) {
        ArrayList r11 = new ArrayList(r5);
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        SimpleType r13 = (SimpleType) r12.next();
        if (r11.isEmpty() == true) goto L4;
        Iterator r14 = r11.iterator();
    L10:
        if (r14.hasNext() == false) goto L4;
        SimpleType r15 = (SimpleType) r14.next();
        if (r15 == r13) goto L10;
        if (r10.mo2invoke(r15, r13).booleanValue() == false) goto L10;
        r12.remove();
        goto L4
    L16:
        return r11;
    }

    private final SimpleType intersectTypesWithoutIntersectionType(final Set<? extends SimpleType> r5) {
        if (r5.size() == 1) goto L5;
        new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(r5);
        Set<? extends SimpleType> r10 = r5;
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
        return (SimpleType) CollectionsKt.single(r5);
    }

    private final boolean isStrictSupertype(KotlinType r5, KotlinType r10) {
        NewKotlinTypeCheckerImpl r11 = NewKotlinTypeChecker.Companion.getDefault();
        if (r11.isSubtypeOf(r5, r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (r11.isSubtypeOf(r10, r5) == true) goto L7;
        return true;
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> r10) {
        Intrinsics.checkNotNullParameter(r10, "types");
        r10.size();
        ArrayList r5 = new ArrayList();
        Iterator<? extends SimpleType> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        SimpleType r12 = r11.next();
        if ((r12.getConstructor() instanceof IntersectionTypeConstructor) == true) goto L7;
        r5.add(r12);
        goto L4
    L7:
        Collection<KotlinType> r13 = r12.getConstructor().mo1403getSupertypes();
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L9:
        if (r15.hasNext() == false) goto L14;
        SimpleType r16 = FlexibleTypesKt.upperIfFlexible((KotlinType) r15.next());
        if (r12.isMarkedNullable() == false) goto L13;
        r16 = r16.makeNullableAsSpecified(true);
    L13:
        r14.add(r16);
        goto L9
    L14:
        r5.addAll(r14);
        goto L4
    L16:
        ResultNullability r17 = ResultNullability.START;
        Iterator r18 = r5.iterator();
    L18:
        if (r18.hasNext() == false) goto L20;
        r17 = r17.combine((UnwrappedType) r18.next());
        goto L18
    L20:
        LinkedHashSet r19 = new LinkedHashSet();
        Iterator r20 = r5.iterator();
    L22:
        if (r20.hasNext() == false) goto L30;
        SimpleType r21 = (SimpleType) r20.next();
        if (r17 != ResultNullability.NOT_NULL) goto L29;
        if ((r21 instanceof NewCapturedType) == false) goto L28;
        r21 = SpecialTypesKt.withNotNullProjection((NewCapturedType) r21);
    L28:
        r21 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(r21, false, 1, null);
    L29:
        r19.add(r21);
        goto L22
    L30:
        ArrayList r22 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r23 = r10.iterator();
    L32:
        if (r23.hasNext() == false) goto L34;
        r22.add(((SimpleType) r23.next()).getAttributes());
        goto L32
    L34:
        Iterator r24 = r22.iterator();
        if (r24.hasNext() == false) goto L43;
        Object r25 = r24.next();
    L38:
        if (r24.hasNext() == false) goto L40;
        TypeAttributes r26 = (TypeAttributes) r25;
        r25 = r26.intersect((TypeAttributes) r24.next());
        goto L38
    L40:
        SimpleType r27 = intersectTypesWithoutIntersectionType(r19);
        return r27.replaceAttributes((TypeAttributes) r25);
    L43:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
