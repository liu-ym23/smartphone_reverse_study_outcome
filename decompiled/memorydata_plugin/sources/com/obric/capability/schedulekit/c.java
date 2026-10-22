package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0007*\u0001\f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/obric/capability/schedulekit/ExecuteResultManager;", "", "()V", "connectionClosed", "", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "Lcom/obric/capability/schedulekit/JobResultWrapper;", "", "resultReceiver", "com/obric/capability/schedulekit/ExecuteResultManager$resultReceiver$1", "Lcom/obric/capability/schedulekit/ExecuteResultManager$resultReceiver$1;", "getResultWithTimeout", "questionId", "timeoutMillis", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7386a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, Function1<JobResultWrapper, Unit>> f7387b = null;
    private static boolean c;
    private static final a d = null;

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J.\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J8\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0016J:\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0016¨\u0006\u0019"}, d2 = {"com/obric/capability/schedulekit/ExecuteResultManager$resultReceiver$1", "Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver$Stub;", "isCardViewVisible", "", "questionId", "", "isKeyguardReallyLocked", "onActionResultRecv", "", "question", "", "result", "replyForSvr", "onFinishFloatingActivity", "onHideIntentResultCard", "onJobResultRecv", "jobResult", "Lcom/obric/capabilitykit/common/execution/JobResult;", "onUpdateIntentResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "isStatusChange", "ext", "", "onUpdateIntentResultWithRequest", Ext.KEY_REQUEST, "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ICapabilityFeedbackReceiver.Stub {
        a() {
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
        public void onJobResultRecv(String r5, String r6, boolean r7, JobResult r8) {
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(c.a(), Map.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L5;
            Long r0 = Long.valueOf(r8.getQuestionId());
        L6:
            Function1 r9 = (Function1) ZeusTransformUtils.preCheckCast(r4.get(r0), Function1.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L10;
            r9.invoke(new JobResultWrapper(r5, r6, r7, r8));
            return;
        L10:
            return;
        L5:
            r0 = null;
            goto L6
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResult(long r1, IntentResult<?> r3, boolean r4, Map<?, ?> r5) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResultWithRequest(String r1, IntentResult<?> r2, boolean r3, Map<?, ?> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f7386a = new c();
        f7387b = new ConcurrentHashMap();
        a r0 = new a();
        d = r0;
        com.obric.capability.schedulekit.a.f7373a.a((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(r0, ICapabilityFeedbackReceiver.class, "com.obric.memorydata.plugin"));
        com.obric.capability.schedulekit.a.a((Function0) ZeusTransformUtils.preCheckCast(ExecuteResultManager$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private c() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f7387b;
    }

    public static final /* synthetic */ void a(boolean r0) {
        c = r0;
    }

    public final Object a(long r6, long r8, Continuation<? super JobResultWrapper> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, ExecuteResultManager$getResultWithTimeout$1.class) == false) goto L7;
        ExecuteResultManager$getResultWithTimeout$1 r0 = (ExecuteResultManager$getResultWithTimeout$1) ZeusTransformUtils.preCheckCast(r11, ExecuteResultManager$getResultWithTimeout$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r6 = r0.J$0;
        ResultKt.throwOnFailure(r5);
    L20:
        JobResultWrapper r7 = (JobResultWrapper) ZeusTransformUtils.preCheckCast(r5, JobResultWrapper.class, "com.obric.memorydata.plugin");
        f7387b.remove(Boxing.boxLong(r6));
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        if (c == false) goto L17;
        c = false;
        com.obric.capability.schedulekit.a.f7373a.a((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(d, ICapabilityFeedbackReceiver.class, "com.obric.memorydata.plugin"));
    L17:
        Function2 r9 = (Function2) ZeusTransformUtils.preCheckCast(new ExecuteResultManager$getResultWithTimeout$result$1(r6, null), Function2.class, "com.obric.memorydata.plugin");
        r0.J$0 = r6;
        r0.label = 1;
        r5 = da.b(r8, r9, r0);
        if (r5 != r12) goto L20;
        return r12;
    L7:
        r0 = new ExecuteResultManager$getResultWithTimeout$1(this, r11);
        goto L8
    }
}
