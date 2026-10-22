package androidx.sqlite.db;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00002\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\n\u001a\u00020\u0000J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J)\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002J%\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0002\u0010\u001cR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "", "table", "", "(Ljava/lang/String;)V", "bindArgs", "", "[Ljava/lang/Object;", "columns", "[Ljava/lang/String;", "distinct", "", "groupBy", "having", "limit", "orderBy", "selection", "([Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "create", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "appendClause", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "clause", "appendColumns", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)V", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder$Companion;", "", "()V", "limitPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "builder", "Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "tableName", "", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final SupportSQLiteQueryBuilder builder(String r5) {
            Intrinsics.checkNotNullParameter(r5, "tableName");
            return new SupportSQLiteQueryBuilder(r5, null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    private final void appendClause(StringBuilder r5, String r10, String r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.length() == 0) goto L9;
        r5.append(r10);
        r5.append(r11);
        return;
    }

    private final void appendColumns(StringBuilder r5, String[] r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        String r13 = r10[r12];
        if (r12 <= 0) goto L7;
        r5.append(", ");
    L7:
        r5.append(r13);
        r12 = r12 + 1;
        goto L3
    L8:
        r5.append(' ');
    }

    @JvmStatic
    public static final SupportSQLiteQueryBuilder builder(String r5) {
        return Companion.builder(r5);
    }

    public final SupportSQLiteQueryBuilder columns(String[] r5) {
        this.columns = r5;
        return this;
    }

    public final SupportSQLiteQuery create() {
        String r5 = this.groupBy;
        if (r5 != null) goto L5;
    L6:
        String r10 = this.having;
        if (r10 != null) goto L9;
    L13:
        StringBuilder r11 = a.x(120, "SELECT ");
        if (this.distinct == false) goto L16;
        r11.append("DISTINCT ");
    L16:
        String[] r12 = this.columns;
        if (r12 != null) goto L19;
    L22:
        r11.append("* ");
    L23:
        r11.append("FROM ");
        r11.append(this.table);
        appendClause(r11, " WHERE ", this.selection);
        appendClause(r11, " GROUP BY ", this.groupBy);
        appendClause(r11, " HAVING ", this.having);
        appendClause(r11, " ORDER BY ", this.orderBy);
        appendClause(r11, " LIMIT ", this.limit);
        return new SimpleSQLiteQuery(r11.toString(), this.bindArgs);
    L19:
        if (r12.length == 0) goto L22;
        Intrinsics.checkNotNull(r12);
        appendColumns(r11, r12);
        goto L23
    L9:
        if (r10.length() == 0) goto L13;
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    L5:
        if (r5.length() != 0) goto L13;
        goto L6
    }

    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String r5) {
        this.groupBy = r5;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String r5) {
        this.having = r5;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String r5) {
        Intrinsics.checkNotNullParameter(r5, "limit");
        boolean r10 = limitPattern.matcher(r5).matches();
        if (r5.length() == 0) goto L6;
        if (r10 == true) goto L6;
        throw new IllegalArgumentException(j0.C("invalid LIMIT clauses:", r5).toString());
    L6:
        this.limit = r5;
        return this;
    }

    public final SupportSQLiteQueryBuilder orderBy(String r5) {
        this.orderBy = r5;
        return this;
    }

    public final SupportSQLiteQueryBuilder selection(String r5, Object[] r10) {
        this.selection = r5;
        this.bindArgs = r10;
        return this;
    }

    private SupportSQLiteQueryBuilder(String r5) {
        this.table = r5;
    }
}
