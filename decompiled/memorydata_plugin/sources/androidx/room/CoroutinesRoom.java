package androidx.room;

import android.os.CancellationSignal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CoroutinesRoom {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\r\u0012\t\u0012\u0007H\u0005¢\u0006\u0002\b\u00060\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J5\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "()V", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "db", "Landroidx/room/RoomDatabase;", "inTransaction", "", "tableNames", "", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "execute", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final <R> i<R> createFlow(RoomDatabase r8, boolean r9, String[] r10, Callable<R> r11) {
            Callable r5 = (Callable) ZeusTransformUtils.wrapperContextForParams(r11, Callable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "db");
            Intrinsics.checkNotNullParameter(r10, "tableNames");
            Intrinsics.checkNotNullParameter(r5, "callable");
            return k.a((Function2) ZeusTransformUtils.preCheckCast(new CoroutinesRoom$Companion$createFlow$1(r9, r8, r10, r5, null), Function2.class, "com.obric.memorydata.plugin"));
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase r9, boolean r10, final CancellationSignal r11, Callable<R> r12, Continuation<? super R> r13) {
            Callable r8 = (Callable) ZeusTransformUtils.wrapperContextForParams(r12, Callable.class, "com.obric.memorydata.plugin");
            Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            if (r9.isOpenInternal() == true) goto L5;
        L8:
            TransactionElement r15 = (TransactionElement) ZeusTransformUtils.preCheckCast(r14.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(TransactionElement.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), TransactionElement.class, "com.obric.memorydata.plugin");
            if (r15 == null) goto L12;
            ContinuationInterceptor r16 = r15.getTransactionDispatcher$room_ktx_release();
            if (r16 == null) goto L12;
        L16:
            o r17 = new o(IntrinsicsKt.intercepted(r14), 1);
            r17.e();
            n r18 = (n) ZeusTransformUtils.preCheckCast(r17, n.class, "com.obric.memorydata.plugin");
            final bx r19 = kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(r16, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new CoroutinesRoom$Companion$execute$4$job$1(r8, r18, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
            r18.a((Function1) ZeusTransformUtils.preCheckCast(new CoroutinesRoom$Companion$execute$4$1(r11, r19), Function1.class, "com.obric.memorydata.plugin"));
            Object r20 = r17.h();
            if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
            DebugProbesKt.probeCoroutineSuspended(r14);
        L19:
            return r20;
        L12:
            if (r10 == false) goto L14;
            ah r21 = CoroutinesRoomKt.getTransactionDispatcher(r9);
        L15:
            r16 = (ContinuationInterceptor) ZeusTransformUtils.preCheckCast(r21, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
            goto L16
        L14:
            r21 = CoroutinesRoomKt.getQueryDispatcher(r9);
            goto L15
        L5:
            if (r9.inTransaction() == false) goto L8;
            return r8.call();
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase r4, boolean r5, Callable<R> r6, Continuation<? super R> r7) {
            Callable r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (r4.isOpenInternal() == true) goto L5;
        L8:
            TransactionElement r9 = (TransactionElement) ZeusTransformUtils.preCheckCast(r8.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(TransactionElement.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), TransactionElement.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L12;
            ContinuationInterceptor r10 = r9.getTransactionDispatcher$room_ktx_release();
            if (r10 == null) goto L12;
        L17:
            return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(r10, CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new CoroutinesRoom$Companion$execute$2(r3, null), Function2.class, "com.obric.memorydata.plugin"), r8);
        L12:
            if (r5 == false) goto L14;
            ah r11 = CoroutinesRoomKt.getTransactionDispatcher(r4);
        L15:
            r10 = (ContinuationInterceptor) ZeusTransformUtils.preCheckCast(r11, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
            goto L17
        L14:
            r11 = CoroutinesRoomKt.getQueryDispatcher(r4);
            goto L15
        L5:
            if (r4.inTransaction() == false) goto L8;
            return r3.call();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private CoroutinesRoom() {
    }

    @JvmStatic
    public static final <R> i<R> createFlow(RoomDatabase r2, boolean r3, String[] r4, Callable<R> r5) {
        Callable<R> r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.memorydata.plugin");
        return Companion.createFlow(r2, r3, r4, r6);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase r8, boolean r9, CancellationSignal r10, Callable<R> r11, Continuation<? super R> r12) {
        Callable<R> r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r11, Callable.class, "com.obric.memorydata.plugin");
        Continuation<? super R> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return Companion.execute(r8, r9, r10, r6, r7);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase r2, boolean r3, Callable<R> r4, Continuation<? super R> r5) {
        Callable<R> r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
        Continuation<? super R> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return Companion.execute(r2, r3, r6, r7);
    }
}
