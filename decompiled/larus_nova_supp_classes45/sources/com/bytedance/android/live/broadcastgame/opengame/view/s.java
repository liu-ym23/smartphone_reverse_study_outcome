package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements Runnable {
    public final /* synthetic */ PanelTopRightButtonView a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ float d;

    public s(PanelTopRightButtonView r1, Function0 r2, Function0 r3, float r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L6;
        return;
    L6:
        if (((Boolean) this.c.invoke()).booleanValue() == false) goto L8;
        int r0 = 2131567812;
    L9:
        LayoutInflater r1 = LayoutInflater.from(this.a.getContext());
        if (r1 == null) goto L12;
        View r2 = r1.inflate(r0, null);
    L13:
        if (r2 == null) goto L15;
        TextView r3 = (TextView) r2.findViewById(2131367794);
    L16:
        if (r2 == null) goto L18;
        View r4 = r2.findViewById(2131363236);
    L19:
        if (r3 == null) goto L21;
        r3.setText("设为常用，在任意直播间玩");
    L21:
        if (r4 == null) goto L23;
        a1.n(r4, s1.f(this.d));
    L23:
        yo2.e r5 = new yo2.e(this.a.getContext());
        ((yo2.d) r5).d = r2;
        ((yo2.d) r5).e = 0;
        ((yo2.d) r5).l = true;
        r5.a();
        LivePopupWindow r6 = ((yo2.d) r5).a;
        if (r6 == null) goto L27;
        r6.setClippingEnabled(false);
    L27:
        if (((Boolean) this.c.invoke()).booleanValue() == false) goto L29;
        r5.i(this.a, 2, 4, 0, s1.f(3.0f));
    L30:
        com.bytedance.android.live.broadcastgame.opengame.service.e r7 = com.bytedance.android.live.broadcastgame.opengame.service.e.b;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("popup_reason", com.bytedance.android.live.broadcastgame.opengame.service.e.a);
        com.bytedance.android.live.broadcastgame.opengame.service.e.b(r7, r8, null, null, 14);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_collect_popup_show", r8, new Object[]{Room.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L29:
        r5.i(this.a, 1, 4, 0, s1.f(-4.0f));
        goto L30
    L18:
        r4 = null;
        goto L19
    L15:
        r3 = null;
        goto L16
    L12:
        r2 = null;
        goto L13
    L8:
        r0 = 2131567811;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
