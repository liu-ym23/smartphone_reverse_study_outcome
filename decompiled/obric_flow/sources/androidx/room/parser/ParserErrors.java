package androidx.room.parser;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/parser/ParserErrors;", "", "()V", "ANONYMOUS_BIND_ARGUMENT", "", "getANONYMOUS_BIND_ARGUMENT", "()Ljava/lang/String;", "NOT_ONE_QUERY", "getNOT_ONE_QUERY", "cannotUseVariableIndices", "name", "position", "", "invalidQueryType", "type", "Landroidx/room/parser/QueryType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ParserErrors {
    private static final String ANONYMOUS_BIND_ARGUMENT = null;
    public static final ParserErrors INSTANCE = null;
    private static final String NOT_ONE_QUERY = null;

    static {
        INSTANCE = new ParserErrors();
        ANONYMOUS_BIND_ARGUMENT = "Room does not support ? as bind parameters. You must use named bind arguments (e..g :argName)";
        NOT_ONE_QUERY = "Must have exactly 1 query in the value of @Query or @DatabaseView";
    }

    private ParserErrors() {
    }

    public final String cannotUseVariableIndices(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return "Cannot use variable indices. Use named parameters instead (e.g. WHERE name LIKE :nameArg and lastName LIKE :lastName). Problem: " + r5 + " at " + r10;
    }

    public final String getANONYMOUS_BIND_ARGUMENT() {
        return ANONYMOUS_BIND_ARGUMENT;
    }

    public final String getNOT_ONE_QUERY() {
        return NOT_ONE_QUERY;
    }

    public final String invalidQueryType(QueryType r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        return r10 + " query type is not supported yet. You can use:" + CollectionsKt.q(QueryType.Companion.getSUPPORTED(), ", ", null, null, 0, null, AnonymousClass1.INSTANCE, 30);
    }
}
