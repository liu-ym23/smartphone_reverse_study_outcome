package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.a;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractTypeChecker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 TypeSystemContext.kt\norg/jetbrains/kotlin/types/model/TypeSystemContextKt\n*L\n1#1,835:1\n1#2:836\n1#2:853\n1#2:905\n1#2:943\n132#3,16:837\n148#3,13:854\n46#3,8:875\n132#3,16:889\n148#3,13:906\n132#3,16:927\n148#3,13:944\n1549#4:867\n1620#4,3:868\n1549#4:871\n1620#4,3:872\n1726#4,3:883\n1726#4,3:886\n766#4:919\n857#4:920\n858#4:926\n1360#4:957\n1446#4,5:958\n1747#4,3:963\n1747#4,3:966\n556#5,5:921\n*S KotlinDebug\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractTypeChecker\n*L\n342#1:853\n622#1:905\n692#1:943\n342#1:837,16\n342#1:854,13\n475#1:875,8\n622#1:889,16\n622#1:906,13\n692#1:927,16\n692#1:944,13\n378#1:867\n378#1:868,3\n389#1:871\n389#1:872,3\n561#1:883,3\n572#1:886,3\n667#1:919\n667#1:920\n667#1:926\n701#1:957\n701#1:958,5\n295#1:963,3\n303#1:966,3\n668#1:921,5\n*E\n"})
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = null;

    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r5 = new int[TypeVariance.values().length];
            r5[TypeVariance.INV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r5[TypeVariance.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r5[TypeVariance.IN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            $EnumSwitchMapping$0 = r5;
            int[] r10 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            r10[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r10[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r10[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            $EnumSwitchMapping$1 = r10;
        }
    }

    static {
        INSTANCE = new AbstractTypeChecker();
    }

    private AbstractTypeChecker() {
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState r5, SimpleTypeMarker r10, SimpleTypeMarker r11) {
        TypeSystemContext r12 = r5.getTypeSystemContext();
        if (r12.isIntegerLiteralType(r10) == true) goto L8;
        if (r12.isIntegerLiteralType(r11) == true) goto L8;
        return null;
    L8:
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(r12, r10) == false) goto L14;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(r12, r11) == false) goto L14;
        return Boolean.TRUE;
    L14:
        if (r12.isIntegerLiteralType(r10) == false) goto L20;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(r12, r5, r10, r11, false) == true) goto L18;
    L27:
        return null;
    L18:
        return Boolean.TRUE;
    L20:
        if (r12.isIntegerLiteralType(r11) == false) goto L27;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(r12, r10) == true) goto L26;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(r12, r5, r11, r10, true) == false) goto L27;
    L26:
        return Boolean.TRUE;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(TypeSystemContext r5, SimpleTypeMarker r10) {
        if ((r10 instanceof CapturedTypeMarker) == true) goto L5;
        return false;
    L5:
        TypeArgumentMarker r11 = r5.projection(r5.typeConstructor((CapturedTypeMarker) r10));
        if (r5.isStarProjection(r11) == false) goto L8;
        return false;
    L8:
        if (r5.isIntegerLiteralType(r5.upperBoundIfFlexible(r5.getType(r11))) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext r5, SimpleTypeMarker r10) {
        TypeConstructorMarker r11 = r5.typeConstructor(r10);
        if ((r11 instanceof IntersectionTypeConstructorMarker) == false) goto L17;
        Collection<KotlinTypeMarker> r12 = r5.supertypes(r11);
        if ((r12 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L17;
        SimpleTypeMarker r14 = r5.asSimpleType((KotlinTypeMarker) r13.next());
        if (r14 == null) goto L11;
        if (r5.isIntegerLiteralType(r14) != true) goto L11;
        return true;
    L7:
        if (r12.isEmpty() == false) goto L9;
    L17:
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext r5, SimpleTypeMarker r10) {
        if (r5.isIntegerLiteralType(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(r5, r10) == true) goto L8;
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(TypeSystemContext r10, TypeCheckerState r11, SimpleTypeMarker r12, SimpleTypeMarker r13, boolean r14) {
        Collection<KotlinTypeMarker> r15 = r10.possibleIntegerTypes(r12);
        if ((r15 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L25;
        KotlinTypeMarker r5 = (KotlinTypeMarker) r16.next();
        if (Intrinsics.areEqual(r10.typeConstructor(r5), r10.typeConstructor(r13)) == true) goto L15;
        if (r14 == false) goto L9;
        if (isSubtypeOf$default(INSTANCE, r11, r13, r5, false, 8, null) == false) goto L9;
    L15:
        return true;
    L25:
        return false;
    L5:
        if (r15.isEmpty() == false) goto L7;
        return false;
    }

    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState r13, SimpleTypeMarker r14, SimpleTypeMarker r15) {
        TypeSystemContext r12 = r13.getTypeSystemContext();
        boolean r5 = false;
        if (r12.isError(r14) == true) goto L91;
        if (r12.isError(r15) == true) goto L91;
        if (r12.isStubTypeForBuilderInference(r14) == false) goto L19;
        if (r12.isStubTypeForBuilderInference(r15) == false) goto L19;
        if (INSTANCE.isStubTypeSubtypeOfAnother(r12, r14, r15) == false) goto L14;
    L15:
        r5 = true;
    L17:
        return Boolean.valueOf(r5);
    L14:
        if (r13.isStubTypeEqualsToAnything() == false) goto L17;
    L19:
        if (r12.isStubType(r14) == true) goto L89;
        if (r12.isStubType(r15) == true) goto L89;
        DefinitelyNotNullTypeMarker r10 = r12.asDefinitelyNotNullType(r15);
        if (r10 == null) goto L27;
        SimpleTypeMarker r11 = r12.original(r10);
        if (r11 == null) goto L27;
    L28:
        CapturedTypeMarker r16 = r12.asCapturedType(r11);
        if (r16 == null) goto L31;
        KotlinTypeMarker r17 = r12.lowerType(r16);
    L32:
        if (r16 == null) goto L52;
        if (r17 == null) goto L52;
        if (r12.isMarkedNullable(r15) == false) goto L39;
        r17 = r12.withNullability(r17, true);
    L37:
        KotlinTypeMarker r18 = r17;
        int r19 = WhenMappings.$EnumSwitchMapping$1[r13.getLowerCapturedTypePolicy(r14, r16).ordinal()];
        if (r19 == 1) goto L51;
        if (r19 != 2) goto L52;
        if (isSubtypeOf$default(INSTANCE, r13, r14, r18, false, 8, null) == false) goto L52;
        return Boolean.TRUE;
    L51:
        return Boolean.valueOf(isSubtypeOf$default(INSTANCE, r13, r14, r18, false, 8, null));
    L39:
        if (r12.isDefinitelyNotNullType(r15) == false) goto L37;
        r17 = r12.makeDefinitelyNotNullOrNotNull(r17);
    L52:
        TypeConstructorMarker r20 = r12.typeConstructor(r15);
        if (r12.isIntersection(r20) == false) goto L66;
        r12.isMarkedNullable(r15);
        Collection<KotlinTypeMarker> r110 = r12.supertypes(r20);
        if ((r110 instanceof Collection) == true) goto L57;
    L59:
        Iterator<T> r111 = r110.iterator();
    L61:
        if (r111.hasNext() == false) goto L58;
        if (isSubtypeOf$default(INSTANCE, r13, r14, (KotlinTypeMarker) r111.next(), false, 8, null) == true) goto L61;
    L65:
        return Boolean.valueOf(r5);
    L58:
        r5 = true;
        goto L65
    L57:
        if (r110.isEmpty() == false) goto L59;
    L66:
        TypeConstructorMarker r21 = r12.typeConstructor(r14);
        if ((r14 instanceof CapturedTypeMarker) == false) goto L69;
    L81:
        TypeParameterMarker r112 = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(r13.getTypeSystemContext(), r15, r14);
        if (r112 != null) goto L84;
    L87:
        return null;
    L84:
        if (r12.hasRecursiveBounds(r112, r12.typeConstructor(r15)) == false) goto L87;
        return Boolean.TRUE;
    L69:
        if (r12.isIntersection(r21) == false) goto L87;
        Collection<KotlinTypeMarker> r22 = r12.supertypes(r21);
        if ((r22 instanceof Collection) == true) goto L73;
    L75:
        Iterator<T> r23 = r22.iterator();
    L77:
        if (r23.hasNext() == false) goto L81;
        if ((((KotlinTypeMarker) r23.next()) instanceof CapturedTypeMarker) == true) goto L77;
    L73:
        if (r22.isEmpty() == false) goto L75;
    L31:
        r17 = null;
    L27:
        r11 = r15;
    L89:
        return Boolean.valueOf(r13.isStubTypeEqualsToAnything());
    L91:
        if (r13.isErrorTypeEqualsToAnything() == false) goto L95;
        return Boolean.TRUE;
    L95:
        if (r12.isMarkedNullable(r14) == false) goto L101;
        if (r12.isMarkedNullable(r15) == true) goto L101;
        return Boolean.FALSE;
    L101:
        return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(r12, r12.withNullability(r14, false), r12.withNullability(r15, false)));
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState r12, SimpleTypeMarker r13, TypeConstructorMarker r14) {
        TypeSystemContext r11 = r12.getTypeSystemContext();
        List<SimpleTypeMarker> r5 = r11.fastCorrespondingSupertypes(r13, r14);
        if (r5 == null) goto L6;
        return r5;
    L6:
        if (r11.isClassTypeConstructor(r14) == true) goto L12;
        if (r11.isClassType(r13) == false) goto L12;
        return CollectionsKt.emptyList();
    L12:
        if (r11.isCommonFinalClassConstructor(r14) == true) goto L14;
        SmartList r10 = new SmartList();
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r15 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r15);
        Set<SimpleTypeMarker> r16 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r16);
        r15.push(r13);
    L24:
        if (r15.isEmpty() == true) goto L51;
        if (r16.size() > 1000) goto L49;
        SimpleTypeMarker r17 = r15.pop();
        if (r16.add(r17) == false) goto L24;
        SimpleTypeMarker r18 = r11.captureFromArguments(r17, CaptureStatus.FOR_SUBTYPING);
        if (r18 != null) goto L33;
        r18 = r17;
    L33:
        if (r11.areEqualTypeConstructors(r11.typeConstructor(r18), r14) == false) goto L36;
        r10.add(r18);
        TypeCheckerState.SupertypesPolicy r19 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L40:
        if (Intrinsics.areEqual(r19, TypeCheckerState.SupertypesPolicy.None.INSTANCE) == false) goto L43;
        r19 = null;
    L43:
        if (r19 == null) goto L24;
        TypeSystemContext r20 = r12.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r21 = r20.supertypes(r20.typeConstructor(r17)).iterator();
    L47:
        if (r21.hasNext() == false) goto L24;
        r15.add(r19.mo1406transformType(r12, r21.next()));
        goto L47
    L36:
        if (r11.argumentsCount(r18) != 0) goto L38;
        r19 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L40
    L38:
        r19 = r12.getTypeSystemContext().substitutionSupertypePolicy(r18);
        goto L40
    L49:
        StringBuilder r110 = a.i("Too many supertypes for type: ", r13, ". Supertypes = ");
        r110.append(CollectionsKt.q(r16, null, null, null, 0, null, null, 63));
        throw new IllegalStateException(r110.toString().toString());
    L51:
        r12.clear();
        return r10;
    L14:
        if (r11.areEqualTypeConstructors(r11.typeConstructor(r13), r14) == false) goto L21;
        SimpleTypeMarker r111 = r11.captureFromArguments(r13, CaptureStatus.FOR_SUBTYPING);
        if (r111 == null) goto L61;
        r13 = r111;
    L61:
        return CollectionsKt.listOf(r13);
    L21:
        return CollectionsKt.emptyList();
    }

    private final List<SimpleTypeMarker> collectAndFilter(TypeCheckerState r5, SimpleTypeMarker r10, TypeConstructorMarker r11) {
        return selectOnlyPureKotlinSupertypes(r5, collectAllSupertypesWithGivenTypeConstructor(r5, r10, r11));
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState r5, KotlinTypeMarker r10, KotlinTypeMarker r11, boolean r12) {
        TypeSystemContext r13 = r5.getTypeSystemContext();
        KotlinTypeMarker r14 = r5.prepareType(r5.refineType(r10));
        KotlinTypeMarker r15 = r5.prepareType(r5.refineType(r11));
        AbstractTypeChecker r16 = INSTANCE;
        Boolean r17 = r16.checkSubtypeForSpecialCases(r5, r13.lowerBoundIfFlexible(r14), r13.upperBoundIfFlexible(r15));
        if (r17 == null) goto L6;
        boolean r18 = r17.booleanValue();
        r5.addSubtypeConstraint(r14, r15, r12);
        return r18;
    L6:
        Boolean r19 = r5.addSubtypeConstraint(r14, r15, r12);
        if (r19 == null) goto L11;
        return r19.booleanValue();
    L11:
        return r16.isSubtypeOfForSingleClassifierType(r5, r13.lowerBoundIfFlexible(r14), r13.upperBoundIfFlexible(r15));
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext r10, KotlinTypeMarker r11, KotlinTypeMarker r12) {
        int r5 = r10.argumentsCount(r11);
        int r13 = 0;
    L3:
        TypeArgumentMarker r14 = null;
        if (r13 >= r5) goto L30;
        TypeArgumentMarker r15 = r10.getArgument(r11, r13);
        if (r10.isStarProjection(r15) == true) goto L8;
        r14 = r15;
    L8:
        if (r14 == null) goto L29;
        KotlinTypeMarker r16 = r10.getType(r14);
        if (r16 == null) goto L29;
        if (r10.isCapturedType(r10.originalIfDefinitelyNotNullable(r10.lowerBoundIfFlexible(r16))) == true) goto L15;
    L17:
        boolean r17 = false;
    L19:
        if (Intrinsics.areEqual(r16, r12) == true) goto L28;
        if (r17 == true) goto L22;
    L24:
        TypeParameterMarker r18 = getTypeParameterForArgumentInBaseIfItEqualToTarget(r10, r16, r12);
        if (r18 == null) goto L29;
        return r18;
    L22:
        if (Intrinsics.areEqual(r10.typeConstructor(r16), r10.typeConstructor(r12)) == false) goto L24;
    L28:
        return r10.getParameter(r10.typeConstructor(r11), r13);
    L15:
        if (r10.isCapturedType(r10.originalIfDefinitelyNotNullable(r10.lowerBoundIfFlexible(r12))) == false) goto L17;
        r17 = true;
    L29:
        r13 = r13 + 1;
        goto L3
    L30:
        return null;
    }

    private final boolean hasNothingSupertype(TypeCheckerState r12, SimpleTypeMarker r13) {
        TypeSystemContext r11 = r12.getTypeSystemContext();
        TypeConstructorMarker r5 = r11.typeConstructor(r13);
        if (r11.isClassTypeConstructor(r5) == false) goto L7;
        return r11.isNothingConstructor(r5);
    L7:
        if (r11.isNothingConstructor(r11.typeConstructor(r13)) == true) goto L47;
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r10 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r10);
        Set<SimpleTypeMarker> r14 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r14);
        r10.push(r13);
    L11:
        if (r10.isEmpty() == true) goto L35;
        if (r14.size() > 1000) goto L33;
        SimpleTypeMarker r15 = r10.pop();
        if (r14.add(r15) == false) goto L11;
        if (r11.isClassType(r15) == false) goto L19;
        TypeCheckerState.SupertypesPolicy r16 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L21:
        if (Intrinsics.areEqual(r16, TypeCheckerState.SupertypesPolicy.None.INSTANCE) == false) goto L24;
        r16 = null;
    L24:
        if (r16 == null) goto L11;
        TypeSystemContext r17 = r12.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r18 = r17.supertypes(r17.typeConstructor(r15)).iterator();
    L28:
        if (r18.hasNext() == false) goto L11;
        SimpleTypeMarker r19 = r16.mo1406transformType(r12, r18.next());
        if (r11.isNothingConstructor(r11.typeConstructor(r19)) == true) goto L31;
        r10.add(r19);
        goto L28
    L31:
        r12.clear();
        return true;
    L19:
        r16 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L21
    L33:
        StringBuilder r110 = a.i("Too many supertypes for type: ", r13, ". Supertypes = ");
        r110.append(CollectionsKt.q(r14, null, null, null, 0, null, null, 63));
        throw new IllegalStateException(r110.toString().toString());
    L35:
        r12.clear();
        return false;
    L47:
        return true;
    }

    private final boolean isCommonDenotableType(TypeSystemContext r5, KotlinTypeMarker r10) {
        if (r5.isDenotable(r5.typeConstructor(r10)) == true) goto L5;
    L13:
        return false;
    L5:
        if (r5.isDynamic(r10) == true) goto L13;
        if (r5.isDefinitelyNotNullType(r10) == true) goto L13;
        if (r5.isNotNullTypeParameter(r10) == true) goto L13;
        if (Intrinsics.areEqual(r5.typeConstructor(r5.lowerBoundIfFlexible(r10)), r5.typeConstructor(r5.upperBoundIfFlexible(r10))) == false) goto L13;
        return true;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext r5, SimpleTypeMarker r10, SimpleTypeMarker r11) {
        DefinitelyNotNullTypeMarker r12 = r5.asDefinitelyNotNullType(r10);
        if (r12 == null) goto L6;
        SimpleTypeMarker r13 = r5.original(r12);
        if (r13 == null) goto L6;
    L7:
        DefinitelyNotNullTypeMarker r14 = r5.asDefinitelyNotNullType(r11);
        if (r14 == null) goto L11;
        SimpleTypeMarker r15 = r5.original(r14);
        if (r15 == null) goto L11;
    L13:
        if (r5.typeConstructor(r13) == r5.typeConstructor(r15)) goto L16;
        return false;
    L16:
        if (r5.isDefinitelyNotNullType(r10) == true) goto L21;
        if (r5.isDefinitelyNotNullType(r11) == false) goto L21;
        return false;
    L21:
        if (r5.isMarkedNullable(r10) == true) goto L23;
        return true;
    L23:
        if (r5.isMarkedNullable(r11) == true) goto L27;
        return false;
    L27:
        return true;
    L11:
        r15 = r11;
    L6:
        r13 = r10;
        goto L7
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker r5, TypeCheckerState r10, KotlinTypeMarker r11, KotlinTypeMarker r12, boolean r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = false;
    L6:
        return r5.isSubtypeOf(r10, r11, r12, r13);
    }

    private final boolean isSubtypeOfForSingleClassifierType(final TypeCheckerState r17, SimpleTypeMarker r18, final SimpleTypeMarker r19) {
        final TypeSystemContext r5 = r17.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS == true) goto L5;
    L12:
        boolean r10 = false;
        if (AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(r17, r18, r19) == true) goto L15;
        return false;
    L15:
        AbstractTypeChecker r11 = INSTANCE;
        Boolean r12 = r11.checkSubtypeForIntegerLiteralType(r17, r5.lowerBoundIfFlexible(r18), r5.upperBoundIfFlexible(r19));
        if (r12 == null) goto L19;
        boolean r13 = r12.booleanValue();
        TypeCheckerState.addSubtypeConstraint$default(r17, r18, r19, false, 4, null);
        return r13;
    L19:
        TypeConstructorMarker r14 = r5.typeConstructor(r19);
        boolean r15 = true;
        if (r5.areEqualTypeConstructors(r5.typeConstructor(r18), r14) == false) goto L25;
        if (r5.parametersCount(r14) != 0) goto L25;
        return true;
    L25:
        if (r5.isAnyConstructor(r5.typeConstructor(r19)) == false) goto L27;
        return true;
    L27:
        List<SimpleTypeMarker> r16 = r11.findCorrespondingSupertypes(r17, r18, r14);
        final ArrayList r20 = new ArrayList(CollectionsKt.h(r16));
        Iterator<T> r21 = r16.iterator();
    L29:
        if (r21.hasNext() == false) goto L35;
        SimpleTypeMarker r22 = (SimpleTypeMarker) r21.next();
        SimpleTypeMarker r110 = r5.asSimpleType(r17.prepareType(r22));
        if (r110 == null) goto L34;
        r22 = r110;
    L34:
        r20.add(r22);
        goto L29
    L35:
        int r23 = r20.size();
        if (r23 == 0) goto L74;
        if (r23 == 1) goto L72;
        ArgumentList r24 = new ArgumentList(r5.parametersCount(r14));
        int r25 = r5.parametersCount(r14);
        int r111 = 0;
        boolean r112 = false;
    L39:
        if (r111 >= r25) goto L64;
        if (r112 == false) goto L42;
    L45:
        r112 = r15;
    L46:
        if (r112 == true) goto L63;
        ArrayList r113 = new ArrayList(CollectionsKt.h(r20));
        Iterator r114 = r20.iterator();
    L49:
        if (r114.hasNext() == false) goto L62;
        SimpleTypeMarker r115 = (SimpleTypeMarker) r114.next();
        TypeArgumentMarker r116 = r5.getArgumentOrNull(r115, r111);
        if (r116 == null) goto L61;
        if (r5.getVariance(r116) == TypeVariance.INV) goto L56;
        r116 = null;
    L56:
        if (r116 == null) goto L61;
        KotlinTypeMarker r26 = r5.getType(r116);
        if (r26 == null) goto L61;
        r113.add(r26);
    L61:
        throw new IllegalStateException(("Incorrect type: " + r115 + ", subType: " + r18 + ", superType: " + r19).toString());
    L62:
        r24.add(r5.asTypeArgument(r5.intersectTypes(r113)));
    L63:
        r111 = r111 + 1;
        r10 = false;
        r15 = true;
        goto L39
    L42:
        if (r5.getVariance(r5.getParameter(r14, r111)) != TypeVariance.OUT) goto L45;
        r112 = r10;
        goto L46
    L64:
        if (r112 == true) goto L70;
        if (INSTANCE.isSubtypeForSameConstructor(r17, r24, r19) == false) goto L70;
        return true;
    L70:
        return r17.runForkingPoint(new AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4(r20, r17, r5, r19));
    L72:
        return INSTANCE.isSubtypeForSameConstructor(r17, r5.asArgumentList((SimpleTypeMarker) CollectionsKt.first(r20)), r19);
    L74:
        return INSTANCE.hasNothingSupertype(r17, r18);
    L5:
        if (r5.isSingleClassifierType(r18) == true) goto L10;
        if (r5.isIntersection(r5.typeConstructor(r18)) == true) goto L10;
        r17.isAllowedTypeVariable(r18);
    L10:
        if (r5.isSingleClassifierType(r19) == true) goto L12;
        r17.isAllowedTypeVariable(r19);
        goto L12
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext r5, KotlinTypeMarker r10, KotlinTypeMarker r11, TypeConstructorMarker r12) {
        SimpleTypeMarker r13 = r5.asSimpleType(r10);
        if ((r13 instanceof CapturedTypeMarker) == false) goto L24;
        CapturedTypeMarker r14 = (CapturedTypeMarker) r13;
        if (r5.isOldCapturedType(r14) == false) goto L7;
        return false;
    L7:
        if (r5.isStarProjection(r5.projection(r5.typeConstructor(r14))) == true) goto L10;
        return false;
    L10:
        if (r5.captureStatus(r14) == CaptureStatus.FOR_SUBTYPING) goto L12;
        return false;
    L12:
        TypeConstructorMarker r15 = r5.typeConstructor(r11);
        if ((r15 instanceof TypeVariableTypeConstructorMarker) == false) goto L15;
        TypeVariableTypeConstructorMarker r16 = (TypeVariableTypeConstructorMarker) r15;
    L16:
        if (r16 != null) goto L18;
        return false;
    L18:
        TypeParameterMarker r17 = r5.getTypeParameter(r16);
        if (r17 != null) goto L21;
        return false;
    L21:
        if (r5.hasRecursiveBounds(r17, r12) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        r16 = null;
        goto L16
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(TypeCheckerState r10, List<? extends SimpleTypeMarker> r11) {
        TypeSystemContext r12 = r10.getTypeSystemContext();
        if (r11.size() >= 2) goto L5;
        return r11;
    L5:
        ArrayList r13 = new ArrayList();
        Iterator r5 = r11.iterator();
    L7:
        if (r5.hasNext() == false) goto L15;
        Object r14 = r5.next();
        TypeArgumentListMarker r15 = r12.asArgumentList((SimpleTypeMarker) r14);
        int r16 = r12.size(r15);
        int r17 = 0;
    L9:
        if (r17 >= r16) goto L13;
        if (r12.asFlexibleType(r12.getType(r12.get(r15, r17))) != null) goto L7;
        r17 = r17 + 1;
        goto L9
    L13:
        r13.add(r14);
        goto L7
    L15:
        if (r13.isEmpty() == false) goto L17;
        return r11;
    L17:
        return r13;
    }

    public final TypeVariance effectiveVariance(TypeVariance r5, TypeVariance r10) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "useSite");
        TypeVariance r11 = TypeVariance.INV;
        if (r5 != r11) goto L5;
        return r10;
    L5:
        if (r10 != r11) goto L7;
        return r5;
    L7:
        if (r5 != r10) goto L9;
        return r5;
    L9:
        return null;
    }

    public final boolean equalTypes(TypeCheckerState r11, KotlinTypeMarker r12, KotlinTypeMarker r13) {
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r12, "a");
        Intrinsics.checkNotNullParameter(r13, "b");
        TypeSystemContext r10 = r11.getTypeSystemContext();
        if (r12 != r13) goto L5;
        return true;
    L5:
        AbstractTypeChecker r14 = INSTANCE;
        if (r14.isCommonDenotableType(r10, r12) == false) goto L25;
        if (r14.isCommonDenotableType(r10, r13) == false) goto L25;
        KotlinTypeMarker r5 = r11.prepareType(r11.refineType(r12));
        KotlinTypeMarker r15 = r11.prepareType(r11.refineType(r13));
        SimpleTypeMarker r16 = r10.lowerBoundIfFlexible(r5);
        if (r10.areEqualTypeConstructors(r10.typeConstructor(r5), r10.typeConstructor(r15)) == true) goto L13;
        return false;
    L13:
        if (r10.argumentsCount(r16) != 0) goto L25;
        if (r10.hasFlexibleNullability(r5) == false) goto L17;
        return true;
    L17:
        if (r10.hasFlexibleNullability(r15) == false) goto L20;
        return true;
    L20:
        if (r10.isMarkedNullable(r16) != r10.isMarkedNullable(r10.lowerBoundIfFlexible(r15))) goto L23;
        return true;
    L23:
        return false;
    L25:
        if (isSubtypeOf$default(r14, r11, r12, r13, false, 8, null) == false) goto L30;
        if (isSubtypeOf$default(r14, r11, r13, r12, false, 8, null) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public final List<SimpleTypeMarker> findCorrespondingSupertypes(TypeCheckerState r12, SimpleTypeMarker r13, TypeConstructorMarker r14) {
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r13, "subType");
        Intrinsics.checkNotNullParameter(r14, "superConstructor");
        TypeSystemContext r11 = r12.getTypeSystemContext();
        if (r11.isClassType(r13) == false) goto L7;
        return INSTANCE.collectAndFilter(r12, r13, r14);
    L7:
        if (r11.isClassTypeConstructor(r14) == false) goto L9;
    L12:
        SmartList r5 = new SmartList();
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r10 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r10);
        Set<SimpleTypeMarker> r15 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r15);
        r10.push(r13);
    L14:
        if (r10.isEmpty() == true) goto L35;
        if (r15.size() > 1000) goto L33;
        SimpleTypeMarker r16 = r10.pop();
        if (r15.add(r16) == false) goto L14;
        if (r11.isClassType(r16) == false) goto L22;
        r5.add(r16);
        TypeCheckerState.SupertypesPolicy r17 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L24:
        if (Intrinsics.areEqual(r17, TypeCheckerState.SupertypesPolicy.None.INSTANCE) == false) goto L27;
        r17 = null;
    L27:
        if (r17 == null) goto L14;
        TypeSystemContext r18 = r12.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r19 = r18.supertypes(r18.typeConstructor(r16)).iterator();
    L31:
        if (r19.hasNext() == false) goto L14;
        r10.add(r17.mo1406transformType(r12, r19.next()));
        goto L31
    L22:
        r17 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L24
    L33:
        StringBuilder r110 = a.i("Too many supertypes for type: ", r13, ". Supertypes = ");
        r110.append(CollectionsKt.q(r15, null, null, null, 0, null, null, 63));
        throw new IllegalStateException(r110.toString().toString());
    L35:
        r12.clear();
        ArrayList r111 = new ArrayList();
        Iterator<E> r112 = r5.iterator();
    L37:
        if (r112.hasNext() == false) goto L39;
        SimpleTypeMarker r20 = (SimpleTypeMarker) r112.next();
        CollectionsKt.a(r111, INSTANCE.collectAndFilter(r12, r20, r14));
        goto L37
    L39:
        return r111;
    L9:
        if (r11.isIntegerLiteralTypeConstructor(r14) == true) goto L12;
        return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(r12, r13, r14);
    }

    public final boolean isSubtypeForSameConstructor(TypeCheckerState r17, TypeArgumentListMarker r18, SimpleTypeMarker r19) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(r19, "superType");
        TypeSystemContext r10 = r17.getTypeSystemContext();
        TypeConstructorMarker r11 = r10.typeConstructor(r19);
        int r5 = r10.size(r18);
        int r12 = r10.parametersCount(r11);
        if (r5 == r12) goto L5;
    L42:
        return false;
    L5:
        if (r5 != r10.argumentsCount(r19)) goto L42;
        int r14 = 0;
    L9:
        if (r14 >= r12) goto L41;
        TypeArgumentMarker r13 = r10.getArgument(r19, r14);
        if (r10.isStarProjection(r13) == true) goto L40;
        KotlinTypeMarker r15 = r10.getType(r13);
        TypeArgumentMarker r16 = r10.get(r18, r14);
        r10.getVariance(r16);
        TypeVariance r20 = TypeVariance.INV;
        KotlinTypeMarker r21 = r10.getType(r16);
        AbstractTypeChecker r22 = INSTANCE;
        TypeVariance r23 = r22.effectiveVariance(r10.getVariance(r10.getParameter(r11, r14)), r10.getVariance(r13));
        if (r23 == null) goto L15;
        if (r23 != r20) goto L23;
        if (r22.isTypeVariableAgainstStarProjectionForSelfType(r10, r21, r15, r11) == true) goto L40;
        if (r22.isTypeVariableAgainstStarProjectionForSelfType(r10, r15, r21, r11) == true) goto L40;
    L23:
        if (TypeCheckerState.access$getArgumentsDepth(r17) > 100) goto L39;
        TypeCheckerState.access$setArgumentsDepth(r17, TypeCheckerState.access$getArgumentsDepth(r17) + 1);
        int r24 = WhenMappings.$EnumSwitchMapping$0[r23.ordinal()];
        if (r24 != 1) goto L27;
        boolean r25 = r22.equalTypes(r17, r21, r15);
    L35:
        TypeCheckerState.access$setArgumentsDepth(r17, TypeCheckerState.access$getArgumentsDepth(r17) - 1);
        if (r25 == true) goto L40;
        return false;
    L27:
        if (r24 != 2) goto L29;
        r25 = isSubtypeOf$default(r22, r17, r21, r15, false, 8, null);
        goto L35
    L29:
        if (r24 != 3) goto L32;
        r25 = isSubtypeOf$default(r22, r17, r15, r21, false, 8, null);
        goto L35
    L32:
        throw new NoWhenBranchMatchedException();
    L39:
        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + r21).toString());
    L15:
        return r17.isErrorTypeEqualsToAnything();
    L40:
        r14 = r14 + 1;
        goto L9
    L41:
        return true;
    }

    @JvmOverloads
    public final boolean isSubtypeOf(TypeCheckerState r10, KotlinTypeMarker r11, KotlinTypeMarker r12) {
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "subType");
        Intrinsics.checkNotNullParameter(r12, "superType");
        return isSubtypeOf$default(this, r10, r11, r12, false, 8, null);
    }

    @JvmOverloads
    public final boolean isSubtypeOf(TypeCheckerState r5, KotlinTypeMarker r10, KotlinTypeMarker r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r10, "subType");
        Intrinsics.checkNotNullParameter(r11, "superType");
        if (r10 != r11) goto L7;
        return true;
    L7:
        if (r5.customIsSubtypeOf(r10, r11) == true) goto L11;
        return false;
    L11:
        return completeIsSubTypeOf(r5, r10, r11, r12);
    }
}
