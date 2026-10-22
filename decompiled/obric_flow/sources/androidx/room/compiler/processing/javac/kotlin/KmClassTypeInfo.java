package androidx.room.compiler.processing.javac.kotlin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KmClassTypeInfo;", "", "kmType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "superType", "(Landroidx/room/compiler/processing/javac/kotlin/KmType;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "getKmType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getSuperType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmClassTypeInfo {
    private final KmType kmType;
    private final KmType superType;

    public KmClassTypeInfo(KmType r5, KmType r10) {
        Intrinsics.checkNotNullParameter(r5, "kmType");
        this.kmType = r5;
        this.superType = r10;
    }

    public static /* synthetic */ KmClassTypeInfo copy$default(KmClassTypeInfo r5, KmType r10, KmType r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.kmType;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.superType;
    L9:
        return r5.copy(r10, r11);
    }

    public final KmType component1() {
        return this.kmType;
    }

    public final KmType component2() {
        return this.superType;
    }

    public final KmClassTypeInfo copy(KmType r5, KmType r10) {
        Intrinsics.checkNotNullParameter(r5, "kmType");
        return new KmClassTypeInfo(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmClassTypeInfo) == true) goto L8;
        return false;
    L8:
        KmClassTypeInfo r10 = (KmClassTypeInfo) r5;
        if (Intrinsics.areEqual(this.kmType, r10.kmType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.superType, r10.superType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final KmType getKmType() {
        return this.kmType;
    }

    public final KmType getSuperType() {
        return this.superType;
    }

    public int hashCode() {
        int r5 = this.kmType.hashCode() * 31;
        KmType r10 = this.superType;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public String toString() {
        return "KmClassTypeInfo(kmType=" + this.kmType + ", superType=" + this.superType + ')';
    }
}
