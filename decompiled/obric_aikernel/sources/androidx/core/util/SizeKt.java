package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class SizeKt {
    @RequiresApi(21)
    public static final float component1(SizeF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getWidth();
    }

    public static final float component1(SizeFCompat r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getWidth();
    }

    @RequiresApi(21)
    public static final int component1(Size r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getHeight();
    }

    public static final float component2(SizeFCompat r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getHeight();
    }

    @RequiresApi(21)
    public static final int component2(Size r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getHeight();
    }
}
