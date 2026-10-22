package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0090@¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\rH\u0010¢\u0006\u0002\b\u0019J#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J+\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BufferedChannel;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "isConflatedDropOldest", "", "()Z", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "element", "", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropLatest", "isSendOp", "trySendDropLatest-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendImpl", "trySendImpl-Mj0NB7M", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class s<E> extends g<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17293a;
    private final BufferOverflow d;

    public s(int r3, BufferOverflow r4, Function1<? super E, Unit> r5) {
        super(r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin"));
        this.f17293a = r3;
        this.d = r4;
        boolean r6 = false;
        if (r4 == BufferOverflow.SUSPEND) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L14;
        if (r3 < 1) goto L9;
        r6 = true;
    L9:
        if (r6 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + r3 + " was specified").toString());
    L14:
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(g.class).getSimpleName() + " instead").toString());
    L5:
        r2 = false;
        goto L6
    }

    public /* synthetic */ s(int r2, BufferOverflow r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        this(r2, r3, r7);
    }

    private final Object a(E r3, boolean r4) {
        if (this.d != BufferOverflow.DROP_LATEST) goto L6;
        return b(r3, r4);
    L6:
        return a(r3);
    }

    static /* synthetic */ <E> Object a(s<E> r3, E r4, Continuation<? super Unit> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r7 = r3.a(r4, true);
        if (ZeusTransformUtils.instanceOf(r7, m.a.class) == false) goto L13;
        m.e(r7);
        Function1<E, Unit> r8 = r3.f17279b;
        if (r8 == null) goto L11;
        UndeliveredElementException r9 = kotlinx.coroutines.internal.ab.a(r8, r4, null, 2, null);
        if (r9 == null) goto L11;
        ExceptionsKt.addSuppressed((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin"), r3.n());
        throw r9;
    L11:
        throw r3.n();
    L13:
        return Unit.INSTANCE;
    }

    private final Object b(E r3, boolean r4) {
        Object r0 = super.mo54trySendJP2dKIU(r3);
        if (m.a(r0) == false) goto L5;
    L16:
        return r0;
    L5:
        if (m.c(r0) == true) goto L16;
        if (r4 == false) goto L15;
        Function1<E, Unit> r2 = this.f17279b;
        if (r2 == null) goto L15;
        UndeliveredElementException r5 = kotlinx.coroutines.internal.ab.a(r2, r3, null, 2, null);
        if (r5 == null) goto L15;
        throw r5;
    L15:
        return m.f17289a.a(Unit.INSTANCE);
    }

    static /* synthetic */ <E> Object b(s<E> r2, E r3, Continuation<? super Boolean> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Object r6 = r2.a(r3, true);
        if (ZeusTransformUtils.instanceOf(r6, m.c.class) == true) goto L7;
        Unit r7 = (Unit) ZeusTransformUtils.preCheckCast(r6, Unit.class, "com.obric.memorydata.plugin");
        return Boxing.boxBoolean(true);
    L7:
        return Boxing.boxBoolean(false);
    }

    @Override // kotlinx.coroutines.channels.g
    public Object a(E r3, Continuation<? super Boolean> r4) {
        return b(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.g
    public void a(kotlinx.coroutines.selects.m<?> r3, Object r4) {
        kotlinx.coroutines.selects.m r5 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
        Object r2 = mo54trySendJP2dKIU(r4);
        if (ZeusTransformUtils.instanceOf(r2, m.c.class) == true) goto L8;
        Unit r6 = (Unit) ZeusTransformUtils.preCheckCast(r2, Unit.class, "com.obric.memorydata.plugin");
        Object r7 = Unit.INSTANCE;
    L5:
        r5.a(r7);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r2, m.a.class) == false) goto L11;
        m.e(r2);
        r7 = h.b();
        goto L5
    L11:
        throw new IllegalStateException("unreachable".toString());
    }

    @Override // kotlinx.coroutines.channels.g
    public boolean f() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.g
    public boolean p() {
        if (this.d != BufferOverflow.DROP_OLDEST) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.g, kotlinx.coroutines.channels.z
    public Object send(E r3, Continuation<? super Unit> r4) {
        return a(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.channels.g, kotlinx.coroutines.channels.z
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo54trySendJP2dKIU(E r2) {
        return a(r2, false);
    }
}
