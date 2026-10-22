package androidx.room.solver.types;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/room/solver/types/UuidColumnTypeAdapter;", "Landroidx/room/solver/types/ColumnTypeAdapter;", "out", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/XType;)V", "bindToStmt", "", "stmtName", "", "indexVarName", "valueVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "readFromCursor", "outVarName", "cursorVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UuidColumnTypeAdapter extends ColumnTypeAdapter {
    public UuidColumnTypeAdapter(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "out");
        super(r5, SQLTypeAffinity.BLOB);
    }

    @Override // androidx.room.solver.types.StatementValueBinder
    public void bindToStmt(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "stmtName");
        Intrinsics.checkNotNullParameter(r11, "indexVarName");
        g r14 = a.k(r12, "valueVarName", "scope", r13);
        r14.e(j0.k("if (", Javapoet_extKt.getL(), " == null)"), new Object[]{r12});
        r14.c(a.q(Javapoet_extKt.getL(), ".bindNull(", Javapoet_extKt.getL(), ")"), new Object[]{r10, r11});
        r14.h("else", new Object[0]);
        String r15 = Javapoet_extKt.getL();
        String r5 = Javapoet_extKt.getL();
        String r16 = Javapoet_extKt.getT();
        String r17 = Javapoet_extKt.getL();
        String r18 = Javapoet_extKt.getL();
        StringBuilder r19 = a.y(r15, ".bindBlob(", r5, ", ", r16);
        androidx.constraintlayout.motion.widget.a.C(r19, ".", r17, "(", r18);
        r19.append("))");
        r14.c(r19.toString(), new Object[]{r10, r11, RoomTypeNames.INSTANCE.getUUID_UTIL(), "convertUUIDToByte", r12});
        r14.g();
    }

    @Override // androidx.room.solver.types.CursorValueReader
    public void readFromCursor(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        Intrinsics.checkNotNullParameter(r11, "cursorVarName");
        g r14 = a.k(r12, "indexVarName", "scope", r13);
        r14.e(j0.l("if (", Javapoet_extKt.getL(), ".isNull(", Javapoet_extKt.getL(), "))"), new Object[]{r11, r12});
        r14.c(j0.j(Javapoet_extKt.getL(), " = null"), new Object[]{r10});
        r14.h("else", new Object[0]);
        String r15 = Javapoet_extKt.getL();
        String r5 = Javapoet_extKt.getT();
        String r16 = Javapoet_extKt.getL();
        String r17 = Javapoet_extKt.getL();
        String r18 = Javapoet_extKt.getL();
        StringBuilder r19 = a.y(r15, " = ", r5, ".", r16);
        androidx.constraintlayout.motion.widget.a.C(r19, "(", r17, ".getBlob(", r18);
        r19.append("))");
        r14.c(r19.toString(), new Object[]{r10, RoomTypeNames.INSTANCE.getUUID_UTIL(), "convertByteToUUID", r11, r12});
        r14.g();
    }
}
