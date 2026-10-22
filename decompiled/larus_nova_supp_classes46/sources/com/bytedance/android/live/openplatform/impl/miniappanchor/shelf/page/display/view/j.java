package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformTitleBar;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ BaseAnchorShelfDisplayDialog a;

    public j(BaseAnchorShelfDisplayDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        ShelfMicroAppInfo r7 = (ShelfMicroAppInfo) r6;
        if (r7 == null) goto L32;
        OpenPlatformTitleBar r0 = (OpenPlatformTitleBar) this.a.T90(2131388807);
        ImageModel r2 = r7.icon;
        String r3 = "";
        if (r2 == null) goto L10;
        List r4 = r2.getUrls();
        if (r4 == null) goto L10;
        String r5 = (String) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L10;
    L11:
        r0.setLeftNetIconUrl(r5);
        ((OpenPlatformTitleBar) this.a.T90(2131388807)).setLeftNetIconVisibility(true);
        OpenPlatformTitleBar r1 = (OpenPlatformTitleBar) this.a.T90(2131388807);
        String r8 = r7.name;
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        r1.setLeftTvText(r8);
        ((OpenPlatformTitleBar) this.a.T90(2131388807)).setLeftTvVisibility(true);
        this.a.X90().setOnClickListener(new i(this, r7));
        OpenPlatformContext r9 = this.a.ca0().a();
        if (r9 == null) goto L33;
        AnchorMiniAppAppLogContextService r10 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
        if (r10 == null) goto L34;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r11 = AnchorMiniAppDataContext.a.a();
        if (r11 == null) goto L30;
        n<ShelfInfo> r12 = r11.m618getShelfInfo();
        if (r12 == null) goto L30;
        ShelfInfo r13 = (ShelfInfo) r12.getValue();
        if (r13 == null) goto L30;
        ShelfMicroAppInfo r14 = r13.appInfo;
        if (r14 == null) goto L30;
        String r15 = r14.appId;
        if (r15 == null) goto L30;
        r3 = r15;
    L30:
        r10.reportMpShow(r3, "shelf_show_page");
        return;
    L34:
        return;
    L33:
        return;
    L10:
        r5 = "";
        goto L11
    }
}
