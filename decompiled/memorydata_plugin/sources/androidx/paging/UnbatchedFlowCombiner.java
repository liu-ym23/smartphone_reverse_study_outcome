package androidx.paging;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003Be\u0012[\u0010\u0004\u001aW\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ#\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000Rh\u0010\u0004\u001aW\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0013R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/paging/UnbatchedFlowCombiner;", "T1", "T2", "", "send", "Lkotlin/Function4;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "t1", "t2", "Landroidx/paging/CombineSource;", "updateFrom", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function4;)V", "initialDispatched", "Lkotlinx/coroutines/CompletableDeferred;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/jvm/functions/Function4;", "valueReceived", "", "[Lkotlinx/coroutines/CompletableDeferred;", "values", "[Ljava/lang/Object;", "onNext", "index", "", EventBody.KEY_VALUE, "(ILjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UnbatchedFlowCombiner<T1, T2> {
    private final w<Unit> initialDispatched;
    private final a lock;
    private final Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> send;
    private final w<Unit>[] valueReceived;
    private final Object[] values;

    /* JADX INFO: renamed from: androidx.paging.UnbatchedFlowCombiner$onNext$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.UnbatchedFlowCombiner", f = "FlowExt.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {191, 230, 208}, m = "onNext", n = {"this", EventBody.KEY_VALUE, "index", "this", EventBody.KEY_VALUE, "$this$withLock_u24default$iv", "index", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ UnbatchedFlowCombiner<T1, T2> this$0;

        AnonymousClass1(UnbatchedFlowCombiner<T1, T2> r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onNext(0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    public UnbatchedFlowCombiner(Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super Unit>, ? extends Object> r7) {
        Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> r8 = (Function4) ZeusTransformUtils.wrapperContextForParams(r7, Function4.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "send");
        this.send = r8;
        this.initialDispatched = y.a(null, 1, null);
        int r1 = 0;
        this.lock = c.a(false, 1, null);
        w<Unit>[] r3 = new w[2];
        int r4 = 0;
    L3:
        if (r4 >= 2) goto L5;
        r3[r4] = y.a(null, 1, null);
        r4 = r4 + 1;
        goto L3
    L5:
        this.valueReceived = r3;
        Object[] r9 = new Object[2];
    L6:
        if (r1 >= 2) goto L8;
        r9[r1] = FlowExtKt.access$getNULL$p();
        r1 = r1 + 1;
        goto L6
    L8:
        this.values = r9;
    }

    public final Object onNext(int r13, Object r14, Continuation<? super Unit> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r16, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L20;
        if (r4 != 3) goto L19;
        a r12 = (a) ZeusTransformUtils.preCheckCast(r1.L$1, a.class, "com.obric.memorydata.plugin");
        UnbatchedFlowCombiner<T1, T2> r18 = (UnbatchedFlowCombiner) ZeusTransformUtils.preCheckCast(r1.L$0, UnbatchedFlowCombiner.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L16
    L62:
        r18.initialDispatched.a(Unit.INSTANCE);     // Catch: Throwable -> L16
    L64:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r12.b(null);
        return Unit.INSTANCE;
    L16:
        Throwable th = th;
    L69:
        r12.b(null);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        int r110 = r1.I$0;
        a r111 = (a) ZeusTransformUtils.preCheckCast(r1.L$2, a.class, "com.obric.memorydata.plugin");
        r14 = r1.L$1;
        UnbatchedFlowCombiner<T1, T2> r0 = (UnbatchedFlowCombiner) ZeusTransformUtils.preCheckCast(r1.L$0, UnbatchedFlowCombiner.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L73:
        Object[] r112 = r0.values;     // Catch: Throwable -> L67
        int r2 = r112.length;     // Catch: Throwable -> L67
        int r6 = 0;
    L33:
        if (r6 >= r2) goto L41;
        if (r112[r6] != FlowExtKt.access$getNULL$p()) goto L37;
        boolean r9 = true;
    L38:
        if (r9 == true) goto L39;
        r6 = r6 + 1;     // Catch: Throwable -> L67
        goto L33
    L39:
        boolean r113 = true;
    L42:
        Object[] r5 = r0.values;     // Catch: Throwable -> L67
        r5[r110] = r14;     // Catch: Throwable -> L67
        int r114 = r5.length;     // Catch: Throwable -> L67
        int r7 = 0;
    L43:
        if (r7 >= r114) goto L51;
        if (r5[r7] != FlowExtKt.access$getNULL$p()) goto L47;
        boolean r10 = true;
    L48:
        if (r10 == true) goto L49;
        r7 = r7 + 1;     // Catch: Throwable -> L67
        goto L43
    L49:
        boolean r115 = false;
    L52:
        if (r115 == false) goto L63;
        if (r113 == false) goto L55;
        CombineSource r116 = CombineSource.INITIAL;     // Catch: Throwable -> L67
    L58:
        Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> r117 = r0.send;     // Catch: Throwable -> L67
        Object[] r118 = r0.values;     // Catch: Throwable -> L67
        Object r8 = r118[0];     // Catch: Throwable -> L67
        Object r119 = r118[1];     // Catch: Throwable -> L67
        r1.L$0 = r0;     // Catch: Throwable -> L67
        r1.L$1 = r111;     // Catch: Throwable -> L67
        r1.L$2 = null;     // Catch: Throwable -> L67
        r1.label = 3;     // Catch: Throwable -> L67
        if (r117.invoke((T1) r8, (T2) r119, r116, r1) != r3) goto L61;
        return r3;
    L61:
        r12 = r111;
        r18 = r0;
        goto L62
    L55:
        if (r110 != 0) goto L57;
        r116 = CombineSource.RECEIVER;     // Catch: Throwable -> L67
        goto L58
    L57:
        r116 = CombineSource.OTHER;     // Catch: Throwable -> L67
        goto L58
    L63:
        r12 = r111;
        goto L64
    L47:
        r10 = false;
        goto L48
    L51:
        r115 = true;
        goto L52
    L37:
        r9 = false;
        goto L38
    L41:
        r113 = false;
    L67:
        th = move-exception;
        a r11 = r111;
        th = th;
        r12 = r11;
        goto L69
    L21:
        int r120 = r1.I$0;
        Object r121 = r1.L$1;
        UnbatchedFlowCombiner<T1, T2> r122 = (UnbatchedFlowCombiner) ZeusTransformUtils.preCheckCast(r1.L$0, UnbatchedFlowCombiner.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
        r13 = r120;
        UnbatchedFlowCombiner<T1, T2> this = r122;
        r14 = r121;
    L28:
        a r123 = this.lock;
        r1.L$0 = this;
        r1.L$1 = r14;
        r1.L$2 = r123;
        r1.I$0 = r13;
        r1.label = 2;
        if (r123.a(null, r1) != r3) goto L31;
        return r3;
    L31:
        r0 = this;
        r110 = r13;
        r111 = r123;
        goto L73
    L22:
        ResultKt.throwOnFailure(r17);
        if (this.valueReceived[r13].q_() == false) goto L27;
        w<Unit> r124 = this.initialDispatched;
        r1.L$0 = this;
        r1.L$1 = r14;
        r1.I$0 = r13;
        r1.label = 1;
        if (r124.a(r1) != r3) goto L28;
        return r3;
    L27:
        this.valueReceived[r13].a(Unit.INSTANCE);
    L7:
        r1 = new AnonymousClass1(this, r16);
        goto L8
    }
}
