package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001hB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020,H\u0002J\u001c\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0096@¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u00020\u0003H\u0014J\u001d\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u0010<\u001a\u00020\bH\u0014¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020,H\u0002J\u0016\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010AJ\u0016\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010AJ\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0014\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000eH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020\u0012H\u0002J7\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020,H\u0016J\u0015\u0010V\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0003H\u0002J(\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J%\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0006\u0010c\u001a\u00020\u0012H\u0000¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0012H\u0000¢\u0006\u0002\bgR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(¨\u0006i"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class aj<T> extends kotlinx.coroutines.flow.internal.a<al> implements ad<T>, c<T>, kotlinx.coroutines.flow.internal.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17413b;
    private final BufferOverflow c;
    private Object[] d;
    private long e;
    private long f;
    private int g;
    private int h;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", EventBody.KEY_VALUE, "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class a implements bc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final aj<?> f17414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17415b;
        public final Object c;
        public final Continuation<Unit> d;

        public a(aj<?> r3, long r4, Object r6, Continuation<? super Unit> r7) {
            Continuation<Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.f17414a = r3;
            this.f17415b = r4;
            this.c = r6;
            this.d = r8;
        }

        @Override // kotlinx.coroutines.bc
        public void dispose() {
            aj.a(this.f17414a, this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17416a = null;

        static {
            int[] r0 = new int[BufferOverflow.values().length];
            r0[BufferOverflow.SUSPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BufferOverflow.DROP_LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BufferOverflow.DROP_OLDEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f17416a = r0;
        }
    }

    public aj(int r1, int r2, BufferOverflow r3) {
        this.f17412a = r1;
        this.f17413b = r2;
        this.c = r3;
    }

    public static final /* synthetic */ int a(aj r0) {
        return r0.h;
    }

    public static final /* synthetic */ long a(aj r0, al r1) {
        return r0.b(r1);
    }

    private final Object a(T r12, Continuation<? super Unit> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r14), 1);
        r0.e();
        kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        Continuation<Unit>[] r3 = kotlinx.coroutines.flow.internal.b.f17452a;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (b(this, r12) == false) goto L7;
        Continuation r15 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L28
        r15.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L28
        Continuation<Unit>[] r16 = a(this, r3);     // Catch: Throwable -> L28
        a r4 = null;
    L11:
        monitor-exit(this);
        if (r4 == null) goto L14;
        kotlinx.coroutines.q.a(r1, (bc) ZeusTransformUtils.preCheckCast(r4, bc.class, "com.obric.memorydata.plugin"));
    L14:
        int r11 = 0;
        int r5 = r16.length;
    L15:
        if (r11 >= r5) goto L20;
        Continuation<Unit> r6 = r16[r11];
        if (r6 == null) goto L19;
        Result.Companion r7 = Result.Companion;
        r6.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));
    L19:
        r11 = r11 + 1;
        goto L15
    L20:
        Object r17 = r0.h();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L24:
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r17;
    L27:
        return Unit.INSTANCE;
    L7:
        long r8 = c(this);     // Catch: Throwable -> L28
        a r10 = new a(this, ((long) d(this)) + r8, r12, (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        a(this, r10);     // Catch: Throwable -> L28
        a(this, a(this) + 1);     // Catch: Throwable -> L28
        if (b(this) != 0) goto L10;
        r3 = a(this, r3);     // Catch: Throwable -> L28
    L10:
        r16 = r3;
        r4 = r10;
        goto L11
    }

    static /* synthetic */ <T> Object a(aj<T> r2, T r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if (r2.a(r3) == true) goto L5;
        Object r6 = r2.a(r3, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r6;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<kotlinx.coroutines.flow.aj>] */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlinx.coroutines.flow.aj] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
    /* JADX WARN: Type inference failed for: r10v22, types: [java.lang.Object, kotlinx.coroutines.flow.al] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x014f -> B:33:0x011e). Please report as a decompilation issue!!! */
    static /* synthetic */ <T> Object a(aj<T> r9, j<? super T> r10, Continuation<?> r11) {
        ?? r0 = aj.class;
        ?? r12 = (j) ZeusTransformUtils.wrapperContextForParams(r10, j.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, SharedFlowImpl$collect$1.class) == false) goto L7;
        SharedFlowImpl$collect$1 r1 = (SharedFlowImpl$collect$1) ZeusTransformUtils.preCheckCast(r13, SharedFlowImpl$collect$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 != 0) goto L53;
        ResultKt.throwOnFailure(r14);
        al r15 = (al) ZeusTransformUtils.preCheckCast(r9.j(), al.class, "com.obric.memorydata.plugin");
        boolean r2 = ZeusTransformUtils.instanceOf(r12, av.class);     // Catch: Throwable -> L47
        ?? r16 = r12;
        r15 = r15;
        if (r2 == false) goto L32;
        av r5 = (av) ZeusTransformUtils.preCheckCast(r12, av.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        r1.L$0 = r9;     // Catch: Throwable -> L47
        r1.L$1 = r12;     // Catch: Throwable -> L47
        r1.L$2 = r15;     // Catch: Throwable -> L47
        r1.label = 1;     // Catch: Throwable -> L47
        r16 = r12;
        r15 = r15;
        if (r5.a(r1) != r3) goto L32;
        return r3;
    L32:
        bx r6 = (bx) ZeusTransformUtils.preCheckCast(r1.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        ?? r17 = r16;
        ?? r18 = r15;
    L33:
        ?? r7 = r17;
        r12 = r18;
    L51:
        Object r19 = r9.a(r12);     // Catch: Throwable -> L45
        if (r19 != ak.f17417a) goto L39;
        r1.L$0 = r9;     // Catch: Throwable -> L45
        r1.L$1 = r7;     // Catch: Throwable -> L45
        r1.L$2 = r12;     // Catch: Throwable -> L45
        r1.L$3 = r6;     // Catch: Throwable -> L45
        r1.label = 2;     // Catch: Throwable -> L45
        if (r9.a(r12, r1) != r3) goto L51;
        return r3;
    L39:
        if (r6 == null) goto L41;
        ca.b(r6);     // Catch: Throwable -> L45
    L41:
        r1.L$0 = r9;     // Catch: Throwable -> L45
        r1.L$1 = r7;     // Catch: Throwable -> L45
        r1.L$2 = r12;     // Catch: Throwable -> L45
        r1.L$3 = r6;     // Catch: Throwable -> L45
        r1.label = 3;     // Catch: Throwable -> L45
        if (r7.emit(r19, r1) != r3) goto L44;
        return r3;
    L44:
        r18 = r12;
        r17 = r7;
    L45:
        th = move-exception;
        r0 = r9;
        th = th;
    L49:
        r0.a((kotlinx.coroutines.flow.internal.c) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.flow.internal.c.class, "com.obric.memorydata.plugin"));
        throw th;
    L47:
        th = move-exception;
        r0 = r9;
        th = th;
        r12 = r15;
        goto L49
    L53:
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L17;
        bx r20 = (bx) ZeusTransformUtils.preCheckCast(r1.L$3, bx.class, "com.obric.memorydata.plugin");
        al r110 = (al) ZeusTransformUtils.preCheckCast(r1.L$2, al.class, "com.obric.memorydata.plugin");
        j r8 = (j) ZeusTransformUtils.preCheckCast(r1.L$1, j.class, "com.obric.memorydata.plugin");
        aj<T> r21 = (aj) ZeusTransformUtils.preCheckCast(r1.L$0, r0, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
        r18 = r110;
        r17 = r8;
        r6 = r20;
        r9 = r21;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        bx r22 = (bx) ZeusTransformUtils.preCheckCast(r1.L$3, bx.class, "com.obric.memorydata.plugin");
        al r111 = (al) ZeusTransformUtils.preCheckCast(r1.L$2, al.class, "com.obric.memorydata.plugin");
        j r23 = (j) ZeusTransformUtils.preCheckCast(r1.L$1, j.class, "com.obric.memorydata.plugin");
        aj<T> r24 = (aj) ZeusTransformUtils.preCheckCast(r1.L$0, r0, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
        r6 = r22;
        r9 = r24;
        r7 = r23;
        r12 = r111;
        goto L51
    L21:
        al r112 = (al) ZeusTransformUtils.preCheckCast(r1.L$2, al.class, "com.obric.memorydata.plugin");
        j r25 = (j) ZeusTransformUtils.preCheckCast(r1.L$1, j.class, "com.obric.memorydata.plugin");
        aj<T> r26 = (aj) ZeusTransformUtils.preCheckCast(r1.L$0, r0, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
        r15 = r112;
        r16 = r25;
        r9 = r26;
    L24:
        th = th;
    L7:
        r1 = new SharedFlowImpl$collect$1(r9, r13);
        goto L8
    }

    private final Object a(al r9) {
        Continuation<Unit>[] r0 = kotlinx.coroutines.flow.internal.b.f17452a;
        monitor-enter(this);
        long r1 = b(r9);     // Catch: Throwable -> L17
        if (r1 >= 0) goto L7;
        Object r10 = ak.f17417a;     // Catch: Throwable -> L17
    L9:
        monitor-exit(this);
        int r8 = 0;
        int r2 = r0.length;
    L11:
        if (r8 >= r2) goto L16;
        Continuation<Unit> r3 = r0[r8];
        if (r3 == null) goto L15;
        Result.Companion r4 = Result.Companion;
        r3.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));
    L15:
        r8 = r8 + 1;
        goto L11
    L16:
        return r10;
    L7:
        long r5 = r9.f17418a;     // Catch: Throwable -> L17
        Object r6 = c(r1);     // Catch: Throwable -> L17
        r9.f17418a = r1 + 1;     // Catch: Throwable -> L17
        r0 = a(r5);     // Catch: Throwable -> L17
        r10 = r6;
    L17:
        th = move-exception;
        throw th;
    }

    private final Object a(al r7, Continuation<? super Unit> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r9), 1);
        r0.e();
        kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (a(this, r7) >= 0) goto L7;
        r7.f17419b = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        r7.f17419b = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
    L8:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        Object r6 = r0.h();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L14:
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r6;
    L17:
        return Unit.INSTANCE;
    L7:
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        r11.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L18
        goto L8
    }

    private final void a(long r15, long r17, long r19, long r21) {
        long r5 = Math.min(r17, r15);
        boolean r8 = true;
        if (kotlinx.coroutines.an.a() == true) goto L5;
    L12:
        long r10 = c();
    L14:
        if (r10 >= r5) goto L16;
        Object[] r7 = this.d;
        Intrinsics.checkNotNull(r7);
        ak.a(r7, r10, null);
        r10 = r10 + 1;
        goto L14
    L16:
        this.e = r15;
        this.f = r17;
        this.g = (int) (r19 - r5);
        this.h = (int) (r21 - r19);
        if (kotlinx.coroutines.an.a() == false) goto L27;
        if (this.g < 0) goto L21;
        boolean r1 = true;
    L22:
        if (r1 == true) goto L27;
        throw new AssertionError();
    L21:
        r1 = false;
    L27:
        if (kotlinx.coroutines.an.a() == false) goto L37;
        if (this.h < 0) goto L31;
        boolean r2 = true;
    L32:
        if (r2 == true) goto L37;
        throw new AssertionError();
    L31:
        r2 = false;
    L37:
        if (kotlinx.coroutines.an.a() == true) goto L39;
        return;
    L39:
        if (this.e <= (c() + ((long) this.g))) goto L42;
        r8 = false;
    L42:
        if (r8 == false) goto L45;
        return;
    L45:
        throw new AssertionError();
    L5:
        if (r5 < c()) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == true) goto L12;
        throw new AssertionError();
    L7:
        r9 = false;
        goto L8
    }

    private final void a(a r5) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r5.f17415b >= c()) goto L8;
        monitor-exit(this);
        return;
    L8:
        Object[] r0 = this.d;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L15
        if (ak.a(r0, r5.f17415b) == r5) goto L12;
        monitor-exit(this);
        return;
    L12:
        ak.a(r0, r5.f17415b, ak.f17417a);     // Catch: Throwable -> L15
        p();     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    public static final /* synthetic */ void a(aj r0, int r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ void a(aj r0, Object r1) {
        r0.d(r1);
    }

    public static final /* synthetic */ void a(aj r0, a r1) {
        r0.a(r1);
    }

    private final Object[] a(Object[] r6, int r7, int r8) {
        int r0 = 0;
        if (r8 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L15;
        Object[] r9 = new Object[r8];
        this.d = r9;
        if (r6 != null) goto L10;
        return r9;
    L10:
        long r2 = c();
    L11:
        if (r0 >= r7) goto L13;
        long r3 = ((long) r0) + r2;
        ak.a(r9, r3, ak.a(r6, r3));
        r0 = r0 + 1;
        goto L11
    L13:
        return r9;
    L15:
        throw new IllegalStateException("Buffer size overflow".toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final /* synthetic */ Continuation[] a(aj r0, Continuation[] r1) {
        return r0.a(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    private final Continuation<Unit>[] a(Continuation<Unit>[] r12) {
        int r0 = r12.length;
        kotlinx.coroutines.flow.internal.a r1 = (kotlinx.coroutines.flow.internal.a) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.flow.internal.a.class, "com.obric.memorydata.plugin");
        if (kotlinx.coroutines.flow.internal.a.a(r1) == 0) goto L21;
        kotlinx.coroutines.flow.internal.c[] r2 = kotlinx.coroutines.flow.internal.a.b(r1);
        if (r2 == null) goto L21;
        int r3 = 0;
        int r4 = r2.length;
        r12 = r12;
    L7:
        if (r3 >= r4) goto L21;
        kotlinx.coroutines.flow.internal.c r5 = r2[r3];
        if (r5 == null) goto L19;
        al r6 = (al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r7 = r6.f17419b;
        if (r7 == null) goto L19;
        if (b(r6) < 0) goto L19;
        int r8 = r12.length;
        r12 = r12;
        if (r0 < r8) goto L18;
        Object[] r13 = Arrays.copyOf(r12, Math.max(2, r12.length * 2));
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(...)");
        r12 = r13;
    L18:
        ((Continuation[]) ZeusTransformUtils.preCheckCast(r12, Continuation[].class, "com.obric.memorydata.plugin"))[r0] = r7;
        r6.f17419b = null;
        r0 = r0 + 1;
    L19:
        r3 = r3 + 1;
        r12 = r12;
    L21:
        return (Continuation[]) ZeusTransformUtils.preCheckCast(r12, Continuation[].class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ int b(aj r0) {
        return r0.f17413b;
    }

    private final long b(al r7) {
        long r0 = r7.f17418a;
        if (r0 >= m()) goto L6;
        return r0;
    L6:
        if (this.f17413b <= 0) goto L9;
        return -1;
    L9:
        if (r0 <= c()) goto L12;
        return -1;
    L12:
        if (this.h != 0) goto L14;
        return -1;
    L14:
        return r0;
    }

    private final void b(long r10) {
        kotlinx.coroutines.flow.internal.a r0 = (kotlinx.coroutines.flow.internal.a) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.flow.internal.a.class, "com.obric.memorydata.plugin");
        if (kotlinx.coroutines.flow.internal.a.a(r0) == 0) goto L16;
        kotlinx.coroutines.flow.internal.c[] r1 = kotlinx.coroutines.flow.internal.a.b(r0);
        if (r1 == null) goto L16;
        int r2 = 0;
        int r3 = r1.length;
    L7:
        if (r2 >= r3) goto L16;
        kotlinx.coroutines.flow.internal.c r4 = r1[r2];
        if (r4 == null) goto L15;
        al r5 = (al) ZeusTransformUtils.preCheckCast(r4, al.class, "com.obric.memorydata.plugin");
        if (r5.f17418a < 0) goto L15;
        if (r5.f17418a >= r10) goto L15;
        r5.f17418a = r10;
    L15:
        r2 = r2 + 1;
    L16:
        this.f = r10;
    }

    private final boolean b(T r15) {
        if (i() != 0) goto L7;
        return c(r15);
    L7:
        if (this.g >= this.f17413b) goto L9;
    L18:
        d(r15);
        int r16 = this.g + 1;
        this.g = r16;
        if (r16 <= this.f17413b) goto L22;
        o();
    L22:
        if (k() <= this.f17412a) goto L24;
        a(this.e + 1, this.f, m(), n());
    L24:
        return true;
    L9:
        if (this.f > this.e) goto L18;
        BufferOverflow r0 = this.c;
        int r1 = b.f17416a[r0.ordinal()];
        if (r1 != 1) goto L13;
        return false;
    L13:
        if (r1 != 2) goto L18;
        return true;
    }

    public static final /* synthetic */ boolean b(aj r0, Object r1) {
        return r0.b(r1);
    }

    private final long c() {
        return Math.min(this.f, this.e);
    }

    public static final /* synthetic */ long c(aj r2) {
        return r2.c();
    }

    private final Object c(long r1) {
        Object[] r0 = this.d;
        Intrinsics.checkNotNull(r0);
        Object r2 = ak.a(r0, r1);
        if (ZeusTransformUtils.instanceOf(r2, a.class) == true) goto L5;
        return r2;
    L5:
        return ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).c;
    }

    private final boolean c(T r7) {
        if (kotlinx.coroutines.an.a() == false) goto L13;
        if (i() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (this.f17412a != 0) goto L15;
        return true;
    L15:
        d(r7);
        int r8 = this.g + 1;
        this.g = r8;
        if (r8 <= this.f17412a) goto L18;
        o();
    L18:
        this.f = c() + ((long) this.g);
        return true;
    }

    public static final /* synthetic */ int d(aj r0) {
        return r0.l();
    }

    private final void d(Object r7) {
        int r0 = l();
        Object[] r1 = this.d;
        if (r1 != null) goto L6;
        r1 = a(null, 0, 2);
    L8:
        ak.a(r1, c() + ((long) r0), r7);
        return;
    L6:
        if (r0 < r1.length) goto L8;
        r1 = a(r1, r0, r1.length * 2);
        goto L8
    }

    private final int k() {
        return (int) ((c() + ((long) this.g)) - this.e);
    }

    private final int l() {
        return this.g + this.h;
    }

    private final long m() {
        return c() + ((long) this.g);
    }

    private final long n() {
        return (c() + ((long) this.g)) + ((long) this.h);
    }

    private final void o() {
        Object[] r0 = this.d;
        Intrinsics.checkNotNull(r0);
        ak.a(r0, c(), null);
        this.g--;
        long r1 = c() + 1;
        if (this.e >= r1) goto L6;
        this.e = r1;
    L6:
        if (this.f >= r1) goto L9;
        b(r1);
    L9:
        if (kotlinx.coroutines.an.a() == true) goto L11;
        return;
    L11:
        if (c() != r1) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        return;
    L17:
        throw new AssertionError();
    L13:
        r4 = false;
        goto L14
    }

    private final void p() {
        if (this.f17413b == 0) goto L5;
    L7:
        Object[] r0 = this.d;
        Intrinsics.checkNotNull(r0);
    L9:
        if (this.h <= 0) goto L13;
        if (ak.a(r0, (c() + ((long) l())) - 1) != ak.f17417a) goto L16;
        this.h--;
        ak.a(r0, c() + ((long) l()), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.h > 1) goto L7;
    }

    @Override // kotlinx.coroutines.flow.ad
    public boolean a(T r5) {
        Continuation<Unit>[] r0 = kotlinx.coroutines.flow.internal.b.f17452a;
        monitor-enter(this);
        int r1 = 0;
        if (b(r5) == false) goto L8;
        r0 = a(r0);     // Catch: Throwable -> L17
        boolean r6 = true;
    L9:
        monitor-exit(this);
        int r4 = r0.length;
    L11:
        if (r1 >= r4) goto L16;
        Continuation<Unit> r2 = r0[r1];
        if (r2 == null) goto L15;
        Result.Companion r3 = Result.Companion;
        r2.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));
    L15:
        r1 = r1 + 1;
        goto L11
    L16:
        return r6;
    L8:
        r6 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final Continuation<Unit>[] a(long r24) {
        if (kotlinx.coroutines.an.a() == false) goto L13;
        if (r24 < this.f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (r24 > this.f) goto L15;
        long r1 = c();
        long r2 = ((long) this.g) + r1;
        if (this.f17413b == 0) goto L19;
    L21:
        kotlinx.coroutines.flow.internal.a r4 = (kotlinx.coroutines.flow.internal.a) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.flow.internal.a.class, "com.obric.memorydata.plugin");
        if (kotlinx.coroutines.flow.internal.a.a(r4) == 0) goto L36;
        kotlinx.coroutines.flow.internal.c[] r5 = kotlinx.coroutines.flow.internal.a.b(r4);
        if (r5 == null) goto L36;
        int r8 = r5.length;
        int r12 = 0;
    L26:
        if (r12 >= r8) goto L36;
        kotlinx.coroutines.flow.internal.c r13 = r5[r12];
        if (r13 == null) goto L34;
        al r14 = (al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin");
        if (r14.f17418a < 0) goto L34;
        if (r14.f17418a >= r2) goto L34;
        r2 = r14.f17418a;
    L34:
        r12 = r12 + 1;
    L36:
        if (kotlinx.coroutines.an.a() == false) goto L46;
        if (r2 < this.f) goto L40;
        boolean r6 = true;
    L41:
        if (r6 == true) goto L46;
        throw new AssertionError();
    L40:
        r6 = false;
    L46:
        if (r2 <= this.f) goto L48;
        long r15 = m();
        if (i() <= 0) goto L52;
        int r7 = Math.min(this.h, this.f17413b - ((int) (r15 - r2)));
    L53:
        Continuation<Unit>[] r9 = kotlinx.coroutines.flow.internal.b.f17452a;
        long r16 = ((long) this.h) + r15;
        if (r7 <= 0) goto L67;
        r9 = new Continuation[r7];
        Object[] r10 = this.d;
        Intrinsics.checkNotNull(r10);
        long r11 = r15;
        int r17 = 0;
    L57:
        if (r15 >= r16) goto L65;
        Object r18 = ak.a(r10, r15);
        long r19 = r2;
        if (r18 == ak.f17417a) goto L63;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        a r3 = (a) ZeusTransformUtils.preCheckCast(r18, a.class, "com.obric.memorydata.plugin");
        int r20 = r17 + 1;
        r9[r17] = ((a) ZeusTransformUtils.preCheckCast(r18, a.class, "com.obric.memorydata.plugin")).d;
        ak.a(r10, r15, ak.f17417a);
        ak.a(r10, r11, ((a) ZeusTransformUtils.preCheckCast(r18, a.class, "com.obric.memorydata.plugin")).c);
        long r21 = 1;
        r11 = r11 + 1;
        if (r20 >= r7) goto L66;
        r17 = r20;
    L64:
        r15 = r15 + r21;
        r2 = r19;
    L66:
        r15 = r11;
    L68:
        Continuation<Unit>[] r110 = r9;
        int r22 = (int) (r15 - r1);
        if (i() != 0) goto L71;
        long r23 = r15;
    L72:
        long r25 = Math.max(this.e, r15 - ((long) Math.min(this.f17412a, r22)));
        if (this.f17413b == 0) goto L75;
    L79:
        a(r25, r23, r15, r16);
        p();
        if (r110.length != 0) goto L82;
        boolean r111 = true;
    L84:
        if ((!r111) == true) goto L86;
        return r110;
    L86:
        return a(r110);
    L82:
        r111 = false;
        goto L84
    L75:
        if (r25 >= r16) goto L79;
        Object[] r26 = this.d;
        Intrinsics.checkNotNull(r26);
        if (Intrinsics.areEqual(ak.a(r26, r25), ak.f17417a) == false) goto L79;
        r15 = r15 + 1;
        r25 = r25 + 1;
        goto L79
    L71:
        r23 = r19;
        goto L72
    L63:
        r21 = 1;
        goto L64
    L65:
        r19 = r2;
        goto L66
    L67:
        r19 = r2;
        goto L68
    L52:
        r7 = this.h;
        goto L53
    L48:
        return kotlinx.coroutines.flow.internal.b.f17452a;
    L19:
        if (this.h <= 0) goto L21;
        r2 = r2 + 1;
        goto L21
    L15:
        return kotlinx.coroutines.flow.internal.b.f17452a;
    }

    public al[] a(int r1) {
        return new al[r1];
    }

    @Override // kotlinx.coroutines.flow.internal.p
    public i<T> a_(CoroutineContext r3, int r4, BufferOverflow r5) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        return ak.a((ai) ZeusTransformUtils.preCheckCast(this, ai.class, "com.obric.memorydata.plugin"), r6, r4, r5);
    }

    @Override // kotlinx.coroutines.flow.ad
    public void b() {
        monitor-enter(this);
        a(m(), this.f, m(), n());     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* synthetic */ kotlinx.coroutines.flow.internal.c[] b(int r2) {
        return (kotlinx.coroutines.flow.internal.c[]) ZeusTransformUtils.preCheckCast(a(r2), kotlinx.coroutines.flow.internal.c[].class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.flow.ai, kotlinx.coroutines.flow.i
    public Object collect(j<? super T> r3, Continuation<?> r4) {
        return a(this, (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final T d() {
        Object[] r0 = this.d;
        Intrinsics.checkNotNull(r0);
        return (T) ak.a(r0, (this.e + ((long) k())) - 1);
    }

    public final long e() {
        long r0 = this.e;
        if (r0 >= this.f) goto L5;
        this.f = r0;
    L5:
        return r0;
    }

    @Override // kotlinx.coroutines.flow.ad, kotlinx.coroutines.flow.j
    public Object emit(T r3, Continuation<? super Unit> r4) {
        return a(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public al f() {
        return new al();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* synthetic */ kotlinx.coroutines.flow.internal.c g() {
        return (kotlinx.coroutines.flow.internal.c) ZeusTransformUtils.preCheckCast(f(), kotlinx.coroutines.flow.internal.c.class, "com.obric.memorydata.plugin");
    }
}
