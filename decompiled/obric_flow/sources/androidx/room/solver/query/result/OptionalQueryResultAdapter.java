package androidx.room.solver.query.result;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/solver/query/result/OptionalQueryResultAdapter;", "Landroidx/room/solver/query/result/QueryResultAdapter;", "typeArg", "Landroidx/room/compiler/processing/XType;", "resultAdapter", "Landroidx/room/solver/query/result/SingleEntityQueryResultAdapter;", "(Landroidx/room/compiler/processing/XType;Landroidx/room/solver/query/result/SingleEntityQueryResultAdapter;)V", "convert", "", "outVarName", "", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OptionalQueryResultAdapter extends QueryResultAdapter {
    private final SingleEntityQueryResultAdapter resultAdapter;
    private final XType typeArg;

    public OptionalQueryResultAdapter(XType r5, SingleEntityQueryResultAdapter r10) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        Intrinsics.checkNotNullParameter(r10, "resultAdapter");
        super(r10.getRowAdapters());
        this.typeArg = r5;
        this.resultAdapter = r10;
    }

    @Override // androidx.room.solver.query.result.QueryResultAdapter
    public void convert(String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        g r5 = a.k(r11, "cursorVarName", "scope", r12);
        String r13 = r12.getTmpVar("_value");
        this.resultAdapter.convert(r13, r11, r12);
        String r14 = Javapoet_extKt.getT();
        String r15 = Javapoet_extKt.getL();
        String r16 = Javapoet_extKt.getT();
        String r17 = Javapoet_extKt.getL();
        String r18 = androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("final ", r14, " ", r15, " = "), r16, ".ofNullable(", r17, ")");
        CommonTypeNames r19 = CommonTypeNames.INSTANCE;
        r5.c(r18, new Object[]{v.n(r19.getOPTIONAL(), new x[]{this.typeArg.getTypeName()}), r10, r19.getOPTIONAL(), r13});
    }
}
