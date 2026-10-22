package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.solver.query.result.QueryResultBinder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/room/vo/ReadQueryMethod;", "Landroidx/room/vo/QueryMethod;", "element", "Landroidx/room/compiler/processing/XMethodElement;", "query", "Landroidx/room/parser/ParsedQuery;", "returnType", "Landroidx/room/compiler/processing/XType;", "parameters", "", "Landroidx/room/vo/QueryParameter;", "inTransaction", "", "queryResultBinder", "Landroidx/room/solver/query/result/QueryResultBinder;", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/parser/ParsedQuery;Landroidx/room/compiler/processing/XType;Ljava/util/List;ZLandroidx/room/solver/query/result/QueryResultBinder;)V", "getInTransaction", "()Z", "getQueryResultBinder", "()Landroidx/room/solver/query/result/QueryResultBinder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ReadQueryMethod extends QueryMethod {
    private final boolean inTransaction;
    private final QueryResultBinder queryResultBinder;

    public ReadQueryMethod(XMethodElement r10, ParsedQuery r11, XType r12, List<QueryParameter> r13, boolean r14, QueryResultBinder r15) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "query");
        Intrinsics.checkNotNullParameter(r12, "returnType");
        Intrinsics.checkNotNullParameter(r13, "parameters");
        Intrinsics.checkNotNullParameter(r15, "queryResultBinder");
        super(r10, r11, r12, r13, null);
        this.inTransaction = r14;
        this.queryResultBinder = r15;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final QueryResultBinder getQueryResultBinder() {
        return this.queryResultBinder;
    }
}
