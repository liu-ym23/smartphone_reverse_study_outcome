package androidx.room.compiler.processing.javac.kotlin;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.kotlinx.metadata.Flag;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010\u0012\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0000J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\tJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KmType;", "", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "typeArguments", "", "extendsBound", "isExtensionType", "", "(ILjava/util/List;Landroidx/room/compiler/processing/javac/kotlin/KmType;Z)V", "getExtendsBound", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getFlags", "()I", "()Z", "getTypeArguments", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "erasure", "hashCode", "isNullable", "toString", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmType {
    private final KmType extendsBound;
    private final int flags;
    private final boolean isExtensionType;
    private final List<KmType> typeArguments;

    public KmType(int r5, List<KmType> r10, KmType r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "typeArguments");
        this.flags = r5;
        this.typeArguments = r10;
        this.extendsBound = r11;
        this.isExtensionType = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmType copy$default(KmType r5, int r10, List r11, KmType r12, boolean r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.flags;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.typeArguments;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.extendsBound;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.isExtensionType;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final int component1() {
        return this.flags;
    }

    public final List<KmType> component2() {
        return this.typeArguments;
    }

    public final KmType component3() {
        return this.extendsBound;
    }

    public final boolean component4() {
        return this.isExtensionType;
    }

    public final KmType copy(int r5, List<KmType> r10, KmType r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "typeArguments");
        return new KmType(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmType) == true) goto L8;
        return false;
    L8:
        KmType r10 = (KmType) r5;
        if (this.flags == r10.flags) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.typeArguments, r10.typeArguments) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extendsBound, r10.extendsBound) == true) goto L18;
        return false;
    L18:
        if (this.isExtensionType == r10.isExtensionType) goto L20;
        return false;
    L20:
        return true;
    }

    public final KmType erasure() {
        int r5 = this.flags;
        List r10 = CollectionsKt.emptyList();
        KmType r11 = this.extendsBound;
        if (r11 == null) goto L5;
        KmType r12 = r11.erasure();
    L7:
        return new KmType(r5, r10, r12, this.isExtensionType);
    L5:
        r12 = null;
        goto L7
    }

    public final KmType getExtendsBound() {
        return this.extendsBound;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final List<KmType> getTypeArguments() {
        return this.typeArguments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r5 = Integer.hashCode(this.flags) * 31;
        int r10 = a.f(this.typeArguments, r5, 31);
        KmType r11 = this.extendsBound;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r10 + r12) * 31;
        boolean r14 = this.isExtensionType;
        ?? r15 = r14;
        if (r14 == false) goto L10;
        r15 = 1;
    L10:
        return r13 + r15;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final boolean isExtensionType() {
        return this.isExtensionType;
    }

    public final boolean isNullable() {
        return Flag.Type.IS_NULLABLE.invoke(this.flags);
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("KmType(flags=");
        r5.append(this.flags);
        r5.append(", typeArguments=");
        r5.append(this.typeArguments);
        r5.append(", extendsBound=");
        r5.append(this.extendsBound);
        r5.append(", isExtensionType=");
        return a.w(r5, this.isExtensionType, ')');
    }
}
