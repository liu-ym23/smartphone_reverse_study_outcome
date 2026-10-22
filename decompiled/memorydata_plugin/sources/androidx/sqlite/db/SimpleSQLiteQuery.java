package androidx.sqlite.db;

import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", ChatMessage.TYPE_QUERY, "", "(Ljava/lang/String;)V", "bindArgs", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "argCount", "", "getArgCount", "()I", "[Ljava/lang/Object;", "sql", "getSql", "()Ljava/lang/String;", "bindTo", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public static final Companion Companion = null;
    private final Object[] bindArgs;
    private final String query;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery$Companion;", "", "()V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "bindArgs", "", "(Landroidx/sqlite/db/SupportSQLiteProgram;[Ljava/lang/Object;)V", "index", "", "arg", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final void bind(SupportSQLiteProgram r3, int r4, Object r5) {
            SupportSQLiteProgram r2 = (SupportSQLiteProgram) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteProgram.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L6;
            r2.bindNull(r4);
            return;
        L6:
            if ((r5 instanceof byte[]) == false) goto L9;
            r2.bindBlob(r4, (byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin"));
            return;
        L9:
            if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L13;
            double r0 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).floatValue();
        L11:
            r2.bindDouble(r4, r0);
            return;
        L13:
            if (ZeusTransformUtils.instanceOf(r5, Double.class) == false) goto L16;
            r0 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).doubleValue();
            goto L11
        L16:
            if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L20;
            long r1 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue();
        L18:
            r2.bindLong(r4, r1);
            return;
        L20:
            if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L24;
            int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        L22:
            r1 = r6;
            goto L18
        L24:
            if (ZeusTransformUtils.instanceOf(r5, Short.class) == false) goto L27;
            r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).shortValue();
            goto L22
        L27:
            if (ZeusTransformUtils.instanceOf(r5, Byte.class) == false) goto L30;
            r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).byteValue();
            goto L22
        L30:
            if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L33;
            r2.bindString(r4, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));
            return;
        L33:
            if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L40;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L37;
            r1 = 1;
            goto L18
        L37:
            r1 = 0;
            goto L18
        L40:
            throw new IllegalArgumentException("Cannot bind " + r5 + " at index " + r4 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        @JvmStatic
        public final void bind(SupportSQLiteProgram r4, Object[] r5) {
            SupportSQLiteProgram r6 = (SupportSQLiteProgram) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteProgram.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "statement");
            if (r5 != null) goto L5;
            return;
        L5:
            int r0 = r5.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L8;
            Object r2 = r5[r1];
            r1 = r1 + 1;
            bind(r6, r1, r2);
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SimpleSQLiteQuery(String r2) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        this(r2, null);
    }

    public SimpleSQLiteQuery(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        this.query = r2;
        this.bindArgs = r3;
    }

    @JvmStatic
    public static final void bind(SupportSQLiteProgram r2, Object[] r3) {
        SupportSQLiteProgram r4 = (SupportSQLiteProgram) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteProgram.class, "com.obric.memorydata.plugin");
        Companion.bind(r4, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r3) {
        SupportSQLiteProgram r4 = (SupportSQLiteProgram) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteProgram.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "statement");
        Companion.bind(r4, this.bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] r0 = this.bindArgs;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.query;
    }
}
