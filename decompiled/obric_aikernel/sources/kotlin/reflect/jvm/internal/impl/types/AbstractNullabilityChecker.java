package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = null;

    static {
        INSTANCE = new AbstractNullabilityChecker();
    }

    private AbstractNullabilityChecker() {
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState r10, SimpleTypeMarker r11, TypeConstructorMarker r12) {
        TypeSystemContext r13 = r10.getTypeSystemContext();
        if (r13.isNothing(r11) == false) goto L6;
        return true;
    L6:
        if (r13.isMarkedNullable(r11) == false) goto L10;
        return false;
    L10:
        if (r10.isStubTypeEqualsToAnything() == false) goto L15;
        if (r13.isStubType(r11) == false) goto L15;
        return true;
    L15:
        return r13.areEqualTypeConstructors(r13.typeConstructor(r11), r12);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState r10, SimpleTypeMarker r11, SimpleTypeMarker r12) {
        TypeSystemContext r13 = r10.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS == false) goto L13;
        if (r13.isSingleClassifierType(r11) == true) goto L10;
        if (r13.isIntersection(r13.typeConstructor(r11)) == true) goto L10;
        r10.isAllowedTypeVariable(r11);
    L10:
        if (r13.isSingleClassifierType(r12) == true) goto L13;
        r10.isAllowedTypeVariable(r12);
    L13:
        if (r13.isMarkedNullable(r12) == false) goto L16;
        return true;
    L16:
        if (r13.isDefinitelyNotNullType(r11) == false) goto L18;
    L39:
        return true;
    L18:
        if (r13.isNotNullTypeParameter(r11) == true) goto L39;
        if ((r11 instanceof CapturedTypeMarker) == true) goto L23;
    L25:
        AbstractNullabilityChecker r14 = INSTANCE;
        if (r14.hasNotNullSupertype(r10, r11, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE) == false) goto L29;
        return true;
    L29:
        if (r13.isDefinitelyNotNullType(r12) == false) goto L32;
        return false;
    L32:
        if (r14.hasNotNullSupertype(r10, r12, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) == false) goto L35;
        return false;
    L35:
        if (r13.isClassType(r11) == false) goto L38;
        return false;
    L38:
        return r14.hasPathByNotMarkedNullableNodes(r10, r11, r13.typeConstructor(r12));
    L23:
        if (r13.isProjectionNotNull((CapturedTypeMarker) r11) == false) goto L25;
        return true;
    }

    public final boolean hasNotNullSupertype(TypeCheckerState r13, SimpleTypeMarker r14, TypeCheckerState.SupertypesPolicy r15) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r14, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r15, "supertypesPolicy");
        TypeSystemContext r12 = r13.getTypeSystemContext();
        if (r12.isClassType(r14) == false) goto L7;
        if (r12.isMarkedNullable(r14) == true) goto L7;
    L8:
        boolean r10 = true;
    L10:
        if (r10 == true) goto L56;
        r13.initialize();
        ArrayDeque<SimpleTypeMarker> r11 = r13.getSupertypesDeque();
        Intrinsics.checkNotNull(r11);
        Set<SimpleTypeMarker> r16 = r13.getSupertypesSet();
        Intrinsics.checkNotNull(r16);
        r11.push(r14);
    L14:
        if ((!r11.isEmpty()) == false) goto L45;
        if (r16.size() > 1000) goto L44;
        SimpleTypeMarker r17 = r11.pop();
        Intrinsics.checkNotNullExpressionValue(r17, "current");
        if (r16.add(r17) == false) goto L14;
        if (r12.isMarkedNullable(r17) == false) goto L22;
        TypeCheckerState.SupertypesPolicy r18 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L24:
        if ((!Intrinsics.areEqual(r18, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L27;
        r18 = null;
    L27:
        if (r18 == null) goto L14;
        TypeSystemContext r19 = r13.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r20 = r19.supertypes(r19.typeConstructor(r17)).iterator();
    L31:
        if (r20.hasNext() == false) goto L14;
        SimpleTypeMarker r21 = r18.mo1327transformType(r13, r20.next());
        if (r12.isClassType(r21) == false) goto L37;
        if (r12.isMarkedNullable(r21) == true) goto L37;
    L38:
        boolean r22 = true;
    L40:
        if (r22 == true) goto L41;
        r11.add(r21);
        goto L31
    L41:
        r13.clear();
    L37:
        if (r12.isDefinitelyNotNullType(r21) == true) goto L38;
        r22 = false;
        goto L40
    L22:
        r18 = r15;
        goto L24
    L44:
        throw new IllegalStateException(("Too many supertypes for type: " + r14 + ". Supertypes = " + CollectionsKt.joinToString$default(r16, null, null, null, 0, null, null, 63, null)).toString());
    L45:
        r13.clear();
        return false;
    L56:
        return true;
    L7:
        if (r12.isDefinitelyNotNullType(r14) == true) goto L8;
        r10 = false;
        goto L10
    }

    public final boolean hasPathByNotMarkedNullableNodes(TypeCheckerState r12, SimpleTypeMarker r13, TypeConstructorMarker r14) {
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r13, CommonConsts.APM_INNER_EVENT_COST_START);
        Intrinsics.checkNotNullParameter(r14, "end");
        TypeSystemContext r11 = r12.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(r12, r13, r14) == true) goto L43;
        r12.initialize();
        ArrayDeque<SimpleTypeMarker> r10 = r12.getSupertypesDeque();
        Intrinsics.checkNotNull(r10);
        Set<SimpleTypeMarker> r15 = r12.getSupertypesSet();
        Intrinsics.checkNotNull(r15);
        r10.push(r13);
    L7:
        if ((!r10.isEmpty()) == false) goto L31;
        if (r15.size() > 1000) goto L30;
        SimpleTypeMarker r16 = r10.pop();
        Intrinsics.checkNotNullExpressionValue(r16, "current");
        if (r15.add(r16) == false) goto L7;
        if (r11.isMarkedNullable(r16) == false) goto L15;
        TypeCheckerState.SupertypesPolicy r17 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L17:
        if ((!Intrinsics.areEqual(r17, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L20;
        r17 = null;
    L20:
        if (r17 == null) goto L7;
        TypeSystemContext r18 = r12.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r19 = r18.supertypes(r18.typeConstructor(r16)).iterator();
    L24:
        if (r19.hasNext() == false) goto L7;
        SimpleTypeMarker r20 = r17.mo1327transformType(r12, r19.next());
        if (INSTANCE.isApplicableAsEndNode(r12, r20, r14) == true) goto L27;
        r10.add(r20);
        goto L24
    L27:
        r12.clear();
        return true;
    L15:
        r17 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L17
    L30:
        throw new IllegalStateException(("Too many supertypes for type: " + r13 + ". Supertypes = " + CollectionsKt.joinToString$default(r15, null, null, null, 0, null, null, 63, null)).toString());
    L31:
        r12.clear();
        return false;
    L43:
        return true;
    }

    public final boolean isPossibleSubtype(TypeCheckerState r10, SimpleTypeMarker r11, SimpleTypeMarker r12) {
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "subType");
        Intrinsics.checkNotNullParameter(r12, "superType");
        return runIsPossibleSubtype(r10, r11, r12);
    }
}
