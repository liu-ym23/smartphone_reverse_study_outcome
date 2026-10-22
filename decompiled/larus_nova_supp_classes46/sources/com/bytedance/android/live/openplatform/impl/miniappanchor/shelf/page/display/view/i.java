package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.BaseAnchorShelfDisplayViewModel;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ j a;
    public final /* synthetic */ ShelfMicroAppInfo b;

    public i(j r1, ShelfMicroAppInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        BaseAnchorShelfDisplayDialog r5 = this.a.a;
        int r0 = BaseAnchorShelfDisplayDialog.n;
        BaseAnchorShelfDisplayViewModel r6 = r5.W90();
        String r1 = this.b.schema;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r6.openMiniAppLandingPage(r1, true);
        OpenPlatformContext r7 = this.a.a.ca0().a();
        if (r7 == null) goto L23;
        AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) r7.getService(AnchorMiniAppAppLogContextService.class);
        if (r8 == null) goto L24;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r3 = AnchorMiniAppDataContext.a.a();
        if (r3 == null) goto L21;
        n<ShelfInfo> r9 = r3.m618getShelfInfo();
        if (r9 == null) goto L21;
        ShelfInfo r10 = (ShelfInfo) r9.getValue();
        if (r10 == null) goto L21;
        ShelfMicroAppInfo r11 = r10.appInfo;
        if (r11 == null) goto L21;
        String r12 = r11.appId;
        if (r12 == null) goto L21;
        r2 = r12;
    L21:
        r8.reportMpClick(r2, "shelf_show_page");
        return;
    L24:
        return;
    }
}
