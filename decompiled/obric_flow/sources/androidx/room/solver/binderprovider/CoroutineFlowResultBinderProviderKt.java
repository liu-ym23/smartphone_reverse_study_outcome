package androidx.room.solver.binderprovider;

import androidx.room.ext.RoomCoroutinesTypeNames;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.QueryResultBinderProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"CoroutineFlowResultBinderProvider", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CoroutineFlowResultBinderProviderKt {
    public static final QueryResultBinderProvider CoroutineFlowResultBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return QueryResultBinderProviderWithRequiredArtifactKt.requireArtifact(new CoroutineFlowResultBinderProviderImpl(r5), r5, RoomCoroutinesTypeNames.INSTANCE.getCOROUTINES_ROOM(), ProcessorErrors.INSTANCE.getMISSING_ROOM_COROUTINE_ARTIFACT());
    }
}
