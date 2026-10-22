package com.bytedance.android.live.panel;

import com.bytedance.android.live.panel.panelobserver.PanelObserverType;
import com.bytedance.android.live.room.api.panel.b;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {
    void a(b r1);

    void b(List<? extends b> r1);

    PanelObserverType c();

    void destroy();
}
