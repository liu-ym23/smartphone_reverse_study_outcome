package com.bytedance.android.live.misc;

import com.bytedance.android.live.search.api.ILiveSearchService;
import com.bytedance.android.live.search.impl.search.LiveSearchService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livesearchimpl {
    public LiveService$$livesearchimpl() {
    }

    public static void registerService() {
        jc1.k.l(ILiveSearchService.class, new LiveSearchService());
    }
}
