package com.bytedance.ai.bridge.method.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Base64;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DBOperation {
    public static final Pattern f = null;
    public final Context a;
    public final String b;
    public SQLiteDatabase c;
    public boolean d;
    public final Lazy e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/sqlite/DBOperation$QueryType;", "", "operationType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOperationType", "()Ljava/lang/String;", "UPDATE", "INSERT", "DELETE", "SELECT", "OTHER", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum QueryType extends Enum<QueryType> {
        public static final QueryType DELETE = null;
        public static final QueryType INSERT = null;
        public static final QueryType OTHER = null;
        public static final QueryType SELECT = null;
        public static final QueryType UPDATE = null;
        public static final /* synthetic */ QueryType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String operationType;

        public static EnumEntries<QueryType> getEntries() {
            return b;
        }

        static {
            QueryType r0 = new QueryType("UPDATE", 0, "update");
            UPDATE = r0;
            QueryType r1 = new QueryType("INSERT", 1, "insert");
            INSERT = r1;
            QueryType r10 = new QueryType("DELETE", 2, "delete");
            DELETE = r10;
            QueryType r11 = new QueryType("SELECT", 3, "select");
            SELECT = r11;
            QueryType r12 = new QueryType("OTHER", 4, "other");
            OTHER = r12;
            QueryType[] r13 = {r0, r1, r10, r11, r12};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static QueryType[] values() {
            return (QueryType[]) a.clone();
        }

        public final String getOperationType() {
            return this.operationType;
        }

        public static QueryType valueOf(String r1) {
            return (QueryType) r27.a.a(QueryType.class, r1);
        }

        public QueryType(String r1, int r10, String r11) {
            super(r1, r10);
            this.operationType = r11;
        }
    }

    public static final class a {
    }

    static {
        f = PatternProtector.compile("^\\s*(\\S+)", 2);
    }

    public static QueryType c(String r10) {
        Matcher r11 = f.matcher(r10);
        if (r11.find() == true) goto L16;
        com.bytedance.ai.utils.g.a.w("ExecuteSqliteActionMethod", "unsupported query type");
        return QueryType.OTHER;
    L16:
        String r12 = r11.group().toLowerCase();     // Catch: IllegalArgumentException -> L12
        QueryType[] r0 = QueryType.values();     // Catch: IllegalArgumentException -> L12
        int r13 = r0.length;     // Catch: IllegalArgumentException -> L12
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L11;
        QueryType r15 = r0[r14];     // Catch: IllegalArgumentException -> L12
        if (Intrinsics.areEqual(r15.getOperationType(), r12) == true) goto L8;
        r14 = r14 + 1;     // Catch: IllegalArgumentException -> L12
        goto L5
    L8:
        return r15;
    L11:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: IllegalArgumentException -> L12
    L12:
        com.bytedance.ai.utils.g.a.w("ExecuteSqliteActionMethod", "unsupported query type");
        return QueryType.OTHER;
    }

    public DBOperation(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "dbName");
        this.a = r10;
        this.b = r11;
        this.e = LazyKt.lazy(new d());
    }

    public static void a(SQLiteStatement r10, ArrayList r11) {
        Iterator r12 = r11.iterator();
        int r0 = 0;
    L4:
        if (r12.hasNext() == false) goto L24;
        Object r1 = r12.next();
        int r13 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if ((r1 instanceof Integer) == false) goto L12;
        r10.bindLong(r13, ((Number) r1).intValue());
    L23:
        r0 = r13;
        goto L4
    L12:
        if ((r1 instanceof Long) == false) goto L15;
        r10.bindLong(r13, ((Number) r1).longValue());
        goto L23
    L15:
        if ((r1 instanceof Double) == false) goto L18;
        r10.bindDouble(r13, ((Number) r1).doubleValue());
        goto L23
    L18:
        if ((r1 instanceof String) == false) goto L23;
        if (Intrinsics.areEqual(((String) r1).toUpperCase(), "NULL") == false) goto L22;
        r10.bindNull(r13);
        goto L23
    L22:
        r10.bindString(r13, d(r1, ""));
        goto L23
    }

    public static String d(Object r1, String r10) {
        if ((r1 instanceof String) == false) goto L6;
        return (String) r1;
    L6:
        if ((r1 instanceof Integer) == false) goto L9;
        return String.valueOf(((Number) r1).intValue());
    L9:
        if ((r1 instanceof Long) == false) goto L12;
        return String.valueOf(((Number) r1).longValue());
    L12:
        if ((r1 instanceof Boolean) == true) goto L14;
        return r10;
    L14:
        return String.valueOf(((Boolean) r1).booleanValue());
    }

    public final void e(f3.h<AbsExecuteSqliteActionMethodIDL.b> r10, Function1<? super SQLiteDatabase, Unit> r11) {
        BuildersKt.launch$default((CoroutineScope) this.e.getValue(), null, null, new DBOperation$safeRun$1(this, r11, r10, null), 3, null);
    }

    public static void b(Map r10, String r11, Cursor r12, int r13) {
        int r0 = r12.getType(r13);
        Long r1 = null;
        byte[] r14 = null;
        String r15 = null;
        Double r16 = null;
        if (r0 != 0) goto L5;
        r10.put(r11, null);
        return;
    L5:
        if (r0 == 1) goto L34;
        if (r0 == 2) goto L29;
        if (r0 == 3) goto L24;
        if (r0 == 4) goto L14;
        return;
    L14:
        if (r12.isNull(r13) == true) goto L17;
        r14 = r12.getBlob(r13);
    L17:
        if (r14 == null) goto L21;
        byte[] r17 = Base64.encode(r14, 0);
        Object r18 = r17;
        if (r17 == null) goto L21;
    L22:
        r10.put(r11, r18);
        return;
    L21:
        r18 = "";
        goto L22
    L24:
        if (r12.isNull(r13) == true) goto L27;
        r15 = r12.getString(r13);
    L27:
        r10.put(r11, r15);
        return;
    L29:
        if (r12.isNull(r13) == true) goto L32;
        r16 = Double.valueOf(r12.getDouble(r13));
    L32:
        r10.put(r11, r16);
        return;
    L34:
        if (r12.isNull(r13) == true) goto L37;
        r1 = Long.valueOf(r12.getLong(r13));
    L37:
        r10.put(r11, r1);
    }
}
