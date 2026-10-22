package androidx.room.parser.expansion;

import androidx.room.parser.SingleQuerySqlParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSqlParser;", "", "()V", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpandableSqlParser {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSqlParser$Companion;", "", "()V", "parse", "Landroidx/room/parser/expansion/ExpandableParsedQuery;", "input", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final ExpandableParsedQuery parse(final String r5) {
            Intrinsics.checkNotNullParameter(r5, "input");
            return (ExpandableParsedQuery) SingleQuerySqlParser.INSTANCE.parse(r5, new ExpandableSqlParser$Companion$parse$1(r5), new ExpandableSqlParser$Companion$parse$2(r5));
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ExpandableSqlParser() {
    }
}
