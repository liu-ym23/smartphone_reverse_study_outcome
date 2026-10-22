package androidx.sqlite.db;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00002\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\n\u001a\u00020\u0000J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J)\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002J%\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0002\u0010\u001cR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "", "table", "", "(Ljava/lang/String;)V", "bindArgs", "", "[Ljava/lang/Object;", "columns", "[Ljava/lang/String;", "distinct", "", "groupBy", "having", "limit", "orderBy", "selection", "([Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "create", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "appendClause", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", ActivityLifecycle.NAME, "clause", "appendColumns", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)V", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final SupportSQLiteQueryBuilder builder(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tableName");
            return new SupportSQLiteQueryBuilder(r2, null);
        }
    }

    static {
        Companion = new Companion(null);
        limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    private SupportSQLiteQueryBuilder(String r1) {
        this.table = r1;
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private final void appendClause(StringBuilder r2, String r3, String r4) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        r2.append(r3);
        r2.append(r4);
        return;
    L12:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    private final void appendColumns(StringBuilder r4, String[] r5) {
        int r3 = r5.length;
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L8;
        String r1 = r5[r0];
        if (r0 <= 0) goto L7;
        r4.append(", ");
    L7:
        r4.append(r1);
        r0 = r0 + 1;
        goto L3
    L8:
        r4.append(' ');
    }

    @JvmStatic
    public static final SupportSQLiteQueryBuilder builder(String r1) {
        return Companion.builder(r1);
    }

    public final SupportSQLiteQueryBuilder columns(String[] r4) {
        ((SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin")).columns = r4;
        return (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
    }

    public final SupportSQLiteQuery create() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.groupBy, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L20;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(this.having, CharSequence.class, "com.obric.memorydata.plugin");
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
        String r8 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "StringBuilder(capacity).…builderAction).toString()");
        return (SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r8, this.bindArgs), SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
    L35:
        r6.append("* ");
        goto L36
    L28:
        if (r7.length != 0) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L33;
    L30:
        r9 = false;
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

    public final SupportSQLiteQueryBuilder distinct() {
        ((SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin")).distinct = true;
        return (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
    }

    public final SupportSQLiteQueryBuilder groupBy(String r4) {
        ((SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin")).groupBy = r4;
        return (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
    }

    public final SupportSQLiteQueryBuilder having(String r4) {
        ((SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin")).having = r4;
        return (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
    }

    public final SupportSQLiteQueryBuilder limit(String r8) {
        Intrinsics.checkNotNullParameter(r8, "limit");
        SupportSQLiteQueryBuilder r2 = (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
        boolean r3 = limitPattern.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).matches();
        boolean r5 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L10;
        if (r3 == true) goto L10;
        r5 = false;
    L10:
        if (r5 == false) goto L14;
        r2.limit = r8;
        return (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
    L14:
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + r8).toString());
    L5:
        r4 = false;
        goto L6
    }

    public final SupportSQLiteQueryBuilder orderBy(String r4) {
        ((SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin")).orderBy = r4;
        return (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
    }

    public final SupportSQLiteQueryBuilder selection(String r4, Object[] r5) {
        SupportSQLiteQueryBuilder r2 = (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
        r2.selection = r4;
        r2.bindArgs = r5;
        return (SupportSQLiteQueryBuilder) ZeusTransformUtils.preCheckCast(this, SupportSQLiteQueryBuilder.class, "com.obric.memorydata.plugin");
    }
}
