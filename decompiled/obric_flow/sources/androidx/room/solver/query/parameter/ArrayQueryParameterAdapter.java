package androidx.room.solver.query.parameter;

import ai.j0;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.types.StatementValueBinder;
import com.squareup.javapoet.g;
import com.squareup.javapoet.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/solver/query/parameter/ArrayQueryParameterAdapter;", "Landroidx/room/solver/query/parameter/QueryParameterAdapter;", "bindAdapter", "Landroidx/room/solver/types/StatementValueBinder;", "(Landroidx/room/solver/types/StatementValueBinder;)V", "getBindAdapter", "()Landroidx/room/solver/types/StatementValueBinder;", "bindToStmt", "", "inputVarName", "", "stmtVarName", "startIndexVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "getArgCount", "outputVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ArrayQueryParameterAdapter extends QueryParameterAdapter {
    private final StatementValueBinder bindAdapter;

    public ArrayQueryParameterAdapter(StatementValueBinder r5) {
        Intrinsics.checkNotNullParameter(r5, "bindAdapter");
        super(true);
        this.bindAdapter = r5;
    }

    @Override // androidx.room.solver.query.parameter.QueryParameterAdapter
    public void bindToStmt(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "inputVarName");
        Intrinsics.checkNotNullParameter(r11, "stmtVarName");
        g r5 = a.k(r12, "startIndexVarName", "scope", r13);
        String r14 = r13.getTmpVar("_item");
        String r15 = Javapoet_extKt.getT();
        String r16 = Javapoet_extKt.getL();
        String r17 = Javapoet_extKt.getL();
        r5.e(j0.q(androidx.constraintlayout.motion.widget.a.y("for (", r15, " ", r16, " : "), r17, ")"), new Object[]{this.bindAdapter.typeMirror().getTypeName(), r14, r10});
        this.bindAdapter.bindToStmt(r11, r12, r14, r13);
        r5.c(j0.j(Javapoet_extKt.getL(), " ++"), new Object[]{r12});
        r5.g();
    }

    @Override // androidx.room.solver.query.parameter.QueryParameterAdapter
    public void getArgCount(String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r10, "inputVarName");
        g r5 = a.k(r11, "outputVarName", "scope", r12);
        String r13 = Javapoet_extKt.getT();
        String r14 = Javapoet_extKt.getL();
        String r15 = Javapoet_extKt.getL();
        r5.c(j0.q(androidx.constraintlayout.motion.widget.a.y("final ", r13, " ", r14, " = "), r15, ".length"), new Object[]{x.f15023h, r11, r10});
    }

    public final StatementValueBinder getBindAdapter() {
        return this.bindAdapter;
    }
}
