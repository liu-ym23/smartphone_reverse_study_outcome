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
import androidx.room.solver.query.result.ListQueryResultAdapter;
import androidx.room.solver.query.result.MultiTypedPagingSourceQueryResultBinder;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.query.result.RowAdapter;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/room/solver/binderprovider/MultiTypedPagingSourceQueryResultBinderProvider;", "Landroidx/room/solver/QueryResultBinderProvider;", "Landroidx/room/processor/Context;", "context", "Lcom/squareup/javapoet/e;", "roomPagingClassName", "Lcom/squareup/javapoet/x;", "pagingSourceTypeName", "<init>", "(Landroidx/room/processor/Context;Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/x;)V", "Landroidx/room/compiler/processing/XType;", "declared", "Landroidx/room/parser/ParsedQuery;", "query", "Landroidx/room/solver/TypeAdapterExtras;", "extras", "Landroidx/room/solver/query/result/QueryResultBinder;", "provide", "(Landroidx/room/compiler/processing/XType;Landroidx/room/parser/ParsedQuery;Landroidx/room/solver/TypeAdapterExtras;)Landroidx/room/solver/query/result/QueryResultBinder;", "", "matches", "(Landroidx/room/compiler/processing/XType;)Z", "Landroidx/room/processor/Context;", "Lcom/squareup/javapoet/e;", "Landroidx/room/compiler/processing/XRawType;", "pagingSourceType$delegate", "Lkotlin/Lazy;", "getPagingSourceType", "()Landroidx/room/compiler/processing/XRawType;", "pagingSourceType", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MultiTypedPagingSourceQueryResultBinderProvider implements QueryResultBinderProvider {
    private final Context context;
    private final Lazy pagingSourceType$delegate;
    private final e roomPagingClassName;

    public MultiTypedPagingSourceQueryResultBinderProvider(Context r5, e r10, final x r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "roomPagingClassName");
        Intrinsics.checkNotNullParameter(r11, "pagingSourceTypeName");
        this.context = r5;
        this.roomPagingClassName = r10;
        this.pagingSourceType$delegate = LazyKt.lazy(new MultiTypedPagingSourceQueryResultBinderProvider$pagingSourceType$2(this, r11));
    }

    public static final /* synthetic */ Context access$getContext$p(MultiTypedPagingSourceQueryResultBinderProvider r5) {
        return r5.context;
    }

    private final XRawType getPagingSourceType() {
        return (XRawType) this.pagingSourceType$delegate.getValue();
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public boolean matches(XType r10) {
        Intrinsics.checkNotNullParameter(r10, "declared");
        XRawType r5 = this.context.getCOMMON_TYPES().getREADONLY_COLLECTION().getRawType();
        if (getPagingSourceType() != null) goto L6;
        return false;
    L6:
        if (r10.getTypeArguments().isEmpty() == false) goto L8;
        return false;
    L8:
        XRawType r11 = getPagingSourceType();
        Intrinsics.checkNotNull(r11);
        if (r11.isAssignableFrom(r10) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(((XType) CollectionsKt.first(r10.getTypeArguments())).getTypeName(), x.f15023h.b()) == true) goto L15;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getPAGING_SPECIFY_PAGING_SOURCE_TYPE(), new Object[0]);
    L15:
        if (r5.isAssignableFrom(((XType) CollectionsKt.last(r10.getTypeArguments())).getRawType()) == false) goto L19;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getPAGING_SPECIFY_PAGING_SOURCE_VALUE_TYPE(), new Object[0]);
        return true;
    L19:
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
        XType r13 = (XType) CollectionsKt.last(r10.getTypeArguments());
        RowAdapter r14 = TypeAdapterStore.findRowAdapter$default(this.context.getTypeAdapterStore(), r13, r11, null, 4, null);
        if (r14 == null) goto L8;
        ListQueryResultAdapter r5 = new ListQueryResultAdapter(r13, r14);
    L9:
        if (r5 == null) goto L12;
        List<String> r15 = r5.accessedTableNames();
        if (r15 == null) goto L12;
    L13:
        Set<Table> r16 = r11.getTables();
        ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
        Iterator<T> r18 = r16.iterator();
    L15:
        if (r18.hasNext() == false) goto L18;
        r17.add(((Table) r18.next()).getName());
        goto L15
    L18:
        return new MultiTypedPagingSourceQueryResultBinder(r5, CollectionsKt.toSet(CollectionsKt.plus(r15, r17)), this.roomPagingClassName);
    L12:
        r15 = CollectionsKt.emptyList();
        goto L13
    L8:
        r5 = null;
        goto L9
    }
}
