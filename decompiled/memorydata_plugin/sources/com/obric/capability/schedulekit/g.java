package com.obric.capability.schedulekit;

import android.os.IInterface;
import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import com.obric.capabilitykit.corecommon.BinderExceptionHandlerProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/capability/schedulekit/ScheduleProxy;", "Lcom/obric/capability/schedulekit/IScheduleProxy;", "api", "Lcom/obric/capabilitykit/common/ICapabilitySchedule;", "(Lcom/obric/capabilitykit/common/ICapabilitySchedule;)V", "getApi", "()Lcom/obric/capabilitykit/common/ICapabilitySchedule;", "mApi", "dispatchServerActions", "", "payload", "", "replyForServer", "", "queryAppIntents", ActivityLifecycle.NAME, "callback", "Lcom/obric/capabilitykit/common/IQueryAppIntentsCallback;", "registerActionsResultReceiver", "receiver", "Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver;", "Companion", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ICapabilitySchedule f7414b;
    private final ICapabilitySchedule c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/capability/schedulekit/ScheduleProxy$Companion;", "", "()V", "TAG", "", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7413a = new a(null);
    }

    public g(ICapabilitySchedule r7) {
        ICapabilitySchedule r8 = (ICapabilitySchedule) ZeusTransformUtils.wrapperContextForParams(r7, ICapabilitySchedule.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "api");
        this.f7414b = r8;
        BinderExceptionHandlerProxy.Companion r0 = BinderExceptionHandlerProxy.Companion;
        IInterface r9 = (IInterface) ZeusTransformUtils.preCheckCast(r8, IInterface.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Proxy.newProxyInstance(ICapabilitySchedule.class.getClassLoader(), new Class[]{ICapabilitySchedule.class}, (InvocationHandler) ZeusTransformUtils.preCheckCast(new BinderExceptionHandlerProxy(r9, "ScheduleProxy", ICapabilitySchedule.class), InvocationHandler.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        if (r3 == null) goto L7;
        r9 = (IInterface) ZeusTransformUtils.preCheckCast((ICapabilitySchedule) ZeusTransformUtils.preCheckCast(r3, ICapabilitySchedule.class, "com.obric.memorydata.plugin"), IInterface.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L12:
        this.c = (ICapabilitySchedule) ZeusTransformUtils.preCheckCast(r9, ICapabilitySchedule.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilitySchedule");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Throwable r5 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
        if (r5 == null) goto L12;
        Log.e("ScheduleProxy", "BinderExceptionHandlerProxy createProxyInstance for " + r9.getClass() + " fail", r5);
        goto L12
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(ICapabilityFeedbackReceiver r3) {
        ICapabilityFeedbackReceiver r4 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityFeedbackReceiver.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "receiver");
        this.c.registerActionsResultReceiver(r4);
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(String r3, IQueryAppIntentsCallback r4) {
        IQueryAppIntentsCallback r5 = (IQueryAppIntentsCallback) ZeusTransformUtils.wrapperContextForParams(r4, IQueryAppIntentsCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.c.queryAppIntents(r3, r5);
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.c.dispatchServerActions(r2, r3);
    }
}
