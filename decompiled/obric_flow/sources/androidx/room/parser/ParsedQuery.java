package androidx.room.parser;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.verifier.QueryResultInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 D2\u00020\u0001:\u0001DBI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\u000fJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J^\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002R&\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u0011¢\u0006\u0002\b\u00120\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b!\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R+\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b-\u0010.R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006E"}, d2 = {"Landroidx/room/parser/ParsedQuery;", "", "original", "", "type", "Landroidx/room/parser/QueryType;", "inputs", "", "Landroidx/room/parser/BindParameterNode;", "tables", "", "Landroidx/room/parser/Table;", "hasTopStarProjection", "", "syntaxErrors", "(Ljava/lang/String;Landroidx/room/parser/QueryType;Ljava/util/List;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/List;)V", "bindSections", "Landroidx/room/parser/Section$BindVar;", "Lkotlin/internal/NoInfer;", "getBindSections", "()Ljava/util/List;", "bindSections$delegate", "Lkotlin/Lazy;", "errors", "getErrors", "errors$delegate", "getHasTopStarProjection", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getInputs", "getOriginal", "()Ljava/lang/String;", "queryWithReplacedBindParams", "getQueryWithReplacedBindParams", "queryWithReplacedBindParams$delegate", "resultInfo", "Landroidx/room/verifier/QueryResultInfo;", "getResultInfo", "()Landroidx/room/verifier/QueryResultInfo;", "setResultInfo", "(Landroidx/room/verifier/QueryResultInfo;)V", "sections", "Ljava/util/ArrayList;", "Landroidx/room/parser/Section;", "Lkotlin/collections/ArrayList;", "getSections", "()Ljava/util/ArrayList;", "sections$delegate", "getSyntaxErrors", "getTables", "()Ljava/util/Set;", "getType", "()Landroidx/room/parser/QueryType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Landroidx/room/parser/QueryType;Ljava/util/List;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/List;)Landroidx/room/parser/ParsedQuery;", "equals", "other", "hashCode", "", "toString", "unknownQueryTypeErrors", "unnamedVariableErrors", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ParsedQuery {
    public static final Companion Companion = null;
    private static final ParsedQuery MISSING = null;
    private static final Regex STARTS_WITH_NUMBER = null;
    private final Lazy bindSections$delegate;
    private final Lazy errors$delegate;
    private final Boolean hasTopStarProjection;
    private final List<BindParameterNode> inputs;
    private final String original;
    private final Lazy queryWithReplacedBindParams$delegate;
    private QueryResultInfo resultInfo;
    private final Lazy sections$delegate;
    private final List<String> syntaxErrors;
    private final Set<Table> tables;
    private final QueryType type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/parser/ParsedQuery$Companion;", "", "()V", "MISSING", "Landroidx/room/parser/ParsedQuery;", "getMISSING", "()Landroidx/room/parser/ParsedQuery;", "STARTS_WITH_NUMBER", "Lkotlin/text/Regex;", "getSTARTS_WITH_NUMBER", "()Lkotlin/text/Regex;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final ParsedQuery getMISSING() {
            return ParsedQuery.access$getMISSING$cp();
        }

        public final Regex getSTARTS_WITH_NUMBER() {
            return ParsedQuery.access$getSTARTS_WITH_NUMBER$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        STARTS_WITH_NUMBER = new Regex("^\\?[0-9]");
        MISSING = new ParsedQuery("missing query", QueryType.UNKNOWN, CollectionsKt.emptyList(), SetsKt.emptySet(), null, CollectionsKt.emptyList());
    }

    public ParsedQuery(String r5, QueryType r10, List<BindParameterNode> r11, Set<Table> r12, Boolean r13, List<String> r14) {
        Intrinsics.checkNotNullParameter(r5, "original");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "inputs");
        Intrinsics.checkNotNullParameter(r12, "tables");
        Intrinsics.checkNotNullParameter(r14, "syntaxErrors");
        this.original = r5;
        this.type = r10;
        this.inputs = r11;
        this.tables = r12;
        this.hasTopStarProjection = r13;
        this.syntaxErrors = r14;
        this.sections$delegate = LazyKt.lazy(new ParsedQuery$sections$2(this));
        this.bindSections$delegate = LazyKt.lazy(new ParsedQuery$bindSections$2(this));
        this.errors$delegate = LazyKt.lazy(new ParsedQuery$errors$2(this));
        this.queryWithReplacedBindParams$delegate = LazyKt.lazy(new ParsedQuery$queryWithReplacedBindParams$2(this));
    }

    public static final /* synthetic */ ParsedQuery access$getMISSING$cp() {
        return MISSING;
    }

    public static final /* synthetic */ Regex access$getSTARTS_WITH_NUMBER$cp() {
        return STARTS_WITH_NUMBER;
    }

    public static final /* synthetic */ List access$unknownQueryTypeErrors(ParsedQuery r5) {
        return r5.unknownQueryTypeErrors();
    }

    public static final /* synthetic */ List access$unnamedVariableErrors(ParsedQuery r5) {
        return r5.unnamedVariableErrors();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParsedQuery copy$default(ParsedQuery r5, String r10, QueryType r11, List r12, Set r13, Boolean r14, List r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.original;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.type;
    L8:
        QueryType r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.inputs;
    L11:
        List r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.tables;
    L14:
        Set r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.hasTopStarProjection;
    L17:
        Boolean r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.syntaxErrors;
    L20:
        String r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    private final List<String> unknownQueryTypeErrors() {
        if (QueryType.Companion.getSUPPORTED().contains(this.type) == false) goto L6;
        return CollectionsKt.emptyList();
    L6:
        return CollectionsKt.listOf(ParserErrors.INSTANCE.invalidQueryType(this.type));
    }

    private final List<String> unnamedVariableErrors() {
        List<BindParameterNode> r5 = this.inputs;
        if (r5 != null) goto L5;
    L7:
        Iterator<T> r10 = r5.iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((BindParameterNode) r10.next()).getText(), "?") == false) goto L9;
        Collection r11 = CollectionsKt.arrayListOf(new String[]{ParserErrors.INSTANCE.getANONYMOUS_BIND_ARGUMENT()});
    L14:
        List<BindParameterNode> r12 = this.inputs;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        Object r15 = r14.next();
        String r16 = ((BindParameterNode) r15).getText();
        if (STARTS_WITH_NUMBER.matches(r16) == false) goto L16;
        r13.add(r15);
        goto L16
    L20:
        ArrayList r17 = new ArrayList(CollectionsKt.h(r13));
        Iterator r18 = r13.iterator();
    L22:
        if (r18.hasNext() == false) goto L25;
        BindParameterNode r19 = (BindParameterNode) r18.next();
        r17.add(ParserErrors.INSTANCE.cannotUseVariableIndices(r19.getText(), r19.getSymbol().getCharPositionInLine()));
        goto L22
    L25:
        return CollectionsKt.plus(r11, r17);
    L13:
        r11 = CollectionsKt.emptyList();
        goto L14
    L5:
        if (r5.isEmpty() == false) goto L7;
        goto L7
    }

    public final String component1() {
        return this.original;
    }

    public final QueryType component2() {
        return this.type;
    }

    public final List<BindParameterNode> component3() {
        return this.inputs;
    }

    public final Set<Table> component4() {
        return this.tables;
    }

    public final Boolean component5() {
        return this.hasTopStarProjection;
    }

    public final List<String> component6() {
        return this.syntaxErrors;
    }

    public final ParsedQuery copy(String r10, QueryType r11, List<BindParameterNode> r12, Set<Table> r13, Boolean r14, List<String> r15) {
        Intrinsics.checkNotNullParameter(r10, "original");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "inputs");
        Intrinsics.checkNotNullParameter(r13, "tables");
        Intrinsics.checkNotNullParameter(r15, "syntaxErrors");
        return new ParsedQuery(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ParsedQuery) == true) goto L8;
        return false;
    L8:
        ParsedQuery r10 = (ParsedQuery) r5;
        if (Intrinsics.areEqual(this.original, r10.original) == true) goto L12;
        return false;
    L12:
        if (this.type == r10.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputs, r10.inputs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tables, r10.tables) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hasTopStarProjection, r10.hasTopStarProjection) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.syntaxErrors, r10.syntaxErrors) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final List<Section.BindVar> getBindSections() {
        return (List) this.bindSections$delegate.getValue();
    }

    public final List<String> getErrors() {
        return (List) this.errors$delegate.getValue();
    }

    public final Boolean getHasTopStarProjection() {
        return this.hasTopStarProjection;
    }

    public final List<BindParameterNode> getInputs() {
        return this.inputs;
    }

    public final String getOriginal() {
        return this.original;
    }

    public final String getQueryWithReplacedBindParams() {
        return (String) this.queryWithReplacedBindParams$delegate.getValue();
    }

    public final QueryResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final ArrayList<Section> getSections() {
        return (ArrayList) this.sections$delegate.getValue();
    }

    public final List<String> getSyntaxErrors() {
        return this.syntaxErrors;
    }

    public final Set<Table> getTables() {
        return this.tables;
    }

    public final QueryType getType() {
        return this.type;
    }

    public int hashCode() {
        int r5 = this.original.hashCode() * 31;
        int r10 = (this.type.hashCode() + r5) * 31;
        int r11 = a.f(this.inputs, r10, 31);
        int r12 = (this.tables.hashCode() + r11) * 31;
        Boolean r13 = this.hasTopStarProjection;
        if (r13 != null) goto L5;
        int r14 = 0;
    L6:
        int r15 = this.syntaxErrors.hashCode();
        return r15 + ((r12 + r14) * 31);
    L5:
        r14 = r13.hashCode();
        goto L6
    }

    public final void setResultInfo(QueryResultInfo r5) {
        this.resultInfo = r5;
    }

    public String toString() {
        return "ParsedQuery(original=" + this.original + ", type=" + this.type + ", inputs=" + this.inputs + ", tables=" + this.tables + ", hasTopStarProjection=" + this.hasTopStarProjection + ", syntaxErrors=" + this.syntaxErrors + ")";
    }
}
