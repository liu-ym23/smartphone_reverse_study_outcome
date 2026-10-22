package com.bytedance.android.live.liveinteract.bgComponent.theme.util;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r3) {
        ALogger.i("[VoiceChat]ToolbarAudioThemeBehavior", "getLastBg failed " + ((Throwable) r3).getMessage());
    }
}
