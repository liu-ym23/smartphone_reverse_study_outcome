package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Path;
import androidx.annotation.RequiresApi;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\f"}, d2 = {"and", "Landroid/graphics/Path;", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "flatten", "", "Landroidx/core/graphics/PathSegment;", "error", "", "minus", "or", "plus", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
@SourceDebugExtension({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n1#1,80:1\n43#1,3:81\n*S KotlinDebug\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n60#1:81,3\n*E\n"})
public final class PathKt {
    public static final Path and(Path r5, Path r10) {
        Path r11 = new Path();
        r11.op(r5, r10, Path.Op.INTERSECT);
        return r11;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path r5, float r10) {
        return PathUtils.flatten(r5, r10);
    }

    public static /* synthetic */ Iterable flatten$default(Path r5, float r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = 0.5f;
    L6:
        return flatten(r5, r10);
    }

    public static final Path minus(Path r5, Path r10) {
        Path r11 = new Path(r5);
        r11.op(r10, Path.Op.DIFFERENCE);
        return r11;
    }

    public static final Path or(Path r5, Path r10) {
        Path r11 = new Path(r5);
        r11.op(r10, Path.Op.UNION);
        return r11;
    }

    public static final Path plus(Path r5, Path r10) {
        Path r11 = new Path(r5);
        r11.op(r10, Path.Op.UNION);
        return r11;
    }

    public static final Path xor(Path r5, Path r10) {
        Path r11 = new Path(r5);
        r11.op(r10, Path.Op.XOR);
        return r11;
    }
}
