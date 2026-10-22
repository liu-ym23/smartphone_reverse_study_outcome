package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeSystemContextKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[Variance.values().length];
            r10[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public static final TypeVariance convertVariance(Variance r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L15;
        if (r11 != 3) goto L10;
        return TypeVariance.OUT;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return TypeVariance.IN;
    L13:
        return TypeVariance.INV;
    }
}
