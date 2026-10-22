package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    public final void accept(Object r3) {
        ALogger.w("MultiLinkSettingPanelReuseManager", "preloadSettingPanelContainerCard fail=" + ((Throwable) r3).getMessage());
    }
}
