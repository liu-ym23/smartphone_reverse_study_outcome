package androidx.room.solver.query.result;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/room/solver/query/result/SingleEntityQueryResultAdapter;", "Landroidx/room/solver/query/result/QueryResultAdapter;", "rowAdapter", "Landroidx/room/solver/query/result/RowAdapter;", "(Landroidx/room/solver/query/result/RowAdapter;)V", "type", "Landroidx/room/compiler/processing/XType;", "getType", "()Landroidx/room/compiler/processing/XType;", "convert", "", "outVarName", "", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SingleEntityQueryResultAdapter extends QueryResultAdapter {
    private final RowAdapter rowAdapter;
    private final XType type;

    public SingleEntityQueryResultAdapter(RowAdapter r5) {
        Intrinsics.checkNotNullParameter(r5, "rowAdapter");
        super(CollectionsKt.listOf(r5));
        this.rowAdapter = r5;
        this.type = r5.getOut();
    }

    @Override // androidx.room.solver.query.result.QueryResultAdapter
    public void convert(String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        g r5 = a.k(r11, "cursorVarName", "scope", r12);
        RowAdapter.onCursorReady$default(this.rowAdapter, r11, r12, null, 4, null);
        r5.c(androidx.constraintlayout.motion.widget.a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{this.type.getTypeName(), r10});
        r5.e(j0.k("if(", Javapoet_extKt.getL(), ".moveToFirst())"), new Object[]{r11});
        this.rowAdapter.convert(r10, r11, r12);
        r5.h("else", new Object[0]);
        r5.c(j0.D(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getL()), new Object[]{r10, this.rowAdapter.getOut().defaultValue()});
        r5.g();
    }

    public final XType getType() {
        return this.type;
    }
}
