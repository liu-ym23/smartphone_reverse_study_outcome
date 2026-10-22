package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.middleware.api.settings.IAppEntityIndexSetting;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0000H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/AppEntityIndexSetting;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/obric/memorydata/middleware/api/settings/IAppEntityIndexSetting;", "<init>", "()V", "create", "launchIndexTaskInterval", "", "getLaunchIndexTaskInterval", "()J", "setLaunchIndexTaskInterval", "(J)V", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements IAppEntityIndexSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("launchIndexTaskIntervalSeconds")
    private long f11852a;

    public a() {
        this.f11852a = 1;
    }

    public a a() {
        return new a();
    }

    @Override // com.obric.memorydata.middleware.api.settings.IAppEntityIndexSetting
    public long getLaunchIndexTaskInterval() {
        return this.f11852a;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IAppEntityIndexSetting
    public void setLaunchIndexTaskInterval(long r1) {
        this.f11852a = r1;
    }
}
