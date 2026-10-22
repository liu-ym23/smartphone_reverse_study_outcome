package androidx.room.solver.query.result;

import ai.j0;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.types.CursorValueReader;
import androidx.room.vo.ColumnIndexVar;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002*\u0001\f\u0018\u00002\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Landroidx/room/solver/query/result/SingleNamedColumnRowAdapter;", "Landroidx/room/solver/query/result/QueryMappedRowAdapter;", "reader", "Landroidx/room/solver/types/CursorValueReader;", "columnName", "", "(Landroidx/room/solver/types/CursorValueReader;Ljava/lang/String;)V", "columnIndexVar", "Landroidx/room/vo/ColumnIndexVar;", "getColumnName", "()Ljava/lang/String;", "indexAdapter", "androidx/room/solver/query/result/SingleNamedColumnRowAdapter$indexAdapter$1", "Landroidx/room/solver/query/result/SingleNamedColumnRowAdapter$indexAdapter$1;", "mapping", "Landroidx/room/solver/query/result/SingleNamedColumnRowAdapter$SingleNamedColumnRowMapping;", "getMapping", "()Landroidx/room/solver/query/result/SingleNamedColumnRowAdapter$SingleNamedColumnRowMapping;", "getReader", "()Landroidx/room/solver/types/CursorValueReader;", "convert", "", "outVarName", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "getDefaultIndexAdapter", "Landroidx/room/solver/query/result/IndexAdapter;", "onCursorReady", "indices", "", "SingleNamedColumnRowMapping", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SingleNamedColumnRowAdapter extends QueryMappedRowAdapter {
    private ColumnIndexVar columnIndexVar;
    private final String columnName;
    private final SingleNamedColumnRowAdapter$indexAdapter$1 indexAdapter;
    private final SingleNamedColumnRowMapping mapping;
    private final CursorValueReader reader;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/room/solver/query/result/SingleNamedColumnRowAdapter$SingleNamedColumnRowMapping;", "Landroidx/room/solver/query/result/QueryMappedRowAdapter$Mapping;", "usedColumn", "", "(Ljava/lang/String;)V", "getUsedColumn", "()Ljava/lang/String;", "usedColumns", "", "getUsedColumns", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SingleNamedColumnRowMapping extends QueryMappedRowAdapter.Mapping {
        private final String usedColumn;
        private final List<String> usedColumns;

        public SingleNamedColumnRowMapping(String r5) {
            Intrinsics.checkNotNullParameter(r5, "usedColumn");
            this.usedColumn = r5;
            this.usedColumns = CollectionsKt.listOf(r5);
        }

        public static /* synthetic */ SingleNamedColumnRowMapping copy$default(SingleNamedColumnRowMapping r5, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.usedColumn;
        L6:
            return r5.copy(r10);
        }

        public final String component1() {
            return this.usedColumn;
        }

        public final SingleNamedColumnRowMapping copy(String r5) {
            Intrinsics.checkNotNullParameter(r5, "usedColumn");
            return new SingleNamedColumnRowMapping(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SingleNamedColumnRowMapping) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.usedColumn, ((SingleNamedColumnRowMapping) r5).usedColumn) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getUsedColumn() {
            return this.usedColumn;
        }

        @Override // androidx.room.solver.query.result.QueryMappedRowAdapter.Mapping
        public List<String> getUsedColumns() {
            return this.usedColumns;
        }

        public int hashCode() {
            return this.usedColumn.hashCode();
        }

        public String toString() {
            return j0.k("SingleNamedColumnRowMapping(usedColumn=", this.usedColumn, ")");
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.room.solver.query.result.SingleNamedColumnRowAdapter$indexAdapter$1] */
    public SingleNamedColumnRowAdapter(CursorValueReader r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "reader");
        Intrinsics.checkNotNullParameter(r10, "columnName");
        super(r5.typeMirror());
        this.reader = r5;
        this.columnName = r10;
        this.mapping = new SingleNamedColumnRowMapping(r10);
        this.indexAdapter = new SingleNamedColumnRowAdapter$indexAdapter$1(this);
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public void convert(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "outVarName");
        Intrinsics.checkNotNullParameter(r10, "cursorVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        CursorValueReader r12 = this.reader;
        ColumnIndexVar r13 = this.columnIndexVar;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("columnIndexVar");
        r13 = null;
    L5:
        r12.readFromCursor(r5, r10, r13.getIndexVar(), r11);
    }

    public final String getColumnName() {
        return this.columnName;
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public IndexAdapter getDefaultIndexAdapter() {
        return this.indexAdapter;
    }

    @Override // androidx.room.solver.query.result.QueryMappedRowAdapter
    public /* bridge */ /* synthetic */ QueryMappedRowAdapter.Mapping getMapping() {
        return getMapping();
    }

    public final CursorValueReader getReader() {
        return this.reader;
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public void onCursorReady(String r5, CodeGenScope r10, List<ColumnIndexVar> r11) {
        Intrinsics.checkNotNullParameter(r5, "cursorVarName");
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "indices");
        ColumnIndexVar r12 = (ColumnIndexVar) CollectionsKt.singleOrNull(r11);
        if (r12 == null) goto L7;
        this.columnIndexVar = r12;
        return;
    L7:
        throw new IllegalStateException(("Expected a single resolved index var but got " + r11.size()).toString());
    }

    @Override // androidx.room.solver.query.result.QueryMappedRowAdapter
    public SingleNamedColumnRowMapping getMapping() {
        return this.mapping;
    }
}
