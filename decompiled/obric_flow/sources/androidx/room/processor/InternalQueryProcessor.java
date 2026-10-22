package androidx.room.processor;

import androidx.room.MapInfo;
import androidx.room.SkipQueryVerification;
import androidx.room.Transaction;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Xtype_extKt;
import androidx.room.log.RLog;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.QueryType;
import androidx.room.parser.Section;
import androidx.room.parser.SqlParser;
import androidx.room.parser.Table;
import androidx.room.preconditions.Checks;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import androidx.room.solver.query.result.PojoRowAdapter;
import androidx.room.solver.query.result.QueryMappedRowAdapter;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.query.result.RowAdapter;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.DatabaseVerificationErrors;
import androidx.room.verifier.DatabaseVerifier;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.vo.QueryMethod;
import androidx.room.vo.QueryParameter;
import androidx.room.vo.ReadQueryMethod;
import androidx.room.vo.Warning;
import androidx.room.vo.WriteQueryMethod;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J.\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006+"}, d2 = {"Landroidx/room/processor/InternalQueryProcessor;", "", "context", "Landroidx/room/processor/Context;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "containing", "Landroidx/room/compiler/processing/XType;", "dbVerifier", "Landroidx/room/verifier/DatabaseVerifier;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XType;Landroidx/room/verifier/DatabaseVerifier;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "getContext", "()Landroidx/room/processor/Context;", "getDbVerifier", "()Landroidx/room/verifier/DatabaseVerifier;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "getPreparedQueryMethod", "Landroidx/room/vo/WriteQueryMethod;", "delegate", "Landroidx/room/processor/MethodProcessorDelegate;", "returnType", "query", "Landroidx/room/parser/ParsedQuery;", "getQueryMethod", "Landroidx/room/vo/QueryMethod;", "processMapInfo", "", "mapInfoAnnotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "Landroidx/room/MapInfo;", "queryExecutableElement", "adapterExtras", "Landroidx/room/solver/TypeAdapterExtras;", "processQuery", "input", "", "processQueryMethod", "queryMethod", "validateQuery", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class InternalQueryProcessor {
    public static final Companion Companion = null;
    private static final QueryType[] PREPARED_TYPES = null;
    private final XType containing;
    private final Context context;
    private final DatabaseVerifier dbVerifier;
    private final XMethodElement executableElement;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/room/processor/InternalQueryProcessor$Companion;", "", "()V", "PREPARED_TYPES", "", "Landroidx/room/parser/QueryType;", "getPREPARED_TYPES", "()[Landroidx/room/parser/QueryType;", "[Landroidx/room/parser/QueryType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final QueryType[] getPREPARED_TYPES() {
            return InternalQueryProcessor.access$getPREPARED_TYPES$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        PREPARED_TYPES = new QueryType[]{QueryType.INSERT, QueryType.DELETE, QueryType.UPDATE};
    }

    public InternalQueryProcessor(Context r5, XMethodElement r10, XType r11, DatabaseVerifier r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "executableElement");
        Intrinsics.checkNotNullParameter(r11, "containing");
        this.context = r5;
        this.executableElement = r10;
        this.containing = r11;
        this.dbVerifier = r12;
    }

    public static final /* synthetic */ QueryType[] access$getPREPARED_TYPES$cp() {
        return PREPARED_TYPES;
    }

    public static final /* synthetic */ void access$processMapInfo(InternalQueryProcessor r5, XAnnotationBox r10, ParsedQuery r11, XMethodElement r12, TypeAdapterExtras r13) {
        r5.processMapInfo(r10, r11, r12, r13);
    }

    private final WriteQueryMethod getPreparedQueryMethod(MethodProcessorDelegate r10, XType r11, ParsedQuery r12) {
        PreparedQueryResultBinder r5 = r10.findPreparedResultBinder(r11, r12);
        Checks r13 = this.context.getChecker();
        if (r5.getAdapter() == null) goto L5;
        boolean r14 = true;
    L6:
        r13.check(r14, this.executableElement, ProcessorErrors.INSTANCE.cannotFindPreparedQueryResultAdapter(r11.getTypeName(), r12.getType()), new Object[0]);
        return new WriteQueryMethod(this.executableElement, r12, r11, r10.extractQueryParams(r12), r5);
    L5:
        r14 = false;
        goto L6
    }

    private final QueryMethod getQueryMethod(final MethodProcessorDelegate r11, XType r12, final ParsedQuery r13) {
        QueryResultBinder r10 = r11.findResultBinder(r12, r13, new InternalQueryProcessor$getQueryMethod$resultBinder$1(r11, this, r13));
        Checks r5 = this.context.getChecker();
        if (r10.getAdapter() == null) goto L5;
        boolean r14 = true;
    L6:
        r5.check(r14, this.executableElement, ProcessorErrors.INSTANCE.cannotFindQueryResultAdapter(r12.getTypeName()), new Object[0]);
        boolean r15 = this.executableElement.hasAnnotation(Reflection.getOrCreateKotlinClass(Transaction.class));
        if (r13.getType() != QueryType.SELECT) goto L24;
        if (r15 == true) goto L24;
        QueryResultAdapter r16 = r10.getAdapter();
        if (r16 == null) goto L24;
        List<RowAdapter> r17 = r16.getRowAdapters();
        if (r17 == null) goto L24;
        if (r17.isEmpty() == true) goto L24;
        Iterator<T> r18 = r17.iterator();
    L18:
        if (r18.hasNext() == false) goto L24;
        RowAdapter r19 = (RowAdapter) r18.next();
        if ((r19 instanceof PojoRowAdapter) == false) goto L18;
        if (((PojoRowAdapter) r19).getRelationCollectors().isEmpty() == true) goto L18;
        this.context.getLogger().w(Warning.RELATION_QUERY_WITHOUT_TRANSACTION, this.executableElement, ProcessorErrors.INSTANCE.getTRANSACTION_MISSING_ON_RELATION(), new Object[0]);
    L24:
        QueryResultInfo r20 = r13.getResultInfo();
        if (r20 == null) goto L75;
        QueryResultAdapter r21 = r10.getAdapter();
        if (r21 == null) goto L75;
        List<QueryMappedRowAdapter.Mapping> r22 = r21.getMappings();
        if (r22 == null) goto L75;
        if (r22.isEmpty() == true) goto L75;
        if (r22.isEmpty() == true) goto L75;
        Iterator<T> r23 = r22.iterator();
    L38:
        if (r23.hasNext() == false) goto L75;
        if ((((QueryMappedRowAdapter.Mapping) r23.next()) instanceof PojoRowAdapter.PojoMapping) == false) goto L38;
        ArrayList r24 = new ArrayList();
        Iterator<T> r25 = r22.iterator();
    L43:
        if (r25.hasNext() == false) goto L45;
        CollectionsKt.a(r24, ((QueryMappedRowAdapter.Mapping) r25.next()).getUsedColumns());
        goto L43
    L45:
        List<ColumnInfo> r26 = r20.getColumns();
        ArrayList r27 = new ArrayList(CollectionsKt.h(r26));
        Iterator<T> r28 = r26.iterator();
    L47:
        if (r28.hasNext() == false) goto L49;
        r27.add(((ColumnInfo) r28.next()).getName());
        goto L47
    L49:
        List<String> r29 = CollectionsKt.v(r27, r24);
        ArrayList r30 = new ArrayList();
        Iterator<T> r31 = r22.iterator();
    L51:
        if (r31.hasNext() == false) goto L55;
        Object r32 = r31.next();
        if ((r32 instanceof PojoRowAdapter.PojoMapping) == false) goto L51;
        r30.add(r32);
        goto L51
    L55:
        ArrayList r33 = new ArrayList();
        Iterator r34 = r30.iterator();
    L57:
        if (r34.hasNext() == false) goto L61;
        Object r35 = r34.next();
        if (((PojoRowAdapter.PojoMapping) r35).getUnusedFields().isEmpty() == true) goto L57;
        r33.add(r35);
        goto L57
    L61:
        LinkedHashMap r36 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r33)), 16));
        Iterator r37 = r33.iterator();
    L63:
        if (r37.hasNext() == false) goto L66;
        PojoRowAdapter.PojoMapping r38 = (PojoRowAdapter.PojoMapping) r37.next();
        Pair r39 = TuplesKt.to(XTypeNameKt.toJavaPoet(r38.getPojo().getTypeName()), r38.getUnusedFields());
        r36.put(r39.getFirst(), r39.getSecond());
        goto L63
    L66:
        if (r29.isEmpty() == true) goto L68;
    L69:
        ProcessorErrors r40 = ProcessorErrors.INSTANCE;
        ArrayList r41 = new ArrayList(CollectionsKt.h(r30));
        Iterator r42 = r30.iterator();
    L71:
        if (r42.hasNext() == false) goto L73;
        r41.add(XTypeNameKt.toJavaPoet(((PojoRowAdapter.PojoMapping) r42.next()).getPojo().getTypeName()));
        goto L71
    L73:
        this.context.getLogger().w(Warning.CURSOR_MISMATCH, this.executableElement, r40.cursorPojoMismatch(r41, r29, r27, r36), new Object[0]);
        goto L75
    L68:
        if (r36.isEmpty() == false) goto L69;
    L75:
        return new ReadQueryMethod(this.executableElement, r13, r12, r11.extractQueryParams(r13), r15, r10);
    L5:
        r14 = false;
        goto L6
    }

    private final void processMapInfo(XAnnotationBox<MapInfo> r12, ParsedQuery r13, XMethodElement r14, TypeAdapterExtras r15) {
        final String r5 = r12.getValue().keyColumn();
        final String r10 = r12.getValue().keyTable();
        final List<ColumnInfo> r11 = null;
        if (r10.length() != 0) goto L5;
        r10 = null;
    L5:
        final String r16 = r12.getValue().valueColumn();
        final String r17 = r12.getValue().valueTable();
        if (r17.length() != 0) goto L8;
        r17 = null;
    L8:
        Set<Table> r18 = r13.getTables();
        LinkedHashMap r19 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r18)), 16));
        Iterator<T> r20 = r18.iterator();
    L10:
        if (r20.hasNext() == false) goto L12;
        Table r21 = (Table) r20.next();
        Pair r22 = TuplesKt.to(r21.getName(), r21.getAlias());
        r19.put(r22.getFirst(), r22.getSecond());
        goto L10
    L12:
        Checks r23 = this.context.getChecker();
        boolean r24 = true;
        if (r5.length() <= 0) goto L16;
    L17:
        boolean r25 = true;
    L19:
        r23.check(r25, r14, ProcessorErrors.INSTANCE.getMAP_INFO_MUST_HAVE_AT_LEAST_ONE_COLUMN_PROVIDED(), new Object[0]);
        QueryResultInfo r110 = r13.getResultInfo();
        if (r110 == null) goto L22;
        r11 = r110.getColumns();
    L22:
        if (r11 == null) goto L38;
        Checks r111 = this.context.getChecker();
        if (r5.length() != 0) goto L27;
    L28:
        boolean r26 = true;
    L30:
        r111.check(r26, r14, new AnonymousClass1(r10, r5, r11));
        Checks r112 = this.context.getChecker();
        if (r16.length() != 0) goto L34;
    L37:
        r112.check(r24, r14, new AnonymousClass2(r17, r16, r11));
        goto L38
    L34:
        if (processMapInfo$contains(r11, r19, r16, r17) == true) goto L37;
        r24 = false;
        goto L37
    L27:
        if (processMapInfo$contains(r11, r19, r5, r10) == true) goto L28;
        r26 = false;
    L38:
        r15.putData(Reflection.getOrCreateKotlinClass(androidx.room.vo.MapInfo.class), new androidx.room.vo.MapInfo(r5, r16));
        return;
    L16:
        if (r16.length() > 0) goto L17;
        r25 = false;
        goto L19
    }

    private static final boolean processMapInfo$contains(List<ColumnInfo> r5, Map<String, String> r10, String r11, String r12) {
        if (r5 != null) goto L5;
    L7:
        Iterator<T> r13 = r5.iterator();
    L9:
        if (r13.hasNext() == false) goto L35;
        ColumnInfo r14 = (ColumnInfo) r13.next();
        String r15 = r14.getOriginTable();
        if (r15 == null) goto L16;
        String r16 = r10.get(r15);
        if (r16 == null) goto L18;
        r15 = r16;
    L18:
        if (Intrinsics.areEqual(r14.getName(), r11) == false) goto L9;
        if (r12 == null) goto L24;
        if (Intrinsics.areEqual(r15, r12) == true) goto L24;
        if (Intrinsics.areEqual(r14.getOriginTable(), r12) == false) goto L9;
    L24:
        return true;
    L16:
        r15 = null;
        goto L18
    L35:
        return false;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return false;
    }

    private final QueryMethod processQueryMethod(QueryMethod r10) {
        List<Pair<Section.BindVar, QueryParameter>> r5 = r10.getSectionToParamMapping();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((Pair) r13).getSecond() != null) goto L4;
        r11.add(r13);
        goto L4
    L8:
        ArrayList r14 = new ArrayList(CollectionsKt.h(r11));
        Iterator r15 = r11.iterator();
    L10:
        if (r15.hasNext() == false) goto L13;
        r14.add(((Section.BindVar) ((Pair) r15.next()).getFirst()).getText());
        goto L10
    L13:
        if (r14.isEmpty() == true) goto L15;
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.missingParameterForBindVariable(r14), new Object[0]);
    L15:
        List<QueryParameter> r16 = r10.getParameters();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L17:
        if (r18.hasNext() == false) goto L30;
        Object r19 = r18.next();
        QueryParameter r20 = (QueryParameter) r19;
        List<Pair<Section.BindVar, QueryParameter>> r21 = r10.getSectionToParamMapping();
        if (r21 != null) goto L21;
    L23:
        Iterator<T> r22 = r21.iterator();
    L25:
        if (r22.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((Pair) r22.next()).getSecond(), r20) == false) goto L25;
    L29:
        r17.add(r19);
        goto L17
    L21:
        if (r21.isEmpty() == false) goto L23;
    L30:
        ArrayList r23 = new ArrayList(CollectionsKt.h(r17));
        Iterator r24 = r17.iterator();
    L32:
        if (r24.hasNext() == false) goto L35;
        r23.add(((QueryParameter) r24.next()).getSqlName());
        goto L32
    L35:
        if (r23.isEmpty() == true) goto L37;
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.unusedQueryMethodParameter(r23), new Object[0]);
    L37:
        return r10;
    }

    private final void validateQuery(ParsedQuery r5) {
        if (this.executableElement.hasAnnotation(Reflection.getOrCreateKotlinClass(SkipQueryVerification.class)) == false) goto L5;
        return;
    L5:
        DatabaseVerifier r10 = this.dbVerifier;
        SQLException r11 = null;
        if (r10 == null) goto L8;
        QueryResultInfo r12 = r10.analyze(r5.getOriginal());
    L9:
        r5.setResultInfo(r12);
        QueryResultInfo r13 = r5.getResultInfo();
        if (r13 == null) goto L12;
        r11 = r13.getError();
    L12:
        if (r11 == null) goto L15;
        RLog r14 = this.context.getLogger();
        XMethodElement r15 = this.executableElement;
        DatabaseVerificationErrors r16 = DatabaseVerificationErrors.INSTANCE;
        QueryResultInfo r17 = r5.getResultInfo();
        Intrinsics.checkNotNull(r17);
        SQLException r18 = r17.getError();
        Intrinsics.checkNotNull(r18);
        r14.e(r15, r16.cannotVerifyQuery(r18), new Object[0]);
        return;
    L15:
        return;
    L8:
        r12 = null;
        goto L9
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DatabaseVerifier getDbVerifier() {
        return this.dbVerifier;
    }

    public final XMethodElement getExecutableElement() {
        return this.executableElement;
    }

    public final QueryMethod processQuery(String r19) {
        MethodProcessorDelegate r5 = MethodProcessorDelegate.Companion.createFor(this.context, this.containing, this.executableElement);
        XType r10 = r5.extractReturnType();
        Checks r11 = this.context.getChecker();
        boolean r12 = !MethodProcessorDelegateKt.isSuspendAndReturnsDeferredType(r5);
        XMethodElement r13 = this.executableElement;
        ProcessorErrors r14 = ProcessorErrors.INSTANCE;
        r11.check(r12, r13, r14.suspendReturnsDeferredType(r10.getRawType().getTypeName().toString()), new Object[0]);
        if (r19 == null) goto L5;
        ParsedQuery r15 = SqlParser.Companion.parse(r19);
        this.context.getChecker().check(r15.getErrors().isEmpty(), this.executableElement, CollectionsKt.q(r15.getErrors(), "\n", null, null, 0, null, null, 62), new Object[0]);
        validateQuery(r15);
        this.context.getChecker().check(Xtype_extKt.isNotError(r10), this.executableElement, r14.getCANNOT_RESOLVE_RETURN_TYPE(), new Object[]{this.executableElement});
    L6:
        this.context.getChecker().notUnbound(r10.getTypeName(), this.executableElement, r14.getCANNOT_USE_UNBOUND_GENERICS_IN_QUERY_METHODS(), new Object[0]);
        if (ArraysKt.contains(PREPARED_TYPES, r15.getType()) == false) goto L9;
        QueryMethod r16 = getPreparedQueryMethod(r5, r10, r15);
    L11:
        return processQueryMethod(r16);
    L9:
        r16 = getQueryMethod(r5, r10, r15);
        goto L11
    L5:
        r15 = ParsedQuery.Companion.getMISSING();
        goto L6
    }

    public /* synthetic */ InternalQueryProcessor(Context r5, XMethodElement r10, XType r11, DatabaseVerifier r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        r12 = null;
    L5:
        this(r5, r10, r11, r12);
    }
}
