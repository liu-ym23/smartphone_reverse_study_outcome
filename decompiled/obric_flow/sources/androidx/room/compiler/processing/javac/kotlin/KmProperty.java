package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.Flag;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0006\u0010\u001f\u001a\u00020\u001bJ\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KmProperty;", "", "name", "", "type", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getter", "Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "setter", "(Ljava/lang/String;Landroidx/room/compiler/processing/javac/kotlin/KmType;Landroidx/room/compiler/processing/javac/kotlin/KmFunction;Landroidx/room/compiler/processing/javac/kotlin/KmFunction;)V", "getGetter", "()Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "getName", "()Ljava/lang/String;", "getSetter", "getType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "typeParameters", "", "getTypeParameters", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "isNullable", "toString", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmProperty {
    private final KmFunction getter;
    private final String name;
    private final KmFunction setter;
    private final KmType type;

    public KmProperty(String r5, KmType r10, KmFunction r11, KmFunction r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        this.name = r5;
        this.type = r10;
        this.getter = r11;
        this.setter = r12;
    }

    public static /* synthetic */ KmProperty copy$default(KmProperty r5, String r10, KmType r11, KmFunction r12, KmFunction r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.type;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.getter;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.setter;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.name;
    }

    public final KmType component2() {
        return this.type;
    }

    public final KmFunction component3() {
        return this.getter;
    }

    public final KmFunction component4() {
        return this.setter;
    }

    public final KmProperty copy(String r5, KmType r10, KmFunction r11, KmFunction r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        return new KmProperty(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmProperty) == true) goto L8;
        return false;
    L8:
        KmProperty r10 = (KmProperty) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.getter, r10.getter) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.setter, r10.setter) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final KmFunction getGetter() {
        return this.getter;
    }

    public final String getName() {
        return this.name;
    }

    public final KmFunction getSetter() {
        return this.setter;
    }

    public final KmType getType() {
        return this.type;
    }

    public final List<KmType> getTypeParameters() {
        return this.type.getTypeArguments();
    }

    public int hashCode() {
        int r5 = (this.type.hashCode() + (this.name.hashCode() * 31)) * 31;
        KmFunction r10 = this.getter;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        KmFunction r14 = this.setter;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final boolean isNullable() {
        return Flag.Type.IS_NULLABLE.invoke(this.type.getFlags());
    }

    public String toString() {
        return "KmProperty(name=" + this.name + ", type=" + this.type + ", getter=" + this.getter + ", setter=" + this.setter + ')';
    }
}
