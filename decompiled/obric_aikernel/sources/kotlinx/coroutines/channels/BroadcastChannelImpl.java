package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n15#2:415\n15#2:416\n15#2:420\n15#2:423\n15#2:429\n15#2:430\n15#2:436\n15#2:439\n15#2:440\n15#2:441\n766#3:417\n857#3,2:418\n1855#3,2:421\n1747#3,3:424\n1855#3,2:427\n1855#3,2:431\n766#3:433\n857#3,2:434\n1855#3,2:437\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n166#1:415\n188#1:416\n213#1:420\n237#1:423\n279#1:429\n331#1:430\n343#1:436\n355#1:439\n382#1:440\n394#1:441\n189#1:417\n189#1:418,2\n226#1:421,2\n242#1:424,3\n251#1:427,2\n333#1:431,2\n338#1:433\n338#1:434,2\n346#1:437,2\n*E\n"})
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements kotlinx.coroutines.channels.b<E> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f10268r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ReentrantLock f10269s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<? extends BufferedChannel<E>> f10270t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Object f10271u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final HashMap<kotlinx.coroutines.selects.k<?>, Object> f10272v;

    @SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n*L\n1#1,414:1\n15#2:415\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n*L\n362#1:415\n*E\n"})
    private final class a extends BufferedChannel<E> {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final /* synthetic */ BroadcastChannelImpl<E> f10273r;

        /* JADX WARN: Multi-variable type inference failed */
        public a(BroadcastChannelImpl r10) {
            this.f10273r = r10;
            super(r10.k1(), null, 2, 0 == true ? 1 : 0);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        public /* bridge */ /* synthetic */ boolean I(Throwable r10) {
            return h1(r10);
        }

        public boolean h1(Throwable r10) {
            ReentrantLock r11 = BroadcastChannelImpl.h1(this.f10273r);
            BroadcastChannelImpl<E> r12 = this.f10273r;
            r11.lock();
            BroadcastChannelImpl.j1(r12, this);     // Catch: Throwable -> L6
            boolean r13 = super.I(r10);     // Catch: Throwable -> L6
            r11.unlock();
            return r13;
        L6:
            th = move-exception;
            r11.unlock();
            throw th;
        }
    }

    private final class b extends j<E> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ BroadcastChannelImpl<E> f10274t;

        public b(BroadcastChannelImpl r10) {
            this.f10274t = r10;
            int r11 = 1;
            super(r11, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        public /* bridge */ /* synthetic */ boolean I(Throwable r10) {
            return m1(r10);
        }

        public boolean m1(Throwable r10) {
            BroadcastChannelImpl.j1(this.f10274t, this);
            return super.I(r10);
        }
    }

    public static final /* synthetic */ ReentrantLock h1(BroadcastChannelImpl r10) {
        return r10.f10269s;
    }

    public static final /* synthetic */ HashMap i1(BroadcastChannelImpl r10) {
        return r10.f10272v;
    }

    public static final /* synthetic */ void j1(BroadcastChannelImpl r10, ReceiveChannel r11) {
        r10.m1(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m1(ReceiveChannel<? extends E> r10) {
        ReentrantLock r11 = this.f10269s;
        r11.lock();
        List<? extends BufferedChannel<E>> r12 = this.f10270t;     // Catch: Throwable -> L15
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<T> r14 = r12.iterator();     // Catch: Throwable -> L15
    L5:
        if (r14.hasNext() == false) goto L12;
        Object r15 = r14.next();     // Catch: Throwable -> L15
        if (((BufferedChannel) r15) == r10) goto L9;
        boolean r16 = true;
    L10:
        if (r16 == false) goto L5;
        r13.add(r15);     // Catch: Throwable -> L15
        goto L5
    L9:
        r16 = false;
        goto L10
    L12:
        this.f10270t = r13;     // Catch: Throwable -> L15
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r11.unlock();
        return;
    L15:
        th = move-exception;
        r11.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.n
    public Object E(E r10) {
        ReentrantLock r11 = this.f10269s;
        r11.lock();
    L33:
        th = move-exception;
        r11.unlock();
        throw th;
    L4:
        if (L() == false) goto L8;
        Object r12 = super.E(r10);     // Catch: Throwable -> L33
        r11.unlock();
        return r12;
    L8:
        List<? extends BufferedChannel<E>> r13 = this.f10270t;     // Catch: Throwable -> L33
        boolean r14 = false;
        if ((r13 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r15 = r13.iterator();     // Catch: Throwable -> L33
    L15:
        if (r15.hasNext() == false) goto L19;
        if (((BufferedChannel) r15.next()).V0() == false) goto L15;
        r14 = true;
    L19:
        if (r14 == false) goto L24;
        Object r16 = g.f10318b.b();     // Catch: Throwable -> L33
        r11.unlock();
        return r16;
    L24:
        if (this.f10268r != (-1)) goto L26;
        this.f10271u = r10;     // Catch: Throwable -> L33
    L26:
        Iterator<T> r17 = this.f10270t.iterator();     // Catch: Throwable -> L33
    L28:
        if (r17.hasNext() == false) goto L30;
        ((BufferedChannel) r17.next()).E(r10);     // Catch: Throwable -> L33
        goto L28
    L30:
        Object r18 = g.f10318b.c(Unit.INSTANCE);     // Catch: Throwable -> L33
        r11.unlock();
        return r18;
    L11:
        if (r13.isEmpty() == false) goto L13;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x007d -> B:12:0x0035). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.n
    public Object H(E r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof BroadcastChannelImpl$send$1) == false) goto L7;
        BroadcastChannelImpl$send$1 r12 = (BroadcastChannelImpl$send$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L15;
        if (r16 != 1) goto L14;
        Iterator r17 = (Iterator) r12.L$2;
        Object r18 = r12.L$1;
        BroadcastChannelImpl<E> r19 = (BroadcastChannelImpl) r12.L$0;
        ResultKt.throwOnFailure(r14);
        BroadcastChannelImpl$send$1 r20 = r12;
        Object r21 = r18;
        BroadcastChannelImpl<E> r22 = r19;
    L12:
        Object r23 = r15;
        BroadcastChannelImpl$send$1 r24 = r20;
        if (((Boolean) r14).booleanValue() == false) goto L32;
    L36:
        Object r25 = r21;
        r12 = r24;
        r15 = r23;
    L24:
        if (r17.hasNext() == false) goto L38;
        BufferedChannel r26 = (BufferedChannel) r17.next();
        r12.L$0 = r22;
        r12.L$1 = r25;
        r12.L$2 = r17;
        r12.label = 1;
        Object r27 = r26.R0(r25, r12);
        if (r27 != r15) goto L28;
        return r15;
    L28:
        r20 = r12;
        r21 = r25;
        r14 = r27;
        goto L12
    L38:
        return Unit.INSTANCE;
    L32:
        if (r22.L() == false) goto L36;
        throw r22.Z();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        ReentrantLock r28 = this.f10269s;
        r28.lock();
    L41:
        th = move-exception;
        r28.unlock();
        throw th;
    L17:
        if (L() == true) goto L40;
        if (this.f10268r != (-1)) goto L21;
        this.f10271u = r10;     // Catch: Throwable -> L41
    L21:
        List<? extends BufferedChannel<E>> r29 = this.f10270t;     // Catch: Throwable -> L41
        r28.unlock();
        r22 = this;
        r17 = r29.iterator();
        r25 = r10;
        goto L24
    L40:
        throw Z();     // Catch: Throwable -> L41
    L7:
        r12 = new BroadcastChannelImpl$send$1(this, r11);
        goto L8
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean I(Throwable r10) {
        ReentrantLock r11 = this.f10269s;
        r11.lock();
        Iterator<T> r12 = this.f10270t.iterator();     // Catch: Throwable -> L10
    L5:
        if (r12.hasNext() == false) goto L7;
        ((BufferedChannel) r12.next()).I(r10);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f10271u = c.a();     // Catch: Throwable -> L10
        boolean r13 = super.I(r10);     // Catch: Throwable -> L10
        r11.unlock();
        return r13;
    L10:
        th = move-exception;
        r11.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.n
    public boolean L() {
        ReentrantLock r10 = this.f10269s;
        r10.lock();
        boolean r11 = super.L();     // Catch: Throwable -> L6
        r10.unlock();
        return r11;
    L6:
        th = move-exception;
        r10.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void L0(kotlinx.coroutines.selects.k<?> r10, Object r11) {
        ReentrantLock r12 = this.f10269s;
        r12.lock();
        Object r13 = this.f10272v.remove(r10);     // Catch: Throwable -> L11
        if (r13 == null) goto L8;
        r10.f(r13);     // Catch: Throwable -> L11
        r12.unlock();
        return;
    L8:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r12.unlock();
        kotlinx.coroutines.h.d(m0.a(r10.getContext()), null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, r11, r10, null), 1, null);
        return;
    L11:
        th = move-exception;
        r12.unlock();
        throw th;
    }

    public final int k1() {
        return this.f10268r;
    }

    public final E l1() {
        ReentrantLock r10 = this.f10269s;
        r10.lock();
    L16:
        th = move-exception;
        r10.unlock();
        throw th;
    L4:
        if (L() == false) goto L10;
        Throwable r11 = W();     // Catch: Throwable -> L16
        if (r11 == null) goto L8;
        throw r11;     // Catch: Throwable -> L16
    L8:
        throw new IllegalStateException("This broadcast channel is closed");     // Catch: Throwable -> L16
    L10:
        if (this.f10271u == c.a()) goto L15;
        E r12 = (E) this.f10271u;
        r10.unlock();
        return r12;
    L15:
        throw new IllegalStateException("No value".toString());     // Catch: Throwable -> L16
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.f10271u == c.a()) goto L5;
        String r11 = "CONFLATED_ELEMENT=" + this.f10271u + "; ";
    L6:
        r10.append(r11);
        r10.append("BROADCAST=<");
        r10.append(super.toString());
        r10.append(">; SUBSCRIBERS=");
        r10.append(CollectionsKt.joinToString$default(this.f10270t, ";", "<", ">", 0, null, null, 56, null));
        return r10.toString();
    L5:
        r11 = "";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.n
    public boolean w(Throwable r10) {
        ReentrantLock r11 = this.f10269s;
        r11.lock();
        Iterator<T> r12 = this.f10270t.iterator();     // Catch: Throwable -> L16
    L5:
        if (r12.hasNext() == false) goto L7;
        ((BufferedChannel) r12.next()).w(r10);     // Catch: Throwable -> L16
        goto L5
    L7:
        List<? extends BufferedChannel<E>> r13 = this.f10270t;     // Catch: Throwable -> L16
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<T> r15 = r13.iterator();     // Catch: Throwable -> L16
    L9:
        if (r15.hasNext() == false) goto L13;
        Object r16 = r15.next();     // Catch: Throwable -> L16
        if (((BufferedChannel) r16).b0() == false) goto L9;
        r14.add(r16);     // Catch: Throwable -> L16
        goto L9
    L13:
        this.f10270t = r14;     // Catch: Throwable -> L16
        boolean r17 = super.w(r10);     // Catch: Throwable -> L16
        r11.unlock();
        return r17;
    L16:
        th = move-exception;
        r11.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.b
    public ReceiveChannel<E> x() {
        ReentrantLock r10 = this.f10269s;
        r10.lock();
    L20:
        th = move-exception;
        r10.unlock();
        throw th;
    L4:
        if (this.f10268r != (-1)) goto L6;
        a r11 = new b(this);     // Catch: Throwable -> L20
    L8:
        if (L() == false) goto L15;
        if (this.f10271u != c.a()) goto L15;
        n r12 = (BufferedChannel) r11;
        r12.w(W());     // Catch: Throwable -> L20
        r10.unlock();
        return r11;
    L15:
        if (this.f10271u == c.a()) goto L17;
        n r13 = (BufferedChannel) r11;
        r13.E(l1());     // Catch: Throwable -> L20
    L17:
        this.f10270t = CollectionsKt.plus(this.f10270t, r11);     // Catch: Throwable -> L20
        r10.unlock();
        return r11;
    L6:
        r11 = new a(this);     // Catch: Throwable -> L20
        goto L8
    }
}
