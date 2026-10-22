package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.am;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000245B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0010¢\u0006\u0002\b\"J\u0012\u0010#\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001e\u0010&\u001a\u00020'2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010)\u001a\u0004\u0018\u00010\rH\u0014J\u0016\u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0002J\u0016\u0010,\u001a\u00020'2\u0006\u0010)\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020/H\u0016J#\u00100\u001a\b\u0012\u0004\u0012\u00020'012\u0006\u0010)\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u0004\u0018\u00018\u00008F¢\u0006\f\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "(I)V", "getCapacity", "()I", "isClosedForSend", "", "()Z", "lastConflatedElement", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "onSendInternalResult", "Ljava/util/HashMap;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/collections/HashMap;", "subscribers", "", EventBody.KEY_VALUE, "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull$annotations", "getValueOrNull", "cancelImpl", "cause", "", "cancelImpl$kotlinx_coroutines_core", IslandSession.REOPEN_VALUE_CLOSE, "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "registerSelectForSend", "", "select", "element", "removeSubscriber", "s", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class d<E> extends g<E> implements c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17274a;
    private final ReentrantLock d;
    private List<? extends g<E>> e;
    private Object f;
    private final HashMap<kotlinx.coroutines.selects.m<?>, Object> g;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class a extends g<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d<E> f17275a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(d r3) {
            this.f17275a = r3;
            super(r3.b(), null, 2, 0 == true ? 1 : 0);
        }

        @Override // kotlinx.coroutines.channels.g
        public /* synthetic */ boolean a(Throwable r1) {
            return b(r1);
        }

        public boolean b(Throwable r5) {
            ReentrantLock r0 = d.a(this.f17275a);
            d<E> r1 = this.f17275a;
            Lock r2 = (Lock) ZeusTransformUtils.preCheckCast(r0, Lock.class, "com.obric.memorydata.plugin");
            r2.lock();
            d.a(r1, (y) ZeusTransformUtils.preCheckCast(this, y.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
            boolean r4 = super.a(r5);     // Catch: Throwable -> L6
            r2.unlock();
            return r4;
        L6:
            th = move-exception;
            r2.unlock();
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class b extends s<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d<E> f17276a;

        public b(d r7) {
            this.f17276a = r7;
            int r1 = 1;
            super(r1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.g
        public /* synthetic */ boolean a(Throwable r1) {
            return b(r1);
        }

        public boolean b(Throwable r4) {
            d.a(this.f17276a, (y) ZeusTransformUtils.preCheckCast(this, y.class, "com.obric.memorydata.plugin"));
            return super.a(r4);
        }
    }

    public static final /* synthetic */ ReentrantLock a(d r0) {
        return r0.d;
    }

    public static final /* synthetic */ void a(d r2, y r3) {
        r2.a((y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(y<? extends E> r7) {
        y r8 = (y) ZeusTransformUtils.wrapperContextForParams(r7, y.class, "com.obric.memorydata.plugin");
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L15
    L5:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();     // Catch: Throwable -> L15
        if (((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin")) == r8) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L5;
        r3.add(r5);     // Catch: Throwable -> L15
        goto L5
    L9:
        r6 = false;
        goto L10
    L12:
        this.e = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r0.unlock();
        return;
    L15:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static final /* synthetic */ HashMap b(d r0) {
        return r0.g;
    }

    @Override // kotlinx.coroutines.channels.c
    public y<E> a() {
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
    L21:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (this.f17274a != (-1)) goto L7;
        Object r1 = ZeusTransformUtils.preCheckCast(new b(this), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
    L6:
        g r2 = (g) r1;     // Catch: Throwable -> L21
        if (isClosedForSend() == false) goto L16;
        if (this.f != e.a()) goto L16;
        r2.close(m());     // Catch: Throwable -> L21
        y<E> r5 = (y) ZeusTransformUtils.preCheckCast(r2, y.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r0.unlock();
        return r5;
    L16:
        if (this.f == e.a()) goto L18;
        r2.mo54trySendJP2dKIU(c());     // Catch: Throwable -> L21
    L18:
        this.e = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin"), r2);     // Catch: Throwable -> L21
        r0.unlock();
        return (y) ZeusTransformUtils.preCheckCast(r2, y.class, "com.obric.memorydata.plugin");
    L7:
        r1 = ZeusTransformUtils.preCheckCast(new a(this), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        goto L6
    }

    @Override // kotlinx.coroutines.channels.g
    public void a(kotlinx.coroutines.selects.m<?> r9, Object r10) {
        kotlinx.coroutines.selects.m r11 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
        Object r2 = this.g.remove(r11);     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        r11.a(r2);     // Catch: Throwable -> L11
        r0.unlock();
        return;
    L8:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r0.unlock();
        kotlinx.coroutines.i.a(am.a(r11.getContext()), null, CoroutineStart.UNDISPATCHED, (Function2) ZeusTransformUtils.preCheckCast(new BroadcastChannelImpl$registerSelectForSend$2(this, r10, r11, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.g
    public boolean a(Throwable r6) {
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L7;
        ((g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.memorydata.plugin")).a(r6);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f = e.a();     // Catch: Throwable -> L10
        boolean r5 = super.a(r6);     // Catch: Throwable -> L10
        r0.unlock();
        return r5;
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final int b() {
        return this.f17274a;
    }

    public final E c() {
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
    L16:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (isClosedForSend() == false) goto L10;
        Throwable r3 = m();     // Catch: Throwable -> L16
        if (r3 == null) goto L8;
        throw r3;     // Catch: Throwable -> L16
    L8:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("This broadcast channel is closed"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
    L10:
        if (this.f == e.a()) goto L15;
        E r4 = (E) this.f;
        r0.unlock();
        return r4;
    L15:
        throw new IllegalStateException("No value".toString());     // Catch: Throwable -> L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.g, kotlinx.coroutines.channels.z
    public boolean close(Throwable r7) {
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L16
    L5:
        if (r1.hasNext() == false) goto L7;
        ((g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.memorydata.plugin")).close(r7);     // Catch: Throwable -> L16
        goto L5
    L7:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L16
    L9:
        if (r4.hasNext() == false) goto L13;
        Object r5 = r4.next();     // Catch: Throwable -> L16
        if (((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin")).r() == false) goto L9;
        r3.add(r5);     // Catch: Throwable -> L16
        goto L9
    L13:
        this.e = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        boolean r6 = super.close(r7);     // Catch: Throwable -> L16
        r0.unlock();
        return r6;
    L16:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.g, kotlinx.coroutines.channels.z
    public boolean isClosedForSend() {
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
        boolean r3 = super.isClosedForSend();     // Catch: Throwable -> L6
        r0.unlock();
        return r3;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b3 -> B:12:0x0055). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.g, kotlinx.coroutines.channels.z
    public Object send(E r8, Continuation<? super Unit> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, BroadcastChannelImpl$send$1.class) == false) goto L7;
        BroadcastChannelImpl$send$1 r0 = (BroadcastChannelImpl$send$1) ZeusTransformUtils.preCheckCast(r10, BroadcastChannelImpl$send$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$2, Iterator.class, "com.obric.memorydata.plugin");
        Object r12 = r0.L$1;
        d<E> r4 = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        BroadcastChannelImpl$send$1 r6 = r0;
        Object r1 = r12;
        d<E> r13 = r4;
    L12:
        Object r5 = r2;
        BroadcastChannelImpl$send$1 r14 = r6;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L32;
    L36:
        Object r15 = r1;
        r0 = r14;
        r2 = r5;
    L24:
        if (r7.hasNext() == false) goto L38;
        g r16 = (g) ZeusTransformUtils.preCheckCast(r7.next(), g.class, "com.obric.memorydata.plugin");
        r0.L$0 = r13;
        r0.L$1 = r15;
        r0.L$2 = r7;
        r0.label = 1;
        Object r17 = r16.a(r15, r0);
        if (r17 != r2) goto L28;
        return r2;
    L28:
        r6 = r0;
        r1 = r15;
        r11 = r17;
        goto L12
    L38:
        return Unit.INSTANCE;
    L32:
        if (r13.isClosedForSend() == false) goto L36;
        throw r13.n();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        Lock r18 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r18.lock();
    L41:
        th = move-exception;
        r18.unlock();
        throw th;
    L17:
        if (isClosedForSend() == true) goto L40;
        if (this.f17274a != (-1)) goto L21;
        this.f = r8;     // Catch: Throwable -> L41
    L21:
        List<? extends g<E>> r19 = this.e;     // Catch: Throwable -> L41
        r18.unlock();
        r13 = this;
        r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r15 = r8;
        goto L24
    L40:
        throw n();     // Catch: Throwable -> L41
    L7:
        r0 = new BroadcastChannelImpl$send$1(this, r10);
        goto L8
    }

    @Override // kotlinx.coroutines.channels.g
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f == e.a()) goto L5;
        String r1 = "CONFLATED_ELEMENT=" + this.f + "; ";
    L7:
        return r0.append(r1).append("BROADCAST=<").append(super.toString()).append(">; SUBSCRIBERS=").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(";", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("<", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(">", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null)).toString();
    L5:
        r1 = "";
        goto L7
    }

    @Override // kotlinx.coroutines.channels.g, kotlinx.coroutines.channels.z
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo54trySendJP2dKIU(E r7) {
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.d, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
    L33:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (isClosedForSend() == false) goto L8;
        Object r6 = super.mo54trySendJP2dKIU(r7);     // Catch: Throwable -> L33
        r0.unlock();
        return r6;
    L8:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L11;
    L13:
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L33
    L15:
        if (r2.hasNext() == false) goto L19;
        if (((g) ZeusTransformUtils.preCheckCast(r2.next(), g.class, "com.obric.memorydata.plugin")).f() == false) goto L15;
        r4 = true;
    L19:
        if (r4 == false) goto L24;
        Object r8 = m.f17289a.a();     // Catch: Throwable -> L33
        r0.unlock();
        return r8;
    L24:
        if (this.f17274a != (-1)) goto L26;
        this.f = r7;     // Catch: Throwable -> L33
    L26:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L33
    L28:
        if (r9.hasNext() == false) goto L30;
        ((g) ZeusTransformUtils.preCheckCast(r9.next(), g.class, "com.obric.memorydata.plugin")).mo54trySendJP2dKIU(r7);     // Catch: Throwable -> L33
        goto L28
    L30:
        Object r10 = m.f17289a.a(Unit.INSTANCE);     // Catch: Throwable -> L33
        r0.unlock();
        return r10;
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L13;
        goto L13
    }
}
