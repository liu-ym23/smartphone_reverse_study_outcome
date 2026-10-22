package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.Flag;
import androidx.room.jarjarred.org.antlr.runtime.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\r\u0010\u0010\u001a\u00060\u0005j\u0002`\u0006HÂ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0014J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KmConstructor;", "Landroidx/room/compiler/processing/javac/kotlin/KmExecutable;", "descriptor", "", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "parameters", "", "Landroidx/room/compiler/processing/javac/kotlin/KmValueParameter;", "(Ljava/lang/String;ILjava/util/List;)V", "getDescriptor", "()Ljava/lang/String;", "getParameters", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "isPrimary", "toString", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmConstructor implements KmExecutable {
    private final String descriptor;
    private final int flags;
    private final List<KmValueParameter> parameters;

    public KmConstructor(String r5, int r10, List<KmValueParameter> r11) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r11, "parameters");
        this.descriptor = r5;
        this.flags = r10;
        this.parameters = r11;
    }

    private final int component2() {
        return this.flags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmConstructor copy$default(KmConstructor r5, String r10, int r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.descriptor;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.flags;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.getParameters();
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.descriptor;
    }

    public final List<KmValueParameter> component3() {
        return getParameters();
    }

    public final KmConstructor copy(String r5, int r10, List<KmValueParameter> r11) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r11, "parameters");
        return new KmConstructor(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmConstructor) == true) goto L8;
        return false;
    L8:
        KmConstructor r10 = (KmConstructor) r5;
        if (Intrinsics.areEqual(this.descriptor, r10.descriptor) == true) goto L12;
        return false;
    L12:
        if (this.flags == r10.flags) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getParameters(), r10.getParameters()) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getDescriptor() {
        return this.descriptor;
    }

    @Override // androidx.room.compiler.processing.javac.kotlin.KmExecutable
    public List<KmValueParameter> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        int r5 = this.descriptor.hashCode() * 31;
        int r10 = a.c(this.flags, r5, 31);
        return getParameters().hashCode() + r10;
    }

    public final boolean isPrimary() {
        return !Flag.Constructor.IS_SECONDARY.invoke(this.flags);
    }

    public String toString() {
        return "KmConstructor(descriptor=" + this.descriptor + ", flags=" + this.flags + ", parameters=" + getParameters() + ')';
    }
}
