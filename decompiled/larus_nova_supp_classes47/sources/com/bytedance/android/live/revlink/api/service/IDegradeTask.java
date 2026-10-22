package com.bytedance.android.live.revlink.api.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/api/service/IDegradeTask;", "", "onClear", "", "onDegrade", "onRecover", "onSceneEnter", "scene", "", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IDegradeTask {
    void onClear();

    void onDegrade();

    void onRecover();

    void onSceneEnter(String r1);
}
