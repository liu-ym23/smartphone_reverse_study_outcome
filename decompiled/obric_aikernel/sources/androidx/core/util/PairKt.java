package androidx.core.util;

import android.annotation.SuppressLint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (F) r10.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (S) r10.second;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(kotlin.Pair<? extends F, ? extends S> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new android.util.Pair(r10.getFirst(), r10.getSecond());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(kotlin.Pair<? extends F, ? extends S> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Pair(r10.getFirst(), r10.getSecond());
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(android.util.Pair<F, S> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new kotlin.Pair(r10.first, r10.second);
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(Pair<F, S> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new kotlin.Pair(r10.first, r10.second);
    }
}
