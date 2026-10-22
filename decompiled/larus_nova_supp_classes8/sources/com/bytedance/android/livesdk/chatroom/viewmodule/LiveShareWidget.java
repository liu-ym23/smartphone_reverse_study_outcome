package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.net.Uri;
import com.bytedance.android.live.base.model.commerce.DouPlusEntry;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q4;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusEcpService;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveShareWidget extends LiveWidget {
    public final CompositeDisposable a;
    public boolean b;
    public Room c;
    public User d;
    public final a2 e;

    public final String getSpm() {
        return "a100.a100.a246";
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.chatroom.viewmodule.a2] */
    public LiveShareWidget() {
        this.a = new CompositeDisposable();
        this.e = new a2(this);
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        Boolean r1 = Boolean.FALSE;
        this.b = ((Boolean) r0.get("data_is_anchor", r1)).booleanValue();
        this.c = (Room) ((Widget) this).dataCenter.get("data_room");
        this.d = (User) ((Widget) this).dataCenter.get("data_user_in_room");
        ((Widget) this).dataCenter.observe("cmd_wanna_share_live", this.e);
        if (tb1.c.a == false) goto L23;
        ILiveDouPlusService r2 = jc1.k.f(ILiveDouPlusService.class);
        ILiveDouPlusEcpService r3 = r2.getEcpService();
        long r4 = this.c.getId();
        String r5 = this.c.author().getCastSecUid();
        String r7 = "tool_panel";
        if (this.c.getSceneTypeInfo() == null) goto L18;
        if (this.c.getSceneTypeInfo().getIsLastedGoodsRoom() == false) goto L18;
        if (r3 == null) goto L18;
        Uri.Builder r6 = UriProtector.parse((String) r3.getDouPlusEcpInfo().getSecond()).buildUpon();
        Uri.Builder r8 = r6.appendQueryParameter("sec_anchor_id", r5).appendQueryParameter("room_id", String.valueOf(r4));
        if (this.b == true) goto L13;
        r7 = "share_panel";
    L13:
        r8.appendQueryParameter("entrance_type", r7);
        if (this.b == false) goto L16;
        r6.appendQueryParameter("utm_term", "dou-live-more-zhubo");
    L16:
        com.bytedance.android.livesdk.utils.c1.j(new DouPlusEntry(true, r6.toString()), this.c, ((Widget) this).dataCenter);
        com.bytedance.android.livesdk.business.douplus.h.g(this.b, ((Widget) this).dataCenter);
        int r9 = q4.e;
        q4.a.b(((Widget) this).dataCenter);
        return;
    L18:
        if (this.b == false) goto L20;
        String r10 = "tool_panel";
    L21:
        r2.showDouPlusLiveEntry(r5, r4, r10, new b2(this));
        ((Widget) this).dataCenter.put("data_ren_qi_bao_button_dismiss", r1);
        return;
    L20:
        r10 = "share_panel";
        goto L21
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ((Widget) this).dataCenter.removeObserver(this.e);
        this.a.clear();
    }
}
