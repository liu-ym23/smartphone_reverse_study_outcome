package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.middleware.api.settings.IDataUploadSettings;
import com.obric.memorydata.middleware.api.settings.LogFilterConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0000H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00108\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R&\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u001e\u0010!\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u0016\u0010$\u001a\u00020\u00078\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\t¨\u0006&"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/DataUploadSettings;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/obric/memorydata/middleware/api/settings/IDataUploadSettings;", "<init>", "()V", "create", "privacyTrackerSwitch", "", "getPrivacyTrackerSwitch", "()Z", "setPrivacyTrackerSwitch", "(Z)V", "logRetrieval", "getLogRetrieval", "setLogRetrieval", "logLowestLevel", "", "getLogLowestLevel", "()I", "trackerBlackList", "", "", "getTrackerBlackList", "()Ljava/util/List;", "setTrackerBlackList", "(Ljava/util/List;)V", "privacyEventGroupList", "getPrivacyEventGroupList", "setPrivacyEventGroupList", "logBlacklist", "Lcom/obric/memorydata/middleware/api/settings/LogFilterConfig;", "getLogBlacklist", "setLogBlacklist", "forcePrintLogcat", "getForcePrintLogcat", "setForcePrintLogcat", "skipAppLogBackgroundNetworkRestriction", "getSkipAppLogBackgroundNetworkRestriction", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements IDataUploadSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("privacy_tracker_switch")
    private boolean f11857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("log_retrieval")
    private boolean f11858b;

    @SerializedName("log_lowest_level")
    private final int c;

    @SerializedName("tracker_black_list")
    private List<String> d;

    @SerializedName("privacy_event_group")
    private List<String> e;

    @SerializedName("log_blacklist")
    private List<LogFilterConfig> f;

    @SerializedName("force_print_logcat")
    private boolean g;

    @SerializedName("skip_applog_background_network_restriction")
    private final boolean h;

    public d() {
        this.f11858b = true;
        this.c = 4;
    }

    public d a() {
        return new d();
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public boolean getForcePrintLogcat() {
        return this.g;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public List<LogFilterConfig> getLogBlacklist() {
        return this.f;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public int getLogLowestLevel() {
        return this.c;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public boolean getLogRetrieval() {
        return this.f11858b;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public List<String> getPrivacyEventGroupList() {
        return this.e;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public boolean getPrivacyTrackerSwitch() {
        return this.f11857a;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public boolean getSkipAppLogBackgroundNetworkRestriction() {
        return this.h;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public List<String> getTrackerBlackList() {
        return this.d;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public void setForcePrintLogcat(boolean r1) {
        this.g = r1;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public void setLogBlacklist(List<LogFilterConfig> r3) {
        this.f = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public void setLogRetrieval(boolean r1) {
        this.f11858b = r1;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public void setPrivacyEventGroupList(List<String> r3) {
        this.e = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public void setPrivacyTrackerSwitch(boolean r1) {
        this.f11857a = r1;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IDataUploadSettings
    public void setTrackerBlackList(List<String> r3) {
        this.d = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }
}
