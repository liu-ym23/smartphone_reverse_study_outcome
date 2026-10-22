package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.h4;
import com.bytedance.android.livesdk.config.setting.s;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static Disposable a;
    public static a b;
    public static DataCenter c;

    public interface a {
        void a(Long r1, int r2);
    }

    public static final class b<T> implements Observer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void onChanged(Object r5) {
            KVData r6 = (KVData) r5;
            if (r6 == null) goto L5;
            String r1 = r6.getKey();
        L6:
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.hashCode() == 919040494) goto L12;
            return;
        L12:
            if (r1.equals("data_live_mini_app_commerce_status") == true) goto L14;
            return;
        L14:
            if (s.b() == false) goto L17;
            return;
        L17:
            if (((p2) r6.getData()) == null) goto L28;
            Disposable r7 = e.a;
            boolean r8 = tb1.c.a;
            y3.f(e.c).i(ToolbarButton.TICKET_SALE_ANCHOR_MORE.extended());
            a r9 = e.b;
            if (r9 == null) goto L22;
            int r2 = h4.j;
            r9.a(null, 0);
        L22:
            y3.m(e.c).i(ToolbarButton.TICKET_SALE_ANCHOR.extended());
            return;
        L28:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static void a() {
        DataCenter r0 = c;
        LiveMode r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("data_paid_live_sell_ticket_owner_id", "");
    L6:
        DataCenter r3 = c;
        if (r3 == null) goto L9;
        Room r4 = z.o(r3);
    L11:
        if (TextUtils.isEmpty(r2) == true) goto L20;
        if (r4 == null) goto L16;
        User r5 = r4.getOwner();
        if (r5 == null) goto L16;
        String r6 = r5.getIdString();
    L18:
        if (TextUtils.equals(r6, r2) == false) goto L20;
        boolean r7 = true;
    L21:
        Pair[] r8 = new Pair[4];
        r8[0] = TuplesKt.to("enter_from_merge", "live_room");
        if (r4 == null) goto L24;
        r1 = r4.getStreamType();
    L24:
        int r9 = h1.a;
        r8[1] = TuplesKt.to("live_type", i1.a(r1));
        if (r7 == false) goto L27;
        String r10 = "1";
    L28:
        r8[2] = TuplesKt.to("is_creator_anchor", r10);
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, c, 0, 2);
        if (r11 == null) goto L34;
        com.bytedance.live.datacontext.m r12 = r11.getAnchorPaidLiveCreateRights();
        if (r12 == null) goto L34;
        Object r13 = (List) r12.getValue();
        if (r13 == null) goto L34;
    L35:
        r8[3] = TuplesKt.to("carry_ticket_authorization_level_v2", r13.toString());
        u.l().sendLog("livesdk_anchor_paidcontent_icon_show", MapsKt.mutableMapOf(r8), new Object[]{Room.class, x.class});
        return;
    L34:
        r13 = new ArrayList();
        goto L35
    L27:
        r10 = "0";
    L16:
        r6 = null;
    L20:
        r7 = false;
        goto L21
    L9:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    static {
    }
}
