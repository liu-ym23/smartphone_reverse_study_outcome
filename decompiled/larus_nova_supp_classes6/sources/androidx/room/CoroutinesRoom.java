package androidx.room;

import android.os.CancellationSignal;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CoroutinesRoom {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\r\u0012\t\u0012\u0007H\u0005¢\u0006\u0002\b\u00060\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J5\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "()V", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "db", "Landroidx/room/RoomDatabase;", "inTransaction", "", "tableNames", "", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "execute", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final <R> Flow<R> createFlow(RoomDatabase r8, boolean r9, String[] r10, Callable<R> r11) {
            Intrinsics.checkNotNullParameter(r8, "db");
            Intrinsics.checkNotNullParameter(r10, "tableNames");
            Intrinsics.checkNotNullParameter(r11, "callable");
            return new c1(new CoroutinesRoom$Companion$createFlow$1(r9, r8, r10, r11, null));
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase r3, boolean r4, Callable<R> r5, Continuation<? super R> r6) {
            if (r3.isOpen() == true) goto L5;
        L8:
            TransactionElement r0 = (TransactionElement) r6.getContext().get(TransactionElement.Key);
            if (r0 == null) goto L12;
            ContinuationInterceptor r1 = r0.getTransactionDispatcher$room_ktx_release();
            if (r1 == null) goto L12;
        L17:
            return BuildersKt.withContext(r1, new CoroutinesRoom$Companion$execute$2(r5, null), r6);
        L12:
            if (r4 == false) goto L14;
            ContinuationInterceptor r7 = CoroutinesRoomKt.getTransactionDispatcher(r3);
        L15:
            r1 = r7;
            goto L17
        L14:
            r7 = CoroutinesRoomKt.getQueryDispatcher(r3);
            goto L15
        L5:
            if (r3.inTransaction() == false) goto L8;
            return r5.call();
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase r8, boolean r9, final CancellationSignal r10, Callable<R> r11, Continuation<? super R> r12) {
            if (r8.isOpen() == true) goto L5;
        L8:
            TransactionElement r0 = (TransactionElement) r12.getContext().get(TransactionElement.Key);
            if (r0 == null) goto L14;
            ContinuationInterceptor r1 = r0.getTransactionDispatcher$room_ktx_release();
            if (r1 == null) goto L14;
        L13:
            ContinuationInterceptor r2 = r1;
            j r13 = new j(IntrinsicsKt.intercepted(r12), 1);
            r13.C();
            final Job r14 = BuildersKt.launch$default(GlobalScope.INSTANCE, r2, null, new CoroutinesRoom$Companion$execute$4$job$1(r11, r13, null), 2, null);
            r13.i(new CoroutinesRoom$Companion$execute$4$1(r10, r14));
            Object r15 = r13.B();
            if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
            DebugProbesKt.probeCoroutineSuspended(r12);
        L21:
            return r15;
        L14:
            if (r9 == false) goto L16;
            ContinuationInterceptor r16 = CoroutinesRoomKt.getTransactionDispatcher(r8);
        L17:
            r1 = r16;
            goto L13
        L16:
            r16 = CoroutinesRoomKt.getQueryDispatcher(r8);
            goto L17
        L5:
            if (r8.inTransaction() == false) goto L8;
            return r11.call();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private CoroutinesRoom() {
    }

    @JvmStatic
    public static final <R> Flow<R> createFlow(RoomDatabase r1, boolean r2, String[] r3, Callable<R> r4) {
        return Companion.createFlow(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase r6, boolean r7, CancellationSignal r8, Callable<R> r9, Continuation<? super R> r10) {
        return Companion.execute(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase r1, boolean r2, Callable<R> r3, Continuation<? super R> r4) {
        return Companion.execute(r1, r2, r3, r4);
    }
}
