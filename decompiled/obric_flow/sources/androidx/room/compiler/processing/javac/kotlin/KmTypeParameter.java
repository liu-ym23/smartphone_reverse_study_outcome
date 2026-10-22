package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.org.antlr.runtime.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\r\u0010\u0012\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KmTypeParameter;", "", "name", "", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "extendsBound", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "(Ljava/lang/String;ILandroidx/room/compiler/processing/javac/kotlin/KmType;)V", "getExtendsBound", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getFlags", "()I", "getName", "()Ljava/lang/String;", "asKmType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class KmTypeParameter {
    private final KmType extendsBound;
    private final int flags;
    private final String name;

    public KmTypeParameter(String r5, int r10, KmType r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.name = r5;
        this.flags = r10;
        this.extendsBound = r11;
    }

    public static /* synthetic */ KmTypeParameter copy$default(KmTypeParameter r5, String r10, int r11, KmType r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.flags;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.extendsBound;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final KmType asKmType() {
        return new KmType(this.flags, CollectionsKt.emptyList(), this.extendsBound, false);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.flags;
    }

    public final KmType component3() {
        return this.extendsBound;
    }

    public final KmTypeParameter copy(String r5, int r10, KmType r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return new KmTypeParameter(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmTypeParameter) == true) goto L8;
        return false;
    L8:
        KmTypeParameter r10 = (KmTypeParameter) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (this.flags == r10.flags) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extendsBound, r10.extendsBound) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final KmType getExtendsBound() {
        return this.extendsBound;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        int r10 = a.c(this.flags, r5, 31);
        KmType r11 = this.extendsBound;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "KmTypeParameter(name=" + this.name + ", flags=" + this.flags + ", extendsBound=" + this.extendsBound + ')';
    }
}
