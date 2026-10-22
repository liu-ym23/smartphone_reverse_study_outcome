package com.bytedance.android.live.liveinteract.component;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.component.api.IComponentService;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkPanelService;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final ILinkPanelService a() {
        Lazy r0 = MultiComponentManager.e;
        MultiComponentManager r1 = MultiComponentManager.a.a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(ILinkPanelService.class, "clazz");
        if (r1.d == true) goto L5;
        ALogger.w("MultiComponentManager", "component manager has not init.");
    L5:
        me0.a<? extends IComponentService> r2 = r1.b.get(ILinkPanelService.class);
        Object r3 = null;
        if (r2 != null) goto L8;
        Object r4 = null;
    L15:
        if ((r4 instanceof IComponentService) == false) goto L19;
        r3 = r4;
    L19:
        return (ILinkPanelService) r3;
    L8:
        if (r2.a != 0) goto L12;
        LinkPanelService r5 = r2.a();
        r2.a = r5;
        if (r5 == null) goto L12;
        r2.b.getLifecycle().addObserver(r5);
    L12:
        r4 = r2.a;
        goto L15
    }
}
