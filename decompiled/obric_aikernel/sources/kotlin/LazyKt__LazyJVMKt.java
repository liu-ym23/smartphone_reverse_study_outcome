package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class LazyKt__LazyJVMKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[LazyThreadSafetyMode.values().length];
            r10[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[LazyThreadSafetyMode.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public LazyKt__LazyJVMKt() {
    }

    public static final <T> Lazy<T> lazy(Object r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "initializer");
        return new SynchronizedLazyImpl(r11, r10);
    }

    public static <T> Lazy<T> lazy(LazyThreadSafetyMode r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        Intrinsics.checkNotNullParameter(r11, "initializer");
        int r12 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        int r13 = 2;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L14;
        if (r12 != 3) goto L9;
        return new UnsafeLazyImpl(r11);
    L9:
        throw new NoWhenBranchMatchedException();
    L14:
        return new SafePublicationLazyImpl(r11);
    L11:
        DefaultConstructorMarker r14 = null;
        return new SynchronizedLazyImpl(r11, r14, r13, r14);
    }

    public static <T> Lazy<T> lazy(Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "initializer");
        DefaultConstructorMarker r11 = null;
        return new SynchronizedLazyImpl(r10, r11, 2, r11);
    }
}
