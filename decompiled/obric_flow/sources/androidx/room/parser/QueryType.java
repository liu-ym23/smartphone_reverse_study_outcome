package androidx.room.parser;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Landroidx/room/parser/QueryType;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "SELECT", "DELETE", "UPDATE", "EXPLAIN", "INSERT", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum QueryType extends Enum<QueryType> {
    private static final /* synthetic */ QueryType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final QueryType DELETE = null;
    public static final QueryType EXPLAIN = null;
    public static final QueryType INSERT = null;
    public static final QueryType SELECT = null;
    private static final HashSet<QueryType> SUPPORTED = null;
    public static final QueryType UNKNOWN = null;
    public static final QueryType UPDATE = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/parser/QueryType$Companion;", "", "()V", "SUPPORTED", "Ljava/util/HashSet;", "Landroidx/room/parser/QueryType;", "Lkotlin/collections/HashSet;", "getSUPPORTED", "()Ljava/util/HashSet;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final HashSet<QueryType> getSUPPORTED() {
            return QueryType.access$getSUPPORTED$cp();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ QueryType[] $values() {
        return new QueryType[]{UNKNOWN, SELECT, DELETE, UPDATE, EXPLAIN, INSERT};
    }

    static {
        UNKNOWN = new QueryType("UNKNOWN", 0);
        QueryType r5 = new QueryType("SELECT", 1);
        SELECT = r5;
        QueryType r10 = new QueryType("DELETE", 2);
        DELETE = r10;
        QueryType r11 = new QueryType("UPDATE", 3);
        UPDATE = r11;
        EXPLAIN = new QueryType("EXPLAIN", 4);
        QueryType r12 = new QueryType("INSERT", 5);
        INSERT = r12;
        $VALUES = $values();
        Companion = new Companion(null);
        SUPPORTED = SetsKt.hashSetOf(new QueryType[]{r5, r10, r11, r12});
    }

    private QueryType(String r5, int r10) {
        super(r5, r10);
    }

    public static final /* synthetic */ HashSet access$getSUPPORTED$cp() {
        return SUPPORTED;
    }

    public static QueryType valueOf(String r5) {
        return (QueryType) Enum.valueOf(QueryType.class, r5);
    }

    public static QueryType[] values() {
        return (QueryType[]) $VALUES.clone();
    }
}
