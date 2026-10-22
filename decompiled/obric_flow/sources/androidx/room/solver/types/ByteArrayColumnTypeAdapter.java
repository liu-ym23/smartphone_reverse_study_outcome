package androidx.room.solver.types;

import ai.j0;
import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import com.squareup.javapoet.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Landroidx/room/solver/types/ByteArrayColumnTypeAdapter;", "Landroidx/room/solver/types/ColumnTypeAdapter;", "out", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/XType;)V", "bindToStmt", "", "stmtName", "", "indexVarName", "valueVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "readFromCursor", "outVarName", "cursorVarName", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ByteArrayColumnTypeAdapter extends ColumnTypeAdapter {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/room/solver/types/ByteArrayColumnTypeAdapter$Companion;", "", "()V", "create", "", "Landroidx/room/solver/types/ByteArrayColumnTypeAdapter;", "env", "Landroidx/room/compiler/processing/XProcessingEnv;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<ByteArrayColumnTypeAdapter> create(XProcessingEnv r5) {
            Intrinsics.checkNotNullParameter(r5, "env");
            XArrayType r10 = r5.getArrayType(x.f);
            DefaultConstructorMarker r11 = null;
            if (r5.getBackend() != XProcessingEnv.Backend.KSP) goto L6;
            return CollectionsKt.listOf(new ByteArrayColumnTypeAdapter[]{new ByteArrayColumnTypeAdapter(r10.makeNonNullable(), r11), new ByteArrayColumnTypeAdapter(r10.makeNullable(), r11)});
        L6:
            return CollectionsKt.listOf(new ByteArrayColumnTypeAdapter(r10, r11));
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ ByteArrayColumnTypeAdapter(XType r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    @Override // androidx.room.solver.types.StatementValueBinder
    public void bindToStmt(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "stmtName");
        Intrinsics.checkNotNullParameter(r11, "indexVarName");
        g r5 = a.k(r12, "valueVarName", "scope", r13);
        r5.e(j0.k("if (", Javapoet_extKt.getL(), " == null)"), new Object[]{r12});
        r5.c(a.q(Javapoet_extKt.getL(), ".bindNull(", Javapoet_extKt.getL(), ")"), new Object[]{r10, r11});
        r5.h("else", new Object[0]);
        StringBuilder r14 = a.y(Javapoet_extKt.getL(), ".bindBlob(", Javapoet_extKt.getL(), ", ", Javapoet_extKt.getL());
        r14.append(")");
        r5.c(r14.toString(), new Object[]{r10, r11, r12});
        r5.g();
    }

    @Override // androidx.room.solver.types.CursorValueReader
    public void readFromCursor(String r5, String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r5, "outVarName");
        Intrinsics.checkNotNullParameter(r10, "cursorVarName");
        g r13 = a.k(r11, "indexVarName", "scope", r12);
        r13.e(j0.l("if (", Javapoet_extKt.getL(), ".isNull(", Javapoet_extKt.getL(), "))"), new Object[]{r10, r11});
        r13.c(j0.j(Javapoet_extKt.getL(), " = null"), new Object[]{r5});
        r13.h("else", new Object[0]);
        StringBuilder r14 = a.y(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getL(), ".getBlob(", Javapoet_extKt.getL());
        r14.append(")");
        r13.c(r14.toString(), new Object[]{r5, r10, r11});
        r13.g();
    }

    private ByteArrayColumnTypeAdapter(XType r5) {
        super(r5, SQLTypeAffinity.BLOB);
    }
}
