package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface h {
    void a(IJsBridgeManager r1);

    Map<String, Object> getCacheByScheme(String r1);

    JSONObject getCacheJsonByScheme(String r1);

    void init();

    void prefetch(String r1);
}
