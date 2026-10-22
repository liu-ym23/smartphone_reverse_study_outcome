package com.obric.aikernel.middleware.api.traker;

import androidx.core.app.NotificationCompat;
import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import u7.b;

/* JADX INFO: loaded from: classes2.dex */
public final class TrackerApi implements ITrackerApi {
    public static final TrackerApi INSTANCE = null;
    private final /* synthetic */ ITrackerApi $$delegate_0;

    static {
        INSTANCE = new TrackerApi();
    }

    private TrackerApi() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(ITrackerApi.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (ITrackerApi) r10;
    }

    @Override // com.obric.aikernel.middleware.api.traker.ITrackerApi
    public void flush() {
        this.$$delegate_0.flush();
    }

    @Override // com.obric.aikernel.middleware.api.traker.ITrackerApi
    public void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        this.$$delegate_0.monitorEvent(r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.middleware.api.traker.ITrackerApi
    public void onEvent(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        this.$$delegate_0.onEvent(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.traker.ITrackerApi
    public void registerIntercept(b r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "intercept");
        this.$$delegate_0.registerIntercept(r10, r11);
    }
}
