package androidx.room.parser;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import androidx.room.parser.expansion.ExpandableSqlParserKt;
import com.bytedance.ai.event.MessageIndication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001&B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020%H\u0016R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/room/parser/QueryVisitor;", "Landroidx/room/parser/SQLiteBaseVisitor;", "Ljava/lang/Void;", "original", "", "syntaxErrors", "", "statement", "Landroidx/room/jarjarred/org/antlr/v4/runtime/tree/ParseTree;", "(Ljava/lang/String;Ljava/util/List;Lorg/antlr/v4/runtime/tree/ParseTree;)V", "bindingExpressions", "Ljava/util/ArrayList;", "Landroidx/room/parser/BindParameterNode;", "Lkotlin/collections/ArrayList;", "foundTopLevelStarProjection", "", "queryType", "Landroidx/room/parser/QueryType;", "tableNames", "", "Landroidx/room/parser/Table;", "withClauseNames", "createParsedQuery", "Landroidx/room/parser/ParsedQuery;", "findQueryType", "isFixedParamFunctionExpr", "ctx", "Landroidx/room/parser/SQLiteParser$Comma_separated_exprContext;", "unescapeIdentifier", MessageIndication.CONTENT_TYPE_TEXT, "visitCommon_table_expression", "Landroidx/room/parser/SQLiteParser$Common_table_expressionContext;", "visitExpr", "Landroidx/room/parser/SQLiteParser$ExprContext;", "visitResult_column", "Landroidx/room/parser/SQLiteParser$Result_columnContext;", "visitTable_or_subquery", "Landroidx/room/parser/SQLiteParser$Table_or_subqueryContext;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryVisitor extends SQLiteBaseVisitor<Void> {
    public static final Companion Companion = null;
    private static final List<String> ESCAPE_LITERALS = null;
    private static final Set<String> fixedParamFunctions = null;
    private final ArrayList<BindParameterNode> bindingExpressions;
    private boolean foundTopLevelStarProjection;
    private final String original;
    private final QueryType queryType;
    private final List<String> syntaxErrors;
    private final Set<Table> tableNames;
    private final Set<String> withClauseNames;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/parser/QueryVisitor$Companion;", "", "()V", "ESCAPE_LITERALS", "", "", "fixedParamFunctions", "", "getFixedParamFunctions", "()Ljava/util/Set;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Set<String> getFixedParamFunctions() {
            return QueryVisitor.access$getFixedParamFunctions$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        ESCAPE_LITERALS = CollectionsKt.listOf(new String[]{"\"", "'", "`"});
        fixedParamFunctions = SetsKt.setOf(new String[]{"abs", "glob", "hex", "ifnull", "iif", "instr", "length", "like", "likelihood", "likely", "load_extension", "lower", "ltrim", "nullif", "quote", "randomblob", "replace", "round", "rtrim", "soundex", "sqlite_compileoption_get", "sqlite_compileoption_used", "sqlite_offset", "substr", "trim", "typeof", "unicode", "unlikely", "upper", "zeroblob"});
    }

    public QueryVisitor(String r5, List<String> r10, ParseTree r11) {
        Intrinsics.checkNotNullParameter(r5, "original");
        Intrinsics.checkNotNullParameter(r10, "syntaxErrors");
        Intrinsics.checkNotNullParameter(r11, "statement");
        this.original = r5;
        this.syntaxErrors = r10;
        this.bindingExpressions = new ArrayList();
        this.tableNames = new LinkedHashSet();
        this.withClauseNames = new LinkedHashSet();
        IntRange r12 = RangesKt.until(0, r11.getChildCount());
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<Integer> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(findQueryType(r11.getChild(((IntIterator) r14).nextInt())));
        goto L4
    L6:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L13;
        Object r17 = r16.next();
        if (((QueryType) r17) == QueryType.UNKNOWN) goto L8;
        r15.add(r17);
        goto L8
    L13:
        QueryType r18 = (QueryType) CollectionsKt.firstOrNull(r15);
        if (r18 != null) goto L16;
        r18 = QueryType.UNKNOWN;
    L16:
        this.queryType = r18;
        r11.accept(this);
    }

    public static final /* synthetic */ Set access$getFixedParamFunctions$cp() {
        return fixedParamFunctions;
    }

    private final QueryType findQueryType(ParseTree r5) {
        if ((r5 instanceof SQLiteParser.Select_stmtContext) == true) goto L28;
        boolean r10 = true;
        if ((r5 instanceof SQLiteParser.Delete_stmt_limitedContext) == false) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        return QueryType.DELETE;
    L12:
        if ((r5 instanceof SQLiteParser.Insert_stmtContext) == false) goto L15;
        return QueryType.INSERT;
    L15:
        if ((r5 instanceof SQLiteParser.Update_stmtContext) == true) goto L18;
        r10 = r5 instanceof SQLiteParser.Update_stmt_limitedContext;
    L18:
        if (r10 == false) goto L21;
        return QueryType.UPDATE;
    L21:
        if ((r5 instanceof TerminalNode) == false) goto L27;
        if (Intrinsics.areEqual(((TerminalNode) r5).getText(), "EXPLAIN") == false) goto L33;
        return QueryType.EXPLAIN;
    L33:
        return QueryType.UNKNOWN;
    L27:
        return QueryType.UNKNOWN;
    L8:
        r11 = r5 instanceof SQLiteParser.Delete_stmtContext;
        goto L9
    L28:
        return QueryType.SELECT;
    }

    private final boolean isFixedParamFunctionExpr(SQLiteParser.Comma_separated_exprContext r5) {
        RuleContext r10 = r5.parent;
        if ((r10 instanceof SQLiteParser.ExprContext) == false) goto L9;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.room.parser.SQLiteParser.ExprContext");
        SQLiteParser.Function_nameContext r11 = ((SQLiteParser.ExprContext) r10).function_name();
        if (r11 != null) goto L8;
        return false;
    L8:
        return fixedParamFunctions.contains(r11.getText().toLowerCase(Locale.US));
    L9:
        return false;
    }

    private final String unescapeIdentifier(String r5) {
        String r10 = StringsKt.trim(r5).toString();
        Iterator<T> r11 = ESCAPE_LITERALS.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        String r12 = (String) r11.next();
        if (StringsKt.P(r10, r12) == false) goto L4;
        if (StringsKt.k(r10, r12) == false) goto L4;
        return unescapeIdentifier(a.n(r10, 1, 1));
    L11:
        return r10;
    }

    public final ParsedQuery createParsedQuery() {
        String r5 = this.original;
        QueryType r10 = this.queryType;
        List r11 = CollectionsKt.sortedWith(this.bindingExpressions, new QueryVisitor$createParsedQuery$$inlined$sortedBy$1());
        Set<Table> r12 = this.tableNames;
        if (this.queryType != QueryType.SELECT) goto L6;
        Boolean r13 = Boolean.valueOf(this.foundTopLevelStarProjection);
    L5:
        Boolean r14 = r13;
        return new ParsedQuery(r5, r10, r11, r12, r14, this.syntaxErrors);
    L6:
        r13 = null;
        goto L5
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public /* bridge */ /* synthetic */ Object visitCommon_table_expression(SQLiteParser.Common_table_expressionContext r5) {
        return visitCommon_table_expression(r5);
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public /* bridge */ /* synthetic */ Object visitExpr(SQLiteParser.ExprContext r5) {
        return visitExpr(r5);
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public /* bridge */ /* synthetic */ Object visitResult_column(SQLiteParser.Result_columnContext r5) {
        return visitResult_column(r5);
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public /* bridge */ /* synthetic */ Object visitTable_or_subquery(SQLiteParser.Table_or_subqueryContext r5) {
        return visitTable_or_subquery(r5);
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public Void visitCommon_table_expression(SQLiteParser.Common_table_expressionContext r5) {
        Intrinsics.checkNotNullParameter(r5, "ctx");
        SQLiteParser.Table_nameContext r10 = r5.table_name();
        if (r10 == null) goto L5;
        String r11 = r10.getText();
    L6:
        if (r11 == null) goto L9;
        this.withClauseNames.add(unescapeIdentifier(r11));
    L9:
        return (Void) super.visitCommon_table_expression(r5);
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public Void visitExpr(SQLiteParser.ExprContext r5) {
        Intrinsics.checkNotNullParameter(r5, "ctx");
        TerminalNode r10 = r5.BIND_PARAMETER();
        if (r10 == null) goto L12;
        RuleContext r11 = r5.parent;
        if ((r11 instanceof SQLiteParser.Comma_separated_exprContext) == true) goto L7;
    L9:
        boolean r12 = false;
    L10:
        this.bindingExpressions.add(new BindParameterNode(r10, r12));
        goto L12
    L7:
        if (isFixedParamFunctionExpr((SQLiteParser.Comma_separated_exprContext) r11) == true) goto L9;
        r12 = true;
    L12:
        return (Void) super.visitExpr(r5);
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public Void visitResult_column(SQLiteParser.Result_columnContext r5) {
        Intrinsics.checkNotNullParameter(r5, "ctx");
        if (ExpandableSqlParserKt.isCoreSelect(r5.parent) == false) goto L7;
        if (Intrinsics.areEqual(r5.getText(), XPath.WILDCARD) == false) goto L7;
    L8:
        this.foundTopLevelStarProjection = true;
    L10:
        return (Void) super.visitResult_column(r5);
    L7:
        if (StringsKt.k(r5.getText(), ".*") == false) goto L10;
        goto L8
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public Void visitTable_or_subquery(SQLiteParser.Table_or_subqueryContext r10) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        SQLiteParser.Table_nameContext r5 = r10.table_name();
        String r11 = null;
        if (r5 == null) goto L5;
        String r12 = r5.getText();
    L6:
        if (r12 == null) goto L18;
        SQLiteParser.Table_aliasContext r13 = r10.table_alias();
        if (r13 == null) goto L11;
        r11 = r13.getText();
    L11:
        if (this.withClauseNames.contains(r12) == true) goto L18;
        Set<Table> r14 = this.tableNames;
        String r15 = unescapeIdentifier(r12);
        if (r11 == null) goto L16;
        r12 = r11;
    L16:
        r14.add(new Table(r15, unescapeIdentifier(r12)));
    L18:
        return (Void) super.visitTable_or_subquery(r10);
    L5:
        r12 = null;
        goto L6
    }
}
