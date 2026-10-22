package com.obric.assistant.view;

import android.view.View;
import android.widget.PopupWindow;
import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b0 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ ObricUpdateBannerPopupWindow a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function0 c;

    public /* synthetic */ b0(ObricUpdateBannerPopupWindow r1, View r2, sba.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ObricUpdateBannerPopupWindow r0 = this.a;
        View r1 = this.b;
        Function0 r2 = this.c;
        FLogger r3 = FLogger.a;
        r3.i("ObricUpdateBannerPopupWindow", "popup onDismiss, hostId=" + r0.a + ", anchor=" + ObricUpdateBannerPopupWindow.j(r1));
        StringBuilder r4 = new StringBuilder("onPopupDismissed, hostId=");
        r4.append(r0.a);
        r3.i("ObricUpdateBannerPopupWindow", r4.toString());
        IObricUpdateService r5 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r5 == null) goto L5;
        r5.i(r0.j);
    L5:
        h0 r6 = r0.i;
        if (r6 == null) goto L12;
        View r7 = r0.h;
        if (r7 == null) goto L11;
        r7.removeOnAttachStateChangeListener(r6);
    L11:
        r0.i = null;
        r0.h = null;
    L12:
        r0.b = null;
        r0.g = null;
        r0.l = null;
        r0.k = -1;
        if (r2 == null) goto L16;
        r2.invoke();
        return;
    }
}
