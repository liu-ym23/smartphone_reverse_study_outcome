package androidx.room.compiler.processing.ksp;

import ai.j0;
import il.c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lil/c;", "findCompanionObject", "(Lil/c;)Lil/c;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSClassDeclarationExtKt {
    public static final c findCompanionObject(c r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r10 = r5.j().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        j0.A(r10.next());
        goto L4
    L6:
        return null;
    }
}
