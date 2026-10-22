package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w4 implements hh1.w0 {
    public final /* synthetic */ AbsInteractionFragment a;

    public w4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final void O6(List<ILinkPlayerInfoBridge> r3) {
        Iterator r0 = ((ArrayList) this.a.H3).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        hh1.w0 r1 = (hh1.w0) r0.next();
        if (r1 == null) goto L4;
        r1.O6(r3);
        goto L4
    }

    public final void Mc(IBaseUser r3, boolean r4) {
        Iterator r0 = ((ArrayList) this.a.H3).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        hh1.w0 r1 = (hh1.w0) r0.next();
        if (r1 == null) goto L4;
        r1.Mc(r3, r4);
        goto L4
    }

    public final void Wk(String r3, boolean r4) {
        Iterator r0 = ((ArrayList) this.a.H3).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        hh1.w0 r1 = (hh1.w0) r0.next();
        if (r1 == null) goto L4;
        r1.Wk(r3, r4);
        goto L4
    }

    public final void f9(String r3, boolean r4) {
        Iterator r0 = ((ArrayList) this.a.H3).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        hh1.w0 r1 = (hh1.w0) r0.next();
        if (r1 == null) goto L4;
        r1.f9(r3, r4);
        goto L4
    }
}
