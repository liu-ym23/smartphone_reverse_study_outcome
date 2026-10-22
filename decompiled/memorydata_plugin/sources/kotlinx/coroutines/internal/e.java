package kotlinx.coroutines.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a8\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\tH\u0082\b\u001a!\u0010\r\u001a\u0002H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f*\u0002H\u000eH\u0000¢\u0006\u0002\u0010\u0010\u001as\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u001328\b\b\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0080\b\u001ag\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u00132\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0000¢\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u001f\u001a\u0002H\u0013H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "POINTERS_SHIFT", "", "addConditionally", "", "Lkotlinx/atomicfu/AtomicInt;", "delta", "condition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cur", IslandSession.REOPEN_VALUE_CLOSE, "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "findSegmentAndMoveForward", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "Lkotlinx/atomicfu/AtomicRef;", OaidModel.KEY_ID, "", "startFrom", "createNewSegment", "Lkotlin/Function2;", "prev", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", TypedValues.TransitionType.S_TO, "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final aj f17579a = null;

    static {
        f17579a = new aj("CLOSED");
    }

    public static final <S extends ag<S>> Object a(S r6, long r7, Function2<? super Long, ? super S, ? extends S> r9) {
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
    L4:
        if (r6.f17558a >= r7) goto L6;
    L10:
        Object r0 = f.b((f) ZeusTransformUtils.preCheckCast(r6, f.class, "com.obric.memorydata.plugin"));
        if (r0 == a()) goto L13;
        ag r1 = (ag) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin"), ag.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L16;
        r1 = (ag) ZeusTransformUtils.preCheckCast(r10.invoke(Long.valueOf(r6.f17558a + 1), r6), ag.class, "com.obric.memorydata.plugin");
        if (r6.a((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.memorydata.plugin")) == false) goto L4;
        if (r6.h() == false) goto L16;
        r6.i();
    L16:
        r6 = (S) r1;
        goto L4
    L13:
        return ah.e(f17579a);
    L6:
        if (r6.h() == true) goto L10;
        return ah.e(r6);
    }

    public static final /* synthetic */ aj a() {
        return f17579a;
    }

    public static final <N extends f<N>> N a(N r3) {
    L2:
        Object r0 = f.b(r3);
        if (r0 == a()) goto L4;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        r3 = (N) r1;
        goto L2
    L8:
        if (r3.g() == false) goto L2;
        return r3;
    L4:
        return r3;
    }
}
