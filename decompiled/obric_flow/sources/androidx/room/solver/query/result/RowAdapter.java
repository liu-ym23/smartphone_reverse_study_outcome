package androidx.room.solver.query.result;

import androidx.room.compiler.processing.XType;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.ColumnIndexVar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Landroidx/room/solver/query/result/RowAdapter;", "", "out", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/XType;)V", "getOut", "()Landroidx/room/compiler/processing/XType;", "convert", "", "outVarName", "", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "getDefaultIndexAdapter", "Landroidx/room/solver/query/result/IndexAdapter;", "onCursorReady", "indices", "", "Landroidx/room/vo/ColumnIndexVar;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class RowAdapter {
    private final XType out;

    public RowAdapter(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "out");
        this.out = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onCursorReady$default(RowAdapter r5, String r10, CodeGenScope r11, List r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 4) == 0) goto L6;
        IndexAdapter r15 = r5.getDefaultIndexAdapter();
        r15.onCursorReady(r10, r11);
        r12 = r15.getIndexVars();
    L6:
        r5.onCursorReady(r10, r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCursorReady");
    }

    public abstract void convert(String r5, String r10, CodeGenScope r11);

    public abstract IndexAdapter getDefaultIndexAdapter();

    public final XType getOut() {
        return this.out;
    }

    public void onCursorReady(String r5, CodeGenScope r10, List<ColumnIndexVar> r11) {
        Intrinsics.checkNotNullParameter(r5, "cursorVarName");
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "indices");
    }
}
