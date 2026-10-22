package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: loaded from: classes3.dex */
public final class NullabilityChecker {
    public static final NullabilityChecker INSTANCE = null;

    static {
        INSTANCE = new NullabilityChecker();
    }

    private NullabilityChecker() {
    }

    public final boolean isSubtypeOfAny(UnwrappedType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return AbstractNullabilityChecker.INSTANCE.hasNotNullSupertype(SimpleClassicTypeSystemContext.INSTANCE.newTypeCheckerState(false, true), FlexibleTypesKt.lowerIfFlexible(r5), TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE);
    }
}
