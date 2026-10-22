package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XMethodElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/room/compiler/processing/javac/VisitorData;", "", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "method", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/XMethodElement;)V", "getEnv", "()Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "getMethod", "()Landroidx/room/compiler/processing/XMethodElement;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class VisitorData {
    private final JavacProcessingEnv env;
    private final XMethodElement method;

    public VisitorData(JavacProcessingEnv r5, XMethodElement r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "method");
        this.env = r5;
        this.method = r10;
    }

    public static /* synthetic */ VisitorData copy$default(VisitorData r5, JavacProcessingEnv r10, XMethodElement r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.env;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.method;
    L9:
        return r5.copy(r10, r11);
    }

    public final JavacProcessingEnv component1() {
        return this.env;
    }

    public final XMethodElement component2() {
        return this.method;
    }

    public final VisitorData copy(JavacProcessingEnv r5, XMethodElement r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "method");
        return new VisitorData(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VisitorData) == true) goto L8;
        return false;
    L8:
        VisitorData r10 = (VisitorData) r5;
        if (Intrinsics.areEqual(this.env, r10.env) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.method, r10.method) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final JavacProcessingEnv getEnv() {
        return this.env;
    }

    public final XMethodElement getMethod() {
        return this.method;
    }

    public int hashCode() {
        int r5 = this.env.hashCode() * 31;
        return this.method.hashCode() + r5;
    }

    public String toString() {
        return "VisitorData(env=" + this.env + ", method=" + this.method + ')';
    }
}
