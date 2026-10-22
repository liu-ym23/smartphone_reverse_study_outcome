package androidx.room.solver.shortcut.binder;

import ai.j0;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.shortcut.result.InsertOrUpsertMethodAdapter;
import androidx.room.vo.ShortcutQueryParameter;
import androidx.room.writer.DaoWriter;
import com.squareup.javapoet.m;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005JM\u0010\u0013\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/shortcut/binder/InstantUpsertMethodBinder;", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", "adapter", "<init>", "(Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;)V", "", "Landroidx/room/vo/ShortcutQueryParameter;", "parameters", "", "", "Lkotlin/Pair;", "Lcom/squareup/javapoet/m;", "", "adapters", "dbField", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convertAndReturn", "(Ljava/util/List;Ljava/util/Map;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InstantUpsertMethodBinder extends InsertOrUpsertMethodBinder {
    public InstantUpsertMethodBinder(InsertOrUpsertMethodAdapter r5) {
        super(r5);
    }

    @Override // androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder
    public void convertAndReturn(List<ShortcutQueryParameter> r5, Map<String, ? extends Pair<m, ? extends Object>> r10, m r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r5, "parameters");
        Intrinsics.checkNotNullParameter(r10, "adapters");
        Intrinsics.checkNotNullParameter(r11, "dbField");
        Intrinsics.checkNotNullParameter(r12, "scope");
        r12.builder().c(j0.j(Javapoet_extKt.getN(), ".assertNotSuspendingTransaction()"), new Object[]{DaoWriter.Companion.getDbField()});
        InsertOrUpsertMethodAdapter r13 = getAdapter();
        if (r13 == null) goto L6;
        r13.createMethodBody(r5, r10, r11, r12);
        return;
    }
}
