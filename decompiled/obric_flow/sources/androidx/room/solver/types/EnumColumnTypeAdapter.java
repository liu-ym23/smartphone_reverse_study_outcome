package androidx.room.solver.types;

import ai.j0;
import androidx.room.compiler.processing.XEnumTypeElement;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.solver.CodeGenScope;
import androidx.room.writer.TypeWriter;
import com.squareup.javapoet.g;
import com.squareup.javapoet.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/solver/types/EnumColumnTypeAdapter;", "Landroidx/room/solver/types/ColumnTypeAdapter;", "Landroidx/room/compiler/processing/XEnumTypeElement;", "enumTypeElement", "<init>", "(Landroidx/room/compiler/processing/XEnumTypeElement;)V", "Landroidx/room/solver/CodeGenScope;", "scope", "Lcom/squareup/javapoet/t;", "enumToStringMethod", "(Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/t;", "stringToEnumMethod", "", "outVarName", "cursorVarName", "indexVarName", "", "readFromCursor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/room/solver/CodeGenScope;)V", "stmtName", "valueVarName", "bindToStmt", "Landroidx/room/compiler/processing/XEnumTypeElement;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EnumColumnTypeAdapter extends ColumnTypeAdapter {
    private final XEnumTypeElement enumTypeElement;

    public EnumColumnTypeAdapter(XEnumTypeElement r5) {
        Intrinsics.checkNotNullParameter(r5, "enumTypeElement");
        super(r5.getType(), SQLTypeAffinity.TEXT);
        this.enumTypeElement = r5;
    }

    public static final /* synthetic */ XEnumTypeElement access$getEnumTypeElement$p(EnumColumnTypeAdapter r5) {
        return r5.enumTypeElement;
    }

    private final t enumToStringMethod(CodeGenScope r5) {
        TypeWriter r10 = r5.getWriter();
        XTypeElement r11 = getOut().getTypeElement();
        Intrinsics.checkNotNull(r11);
        final String r12 = j0.j(r11.getName(), "_enumToString");
        return r10.getOrCreateMethod(new AnonymousClass1(this, r12));
    }

    private final t stringToEnumMethod(CodeGenScope r5) {
        TypeWriter r10 = r5.getWriter();
        XTypeElement r11 = getOut().getTypeElement();
        Intrinsics.checkNotNull(r11);
        final String r12 = j0.j(r11.getName(), "_stringToEnum");
        return r10.getOrCreateMethod(new C01431(this, r12));
    }

    @Override // androidx.room.solver.types.StatementValueBinder
    public void bindToStmt(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "stmtName");
        Intrinsics.checkNotNullParameter(r11, "indexVarName");
        Intrinsics.checkNotNullParameter(r12, "valueVarName");
        Intrinsics.checkNotNullParameter(r13, "scope");
        t r14 = enumToStringMethod(r13);
        g r15 = r13.builder();
        r15.e(j0.k("if (", Javapoet_extKt.getL(), " == null)"), new Object[]{r12});
        r15.c(a.q(Javapoet_extKt.getL(), ".bindNull(", Javapoet_extKt.getL(), ")"), new Object[]{r10, r11});
        r15.h("else", new Object[0]);
        String r5 = Javapoet_extKt.getL();
        String r16 = Javapoet_extKt.getL();
        String r17 = Javapoet_extKt.getN();
        String r18 = Javapoet_extKt.getL();
        r15.c(androidx.constraintlayout.motion.widget.a.t(a.y(r5, ".bindString(", r16, ", ", r17), "(", r18, "))"), new Object[]{r10, r11, r14, r12});
        r15.g();
    }

    @Override // androidx.room.solver.types.CursorValueReader
    public void readFromCursor(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        Intrinsics.checkNotNullParameter(r11, "cursorVarName");
        Intrinsics.checkNotNullParameter(r12, "indexVarName");
        Intrinsics.checkNotNullParameter(r13, "scope");
        t r14 = stringToEnumMethod(r13);
        g r15 = r13.builder();
        String r5 = Javapoet_extKt.getL();
        String r16 = Javapoet_extKt.getN();
        String r17 = Javapoet_extKt.getL();
        String r18 = Javapoet_extKt.getL();
        r15.c(androidx.constraintlayout.motion.widget.a.t(a.y(r5, " = ", r16, "(", r17), ".getString(", r18, "))"), new Object[]{r10, r14, r11, r12});
    }
}
