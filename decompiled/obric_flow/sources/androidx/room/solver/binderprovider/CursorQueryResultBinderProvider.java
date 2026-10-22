package androidx.room.solver.binderprovider;

import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.solver.QueryResultBinderProvider;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.query.result.CursorQueryResultBinder;
import androidx.room.solver.query.result.QueryResultBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/solver/binderprovider/CursorQueryResultBinderProvider;", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "getContext", "()Landroidx/room/processor/Context;", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/query/result/QueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "extras", "Landroidx/room/solver/TypeAdapterExtras;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CursorQueryResultBinderProvider implements QueryResultBinderProvider {
    private final Context context;

    public CursorQueryResultBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getTypeName(), XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR())) == false) goto L7;
        return true;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public QueryResultBinder provide(XType r5, ParsedQuery r10, TypeAdapterExtras r11) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extras");
        return new CursorQueryResultBinder();
    }
}
