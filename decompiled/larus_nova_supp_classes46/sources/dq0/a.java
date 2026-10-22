package dq0;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        xs2.b r6 = xs2.b.a();
        b r1 = this.a;
        r6.post(new zp0.b(1, r1.b, r1.c));
        OpenPlatformContext r7 = this.a.getMiniAppAnchorService().a();
        if (r7 == null) goto L19;
        AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) r7.getService(AnchorMiniAppAppLogContextService.class);
        if (r8 == null) goto L20;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L16;
        n<ShelfInfo> r2 = r0.m618getShelfInfo();
        if (r2 == null) goto L16;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
        if (r3 == null) goto L16;
        ShelfMicroAppInfo r4 = r3.appInfo;
        if (r4 == null) goto L16;
        String r9 = r4.appId;
        if (r9 == null) goto L16;
    L17:
        r8.reportCardMorePanelClick(r9, "click_explanation_card");
        return;
    L16:
        r9 = "";
        goto L17
    L20:
        return;
    }
}
