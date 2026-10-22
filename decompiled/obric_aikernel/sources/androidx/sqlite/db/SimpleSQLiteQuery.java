package androidx.sqlite.db;

import android.annotation.SuppressLint;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public static final Companion Companion = null;
    private final Object[] bindArgs;
    private final String query;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final void bind(SupportSQLiteProgram r10, int r11, Object r12) {
            if (r12 != null) goto L5;
            r10.bindNull(r11);
            return;
        L5:
            if ((r12 instanceof byte[]) == false) goto L8;
            r10.bindBlob(r11, (byte[]) r12);
            return;
        L8:
            if ((r12 instanceof Float) == false) goto L12;
            double r13 = ((Number) r12).floatValue();
        L10:
            r10.bindDouble(r11, r13);
            return;
        L12:
            if ((r12 instanceof Double) == false) goto L15;
            r13 = ((Number) r12).doubleValue();
            goto L10
        L15:
            if ((r12 instanceof Long) == false) goto L19;
            long r14 = ((Number) r12).longValue();
        L17:
            r10.bindLong(r11, r14);
            return;
        L19:
            if ((r12 instanceof Integer) == false) goto L23;
            int r15 = ((Number) r12).intValue();
        L21:
            r14 = r15;
            goto L17
        L23:
            if ((r12 instanceof Short) == false) goto L26;
            r15 = ((Number) r12).shortValue();
            goto L21
        L26:
            if ((r12 instanceof Byte) == false) goto L29;
            r15 = ((Number) r12).byteValue();
            goto L21
        L29:
            if ((r12 instanceof String) == false) goto L32;
            r10.bindString(r11, (String) r12);
            return;
        L32:
            if ((r12 instanceof Boolean) == false) goto L39;
            if (((Boolean) r12).booleanValue() == false) goto L36;
            r14 = 1;
            goto L17
        L36:
            r14 = 0;
            goto L17
        L39:
            throw new IllegalArgumentException("Cannot bind " + r12 + " at index " + r11 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        @JvmStatic
        @SuppressLint({"SyntheticAccessor"})
        public final void bind(SupportSQLiteProgram r10, Object[] r11) {
            Intrinsics.checkNotNullParameter(r10, "statement");
            if (r11 != null) goto L5;
            return;
        L5:
            int r12 = r11.length;
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L8;
            Object r14 = r11[r13];
            r13 = r13 + 1;
            bind(r10, r13, r14);
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SimpleSQLiteQuery(String r10) {
        Intrinsics.checkNotNullParameter(r10, "query");
        this(r10, null);
    }

    public SimpleSQLiteQuery(String r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "query");
        this.query = r10;
        this.bindArgs = r11;
    }

    @JvmStatic
    @SuppressLint({"SyntheticAccessor"})
    public static final void bind(SupportSQLiteProgram r10, Object[] r11) {
        Companion.bind(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r10) {
        Intrinsics.checkNotNullParameter(r10, "statement");
        Companion.bind(r10, this.bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] r10 = this.bindArgs;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.query;
    }
}
