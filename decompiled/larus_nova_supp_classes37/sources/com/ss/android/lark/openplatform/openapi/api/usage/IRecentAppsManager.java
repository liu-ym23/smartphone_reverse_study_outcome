package com.ss.android.lark.openplatform.openapi.api.usage;

import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IRecentAppsManager {
    void addDataChangeListener(DataChangeListener r1);

    void deleteRecentApp(String r1, RecentAppsManager.OnAppDeleteListener r2, IAppContext r3);

    List<AppLaunchInfo> getRecentAppList(RecentAppsManager.OnDataGetListener r1, IAppContext r2);

    boolean removeDataChangeListener(DataChangeListener r1);
}
