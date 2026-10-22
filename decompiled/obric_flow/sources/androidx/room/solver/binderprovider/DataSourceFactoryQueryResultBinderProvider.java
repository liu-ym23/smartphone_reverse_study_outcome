package androidx.room.solver.binderprovider;

import androidx.room.compiler.processing.XRawType;
import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.Table;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.QueryResultBinderProvider;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.TypeAdapterStore;
import androidx.room.solver.query.result.DataSourceFactoryQueryResultBinder;
import androidx.room.solver.query.result.ListQueryResultAdapter;
import androidx.room.solver.query.result.PositionalDataSourceQueryResultBinder;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.query.result.RowAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/room/solver/binderprovider/DataSourceFactoryQueryResultBinderProvider;", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "getContext", "()Landroidx/room/processor/Context;", "dataSourceFactoryType", "Landroidx/room/compiler/processing/XRawType;", "getDataSourceFactoryType", "()Landroidx/room/compiler/processing/XRawType;", "dataSourceFactoryType$delegate", "Lkotlin/Lazy;", "isLivePagedList", "", "declared", "Landroidx/room/compiler/processing/XType;", "matches", "provide", "Landroidx/room/solver/query/result/QueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "extras", "Landroidx/room/solver/TypeAdapterExtras;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DataSourceFactoryQueryResultBinderProvider implements QueryResultBinderProvider {
    private final Context context;
    private final Lazy dataSourceFactoryType$delegate;

    public DataSourceFactoryQueryResultBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        this.dataSourceFactoryType$delegate = LazyKt.lazy(new DataSourceFactoryQueryResultBinderProvider$dataSourceFactoryType$2(this));
    }

    private final XRawType getDataSourceFactoryType() {
        return (XRawType) this.dataSourceFactoryType$delegate.getValue();
    }

    private final boolean isLivePagedList(XType r5) {
        if (getDataSourceFactoryType() != null) goto L6;
        return false;
    L6:
        XRawType r10 = r5.getRawType();
        XRawType r11 = getDataSourceFactoryType();
        Intrinsics.checkNotNull(r11);
        return r10.isAssignableFrom(r11);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 2) goto L5;
    L7:
        return false;
    L5:
        if (isLivePagedList(r5) == false) goto L7;
        return true;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public QueryResultBinder provide(XType r10, ParsedQuery r11, TypeAdapterExtras r12) {
        Intrinsics.checkNotNullParameter(r10, "declared");
        Intrinsics.checkNotNullParameter(r11, "query");
        Intrinsics.checkNotNullParameter(r12, "extras");
        if (r11.getTables().isEmpty() == false) goto L5;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getOBSERVABLE_QUERY_NOTHING_TO_OBSERVE(), new Object[0]);
    L5:
        XType r13 = r10.getTypeArguments().get(1);
        RowAdapter r14 = TypeAdapterStore.findRowAdapter$default(this.context.getTypeAdapterStore(), r13, r11, null, 4, null);
        if (r14 == null) goto L8;
        ListQueryResultAdapter r15 = new ListQueryResultAdapter(r13, r14);
    L9:
        if (r15 == null) goto L12;
        List<String> r16 = r15.accessedTableNames();
        if (r16 == null) goto L12;
    L13:
        Set<Table> r17 = r11.getTables();
        ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
        Iterator<T> r19 = r17.iterator();
    L15:
        if (r19.hasNext() == false) goto L18;
        r18.add(((Table) r19.next()).getName());
        goto L15
    L18:
        return new DataSourceFactoryQueryResultBinder(new PositionalDataSourceQueryResultBinder(r15, CollectionsKt.toSet(CollectionsKt.plus(r16, r18))));
    L12:
        r16 = CollectionsKt.emptyList();
        goto L13
    L8:
        r15 = null;
        goto L9
    }
}
