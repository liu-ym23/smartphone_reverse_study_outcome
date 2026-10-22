package androidx.room;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"transactionDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Landroidx/room/RoomDatabase;", "getTransactionDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/CoroutineDispatcher;", "getQueryDispatcher", "reflectGetBackingFieldMap", "", "", "", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CoroutinesRoomKt {
    public static final CoroutineDispatcher getQueryDispatcher(RoomDatabase r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map<String, Object> r0 = reflectGetBackingFieldMap(r3);
        Object r2 = r0.get("QueryDispatcher");
        if (r2 != null) goto L5;
        r2 = ExecutorsKt.from(r3.getQueryExecutor());
        r0.put("QueryDispatcher", r2);
    L5:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) r2;
    }

    public static final CoroutineDispatcher getTransactionDispatcher(RoomDatabase r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map<String, Object> r0 = reflectGetBackingFieldMap(r3);
        Object r2 = r0.get("TransactionDispatcher");
        if (r2 != null) goto L5;
        r2 = ExecutorsKt.from(r3.getTransactionExecutor());
        r0.put("TransactionDispatcher", r2);
    L5:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) r2;
    }

    public static final Map<String, Object> reflectGetBackingFieldMap(RoomDatabase r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Method r0 = RoomDatabase.class.getDeclaredMethod("getBackingFieldMap", new Class[0]);
        r0.setAccessible(true);
        Object r5 = r0.invoke(r4, new Object[0]);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        return TypeIntrinsics.asMutableMap(r5);
    }
}
