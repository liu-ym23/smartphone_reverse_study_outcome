package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class StandardKt__StandardKt {
    public StandardKt__StandardKt() {
    }

    @InlineOnly
    private static final Void TODO() {
        throw new NotImplementedError(null, 1, null);
    }

    @InlineOnly
    private static final Void TODO(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        throw new NotImplementedError("An operation is not implemented: " + r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T also(T r10, Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        r11.invoke(r10);
        return r10;
    }

    @InlineOnly
    private static final <T> T apply(T r10, Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        r11.invoke(r10);
        return r10;
    }

    @InlineOnly
    private static final <T, R> R let(T r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        return r11.invoke(r10);
    }

    @InlineOnly
    private static final void repeat(int r10, Function1<? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11.invoke(Integer.valueOf(r12));
        r12 = r12 + 1;
        goto L3
    }

    @InlineOnly
    private static final <T, R> R run(T r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        return r11.invoke(r10);
    }

    @InlineOnly
    private static final <R> R run(Function0<? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        return r10.invoke();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T takeIf(T r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (r11.invoke(r10).booleanValue() == true) goto L7;
        return null;
    L7:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T takeUnless(T r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (r11.invoke(r10).booleanValue() == false) goto L7;
        return null;
    L7:
        return r10;
    }

    @InlineOnly
    private static final <T, R> R with(T r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        return r11.invoke(r10);
    }
}
