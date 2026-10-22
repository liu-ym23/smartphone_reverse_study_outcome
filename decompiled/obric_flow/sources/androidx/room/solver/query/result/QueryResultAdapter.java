package androidx.room.solver.query.result;

import androidx.room.solver.CodeGenScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/query/result/QueryResultAdapter;", "", "rowAdapters", "", "Landroidx/room/solver/query/result/RowAdapter;", "(Ljava/util/List;)V", "mappings", "Landroidx/room/solver/query/result/QueryMappedRowAdapter$Mapping;", "getMappings", "()Ljava/util/List;", "getRowAdapters", "accessedTableNames", "", "convert", "", "outVarName", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "shouldCopyCursor", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class QueryResultAdapter {
    private final List<RowAdapter> rowAdapters;

    /* JADX WARN: Multi-variable type inference failed */
    public QueryResultAdapter(List<? extends RowAdapter> r5) {
        Intrinsics.checkNotNullParameter(r5, "rowAdapters");
        this.rowAdapters = r5;
    }

    public final List<String> accessedTableNames() {
        List<RowAdapter> r5 = this.rowAdapters;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if ((r12 instanceof PojoRowAdapter) == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        CollectionsKt.a(r13, ((PojoRowAdapter) r14.next()).relationTableNames());
        goto L10
    L12:
        return r13;
    }

    public abstract void convert(String r5, String r10, CodeGenScope r11);

    public final List<QueryMappedRowAdapter.Mapping> getMappings() {
        List<RowAdapter> r5 = this.rowAdapters;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if ((r12 instanceof QueryMappedRowAdapter) == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        ArrayList r13 = new ArrayList(CollectionsKt.h(r10));
        Iterator r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r13.add(((QueryMappedRowAdapter) r14.next()).getMapping());
        goto L10
    L12:
        return r13;
    }

    public final List<RowAdapter> getRowAdapters() {
        return this.rowAdapters;
    }

    public final boolean shouldCopyCursor() {
        List<RowAdapter> r5 = this.rowAdapters;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Object r12 = r11.next();
        if ((r12 instanceof PojoRowAdapter) == false) goto L4;
        r10.add(r12);
        goto L4
    L9:
        if (r10.isEmpty() == true) goto L26;
        Iterator r13 = r10.iterator();
    L13:
        if (r13.hasNext() == false) goto L27;
        if (((PojoRowAdapter) r13.next()).getRelationCollectors().isEmpty() == true) goto L13;
        return true;
    L27:
        return false;
    L26:
        return false;
    }
}
