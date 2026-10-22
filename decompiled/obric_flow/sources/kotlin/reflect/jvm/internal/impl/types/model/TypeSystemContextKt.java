package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeSystemContextKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Variance.values().length];
            r5[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final TypeVariance convertVariance(Variance r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L15;
        if (r10 != 3) goto L10;
        return TypeVariance.OUT;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return TypeVariance.IN;
    L13:
        return TypeVariance.INV;
    }
}
