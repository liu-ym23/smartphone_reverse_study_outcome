package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.RoomOwner;
import com.bytedance.android.live.base.model.user.f0;
import com.bytedance.android.live.base.model.user.x;
import com.bytedance.android.live.base.model.user.z;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements RoomImageLayoutController.a {
    public final /* synthetic */ d a;

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController.a
    public final void a() {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController.a
    public final void onUnload() {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController.a
    public final ViewGroup getContainer() {
        View r0 = this.a.f;
        if ((r0 instanceof ViewGroup) == true) goto L6;
        r0 = null;
    L6:
        return (ViewGroup) r0;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController.a
    public final void onShow() {
        IRoom r0 = this.a.d;
        f0 r2 = null;
        if (r0 != null) goto L5;
    L10:
        d r1 = this.a;
        IRoom r3 = r1.d;
        if (r3 == null) goto L19;
        IBaseUser r4 = r3.getOwner();
        if (r4 == null) goto L19;
        x r5 = r4.getIndustryCertification();
        if (r5 == null) goto L19;
        z r6 = r5.getRoom();
        if (r6 == null) goto L19;
        f0 r7 = r6.getMRoomOwner();
    L21:
        if ((r7 instanceof RoomOwner) == false) goto L24;
        r2 = r7;
    L24:
        RoomOwner r8 = (RoomOwner) r2;
        if (r8 != null) goto L27;
        return;
    L27:
        if (r8.getType() != 106) goto L50;
        t r9 = j0.l().c(am2.x.class);
        if ((r9 instanceof t) == false) goto L49;
        t r10 = r9;
        String r12 = (String) r10.getMap().get("enter_from_merge");
        String r13 = (String) r10.getMap().get("enter_method");
        if (r12 != null) goto L34;
        r12 = "";
    L34:
        if (r13 != null) goto L36;
        r13 = "";
    L36:
        HashMap r14 = new HashMap();
        IRoom r15 = r1.d;
        if (r15 == null) goto L40;
        String r16 = String.valueOf(r15.getId());
        if (r16 == null) goto L40;
    L41:
        r14.put("room_id", r16);
        r14.put("EVENT_ORIGIN_FEATUR", "TEMAI");
        r14.put("enter_from_merge", r12);
        r14.put("enter_method", r13);
        IRoom r17 = r1.d;
        if (r17 == null) goto L45;
        String r18 = r17.getOwnerUserIdString();
        if (r18 == null) goto L45;
    L46:
        r14.put("anchor_id", r18);
        r14.put("_param_live_platform", "live");
        r14.put("action_type", r1.e.get("log_action_type", ""));
        r14.put("is_flagship_room", DataType.TRUE);
        r14.put("is_flash", DataType.FALSE);
        j0.l().sendLog("livesdk_flagship_label_show", r14, new Object[0]);
        return;
    L45:
        r18 = "";
    L40:
        r16 = "";
        goto L41
    L49:
        return;
    L50:
        return;
    L19:
        r7 = null;
        goto L21
    L5:
        if (r0.isVipRoom() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        j0.l().sendLog("livesdk_livevip_exclusive_live_show", null, new Object[]{new am2.x(), IRoom.class});
        goto L10
    }

    public e(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController.a
    public final void b(Bitmap r5, ImageView r6, py.k r7) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Intrinsics.checkNotNullParameter(r6, "certImg");
        Intrinsics.checkNotNullParameter(r7, "imageModel");
        if (r5.getHeight() == 0) goto L6;
        r6.setLayoutParams(new FrameLayout.LayoutParams(s1.f((float) ((((double) r5.getWidth()) * 10.0d) / ((double) r5.getHeight()))), s1.f(10)));
        return;
    }
}
