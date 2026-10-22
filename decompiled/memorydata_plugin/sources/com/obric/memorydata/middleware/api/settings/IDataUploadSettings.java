package com.obric.memorydata.middleware.api.settings;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u0018\u0010\u001d\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005¨\u0006\""}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/IDataUploadSettings;", "", "privacyTrackerSwitch", "", "getPrivacyTrackerSwitch", "()Z", "setPrivacyTrackerSwitch", "(Z)V", "logRetrieval", "getLogRetrieval", "setLogRetrieval", "logLowestLevel", "", "getLogLowestLevel", "()I", "trackerBlackList", "", "", "getTrackerBlackList", "()Ljava/util/List;", "setTrackerBlackList", "(Ljava/util/List;)V", "privacyEventGroupList", "getPrivacyEventGroupList", "setPrivacyEventGroupList", "logBlacklist", "Lcom/obric/memorydata/middleware/api/settings/LogFilterConfig;", "getLogBlacklist", "setLogBlacklist", "forcePrintLogcat", "getForcePrintLogcat", "setForcePrintLogcat", "skipAppLogBackgroundNetworkRestriction", "getSkipAppLogBackgroundNetworkRestriction", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IDataUploadSettings {
    boolean getForcePrintLogcat();

    List<LogFilterConfig> getLogBlacklist();

    int getLogLowestLevel();

    boolean getLogRetrieval();

    List<String> getPrivacyEventGroupList();

    boolean getPrivacyTrackerSwitch();

    boolean getSkipAppLogBackgroundNetworkRestriction();

    List<String> getTrackerBlackList();

    void setForcePrintLogcat(boolean r1);

    void setLogBlacklist(List<LogFilterConfig> r1);

    void setLogRetrieval(boolean r1);

    void setPrivacyEventGroupList(List<String> r1);

    void setPrivacyTrackerSwitch(boolean r1);

    void setTrackerBlackList(List<String> r1);
}
