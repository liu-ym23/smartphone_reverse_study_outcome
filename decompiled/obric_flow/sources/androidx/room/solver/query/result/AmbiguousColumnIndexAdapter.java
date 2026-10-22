package androidx.room.solver.query.result;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.AmbiguousColumnResolver;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.parser.ParsedQuery;
import androidx.room.solver.CodeGenScope;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.vo.ColumnIndexVar;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u0016J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0011\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R,\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/solver/query/result/AmbiguousColumnIndexAdapter;", "Landroidx/room/solver/query/result/IndexAdapter;", "mappings", "", "Landroidx/room/solver/query/result/QueryMappedRowAdapter$Mapping;", "query", "Landroidx/room/parser/ParsedQuery;", "(Ljava/util/List;Landroidx/room/parser/ParsedQuery;)V", "mappingToIndexVars", "", "Landroidx/room/vo/ColumnIndexVar;", "getMappingToIndexVars", "()Ljava/util/Map;", "setMappingToIndexVars", "(Ljava/util/Map;)V", "getIndexVars", "getIndexVarsForMapping", "mapping", "onCursorReady", "", "cursorVarName", "", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AmbiguousColumnIndexAdapter implements IndexAdapter {
    public Map<QueryMappedRowAdapter.Mapping, ? extends List<ColumnIndexVar>> mappingToIndexVars;
    private final List<QueryMappedRowAdapter.Mapping> mappings;
    private final ParsedQuery query;

    /* JADX WARN: Multi-variable type inference failed */
    public AmbiguousColumnIndexAdapter(List<? extends QueryMappedRowAdapter.Mapping> r5, ParsedQuery r10) {
        Intrinsics.checkNotNullParameter(r5, "mappings");
        Intrinsics.checkNotNullParameter(r10, "query");
        this.mappings = r5;
        this.query = r10;
    }

    public static final /* synthetic */ List access$getMappings$p(AmbiguousColumnIndexAdapter r5) {
        return r5.mappings;
    }

    @Override // androidx.room.solver.query.result.IndexAdapter
    public List<ColumnIndexVar> getIndexVars() {
        return CollectionsKt.flatten(getMappingToIndexVars().values());
    }

    public final List<ColumnIndexVar> getIndexVarsForMapping(QueryMappedRowAdapter.Mapping r5) {
        Intrinsics.checkNotNullParameter(r5, "mapping");
        return (List) MapsKt.getValue(getMappingToIndexVars(), r5);
    }

    public final Map<QueryMappedRowAdapter.Mapping, List<ColumnIndexVar>> getMappingToIndexVars() {
        Map r5 = this.mappingToIndexVars;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mappingToIndexVars");
        return null;
    }

    @Override // androidx.room.solver.query.result.IndexAdapter
    public void onCursorReady(String r14, CodeGenScope r15) {
        Intrinsics.checkNotNullParameter(r14, "cursorVarName");
        Intrinsics.checkNotNullParameter(r15, "scope");
        String r5 = r15.getTmpVar("_cursorIndices");
        g r16 = r15.builder();
        QueryResultInfo r10 = this.query.getResultInfo();
        if (r10 != null) goto L5;
    L15:
        i r11 = Javapoet_extKt.DoubleArrayLiteral(CommonTypeNames.INSTANCE.getSTRING(), this.mappings.size(), new AmbiguousColumnIndexAdapter$onCursorReady$1$rowMappings$3(this), new AmbiguousColumnIndexAdapter$onCursorReady$1$rowMappings$4(this));
        String r12 = Javapoet_extKt.getT();
        String r13 = Javapoet_extKt.getL();
        String r17 = Javapoet_extKt.getT();
        String r18 = Javapoet_extKt.getL();
        String r19 = Javapoet_extKt.getW();
        String r110 = Javapoet_extKt.getL();
        StringBuilder r20 = a.y("final ", r12, "[][] ", r13, " = ");
        a.C(r20, r17, ".resolve(", r18, ".getColumnNames(),");
        r16.c(a.t(r20, r19, r110, ")"), new Object[]{x.f15023h, r5, RoomTypeNames.INSTANCE.getAMBIGUOUS_COLUMN_RESOLVER(), r14, r11});
    L16:
        Map r111 = MapsKt.createMapBuilder();
        Iterator<T> r112 = this.mappings.iterator();
        int r21 = 0;
    L18:
        if (r112.hasNext() == false) goto L30;
        Object r22 = r112.next();
        int r23 = r21 + 1;
        if (r21 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        QueryMappedRowAdapter.Mapping r24 = (QueryMappedRowAdapter.Mapping) r22;
        List<String> r25 = r24.getUsedColumns();
        ArrayList r26 = new ArrayList(CollectionsKt.h(r25));
        Iterator<T> r27 = r25.iterator();
        int r28 = 0;
    L24:
        if (r27.hasNext() == false) goto L29;
        Object r29 = r27.next();
        int r30 = r28 + 1;
        if (r28 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        r26.add(new ColumnIndexVar((String) r29, r5 + "[" + r21 + "][" + r28 + "]"));
        r28 = r30;
        goto L24
    L29:
        r111.put(r24, r26);
        r21 = r23;
        goto L18
    L30:
        setMappingToIndexVars(MapsKt.build(r111));
        return;
    L5:
        if (Intrinsics.areEqual(this.query.getHasTopStarProjection(), Boolean.FALSE) == false) goto L15;
        List<ColumnInfo> r113 = r10.getColumns();
        ArrayList r31 = new ArrayList(CollectionsKt.h(r113));
        Iterator<T> r114 = r113.iterator();
    L8:
        if (r114.hasNext() == false) goto L10;
        r31.add(((ColumnInfo) r114.next()).getName());
        goto L8
    L10:
        Object[] r115 = r31.toArray(new String[0]);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] r116 = (String[]) r115;
        List<QueryMappedRowAdapter.Mapping> r32 = this.mappings;
        ArrayList r33 = new ArrayList(CollectionsKt.h(r32));
        Iterator<T> r34 = r32.iterator();
    L12:
        if (r34.hasNext() == false) goto L14;
        Object[] r35 = ((QueryMappedRowAdapter.Mapping) r34.next()).getUsedColumns().toArray(new String[0]);
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r33.add((String[]) r35);
        goto L12
    L14:
        Object[] r36 = r33.toArray(new String[0][]);
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        final int[][] r117 = AmbiguousColumnResolver.resolve(r116, (String[][]) r36);
        x r37 = x.f15023h;
        i r118 = Javapoet_extKt.DoubleArrayLiteral(r37, r117.length, new AmbiguousColumnIndexAdapter$onCursorReady$1$rowMappings$1(r117), new AmbiguousColumnIndexAdapter$onCursorReady$1$rowMappings$2(r117));
        String r38 = Javapoet_extKt.getT();
        String r39 = Javapoet_extKt.getL();
        String r40 = Javapoet_extKt.getL();
        StringBuilder r41 = a.y("final ", r38, "[][] ", r39, " = ");
        r41.append(r40);
        r16.c(r41.toString(), new Object[]{r37, r5, r118});
        goto L16
    }

    public final void setMappingToIndexVars(Map<QueryMappedRowAdapter.Mapping, ? extends List<ColumnIndexVar>> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.mappingToIndexVars = r5;
    }
}
