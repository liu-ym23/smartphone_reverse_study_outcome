package androidx.room.compiler.processing.ksp;

import il.g;
import il.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lil/g;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspType;", "containing", "returnKspType", "(Lil/g;Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspType;)Landroidx/room/compiler/processing/ksp/KspType;", "Lil/s;", "getOriginatingReference", "(Lil/g;)Lil/s;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSFunctionExtKt {
    private static final s getOriginatingReference(g r5) {
        r5.h();
        return r5.getReturnType();
    }

    public static final KspType returnKspType(g r5, KspProcessingEnv r10, KspType r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        if (r11 == null) goto L13;
        KspTypeElement r12 = r11.getTypeElement();
        if (r12 == null) goto L13;
        if (r12.isAnnotationClass() != true) goto L13;
        s r13 = r5.getReturnType();
        if (r13 == null) goto L12;
        r13.resolve();
        return r10.wrap(r13, null);
    L12:
        throw new IllegalStateException("Required value was null.");
    L13:
        s r14 = getOriginatingReference(r5);
        if (r14 == null) goto L20;
        if (r11 == null) goto L17;
        r11.getKsType();
    L17:
        KSAsMemberOfKt.returnTypeAsMemberOf(r5, null);
        return r10.wrap(r14, null);
    L20:
        throw new IllegalStateException("Required value was null.");
    }
}
