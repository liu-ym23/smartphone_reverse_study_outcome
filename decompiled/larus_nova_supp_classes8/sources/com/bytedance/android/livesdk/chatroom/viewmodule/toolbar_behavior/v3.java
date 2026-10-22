package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdk.record.admin.AdminRecordManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, tp2.a.b {
    public final Context a;
    public final Room b;
    public com.bytedance.android.live.pushstream.d c;
    public View d;
    public Disposable e;
    public boolean f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final boolean a() {
        Context r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getResources().getConfiguration().orientation != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final void b(boolean r11) {
        if (this.c == null) goto L5;
    L11:
        xs2.b.a().post(new zg1.n1(this.c, this, false, 0, r11, "more_function"));
        HashMap r12 = new HashMap();
        r12.put("anchor_id", String.valueOf(this.b.author().getIdString()));
        r12.put("room_id", String.valueOf(this.b.getId()));
        AdminRecordManager.k(r12);
        if (a() == false) goto L14;
        String r0 = "0";
    L15:
        r12.put("room_orientation", r0);
        if (a() == false) goto L18;
        String r1 = "more_function";
    L19:
        r12.put("enter_way", r1);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_pm_live_record_screen_click", r12, new Object[]{new am2.x(), Room.class});
        return;
    L18:
        r1 = "button";
        goto L19
    L14:
        r0 = "1";
        goto L15
    L5:
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L9;
        com.bytedance.android.scope.m r2 = com.bytedance.android.scope.m.e;
        f00.a.a r3 = f00.a.b;
        if (r2.d(r3, g00.c.class) == null) goto L10;
        ((g00.c) r2.d(r3, g00.c.class)).init();
    L10:
        this.c = jc1.k.f(IPushStreamService.class).getRecordLiveStream(this.a);
        goto L11
    L9:
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).init();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        if ((r2 instanceof pp1.b) == false) goto L8;
        if (this.d == null) goto L8;
        this.f = ((pp1.b) r2).a;
        return;
    L8:
        if ((r2 instanceof pp1.a) == false) goto L12;
        b(true);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.f == true) goto L6;
        return;
    L6:
        if (jc1.k.f(IUserService.class).user().isLogin() == true) goto L9;
        this.e = TTLiveSDKContext.getHostService().h().login(r4.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new u3(this), new com.bytedance.android.live.multilink.impl.o1());
        return;
    L9:
        b(false);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r1, DataCenter r2) {
        Disposable r3 = this.e;
        if (r3 == null) goto L6;
        r3.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        this.d = r4;
        HashMap r6 = new HashMap();
        AdminRecordManager.k(r6);
        if (a() == false) goto L5;
        String r7 = "0";
    L6:
        r6.put("room_orientation", r7);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_record_button_show", r6, new Object[]{Room.class, new am2.x()});
        this.f = true;
        return;
    L5:
        r7 = "1";
        goto L6
    }

    public v3(Context r1, com.bytedance.android.live.pushstream.d r2, Room r3) {
        this.a = r1;
        this.c = r2;
        this.b = r3;
    }
}
