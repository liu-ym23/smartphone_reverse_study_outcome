package com.bytedance.android.live.liveinteract.revenue.starwish;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import gj0.i;
import ih0.b;
import java.util.ArrayList;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import tlc.d;
import vlc.l;
import xh0.f;
import xh0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/starwish/StarWishWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StarWishWidget extends AbsPlayModeWidget implements l {

    public static final class a {
    }

    static {
    }

    public final void onMessage(d r1) {
    }

    @Override // xh0.b
    public final ArrayList<f> getIncompatibleSourceList() {
        return new ArrayList();
    }

    @Override // xh0.b
    public final h getPlayModeInfo() {
        return new h(34, s1.B(2131922640));
    }

    @Override // xh0.b
    public final boolean isOpen() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L9;
        b r1 = r0.dynamicService(((Widget) this).dataCenter);
        if (r1 == null) goto L9;
        if (r1.jl("star_wish") != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        i.a("StarWishWidget", "onCreate");
        super.onCreate();
        n r0 = m.e(this).a();
        if (r0 == null) goto L15;
        ArrayList r1 = (ArrayList) r0.getValue();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.contains(34) != true) goto L17;
        n r2 = m.e(this).a();
        if (r2 == null) goto L13;
        ArrayList r3 = (ArrayList) r2.getValue();
        if (r3 == null) goto L13;
        r3.remove(34);
    L13:
        int r4 = gj0.h.a;
        gj0.h.b(jc1.a.b(), MapsKt.mapOf(TuplesKt.to("request_page", "link_playmode_panel")), 4);
        return;
    L17:
        return;
    }

    public StarWishWidget() {
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r3) {
        int r4 = gj0.h.a;
        gj0.h.b(getContext(), null, 6);
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r3) {
        int r4 = gj0.h.a;
        gj0.h.b(getContext(), null, 6);
    }
}
