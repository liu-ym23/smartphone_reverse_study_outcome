package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPreconditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Preconditions.kt\nkotlin/PreconditionsKt__PreconditionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n1#2:145\n*E\n"})
class PreconditionsKt__PreconditionsKt extends PreconditionsKt__AssertionsJVMKt {
    public PreconditionsKt__PreconditionsKt() {
    }

    @InlineOnly
    private static final void check(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException("Check failed.".toString());
    }

    @InlineOnly
    private static final void check(boolean r10, Function0<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "lazyMessage");
        if (r10 == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(r11.invoke().toString());
    }

    @InlineOnly
    private static final <T> T checkNotNull(T r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @InlineOnly
    private static final <T> T checkNotNull(T r10, Function0<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "lazyMessage");
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException(r11.invoke().toString());
    }

    @InlineOnly
    private static final Void error(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        throw new IllegalStateException(r10.toString());
    }

    @InlineOnly
    private static final void require(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @InlineOnly
    private static final void require(boolean r10, Function0<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "lazyMessage");
        if (r10 == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r11.invoke().toString());
    }

    @InlineOnly
    private static final <T> T requireNotNull(T r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @InlineOnly
    private static final <T> T requireNotNull(T r10, Function0<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "lazyMessage");
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(r11.invoke().toString());
    }
}
