package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.config.ty;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends mx.l {
    public final Room p;
    public final ListDialogAbility q;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.setting.a$a, reason: collision with other inner class name */
    public static final class C0028a {
    }

    static {
    }

    public a(Room r10, ListDialogAbility r11) {
        Intrinsics.checkNotNullParameter(r11, "ability");
        String r2 = s1.B(2131922475);
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.d3;
        Long r1 = (Long) r0.getValue();
        if (r1 != null) goto L6;
    L10:
        String r3 = ty.a.getValue().c();
        if (r3 != null) goto L13;
        r3 = s1.B(2131922472);
    L13:
        String r5 = r3;
        Long r4 = (Long) r0.getValue();
        if (r4 != null) goto L17;
    L19:
        boolean r6 = false;
    L20:
        super(r2, r5, r6, false, false, null, 120);
        this.p = r10;
        this.q = r11;
        return;
    L17:
        if (r4.longValue() != 1) goto L19;
        r6 = true;
        goto L20
    L6:
        if (r1.longValue() != 1) goto L10;
        r3 = ty.a.getValue().b();
        if (r3 != null) goto L13;
        r3 = s1.B(2131922471);
        goto L13
    }

    public final void c(SwitchSettingViewHolder r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r13, "holder");
        ((mx.l) this).l = r14;
        Room r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        long r8 = r0.getRoomId();
        String r1 = this.p.getOwnerUserIdString();
        if (r14 == false) goto L8;
        long r2 = 1;
    L9:
        long r5 = r2;
        Disposable r3 = ((mx.l) this).m;
        if (r3 == null) goto L12;
        r3.dispose();
    L12:
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((mx.l) this).m = ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).updateAudienceAuthSwitch(r8, r1, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r14, r13, r8, r1), new c(this, r14, r8, r1));
        return;
    L8:
        r2 = 2;
        goto L9
    }

    public static final void g(a r1, long r2, String r4, boolean r5, boolean r6) {
        r1.getClass();
        HashMap r3 = new HashMap();
        r3.put("anchor_id", r4.toString());
        r3.put("room_id", String.valueOf(r2));
        if (r5 == false) goto L5;
        String r7 = "turn_on";
    L6:
        r3.put("click_type", r7);
        if (r6 == false) goto L9;
        String r8 = "success";
    L10:
        r3.put("click_result", r8);
        com.bytedance.android.livesdk.log.u.l().sendLog("audience_receive_click", r3, new Object[]{new am2.x(), Room.class});
        return;
    L9:
        r8 = "failure";
        goto L10
    L5:
        r7 = "turn_off";
        goto L6
    }
}
