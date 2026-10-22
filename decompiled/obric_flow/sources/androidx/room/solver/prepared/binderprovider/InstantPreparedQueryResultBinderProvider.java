package androidx.room.solver.prepared.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.solver.prepared.binder.InstantPreparedQueryResultBinder;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/room/solver/prepared/binderprovider/InstantPreparedQueryResultBinderProvider;", "Landroidx/room/solver/prepared/binderprovider/PreparedQueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "getContext", "()Landroidx/room/processor/Context;", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/prepared/binder/InstantPreparedQueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InstantPreparedQueryResultBinderProvider implements PreparedQueryResultBinderProvider {
    private final Context context;

    public InstantPreparedQueryResultBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.room.solver.prepared.binderprovider.PreparedQueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return true;
    }

    @Override // androidx.room.solver.prepared.binderprovider.PreparedQueryResultBinderProvider
    public /* bridge */ /* synthetic */ PreparedQueryResultBinder provide(XType r5, ParsedQuery r10) {
        return provide(r5, r10);
    }

    @Override // androidx.room.solver.prepared.binderprovider.PreparedQueryResultBinderProvider
    public InstantPreparedQueryResultBinder provide(XType r5, ParsedQuery r10) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "query");
        return new InstantPreparedQueryResultBinder(this.context.getTypeAdapterStore().findPreparedQueryResultAdapter(r5, r10));
    }
}
