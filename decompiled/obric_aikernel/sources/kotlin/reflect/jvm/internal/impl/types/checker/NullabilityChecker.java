package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.common.wschannel.WsConstants;
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

    public final boolean isSubtypeOfAny(UnwrappedType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        return AbstractNullabilityChecker.INSTANCE.hasNotNullSupertype(SimpleClassicTypeSystemContext.INSTANCE.newTypeCheckerState(false, true), FlexibleTypesKt.lowerIfFlexible(r10), TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE);
    }
}
