package androidx.room.compiler.processing.javac.kotlin;

import ai.j0;
import androidx.room.jarjarred.kotlinx.metadata.Flag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÂ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0014\u001a\u00020\u0012J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0012J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KmValueParameter;", "", "name", "", "type", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "flags", "", "(Ljava/lang/String;Landroidx/room/compiler/processing/javac/kotlin/KmType;I)V", "getName", "()Ljava/lang/String;", "getType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hasDefault", "hashCode", "isNullable", "toString", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmValueParameter {
    private final int flags;
    private final String name;
    private final KmType type;

    public KmValueParameter(String r5, KmType r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        this.name = r5;
        this.type = r10;
        this.flags = r11;
    }

    private final int component3() {
        return this.flags;
    }

    public static /* synthetic */ KmValueParameter copy$default(KmValueParameter r5, String r10, KmType r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.type;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.flags;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.name;
    }

    public final KmType component2() {
        return this.type;
    }

    public final KmValueParameter copy(String r5, KmType r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        return new KmValueParameter(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmValueParameter) == true) goto L8;
        return false;
    L8:
        KmValueParameter r10 = (KmValueParameter) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L15;
        return false;
    L15:
        if (this.flags == r10.flags) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public final KmType getType() {
        return this.type;
    }

    public final boolean hasDefault() {
        return Flag.ValueParameter.DECLARES_DEFAULT_VALUE.invoke(this.flags);
    }

    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        int r10 = (this.type.hashCode() + r5) * 31;
        return Integer.hashCode(this.flags) + r10;
    }

    public final boolean isNullable() {
        return this.type.isNullable();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("KmValueParameter(name=");
        r5.append(this.name);
        r5.append(", type=");
        r5.append(this.type);
        r5.append(", flags=");
        return j0.n(r5, this.flags, ')');
    }
}
