package com.bytedance.android.live.misc;

import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.PushStreamService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livepushstreamimpl {
    public LiveService$$livepushstreamimpl() {
    }

    public static void registerService() {
        jc1.k.l(IPushStreamService.class, new PushStreamService());
    }
}
