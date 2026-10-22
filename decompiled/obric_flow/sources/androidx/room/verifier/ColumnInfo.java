package androidx.room.verifier;

import ai.j0;
import androidx.room.parser.SQLTypeAffinity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/room/verifier/ColumnInfo;", "", "name", "", "type", "Landroidx/room/parser/SQLTypeAffinity;", "originTable", "(Ljava/lang/String;Landroidx/room/parser/SQLTypeAffinity;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getOriginTable", "getType", "()Landroidx/room/parser/SQLTypeAffinity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ColumnInfo {
    private final String name;
    private final String originTable;
    private final SQLTypeAffinity type;

    public ColumnInfo(String r5, SQLTypeAffinity r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        this.name = r5;
        this.type = r10;
        this.originTable = r11;
    }

    public static /* synthetic */ ColumnInfo copy$default(ColumnInfo r5, String r10, SQLTypeAffinity r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.type;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.originTable;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.name;
    }

    public final SQLTypeAffinity component2() {
        return this.type;
    }

    public final String component3() {
        return this.originTable;
    }

    public final ColumnInfo copy(String r5, SQLTypeAffinity r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        return new ColumnInfo(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ColumnInfo) == true) goto L8;
        return false;
    L8:
        ColumnInfo r10 = (ColumnInfo) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (this.type == r10.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.originTable, r10.originTable) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginTable() {
        return this.originTable;
    }

    public final SQLTypeAffinity getType() {
        return this.type;
    }

    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        int r10 = (this.type.hashCode() + r5) * 31;
        String r11 = this.originTable;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        String r5 = this.name;
        SQLTypeAffinity r10 = this.type;
        String r11 = this.originTable;
        StringBuilder r12 = new StringBuilder("ColumnInfo(name=");
        r12.append(r5);
        r12.append(", type=");
        r12.append(r10);
        r12.append(", originTable=");
        return j0.q(r12, r11, ")");
    }
}
