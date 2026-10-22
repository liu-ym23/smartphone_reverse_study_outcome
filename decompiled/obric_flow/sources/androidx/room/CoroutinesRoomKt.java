package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/room/RoomDatabase;", "Lkotlinx/coroutines/z;", "getQueryDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/z;", "getTransactionDispatcher", "transactionDispatcher", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CoroutinesRoomKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final z getQueryDispatcher(RoomDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<String, Object> r10 = r5.getBackingFieldMap();
        Object r11 = r10.get("QueryDispatcher");
        if (r11 != null) goto L5;
        r11 = new e1(r5.getQueryExecutor());
        r10.put("QueryDispatcher", r11);
    L5:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (z) r11;
    }

    public static final z getTransactionDispatcher(RoomDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<String, Object> r10 = r5.getBackingFieldMap();
        Object r11 = r10.get("TransactionDispatcher");
        if (r11 != null) goto L5;
        r11 = new e1(r5.getTransactionExecutor());
        r10.put("TransactionDispatcher", r11);
    L5:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (z) r11;
    }
}
