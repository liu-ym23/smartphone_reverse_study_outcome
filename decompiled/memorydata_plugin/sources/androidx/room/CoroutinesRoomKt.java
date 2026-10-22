package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.bo;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0007\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"transactionDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Landroidx/room/RoomDatabase;", "getTransactionDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/CoroutineDispatcher;", "getQueryDispatcher", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CoroutinesRoomKt {
    public static final ah getQueryDispatcher(RoomDatabase r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map<String, Object> r0 = r3.getBackingFieldMap();
        Object r2 = r0.get("QueryDispatcher");
        if (r2 != null) goto L5;
        r2 = bo.a(r3.getQueryExecutor());
        r0.put("QueryDispatcher", r2);
    L5:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (ah) ZeusTransformUtils.preCheckCast(r2, ah.class, "com.obric.memorydata.plugin");
    }

    public static final ah getTransactionDispatcher(RoomDatabase r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map<String, Object> r0 = r3.getBackingFieldMap();
        Object r2 = r0.get("TransactionDispatcher");
        if (r2 != null) goto L5;
        r2 = bo.a(r3.getTransactionExecutor());
        r0.put("TransactionDispatcher", r2);
    L5:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (ah) ZeusTransformUtils.preCheckCast(r2, ah.class, "com.obric.memorydata.plugin");
    }
}
