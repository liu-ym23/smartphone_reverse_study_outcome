package com.obric.capability.schedulekit;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/capability/schedulekit/EmptyScheduleProxy;", "Lcom/obric/capability/schedulekit/IScheduleProxy;", "()V", "TAG", "", "dispatchServerActions", "", "payload", "replyForServer", "", "queryAppIntents", ActivityLifecycle.NAME, "callback", "Lcom/obric/capabilitykit/common/IQueryAppIntentsCallback;", "registerActionsResultReceiver", "receiver", "Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver;", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7382b = null;

    static {
        f7381a = new b();
        f7382b = "EmptyScheduleProxy";
    }

    private b() {
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(ICapabilityFeedbackReceiver r2) {
        Intrinsics.checkNotNullParameter((ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r2, ICapabilityFeedbackReceiver.class, "com.obric.memorydata.plugin"), "receiver");
        com.obric.capability.schedulekit.b.c.f7384a.c(f7382b, "registerActionsResultReceiver");
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(String r3, IQueryAppIntentsCallback r4) {
        IQueryAppIntentsCallback r2 = (IQueryAppIntentsCallback) ZeusTransformUtils.wrapperContextForParams(r4, IQueryAppIntentsCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r2, "callback");
        com.obric.capability.schedulekit.b.c.f7384a.c(f7382b, "queryAppIntents " + r3);
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "payload");
        com.obric.capability.schedulekit.b.c.f7384a.c(f7382b, "dispatchServerActions");
    }
}
