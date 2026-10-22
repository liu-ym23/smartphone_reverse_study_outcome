package androidx.room.solver.query.result;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.solver.CodeGenScope;
import com.google.common.collect.ImmutableMap;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0016"}, d2 = {"Landroidx/room/solver/query/result/ImmutableMapQueryResultAdapter;", "Landroidx/room/solver/query/result/MultimapQueryResultAdapter;", "context", "Landroidx/room/processor/Context;", "parsedQuery", "Landroidx/room/parser/ParsedQuery;", "keyTypeArg", "Landroidx/room/compiler/processing/XType;", "valueTypeArg", "resultAdapter", "Landroidx/room/solver/query/result/QueryResultAdapter;", "(Landroidx/room/processor/Context;Landroidx/room/parser/ParsedQuery;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;Landroidx/room/solver/query/result/QueryResultAdapter;)V", "getKeyTypeArg", "()Landroidx/room/compiler/processing/XType;", "getValueTypeArg", "convert", "", "outVarName", "", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImmutableMapQueryResultAdapter extends MultimapQueryResultAdapter {
    private final XType keyTypeArg;
    private final QueryResultAdapter resultAdapter;
    private final XType valueTypeArg;

    public ImmutableMapQueryResultAdapter(Context r5, ParsedQuery r10, XType r11, XType r12, QueryResultAdapter r13) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "parsedQuery");
        Intrinsics.checkNotNullParameter(r11, "keyTypeArg");
        Intrinsics.checkNotNullParameter(r12, "valueTypeArg");
        Intrinsics.checkNotNullParameter(r13, "resultAdapter");
        super(r5, r10, r13.getRowAdapters());
        this.keyTypeArg = r11;
        this.valueTypeArg = r12;
        this.resultAdapter = r13;
    }

    @Override // androidx.room.solver.query.result.QueryResultAdapter
    public void convert(String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        g r5 = a.k(r11, "cursorVarName", "scope", r12);
        String r13 = r12.getTmpVar("_mapResult");
        this.resultAdapter.convert(r13, r11, r12);
        String r14 = Javapoet_extKt.getT();
        String r15 = Javapoet_extKt.getL();
        String r16 = Javapoet_extKt.getT();
        String r17 = Javapoet_extKt.getL();
        r5.c(androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("final ", r14, " ", r15, " = "), r16, ".copyOf(", r17, ")"), new Object[]{v.n(e.n(ImmutableMap.class), new x[]{getKeyTypeArg().getTypeName(), getValueTypeArg().getTypeName()}), r10, e.n(ImmutableMap.class), r13});
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
