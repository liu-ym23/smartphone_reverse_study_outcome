package ee;

import com.bytedance.android.ec.adapter.api.message.model.TraceTimeMetric;
import com.bytedance.android.ec.adapter.api.message.model.UpdatedCartInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements a, ce.a {
    public final ce.a a;

    @Override // ce.a
    public final String A() {
        return this.a.A();
    }

    @Override // ce.a
    public final TraceTimeMetric d() {
        return this.a.d();
    }

    @Override // ce.a
    public final String getEcomNotice() {
        return this.a.getEcomNotice();
    }

    @Override // ce.a
    public final long getMessageId2() {
        return this.a.getMessageId2();
    }

    @Override // ce.a
    public final int getMsgType() {
        return this.a.getMsgType();
    }

    @Override // ce.a
    public final List<String> getSecTargetUid() {
        return this.a.getSecTargetUid();
    }

    @Override // ce.a
    public final List<String> getTargetUid() {
        return this.a.getTargetUid();
    }

    @Override // ce.a
    public final UpdatedCartInfo w() {
        return this.a.w();
    }

    public b(ce.a r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        this.a = r10;
    }
}
