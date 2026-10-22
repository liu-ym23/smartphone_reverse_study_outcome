package androidx.room.verifier;

import java.sql.SQLException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/room/verifier/QueryResultInfo;", "", "columns", "", "Landroidx/room/verifier/ColumnInfo;", "error", "Ljava/sql/SQLException;", "(Ljava/util/List;Ljava/sql/SQLException;)V", "getColumns", "()Ljava/util/List;", "getError", "()Ljava/sql/SQLException;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryResultInfo {
    private final List<ColumnInfo> columns;
    private final SQLException error;

    public QueryResultInfo(List<ColumnInfo> r5, SQLException r10) {
        Intrinsics.checkNotNullParameter(r5, "columns");
        this.columns = r5;
        this.error = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryResultInfo copy$default(QueryResultInfo r5, List r10, SQLException r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.columns;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.error;
    L9:
        return r5.copy(r10, r11);
    }

    public final List<ColumnInfo> component1() {
        return this.columns;
    }

    public final SQLException component2() {
        return this.error;
    }

    public final QueryResultInfo copy(List<ColumnInfo> r5, SQLException r10) {
        Intrinsics.checkNotNullParameter(r5, "columns");
        return new QueryResultInfo(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QueryResultInfo) == true) goto L8;
        return false;
    L8:
        QueryResultInfo r10 = (QueryResultInfo) r5;
        if (Intrinsics.areEqual(this.columns, r10.columns) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.error, r10.error) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<ColumnInfo> getColumns() {
        return this.columns;
    }

    public final SQLException getError() {
        return this.error;
    }

    public int hashCode() {
        int r5 = this.columns.hashCode() * 31;
        SQLException r10 = this.error;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public String toString() {
        return "QueryResultInfo(columns=" + this.columns + ", error=" + this.error + ")";
    }

    public /* synthetic */ QueryResultInfo(List r5, SQLException r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10);
    }
}
