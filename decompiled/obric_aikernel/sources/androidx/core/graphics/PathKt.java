package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Path;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
@SourceDebugExtension({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n1#1,85:1\n44#1,3:86\n*S KotlinDebug\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n63#1:86,3\n*E\n"})
public final class PathKt {
    @RequiresApi(19)
    public static final Path and(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        Path r12 = new Path();
        r12.op(r10, r11, Path.Op.INTERSECT);
        return r12;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<PathSegment> r12 = PathUtils.flatten(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "flatten(this, error)");
        return r12;
    }

    public static /* synthetic */ Iterable flatten$default(Path r10, float r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = 0.5f;
    L6:
        return flatten(r10, r11);
    }

    @RequiresApi(19)
    public static final Path minus(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        Path r12 = new Path(r10);
        r12.op(r11, Path.Op.DIFFERENCE);
        return r12;
    }

    @RequiresApi(19)
    public static final Path or(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        Path r12 = new Path(r10);
        r12.op(r11, Path.Op.UNION);
        return r12;
    }

    @RequiresApi(19)
    public static final Path plus(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        Path r12 = new Path(r10);
        r12.op(r11, Path.Op.UNION);
        return r12;
    }

    @RequiresApi(19)
    public static final Path xor(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        Path r12 = new Path(r10);
        r12.op(r11, Path.Op.XOR);
        return r12;
    }
}
