package androidx.room.solver;

import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.Table;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.QueryResultBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH$J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH$J\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Landroidx/room/solver/ObservableQueryResultBinderProvider;", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "getContext", "()Landroidx/room/processor/Context;", "create", "Landroidx/room/solver/query/result/QueryResultBinder;", "typeArg", "Landroidx/room/compiler/processing/XType;", "resultAdapter", "Landroidx/room/solver/query/result/QueryResultAdapter;", "tableNames", "", "", "extractTypeArg", "declared", "provide", "query", "Landroidx/room/parser/ParsedQuery;", "extras", "Landroidx/room/solver/TypeAdapterExtras;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ObservableQueryResultBinderProvider implements QueryResultBinderProvider {
    private final Context context;

    public ObservableQueryResultBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
    }

    public abstract QueryResultBinder create(XType r5, QueryResultAdapter r10, Set<String> r11);

    public abstract XType extractTypeArg(XType r5);

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public final QueryResultBinder provide(XType r5, ParsedQuery r10, TypeAdapterExtras r11) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extras");
        XType r12 = extractTypeArg(r5);
        QueryResultAdapter r13 = this.context.getTypeAdapterStore().findQueryResultAdapter(r12, r10, r11);
        if (r13 == null) goto L6;
        List<String> r14 = r13.accessedTableNames();
        if (r14 == null) goto L6;
    L7:
        Set<Table> r15 = r10.getTables();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L9:
        if (r17.hasNext() == false) goto L11;
        r16.add(((Table) r17.next()).getName());
        goto L9
    L11:
        Set<String> r18 = CollectionsKt.toSet(CollectionsKt.plus(r14, r16));
        if (r18.isEmpty() == false) goto L15;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getOBSERVABLE_QUERY_NOTHING_TO_OBSERVE(), new Object[0]);
    L15:
        return create(r12, r13, r18);
    L6:
        r14 = CollectionsKt.emptyList();
        goto L7
    }
}
