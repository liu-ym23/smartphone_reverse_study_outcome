package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements Runnable {
    public final /* synthetic */ UserInfoMiddleElement a;
    public final /* synthetic */ SharedPrefHelper b;

    public l(UserInfoMiddleElement r1, SharedPrefHelper r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        UserInfoMiddleElement r0 = this.a;
        int r1 = UserInfoMiddleElement.r;
        if (r0.c.getContext() != null) goto L5;
        return;
    L5:
        SharedPrefHelper r2 = this.b;
        r2.l("live.pred.PREF_ANCHOR_BIZ_PABEL_POPUP", Boolean.TRUE);
        r2.a();
        View r3 = LayoutInflater.from(this.a.c.getContext()).inflate(2131565134, null, false);
        this.a.n = new LivePopupWindow(r3, s1.f(141.0f), s1.f(42.0f), true);
        UserInfoMiddleElement r4 = this.a;
        LivePopupWindow r5 = r4.n;
        if (r5 == null) goto L11;
        ViewGroup r6 = r4.o;
        int r7 = -((int) (((double) r6.getWidth()) * 0.6d));
        OverlaySource r8 = PopupWindowLancet.resolveSource(r6);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r5, r6, r8) == true) goto L11;
        r5.showAsDropDown(r6, r7, 0, 3);
        PopupWindowLancet.trackAfterShow(r5, r8, r6);
    L11:
        UserInfoMiddleElement r9 = this.a;
        j0.l().sendLog("livesdk_anchor_live_realtime_widget_guidance_popup_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", a0.n(r9.getDataCenter()).getIdStr()), TuplesKt.to("anchor_id", a0.n(r9.getDataCenter()).getOwnerUserIdString().toString())}), new Object[0]);
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
