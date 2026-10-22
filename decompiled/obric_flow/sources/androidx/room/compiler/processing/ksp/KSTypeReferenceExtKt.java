package androidx.room.compiler.processing.ksp;

import il.p;
import il.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lil/s;", "Lil/p;", "replacement", "swapResolvedType", "(Lil/s;Lil/p;)Lil/s;", "createTypeReference", "(Lil/p;)Lil/s;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSTypeReferenceExtKt {
    public static final s createTypeReference(p r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new NoLocationTypeReference(r5);
    }

    public static final s swapResolvedType(s r5, p r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        return new DelegatingTypeReference(r5, r10);
    }
}
