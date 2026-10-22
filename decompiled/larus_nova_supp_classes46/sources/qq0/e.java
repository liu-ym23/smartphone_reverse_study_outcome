package qq0;

import android.view.View;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ AudienceShelfDisplayDialog a;

    public e(AudienceShelfDisplayDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        OpenPlatformContext r5 = this.a.l;
        if (r5 == null) goto L7;
        AudienceMiniAppAppLogContextService r6 = (AudienceMiniAppAppLogContextService) r5.getService(AudienceMiniAppAppLogContextService.class);
        if (r6 == null) goto L7;
        r6.reportShelfTopMpEntranceClick(this.a.da0());
    L7:
        OpenPlatformContext r7 = this.a.l;
        if (r7 == null) goto L13;
        AudienceLaunchContextService r8 = (AudienceLaunchContextService) r7.getService(AudienceLaunchContextService.class);
        if (r8 == null) goto L14;
        AudienceLaunchContextService.openMiniApp$default(r8, MountedMiniAppSource.ShelfPageMicroApp, null, 2, null);
        return;
    L14:
        return;
    }
}
