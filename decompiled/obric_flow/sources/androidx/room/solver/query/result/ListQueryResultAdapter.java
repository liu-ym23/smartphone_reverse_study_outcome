package androidx.room.solver.query.result;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/solver/query/result/ListQueryResultAdapter;", "Landroidx/room/solver/query/result/QueryResultAdapter;", "typeArg", "Landroidx/room/compiler/processing/XType;", "rowAdapter", "Landroidx/room/solver/query/result/RowAdapter;", "(Landroidx/room/compiler/processing/XType;Landroidx/room/solver/query/result/RowAdapter;)V", "convert", "", "outVarName", "", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListQueryResultAdapter extends QueryResultAdapter {
    private final RowAdapter rowAdapter;
    private final XType typeArg;

    public ListQueryResultAdapter(XType r5, RowAdapter r10) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        Intrinsics.checkNotNullParameter(r10, "rowAdapter");
        super(CollectionsKt.listOf(r10));
        this.typeArg = r5;
        this.rowAdapter = r10;
    }

    @Override // androidx.room.solver.query.result.QueryResultAdapter
    public void convert(String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r11, "outVarName");
        g r5 = a.k(r12, "cursorVarName", "scope", r13);
        RowAdapter.onCursorReady$default(this.rowAdapter, r12, r13, null, 4, null);
        v r10 = v.n(e.n(List.class), new x[]{this.typeArg.getTypeName()});
        v r14 = v.n(e.n(ArrayList.class), new x[]{this.typeArg.getTypeName()});
        String r15 = Javapoet_extKt.getT();
        String r16 = Javapoet_extKt.getL();
        String r17 = Javapoet_extKt.getT();
        String r18 = Javapoet_extKt.getL();
        r5.c(androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("final ", r15, " ", r16, " = new "), r17, "(", r18, ".getCount())"), new Object[]{r10, r11, r14, r12});
        String r19 = r13.getTmpVar("_item");
        r5.e(j0.k("while(", Javapoet_extKt.getL(), ".moveToNext())"), new Object[]{r12});
        r5.c(androidx.constraintlayout.motion.widget.a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{this.typeArg.getTypeName(), r19});
        this.rowAdapter.convert(r19, r12, r13);
        r5.c(a.q(Javapoet_extKt.getL(), ".add(", Javapoet_extKt.getL(), ")"), new Object[]{r11, r19});
        r5.g();
    }
}
