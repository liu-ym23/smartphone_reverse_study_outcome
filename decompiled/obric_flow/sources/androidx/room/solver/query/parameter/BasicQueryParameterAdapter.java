package androidx.room.solver.query.parameter;

import androidx.room.solver.CodeGenScope;
import androidx.room.solver.types.StatementValueBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/solver/query/parameter/BasicQueryParameterAdapter;", "Landroidx/room/solver/query/parameter/QueryParameterAdapter;", "bindAdapter", "Landroidx/room/solver/types/StatementValueBinder;", "(Landroidx/room/solver/types/StatementValueBinder;)V", "getBindAdapter", "()Landroidx/room/solver/types/StatementValueBinder;", "bindToStmt", "", "inputVarName", "", "stmtVarName", "startIndexVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "getArgCount", "outputVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BasicQueryParameterAdapter extends QueryParameterAdapter {
    private final StatementValueBinder bindAdapter;

    public BasicQueryParameterAdapter(StatementValueBinder r5) {
        Intrinsics.checkNotNullParameter(r5, "bindAdapter");
        super(false);
        this.bindAdapter = r5;
    }

    @Override // androidx.room.solver.query.parameter.QueryParameterAdapter
    public void bindToStmt(String r5, String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        Intrinsics.checkNotNullParameter(r10, "stmtVarName");
        Intrinsics.checkNotNullParameter(r11, "startIndexVarName");
        Intrinsics.checkNotNullParameter(r12, "scope");
        r12.builder();
        this.bindAdapter.bindToStmt(r10, r11, r5, r12);
    }

    @Override // androidx.room.solver.query.parameter.QueryParameterAdapter
    public void getArgCount(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        Intrinsics.checkNotNullParameter(r10, "outputVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        throw new UnsupportedOperationException("should not call getArgCount on basic adapters.It is always one.");
    }

    public final StatementValueBinder getBindAdapter() {
        return this.bindAdapter;
    }
}
