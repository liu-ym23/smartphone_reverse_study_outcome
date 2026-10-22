package com.bytedance.android.live.componentsmarket.impl.components.close;

import am2.x;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.u21;
import com.bytedance.android.livesdk.config.zu;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import ev1.p;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends com.bytedance.android.live.core.tetris.task.a {
    public final /* synthetic */ RoomCloseWidget c;
    public final /* synthetic */ d90.a d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            RxBusAbility.INSTANCE.getRxBus(this.a.d.h).post(new pt2.a(null));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            int r0 = com.bytedance.android.live.componentsmarket.impl.components.close.b.a;
            new com.bytedance.android.live.componentsmarket.impl.components.close.a(this.a.d).onClick(r6);
            j0 r7 = j0.l();
            Pair[] r1 = new Pair[3];
            r1[0] = TuplesKt.to("icon_location", GamePromoteDataContext.GAME_TYPE_MOBILE);
            Room r2 = d90.c.q(this.a.d);
            String r3 = null;
            if (r2 == null) goto L5;
            String r4 = r2.getIdStr();
        L6:
            r1[1] = TuplesKt.to("room_id", String.valueOf(r4));
            Room r5 = d90.c.q(this.a.d);
            if (r5 == null) goto L9;
            r3 = r5.getOwnerUserIdString();
        L9:
            r1[2] = TuplesKt.to("anchor_id", String.valueOf(r3));
            r7.sendLog("livesdk_leave_icon_click", MapsKt.mutableMapOf(r1), new Object[]{IRoom.class, x.class});
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        public final void a() {
            j0 r0 = j0.l();
            Pair[] r1 = new Pair[3];
            r1[0] = TuplesKt.to("icon_location", GamePromoteDataContext.GAME_TYPE_MOBILE);
            Room r2 = d90.c.q(this.a.d);
            String r4 = null;
            if (r2 == null) goto L5;
            String r3 = r2.getIdStr();
        L6:
            r1[1] = TuplesKt.to("room_id", String.valueOf(r3));
            Room r5 = d90.c.q(this.a.d);
            if (r5 == null) goto L9;
            r4 = r5.getOwnerUserIdString();
        L9:
            r1[2] = TuplesKt.to("anchor_id", String.valueOf(r4));
            r0.sendLog("livesdk_leave_icon_show", MapsKt.mutableMapOf(r1), new Object[]{IRoom.class, x.class});
            return;
        L5:
            r3 = null;
            goto L6
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object r2 = null;
        View r3 = null;
        if (p.c(this.d.h) == false) goto L37;
        ViewGroup r0 = this.c.Z();
        if (r0 == null) goto L7;
        View r1 = r0.findViewById(2131375921);
    L8:
        if (r1 == null) goto L11;
        r1.setOnClickListener(new a(this));
    L11:
        if (p.e(this.d.h) == false) goto L13;
        String r4 = GamePromoteDataContext.GAME_TYPE_MINI;
    L14:
        RoomCloseWidget r5 = this.c;
        r5.getClass();
        Pair[] r6 = new Pair[3];
        r6[0] = TuplesKt.to("icon_location", r4);
        DataCenter r7 = ((d90.a) r5.K()).h;
        if (r7 == null) goto L19;
        Room r8 = z.o(r7);
        if (r8 == null) goto L19;
        String r9 = r8.getIdStr();
    L20:
        r6[1] = TuplesKt.to("room_id", String.valueOf(r9));
        DataCenter r11 = ((d90.a) r5.K()).h;
        if (r11 == null) goto L25;
        Room r12 = z.o(r11);
        if (r12 == null) goto L25;
        String r13 = r12.getOwnerUserIdString();
    L26:
        r6[2] = TuplesKt.to("anchor_id", String.valueOf(r13));
        Map r14 = MapsKt.mutableMapOf(r6);
        ViewGroup r15 = r5.Z();
        if (r15 == null) goto L29;
        r3 = r15.findViewById(2131366999);
    L29:
        if (r3 == null) goto L31;
        r3.setOnClickListener(new com.bytedance.android.live.componentsmarket.impl.components.close.c(r5, r14));
    L31:
        r5.h0(new d(r14));
        d90.a r16 = this.d;
        if (r16 == null) goto L55;
        DataCenter r17 = r16.h;
        if (r17 == null) goto L55;
        r17.put("key_report_more_btn_click_location", r4);
    L55:
        b(true);
        return;
    L25:
        r13 = null;
    L19:
        r9 = null;
        goto L20
    L13:
        r4 = "3";
        goto L14
    L7:
        r1 = null;
        goto L8
    L37:
        if (this.c.Z() == null) goto L55;
        ViewGroup r18 = this.c.Z();
        if (r18 == null) goto L41;
        r18.setOnClickListener(new b(this));
    L41:
        zu r19 = zu.a;
        if (((u21) r19.getValue()).b() == false) goto L54;
        RoomCloseWidget r21 = this.c;
        ViewGroup r22 = r21.Z();
        if (r22 == null) goto L46;
        r2 = r22.getParent();
    L46:
        View r23 = (View) r2;
        if (r23 == null) goto L54;
        Rect r24 = new Rect();
        r21.Z().getHitRect(r24);
        r24.top -= a1.h(r21.Z());
        r24.right += a1.g(r21.Z());
        r24.left -= a1.f(r21.Z());
        if (a1.e(r21.Z()) != 0) goto L52;
        r24.bottom += s1.f(((u21) r19.getValue()).a());
    L53:
        r23.setTouchDelegate(new e(r24, r21.Z()));
        goto L54
    L52:
        r24.bottom += a1.e(r21.Z());
    L54:
        this.c.h0(new c(this));
        goto L55
    }

    public f(RoomCloseWidget r1, d90.a r2) {
        this.c = r1;
        this.d = r2;
        super("live_close_view");
    }
}
