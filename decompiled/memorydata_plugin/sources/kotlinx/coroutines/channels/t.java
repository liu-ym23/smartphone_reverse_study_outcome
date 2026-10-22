package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u000b2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010!\u001a\u00020\u000bH\u0014J\u0016\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010#J#\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0%2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00118VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/LazyActorCoroutine;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ActorCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "continuation", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", IslandSession.REOPEN_VALUE_CLOSE, "", "cause", "", "offer", "element", "(Ljava/lang/Object;)Z", "onSendRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onStart", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class t<E> extends a<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Continuation<? super Unit> f17294b;

    public static final /* synthetic */ void a(t r2, kotlinx.coroutines.selects.m r3, Object r4) {
        r2.a((kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void a(kotlinx.coroutines.selects.m<?> r3, Object r4) {
        kotlinx.coroutines.selects.m<?> r5 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
        p();
        super.getOnSend().b().invoke(this, r5, r4);
    }

    @Override // kotlinx.coroutines.channels.j, kotlinx.coroutines.channels.z
    public boolean close(Throwable r1) {
        boolean r2 = super.close(r1);
        s_();
        return r2;
    }

    @Override // kotlinx.coroutines.channels.j, kotlinx.coroutines.channels.z
    public kotlinx.coroutines.selects.j<E, z<E>> getOnSend() {
        LazyActorCoroutine$onSend$1 r0 = LazyActorCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return (kotlinx.coroutines.selects.j) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.selects.k(this, (Function3) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, 3), Function3.class, "com.obric.memorydata.plugin"), super.getOnSend().c(), null, 8, null), kotlinx.coroutines.selects.j.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.channels.j, kotlinx.coroutines.channels.z
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E r1) {
        s_();
        return super.offer(r1);
    }

    @Override // kotlinx.coroutines.ce
    public void p() {
        kotlinx.coroutines.a.a.a(this.f17294b, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.channels.j, kotlinx.coroutines.channels.z
    public Object send(E r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        s_();
        Object r2 = super.send(r3, r5);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.j, kotlinx.coroutines.channels.z
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo54trySendJP2dKIU(E r1) {
        s_();
        return super.mo54trySendJP2dKIU(r1);
    }
}
