package me0;

import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkPanelService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends a<ILinkPanelService> {
    @Override // me0.a
    public final LinkPanelService a() {
        return new LinkPanelService();
    }

    public b(MultiComponentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        super(r2);
    }
}
