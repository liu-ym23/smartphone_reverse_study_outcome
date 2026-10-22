package com.larus.bmhome.chat.component.list;

import com.larus.audio.AudioServiceDelegate;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ry8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j5 implements Runnable {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ j5(ChatListComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatListComponent r0 = this.a;
        boolean r2 = false;
        if (AudioServiceDelegate.a.P().g() == true) goto L12;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L9;
        r1.y();
        if (com.larus.home.impl.sdk.t1.a.y0() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L12;
        r2 = true;
    L9:
        r3 = false;
    L12:
        int r4 = ChatListComponent.W3;
        b r5 = r0.B4();
        if (r5 == null) goto L15;
        r5.setAudioBtnEnabled(r2);
    L15:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r6 = r0.k4();
        if (r6 == null) goto L18;
        r6.setAudioBtnEnabled(r2);
    L18:
        paa.b r7 = (paa.b) r0.H2.getValue();
        if (r7 == null) goto L22;
        r7.setEnabled(true);
        return;
    }
}
