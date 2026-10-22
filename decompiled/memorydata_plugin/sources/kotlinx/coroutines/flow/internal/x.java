package kotlinx.coroutines.flow.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.aj;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "initialValue", "(I)V", EventBody.KEY_VALUE, "getValue", "()Ljava/lang/Integer;", "increment", "", "delta", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class x extends aj<Integer> implements ar<Integer> {
    public x(int r4) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        a(Integer.valueOf(r4));
    }

    @Override // kotlinx.coroutines.flow.ar
    public /* synthetic */ Integer c() {
        return k();
    }

    public final boolean c(int r4) {
        monitor-enter(this);
        boolean r5 = a(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(d(), Number.class, "com.obric.memorydata.plugin")).intValue() + r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public Integer k() {
        monitor-enter(this);
        Integer r0 = Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(d(), Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
