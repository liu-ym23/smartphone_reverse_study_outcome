package androidx.room.compiler.processing.ksp;

import com.google.devtools.ksp.symbol.Modifier;
import il.c;
import il.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u00020\n*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lil/d;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "requireEnclosingMemberContainer", "(Lil/d;Landroidx/room/compiler/processing/ksp/KspProcessingEnv;)Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "findEnclosingMemberContainer", "Lil/c;", "findEnclosingAncestorClassDeclaration", "(Lil/d;)Lil/c;", "", "isStatic", "(Lil/d;)Z", "isTransient", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSDeclarationExtKt {
    private static final c findEnclosingAncestorClassDeclaration(d r5) {
        r5.f();
        return null;
    }

    public static final KspMemberContainer findEnclosingMemberContainer(d r5, KspProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        findEnclosingAncestorClassDeclaration(r5);
        r5.getContainingFile();
        return null;
    }

    public static final boolean isStatic(d r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getModifiers().contains(Modifier.JAVA_STATIC) == false) goto L5;
    L7:
        return true;
    L5:
        if (KSAnnotatedExtKt.hasJvmStaticAnnotation(r5) == true) goto L7;
        findEnclosingAncestorClassDeclaration(r5);
        return false;
    }

    public static final boolean isTransient(d r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getModifiers().contains(Modifier.JAVA_TRANSIENT) == false) goto L5;
    L8:
        return true;
    L5:
        if (KSAnnotatedExtKt.hasJvmTransientAnnotation(r5) == true) goto L8;
        return false;
    }

    public static final KspMemberContainer requireEnclosingMemberContainer(d r5, KspProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        KspMemberContainer r11 = findEnclosingMemberContainer(r5, r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException(("Cannot find required enclosing type for " + r5).toString());
    }
}
