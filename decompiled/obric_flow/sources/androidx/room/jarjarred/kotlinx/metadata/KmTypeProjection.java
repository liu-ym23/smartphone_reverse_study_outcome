package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmTypeProjection;", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "type", "<init>", "(Lkotlinx/metadata/KmVariance;Ljava/lang/Object;)V", "component1", "()Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "component2", "()Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "copy", "(Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;Landroidx/room/jarjarred/kotlinx/metadata/KmType;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeProjection;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "getVariance", "()Lkotlinx/metadata/KmVariance;", "setVariance", "(Lkotlinx/metadata/KmVariance;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getType", "()Ljava/lang/Object;", "setType", "(Ljava/lang/Object;)V", "Companion", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmTypeProjection {
    public static final Companion Companion = null;

    @JvmField
    public static final KmTypeProjection STAR = null;
    private KmType type;
    private KmVariance variance;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmTypeProjection$Companion;", "", "()V", "STAR", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeProjection;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        STAR = new KmTypeProjection(null, null);
    }

    public KmTypeProjection(KmVariance r5, KmType r10) {
        this.variance = r5;
        this.type = r10;
    }

    public static /* synthetic */ KmTypeProjection copy$default(KmTypeProjection r5, KmVariance r10, KmType r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.variance;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.type;
    L9:
        return r5.copy(r10, r11);
    }

    public final KmVariance component1() {
        return this.variance;
    }

    public final KmType component2() {
        return this.type;
    }

    public final KmTypeProjection copy(KmVariance r5, KmType r10) {
        return new KmTypeProjection(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmTypeProjection) == true) goto L8;
        return false;
    L8:
        KmTypeProjection r10 = (KmTypeProjection) r5;
        if (this.variance == r10.variance) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final KmType getType() {
        return this.type;
    }

    public final KmVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        KmVariance r5 = this.variance;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        KmType r13 = this.type;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final void setType(KmType r5) {
        this.type = r5;
    }

    public final void setVariance(KmVariance r5) {
        this.variance = r5;
    }

    public String toString() {
        return "KmTypeProjection(variance=" + this.variance + ", type=" + this.type + ')';
    }
}
