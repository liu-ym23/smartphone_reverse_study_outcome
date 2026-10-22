package androidx.room.solver.types;

import androidx.room.compiler.processing.XType;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.solver.CodeGenScope;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/room/solver/types/CursorValueReader;", "", "affinity", "Landroidx/room/parser/SQLTypeAffinity;", "readFromCursor", "", "outVarName", "", "cursorVarName", "indexVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "typeMirror", "Landroidx/room/compiler/processing/XType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface CursorValueReader {
    SQLTypeAffinity affinity();

    void readFromCursor(String r5, String r10, String r11, CodeGenScope r12);

    XType typeMirror();
}
