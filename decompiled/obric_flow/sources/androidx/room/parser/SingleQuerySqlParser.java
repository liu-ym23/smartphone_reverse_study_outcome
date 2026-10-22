package androidx.room.parser;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.antlr.v4.runtime.CharStreams;
import androidx.room.jarjarred.org.antlr.v4.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0080\u0001\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062<\u0010\u0007\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00040\b2'\u0010\u000f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00040\u0010¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/room/parser/SingleQuerySqlParser;", "", "()V", "parse", ExifInterface.GPS_DIRECTION_TRUE, "input", "", "visit", "Lkotlin/Function2;", "Landroidx/room/parser/SQLiteParser$Sql_stmtContext;", "Lkotlin/ParameterName;", "name", "statement", "", "syntaxErrors", "fallback", "Lkotlin/Function1;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SingleQuerySqlParser {
    public static final SingleQuerySqlParser INSTANCE = null;

    static {
        INSTANCE = new SingleQuerySqlParser();
    }

    private SingleQuerySqlParser() {
    }

    public final <T> T parse(String r5, Function2<? super SQLiteParser.Sql_stmtContext, ? super List<String>, ? extends T> r10, Function1<? super List<String>, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "visit");
        Intrinsics.checkNotNullParameter(r11, "fallback");
        SQLiteParser r12 = new SQLiteParser(new CommonTokenStream(new SQLiteLexer(CharStreams.fromString(r5))));
        final ArrayList r13 = new ArrayList();
        r12.addErrorListener(new AnonymousClass1(r13));
        List<SQLiteParser.Sql_stmt_listContext> r14 = r12.parse().sql_stmt_list();     // Catch: RuntimeException -> L7
        if (r14.isEmpty() == true) goto L6;
        List<ParseTree> r15 = ((SQLiteParser.Sql_stmt_listContext) CollectionsKt.first(r14)).children;     // Catch: RuntimeException -> L7
        ArrayList r16 = new ArrayList();     // Catch: RuntimeException -> L7
        Iterator<T> r17 = r15.iterator();     // Catch: RuntimeException -> L7
    L11:
        if (r17.hasNext() == false) goto L16;
        T r18 = r17.next();     // Catch: RuntimeException -> L7
        if ((r18 instanceof SQLiteParser.Sql_stmtContext) == false) goto L11;
        r16.add(r18);     // Catch: RuntimeException -> L7
        goto L11
    L16:
        if (r16.size() == 1) goto L19;
        r13.add(ParserErrors.INSTANCE.getNOT_ONE_QUERY());     // Catch: RuntimeException -> L7
    L19:
        return r10.mo2invoke((SQLiteParser.Sql_stmtContext) CollectionsKt.first(r16), r13);
    L6:
        return r11.invoke(CollectionsKt.listOf(ParserErrors.INSTANCE.getNOT_ONE_QUERY()));
    L7:
        e = move-exception;
        r13.add("unknown error while parsing " + r5 + " : " + e.getMessage());
        return r11.invoke(r13);
    }
}
