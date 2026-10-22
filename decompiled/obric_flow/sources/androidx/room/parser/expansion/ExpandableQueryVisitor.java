package androidx.room.parser.expansion;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import androidx.room.parser.QueryType;
import androidx.room.parser.SQLiteBaseVisitor;
import androidx.room.parser.SQLiteParser;
import androidx.room.parser.Table;
import com.bytedance.ai.event.MessageIndication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001&B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020!H\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020%H\u0016R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/room/parser/expansion/ExpandableQueryVisitor;", "Landroidx/room/parser/SQLiteBaseVisitor;", "Ljava/lang/Void;", "original", "", "syntaxErrors", "", "statement", "Landroidx/room/jarjarred/org/antlr/v4/runtime/tree/ParseTree;", "forRuntimeQuery", "", "(Ljava/lang/String;Ljava/util/List;Lorg/antlr/v4/runtime/tree/ParseTree;Z)V", "bindingExpressions", "Ljava/util/ArrayList;", "Landroidx/room/parser/expansion/SectionInfo;", "Lkotlin/collections/ArrayList;", "explicitColumns", "queryType", "Landroidx/room/parser/QueryType;", "resultColumns", "tableNames", "", "Landroidx/room/parser/Table;", "withClauseNames", "createParsedQuery", "Landroidx/room/parser/expansion/ExpandableParsedQuery;", "findQueryType", "unescapeIdentifier", MessageIndication.CONTENT_TYPE_TEXT, "visitCommon_table_expression", "ctx", "Landroidx/room/parser/SQLiteParser$Common_table_expressionContext;", "visitExpr", "Landroidx/room/parser/SQLiteParser$ExprContext;", "visitResult_column", "Landroidx/room/parser/SQLiteParser$Result_columnContext;", "visitTable_or_subquery", "Landroidx/room/parser/SQLiteParser$Table_or_subqueryContext;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpandableQueryVisitor extends SQLiteBaseVisitor<Void> {
    public static final Companion Companion = null;
    private static final List<String> ESCAPE_LITERALS = null;
    private final ArrayList<SectionInfo> bindingExpressions;
    private final ArrayList<String> explicitColumns;
    private final boolean forRuntimeQuery;
    private final String original;
    private final QueryType queryType;
    private final ArrayList<SectionInfo> resultColumns;
    private final List<String> syntaxErrors;
    private final Set<Table> tableNames;
    private final Set<String> withClauseNames;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/room/parser/expansion/ExpandableQueryVisitor$Companion;", "", "()V", "ESCAPE_LITERALS", "", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        ESCAPE_LITERALS = CollectionsKt.listOf(new String[]{"\"", "'", "`"});
    }

    public ExpandableQueryVisitor(String r5, List<String> r10, ParseTree r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "original");
        Intrinsics.checkNotNullParameter(r10, "syntaxErrors");
        Intrinsics.checkNotNullParameter(r11, "statement");
        this.original = r5;
        this.syntaxErrors = r10;
        this.forRuntimeQuery = r12;
        this.resultColumns = new ArrayList();
        this.explicitColumns = new ArrayList();
        this.bindingExpressions = new ArrayList();
        this.tableNames = new LinkedHashSet();
        this.withClauseNames = new LinkedHashSet();
        IntRange r13 = RangesKt.until(0, r11.getChildCount());
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<Integer> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r14.add(findQueryType(r11.getChild(((IntIterator) r15).nextInt())));
        goto L4
    L6:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r14.iterator();
    L8:
        if (r17.hasNext() == false) goto L13;
        Object r18 = r17.next();
        if (((QueryType) r18) == QueryType.UNKNOWN) goto L8;
        r16.add(r18);
        goto L8
    L13:
        QueryType r19 = (QueryType) CollectionsKt.firstOrNull(r16);
        if (r19 != null) goto L16;
        r19 = QueryType.UNKNOWN;
    L16:
        this.queryType = r19;
        r11.accept(this);
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

    private static final void visitResult_column$addProjectionSection(ExpandableQueryVisitor r5, SQLiteParser.Result_columnContext r10, ExpandableSection.Projection r11) {
        r5.resultColumns.add(new SectionInfo(new Position(r10.start.getLine() - 1, r10.start.getCharPositionInLine()), new Position(r10.stop.getLine() - 1, r10.stop.getText().length() + r10.stop.getCharPositionInLine()), r11));
    }

    public final ExpandableParsedQuery createParsedQuery() {
        String r5 = this.original;
        QueryType r10 = this.queryType;
        List r11 = CollectionsKt.toList(this.resultColumns);
        List r12 = CollectionsKt.toList(this.explicitColumns);
        return new ExpandableParsedQuery(r5, r10, CollectionsKt.toList(this.bindingExpressions), r11, r12, this.tableNames, this.syntaxErrors, this.forRuntimeQuery);
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
    public Void visitExpr(SQLiteParser.ExprContext r10) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        TerminalNode r5 = r10.BIND_PARAMETER();
        if (r5 == null) goto L6;
        this.bindingExpressions.add(new SectionInfo(new Position(r5.getSymbol().getLine() - 1, r5.getSymbol().getCharPositionInLine()), new Position(r5.getSymbol().getLine() - 1, r5.getText().length() + r5.getSymbol().getCharPositionInLine()), new ExpandableSection.BindVar(r5.getText())));
    L6:
        return (Void) super.visitExpr(r10);
    }

    @Override // androidx.room.parser.SQLiteBaseVisitor, androidx.room.parser.SQLiteVisitor
    public Void visitResult_column(SQLiteParser.Result_columnContext r10) {
        if (r10 == null) goto L17;
        if (ExpandableSqlParserKt.isCoreSelect(r10.parent) == false) goto L17;
        if (Intrinsics.areEqual(r10.getText(), XPath.WILDCARD) == false) goto L10;
        visitResult_column$addProjectionSection(this, r10, ExpandableSection.Projection.All.INSTANCE);
        goto L17
    L10:
        if (r10.table_name() == null) goto L13;
        visitResult_column$addProjectionSection(this, r10, new ExpandableSection.Projection.Table(StringsKt.trim(r10.table_name().getText(), new char[]{'`'}), this.original.substring(r10.start.getStartIndex(), r10.stop.getStopIndex() + 1)));
        goto L17
    L13:
        if (r10.column_alias() == null) goto L15;
        this.explicitColumns.add(StringsKt.trim(r10.column_alias().getText(), new char[]{'`'}));
        goto L17
    L15:
        this.explicitColumns.add(StringsKt.trim(r10.getText(), new char[]{'`'}));
    L17:
        return (Void) super.visitResult_column(r10);
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
