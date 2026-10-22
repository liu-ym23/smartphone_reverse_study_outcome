package com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import com.bytedance.live.datacontext.n;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public HybridDialog a;
    public final OpenPlatformContext b;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        AudienceLaunchContextService.openMiniApp$default((AudienceLaunchContextService) this.b.getService(AudienceLaunchContextService.class), MountedMiniAppSource.ToolbarDirectMicroApp, null, 2, null);
        AudienceShelfInfoService r0 = (AudienceShelfInfoService) this.b.getService(AudienceShelfInfoService.class);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        if (r1 == null) goto L13;
        n<ShelfInfo> r2 = r1.m618getShelfInfo();
        if (r2 == null) goto L13;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
        if (r3 == null) goto L13;
        List<ShelfCardInfo> r4 = r3.cardInfoList;
        if (r4 == null) goto L13;
        ShelfCardInfo r5 = (ShelfCardInfo) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L13;
        long r6 = r5.getCardId();
    L14:
        r0.m(2, r6);
        return;
    L13:
        r6 = 0;
        goto L14
    }

    public d(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        this.c = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.b = r2;
    }
}
