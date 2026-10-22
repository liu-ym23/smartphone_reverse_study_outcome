package com.ss.android.lark.locationmessage.ui.navigation;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.integrator.im.message.MessageLocationProvider$1$1;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v implements DialogInterface.OnClickListener {
    public final /* synthetic */ NavigateView a;

    public v(NavigateView r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r9, int r10) {
        if (r10 != 0) goto L4;
        NavigateView r11 = this.a;
        String[] r12 = NavigateView.p;
        r11.getClass();
        Statistics.sendEvent("message_location_share_click");
        if (r11.h != null) goto L21;
        LKUIToast.show(r11.b, 2131891721);
        return;
    L21:
        MessageLocationProvider$1$1 r13 = lqb.b.a.getChatDependency();
        String r0 = r11.g;
        if (r0 != null) goto L24;
        r0 = "";
    L24:
        Activity r2 = r11.b;
        Message r4 = r11.h;
        r13.getClass();
        int r14 = FlowChatModule.d;
        egb.e r1 = FlowChatModule.a.a().a().getForwardDependency();
        r1.d(r2, 6, r4, r0, false, null);
        return;
    L4:
        if (r10 != 1) goto L31;
        NavigateView r15 = this.a;
        if (r15.m == true) goto L9;
        return;
    L9:
        if (r15.j != null) goto L17;
        Statistics.sendEvent("message_location_favorite_click");
        Message r16 = r15.h;
        if (r16 != null) goto L13;
    L16:
        LKUIToast.show(r15.b, 2131892139);
        return;
    L13:
        if (TextUtils.isEmpty(r16.getId()) == true) goto L16;
        new NavigateView.AnonymousClass7(r15);
        com.ss.android.lark.integrator.im.message.b r17 = lqb.b.a.getFavoriteDependency();
        new UIGetDataCallback(new NavigateView.AnonymousClass8(r15));
        r17.getClass();
        return;
    L17:
        new NavigateView.AnonymousClass9(r15);
        com.ss.android.lark.integrator.im.message.b r18 = lqb.b.a.getFavoriteDependency();
        new UIGetDataCallback(new NavigateView.AnonymousClass10(r15));
        r18.getClass();
        return;
    }
}
