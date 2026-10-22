package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fj0.e;
import java.util.List;
import jc1.k;
import je0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ BasePaidLinkMicWidget a;

    public b(BasePaidLinkMicWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        dj0.a r7 = (dj0.a) r6;
        BasePaidLinkMicWidget r8 = this.a;
        int r0 = BasePaidLinkMicWidget.g;
        r8.getClass();
        int r1 = e.a();
        DataCenter r9 = ((Widget) r8).dataCenter;
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        String r3 = null;
        if (r2 == null) goto L7;
        i<ILinkPlayerInfoBridge> r4 = r2.getLinkUserInfoCenter();
        if (r4 == null) goto L7;
        List r5 = r4.V4();
    L8:
        if (r5 == null) goto L10;
        Integer r10 = Integer.valueOf(r5.size());
    L12:
        if (r10 != null) goto L14;
    L16:
        if (r10 == null) goto L18;
        r3 = String.valueOf(r10.intValue());
    L18:
        if (r10 == null) goto L26;
        if (r10.intValue() <= 99) goto L23;
        r3 = "99+";
    L23:
        if (r10.intValue() > 0) goto L26;
        r3 = "";
    L26:
        if (d.N() == false) goto L30;
        if (r9 == null) goto L41;
        r9.put("data_video_talk_dot_with_number_show", r3);
        return;
    L41:
        return;
    L30:
        if (d.f() != 4) goto L32;
        boolean r11 = true;
    L33:
        if (r11 == false) goto L37;
        if (r9 == null) goto L43;
        r9.put("data_interact_number_dot_show", r3);
        return;
    L43:
        return;
    L37:
        if (d.u() == false) goto L45;
        if (r9 == null) goto L46;
        r9.put("data_audio_talk_dot_with_number_show", r3);
        return;
    L46:
        return;
    L45:
        return;
    L32:
        r11 = false;
        goto L33
    L14:
        if (r10.intValue() > 99) goto L16;
        r10 = Integer.valueOf(r10.intValue() + r1);
        goto L16
    L10:
        r10 = null;
    L7:
        r5 = null;
        goto L8
    }
}
