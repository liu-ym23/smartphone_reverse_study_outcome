package com.obric.aiproactive.impl.trigger;

import com.obric.aiproactive.api.ToggleUserSubscriptionRequest;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/impl/trigger/TriggerEngineRequestFactory;", "", "<init>", "()V", "buildInitDefaults", "Lorg/json/JSONObject;", "buildRefreshNowInspirationCandidates", "buildToggleSubscription", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;", "buildBatchCreateAndToggleSubscriptions", "payload", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6531a = null;

    static {
        f6531a = new d();
    }

    private d() {
    }

    public final JSONObject a() {
        JSONObject r2 = new JSONObject().put("runType", "init_defaults");
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    public final JSONObject a(ToggleUserSubscriptionRequest r3) {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        JSONObject r2 = new JSONObject().put("runType", "toggle_subscription").put("subscriptionId", r3.getSubscriptionId()).put("isActive", r3.isActive()).put("eventType", 0);
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    public final JSONObject b() {
        JSONObject r2 = new JSONObject().put("runType", "refresh_now_inspiration_candidates");
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }
}
