package androidx.room.vo;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/room/vo/ColumnIndexVar;", "", "column", "", "indexVar", "(Ljava/lang/String;Ljava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "getIndexVar", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ColumnIndexVar {
    private final String column;
    private final String indexVar;

    public ColumnIndexVar(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "indexVar");
        this.column = r5;
        this.indexVar = r10;
    }

    public static /* synthetic */ ColumnIndexVar copy$default(ColumnIndexVar r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.column;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.indexVar;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.column;
    }

    public final String component2() {
        return this.indexVar;
    }

    public final ColumnIndexVar copy(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "indexVar");
        return new ColumnIndexVar(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ColumnIndexVar) == true) goto L8;
        return false;
    L8:
        ColumnIndexVar r10 = (ColumnIndexVar) r5;
        if (Intrinsics.areEqual(this.column, r10.column) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.indexVar, r10.indexVar) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getColumn() {
        return this.column;
    }

    public final String getIndexVar() {
        return this.indexVar;
    }

    public int hashCode() {
        String r5 = this.column;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = this.indexVar.hashCode();
        return r11 + (r10 * 31);
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return j0.l("ColumnIndexVar(column=", this.column, ", indexVar=", this.indexVar, ")");
    }
}
