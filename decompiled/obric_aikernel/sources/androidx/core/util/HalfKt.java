package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
@SourceDebugExtension({"SMAP\nHalf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n1#1,60:1\n43#1:61\n*S KotlinDebug\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n51#1:61\n*E\n"})
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(double r10) {
        Half r11 = Half.valueOf((float) r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }

    @RequiresApi(26)
    public static final Half toHalf(float r10) {
        Half r11 = Half.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }

    @RequiresApi(26)
    public static final Half toHalf(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Half r11 = Half.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }

    @RequiresApi(26)
    public static final Half toHalf(short r10) {
        Half r11 = Half.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }
}
