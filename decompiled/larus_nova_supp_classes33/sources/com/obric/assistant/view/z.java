package com.obric.assistant.view;

import android.view.View;
import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class z implements View.OnClickListener {
    public final /* synthetic */ ObricUpdateBannerPopupWindow a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ z(ObricUpdateBannerPopupWindow r1, sba.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ObricUpdateBannerPopupWindow r6 = this.a;
        Function1 r0 = this.b;
        r6.getClass();
        FLogger.a.i("ObricUpdateBannerPopupWindow", "onPauseUpdateClick, hostId=" + r6.a);
        ObricUpdateBannerPopupWindow.g("click_pause");
        IObricUpdateService r7 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r7 == null) goto L5;
        r7.k(2);
    L5:
        if (r0 == null) goto L8;
        r0.invoke("downloading");
        return;
    }
}
