package androidx.room.solver.types;

import androidx.room.compiler.processing.XType;
import androidx.room.parser.SQLTypeAffinity;
import com.squareup.javapoet.x;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/room/solver/types/ColumnTypeAdapter;", "Landroidx/room/solver/types/StatementValueBinder;", "Landroidx/room/solver/types/CursorValueReader;", "Landroidx/room/compiler/processing/XType;", "out", "Landroidx/room/parser/SQLTypeAffinity;", "typeAffinity", "<init>", "(Landroidx/room/compiler/processing/XType;Landroidx/room/parser/SQLTypeAffinity;)V", "typeMirror", "()Landroidx/room/compiler/processing/XType;", "affinity", "()Landroidx/room/parser/SQLTypeAffinity;", "Landroidx/room/compiler/processing/XType;", "getOut", "Landroidx/room/parser/SQLTypeAffinity;", "getTypeAffinity", "Lcom/squareup/javapoet/x;", "outTypeName$delegate", "Lkotlin/Lazy;", "getOutTypeName", "()Lcom/squareup/javapoet/x;", "outTypeName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ColumnTypeAdapter implements StatementValueBinder, CursorValueReader {
    private final XType out;
    private final Lazy outTypeName$delegate;
    private final SQLTypeAffinity typeAffinity;

    public ColumnTypeAdapter(XType r5, SQLTypeAffinity r10) {
        Intrinsics.checkNotNullParameter(r5, "out");
        Intrinsics.checkNotNullParameter(r10, "typeAffinity");
        this.out = r5;
        this.typeAffinity = r10;
        this.outTypeName$delegate = LazyKt.lazy(new ColumnTypeAdapter$outTypeName$2(this));
    }

    @Override // androidx.room.solver.types.CursorValueReader
    public SQLTypeAffinity affinity() {
        return this.typeAffinity;
    }

    public final XType getOut() {
        return this.out;
    }

    public final x getOutTypeName() {
        return (x) this.outTypeName$delegate.getValue();
    }

    public final SQLTypeAffinity getTypeAffinity() {
        return this.typeAffinity;
    }

    @Override // androidx.room.solver.types.StatementValueBinder, androidx.room.solver.types.CursorValueReader
    public XType typeMirror() {
        return this.out;
    }
}
