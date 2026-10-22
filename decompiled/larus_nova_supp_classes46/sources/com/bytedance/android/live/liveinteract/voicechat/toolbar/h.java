package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r3) {
        ALogger.i("[VideoTalk]ToolbarVideoThemeBehavior", "getLastBg failed " + ((Throwable) r3).getMessage());
    }
}
