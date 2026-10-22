package com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar;

import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.o90;
import com.bytedance.android.livesdk.config.yc1;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements com.bytedance.android.livesdk.chatroom.viewmodel.c {
    public final /* synthetic */ SnowToolbarContextService a;
    public final /* synthetic */ boolean b;

    public final boolean b() {
        return false;
    }

    public final ToolbarButton c() {
        return ToolbarButton.OPEN_PLATFORM_MINI_APP;
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
        return com.bytedance.android.livesdk.chatroom.viewmodel.a.f.b;
    }

    public final boolean a(long r9) {
        int r0 = qo0.a.a;
        qo0.a.c("SnowToolbarContextService", "on schedule: " + r9);
        SnowToolbarContextService r1 = this.a;
        if (r9 == 0) goto L5;
    L7:
        boolean r6 = false;
    L8:
        int r7 = SnowToolbarContextService.d;
        r1.getClass();
        AudienceMiniAppDataContext.Companion.getClass();
        ko0.d r2 = AudienceMiniAppDataContext.a.b();
        if (r2 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L36;
        MiniAppDataContext.Companion.getClass();
        if (g.c(MiniAppDataContext.a.b()) == true) goto L36;
        if (r6 == true) goto L20;
    L22:
        ko0.e.e.getClass();
        int r4 = ko0.e.a.a();
        int r8 = ((yc1) o90.a.getValue()).g() / 1000;
        if (r4 == 1) goto L32;
        if (r4 != 2) goto L36;
        if ((r9 % ((long) r8)) != 0) goto L36;
        if (r9 == 0) goto L36;
    L35:
        boolean r10 = true;
    L37:
        if (r10 == false) goto L40;
        this.a.getClass();
        SnowToolbarContextService.h();
        return true;
    L40:
        return false;
    L32:
        if ((r9 % ((long) r8)) != 0) goto L36;
        if (((IOpenPlatformAudienceService) k.n(IOpenPlatformAudienceService.class)).isMiniAppExplainCardShowing() == true) goto L36;
    L20:
        if (g.a(MiniAppDataContext.a.b()) == null) goto L22;
    L36:
        r10 = false;
        goto L37
    L11:
        if (r2.a != true) goto L13;
        r3 = true;
        goto L14
    L5:
        if (this.b == false) goto L7;
        r6 = true;
        goto L8
    }

    public a(SnowToolbarContextService r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
