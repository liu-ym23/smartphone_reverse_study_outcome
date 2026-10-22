package androidx.room.solver.query.parameter;

import androidx.room.solver.CodeGenScope;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0010"}, d2 = {"Landroidx/room/solver/query/parameter/QueryParameterAdapter;", "", "isMultiple", "", "(Z)V", "()Z", "bindToStmt", "", "inputVarName", "", "stmtVarName", "startIndexVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "getArgCount", "outputVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class QueryParameterAdapter {
    private final boolean isMultiple;

    public QueryParameterAdapter(boolean r5) {
        this.isMultiple = r5;
    }

    public abstract void bindToStmt(String r5, String r10, String r11, CodeGenScope r12);

    public abstract void getArgCount(String r5, String r10, CodeGenScope r11);

    public final boolean isMultiple() {
        return this.isMultiple;
    }
}
