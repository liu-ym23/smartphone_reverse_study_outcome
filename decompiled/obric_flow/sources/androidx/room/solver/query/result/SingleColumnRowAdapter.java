package androidx.room.solver.query.result;

import androidx.room.solver.CodeGenScope;
import androidx.room.solver.types.CursorValueReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/solver/query/result/SingleColumnRowAdapter;", "Landroidx/room/solver/query/result/RowAdapter;", "reader", "Landroidx/room/solver/types/CursorValueReader;", "(Landroidx/room/solver/types/CursorValueReader;)V", "getReader", "()Landroidx/room/solver/types/CursorValueReader;", "convert", "", "outVarName", "", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "getDefaultIndexAdapter", "Landroidx/room/solver/query/result/IndexAdapter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SingleColumnRowAdapter extends RowAdapter {
    private final CursorValueReader reader;

    public SingleColumnRowAdapter(CursorValueReader r5) {
        Intrinsics.checkNotNullParameter(r5, "reader");
        super(r5.typeMirror());
        this.reader = r5;
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public void convert(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "outVarName");
        Intrinsics.checkNotNullParameter(r10, "cursorVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        this.reader.readFromCursor(r5, r10, "0", r11);
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public IndexAdapter getDefaultIndexAdapter() {
        return new AnonymousClass1();
    }

    public final CursorValueReader getReader() {
        return this.reader;
    }
}
