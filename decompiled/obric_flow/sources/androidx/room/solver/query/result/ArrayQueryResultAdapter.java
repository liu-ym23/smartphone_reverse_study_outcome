package androidx.room.solver.query.result;

import ai.j0;
import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.c;
import com.squareup.javapoet.g;
import com.squareup.javapoet.x;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/room/solver/query/result/ArrayQueryResultAdapter;", "Landroidx/room/solver/query/result/QueryResultAdapter;", "rowAdapter", "Landroidx/room/solver/query/result/RowAdapter;", "(Landroidx/room/solver/query/result/RowAdapter;)V", "type", "Landroidx/room/compiler/processing/XType;", "getType", "()Landroidx/room/compiler/processing/XType;", "convert", "", "outVarName", "", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ArrayQueryResultAdapter extends QueryResultAdapter {
    private final RowAdapter rowAdapter;
    private final XType type;

    public ArrayQueryResultAdapter(RowAdapter r5) {
        Intrinsics.checkNotNullParameter(r5, "rowAdapter");
        super(CollectionsKt.listOf(r5));
        this.rowAdapter = r5;
        this.type = r5.getOut();
    }

    @Override // androidx.room.solver.query.result.QueryResultAdapter
    public void convert(String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r11, "outVarName");
        g r5 = a.k(r12, "cursorVarName", "scope", r13);
        RowAdapter.onCursorReady$default(this.rowAdapter, r12, r13, null, 4, null);
        c r10 = new c(this.type.getTypeName());
        if (XTypeKt.isArray(this.type) == false) goto L5;
        String r14 = Javapoet_extKt.getT();
        String r15 = Javapoet_extKt.getL();
        r5.c(androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("final ", r14, " ", r15, " = new "), Javapoet_extKt.getT(), "[", Javapoet_extKt.getL(), ".getCount()][]"), new Object[]{r10, r11, ((XArrayType) this.type).getComponentType().getTypeName(), r12});
    L6:
        String r16 = r13.getTmpVar("_item");
        String r17 = r13.getTmpVar("_index");
        r5.c(a.q(Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), " = 0"), new Object[]{x.f15023h, r17});
        r5.e(j0.k("while(", Javapoet_extKt.getL(), ".moveToNext())"), new Object[]{r12});
        r5.c(androidx.constraintlayout.motion.widget.a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{this.type.getTypeName(), r16});
        this.rowAdapter.convert(r16, r12, r13);
        r5.c(Javapoet_extKt.getL() + "[" + Javapoet_extKt.getL() + "] = " + Javapoet_extKt.getL(), new Object[]{r11, r17, r16});
        r5.c(j0.j(Javapoet_extKt.getL(), " ++"), new Object[]{r17});
        r5.g();
        return;
    L5:
        String r18 = Javapoet_extKt.getT();
        String r19 = Javapoet_extKt.getL();
        r5.c(androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("final ", r18, " ", r19, " = new "), Javapoet_extKt.getT(), "[", Javapoet_extKt.getL(), ".getCount()]"), new Object[]{r10, r11, this.type.getTypeName(), r12});
        goto L6
    }

    public final XType getType() {
        return this.type;
    }
}
