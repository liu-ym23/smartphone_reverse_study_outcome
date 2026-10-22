package com.obric.assistant.view;

import android.view.View;
import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class w implements View.OnClickListener {
    public final /* synthetic */ ObricUpdateBannerPopupWindow a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ w(ObricUpdateBannerPopupWindow r1, sba.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        ObricUpdateBannerPopupWindow r7 = this.a;
        final Function1 r0 = this.b;
        r7.getClass();
        FLogger.a.i("ObricUpdateBannerPopupWindow", "onStartUpdateClick, hostId=" + r7.a);
        IObricUpdateService r8 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r8 == null) goto L5;
        final Integer r9 = Integer.valueOf(r8.l());
    L7:
        if (r9 != null) goto L10;
    L12:
        if (r9 != null) goto L15;
    L17:
        if (r9 != null) goto L20;
    L22:
        String r4 = "click_background_download";
    L23:
        ObricUpdateBannerPopupWindow.g(r4);
        if (r9 != null) goto L27;
    L28:
        if (r9 != null) goto L31;
    L33:
        if (r9 != null) goto L36;
        return;
    L36:
        if (r9.intValue() != 4) goto L43;
        IObricUpdateService r10 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r10 == null) goto L40;
        r10.k(4);
    L40:
        if (r0 == null) goto L44;
        r0.invoke("start_install");
        return;
    L44:
        return;
    L43:
        return;
    L31:
        if (r9.intValue() != 6) goto L33;
    L32:
        ObricUpdateBannerPopupWindow.d(new c0(r9, r0));
        goto L33
    L27:
        if (r9.intValue() == 1) goto L32;
    L20:
        if (r9.intValue() != 4) goto L22;
        r4 = "click_setup";
        goto L23
    L15:
        if (r9.intValue() != 6) goto L17;
        r4 = "click_retry";
        goto L23
    L10:
        if (r9.intValue() != 1) goto L12;
    L5:
        r9 = null;
        goto L7
    }
}
