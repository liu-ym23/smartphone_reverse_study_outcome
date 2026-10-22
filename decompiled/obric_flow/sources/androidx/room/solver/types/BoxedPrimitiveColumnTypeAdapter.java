package androidx.room.solver.types;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/types/BoxedPrimitiveColumnTypeAdapter;", "Landroidx/room/solver/types/ColumnTypeAdapter;", "boxed", "Landroidx/room/compiler/processing/XType;", "primitiveAdapter", "Landroidx/room/solver/types/PrimitiveColumnTypeAdapter;", "(Landroidx/room/compiler/processing/XType;Landroidx/room/solver/types/PrimitiveColumnTypeAdapter;)V", "getPrimitiveAdapter", "()Landroidx/room/solver/types/PrimitiveColumnTypeAdapter;", "bindToStmt", "", "stmtName", "", "indexVarName", "valueVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "readFromCursor", "outVarName", "cursorVarName", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class BoxedPrimitiveColumnTypeAdapter extends ColumnTypeAdapter {
    public static final Companion Companion = null;
    private final PrimitiveColumnTypeAdapter primitiveAdapter;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¨\u0006\b"}, d2 = {"Landroidx/room/solver/types/BoxedPrimitiveColumnTypeAdapter$Companion;", "", "()V", "createBoxedPrimitiveAdapters", "", "Landroidx/room/solver/types/ColumnTypeAdapter;", "primitiveAdapters", "Landroidx/room/solver/types/PrimitiveColumnTypeAdapter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<ColumnTypeAdapter> createBoxedPrimitiveAdapters(List<PrimitiveColumnTypeAdapter> r5) {
            Intrinsics.checkNotNullParameter(r5, "primitiveAdapters");
            ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            PrimitiveColumnTypeAdapter r12 = (PrimitiveColumnTypeAdapter) r11.next();
            r10.add(new BoxedPrimitiveColumnTypeAdapter(r12.getOut().boxed().makeNullable(), r12));
            goto L4
        L6:
            return r10;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BoxedPrimitiveColumnTypeAdapter(XType r5, PrimitiveColumnTypeAdapter r10) {
        Intrinsics.checkNotNullParameter(r5, "boxed");
        Intrinsics.checkNotNullParameter(r10, "primitiveAdapter");
        super(r5, r10.getTypeAffinity());
        this.primitiveAdapter = r10;
    }

    @Override // androidx.room.solver.types.StatementValueBinder
    public void bindToStmt(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "stmtName");
        Intrinsics.checkNotNullParameter(r11, "indexVarName");
        g r5 = a.k(r12, "valueVarName", "scope", r13);
        r5.e(j0.k("if (", Javapoet_extKt.getL(), " == null)"), new Object[]{r12});
        r5.c(a.q(Javapoet_extKt.getL(), ".bindNull(", Javapoet_extKt.getL(), ")"), new Object[]{r10, r11});
        r5.h("else", new Object[0]);
        this.primitiveAdapter.bindToStmt(r10, r11, r12, r13);
        r5.g();
    }

    public final PrimitiveColumnTypeAdapter getPrimitiveAdapter() {
        return this.primitiveAdapter;
    }

    @Override // androidx.room.solver.types.CursorValueReader
    public void readFromCursor(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        Intrinsics.checkNotNullParameter(r11, "cursorVarName");
        g r5 = a.k(r12, "indexVarName", "scope", r13);
        r5.e(j0.l("if (", Javapoet_extKt.getL(), ".isNull(", Javapoet_extKt.getL(), "))"), new Object[]{r11, r12});
        r5.c(j0.j(Javapoet_extKt.getL(), " = null"), new Object[]{r10});
        r5.h("else", new Object[0]);
        this.primitiveAdapter.readFromCursor(r10, r11, r12, r13);
        r5.g();
    }
}
