package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.memorydata.middleware.api.settings.IProactiveSettings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0000H\u0016R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/ProactiveSettings;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/obric/memorydata/middleware/api/settings/IProactiveSettings;", "<init>", "()V", "create", "autoDismissDurationMs", "", "getAutoDismissDurationMs", "()J", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h implements IProactiveSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("autoDismissDurationMs")
    private final long f11864a;

    public h() {
        this.f11864a = ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    }

    public h a() {
        return new h();
    }

    @Override // com.obric.memorydata.middleware.api.settings.IProactiveSettings
    public long getAutoDismissDurationMs() {
        return this.f11864a;
    }
}
