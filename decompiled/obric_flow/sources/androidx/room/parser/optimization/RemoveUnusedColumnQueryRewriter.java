package androidx.room.parser.optimization;

import ai.j0;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.SqlParser;
import androidx.room.processor.QueryRewriter;
import androidx.room.solver.query.result.QueryMappedRowAdapter;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.QueryResultInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Landroidx/room/parser/optimization/RemoveUnusedColumnQueryRewriter;", "Landroidx/room/processor/QueryRewriter;", "()V", "rewrite", "Landroidx/room/parser/ParsedQuery;", "query", "resultAdapter", "Landroidx/room/solver/query/result/QueryResultAdapter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RemoveUnusedColumnQueryRewriter implements QueryRewriter {
    public static final RemoveUnusedColumnQueryRewriter INSTANCE = null;

    static {
        INSTANCE = new RemoveUnusedColumnQueryRewriter();
    }

    private RemoveUnusedColumnQueryRewriter() {
    }

    @Override // androidx.room.processor.QueryRewriter
    public ParsedQuery rewrite(ParsedQuery r11, QueryResultAdapter r12) {
        Intrinsics.checkNotNullParameter(r11, "query");
        Intrinsics.checkNotNullParameter(r12, "resultAdapter");
        QueryResultInfo r10 = r11.getResultInfo();
        if (r10 != null) goto L6;
        return r11;
    L6:
        if (r12.getMappings().isEmpty() == false) goto L8;
        return r11;
    L8:
        List<QueryMappedRowAdapter.Mapping> r13 = r12.getMappings();
        ArrayList r5 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        CollectionsKt.a(r5, ((QueryMappedRowAdapter.Mapping) r14.next()).getUsedColumns());
        goto L10
    L12:
        List<ColumnInfo> r15 = r10.getColumns();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L14:
        if (r17.hasNext() == false) goto L16;
        r16.add(((ColumnInfo) r17.next()).getName());
        goto L14
    L16:
        List r18 = CollectionsKt.v(r16, r5);
        if (r18.isEmpty() == false) goto L20;
        return r11;
    L20:
        if (r16.size() == CollectionsKt.distinct(r16).size()) goto L22;
        return r11;
    L22:
        List r19 = CollectionsKt.v(r16, r18);
        ParsedQuery r110 = SqlParser.Companion.parse(j0.l("SELECT ", CollectionsKt.q(r19, ", ", null, null, 0, null, RemoveUnusedColumnQueryRewriter$rewrite$updated$1.INSTANCE, 30), " FROM (", r11.getOriginal(), ")"));
        if (r110.getErrors().isEmpty() == true) goto L25;
        return r11;
    L25:
        return r110;
    }
}
