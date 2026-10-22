package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.core.content.c;
import androidx.core.content.d;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public interface Predicate<T> {
    static /* synthetic */ boolean a(Predicate r5, Object r10) {
        return r5.lambda$negate$1(r10);
    }

    static /* synthetic */ boolean b(Predicate r5, Predicate r10, Object r11) {
        return r5.lambda$and$0(r10, r11);
    }

    static /* synthetic */ boolean c(Object r5, Object r10) {
        return lambda$isEqual$4(r5, r10);
    }

    static /* synthetic */ boolean d(Predicate r5, Predicate r10, Object r11) {
        return r5.lambda$or$2(r10, r11);
    }

    static /* synthetic */ boolean e(Object r5) {
        return lambda$isEqual$3(r5);
    }

    @SuppressLint({"MissingNullability"})
    static <T> Predicate<T> isEqual(@SuppressLint({"MissingNullability"}) Object r5) {
        if (r5 != null) goto L5;
        return new d(11);
    L5:
        return new c(r5, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ default boolean lambda$and$0(Predicate r5, Object r10) {
        if (test(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.test(r10) == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$isEqual$3(Object r5) {
        return Objects.isNull(r5);
    }

    private static /* synthetic */ boolean lambda$isEqual$4(Object r5, Object r10) {
        return r5.equals(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ default boolean lambda$negate$1(Object r5) {
        return !test(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ default boolean lambda$or$2(Predicate r5, Object r10) {
        if (test(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.test(r10) == true) goto L8;
        return false;
    }

    @SuppressLint({"MissingNullability"})
    static <T> Predicate<T> not(@SuppressLint({"MissingNullability"}) Predicate<? super T> r5) {
        Objects.requireNonNull(r5);
        return r5.negate();
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> and(@SuppressLint({"MissingNullability"}) Predicate<? super T> r5) {
        Objects.requireNonNull(r5);
        return new a(this, r5, 1);
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> negate() {
        return new c(this, 3);
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> or(@SuppressLint({"MissingNullability"}) Predicate<? super T> r5) {
        Objects.requireNonNull(r5);
        return new a(this, r5, 0);
    }

    boolean test(T r5);
}
