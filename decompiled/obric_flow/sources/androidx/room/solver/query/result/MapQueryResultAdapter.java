package androidx.room.solver.query.result;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.ext.CollectionTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.ColumnIndexVar;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010 R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010 R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010!R\u001c\u0010$\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010&\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%R\u001c\u0010(\u001a\n #*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010*\u001a\n #*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006+"}, d2 = {"Landroidx/room/solver/query/result/MapQueryResultAdapter;", "Landroidx/room/solver/query/result/MultimapQueryResultAdapter;", "Landroidx/room/processor/Context;", "context", "Landroidx/room/parser/ParsedQuery;", "parsedQuery", "Landroidx/room/compiler/processing/XType;", "keyTypeArg", "valueTypeArg", "Landroidx/room/solver/query/result/QueryMappedRowAdapter;", "keyRowAdapter", "valueRowAdapter", "valueCollectionType", "", "isArrayMap", "Lcom/squareup/javapoet/e;", "isSparseArray", "<init>", "(Landroidx/room/processor/Context;Landroidx/room/parser/ParsedQuery;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;Landroidx/room/solver/query/result/QueryMappedRowAdapter;Landroidx/room/solver/query/result/QueryMappedRowAdapter;Landroidx/room/compiler/processing/XType;ZLcom/squareup/javapoet/e;)V", "", "outVarName", "cursorVarName", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convert", "(Ljava/lang/String;Ljava/lang/String;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/parser/ParsedQuery;", "Landroidx/room/compiler/processing/XType;", "getKeyTypeArg", "()Landroidx/room/compiler/processing/XType;", "getValueTypeArg", "Landroidx/room/solver/query/result/QueryMappedRowAdapter;", "Lcom/squareup/javapoet/e;", "Lcom/squareup/javapoet/x;", "kotlin.jvm.PlatformType", "declaredValueType", "Lcom/squareup/javapoet/x;", "implValueType", "Lcom/squareup/javapoet/v;", "mapType", "Lcom/squareup/javapoet/v;", "implMapType", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapQueryResultAdapter extends MultimapQueryResultAdapter {
    private final x declaredValueType;
    private final v implMapType;
    private final x implValueType;
    private final e isSparseArray;
    private final QueryMappedRowAdapter keyRowAdapter;
    private final XType keyTypeArg;
    private final v mapType;
    private final ParsedQuery parsedQuery;
    private final XType valueCollectionType;
    private final QueryMappedRowAdapter valueRowAdapter;
    private final XType valueTypeArg;

    public /* synthetic */ MapQueryResultAdapter(Context r13, ParsedQuery r14, XType r15, XType r16, QueryMappedRowAdapter r17, QueryMappedRowAdapter r18, XType r19, boolean r20, e r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 128) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r22 & 256) == 0) goto L9;
        e r11 = null;
    L10:
        this(r13, r14, r15, r16, r17, r18, r19, r10, r11);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r10 = r20;
        goto L7
    }

    @Override // androidx.room.solver.query.result.QueryResultAdapter
    public void convert(String r22, String r23, CodeGenScope r24) {
        Intrinsics.checkNotNullParameter(r22, "outVarName");
        g r10 = a.k(r23, "cursorVarName", "scope", r24);
        if (getDuplicateColumns().isEmpty() == true) goto L12;
        AmbiguousColumnIndexAdapter r5 = new AmbiguousColumnIndexAdapter(getMappings(), this.parsedQuery);
        r5.onCursorReady(r23, r24);
        Iterator<T> r11 = getRowAdapters().iterator();
    L6:
        if (r11.hasNext() == false) goto L17;
        RowAdapter r12 = (RowAdapter) r11.next();
        if ((r12 instanceof QueryMappedRowAdapter) == false) goto L11;
        r12.onCursorReady(r23, r24, r5.getIndexVarsForMapping(((QueryMappedRowAdapter) r12).getMapping()));
        goto L6
    L11:
        throw new IllegalStateException("Check failed.");
    L17:
        String r13 = Javapoet_extKt.getT();
        String r14 = Javapoet_extKt.getL();
        String r15 = Javapoet_extKt.getT();
        r10.c(j0.q(androidx.constraintlayout.motion.widget.a.y("final ", r13, " ", r14, " = new "), r15, "()"), new Object[]{this.mapType, r22, this.implMapType});
        String r16 = r24.getTmpVar("_key");
        String r17 = r24.getTmpVar("_value");
        r10.e(j0.k("while (", Javapoet_extKt.getL(), ".moveToNext())"), new Object[]{r23});
        r10.c(androidx.constraintlayout.motion.widget.a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{getKeyTypeArg().getTypeName(), r16});
        this.keyRowAdapter.convert(r16, r23, r24);
        if (r5 == null) goto L21;
        List<ColumnIndexVar> r18 = r5.getIndexVarsForMapping(this.valueRowAdapter.getMapping());
        if (r18 == null) goto L21;
    L22:
        i r19 = getColumnNullCheckCode(r23, r18);
        if (this.valueCollectionType == null) goto L29;
        String r110 = r24.getTmpVar("_values");
        r10.c(j0.D(Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{this.declaredValueType, r110});
        if (this.isSparseArray == null) goto L27;
        r10.e(j0.l("if (", Javapoet_extKt.getL(), ".get(", Javapoet_extKt.getL(), ") != null)"), new Object[]{r22, r16});
    L28:
        StringBuilder r20 = a.y(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getL(), ".get(", Javapoet_extKt.getL());
        r20.append(")");
        r10.c(r20.toString(), new Object[]{r110, r22, r16});
        r10.h("else", new Object[0]);
        r10.c(a.q(Javapoet_extKt.getL(), " = new ", Javapoet_extKt.getT(), "()"), new Object[]{r110, this.implValueType});
        StringBuilder r21 = a.y(Javapoet_extKt.getL(), ".put(", Javapoet_extKt.getL(), ", ", Javapoet_extKt.getL());
        r21.append(")");
        r10.c(r21.toString(), new Object[]{r22, r16, r110});
        r10.g();
        r10.e(j0.k("if (", Javapoet_extKt.getL(), ")"), new Object[]{r19});
        r10.c("continue", new Object[0]);
        r10.g();
        r10.c(androidx.constraintlayout.motion.widget.a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{getValueTypeArg().getTypeName(), r17});
        this.valueRowAdapter.convert(r17, r23, r24);
        r10.c(a.q(Javapoet_extKt.getL(), ".add(", Javapoet_extKt.getL(), ")"), new Object[]{r110, r17});
    L38:
        r10.g();
        return;
    L27:
        r10.e(j0.l("if (", Javapoet_extKt.getL(), ".containsKey(", Javapoet_extKt.getL(), "))"), new Object[]{r22, r16});
        goto L28
    L29:
        r10.e(j0.k("if (", Javapoet_extKt.getL(), ")"), new Object[]{r19});
        r10.c(a.q(Javapoet_extKt.getL(), ".put(", Javapoet_extKt.getL(), ", null)"), new Object[]{r22, r16});
        r10.c("continue", new Object[0]);
        r10.g();
        String r25 = androidx.constraintlayout.motion.widget.a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL());
        XTypeElement r26 = getValueTypeArg().getTypeElement();
        if (r26 == null) goto L32;
        e r111 = r26.getClassName();
    L33:
        r10.c(r25, new Object[]{r111, r17});
        this.valueRowAdapter.convert(r17, r23, r24);
        if (this.isSparseArray == null) goto L36;
        r10.e(j0.l("if (", Javapoet_extKt.getL(), ".get(", Javapoet_extKt.getL(), ") == null)"), new Object[]{r22, r16});
    L37:
        StringBuilder r27 = a.y(Javapoet_extKt.getL(), ".put(", Javapoet_extKt.getL(), ", ", Javapoet_extKt.getL());
        r27.append(")");
        r10.c(r27.toString(), new Object[]{r22, r16, r17});
        r10.g();
        goto L38
    L36:
        r10.e(j0.l("if (!", Javapoet_extKt.getL(), ".containsKey(", Javapoet_extKt.getL(), "))"), new Object[]{r22, r16});
        goto L37
    L32:
        r111 = null;
    L21:
        r18 = this.valueRowAdapter.getDefaultIndexAdapter().getIndexVars();
        goto L22
    L12:
        Iterator<T> r112 = getRowAdapters().iterator();
    L14:
        if (r112.hasNext() == false) goto L16;
        RowAdapter.onCursorReady$default((RowAdapter) r112.next(), r23, r24, null, 4, null);
        goto L14
    L16:
        r5 = null;
        goto L17
    }

    @Override // androidx.room.solver.query.result.MultimapQueryResultAdapter
    public XType getKeyTypeArg() {
        return this.keyTypeArg;
    }

    @Override // androidx.room.solver.query.result.MultimapQueryResultAdapter
    public XType getValueTypeArg() {
        return this.valueTypeArg;
    }

    public MapQueryResultAdapter(Context r5, ParsedQuery r10, XType r11, XType r12, QueryMappedRowAdapter r13, QueryMappedRowAdapter r14, XType r15, boolean r16, e r17) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "parsedQuery");
        Intrinsics.checkNotNullParameter(r11, "keyTypeArg");
        Intrinsics.checkNotNullParameter(r12, "valueTypeArg");
        Intrinsics.checkNotNullParameter(r13, "keyRowAdapter");
        Intrinsics.checkNotNullParameter(r14, "valueRowAdapter");
        super(r5, r10, CollectionsKt.listOf(new QueryMappedRowAdapter[]{r13, r14}));
        this.parsedQuery = r10;
        this.keyTypeArg = r11;
        this.valueTypeArg = r12;
        this.keyRowAdapter = r13;
        this.valueRowAdapter = r14;
        this.valueCollectionType = r15;
        this.isSparseArray = r17;
        e r18 = null;
        if (r15 == null) goto L9;
        XTypeElement r19 = r15.getTypeElement();
        if (r19 == null) goto L7;
        e r20 = r19.getClassName();
    L8:
        x r21 = v.n(r20, new x[]{getValueTypeArg().getTypeName()});
    L10:
        this.declaredValueType = r21;
        if (r15 == null) goto L16;
        Map<e, e> r22 = MultimapQueryResultAdapter.Companion.getDeclaredToImplCollection();
        XTypeElement r23 = r15.getTypeElement();
        if (r23 == null) goto L15;
        r18 = r23.getClassName();
    L15:
        x r24 = v.n(r22.get(r18), new x[]{getValueTypeArg().getTypeName()});
    L17:
        this.implValueType = r24;
        if (r17 == null) goto L20;
        v r25 = v.n(r17, new x[]{r21});
    L24:
        this.mapType = r25;
        if (r17 == null) goto L27;
        v r26 = v.n(r17, new x[]{r21});
    L31:
        this.implMapType = r26;
        return;
    L27:
        if (r16 == false) goto L29;
        e r27 = CollectionTypeNames.INSTANCE.getARRAY_MAP();
    L30:
        r26 = v.n(r27, new x[]{getKeyTypeArg().getTypeName(), r21});
        goto L31
    L29:
        r27 = e.n(LinkedHashMap.class);
        goto L30
    L20:
        if (r16 == false) goto L22;
        e r28 = CollectionTypeNames.INSTANCE.getARRAY_MAP();
    L23:
        r25 = v.n(r28, new x[]{getKeyTypeArg().getTypeName(), r21});
        goto L24
    L22:
        r28 = e.n(Map.class);
        goto L23
    L16:
        r24 = getValueTypeArg().getTypeName();
        goto L17
    L7:
        r20 = null;
        goto L8
    L9:
        r21 = getValueTypeArg().getTypeName();
        goto L10
    }
}
