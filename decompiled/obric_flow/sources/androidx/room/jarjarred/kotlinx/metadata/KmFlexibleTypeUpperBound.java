package androidx.room.jarjarred.kotlinx.metadata;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmFlexibleTypeUpperBound;", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "type", "", "typeFlexibilityId", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "component1", "()Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "component2", "()Ljava/lang/String;", "copy", "(Landroidx/room/jarjarred/kotlinx/metadata/KmType;Ljava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmFlexibleTypeUpperBound;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getType", "()Ljava/lang/Object;", "setType", "(Ljava/lang/Object;)V", "Ljava/lang/String;", "getTypeFlexibilityId", "setTypeFlexibilityId", "(Ljava/lang/String;)V", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmFlexibleTypeUpperBound {
    private KmType type;
    private String typeFlexibilityId;

    public KmFlexibleTypeUpperBound(KmType r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        this.type = r5;
        this.typeFlexibilityId = r10;
    }

    public static /* synthetic */ KmFlexibleTypeUpperBound copy$default(KmFlexibleTypeUpperBound r5, KmType r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.type;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.typeFlexibilityId;
    L9:
        return r5.copy(r10, r11);
    }

    public final KmType component1() {
        return this.type;
    }

    public final String component2() {
        return this.typeFlexibilityId;
    }

    public final KmFlexibleTypeUpperBound copy(KmType r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return new KmFlexibleTypeUpperBound(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmFlexibleTypeUpperBound) == true) goto L8;
        return false;
    L8:
        KmFlexibleTypeUpperBound r10 = (KmFlexibleTypeUpperBound) r5;
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.typeFlexibilityId, r10.typeFlexibilityId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final KmType getType() {
        return this.type;
    }

    public final String getTypeFlexibilityId() {
        return this.typeFlexibilityId;
    }

    public int hashCode() {
        int r5 = this.type.hashCode() * 31;
        String r10 = this.typeFlexibilityId;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final void setType(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.type = r5;
    }

    public final void setTypeFlexibilityId(String r5) {
        this.typeFlexibilityId = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("KmFlexibleTypeUpperBound(type=");
        r5.append(this.type);
        r5.append(", typeFlexibilityId=");
        return j0.p(r5, this.typeFlexibilityId, ')');
    }
}
