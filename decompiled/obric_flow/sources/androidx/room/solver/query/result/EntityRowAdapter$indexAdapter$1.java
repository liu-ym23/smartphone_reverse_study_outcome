package androidx.room.solver.query.result;

import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.ColumnIndexVar;
import androidx.room.vo.HasFieldsKt;
import com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"androidx/room/solver/query/result/EntityRowAdapter$indexAdapter$1", "Landroidx/room/solver/query/result/IndexAdapter;", "indexVars", "", "Landroidx/room/vo/ColumnIndexVar;", "getIndexVars", "onCursorReady", "", "cursorVarName", "", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityRowAdapter$indexAdapter$1 implements IndexAdapter {
    private List<ColumnIndexVar> indexVars;
    final /* synthetic */ EntityRowAdapter this$0;

    public EntityRowAdapter$indexAdapter$1(EntityRowAdapter r5) {
        this.this$0 = r5;
    }

    @Override // androidx.room.solver.query.result.IndexAdapter
    public List<ColumnIndexVar> getIndexVars() {
        List<ColumnIndexVar> r5 = this.indexVars;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.solver.query.result.IndexAdapter
    public void onCursorReady(String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r10, "cursorVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        List<String> r12 = HasFieldsKt.getColumnNames(this.this$0.getEntity());
        ArrayList r5 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = (String) r13.next();
        StringBuilder r15 = a.y(Javapoet_extKt.getT(), ".getColumnIndex(", Javapoet_extKt.getN(), ", ", Javapoet_extKt.getS());
        r15.append(")");
        r5.add(new ColumnIndexVar(r14, i.d(r15.toString(), new Object[]{RoomTypeNames.INSTANCE.getCURSOR_UTIL(), r10, r14}).toString()));
        goto L4
    L6:
        this.indexVars = r5;
    }
}
