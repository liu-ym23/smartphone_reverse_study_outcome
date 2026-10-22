package com.obric.memorydata.middleware.impl.playground;

import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J.\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J8\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0019H\u0016J:\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0019H\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/ResultReceiver;", "Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver$Stub;", "<init>", "()V", "onActionResultRecv", "", "action", "", "result", "replyForServer", "", "onHideIntentResultCard", "questionId", "", "onFinishFloatingActivity", "isCardViewVisible", "isKeyguardReallyLocked", "onJobResultRecv", "question", "jobResult", "Lcom/obric/capabilitykit/common/execution/JobResult;", "onUpdateIntentResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "isStatusChange", "ext", "", "onUpdateIntentResultWithRequest", Ext.KEY_REQUEST, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k extends ICapabilityFeedbackReceiver.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f11837a = null;

    static {
        f11837a = new k();
    }

    private k() {
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public boolean isCardViewVisible(long r1) {
        return false;
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public boolean isKeyguardReallyLocked() {
        return false;
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onActionResultRecv(String r1, String r2, boolean r3) {
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onFinishFloatingActivity(long r1) {
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onHideIntentResultCard(long r1) {
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onJobResultRecv(String r1, String r2, boolean r3, JobResult r4) {
        m.f11838a.a(r1, r2, r4);
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onUpdateIntentResult(long r7, IntentResult<?> r9, boolean r10, Map<?, ?> r11) {
        Map<?, ?> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        m.f11838a.a(r7, r9, r10, r5);
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onUpdateIntentResultWithRequest(String r2, IntentResult<?> r3, boolean r4, Map<?, ?> r5) {
        Map<?, ?> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        m.f11838a.a(r2, r3, r4, r1);
    }
}
