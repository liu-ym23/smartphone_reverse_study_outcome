package androidx.room.solver.types;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/room/solver/types/CompositeAdapter;", "Landroidx/room/solver/types/ColumnTypeAdapter;", "out", "Landroidx/room/compiler/processing/XType;", "columnTypeAdapter", "intoStatementConverter", "Landroidx/room/solver/types/TypeConverter;", "fromCursorConverter", "(Landroidx/room/compiler/processing/XType;Landroidx/room/solver/types/ColumnTypeAdapter;Landroidx/room/solver/types/TypeConverter;Landroidx/room/solver/types/TypeConverter;)V", "getColumnTypeAdapter", "()Landroidx/room/solver/types/ColumnTypeAdapter;", "getFromCursorConverter", "()Landroidx/room/solver/types/TypeConverter;", "getIntoStatementConverter", "bindToStmt", "", "stmtName", "", "indexVarName", "valueVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "readFromCursor", "outVarName", "cursorVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CompositeAdapter extends ColumnTypeAdapter {
    private final ColumnTypeAdapter columnTypeAdapter;
    private final TypeConverter fromCursorConverter;
    private final TypeConverter intoStatementConverter;

    public CompositeAdapter(XType r5, ColumnTypeAdapter r10, TypeConverter r11, TypeConverter r12) {
        Intrinsics.checkNotNullParameter(r5, "out");
        Intrinsics.checkNotNullParameter(r10, "columnTypeAdapter");
        super(r5, r10.getTypeAffinity());
        this.columnTypeAdapter = r10;
        this.intoStatementConverter = r11;
        this.fromCursorConverter = r12;
    }

    @Override // androidx.room.solver.types.StatementValueBinder
    public void bindToStmt(String r5, String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r5, "stmtName");
        Intrinsics.checkNotNullParameter(r10, "indexVarName");
        Intrinsics.checkNotNullParameter(r11, "valueVarName");
        Intrinsics.checkNotNullParameter(r12, "scope");
        if (this.intoStatementConverter != null) goto L5;
        return;
    L5:
        r12.builder();
        String r13 = this.intoStatementConverter.convert(r11, r12);
        this.columnTypeAdapter.bindToStmt(r5, r10, r13, r12);
    }

    public final ColumnTypeAdapter getColumnTypeAdapter() {
        return this.columnTypeAdapter;
    }

    public final TypeConverter getFromCursorConverter() {
        return this.fromCursorConverter;
    }

    public final TypeConverter getIntoStatementConverter() {
        return this.intoStatementConverter;
    }

    @Override // androidx.room.solver.types.CursorValueReader
    public void readFromCursor(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        Intrinsics.checkNotNullParameter(r11, "cursorVarName");
        Intrinsics.checkNotNullParameter(r12, "indexVarName");
        Intrinsics.checkNotNullParameter(r13, "scope");
        if (this.fromCursorConverter != null) goto L5;
        return;
    L5:
        g r5 = r13.builder();
        String r14 = r13.getTmpVar();
        r5.c(a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{this.columnTypeAdapter.getOutTypeName(), r14});
        this.columnTypeAdapter.readFromCursor(r14, r11, r12, r13);
        this.fromCursorConverter.convert(r14, r10, r13);
    }
}
