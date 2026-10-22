package androidx.room.solver.binderprovider;

import androidx.room.compiler.processing.XRawType;
import androidx.room.compiler.processing.XType;
import androidx.room.processor.Context;
import androidx.room.solver.ObservableQueryResultBinderProvider;
import androidx.room.solver.query.result.LiveDataQueryResultBinder;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.QueryResultBinder;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Landroidx/room/solver/binderprovider/LiveDataQueryResultBinderProvider;", "Landroidx/room/solver/ObservableQueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "liveDataType", "Landroidx/room/compiler/processing/XRawType;", "getLiveDataType", "()Landroidx/room/compiler/processing/XRawType;", "liveDataType$delegate", "Lkotlin/Lazy;", "create", "Landroidx/room/solver/query/result/QueryResultBinder;", "typeArg", "Landroidx/room/compiler/processing/XType;", "resultAdapter", "Landroidx/room/solver/query/result/QueryResultAdapter;", "tableNames", "", "", "extractTypeArg", "declared", "isLiveData", "", "matches", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LiveDataQueryResultBinderProvider extends ObservableQueryResultBinderProvider {
    private final Lazy liveDataType$delegate;

    public LiveDataQueryResultBinderProvider(final Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.liveDataType$delegate = LazyKt.lazy(new LiveDataQueryResultBinderProvider$liveDataType$2(r5));
    }

    private final XRawType getLiveDataType() {
        return (XRawType) this.liveDataType$delegate.getValue();
    }

    private final boolean isLiveData(XType r5) {
        if (getLiveDataType() != null) goto L6;
        return false;
    L6:
        XRawType r10 = r5.getRawType();
        XRawType r11 = getLiveDataType();
        Intrinsics.checkNotNull(r11);
        return r10.isAssignableFrom(r11);
    }

    @Override // androidx.room.solver.ObservableQueryResultBinderProvider
    public QueryResultBinder create(XType r5, QueryResultAdapter r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        Intrinsics.checkNotNullParameter(r11, "tableNames");
        return new LiveDataQueryResultBinder(r5, r11, r10);
    }

    @Override // androidx.room.solver.ObservableQueryResultBinderProvider
    public XType extractTypeArg(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return (XType) CollectionsKt.first(r5.getTypeArguments());
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 1) goto L5;
    L7:
        return false;
    L5:
        if (isLiveData(r5) == false) goto L7;
        return true;
    }
}
