package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/vo/WriteQueryMethod;", "Landroidx/room/vo/QueryMethod;", "element", "Landroidx/room/compiler/processing/XMethodElement;", "query", "Landroidx/room/parser/ParsedQuery;", "returnType", "Landroidx/room/compiler/processing/XType;", "parameters", "", "Landroidx/room/vo/QueryParameter;", "preparedQueryResultBinder", "Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/parser/ParsedQuery;Landroidx/room/compiler/processing/XType;Ljava/util/List;Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;)V", "getPreparedQueryResultBinder", "()Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WriteQueryMethod extends QueryMethod {
    private final PreparedQueryResultBinder preparedQueryResultBinder;

    public WriteQueryMethod(XMethodElement r10, ParsedQuery r11, XType r12, List<QueryParameter> r13, PreparedQueryResultBinder r14) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "query");
        Intrinsics.checkNotNullParameter(r12, "returnType");
        Intrinsics.checkNotNullParameter(r13, "parameters");
        Intrinsics.checkNotNullParameter(r14, "preparedQueryResultBinder");
        super(r10, r11, r12, r13, null);
        this.preparedQueryResultBinder = r14;
    }

    public final PreparedQueryResultBinder getPreparedQueryResultBinder() {
        return this.preparedQueryResultBinder;
    }
}
