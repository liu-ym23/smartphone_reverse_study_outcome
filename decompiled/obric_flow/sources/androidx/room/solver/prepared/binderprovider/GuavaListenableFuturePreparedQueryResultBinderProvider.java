package androidx.room.solver.prepared.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.GuavaUtilConcurrentTypeNames;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.prepared.binder.CallablePreparedQueryResultBinder;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/room/solver/prepared/binderprovider/GuavaListenableFuturePreparedQueryResultBinderProvider;", "Landroidx/room/solver/prepared/binderprovider/PreparedQueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "getContext", "()Landroidx/room/processor/Context;", "hasGuavaRoom", "", "getHasGuavaRoom", "()Z", "hasGuavaRoom$delegate", "Lkotlin/Lazy;", "matches", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GuavaListenableFuturePreparedQueryResultBinderProvider implements PreparedQueryResultBinderProvider {
    private final Context context;
    private final Lazy hasGuavaRoom$delegate;

    public GuavaListenableFuturePreparedQueryResultBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        this.hasGuavaRoom$delegate = LazyKt.lazy(new GuavaListenableFuturePreparedQueryResultBinderProvider$hasGuavaRoom$2(this));
    }

    private final boolean getHasGuavaRoom() {
        return ((Boolean) this.hasGuavaRoom$delegate.getValue()).booleanValue();
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.room.solver.prepared.binderprovider.PreparedQueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 1) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getRawType().getTypeName(), GuavaUtilConcurrentTypeNames.INSTANCE.getLISTENABLE_FUTURE()) == false) goto L7;
        return true;
    }

    @Override // androidx.room.solver.prepared.binderprovider.PreparedQueryResultBinderProvider
    public PreparedQueryResultBinder provide(XType r5, ParsedQuery r10) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "query");
        if (getHasGuavaRoom() == true) goto L5;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getMISSING_ROOM_GUAVA_ARTIFACT(), new Object[0]);
    L5:
        XType r11 = (XType) CollectionsKt.first(r5.getTypeArguments());
        return CallablePreparedQueryResultBinder.Companion.createPreparedBinder(r11, this.context.getTypeAdapterStore().findPreparedQueryResultAdapter(r11, r10), AnonymousClass1.INSTANCE);
    }
}
