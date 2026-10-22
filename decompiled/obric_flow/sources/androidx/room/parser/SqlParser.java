package androidx.room.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/parser/SqlParser;", "", "()V", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SqlParser {
    public static final Companion Companion = null;
    private static final Character[] INVALID_IDENTIFIER_CHARS = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/parser/SqlParser$Companion;", "", "()V", "INVALID_IDENTIFIER_CHARS", "", "", "[Ljava/lang/Character;", "isValidIdentifier", "", "input", "", "parse", "Landroidx/room/parser/ParsedQuery;", "rawQueryForTables", "tableNames", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final boolean isValidIdentifier(String r5) {
            Intrinsics.checkNotNullParameter(r5, "input");
            if (StringsKt.isBlank(r5) == true) goto L14;
            Character[] r10 = SqlParser.access$getINVALID_IDENTIFIER_CHARS$cp();
            int r11 = r10.length;
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L10;
            if (StringsKt.f(r5, r10[r12].charValue()) == true) goto L15;
            r12 = r12 + 1;
            goto L5
        L15:
            return false;
        L10:
            return true;
        L14:
            return false;
        }

        public final ParsedQuery parse(final String r5) {
            Intrinsics.checkNotNullParameter(r5, "input");
            return (ParsedQuery) SingleQuerySqlParser.INSTANCE.parse(r5, new SqlParser$Companion$parse$1(r5), new SqlParser$Companion$parse$2(r5));
        }

        public final ParsedQuery rawQueryForTables(Set<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "tableNames");
            QueryType r5 = QueryType.UNKNOWN;
            List r11 = CollectionsKt.emptyList();
            Set<String> r12 = r10;
            ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
            Iterator<T> r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L7;
            String r15 = (String) r14.next();
            r13.add(new Table(r15, r15));
            goto L4
        L7:
            return new ParsedQuery("raw query", r5, r11, CollectionsKt.toSet(r13), null, CollectionsKt.emptyList());
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        INVALID_IDENTIFIER_CHARS = new Character[]{'`', Character.valueOf(Typography.quote)};
    }

    public SqlParser() {
    }

    public static final /* synthetic */ Character[] access$getINVALID_IDENTIFIER_CHARS$cp() {
        return INVALID_IDENTIFIER_CHARS;
    }
}
