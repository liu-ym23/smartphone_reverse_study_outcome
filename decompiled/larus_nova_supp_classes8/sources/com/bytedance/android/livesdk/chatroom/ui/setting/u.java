package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u extends mx.j {
    public static final /* synthetic */ int m = 0;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ListDialogAbility a;

        public a(ListDialogAbility r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LiveRoomManageAppLogger.j();
            this.a.jumpSubpage(5);
            if (RoomPermissionContext.a.c(RoomPermissionContext.Companion) == false) goto L5;
            Boolean r0 = Boolean.FALSE;
            com.bytedance.android.livesdk.sharedpref.e r5 = new com.bytedance.android.livesdk.sharedpref.e("hint_refine_permission_ever_click", r0);
            Boolean r1 = Boolean.TRUE;
            com.bytedance.android.livesdk.sharedpref.f.d(r5, r1);
            com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("live_privilege_barrage_hint", r0), r1);
            com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("has_show_admin_pin_flag", r0), r1);
            return;
        L5:
            com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("anchor_room_manage_ever_click", Boolean.FALSE), Boolean.TRUE);
        }
    }

    public static final class b {
        public static final String a() {
            int r0 = u.m;
            boolean r1 = RoomPermissionContext.a.c(RoomPermissionContext.Companion);
            boolean r2 = false;
            if (r1 == false) goto L19;
            Boolean r4 = Boolean.FALSE;
            if (Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e("has_show_admin_pin_flag", r4).getValue(), r4) == false) goto L19;
            RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r3 == null) goto L19;
            com.bytedance.live.datacontext.m r5 = r3.getRoom();
            if (r5 == null) goto L19;
            Room r6 = (Room) r5.getValue();
            if (r6 == null) goto L19;
            Map r7 = r6.anchorAbMap;
            if (r7 == null) goto L19;
            String r8 = (String) r7.get("admin_pin_ab_group");
            if (r8 == null) goto L19;
            if (r8.equals("1") != true) goto L19;
            boolean r9 = true;
        L20:
            if (r1 == false) goto L24;
            Boolean r10 = Boolean.FALSE;
            if (Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e("hint_refine_permission_ever_click", r10).getValue(), r10) == false) goto L24;
            boolean r11 = true;
        L25:
            Boolean r12 = Boolean.FALSE;
            boolean r13 = Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e("anchor_room_manage_ever_click", r12).getValue(), r12);
            if (((Boolean) com.bytedance.android.livesdk.chatroom.setting.j.c.getValue()).booleanValue() == true) goto L28;
        L30:
            if (r11 == true) goto L35;
            if (r1 == true) goto L34;
            if (r13 == true) goto L35;
        L34:
            return "";
        L35:
            if (r9 == false) goto L37;
            int r14 = 2131922840;
        L43:
            return s1.B(r14);
        L37:
            if (r2 == false) goto L39;
            r14 = 2131922843;
            goto L43
        L39:
            if (r11 == false) goto L41;
            r14 = 2131922842;
            goto L43
        L41:
            r14 = 2131922852;
            goto L43
        L28:
            if (Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e("live_privilege_barrage_hint", r12).getValue(), r12) == false) goto L30;
            r2 = true;
        L24:
            r11 = false;
        L19:
            r9 = false;
            goto L20
        }

        public b() {
        }
    }

    static {
        new b();
    }

    public u(ListDialogAbility r5) {
        Intrinsics.checkNotNullParameter(r5, "ability");
        String r0 = s1.B(2131919755);
        String r1 = b.a();
        if (b.a().length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        super(r0, r1, r2, 4);
        ((mx.j) this).l = new a(r5);
        return;
    L5:
        r2 = false;
        goto L6
    }
}
