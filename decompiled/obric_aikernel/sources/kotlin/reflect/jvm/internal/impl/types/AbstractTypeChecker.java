package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
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
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = null;

    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r10 = new int[TypeVariance.values().length];
            r10[TypeVariance.INV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r10[TypeVariance.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r10[TypeVariance.IN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            $EnumSwitchMapping$0 = r10;
            int[] r11 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            r11[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r11[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r11[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            $EnumSwitchMapping$1 = r11;
        }
    }

    static {
        INSTANCE = new AbstractTypeChecker();
    }

    private AbstractTypeChecker() {
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState r10, SimpleTypeMarker r11, SimpleTypeMarker r12) {
        TypeSystemContext r13 = r10.getTypeSystemContext();
        if (r13.isIntegerLiteralType(r11) == true) goto L8;
        if (r13.isIntegerLiteralType(r12) == true) goto L8;
        return null;
    L8:
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(r13, r11) == false) goto L14;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(r13, r12) == false) goto L14;
        return Boolean.TRUE;
    L14:
        if (r13.isIntegerLiteralType(r11) == false) goto L20;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(r13, r10, r11, r12, false) == true) goto L18;
    L27:
        return null;
    L18:
        return Boolean.TRUE;
    L20:
        if (r13.isIntegerLiteralType(r12) == false) goto L27;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(r13, r11) == true) goto L26;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(r13, r10, r12, r11, true) == false) goto L27;
    L26:
        return Boolean.TRUE;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(TypeSystemContext r10, SimpleTypeMarker r11) {
        if ((r11 instanceof CapturedTypeMarker) == true) goto L5;
        return false;
    L5:
        TypeArgumentMarker r12 = r10.projection(r10.typeConstructor((CapturedTypeMarker) r11));
        if (r10.isStarProjection(r12) == false) goto L8;
        return false;
    L8:
        if (r10.isIntegerLiteralType(r10.upperBoundIfFlexible(r10.getType(r12))) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext r10, SimpleTypeMarker r11) {
        TypeConstructorMarker r12 = r10.typeConstructor(r11);
        if ((r12 instanceof IntersectionTypeConstructorMarker) == false) goto L23;
        Collection<KotlinTypeMarker> r13 = r10.supertypes(r12);
        if ((r13 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L8;
        SimpleTypeMarker r15 = r10.asSimpleType((KotlinTypeMarker) r14.next());
        if (r15 != null) goto L15;
    L17:
        boolean r16 = false;
    L18:
        if (r16 == false) goto L11;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L23;
        return true;
    L15:
        if (r10.isIntegerLiteralType(r15) != true) goto L17;
        r16 = true;
    L8:
        r17 = false;
        goto L20
    L7:
        if (r13.isEmpty() == false) goto L9;
    L23:
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext r10, SimpleTypeMarker r11) {
        if (r10.isIntegerLiteralType(r11) == false) goto L5;
    L8:
        return true;
    L5:
        if (checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(r10, r11) == true) goto L8;
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(TypeSystemContext r10, TypeCheckerState r11, SimpleTypeMarker r12, SimpleTypeMarker r13, boolean r14) {
        Collection<KotlinTypeMarker> r15 = r10.possibleIntegerTypes(r12);
        if ((r15 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L19;
        KotlinTypeMarker r17 = (KotlinTypeMarker) r16.next();
        if (Intrinsics.areEqual(r10.typeConstructor(r17), r10.typeConstructor(r13)) == true) goto L17;
        if (r14 == true) goto L14;
    L16:
        boolean r18 = false;
    L18:
        if (r18 == false) goto L9;
        return true;
    L14:
        if (isSubtypeOf$default(INSTANCE, r11, r13, r17, false, 8, null) == false) goto L16;
    L17:
        r18 = true;
    L19:
        return false;
    L5:
        if (r15.isEmpty() == false) goto L7;
        goto L7
    }

    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState r13, SimpleTypeMarker r14, SimpleTypeMarker r15) {
        TypeSystemContext r12 = r13.getTypeSystemContext();
        boolean r10 = false;
        if (r12.isError(r14) == true) goto L91;
        if (r12.isError(r15) == true) goto L91;
        if (r12.isStubTypeForBuilderInference(r14) == false) goto L19;
        if (r12.isStubTypeForBuilderInference(r15) == false) goto L19;
        if (INSTANCE.isStubTypeSubtypeOfAnother(r12, r14, r15) == false) goto L14;
    L15:
        r10 = true;
    L17:
        return Boolean.valueOf(r10);
    L14:
        if (r13.isStubTypeEqualsToAnything() == false) goto L17;
    L19:
        if (r12.isStubType(r14) == false) goto L21;
    L89:
        boolean r16 = r13.isStubTypeEqualsToAnything();
    L52:
        return Boolean.valueOf(r16);
    L21:
        if (r12.isStubType(r15) == true) goto L89;
        DefinitelyNotNullTypeMarker r11 = r12.asDefinitelyNotNullType(r15);
        if (r11 == null) goto L27;
        SimpleTypeMarker r17 = r12.original(r11);
        if (r17 == null) goto L27;
    L28:
        CapturedTypeMarker r18 = r12.asCapturedType(r17);
        if (r18 == null) goto L31;
        KotlinTypeMarker r19 = r12.lowerType(r18);
    L32:
        if (r18 == null) goto L53;
        if (r19 == null) goto L53;
        if (r12.isMarkedNullable(r15) == false) goto L39;
        r19 = r12.withNullability(r19, true);
    L37:
        KotlinTypeMarker r20 = r19;
        int r21 = WhenMappings.$EnumSwitchMapping$1[r13.getLowerCapturedTypePolicy(r14, r18).ordinal()];
        if (r21 != 1) goto L44;
        r16 = isSubtypeOf$default(INSTANCE, r13, r14, r20, false, 8, null);
        goto L52
    L44:
        if (r21 != 2) goto L53;
        if (isSubtypeOf$default(INSTANCE, r13, r14, r20, false, 8, null) == false) goto L53;
        return Boolean.TRUE;
    L39:
        if (r12.isDefinitelyNotNullType(r15) == false) goto L37;
        r19 = r12.makeDefinitelyNotNullOrNotNull(r19);
    L53:
        TypeConstructorMarker r22 = r12.typeConstructor(r15);
        if (r12.isIntersection(r22) == false) goto L67;
        r12.isMarkedNullable(r15);
        Collection<KotlinTypeMarker> r110 = r12.supertypes(r22);
        if ((r110 instanceof Collection) == true) goto L58;
    L60:
        Iterator<T> r111 = r110.iterator();
    L62:
        if (r111.hasNext() == false) goto L59;
        if (isSubtypeOf$default(INSTANCE, r13, r14, (KotlinTypeMarker) r111.next(), false, 8, null) == true) goto L62;
    L66:
        return Boolean.valueOf(r10);
    L59:
        r10 = true;
        goto L66
    L58:
        if (r110.isEmpty() == false) goto L60;
    L67:
        TypeConstructorMarker r23 = r12.typeConstructor(r14);
        if ((r14 instanceof CapturedTypeMarker) == false) goto L70;
    L82:
        TypeParameterMarker r112 = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(r13.getTypeSystemContext(), r15, r14);
        if (r112 != null) goto L85;
    L88:
        return null;
    L85:
        if (r12.hasRecursiveBounds(r112, r12.typeConstructor(r15)) == false) goto L88;
        return Boolean.TRUE;
    L70:
        if (r12.isIntersection(r23) == false) goto L88;
        Collection<KotlinTypeMarker> r24 = r12.supertypes(r23);
        if ((r24 instanceof Collection) == true) goto L74;
    L76:
        Iterator<T> r25 = r24.iterator();
    L78:
        if (r25.hasNext() == false) goto L75;
        if ((((KotlinTypeMarker) r25.next()) instanceof CapturedTypeMarker) == true) goto L78;
    L81:
        if (r10 == false) goto L88;
    L75:
        r10 = true;
        goto L81
    L74:
        if (r24.isEmpty() == false) goto L76;
    L31:
        r19 = null;
    L27:
        r17 = r15;
    L91:
        if (r13.isErrorTypeEqualsToAnything() == false) goto L95;
        return Boolean.TRUE;
    L95:
        if (r12.isMarkedNullable(r14) == true) goto L97;
    L100:
        r16 = AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(r12, r12.withNullability(r14, false), r12.withNullability(r15, false));
        goto L52
    L97:
        if (r12.isMarkedNullable(r15) == true) goto L100;
        return Boolean.FALSE;
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState r12, SimpleTypeMarker r13, TypeConstructorMarker r14) {
        TypeSystemContext r11 = r12.getTypeSystemContext();
        List<SimpleTypeMarker> r10 = r11.fastCorrespondingSupertypes(r13, r14);
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (r11.isClassTypeConstructor(r14) == true) goto L12;
        if (r11.isClassType(r13) == false) goto L12;
        return CollectionsKt.emptyList();
    L12:
        if (r11.isCommonFinalClassConstructor(r14) == true) goto L14;
        SmartList r15 = new SmartList();
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r16 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r16);
        Set<SimpleTypeMarker> r17 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r17);
        r16.push(r13);
    L24:
        if ((!r16.isEmpty()) == false) goto L51;
        if (r17.size() > 1000) goto L50;
        SimpleTypeMarker r18 = r16.pop();
        Intrinsics.checkNotNullExpressionValue(r18, "current");
        if (r17.add(r18) == false) goto L24;
        SimpleTypeMarker r19 = r11.captureFromArguments(r18, CaptureStatus.FOR_SUBTYPING);
        if (r19 != null) goto L33;
        r19 = r18;
    L33:
        if (r11.areEqualTypeConstructors(r11.typeConstructor(r19), r14) == false) goto L36;
        r15.add(r19);
        TypeCheckerState.SupertypesPolicy r20 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L40:
        if ((!Intrinsics.areEqual(r20, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L43;
        r20 = null;
    L43:
        if (r20 == null) goto L24;
        TypeSystemContext r21 = r12.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r22 = r21.supertypes(r21.typeConstructor(r18)).iterator();
    L47:
        if (r22.hasNext() == false) goto L24;
        r16.add(r20.mo1327transformType(r12, r22.next()));
        goto L47
    L36:
        if (r11.argumentsCount(r19) != 0) goto L38;
        r20 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L40
    L38:
        r20 = r12.getTypeSystemContext().substitutionSupertypePolicy(r19);
        goto L40
    L50:
        throw new IllegalStateException(("Too many supertypes for type: " + r13 + ". Supertypes = " + CollectionsKt.joinToString$default(r17, null, null, null, 0, null, null, 63, null)).toString());
    L51:
        r12.clear();
        return r15;
    L14:
        if (r11.areEqualTypeConstructors(r11.typeConstructor(r13), r14) == false) goto L21;
        SimpleTypeMarker r110 = r11.captureFromArguments(r13, CaptureStatus.FOR_SUBTYPING);
        if (r110 == null) goto L61;
        r13 = r110;
    L61:
        return CollectionsKt.listOf(r13);
    L21:
        return CollectionsKt.emptyList();
    }

    private final List<SimpleTypeMarker> collectAndFilter(TypeCheckerState r10, SimpleTypeMarker r11, TypeConstructorMarker r12) {
        return selectOnlyPureKotlinSupertypes(r10, collectAllSupertypesWithGivenTypeConstructor(r10, r11, r12));
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState r10, KotlinTypeMarker r11, KotlinTypeMarker r12, boolean r13) {
        TypeSystemContext r14 = r10.getTypeSystemContext();
        KotlinTypeMarker r15 = r10.prepareType(r10.refineType(r11));
        KotlinTypeMarker r16 = r10.prepareType(r10.refineType(r12));
        AbstractTypeChecker r17 = INSTANCE;
        Boolean r18 = r17.checkSubtypeForSpecialCases(r10, r14.lowerBoundIfFlexible(r15), r14.upperBoundIfFlexible(r16));
        if (r18 == null) goto L6;
        boolean r19 = r18.booleanValue();
        r10.addSubtypeConstraint(r15, r16, r13);
        return r19;
    L6:
        Boolean r20 = r10.addSubtypeConstraint(r15, r16, r13);
        if (r20 == null) goto L11;
        return r20.booleanValue();
    L11:
        return r17.isSubtypeOfForSingleClassifierType(r10, r14.lowerBoundIfFlexible(r15), r14.upperBoundIfFlexible(r16));
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext r10, KotlinTypeMarker r11, KotlinTypeMarker r12) {
        int r13 = r10.argumentsCount(r11);
        int r14 = 0;
    L3:
        TypeArgumentMarker r15 = null;
        if (r14 >= r13) goto L30;
        TypeArgumentMarker r16 = r10.getArgument(r11, r14);
        boolean r17 = true;
        if ((!r10.isStarProjection(r16)) == false) goto L8;
        r15 = r16;
    L8:
        if (r15 == null) goto L29;
        KotlinTypeMarker r18 = r10.getType(r15);
        if (r18 == null) goto L29;
        if (r10.isCapturedType(r10.lowerBoundIfFlexible(r18)) == true) goto L15;
    L17:
        r17 = false;
    L19:
        if (Intrinsics.areEqual(r18, r12) == true) goto L28;
        if (r17 == true) goto L22;
    L24:
        TypeParameterMarker r19 = getTypeParameterForArgumentInBaseIfItEqualToTarget(r10, r18, r12);
        if (r19 == null) goto L29;
        return r19;
    L22:
        if (Intrinsics.areEqual(r10.typeConstructor(r18), r10.typeConstructor(r12)) == false) goto L24;
    L28:
        return r10.getParameter(r10.typeConstructor(r11), r14);
    L15:
        if (r10.isCapturedType(r10.lowerBoundIfFlexible(r12)) == false) goto L17;
    L29:
        r14 = r14 + 1;
        goto L3
    L30:
        return null;
    }

    private final boolean hasNothingSupertype(TypeCheckerState r12, SimpleTypeMarker r13) {
        TypeSystemContext r11 = r12.getTypeSystemContext();
        TypeConstructorMarker r10 = r11.typeConstructor(r13);
        if (r11.isClassTypeConstructor(r10) == false) goto L7;
        return r11.isNothingConstructor(r10);
    L7:
        if (r11.isNothingConstructor(r11.typeConstructor(r13)) == true) goto L47;
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r14 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r14);
        Set<SimpleTypeMarker> r15 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r15);
        r14.push(r13);
    L11:
        if ((!r14.isEmpty()) == false) goto L35;
        if (r15.size() > 1000) goto L34;
        SimpleTypeMarker r16 = r14.pop();
        Intrinsics.checkNotNullExpressionValue(r16, "current");
        if (r15.add(r16) == false) goto L11;
        if (r11.isClassType(r16) == false) goto L19;
        TypeCheckerState.SupertypesPolicy r17 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L21:
        if ((!Intrinsics.areEqual(r17, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L24;
        r17 = null;
    L24:
        if (r17 == null) goto L11;
        TypeSystemContext r18 = r12.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r19 = r18.supertypes(r18.typeConstructor(r16)).iterator();
    L28:
        if (r19.hasNext() == false) goto L11;
        SimpleTypeMarker r20 = r17.mo1327transformType(r12, r19.next());
        if (r11.isNothingConstructor(r11.typeConstructor(r20)) == true) goto L31;
        r14.add(r20);
        goto L28
    L31:
        r12.clear();
        return true;
    L19:
        r17 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L21
    L34:
        throw new IllegalStateException(("Too many supertypes for type: " + r13 + ". Supertypes = " + CollectionsKt.joinToString$default(r15, null, null, null, 0, null, null, 63, null)).toString());
    L35:
        r12.clear();
        return false;
    L47:
        return true;
    }

    private final boolean isCommonDenotableType(TypeSystemContext r10, KotlinTypeMarker r11) {
        if (r10.isDenotable(r10.typeConstructor(r11)) == true) goto L5;
    L13:
        return false;
    L5:
        if (r10.isDynamic(r11) == true) goto L13;
        if (r10.isDefinitelyNotNullType(r11) == true) goto L13;
        if (r10.isNotNullTypeParameter(r11) == true) goto L13;
        if (Intrinsics.areEqual(r10.typeConstructor(r10.lowerBoundIfFlexible(r11)), r10.typeConstructor(r10.upperBoundIfFlexible(r11))) == false) goto L13;
        return true;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext r10, SimpleTypeMarker r11, SimpleTypeMarker r12) {
        DefinitelyNotNullTypeMarker r13 = r10.asDefinitelyNotNullType(r11);
        if (r13 == null) goto L6;
        SimpleTypeMarker r14 = r10.original(r13);
        if (r14 == null) goto L6;
    L7:
        DefinitelyNotNullTypeMarker r15 = r10.asDefinitelyNotNullType(r12);
        if (r15 == null) goto L11;
        SimpleTypeMarker r16 = r10.original(r15);
        if (r16 == null) goto L11;
    L13:
        if (r10.typeConstructor(r14) == r10.typeConstructor(r16)) goto L16;
        return false;
    L16:
        if (r10.isDefinitelyNotNullType(r11) == true) goto L21;
        if (r10.isDefinitelyNotNullType(r12) == false) goto L21;
        return false;
    L21:
        if (r10.isMarkedNullable(r11) == true) goto L23;
        return true;
    L23:
        if (r10.isMarkedNullable(r12) == true) goto L27;
        return false;
    L27:
        return true;
    L11:
        r16 = r12;
    L6:
        r14 = r11;
        goto L7
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker r10, TypeCheckerState r11, KotlinTypeMarker r12, KotlinTypeMarker r13, boolean r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L6;
        r14 = false;
    L6:
        return r10.isSubtypeOf(r11, r12, r13, r14);
    }

    private final boolean isSubtypeOfForSingleClassifierType(final TypeCheckerState r17, SimpleTypeMarker r18, final SimpleTypeMarker r19) {
        final TypeSystemContext r10 = r17.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS == true) goto L5;
    L12:
        boolean r11 = false;
        if (AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(r17, r18, r19) == true) goto L15;
        return false;
    L15:
        AbstractTypeChecker r12 = INSTANCE;
        Boolean r13 = r12.checkSubtypeForIntegerLiteralType(r17, r10.lowerBoundIfFlexible(r18), r10.upperBoundIfFlexible(r19));
        if (r13 == null) goto L19;
        boolean r14 = r13.booleanValue();
        TypeCheckerState.addSubtypeConstraint$default(r17, r18, r19, false, 4, null);
        return r14;
    L19:
        TypeConstructorMarker r15 = r10.typeConstructor(r19);
        boolean r16 = true;
        if (r10.areEqualTypeConstructors(r10.typeConstructor(r18), r15) == false) goto L25;
        if (r10.parametersCount(r15) != 0) goto L25;
        return true;
    L25:
        if (r10.isAnyConstructor(r10.typeConstructor(r19)) == false) goto L27;
        return true;
    L27:
        List<SimpleTypeMarker> r20 = r12.findCorrespondingSupertypes(r17, r18, r15);
        int r21 = 10;
        final ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r23 = r20.iterator();
    L29:
        if (r23.hasNext() == false) goto L35;
        SimpleTypeMarker r110 = (SimpleTypeMarker) r23.next();
        SimpleTypeMarker r111 = r10.asSimpleType(r17.prepareType(r110));
        if (r111 == null) goto L34;
        r110 = r111;
    L34:
        r22.add(r110);
        goto L29
    L35:
        int r24 = r22.size();
        if (r24 == 0) goto L77;
        if (r24 == 1) goto L75;
        ArgumentList r25 = new ArgumentList(r10.parametersCount(r15));
        int r112 = r10.parametersCount(r15);
        int r113 = 0;
        boolean r114 = false;
    L39:
        if (r113 >= r112) goto L67;
        if (r114 == false) goto L42;
    L45:
        r114 = r16;
    L46:
        if (r114 == true) goto L66;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, r21));
        Iterator r116 = r22.iterator();
    L49:
        if (r116.hasNext() == false) goto L65;
        SimpleTypeMarker r117 = (SimpleTypeMarker) r116.next();
        TypeArgumentMarker r26 = r10.getArgumentOrNull(r117, r113);
        if (r26 == null) goto L64;
        if (r10.getVariance(r26) != TypeVariance.INV) goto L55;
        boolean r27 = true;
    L56:
        if (r27 == true) goto L59;
        r26 = null;
    L59:
        if (r26 == null) goto L64;
        KotlinTypeMarker r28 = r10.getType(r26);
        if (r28 == null) goto L64;
        r115.add(r28);
        goto L49
    L55:
        r27 = false;
    L64:
        throw new IllegalStateException(("Incorrect type: " + r117 + ", subType: " + r18 + ", superType: " + r19).toString());
    L65:
        r25.add(r10.asTypeArgument(r10.intersectTypes(r115)));
    L66:
        r113 = r113 + 1;
        r11 = false;
        r16 = true;
        r21 = 10;
        goto L39
    L42:
        if (r10.getVariance(r10.getParameter(r15, r113)) != TypeVariance.OUT) goto L45;
        r114 = r11;
        goto L46
    L67:
        if (r114 == true) goto L73;
        if (INSTANCE.isSubtypeForSameConstructor(r17, r25, r19) == false) goto L73;
        return true;
    L73:
        return r17.runForkingPoint(new AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4(r22, r17, r10, r19));
    L75:
        return INSTANCE.isSubtypeForSameConstructor(r17, r10.asArgumentList((SimpleTypeMarker) CollectionsKt.first(r22)), r19);
    L77:
        return INSTANCE.hasNothingSupertype(r17, r18);
    L5:
        if (r10.isSingleClassifierType(r18) == true) goto L10;
        if (r10.isIntersection(r10.typeConstructor(r18)) == true) goto L10;
        r17.isAllowedTypeVariable(r18);
    L10:
        if (r10.isSingleClassifierType(r19) == true) goto L12;
        r17.isAllowedTypeVariable(r19);
        goto L12
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext r10, KotlinTypeMarker r11, KotlinTypeMarker r12, TypeConstructorMarker r13) {
        SimpleTypeMarker r14 = r10.asSimpleType(r11);
        if ((r14 instanceof CapturedTypeMarker) == false) goto L24;
        CapturedTypeMarker r15 = (CapturedTypeMarker) r14;
        if (r10.isOldCapturedType(r15) == false) goto L7;
        return false;
    L7:
        if (r10.isStarProjection(r10.projection(r10.typeConstructor(r15))) == true) goto L10;
        return false;
    L10:
        if (r10.captureStatus(r15) == CaptureStatus.FOR_SUBTYPING) goto L12;
        return false;
    L12:
        TypeConstructorMarker r16 = r10.typeConstructor(r12);
        if ((r16 instanceof TypeVariableTypeConstructorMarker) == false) goto L15;
        TypeVariableTypeConstructorMarker r17 = (TypeVariableTypeConstructorMarker) r16;
    L16:
        if (r17 != null) goto L18;
        return false;
    L18:
        TypeParameterMarker r18 = r10.getTypeParameter(r17);
        if (r18 != null) goto L21;
        return false;
    L21:
        if (r10.hasRecursiveBounds(r18, r13) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        r17 = null;
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
        Iterator r14 = r11.iterator();
    L6:
        boolean r15 = true;
        if (r14.hasNext() == false) goto L20;
        Object r16 = r14.next();
        TypeArgumentListMarker r17 = r12.asArgumentList((SimpleTypeMarker) r16);
        int r18 = r12.size(r17);
        int r19 = 0;
    L9:
        if (r19 >= r18) goto L17;
        if (r12.asFlexibleType(r12.getType(r12.get(r17, r19))) != null) goto L13;
        boolean r20 = true;
    L14:
        if (r20 == false) goto L15;
        r19 = r19 + 1;
        goto L9
    L15:
        r15 = false;
        goto L17
    L13:
        r20 = false;
    L17:
        if (r15 == false) goto L6;
        r13.add(r16);
        goto L6
    L20:
        if ((!r13.isEmpty()) == true) goto L22;
        return r11;
    L22:
        return r13;
    }

    public final TypeVariance effectiveVariance(TypeVariance r10, TypeVariance r11) {
        Intrinsics.checkNotNullParameter(r10, "declared");
        Intrinsics.checkNotNullParameter(r11, "useSite");
        TypeVariance r12 = TypeVariance.INV;
        if (r10 != r12) goto L5;
        return r11;
    L5:
        if (r11 != r12) goto L7;
        return r10;
    L7:
        if (r10 != r11) goto L9;
        return r10;
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
        KotlinTypeMarker r15 = r11.prepareType(r11.refineType(r12));
        KotlinTypeMarker r16 = r11.prepareType(r11.refineType(r13));
        SimpleTypeMarker r17 = r10.lowerBoundIfFlexible(r15);
        if (r10.areEqualTypeConstructors(r10.typeConstructor(r15), r10.typeConstructor(r16)) == true) goto L13;
        return false;
    L13:
        if (r10.argumentsCount(r17) != 0) goto L25;
        if (r10.hasFlexibleNullability(r15) == false) goto L17;
        return true;
    L17:
        if (r10.hasFlexibleNullability(r16) == false) goto L20;
        return true;
    L20:
        if (r10.isMarkedNullable(r17) != r10.isMarkedNullable(r10.lowerBoundIfFlexible(r16))) goto L23;
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
        SmartList r10 = new SmartList();
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r15 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r15);
        Set<SimpleTypeMarker> r16 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r16);
        r15.push(r13);
    L14:
        if ((!r15.isEmpty()) == false) goto L35;
        if (r16.size() > 1000) goto L34;
        SimpleTypeMarker r17 = r15.pop();
        Intrinsics.checkNotNullExpressionValue(r17, "current");
        if (r16.add(r17) == false) goto L14;
        if (r11.isClassType(r17) == false) goto L22;
        r10.add(r17);
        TypeCheckerState.SupertypesPolicy r18 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L24:
        if ((!Intrinsics.areEqual(r18, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L27;
        r18 = null;
    L27:
        if (r18 == null) goto L14;
        TypeSystemContext r19 = r12.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r20 = r19.supertypes(r19.typeConstructor(r17)).iterator();
    L31:
        if (r20.hasNext() == false) goto L14;
        r15.add(r18.mo1327transformType(r12, r20.next()));
        goto L31
    L22:
        r18 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L24
    L34:
        throw new IllegalStateException(("Too many supertypes for type: " + r13 + ". Supertypes = " + CollectionsKt.joinToString$default(r16, null, null, null, 0, null, null, 63, null)).toString());
    L35:
        r12.clear();
        ArrayList r110 = new ArrayList();
        Iterator<E> r111 = r10.iterator();
    L37:
        if (r111.hasNext() == false) goto L39;
        SimpleTypeMarker r21 = (SimpleTypeMarker) r111.next();
        AbstractTypeChecker r22 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r21, "it");
        CollectionsKt.addAll(r110, r22.collectAndFilter(r12, r21, r14));
        goto L37
    L39:
        return r110;
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
        int r12 = r10.size(r18);
        int r13 = r10.parametersCount(r11);
        if (r12 == r13) goto L5;
    L46:
        return false;
    L5:
        if (r12 != r10.argumentsCount(r19)) goto L46;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L45;
        TypeArgumentMarker r15 = r10.getArgument(r19, r14);
        if (r10.isStarProjection(r15) == true) goto L44;
        KotlinTypeMarker r16 = r10.getType(r15);
        TypeArgumentMarker r20 = r10.get(r18, r14);
        r10.getVariance(r20);
        TypeVariance r21 = TypeVariance.INV;
        KotlinTypeMarker r22 = r10.getType(r20);
        AbstractTypeChecker r23 = INSTANCE;
        TypeVariance r24 = r23.effectiveVariance(r10.getVariance(r10.getParameter(r11, r14)), r10.getVariance(r15));
        if (r24 == null) goto L15;
        if (r24 == r21) goto L18;
    L22:
        boolean r25 = false;
    L23:
        if (r25 == true) goto L44;
        if (TypeCheckerState.access$getArgumentsDepth(r17) > 100) goto L43;
        TypeCheckerState.access$setArgumentsDepth(r17, TypeCheckerState.access$getArgumentsDepth(r17) + 1);
        int r26 = WhenMappings.$EnumSwitchMapping$0[r24.ordinal()];
        if (r26 != 1) goto L30;
        boolean r27 = r23.equalTypes(r17, r22, r16);
    L39:
        TypeCheckerState.access$setArgumentsDepth(r17, TypeCheckerState.access$getArgumentsDepth(r17) - 1);
        if (r27 == true) goto L44;
        return false;
    L30:
        if (r26 != 2) goto L32;
        boolean r28 = false;
        int r29 = 8;
        Object r110 = null;
        KotlinTypeMarker r30 = r22;
    L37:
        r27 = isSubtypeOf$default(r23, r17, r30, r16, r28, r29, r110);
        goto L39
    L32:
        if (r26 != 3) goto L35;
        r28 = false;
        r29 = 8;
        r110 = null;
        r30 = r16;
        r16 = r22;
        goto L37
    L35:
        throw new NoWhenBranchMatchedException();
    L43:
        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + r22).toString());
    L18:
        if (r23.isTypeVariableAgainstStarProjectionForSelfType(r10, r22, r16, r11) == false) goto L20;
    L21:
        r25 = true;
        goto L23
    L20:
        if (r23.isTypeVariableAgainstStarProjectionForSelfType(r10, r16, r22, r11) == false) goto L22;
    L15:
        return r17.isErrorTypeEqualsToAnything();
    L44:
        r14 = r14 + 1;
        goto L9
    L45:
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
    public final boolean isSubtypeOf(TypeCheckerState r10, KotlinTypeMarker r11, KotlinTypeMarker r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "subType");
        Intrinsics.checkNotNullParameter(r12, "superType");
        if (r11 != r12) goto L7;
        return true;
    L7:
        if (r10.customIsSubtypeOf(r11, r12) == true) goto L11;
        return false;
    L11:
        return completeIsSubTypeOf(r10, r11, r12, r13);
    }
}
