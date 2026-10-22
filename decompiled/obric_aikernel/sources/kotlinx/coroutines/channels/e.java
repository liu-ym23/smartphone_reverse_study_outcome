package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nChannelCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,41:1\n706#2,2:42\n706#2,2:44\n706#2,2:46\n*S KotlinDebug\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n*L\n21#1:42,2\n26#1:44,2\n32#1:46,2\n*E\n"})
public class e<E> extends kotlinx.coroutines.a<Unit> implements d<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d<E> f10317i;

    public e(CoroutineContext r10, d<E> r11, boolean r12, boolean r13) {
        super(r10, r12, r13);
        this.f10317i = r11;
    }

    @Override // kotlinx.coroutines.channels.n
    public void B(Function1<? super Throwable, Unit> r10) {
        this.f10317i.B(r10);
    }

    public Object E(E r10) {
        return this.f10317i.E(r10);
    }

    public Object H(E r10, Continuation<? super Unit> r11) {
        return this.f10317i.H(r10, r11);
    }

    @Override // kotlinx.coroutines.channels.n
    public boolean L() {
        return this.f10317i.L();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.f<E> b() {
        return this.f10317i.b();
    }

    @Override // kotlinx.coroutines.c2, kotlinx.coroutines.v1
    public final void c(CancellationException r10) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        r10 = new JobCancellationException(c2.O(this), null, this);
    L7:
        f0(r10);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.f<g<E>> d() {
        return this.f10317i.d();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object e() {
        return this.f10317i.e();
    }

    @Override // kotlinx.coroutines.c2
    public void f0(Throwable r10) {
        CancellationException r11 = c2.Y0(this, r10, null, 1, null);
        this.f10317i.c(r11);
        d0(r11);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object g(Continuation<? super g<? extends E>> r10) {
        Object r11 = this.f10317i.g(r10);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r11;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this.f10317i.iterator();
    }

    public final d<E> j1() {
        return this;
    }

    protected final d<E> k1() {
        return this.f10317i;
    }

    public kotlinx.coroutines.selects.h<E, n<E>> n() {
        return this.f10317i.n();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object t(Continuation<? super E> r10) {
        return this.f10317i.t(r10);
    }

    public boolean w(Throwable r10) {
        return this.f10317i.w(r10);
    }
}
