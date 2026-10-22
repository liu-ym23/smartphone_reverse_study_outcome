package androidx.room.solver.binderprovider;

import androidx.room.ext.PagingTypeNames;
import androidx.room.ext.RoomPagingRx2TypeNames;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.QueryResultBinderProvider;
import com.squareup.javapoet.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"RxJava2PagingSourceQueryResultBinderProvider", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RxJava2PagingSourceQueryResultBinderProviderKt {
    public static final QueryResultBinderProvider RxJava2PagingSourceQueryResultBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        e r10 = RoomPagingRx2TypeNames.INSTANCE.getLIMIT_OFFSET_RX_PAGING_SOURCE();
        return QueryResultBinderProviderWithRequiredArtifactKt.requireArtifact(new MultiTypedPagingSourceQueryResultBinderProvider(r5, r10, PagingTypeNames.INSTANCE.getRX2_PAGING_SOURCE()), r5, r10, ProcessorErrors.INSTANCE.getMISSING_ROOM_PAGING_RXJAVA2_ARTIFACT());
    }
}
