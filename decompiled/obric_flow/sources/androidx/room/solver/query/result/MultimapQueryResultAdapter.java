package androidx.room.solver.query.result;

import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.Xtype_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.log.RLog;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.types.CursorValueReader;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.vo.ColumnIndexVar;
import androidx.room.vo.MapInfo;
import androidx.room.vo.Warning;
import com.squareup.javapoet.e;
import com.squareup.javapoet.i;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001e"}, d2 = {"Landroidx/room/solver/query/result/MultimapQueryResultAdapter;", "Landroidx/room/solver/query/result/QueryResultAdapter;", "Landroidx/room/processor/Context;", "context", "Landroidx/room/parser/ParsedQuery;", "parsedQuery", "", "Landroidx/room/solver/query/result/RowAdapter;", "rowAdapters", "<init>", "(Landroidx/room/processor/Context;Landroidx/room/parser/ParsedQuery;Ljava/util/List;)V", "", "cursorVarName", "Landroidx/room/vo/ColumnIndexVar;", "indexVars", "Lcom/squareup/javapoet/i;", "getColumnNullCheckCode", "(Ljava/lang/String;Ljava/util/List;)Lcom/squareup/javapoet/i;", "", "duplicateColumns", "Ljava/util/Set;", "getDuplicateColumns", "()Ljava/util/Set;", "Landroidx/room/compiler/processing/XType;", "getKeyTypeArg", "()Landroidx/room/compiler/processing/XType;", "keyTypeArg", "getValueTypeArg", "valueTypeArg", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class MultimapQueryResultAdapter extends QueryResultAdapter {
    public static final Companion Companion = null;
    private static final Map<e, e> declaredToImplCollection = null;
    private final Set<String> duplicateColumns;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/solver/query/result/MultimapQueryResultAdapter$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/XType;", "keyTypeArg", "valueTypeArg", "Landroidx/room/solver/types/CursorValueReader;", "keyReader", "valueReader", "Landroidx/room/vo/MapInfo;", "mapInfo", "Landroidx/room/log/RLog;", "logger", "", "validateMapTypeArgs", "(Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;Landroidx/room/solver/types/CursorValueReader;Landroidx/room/solver/types/CursorValueReader;Landroidx/room/vo/MapInfo;Landroidx/room/log/RLog;)V", "", "Lcom/squareup/javapoet/e;", "declaredToImplCollection", "Ljava/util/Map;", "getDeclaredToImplCollection", "()Ljava/util/Map;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Map<e, e> getDeclaredToImplCollection() {
            return MultimapQueryResultAdapter.access$getDeclaredToImplCollection$cp();
        }

        public final void validateMapTypeArgs(XType r5, XType r10, CursorValueReader r11, CursorValueReader r12, MapInfo r13, RLog r14) {
            Intrinsics.checkNotNullParameter(r5, "keyTypeArg");
            Intrinsics.checkNotNullParameter(r10, "valueTypeArg");
            Intrinsics.checkNotNullParameter(r14, "logger");
            if (Xtype_extKt.implementsEqualsAndHashcode(r5) == true) goto L5;
            r14.w(Warning.DOES_NOT_IMPLEMENT_EQUALS_HASHCODE, ProcessorErrors.INSTANCE.classMustImplementEqualsAndHashCode(r5.getTypeName().toString()), new Object[0]);
        L5:
            if (r13 == null) goto L11;
            String r15 = r13.getKeyColumnName();
            if (r15 == null) goto L11;
            if (r15.length() <= 0) goto L11;
        L13:
            if (r13 == null) goto L19;
            String r16 = r13.getValueColumnName();
            if (r16 == null) goto L19;
            if (r16.length() <= 0) goto L19;
            return;
        L19:
            if (r12 == null) goto L22;
            r14.e(ProcessorErrors.INSTANCE.valueMayNeedMapInfo(r10.getTypeName()), new Object[0]);
            return;
        L22:
            return;
        L11:
            if (r11 == null) goto L13;
            r14.e(ProcessorErrors.INSTANCE.keyMayNeedMapInfo(r5.getTypeName()), new Object[0]);
            goto L13
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        declaredToImplCollection = MapsKt.mapOf(new Pair[]{TuplesKt.to(e.n(List.class), e.n(ArrayList.class)), TuplesKt.to(e.n(Set.class), e.n(HashSet.class))});
    }

    public MultimapQueryResultAdapter(Context r5, ParsedQuery r10, List<? extends RowAdapter> r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "parsedQuery");
        Intrinsics.checkNotNullParameter(r11, "rowAdapters");
        super(r11);
        QueryResultInfo r12 = r10.getResultInfo();
        if (r12 == null) goto L10;
        List<ColumnInfo> r13 = r12.getColumns();
        if (r13 == null) goto L10;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L14;
        r14.add(((ColumnInfo) r15.next()).getName());
    L14:
        Set r16 = SetsKt.createSetBuilder();
        LinkedHashSet r17 = new LinkedHashSet();
        Iterator r18 = r14.iterator();
    L16:
        if (r18.hasNext() == false) goto L20;
        String r19 = (String) r18.next();
        if (r17.add(r19) == true) goto L16;
        r16.add(r19);
        goto L16
    L20:
        Set<String> r20 = SetsKt.build(r16);
        this.duplicateColumns = r20;
        if (r10.getResultInfo() != null) goto L23;
        return;
    L23:
        if (r20.isEmpty() == true) goto L67;
        List<QueryMappedRowAdapter.Mapping> r21 = getMappings();
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r21.iterator();
    L26:
        if (r23.hasNext() == false) goto L32;
        Object r24 = r23.next();
        QueryMappedRowAdapter.Mapping r25 = (QueryMappedRowAdapter.Mapping) r24;
        if (r25.getUsedColumns().size() != 1) goto L26;
        if (this.duplicateColumns.contains(CollectionsKt.first(r25.getUsedColumns())) == false) goto L26;
        r22.add(r24);
        goto L26
    L32:
        Iterator r26 = r22.iterator();
    L34:
        if (r26.hasNext() == false) goto L68;
        QueryMappedRowAdapter.Mapping r27 = (QueryMappedRowAdapter.Mapping) r26.next();
        String r28 = (String) CollectionsKt.first(r27.getUsedColumns());
        if ((r27 instanceof SingleNamedColumnRowAdapter.SingleNamedColumnRowMapping) == false) goto L39;
        Pair r29 = TuplesKt.to(ProcessorErrors.AmbiguousColumnLocation.MAP_INFO, null);
    L44:
        r5.getLogger().w(Warning.AMBIGUOUS_COLUMN_IN_RESULT, ProcessorErrors.INSTANCE.ambiguousColumn(r28, (ProcessorErrors.AmbiguousColumnLocation) r29.component1(), (x) r29.component2()), new Object[0]);
        goto L34
    L39:
        if ((r27 instanceof PojoRowAdapter.PojoMapping) == false) goto L42;
        r29 = TuplesKt.to(ProcessorErrors.AmbiguousColumnLocation.POJO, XTypeNameKt.toJavaPoet(((PojoRowAdapter.PojoMapping) r27).getPojo().getTypeName()));
        goto L44
    L42:
        if ((r27 instanceof EntityRowAdapter.EntityMapping) == false) goto L46;
        r29 = TuplesKt.to(ProcessorErrors.AmbiguousColumnLocation.ENTITY, XTypeNameKt.toJavaPoet(((EntityRowAdapter.EntityMapping) r27).getEntity().getTypeName()));
        goto L44
    L46:
        throw new IllegalStateException(("Unknown mapping type: " + r27).toString());
    L68:
        return;
    L67:
        return;
    L10:
        List<QueryMappedRowAdapter.Mapping> r30 = getMappings();
        r14 = new ArrayList();
        Iterator<T> r31 = r30.iterator();
    L12:
        if (r31.hasNext() == false) goto L14;
        CollectionsKt.a(r14, ((QueryMappedRowAdapter.Mapping) r31.next()).getUsedColumns());
        goto L12
    }

    public static final /* synthetic */ Map access$getDeclaredToImplCollection$cp() {
        return declaredToImplCollection;
    }

    public final i getColumnNullCheckCode(String r10, List<ColumnIndexVar> r11) {
        Intrinsics.checkNotNullParameter(r10, "cursorVarName");
        Intrinsics.checkNotNullParameter(r11, "indexVars");
        ArrayList r5 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r5.add(i.d(a.q(Javapoet_extKt.getL(), ".isNull(", Javapoet_extKt.getL(), ")"), new Object[]{r10, ((ColumnIndexVar) r12.next()).getIndexVar()}));
        goto L4
    L7:
        return i.c(Javapoet_extKt.getW() + "&&" + Javapoet_extKt.getW(), r5);
    }

    public final Set<String> getDuplicateColumns() {
        return this.duplicateColumns;
    }

    public abstract XType getKeyTypeArg();

    public abstract XType getValueTypeArg();
}
