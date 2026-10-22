package androidx.sqlite.db;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00002\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\n\u001a\u00020\u0000J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J)\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002J%\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0002\u0010\u001cR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "", "table", "", "(Ljava/lang/String;)V", "bindArgs", "", "[Ljava/lang/Object;", "columns", "[Ljava/lang/String;", "distinct", "", "groupBy", "having", "limit", "orderBy", "selection", "([Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "create", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "appendClause", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "clause", "appendColumns", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)V", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SupportSQLiteQueryBuilder {
    public static final Companion Companion = null;
    private static final Pattern limitPattern = null;
    private Object[] bindArgs;
    private String[] columns;
    private boolean distinct;
    private String groupBy;
    private String having;
    private String limit;
    private String orderBy;
    private String selection;
    private final String table;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder$Companion;", "", "()V", "limitPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "builder", "Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "tableName", "", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final SupportSQLiteQueryBuilder builder(String r3) {
            Intrinsics.checkNotNullParameter(r3, "tableName");
            return new SupportSQLiteQueryBuilder(r3, null);
        }
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    public static final SupportSQLiteQueryBuilder builder(String r1) {
        return Companion.builder(r1);
    }

    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    static {
        Companion = new Companion(null);
        limitPattern = PatternProtector.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    public final SupportSQLiteQuery create() {
        String r0 = this.groupBy;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L20;
        String r3 = this.having;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L20;
        boolean r5 = false;
    L21:
        if (r5 == false) goto L39;
        StringBuilder r6 = new StringBuilder(120);
        r6.append("SELECT ");
        if (this.distinct == false) goto L25;
        r6.append("DISTINCT ");
    L25:
        String[] r7 = this.columns;
        if (r7 != null) goto L28;
    L32:
        r1 = true;
    L33:
        if (r1 == true) goto L35;
        Intrinsics.checkNotNull(r7);
        appendColumns(r6, r7);
    L36:
        r6.append("FROM ");
        r6.append(this.table);
        appendClause(r6, " WHERE ", this.selection);
        appendClause(r6, " GROUP BY ", this.groupBy);
        appendClause(r6, " HAVING ", this.having);
        appendClause(r6, " ORDER BY ", this.orderBy);
        appendClause(r6, " LIMIT ", this.limit);
        return new SimpleSQLiteQuery(r6.toString(), this.bindArgs);
    L35:
        r6.append("* ");
        goto L36
    L28:
        if (r7.length != 0) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == false) goto L33;
    L30:
        r8 = false;
        goto L31
    L39:
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause".toString());
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L20:
        r5 = true;
        goto L21
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private SupportSQLiteQueryBuilder(String r1) {
        this.table = r1;
    }

    public final SupportSQLiteQueryBuilder columns(String[] r1) {
        this.columns = r1;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String r1) {
        this.groupBy = r1;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String r1) {
        this.having = r1;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String r5) {
        Intrinsics.checkNotNullParameter(r5, "limit");
        boolean r0 = limitPattern.matcher(r5).matches();
        boolean r2 = true;
        if (r5.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L10;
        if (r0 == true) goto L10;
        r2 = false;
    L10:
        if (r2 == false) goto L14;
        this.limit = r5;
        return this;
    L14:
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + r5).toString());
    L5:
        r1 = false;
        goto L6
    }

    public final SupportSQLiteQueryBuilder orderBy(String r1) {
        this.orderBy = r1;
        return this;
    }

    private final void appendColumns(StringBuilder r5, String[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r6[r1];
        if (r1 <= 0) goto L7;
        r5.append(", ");
    L7:
        r5.append(r2);
        r1 = r1 + 1;
        goto L3
    L8:
        r5.append(' ');
    }

    public final SupportSQLiteQueryBuilder selection(String r1, Object[] r2) {
        this.selection = r1;
        this.bindArgs = r2;
        return this;
    }

    private final void appendClause(StringBuilder r2, String r3, String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r2.append(r3);
        r2.append(r4);
        return;
    L11:
        return;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
