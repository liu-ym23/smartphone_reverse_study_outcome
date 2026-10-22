package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u001c\u0010!\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/room/solver/query/result/GuavaImmutableMultimapQueryResultAdapter;", "Landroidx/room/solver/query/result/MultimapQueryResultAdapter;", "Landroidx/room/processor/Context;", "context", "Landroidx/room/parser/ParsedQuery;", "parsedQuery", "Landroidx/room/compiler/processing/XType;", "keyTypeArg", "valueTypeArg", "Landroidx/room/solver/query/result/QueryMappedRowAdapter;", "keyRowAdapter", "valueRowAdapter", "Lcom/squareup/javapoet/e;", "immutableClassName", "<init>", "(Landroidx/room/processor/Context;Landroidx/room/parser/ParsedQuery;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;Landroidx/room/solver/query/result/QueryMappedRowAdapter;Landroidx/room/solver/query/result/QueryMappedRowAdapter;Lcom/squareup/javapoet/e;)V", "", "outVarName", "cursorVarName", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convert", "(Ljava/lang/String;Ljava/lang/String;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/parser/ParsedQuery;", "Landroidx/room/compiler/processing/XType;", "getKeyTypeArg", "()Landroidx/room/compiler/processing/XType;", "getValueTypeArg", "Landroidx/room/solver/query/result/QueryMappedRowAdapter;", "Lcom/squareup/javapoet/e;", "Lcom/squareup/javapoet/v;", "kotlin.jvm.PlatformType", "mapType", "Lcom/squareup/javapoet/v;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GuavaImmutableMultimapQueryResultAdapter extends MultimapQueryResultAdapter {
    private final e immutableClassName;
    private final QueryMappedRowAdapter keyRowAdapter;
    private final XType keyTypeArg;
    private final v mapType;
    private final ParsedQuery parsedQuery;
    private final QueryMappedRowAdapter valueRowAdapter;
    private final XType valueTypeArg;

    public GuavaImmutableMultimapQueryResultAdapter(Context r5, ParsedQuery r10, XType r11, XType r12, QueryMappedRowAdapter r13, QueryMappedRowAdapter r14, e r15) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "parsedQuery");
        Intrinsics.checkNotNullParameter(r11, "keyTypeArg");
        Intrinsics.checkNotNullParameter(r12, "valueTypeArg");
        Intrinsics.checkNotNullParameter(r13, "keyRowAdapter");
        Intrinsics.checkNotNullParameter(r14, "valueRowAdapter");
        Intrinsics.checkNotNullParameter(r15, "immutableClassName");
        super(r5, r10, CollectionsKt.listOf(new QueryMappedRowAdapter[]{r13, r14}));
        this.parsedQuery = r10;
        this.keyTypeArg = r11;
        this.valueTypeArg = r12;
        this.keyRowAdapter = r13;
        this.valueRowAdapter = r14;
        this.immutableClassName = r15;
        this.mapType = v.n(r15, new x[]{getKeyTypeArg().getTypeName(), getValueTypeArg().getTypeName()});
    }

    @Override // androidx.room.solver.query.result.QueryResultAdapter
    public void convert(String r13, String r14, CodeGenScope r15) {
        Intrinsics.checkNotNullParameter(r13, "outVarName");
        Intrinsics.checkNotNullParameter(r14, "cursorVarName");
        Intrinsics.checkNotNullParameter(r15, "scope");
        String r5 = r15.getTmpVar("_mapBuilder");
        g r10 = r15.builder();
        if (getDuplicateColumns().isEmpty() == true) goto L12;
        AmbiguousColumnIndexAdapter r11 = new AmbiguousColumnIndexAdapter(getMappings(), this.parsedQuery);
        r11.onCursorReady(r14, r15);
        Iterator<T> r12 = getRowAdapters().iterator();
    L6:
        if (r12.hasNext() == false) goto L17;
        RowAdapter r16 = (RowAdapter) r12.next();
        if ((r16 instanceof QueryMappedRowAdapter) == false) goto L11;
        r16.onCursorReady(r14, r15, r11.getIndexVarsForMapping(((QueryMappedRowAdapter) r16).getMapping()));
        goto L6
    L11:
        throw new IllegalStateException("Check failed.");
    L17:
        String r17 = Javapoet_extKt.getT();
        String r18 = Javapoet_extKt.getT();
        String r19 = Javapoet_extKt.getT();
        String r20 = Javapoet_extKt.getL();
        String r21 = Javapoet_extKt.getT();
        StringBuilder r22 = a.y("final ", r17, ".Builder<", r18, ", ");
        a.C(r22, r19, "> ", r20, " = ");
        r10.c(j0.q(r22, r21, ".builder()"), new Object[]{this.immutableClassName, getKeyTypeArg().getTypeName(), getValueTypeArg().getTypeName(), r5, this.immutableClassName});
        String r23 = r15.getTmpVar("_key");
        String r24 = r15.getTmpVar("_value");
        r10.e(j0.k("while (", Javapoet_extKt.getL(), ".moveToNext())"), new Object[]{r14});
        r10.c(a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{getKeyTypeArg().getTypeName(), r23});
        this.keyRowAdapter.convert(r23, r14, r15);
        if (r11 == null) goto L21;
        List<ColumnIndexVar> r25 = r11.getIndexVarsForMapping(this.valueRowAdapter.getMapping());
        if (r25 == null) goto L21;
    L22:
        i r26 = getColumnNullCheckCode(r14, r25);
        r10.e(j0.k("if (", Javapoet_extKt.getL(), ")"), new Object[]{r26});
        r10.c("continue", new Object[0]);
        r10.g();
        r10.c(a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{getValueTypeArg().getTypeName(), r24});
        this.valueRowAdapter.convert(r24, r14, r15);
        StringBuilder r110 = androidx.room.jarjarred.org.antlr.runtime.a.y(Javapoet_extKt.getL(), ".put(", Javapoet_extKt.getL(), ", ", Javapoet_extKt.getL());
        r110.append(")");
        r10.c(r110.toString(), new Object[]{r5, r23, r24});
        r10.g();
        String r111 = Javapoet_extKt.getT();
        String r112 = Javapoet_extKt.getL();
        String r27 = Javapoet_extKt.getL();
        r10.c(j0.q(a.y("final ", r111, " ", r112, " = "), r27, ".build()"), new Object[]{this.mapType, r13, r5});
        return;
    L21:
        r25 = this.valueRowAdapter.getDefaultIndexAdapter().getIndexVars();
        goto L22
    L12:
        Iterator<T> r28 = getRowAdapters().iterator();
    L14:
        if (r28.hasNext() == false) goto L16;
        RowAdapter.onCursorReady$default((RowAdapter) r28.next(), r14, r15, null, 4, null);
        goto L14
    L16:
        r11 = null;
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
}
