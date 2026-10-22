package com.bytedance.android.live.panel.panelobserver;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.panel.ActionType;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.room.api.panel.RemoveReason;
import com.bytedance.android.live.room.api.panel.b;
import com.bytedance.android.live.room.api.panel.e;
import com.bytedance.android.live.room.api.panel.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PanelCoverObserver implements com.bytedance.android.live.panel.a {
    public Map<String, com.bytedance.android.live.room.api.panel.a> a;
    public Map<PanelName, e> b;

    public static final class a {
    }

    static {
    }

    public PanelCoverObserver() {
    }

    @Override // com.bytedance.android.live.panel.a
    public final void destroy() {
        Map<String, com.bytedance.android.live.room.api.panel.a> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator<Map.Entry<String, com.bytedance.android.live.room.api.panel.a>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, com.bytedance.android.live.room.api.panel.a> r2 = r1.next();
        ALogger.i("PanelCoverObserver", "destroy, clear listener " + r2.getKey());
        r2.getValue().c(RemoveReason.Destroy);
    L8:
        Map<String, com.bytedance.android.live.room.api.panel.a> r3 = this.a;
        if (r3 == null) goto L11;
        r3.clear();
    L11:
        this.a = null;
        Map<PanelName, e> r4 = this.b;
        if (r4 == null) goto L14;
        r4.clear();
    L14:
        this.b = null;
    }

    @Override // com.bytedance.android.live.panel.a
    public final PanelObserverType c() {
        return PanelObserverType.CoverObserver;
    }

    @Override // com.bytedance.android.live.panel.a
    public final void a(final b r3) {
        Intrinsics.checkNotNullParameter(r3, "panelInfoProvider");
        r3.a(new PanelCoverObserver$onPanelOpen$1(this, r3), new PanelCoverObserver$onPanelOpen$2(r3));
    }

    @Override // com.bytedance.android.live.panel.a
    public final void b(List<? extends b> r7) {
        Intrinsics.checkNotNullParameter(r7, "panelInfoProviders");
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L14;
        b r0 = (b) r8.next();
        e r1 = f.a(r0, ActionType.Close, -1);
        Map<String, com.bytedance.android.live.room.api.panel.a> r2 = this.a;
        if (r2 == null) goto L11;
        Iterator r3 = ((LinkedHashMap) r2).entrySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        Map.Entry r4 = (Map.Entry) r3.next();
        ALogger.i("PanelCoverObserver", "onPanelClose, listener name = " + ((com.bytedance.android.live.room.api.panel.a) r4.getValue()).getName() + ", panel name = " + r1.a + ", panel id - " + r1.b);
        ((com.bytedance.android.live.room.api.panel.a) r4.getValue()).a(r1);
    L11:
        Map<PanelName, e> r5 = this.b;
        if (r5 == null) goto L4;
        e r6 = r5.remove(r0.getPanelName());
        goto L4
    }
}
