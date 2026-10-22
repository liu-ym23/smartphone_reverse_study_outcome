package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ai;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0014J\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0014¢\u0006\u0002\u0010\u0013R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/ProducerCoroutine;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;)V", "isActive", "", "()Z", "onCancelled", "", "cause", "", "handled", "onCompleted", EventBody.KEY_VALUE, "(Lkotlin/Unit;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class v<E> extends j<E> implements w<E> {
    public v(CoroutineContext r3, i<E> r4) {
        super((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin"), true, true);
    }

    @Override // kotlinx.coroutines.a
    public /* synthetic */ void a(Unit r3) {
        a2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.a
    public void a(Throwable r2, boolean r3) {
        if (g().close(r2) == true) goto L7;
        if (r3 == true) goto L8;
        ai.a(getContext(), r2);
        return;
    L8:
        return;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(Unit r2) {
        z.a.a((z) ZeusTransformUtils.preCheckCast(g(), z.class, "com.obric.memorydata.plugin"), null, 1, null);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.ce, kotlinx.coroutines.bx
    public boolean a() {
        return super.a();
    }

    @Override // kotlinx.coroutines.channels.w
    public /* synthetic */ z u() {
        return (z) ZeusTransformUtils.preCheckCast(t(), z.class, "com.obric.memorydata.plugin");
    }
}
