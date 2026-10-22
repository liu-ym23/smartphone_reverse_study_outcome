package e92;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public g(k r1, String r2) {
        this.a = r1;
        this.b = r2;
        this.c = "connection_manage_setting";
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r9, int r10) {
        r9.dismiss();
        k r11 = this.a;
        String r13 = this.b;
        String r0 = this.c;
        if (r11.c == true) goto L17;
        r11.c = true;
        com.bytedance.android.livesdk.user.f r1 = jc1.k.n(IUserService.class).user();
        com.bytedance.android.livesdk.user.m.c r2 = new com.bytedance.android.livesdk.user.m.c();
        Context r3 = r11.d;
        if ((r3 instanceof Activity) == true) goto L8;
        r3 = null;
    L8:
        Activity r4 = (Activity) r3;
        com.bytedance.android.livesdk.user.m.c r5 = r2.c(r13);
        long r6 = 0;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L15;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L15;
        Room r14 = (Room) r8.getValue();
        if (r14 == null) goto L15;
        r6 = r14.getRoomId();
    L15:
        com.bytedance.android.livesdk.user.m.c r15 = r5.f(r6).e(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.MULTI_ANCHOR_PANEL));
        r15.getClass();
        RxUtilKt.c(r1.i(new com.bytedance.android.livesdk.user.m(r15)).subscribe(new i(r11, r13, r0), new j(r11)), r11.b);
        return;
    }
}
