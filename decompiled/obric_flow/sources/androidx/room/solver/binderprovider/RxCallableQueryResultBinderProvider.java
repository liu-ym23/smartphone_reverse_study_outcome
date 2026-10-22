package androidx.room.solver.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.solver.QueryResultBinderProvider;
import androidx.room.solver.RxType;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.query.result.RxCallableQueryResultBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/binderprovider/RxCallableQueryResultBinderProvider;", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "rxType", "Landroidx/room/solver/RxType;", "(Landroidx/room/processor/Context;Landroidx/room/solver/RxType;)V", "getContext", "()Landroidx/room/processor/Context;", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "matchesRxType", "provide", "Landroidx/room/solver/query/result/QueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "extras", "Landroidx/room/solver/TypeAdapterExtras;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RxCallableQueryResultBinderProvider implements QueryResultBinderProvider {
    public static final Companion Companion = null;
    private final Context context;
    private final RxType rxType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/room/solver/binderprovider/RxCallableQueryResultBinderProvider$Companion;", "", "()V", "getAll", "", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<QueryResultBinderProvider> getAll(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            List r10 = CollectionsKt.listOf(new RxType[]{RxType.RX2_SINGLE, RxType.RX2_MAYBE, RxType.RX3_SINGLE, RxType.RX3_MAYBE});
            ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
            Iterator r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            RxType r13 = (RxType) r12.next();
            r11.add(QueryResultBinderProviderWithRequiredArtifactKt.requireArtifact(new RxCallableQueryResultBinderProvider(r5, r13, null), r5, r13.getVersion().getRxRoomClassName(), r13.getVersion().getMissingArtifactMessage()));
            goto L4
        L6:
            return r11;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ RxCallableQueryResultBinderProvider(Context r5, RxType r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    private final boolean matchesRxType(XType r5) {
        return Intrinsics.areEqual(r5.getRawType().getTypeName(), this.rxType.getClassName());
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 1) goto L5;
    L7:
        return false;
    L5:
        if (matchesRxType(r5) == false) goto L7;
        return true;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public QueryResultBinder provide(XType r5, ParsedQuery r10, TypeAdapterExtras r11) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extras");
        XType r12 = (XType) CollectionsKt.first(r5.getTypeArguments());
        QueryResultAdapter r13 = this.context.getTypeAdapterStore().findQueryResultAdapter(r12, r10, r11);
        return new RxCallableQueryResultBinder(this.rxType, r12, r13);
    }

    private RxCallableQueryResultBinderProvider(Context r5, RxType r10) {
        this.context = r5;
        this.rxType = r10;
    }
}
