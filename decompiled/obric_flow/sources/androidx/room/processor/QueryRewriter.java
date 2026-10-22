package androidx.room.processor;

import androidx.room.parser.ParsedQuery;
import androidx.room.solver.query.result.QueryResultAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/room/processor/QueryRewriter;", "", "rewrite", "Landroidx/room/parser/ParsedQuery;", "query", "resultAdapter", "Landroidx/room/solver/query/result/QueryResultAdapter;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface QueryRewriter {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/processor/QueryRewriter$Companion;", "", "()V", "NoOpRewriter", "Landroidx/room/processor/QueryRewriter;", "getNoOpRewriter", "()Landroidx/room/processor/QueryRewriter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final QueryRewriter NoOpRewriter = null;

        static {
            $$INSTANCE = new Companion();
            NoOpRewriter = new QueryRewriter$Companion$NoOpRewriter$1();
        }

        private Companion() {
        }

        public final QueryRewriter getNoOpRewriter() {
            return NoOpRewriter;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    ParsedQuery rewrite(ParsedQuery r5, QueryResultAdapter r10);
}
