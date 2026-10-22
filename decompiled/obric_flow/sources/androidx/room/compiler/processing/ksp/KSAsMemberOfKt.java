package androidx.room.compiler.processing.ksp;

import il.g;
import il.l;
import il.p;
import il.s;
import il.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u0001*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lil/l;", "Lil/p;", "ksType", "typeAsMemberOf", "(Lil/l;Lil/p;)Lil/p;", "Lil/u;", "Lil/g;", "functionDeclaration", "(Lil/u;Lil/g;Lil/p;)Lil/p;", "returnTypeAsMemberOf", "(Lil/g;Lil/p;)Lil/p;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSAsMemberOfKt {
    public static final p returnTypeAsMemberOf(g r5, p r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        s r11 = r5.getReturnType();
        if (r11 == null) goto L6;
        r11.resolve();
    L6:
        throw new IllegalStateException(("cannot find return type for " + r5).toString());
    }

    public static final p typeAsMemberOf(l r5, p r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.getType().resolve();
        if (KSDeclarationExtKt.isStatic(r5) == false) goto L5;
        return null;
    L5:
        if (r10 != null) goto L7;
        return null;
    L7:
        throw null;
    }

    public static final p typeAsMemberOf(u r5, g r10, p r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "functionDeclaration");
        r5.getType().resolve();
        if (KSDeclarationExtKt.isStatic(r10) == false) goto L5;
        return null;
    L5:
        throw null;
    }
}
