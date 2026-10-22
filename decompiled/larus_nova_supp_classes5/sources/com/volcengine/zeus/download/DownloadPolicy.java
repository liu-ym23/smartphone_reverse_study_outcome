package com.volcengine.zeus.download;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/volcengine/zeus/download/DownloadPolicy;", "", "allowDownload", "", "pluginPkgName", "", "bean", "Lcom/volcengine/zeus/download/PluginDownloadBean;", "allowRequest", "ignoreTimeInterval", "getCustomTag", "", "isDownloadWifiOnly", "onDownloadSuccess", "", "mPackageName", "pluginDownloadBean", "updateLastRequestTime", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public interface DownloadPolicy {
    boolean allowDownload(String r1, PluginDownloadBean r2);

    boolean allowRequest(String r1, boolean r2);

    Map<String, String> getCustomTag(String r1);

    boolean isDownloadWifiOnly(String r1, PluginDownloadBean r2);

    void onDownloadSuccess(String r1, PluginDownloadBean r2);

    void updateLastRequestTime(String r1);
}
