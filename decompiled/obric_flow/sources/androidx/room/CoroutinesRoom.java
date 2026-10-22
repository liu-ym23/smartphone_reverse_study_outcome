package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
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
import kotlinx.coroutines.flow.f2;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000fJL\u0010\u0015\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00140\u0013\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "<init>", "()V", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "execute", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "cancellationSignal", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "tableNames", "Lkotlinx/coroutines/flow/g;", "Lkotlin/jvm/JvmSuppressWildcards;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/g;", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final <R> kotlinx.coroutines.flow.g createFlow(RoomDatabase r10, boolean r11, String[] r12, Callable<R> r13) {
            Intrinsics.checkNotNullParameter(r10, "db");
            Intrinsics.checkNotNullParameter(r12, "tableNames");
            Intrinsics.checkNotNullParameter(r13, "callable");
            return new f2(new CoroutinesRoom$Companion$createFlow$1(r11, r10, r12, r13, null));
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase r5, boolean r10, Callable<R> r11, Continuation<? super R> r12) {
            if (r5.isOpenInternal() == true) goto L5;
        L8:
            TransactionElement r13 = (TransactionElement) r12.getContext().get(TransactionElement.Key);
            if (r13 == null) goto L12;
            ContinuationInterceptor r14 = r13.getTransactionDispatcher$room_ktx_release();
            if (r14 == null) goto L12;
        L16:
            return BuildersKt.withContext(r14, new CoroutinesRoom$Companion$execute$2(r11, null), r12);
        L12:
            if (r10 == false) goto L14;
            r14 = CoroutinesRoomKt.getTransactionDispatcher(r5);
            goto L16
        L14:
            r14 = CoroutinesRoomKt.getQueryDispatcher(r5);
            goto L16
        L5:
            if (r5.inTransaction() == false) goto L8;
            return r11.call();
        }

        private Companion() {
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase r10, boolean r11, final CancellationSignal r12, Callable<R> r13, Continuation<? super R> r14) {
            if (r10.isOpenInternal() == true) goto L5;
        L8:
            TransactionElement r15 = (TransactionElement) r14.getContext().get(TransactionElement.Key);
            if (r15 == null) goto L14;
            ContinuationInterceptor r16 = r15.getTransactionDispatcher$room_ktx_release();
            if (r16 == null) goto L14;
        L13:
            ContinuationInterceptor r5 = r16;
            l r17 = new l(1, IntrinsicsKt.intercepted(r14));
            r17.w();
            final Job r18 = BuildersKt.launch$default(GlobalScope.INSTANCE, r5, null, new CoroutinesRoom$Companion$execute$4$job$1(r13, r17, null), 2, null);
            r17.y(new CoroutinesRoom$Companion$execute$4$1(r12, r18));
            Object r19 = r17.v();
            if (r19 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
            DebugProbesKt.probeCoroutineSuspended(r14);
        L20:
            return r19;
        L14:
            if (r11 == false) goto L16;
            r16 = CoroutinesRoomKt.getTransactionDispatcher(r10);
            goto L13
        L16:
            r16 = CoroutinesRoomKt.getQueryDispatcher(r10);
            goto L13
        L5:
            if (r10.inTransaction() == false) goto L8;
            return r13.call();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private CoroutinesRoom() {
    }

    @JvmStatic
    public static final <R> kotlinx.coroutines.flow.g createFlow(RoomDatabase r5, boolean r10, String[] r11, Callable<R> r12) {
        return Companion.createFlow(r5, r10, r11, r12);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase r10, boolean r11, CancellationSignal r12, Callable<R> r13, Continuation<? super R> r14) {
        return Companion.execute(r10, r11, r12, r13, r14);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase r5, boolean r10, Callable<R> r11, Continuation<? super R> r12) {
        return Companion.execute(r5, r10, r11, r12);
    }
}
