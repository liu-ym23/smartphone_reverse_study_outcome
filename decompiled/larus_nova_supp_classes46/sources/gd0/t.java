package gd0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements com.bytedance.android.scope.o, j {
    public t() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // gd0.j
    public final Integer a() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentUiLayout();
    L7:
        return Integer.valueOf(r1);
    L5:
        r1 = 0;
        goto L7
    }

    @Override // gd0.j
    public final List<ILinkPlayerInfoBridge> getOnlineUserList() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L9;
        List r2 = r1.getOnlineUserList();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // gd0.j
    public final int i() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentScene();
    }

    @Override // gd0.j
    public final List<Integer> s() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        List<Integer> r1 = r0.getCurrentPlayModes();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    @Override // gd0.j
    public final ILinkPlayerInfoBridge getGuestInfo(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getGuestInfo(r2, "");
    }
}
