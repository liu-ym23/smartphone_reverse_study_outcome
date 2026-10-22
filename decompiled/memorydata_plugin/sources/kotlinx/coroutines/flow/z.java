package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\b\f\u001aM\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aA\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u001cH\u0002¢\u0006\u0002\b\u001d\u001aP\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012-\u0010\u001f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0006\u0012\u0004\u0018\u00010#0 ¢\u0006\u0002\b$¢\u0006\u0002\u0010%\u001a6\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a,\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010)\u001a9\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0002¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"asSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "asStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "configureSharing", "Lkotlinx/coroutines/flow/SharingConfig;", "Lkotlinx/coroutines/flow/Flow;", "replay", "", "configureSharing$FlowKt__ShareKt", "launchSharing", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "upstream", "shared", "started", "Lkotlinx/coroutines/flow/SharingStarted;", "initialValue", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "launchSharingDeferred", "", "result", "Lkotlinx/coroutines/CompletableDeferred;", "launchSharingDeferred$FlowKt__ShareKt", "onSubscription", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "shareIn", "scope", "stateIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class z {
    private static final <T> bx a(kotlinx.coroutines.al r8, CoroutineContext r9, i<? extends T> r10, ad<T> r11, an r12, T r13) {
        kotlinx.coroutines.al r14 = (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        CoroutineContext r15 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r9, CoroutineContext.class, "com.obric.memorydata.plugin");
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r10, i.class, "com.obric.memorydata.plugin");
        ad r5 = (ad) ZeusTransformUtils.wrapperContextForParams(r11, ad.class, "com.obric.memorydata.plugin");
        an r3 = (an) ZeusTransformUtils.wrapperContextForParams(r12, an.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3, an.f17422a.a()) == false) goto L5;
        CoroutineStart r16 = CoroutineStart.DEFAULT;
    L7:
        return kotlinx.coroutines.i.a(r14, r15, r16, (Function2) ZeusTransformUtils.preCheckCast(new FlowKt__ShareKt$launchSharing$1(r3, r4, r5, r13, null), Function2.class, "com.obric.memorydata.plugin"));
    L5:
        r16 = CoroutineStart.UNDISPATCHED;
        goto L7
    }

    public static final <T> ai<T> a(ad<T> r3) {
        return (ai) ZeusTransformUtils.preCheckCast(new af((ai) ZeusTransformUtils.preCheckCast((ad) ZeusTransformUtils.wrapperContextForParams(r3, ad.class, "com.obric.memorydata.plugin"), ai.class, "com.obric.memorydata.plugin"), null), ai.class, "com.obric.memorydata.plugin");
    }

    public static final <T> ai<T> a(ai<? extends T> r2, Function2<? super j<? super T>, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return (ai) ZeusTransformUtils.preCheckCast(new aw((ai) ZeusTransformUtils.wrapperContextForParams(r2, ai.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin")), ai.class, "com.obric.memorydata.plugin");
    }

    public static final <T> ai<T> a(i<? extends T> r8, kotlinx.coroutines.al r9, an r10, int r11) {
        i r12 = (i) ZeusTransformUtils.wrapperContextForParams(r8, i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.al r2 = (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        an r6 = (an) ZeusTransformUtils.wrapperContextForParams(r10, an.class, "com.obric.memorydata.plugin");
        am r13 = a(r12, r11);
        ad r14 = ak.a(r11, r13.f17421b, r13.c);
        bx r15 = a(r2, r13.d, r13.f17420a, r14, r6, ZeusTransformUtils.preCheckCast(ak.f17417a, Object.class, "com.obric.memorydata.plugin"));
        return (ai) ZeusTransformUtils.preCheckCast(new af((ai) ZeusTransformUtils.preCheckCast(r14, ai.class, "com.obric.memorydata.plugin"), r15), ai.class, "com.obric.memorydata.plugin");
    }

    private static final <T> am<T> a(i<? extends T> r8, int r9) {
        i r10 = (i) ZeusTransformUtils.wrapperContextForParams(r8, i.class, "com.obric.memorydata.plugin");
        int r2 = 1;
        if (kotlinx.coroutines.an.a() == false) goto L11;
        if (r9 < 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L11;
        throw new AssertionError();
    L6:
        r0 = false;
    L11:
        int r1 = RangesKt.coerceAtLeast(r9, kotlinx.coroutines.channels.i.c.a()) - r9;
        if (ZeusTransformUtils.instanceOf(r10, kotlinx.coroutines.flow.internal.d.class) == false) goto L33;
        i<T> r4 = ((kotlinx.coroutines.flow.internal.d) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.flow.internal.d.class, "com.obric.memorydata.plugin")).a();
        if (r4 == null) goto L33;
        int r6 = ((kotlinx.coroutines.flow.internal.d) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.flow.internal.d.class, "com.obric.memorydata.plugin")).f17454b;
        if (r6 == (-3)) goto L22;
        if (r6 == (-2)) goto L22;
        if (r6 == 0) goto L22;
        r2 = ((kotlinx.coroutines.flow.internal.d) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.flow.internal.d.class, "com.obric.memorydata.plugin")).f17454b;
    L31:
        return new am(r4, r2, ((kotlinx.coroutines.flow.internal.d) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.flow.internal.d.class, "com.obric.memorydata.plugin")).c, ((kotlinx.coroutines.flow.internal.d) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.flow.internal.d.class, "com.obric.memorydata.plugin")).f17453a);
    L22:
        if (((kotlinx.coroutines.flow.internal.d) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.flow.internal.d.class, "com.obric.memorydata.plugin")).c == BufferOverflow.SUSPEND) goto L24;
        if (r9 == 0) goto L31;
    L29:
        r2 = 0;
        goto L31
    L24:
        if (((kotlinx.coroutines.flow.internal.d) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.flow.internal.d.class, "com.obric.memorydata.plugin")).f17454b == 0) goto L29;
        r2 = r1;
    L33:
        return new am(r10, r1, BufferOverflow.SUSPEND, (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> ar<T> a(ae<T> r3) {
        return (ar) ZeusTransformUtils.preCheckCast(new ag((ar) ZeusTransformUtils.preCheckCast((ae) ZeusTransformUtils.wrapperContextForParams(r3, ae.class, "com.obric.memorydata.plugin"), ar.class, "com.obric.memorydata.plugin"), null), ar.class, "com.obric.memorydata.plugin");
    }

    public static final <T> ar<T> a(i<? extends T> r8, kotlinx.coroutines.al r9, an r10, T r11) {
        i r12 = (i) ZeusTransformUtils.wrapperContextForParams(r8, i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.al r2 = (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        an r6 = (an) ZeusTransformUtils.wrapperContextForParams(r10, an.class, "com.obric.memorydata.plugin");
        am r13 = a(r12, 1);
        ae r14 = at.a(r11);
        bx r15 = a(r2, r13.d, r13.f17420a, (ad) ZeusTransformUtils.preCheckCast(r14, ad.class, "com.obric.memorydata.plugin"), r6, r11);
        return (ar) ZeusTransformUtils.preCheckCast(new ag((ar) ZeusTransformUtils.preCheckCast(r14, ar.class, "com.obric.memorydata.plugin"), r15), ar.class, "com.obric.memorydata.plugin");
    }
}
