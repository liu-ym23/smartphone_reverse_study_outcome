package androidx.room.compiler.processing.ksp;

import il.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Landroidx/room/compiler/processing/ksp/KSFileAsOriginatingElement;", "Landroidx/room/compiler/processing/ksp/OriginatingElementWrapper;", "Lil/f;", "ksFile", "<init>", "(Lil/f;)V", "component1", "()Lil/f;", "copy", "(Lil/f;)Landroidx/room/compiler/processing/ksp/KSFileAsOriginatingElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lil/f;", "getKsFile", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KSFileAsOriginatingElement extends OriginatingElementWrapper {
    private final f ksFile;

    public KSFileAsOriginatingElement(f r5) {
        Intrinsics.checkNotNullParameter(r5, "ksFile");
        super(r5.e(), null);
    }

    public static /* synthetic */ KSFileAsOriginatingElement copy$default(KSFileAsOriginatingElement r5, f r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5.getClass();
        r10 = null;
    L6:
        return r5.copy(r10);
    }

    public final f component1() {
        return null;
    }

    public final KSFileAsOriginatingElement copy(f r5) {
        Intrinsics.checkNotNullParameter(r5, "ksFile");
        return new KSFileAsOriginatingElement(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KSFileAsOriginatingElement) == true) goto L8;
        return false;
    L8:
        ((KSFileAsOriginatingElement) r5).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final f getKsFile() {
        return null;
    }

    public int hashCode() {
        throw null;
    }

    public String toString() {
        return "KSFileAsOriginatingElement(ksFile=null)";
    }
}
