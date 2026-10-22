package com.obric.assistant.component;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o4 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ObricUpdateComponent a;
    public final /* synthetic */ View b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (IWindowContextKt.isWindowContext(this.a.getContext()) == false) goto L11;
        if (this.a.x == false) goto L11;
        FLogger.a.i("ObricUpdateComponent", "titleContainer layout skip during window animation, hostId=" + this.a.w);
        IObricBannerService r0 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r0 == null) goto L32;
        r0.d(this.a.w);
        return;
    L32:
        return;
    L11:
        if (this.b.isShown() == true) goto L13;
    L28:
        FLogger.a.i("ObricUpdateComponent", "titleContainer layout dismiss banner, hostId=" + this.a.w + ", shown=" + this.b.isShown() + ", attached=" + this.b.isAttachedToWindow() + ", pageState=" + this.a.getPageState());
        IObricBannerService r1 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r1 == null) goto L35;
        r1.d(this.a.w);
        return;
    L35:
        return;
    L13:
        if (this.b.isAttachedToWindow() == false) goto L28;
        ObricFloatChatPageData.a r2 = ObricFloatChatPageData.Companion;
        ObricUpdateComponent r3 = this.a;
        int r4 = ObricUpdateComponent.F;
        ObricFloatChatPageState r5 = r3.getPageState();
        r2.getClass();
        if ((r5 instanceof vda.c) == true) goto L28;
        IObricBannerService r6 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r6 == null) goto L22;
        boolean r7 = true;
        if (r6.e(this.a.w) != true) goto L22;
    L23:
        if (r7 == false) goto L33;
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("titleContainer layout update banner, hostId=");
        r9.append(this.a.w);
        r9.append(", anchor=");
        ObricUpdateComponent r10 = this.a;
        View r11 = this.b;
        r10.getClass();
        r9.append(ObricUpdateComponent.E3(r11));
        r8.i("ObricUpdateComponent", r9.toString());
        IObricBannerService r12 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r12 == null) goto L34;
        r12.b(this.b, -1, -1, this.a.w);
        return;
    L34:
        return;
    L33:
        return;
    L22:
        r7 = false;
        goto L23
    }

    public o4(ObricUpdateComponent r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
