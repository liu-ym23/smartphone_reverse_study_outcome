package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.model.ActivityResumeOrigin;
import com.bytedance.android.btm.impl.page.model.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmActivityLifecycleCallbackV2$onPostResumed$1 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ String $activityClassName;
    final /* synthetic */ ActivityResumeOrigin $printOrigin;
    final /* synthetic */ String $printOriginV2;
    final /* synthetic */ h $tree;

    public BtmActivityLifecycleCallbackV2$onPostResumed$1(String r1, ActivityResumeOrigin r10, String r11, h r12) {
        this.$activityClassName = r1;
        this.$printOrigin = r10;
        this.$printOriginV2 = r11;
        this.$tree = r12;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m752invoke() {
        JSONObject r0 = new JSONObject();
        r0.put(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, this.$activityClassName);     // Catch: Throwable -> L5
        r0.put("activityResumeOrigin", this.$printOrigin);     // Catch: Throwable -> L5
        r0.put("activityResumeOriginV2", this.$printOriginV2);     // Catch: Throwable -> L5
        r0.put("pageTree", String.valueOf(this.$tree));     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m752invoke();
    }
}
