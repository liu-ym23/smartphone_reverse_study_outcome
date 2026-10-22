package com.bytedance.android.live.room.api.panel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c {
    void notifyPanelClose(PanelName r1, b r2);

    void notifyPanelOpen(PanelName r1, b r2);

    void registerPanelListener(a r1);

    void registerPanelListener(a r1, boolean r2);

    void unregisterPanelListener(a r1);
}
