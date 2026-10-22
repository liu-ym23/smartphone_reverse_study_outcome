package com.obric.assistant.view;

import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class y implements View.OnClickListener {
    public final /* synthetic */ ObricUpdateBannerPopupWindow a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ y(ObricUpdateBannerPopupWindow r1, sba.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ObricUpdateBannerPopupWindow r6 = this.a;
        final Function1 r0 = this.b;
        r6.getClass();
        FLogger.a.i("ObricUpdateBannerPopupWindow", "onContinueUpdateClick, hostId=" + r6.a);
        ObricUpdateBannerPopupWindow.g("click_continue");
        ObricUpdateBannerPopupWindow.d(new e0(r0));
    }
}
