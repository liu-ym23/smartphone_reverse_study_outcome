package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    public final void accept(Object r3) {
        ALogger.i("MultiLinkSettingPanelReuseManager", "preloadSettingPanelContainerCard cost=" + ((Long) r3));
    }
}
