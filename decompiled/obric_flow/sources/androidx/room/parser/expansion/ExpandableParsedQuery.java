package androidx.room.parser.expansion;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.parser.ParserErrors;
import androidx.room.parser.QueryType;
import androidx.room.parser.Table;
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
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 H2\u00020\u0001:\u0001HBc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0010HÆ\u0003Jw\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010A\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002R&\u0010\u0012\u001a\r\u0012\t\u0012\u00070\u0013¢\u0006\u0002\b\u00140\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R+\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b-\u0010.R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001e\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006I"}, d2 = {"Landroidx/room/parser/expansion/ExpandableParsedQuery;", "", "original", "", "type", "Landroidx/room/parser/QueryType;", "inputs", "", "Landroidx/room/parser/expansion/SectionInfo;", "projections", "explicitColumns", "tables", "", "Landroidx/room/parser/Table;", "syntaxErrors", "runtimeQueryPlaceholder", "", "(Ljava/lang/String;Landroidx/room/parser/QueryType;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Set;Ljava/util/List;Z)V", "bindSections", "Landroidx/room/parser/expansion/ExpandableSection$BindVar;", "Lkotlin/internal/NoInfer;", "getBindSections", "()Ljava/util/List;", "bindSections$delegate", "Lkotlin/Lazy;", "errors", "getErrors", "errors$delegate", "getExplicitColumns", "getInputs", "getOriginal", "()Ljava/lang/String;", "getProjections", "resultInfo", "Landroidx/room/verifier/QueryResultInfo;", "getResultInfo", "()Landroidx/room/verifier/QueryResultInfo;", "setResultInfo", "(Landroidx/room/verifier/QueryResultInfo;)V", "getRuntimeQueryPlaceholder", "()Z", "sections", "Ljava/util/ArrayList;", "Landroidx/room/parser/expansion/ExpandableSection;", "Lkotlin/collections/ArrayList;", "getSections", "()Ljava/util/ArrayList;", "sections$delegate", "getSyntaxErrors", "getTables", "()Ljava/util/Set;", "<set-?>", "transformed", "getTransformed", "getType", "()Landroidx/room/parser/QueryType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "unknownQueryTypeErrors", "unnamedVariableErrors", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpandableParsedQuery {
    public static final Companion Companion = null;
    private static final ExpandableParsedQuery MISSING = null;
    private static final Regex STARTS_WITH_NUMBER = null;
    private final Lazy bindSections$delegate;
    private final Lazy errors$delegate;
    private final List<String> explicitColumns;
    private final List<SectionInfo> inputs;
    private final String original;
    private final List<SectionInfo> projections;
    private QueryResultInfo resultInfo;
    private final boolean runtimeQueryPlaceholder;
    private final Lazy sections$delegate;
    private final List<String> syntaxErrors;
    private final Set<Table> tables;
    private String transformed;
    private final QueryType type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/parser/expansion/ExpandableParsedQuery$Companion;", "", "()V", "MISSING", "Landroidx/room/parser/expansion/ExpandableParsedQuery;", "getMISSING", "()Landroidx/room/parser/expansion/ExpandableParsedQuery;", "STARTS_WITH_NUMBER", "Lkotlin/text/Regex;", "getSTARTS_WITH_NUMBER", "()Lkotlin/text/Regex;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final ExpandableParsedQuery getMISSING() {
            return ExpandableParsedQuery.access$getMISSING$cp();
        }

        public final Regex getSTARTS_WITH_NUMBER() {
            return ExpandableParsedQuery.access$getSTARTS_WITH_NUMBER$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        STARTS_WITH_NUMBER = new Regex("^\\?[0-9]");
        QueryType r5 = QueryType.UNKNOWN;
        List r10 = CollectionsKt.emptyList();
        List r11 = CollectionsKt.emptyList();
        MISSING = new ExpandableParsedQuery("missing query", r5, CollectionsKt.emptyList(), r10, r11, SetsKt.emptySet(), CollectionsKt.emptyList(), false);
    }

    public ExpandableParsedQuery(String r5, QueryType r10, List<SectionInfo> r11, List<SectionInfo> r12, List<String> r13, Set<Table> r14, List<String> r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r5, "original");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "inputs");
        Intrinsics.checkNotNullParameter(r12, "projections");
        Intrinsics.checkNotNullParameter(r13, "explicitColumns");
        Intrinsics.checkNotNullParameter(r14, "tables");
        Intrinsics.checkNotNullParameter(r15, "syntaxErrors");
        this.original = r5;
        this.type = r10;
        this.inputs = r11;
        this.projections = r12;
        this.explicitColumns = r13;
        this.tables = r14;
        this.syntaxErrors = r15;
        this.runtimeQueryPlaceholder = r16;
        this.transformed = r5;
        this.sections$delegate = LazyKt.lazy(new ExpandableParsedQuery$sections$2(this));
        this.bindSections$delegate = LazyKt.lazy(new ExpandableParsedQuery$bindSections$2(this));
        this.errors$delegate = LazyKt.lazy(new ExpandableParsedQuery$errors$2(this));
    }

    public static final /* synthetic */ ExpandableParsedQuery access$getMISSING$cp() {
        return MISSING;
    }

    public static final /* synthetic */ Regex access$getSTARTS_WITH_NUMBER$cp() {
        return STARTS_WITH_NUMBER;
    }

    public static final /* synthetic */ List access$unknownQueryTypeErrors(ExpandableParsedQuery r5) {
        return r5.unknownQueryTypeErrors();
    }

    public static final /* synthetic */ List access$unnamedVariableErrors(ExpandableParsedQuery r5) {
        return r5.unnamedVariableErrors();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExpandableParsedQuery copy$default(ExpandableParsedQuery r10, String r11, QueryType r12, List r13, List r14, List r15, Set r16, List r17, boolean r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r5 = r10.original;
    L7:
        if ((r19 & 2) == 0) goto L9;
        QueryType r20 = r10.type;
    L11:
        if ((r19 & 4) == 0) goto L13;
        List r21 = r10.inputs;
    L15:
        if ((r19 & 8) == 0) goto L17;
        List r22 = r10.projections;
    L19:
        if ((r19 & 16) == 0) goto L21;
        List r23 = r10.explicitColumns;
    L23:
        if ((r19 & 32) == 0) goto L25;
        Set r24 = r10.tables;
    L27:
        if ((r19 & 64) == 0) goto L29;
        List r25 = r10.syntaxErrors;
    L31:
        if ((r19 & 128) == 0) goto L33;
        boolean r26 = r10.runtimeQueryPlaceholder;
    L35:
        return r10.copy(r5, r20, r21, r22, r23, r24, r25, r26);
    L33:
        r26 = r18;
        goto L35
    L29:
        r25 = r17;
        goto L31
    L25:
        r24 = r16;
        goto L27
    L21:
        r23 = r15;
        goto L23
    L17:
        r22 = r14;
        goto L19
    L13:
        r21 = r13;
        goto L15
    L9:
        r20 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    private final List<String> unknownQueryTypeErrors() {
        if (QueryType.Companion.getSUPPORTED().contains(this.type) == false) goto L6;
        return CollectionsKt.emptyList();
    L6:
        return CollectionsKt.listOf(ParserErrors.INSTANCE.invalidQueryType(this.type));
    }

    private final List<String> unnamedVariableErrors() {
        List<SectionInfo> r5 = this.inputs;
        if (r5 != null) goto L5;
    L7:
        Iterator<T> r10 = r5.iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((SectionInfo) r10.next()).getSection().getText(), "?") == false) goto L9;
        Collection r11 = CollectionsKt.arrayListOf(new String[]{ParserErrors.INSTANCE.getANONYMOUS_BIND_ARGUMENT()});
    L14:
        List<SectionInfo> r12 = this.inputs;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        Object r15 = r14.next();
        String r16 = ((SectionInfo) r15).getSection().getText();
        if (STARTS_WITH_NUMBER.matches(r16) == false) goto L16;
        r13.add(r15);
        goto L16
    L20:
        ArrayList r17 = new ArrayList(CollectionsKt.h(r13));
        Iterator r18 = r13.iterator();
    L22:
        if (r18.hasNext() == false) goto L25;
        SectionInfo r19 = (SectionInfo) r18.next();
        r17.add(ParserErrors.INSTANCE.cannotUseVariableIndices(r19.getSection().getText(), r19.getStart().getCharInLine()));
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

    public final List<SectionInfo> component3() {
        return this.inputs;
    }

    public final List<SectionInfo> component4() {
        return this.projections;
    }

    public final List<String> component5() {
        return this.explicitColumns;
    }

    public final Set<Table> component6() {
        return this.tables;
    }

    public final List<String> component7() {
        return this.syntaxErrors;
    }

    public final boolean component8() {
        return this.runtimeQueryPlaceholder;
    }

    public final ExpandableParsedQuery copy(String r11, QueryType r12, List<SectionInfo> r13, List<SectionInfo> r14, List<String> r15, Set<Table> r16, List<String> r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "original");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "inputs");
        Intrinsics.checkNotNullParameter(r14, "projections");
        Intrinsics.checkNotNullParameter(r15, "explicitColumns");
        Intrinsics.checkNotNullParameter(r16, "tables");
        Intrinsics.checkNotNullParameter(r17, "syntaxErrors");
        return new ExpandableParsedQuery(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ExpandableParsedQuery) == true) goto L8;
        return false;
    L8:
        ExpandableParsedQuery r10 = (ExpandableParsedQuery) r5;
        if (Intrinsics.areEqual(this.original, r10.original) == true) goto L12;
        return false;
    L12:
        if (this.type == r10.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputs, r10.inputs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.projections, r10.projections) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.explicitColumns, r10.explicitColumns) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tables, r10.tables) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.syntaxErrors, r10.syntaxErrors) == true) goto L30;
        return false;
    L30:
        if (this.runtimeQueryPlaceholder == r10.runtimeQueryPlaceholder) goto L32;
        return false;
    L32:
        return true;
    }

    public final List<ExpandableSection.BindVar> getBindSections() {
        return (List) this.bindSections$delegate.getValue();
    }

    public final List<String> getErrors() {
        return (List) this.errors$delegate.getValue();
    }

    public final List<String> getExplicitColumns() {
        return this.explicitColumns;
    }

    public final List<SectionInfo> getInputs() {
        return this.inputs;
    }

    public final String getOriginal() {
        return this.original;
    }

    public final List<SectionInfo> getProjections() {
        return this.projections;
    }

    public final QueryResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final boolean getRuntimeQueryPlaceholder() {
        return this.runtimeQueryPlaceholder;
    }

    public final ArrayList<ExpandableSection> getSections() {
        return (ArrayList) this.sections$delegate.getValue();
    }

    public final List<String> getSyntaxErrors() {
        return this.syntaxErrors;
    }

    public final Set<Table> getTables() {
        return this.tables;
    }

    public final String getTransformed() {
        return this.transformed;
    }

    public final QueryType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r5 = this.original.hashCode() * 31;
        int r10 = (this.type.hashCode() + r5) * 31;
        int r11 = a.f(this.inputs, r10, 31);
        int r12 = a.f(this.projections, r11, 31);
        int r13 = a.f(this.explicitColumns, r12, 31);
        int r14 = (this.tables.hashCode() + r13) * 31;
        int r15 = a.f(this.syntaxErrors, r14, 31);
        boolean r16 = this.runtimeQueryPlaceholder;
        ?? r17 = r16;
        if (r16 == false) goto L6;
        r17 = 1;
    L6:
        return r15 + r17;
    }

    public final void setResultInfo(QueryResultInfo r5) {
        this.resultInfo = r5;
    }

    public String toString() {
        return "ExpandableParsedQuery(original=" + this.original + ", type=" + this.type + ", inputs=" + this.inputs + ", projections=" + this.projections + ", explicitColumns=" + this.explicitColumns + ", tables=" + this.tables + ", syntaxErrors=" + this.syntaxErrors + ", runtimeQueryPlaceholder=" + this.runtimeQueryPlaceholder + ")";
    }
}
