package androidx.sqlite.db;

import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
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

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final SupportSQLiteQueryBuilder builder(String r10) {
            Intrinsics.checkNotNullParameter(r10, "tableName");
            return new SupportSQLiteQueryBuilder(r10, null);
        }
    }

    static {
        Companion = new Companion(null);
        limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    private SupportSQLiteQueryBuilder(String r10) {
        this.table = r10;
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    private final void appendClause(StringBuilder r10, String r11, String r12) {
        if (r12 != null) goto L4;
    L7:
        boolean r13 = true;
    L8:
        if (r13 == true) goto L11;
        r10.append(r11);
        r10.append(r12);
        return;
    L11:
        return;
    L4:
        if (r12.length() == 0) goto L7;
        r13 = false;
        goto L8
    }

    private final void appendColumns(StringBuilder r10, String[] r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        String r14 = r11[r13];
        if (r13 <= 0) goto L7;
        r10.append(", ");
    L7:
        r10.append(r14);
        r13 = r13 + 1;
        goto L3
    L8:
        r10.append(' ');
    }

    @JvmStatic
    public static final SupportSQLiteQueryBuilder builder(String r10) {
        return Companion.builder(r10);
    }

    public final SupportSQLiteQueryBuilder columns(String[] r10) {
        this.columns = r10;
        return this;
    }

    public final SupportSQLiteQuery create() {
        String r10 = this.groupBy;
        boolean r11 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L20;
        String r13 = this.having;
        if (r13 != null) goto L13;
    L16:
        boolean r14 = true;
    L17:
        if (r14 == true) goto L20;
        boolean r15 = false;
    L21:
        if (r15 == false) goto L39;
        StringBuilder r16 = new StringBuilder(120);
        r16.append("SELECT ");
        if (this.distinct == false) goto L25;
        r16.append("DISTINCT ");
    L25:
        String[] r17 = this.columns;
        if (r17 != null) goto L28;
    L32:
        r11 = true;
    L33:
        if (r11 == true) goto L35;
        Intrinsics.checkNotNull(r17);
        appendColumns(r16, r17);
    L36:
        r16.append("FROM ");
        r16.append(this.table);
        appendClause(r16, " WHERE ", this.selection);
        appendClause(r16, " GROUP BY ", this.groupBy);
        appendClause(r16, " HAVING ", this.having);
        appendClause(r16, " ORDER BY ", this.orderBy);
        appendClause(r16, " LIMIT ", this.limit);
        String r18 = r16.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder(capacity).…builderAction).toString()");
        return new SimpleSQLiteQuery(r18, this.bindArgs);
    L35:
        r16.append("* ");
        goto L36
    L28:
        if (r17.length != 0) goto L30;
        boolean r19 = true;
    L31:
        if (r19 == false) goto L33;
    L30:
        r19 = false;
        goto L31
    L39:
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause".toString());
    L13:
        if (r13.length() == 0) goto L16;
        r14 = false;
    L20:
        r15 = true;
        goto L21
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String r10) {
        this.groupBy = r10;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String r10) {
        this.having = r10;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String r10) {
        Intrinsics.checkNotNullParameter(r10, "limit");
        boolean r11 = limitPattern.matcher(r10).matches();
        boolean r12 = true;
        if (r10.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L10;
        if (r11 == true) goto L10;
        r12 = false;
    L10:
        if (r12 == false) goto L14;
        this.limit = r10;
        return this;
    L14:
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + r10).toString());
    L5:
        r13 = false;
        goto L6
    }

    public final SupportSQLiteQueryBuilder orderBy(String r10) {
        this.orderBy = r10;
        return this;
    }

    public final SupportSQLiteQueryBuilder selection(String r10, Object[] r11) {
        this.selection = r10;
        this.bindArgs = r11;
        return this;
    }
}
