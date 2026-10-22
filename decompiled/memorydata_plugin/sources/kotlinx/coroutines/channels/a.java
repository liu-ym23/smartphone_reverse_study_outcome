package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.bl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/ActorCoroutine;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "handleJobException", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "onCancelling", "", "cause", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
class a<E> extends j<E> implements b<E> {
    @Override // kotlinx.coroutines.ce
    public void e(Throwable r4) {
        i<E> r0 = g();
        CancellationException r1 = null;
        if (r4 != null) goto L5;
    L9:
        r0.a(r1);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, CancellationException.class) == false) goto L7;
        r1 = (CancellationException) ZeusTransformUtils.preCheckCast(r4, CancellationException.class, "com.obric.memorydata.plugin");
    L7:
        if (r1 != null) goto L9;
        r1 = bl.a(ao.b(this) + " was cancelled", r4);
        goto L9
    }

    @Override // kotlinx.coroutines.ce
    public boolean f(Throwable r1) {
        ai.a(getContext(), r1);
        return true;
    }
}
