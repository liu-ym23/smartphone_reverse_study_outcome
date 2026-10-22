package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001c\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\fH¤@¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH$J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H\u0016J&\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u001c\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R6\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "additionalToStringProps", "", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class d<T> implements p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f17453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17454b;
    public final BufferOverflow c;

    public d(CoroutineContext r3, int r4, BufferOverflow r5) {
        this.f17453a = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        this.f17454b = r4;
        this.c = r5;
        if (an.a() == true) goto L5;
        return;
    L5:
        if (r4 == (-1)) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        return;
    L11:
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    static /* synthetic */ <T> Object a(d<T> r3, kotlinx.coroutines.flow.j<? super T> r4, Continuation<? super Unit> r5) {
        kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r8 = am.a((Function2) ZeusTransformUtils.preCheckCast(new ChannelFlow$collect$2(r6, r3, null), Function2.class, "com.obric.memorydata.plugin"), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public abstract Object a(kotlinx.coroutines.channels.w<? super T> r1, Continuation<? super Unit> r2);

    public kotlinx.coroutines.channels.y<T> a(al r10) {
        return kotlinx.coroutines.channels.u.a((al) ZeusTransformUtils.wrapperContextForParams(r10, al.class, "com.obric.memorydata.plugin"), this.f17453a, d(), this.c, CoroutineStart.ATOMIC, null, c(), 16, null);
    }

    public kotlinx.coroutines.flow.i<T> a() {
        return null;
    }

    public abstract d<T> a(CoroutineContext r1, int r2, BufferOverflow r3);

    @Override // kotlinx.coroutines.flow.internal.p
    public kotlinx.coroutines.flow.i<T> a_(CoroutineContext r5, int r6, BufferOverflow r7) {
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (an.a() == true) goto L5;
    L12:
        CoroutineContext r9 = r8.plus(this.f17453a);
        if (r7 != BufferOverflow.SUSPEND) goto L50;
        int r10 = this.f17454b;
        if (r10 == (-3)) goto L48;
        if (r6 != (-3)) goto L21;
    L19:
        r6 = r10;
        goto L48
    L21:
        if (r10 == (-2)) goto L48;
        if (r6 == (-2)) goto L19;
        if (an.a() == false) goto L36;
        if (this.f17454b < 0) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == true) goto L36;
        throw new AssertionError();
    L30:
        r11 = false;
    L36:
        if (an.a() == false) goto L44;
        if (r6 >= 0) goto L40;
        r2 = false;
    L40:
        if (r2 == true) goto L44;
        throw new AssertionError();
    L44:
        r10 = this.f17454b + r6;
        if (r10 >= 0) goto L19;
        r6 = Integer.MAX_VALUE;
    L48:
        r7 = this.c;
    L50:
        if (Intrinsics.areEqual(r9, this.f17453a) == true) goto L52;
    L57:
        d<T> this = a(r9, r6, r7);
    L56:
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    L52:
        if (r6 != this.f17454b) goto L57;
        if (r7 != this.c) goto L57;
    L5:
        if (r6 == (-1)) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    public String b() {
        return null;
    }

    public final Function2<kotlinx.coroutines.channels.w<? super T>, Continuation<? super Unit>, Object> c() {
        return (Function2) ZeusTransformUtils.preCheckCast(new ChannelFlow$collectToFun$1(this, null), Function2.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.flow.i
    public Object collect(kotlinx.coroutines.flow.j<? super T> r3, Continuation<? super Unit> r4) {
        return a(this, (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final int d() {
        int r1 = this.f17454b;
        if (r1 != (-3)) goto L6;
        return -2;
    L6:
        return r1;
    }

    public String toString() {
        ArrayList r0 = new ArrayList(4);
        String r1 = b();
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        if (this.f17453a == EmptyCoroutineContext.INSTANCE) goto L9;
        r0.add("context=" + this.f17453a);
    L9:
        if (this.f17454b == (-3)) goto L12;
        r0.add("capacity=" + this.f17454b);
    L12:
        if (this.c == BufferOverflow.SUSPEND) goto L15;
        r0.add("onBufferOverflow=" + this.c);
    L15:
        return ao.b(this) + '[' + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ']';
    }
}
