package kotlinx.coroutines.channels;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ce;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\"\u001a\u00020\u0003H\u0017J\u0012\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0007J\u0016\u0010\"\u001a\u00020\u00032\u000e\u0010#\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016J\u0013\u0010(\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0001J.\u0010)\u001a\u00020\u00032#\u0010*\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00030+H\u0096\u0001J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0096\u0003J\u0016\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0002\u00102J\u0010\u00103\u001a\u0004\u0018\u00018\u0000H\u0097\u0001¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096Aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00106J\u0010\u00109\u001a\u0004\u0018\u00018\u0000H\u0097A¢\u0006\u0002\u00106J\u0016\u0010:\u001a\u00020\u00032\u0006\u00101\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u00104J$\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u00101\u001a\u00028\u0000H\u0096\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00158VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R$\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "initParentJob", "", "active", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "getChannel", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", IslandSession.REOPEN_VALUE_CLOSE, "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "offer", "element", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive", "tryReceive-PtdJZtk", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class j<E> extends kotlinx.coroutines.a<Unit> implements i<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i<E> f17288b;

    public j(CoroutineContext r3, i<E> r4, boolean r5, boolean r6) {
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        i<E> r8 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        super(r7, r5, r6);
        this.f17288b = r8;
    }

    @Override // kotlinx.coroutines.channels.y
    public Object a(Continuation<? super E> r3) {
        Continuation<? super E> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return this.f17288b.a(r4);
    }

    @Override // kotlinx.coroutines.ce, kotlinx.coroutines.bx
    public final void a(CancellationException r6) {
        if (r_() == false) goto L6;
        return;
    L6:
        if (r6 != null) goto L8;
        r6 = (CancellationException) ZeusTransformUtils.preCheckCast(new JobCancellationException(ce.a((ce) ZeusTransformUtils.preCheckCast(this, ce.class, "com.obric.memorydata.plugin")), null, (bx) ZeusTransformUtils.preCheckCast((ce) ZeusTransformUtils.preCheckCast(this, ce.class, "com.obric.memorydata.plugin"), bx.class, "com.obric.memorydata.plugin")), CancellationException.class, "com.obric.memorydata.plugin");
    L8:
        b((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.channels.y
    public Object b(Continuation<? super m<? extends E>> r3) {
        Continuation<? super m<? extends E>> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Object r2 = this.f17288b.b(r4);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r2;
    }

    @Override // kotlinx.coroutines.ce
    public void b(Throwable r5) {
        CancellationException r6 = ce.a((ce) ZeusTransformUtils.preCheckCast(this, ce.class, "com.obric.memorydata.plugin"), r5, null, 1, null);
        this.f17288b.a(r6);
        d((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.channels.z
    public boolean close(Throwable r1) {
        return this.f17288b.close(r1);
    }

    public final i<E> g() {
        return this.f17288b;
    }

    @Override // kotlinx.coroutines.channels.z
    public kotlinx.coroutines.selects.j<E, z<E>> getOnSend() {
        return this.f17288b.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.y
    public Object i() {
        return this.f17288b.i();
    }

    @Override // kotlinx.coroutines.channels.z
    public void invokeOnClose(Function1<? super Throwable, Unit> r3) {
        Function1<? super Throwable, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        this.f17288b.invokeOnClose(r4);
    }

    @Override // kotlinx.coroutines.channels.z
    public boolean isClosedForSend() {
        return this.f17288b.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.y
    public kotlinx.coroutines.selects.h<E> j() {
        return this.f17288b.j();
    }

    @Override // kotlinx.coroutines.channels.y
    public kotlinx.coroutines.selects.h<m<E>> k() {
        return this.f17288b.k();
    }

    @Override // kotlinx.coroutines.channels.y
    public k<E> l() {
        return this.f17288b.l();
    }

    @Override // kotlinx.coroutines.channels.z
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E r1) {
        return this.f17288b.offer(r1);
    }

    @Override // kotlinx.coroutines.channels.y
    public boolean q() {
        return this.f17288b.q();
    }

    @Override // kotlinx.coroutines.channels.z
    public Object send(E r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return this.f17288b.send(r3, r5);
    }

    public final i<E> t() {
        return (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.channels.z
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo54trySendJP2dKIU(E r1) {
        return this.f17288b.mo54trySendJP2dKIU(r1);
    }
}
