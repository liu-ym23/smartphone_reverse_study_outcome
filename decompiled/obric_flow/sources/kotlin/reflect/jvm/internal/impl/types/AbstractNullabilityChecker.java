package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractNullabilityChecker\n+ 2 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,835:1\n132#2,16:836\n148#2,13:853\n132#2,16:866\n148#2,13:883\n1#3:852\n1#3:882\n*S KotlinDebug\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractNullabilityChecker\n*L\n779#1:836,16\n779#1:853,13\n793#1:866,16\n793#1:883,13\n779#1:852\n793#1:882\n*E\n"})
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = null;

    static {
        INSTANCE = new AbstractNullabilityChecker();
    }

    private AbstractNullabilityChecker() {
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState r5, SimpleTypeMarker r10, TypeConstructorMarker r11) {
        TypeSystemContext r12 = r5.getTypeSystemContext();
        if (r12.isNothing(r10) == false) goto L6;
        return true;
    L6:
        if (r12.isMarkedNullable(r10) == false) goto L10;
        return false;
    L10:
        if (r5.isStubTypeEqualsToAnything() == false) goto L15;
        if (r12.isStubType(r10) == false) goto L15;
        return true;
    L15:
        return r12.areEqualTypeConstructors(r12.typeConstructor(r10), r11);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState r5, SimpleTypeMarker r10, SimpleTypeMarker r11) {
        TypeSystemContext r12 = r5.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS == false) goto L13;
        if (r12.isSingleClassifierType(r10) == true) goto L10;
        if (r12.isIntersection(r12.typeConstructor(r10)) == true) goto L10;
        r5.isAllowedTypeVariable(r10);
    L10:
        if (r12.isSingleClassifierType(r11) == true) goto L13;
        r5.isAllowedTypeVariable(r11);
    L13:
        if (r12.isMarkedNullable(r11) == false) goto L16;
        return true;
    L16:
        if (r12.isDefinitelyNotNullType(r10) == false) goto L18;
    L39:
        return true;
    L18:
        if (r12.isNotNullTypeParameter(r10) == true) goto L39;
        if ((r10 instanceof CapturedTypeMarker) == true) goto L23;
    L25:
        AbstractNullabilityChecker r13 = INSTANCE;
        if (r13.hasNotNullSupertype(r5, r10, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE) == false) goto L29;
        return true;
    L29:
        if (r12.isDefinitelyNotNullType(r11) == false) goto L32;
        return false;
    L32:
        if (r13.hasNotNullSupertype(r5, r11, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) == false) goto L35;
        return false;
    L35:
        if (r12.isClassType(r10) == false) goto L38;
        return false;
    L38:
        return r13.hasPathByNotMarkedNullableNodes(r5, r10, r12.typeConstructor(r11));
    L23:
        if (r12.isProjectionNotNull((CapturedTypeMarker) r10) == false) goto L25;
        return true;
    }

    public final boolean hasNotNullSupertype(TypeCheckerState r12, SimpleTypeMarker r13, TypeCheckerState.SupertypesPolicy r14) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "supertypesPolicy");
        TypeSystemContext r11 = r12.getTypeSystemContext();
        if (r11.isClassType(r13) == false) goto L7;
        if (r11.isMarkedNullable(r13) == true) goto L7;
        return true;
    L7:
        if (r11.isDefinitelyNotNullType(r13) == true) goto L53;
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r5 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r5);
        Set<SimpleTypeMarker> r10 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r10);
        r5.push(r13);
    L11:
        if (r5.isEmpty() == true) goto L39;
        if (r10.size() > 1000) goto L37;
        SimpleTypeMarker r15 = r5.pop();
        if (r10.add(r15) == false) goto L11;
        if (r11.isMarkedNullable(r15) == false) goto L19;
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
        if (r11.isClassType(r19) == false) goto L34;
        if (r11.isMarkedNullable(r19) == true) goto L34;
    L35:
        r12.clear();
        return true;
    L34:
        if (r11.isDefinitelyNotNullType(r19) == true) goto L35;
        r5.add(r19);
        goto L28
    L19:
        r16 = r14;
        goto L21
    L37:
        StringBuilder r110 = a.i("Too many supertypes for type: ", r13, ". Supertypes = ");
        r110.append(CollectionsKt.q(r10, null, null, null, 0, null, null, 63));
        throw new IllegalStateException(r110.toString().toString());
    L39:
        r12.clear();
        return false;
    L53:
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(TypeCheckerState r12, SimpleTypeMarker r13, TypeConstructorMarker r14) {
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r13, "start");
        Intrinsics.checkNotNullParameter(r14, "end");
        TypeSystemContext r11 = r12.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(r12, r13, r14) == true) goto L43;
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r5 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r5);
        Set<SimpleTypeMarker> r10 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r10);
        r5.push(r13);
    L7:
        if (r5.isEmpty() == true) goto L31;
        if (r10.size() > 1000) goto L29;
        SimpleTypeMarker r15 = r5.pop();
        if (r10.add(r15) == false) goto L7;
        if (r11.isMarkedNullable(r15) == false) goto L15;
        TypeCheckerState.SupertypesPolicy r16 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L17:
        if (Intrinsics.areEqual(r16, TypeCheckerState.SupertypesPolicy.None.INSTANCE) == false) goto L20;
        r16 = null;
    L20:
        if (r16 == null) goto L7;
        TypeSystemContext r17 = r12.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r18 = r17.supertypes(r17.typeConstructor(r15)).iterator();
    L24:
        if (r18.hasNext() == false) goto L7;
        SimpleTypeMarker r19 = r16.mo1406transformType(r12, r18.next());
        if (INSTANCE.isApplicableAsEndNode(r12, r19, r14) == true) goto L27;
        r5.add(r19);
        goto L24
    L27:
        r12.clear();
        return true;
    L15:
        r16 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L17
    L29:
        StringBuilder r110 = a.i("Too many supertypes for type: ", r13, ". Supertypes = ");
        r110.append(CollectionsKt.q(r10, null, null, null, 0, null, null, 63));
        throw new IllegalStateException(r110.toString().toString());
    L31:
        r12.clear();
        return false;
    L43:
        return true;
    }

    public final boolean isPossibleSubtype(TypeCheckerState r5, SimpleTypeMarker r10, SimpleTypeMarker r11) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r10, "subType");
        Intrinsics.checkNotNullParameter(r11, "superType");
        return runIsPossibleSubtype(r5, r10, r11);
    }
}
