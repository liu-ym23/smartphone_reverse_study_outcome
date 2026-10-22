package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"nullability", "Landroidx/room/compiler/processing/XNullability;", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getNullability", "(Landroidx/room/compiler/processing/javac/kotlin/KmType;)Landroidx/room/compiler/processing/XNullability;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KmTypeExtKt {
    public static final XNullability getNullability(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isNullable() == true) goto L11;
        KmType r10 = r5.getExtendsBound();
        if (r10 == null) goto L10;
        XNullability r11 = getNullability(r10);
        if (r11 == null) goto L10;
        return r11;
    L10:
        return XNullability.NONNULL;
    L11:
        return XNullability.NULLABLE;
    }
}
