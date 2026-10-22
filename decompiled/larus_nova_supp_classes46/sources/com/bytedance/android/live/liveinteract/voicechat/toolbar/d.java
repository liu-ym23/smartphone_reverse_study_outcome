package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r3) {
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "error message : " + ((Throwable) r3));
    }
}
