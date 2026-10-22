package com.larus.bmhome.chat.component.bottom;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatBottomComponent$c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ChatBottomComponent b;
    public final /* synthetic */ boolean c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewTreeObserver r0 = this.a.getViewTreeObserver();
        if (r0 == null) goto L6;
        r0.removeOnGlobalLayoutListener(this);
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L48;
        WindowInsets r1 = this.a.getRootWindowInsets();
        if (r1 == null) goto L49;
        ChatBottomComponent r2 = this.b;
        View r3 = this.a;
        boolean r4 = this.c;
        FLogger r5 = FLogger.a;
        r5.i("ChatBottomComponent", "rootWindowInsets onApplyWindowInsets called");
        int r6 = ChatBottomComponent.L0;
        r2.getClass();
        boolean r7 = false;
        if (com.larus.utils.m0.d(r1) == false) goto L12;
    L15:
        boolean r8 = true;
    L16:
        IObricChatUIService r9 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r9 == null) goto L21;
        Boolean r10 = r9.f(r3);
        if (r10 == null) goto L21;
        boolean r11 = r10.booleanValue();
    L22:
        r5.i("ChatBottomComponent", "isNavigationBarVisibleFinal isNavigationBarVisible=" + r8 + " isViewMeetScreenBottom=" + r11);
        if (ObricChatUIDelegate.b.m() == false) goto L26;
        if (r8 == false) goto L26;
    L28:
        boolean r12 = true;
    L30:
        if (r12 == true) goto L45;
        o r13 = r2.C3();
        if (r13 != null) goto L34;
    L36:
        boolean r14 = false;
    L37:
        if (r14 == false) goto L45;
        o r15 = r2.C3();
        if (r15 != null) goto L41;
    L43:
        boolean r16 = false;
    L44:
        if (r16 == true) goto L45;
    L46:
        ChatBottomComponent.Y2(r2, r3, r7, r4);
        return;
    L41:
        if (r15.w() != true) goto L43;
        r16 = true;
        goto L44
    L34:
        if (r13.e60() != 0) goto L36;
        r14 = true;
    L45:
        r7 = true;
    L26:
        if (r8 == false) goto L29;
        if (r11 == false) goto L28;
    L29:
        r12 = false;
    L21:
        r11 = com.larus.utils.m0.e(r3);
        goto L22
    L12:
        if (ObricFeatureServiceDelegate.b.c() == true) goto L15;
        r8 = false;
        goto L16
    L49:
        return;
    }

    public ChatBottomComponent$c(View r1, ChatBottomComponent r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
