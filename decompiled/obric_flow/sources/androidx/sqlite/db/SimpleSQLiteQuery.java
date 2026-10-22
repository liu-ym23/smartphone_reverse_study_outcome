package androidx.sqlite.db;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "", "(Ljava/lang/String;)V", "bindArgs", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "argCount", "", "getArgCount", "()I", "[Ljava/lang/Object;", "sql", "getSql", "()Ljava/lang/String;", "bindTo", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public static final Companion Companion = null;
    private final Object[] bindArgs;
    private final String query;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery$Companion;", "", "()V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "bindArgs", "", "(Landroidx/sqlite/db/SupportSQLiteProgram;[Ljava/lang/Object;)V", "index", "", "arg", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        @SuppressLint({"SyntheticAccessor"})
        public final void bind(SupportSQLiteProgram r5, Object[] r10) {
            Intrinsics.checkNotNullParameter(r5, "statement");
            if (r10 != null) goto L5;
            return;
        L5:
            int r11 = r10.length;
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L8;
            Object r13 = r10[r12];
            r12 = r12 + 1;
            bind(r5, r12, r13);
            goto L6
        }

        private Companion() {
        }

        private final void bind(SupportSQLiteProgram r5, int r10, Object r11) {
            if (r11 != null) goto L5;
            r5.bindNull(r10);
            return;
        L5:
            if ((r11 instanceof byte[]) == false) goto L8;
            r5.bindBlob(r10, (byte[]) r11);
            return;
        L8:
            if ((r11 instanceof Float) == false) goto L11;
            r5.bindDouble(r10, ((Number) r11).floatValue());
            return;
        L11:
            if ((r11 instanceof Double) == false) goto L14;
            r5.bindDouble(r10, ((Number) r11).doubleValue());
            return;
        L14:
            if ((r11 instanceof Long) == false) goto L17;
            r5.bindLong(r10, ((Number) r11).longValue());
            return;
        L17:
            if ((r11 instanceof Integer) == false) goto L20;
            r5.bindLong(r10, ((Number) r11).intValue());
            return;
        L20:
            if ((r11 instanceof Short) == false) goto L23;
            r5.bindLong(r10, ((Number) r11).shortValue());
            return;
        L23:
            if ((r11 instanceof Byte) == false) goto L26;
            r5.bindLong(r10, ((Number) r11).byteValue());
            return;
        L26:
            if ((r11 instanceof String) == false) goto L29;
            r5.bindString(r10, (String) r11);
            return;
        L29:
            if ((r11 instanceof Boolean) == false) goto L37;
            if (((Boolean) r11).booleanValue() == false) goto L33;
            long r12 = 1;
        L34:
            r5.bindLong(r10, r12);
            return;
        L33:
            r12 = 0;
            goto L34
        L37:
            throw new IllegalArgumentException("Cannot bind " + r11 + " at index " + r10 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SimpleSQLiteQuery(String r5, Object[] r10) {
        Intrinsics.checkNotNullParameter(r5, "query");
        this.query = r5;
        this.bindArgs = r10;
    }

    @JvmStatic
    @SuppressLint({"SyntheticAccessor"})
    public static final void bind(SupportSQLiteProgram r5, Object[] r10) {
        Companion.bind(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r5) {
        Intrinsics.checkNotNullParameter(r5, "statement");
        Companion.bind(r5, this.bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] r5 = this.bindArgs;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.query;
    }

    public SimpleSQLiteQuery(String r5) {
        Intrinsics.checkNotNullParameter(r5, "query");
        this(r5, null);
    }
}
