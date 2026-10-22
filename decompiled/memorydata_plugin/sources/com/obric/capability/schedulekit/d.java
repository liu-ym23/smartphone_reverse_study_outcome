package com.obric.capability.schedulekit;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/obric/capability/schedulekit/IScheduleProxy;", "", "dispatchServerActions", "", "payload", "", "replyForServer", "", "queryAppIntents", ActivityLifecycle.NAME, "callback", "Lcom/obric/capabilitykit/common/IQueryAppIntentsCallback;", "registerActionsResultReceiver", "receiver", "Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver;", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface d {
    void a(ICapabilityFeedbackReceiver r1);

    void a(String r1, IQueryAppIntentsCallback r2);

    void a(String r1, boolean r2);
}
