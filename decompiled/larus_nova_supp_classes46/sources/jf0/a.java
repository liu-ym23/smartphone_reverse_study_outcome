package jf0;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Iterator;
import jc1.k;
import je0.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static boolean e(int r4) {
        y r0 = (y) ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 == null) goto L18;
        Iterator<LinkmicPositionItem> r1 = r0.e.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        LinkmicPositionItem r2 = r1.next();
        if (((int) r2.getPosition()) != r4) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L6;
    L14:
        LinkmicPositionItem r5 = r2;
        if (r5 == null) goto L18;
        String r6 = r5.getActiveName();
        if (r6 == null) goto L18;
    L20:
        return TextUtils.isEmpty(r6);
    L10:
        r3 = false;
        goto L11
    L13:
        r2 = null;
    L18:
        r6 = "";
        goto L20
    }

    public static /* synthetic */ void d(int r2, boolean r3) {
        c(r2, true, e(r2), r3);
    }

    public static /* synthetic */ void b(int r1, boolean r2, String r3, boolean r4) {
        a(r1, r2, e(r1), r3, r4);
    }

    public static void c(int r4, boolean r5, boolean r6, boolean r7) {
        HashMap r0 = new HashMap();
        TalkRoomLogUtils.B0(r0, Integer.valueOf(d.f()), null, 4);
        r0.put("seat_num", String.valueOf(r4));
        String r8 = "1";
        if (r5 == false) goto L5;
        Object r9 = "1";
    L6:
        r0.put("is_guest", r9);
        if (r6 == true) goto L10;
        r8 = "0";
    L10:
        r0.put("is_first_edit", r8);
        if (r7 == false) goto L13;
        String r10 = "administrator";
    L14:
        r0.put("user_type", r10);
        j0.l().sendLog("livesdk_anchor_audience_connection_seat_name_setting_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L13:
        r10 = "anchor";
        goto L14
    L5:
        r9 = "0";
        goto L6
    }

    public final void delete(String r5, int r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "seatName");
        HashMap r0 = new HashMap();
        TalkRoomLogUtils.B0(r0, Integer.valueOf(d.f()), null, 4);
        r0.put("seat_name", r5);
        r0.put("seat_num", String.valueOf(r6));
        if (r7 == false) goto L5;
        String r9 = "1";
    L6:
        r0.put("is_guest", r9);
        if (r8 == false) goto L9;
        String r10 = "administrator";
    L10:
        r0.put("user_type", r10);
        j0.l().sendLog("livesdk_anchor_audience_connection_seat_name_delete", r0, new Object[]{IRoom.class, x.class});
        return;
    L9:
        r10 = "anchor";
        goto L10
    L5:
        r9 = "0";
        goto L6
    }

    public static void a(int r5, boolean r6, boolean r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "button_type");
        HashMap r1 = new HashMap();
        TalkRoomLogUtils.B0(r1, Integer.valueOf(d.f()), null, 4);
        r1.put("seat_num", String.valueOf(r5));
        String r10 = "1";
        if (r6 == false) goto L5;
        Object r11 = "1";
    L6:
        r1.put("is_guest", r11);
        if (r7 == true) goto L10;
        r10 = "0";
    L10:
        r1.put("is_first_edit", r10);
        r1.put("button_type", r8);
        if (r9 == false) goto L13;
        String r12 = "administrator";
    L14:
        r1.put("user_type", r12);
        Integer r13 = d.h();
        if (r13 != null) goto L18;
    L20:
        String r14 = "classic";
    L21:
        r1.put("play_layout", r14);
        j0.l().sendLog("livesdk_anchor_audience_connection_seat_name_edit", r1, new Object[]{IRoom.class, x.class});
        return;
    L18:
        if (r13.intValue() != 28) goto L20;
        r14 = "avatar";
        goto L21
    L13:
        r12 = "anchor";
        goto L14
    L5:
        r11 = "0";
        goto L6
    }
}
