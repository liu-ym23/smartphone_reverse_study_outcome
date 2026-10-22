package com.bytedance.android.livesdk.feed.openui.view;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.livesdk.feed.z0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import org.json.JSONObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends q0 {
    public final /* synthetic */ HSLargeLiveCardView a;
    public final /* synthetic */ long[] b;
    public final /* synthetic */ Room c;

    public final void g(k r4) {
        this.b[0] = SystemClock.currentThreadTimeMillis();
        HashMap r5 = new HashMap();
        r5.put("enter_from_merge", this.a.i);
        r5.put("enter_method", "live_window");
        User r0 = this.c.getOwner();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getUserId();
        if (r2 == null) goto L6;
    L7:
        r5.put("anchor_id", r2);
        String r3 = this.c.getRequestId();
        if (r3 == null) goto L11;
        r1 = r3;
    L11:
        r5.put("request_id", r1);
        r5.put("room_id", String.valueOf(this.c.id));
        r5.put("event_belong", "live_view");
        r5.put("event_page", "live");
        r5.put("event_type", "core");
        kw1.c.d("live_cover_show_start", r5);
        z0 r6 = this.a.f;
        if (r6 == null) goto L15;
        r6.c = SystemClock.uptimeMillis();
        return;
    L15:
        return;
    L6:
        r2 = "";
        goto L7
    }

    public final void f(k r7, Exception r8) {
        HashMap r0 = new HashMap();
        r0.put("enter_from_merge", this.a.i);
        r0.put("enter_method", "live_window");
        User r1 = this.c.getOwner();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.getUserId();
        if (r3 == null) goto L6;
    L7:
        r0.put("anchor_id", r3);
        String r4 = this.c.getRequestId();
        if (r4 == null) goto L11;
        r2 = r4;
    L11:
        r0.put("request_id", r2);
        r0.put("room_id", String.valueOf(this.c.id));
        r0.put("is_success", "0");
        r0.put("time", String.valueOf(SystemClock.currentThreadTimeMillis() - this.b[0]));
        r0.put("event_belong", "live_view");
        r0.put("event_page", "live");
        r0.put("event_type", "core");
        kw1.c.d("live_cover_show_finish", r0);
        z0 r5 = this.a.f;
        if (r5 == null) goto L18;
        if (r7 == null) goto L15;
        String r9 = r7.getUri();
    L16:
        r5.o(r8, r9);
        return;
    L15:
        r9 = null;
        goto L16
    L18:
        return;
    L6:
        r3 = "";
        goto L7
    }

    public b(HSLargeLiveCardView r1, long[] r2, Room r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void h(k r9, int r10, int r11) {
        HashMap r12 = new HashMap();
        r12.put("enter_from_merge", this.a.i);
        r12.put("enter_method", "live_window");
        User r13 = this.c.getOwner();
        String r0 = "";
        if (r13 == null) goto L6;
        String r14 = r13.getUserId();
        if (r14 == null) goto L6;
    L7:
        r12.put("anchor_id", r14);
        String r15 = this.c.getRequestId();
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        r12.put("request_id", r15);
        r12.put("room_id", String.valueOf(this.c.id));
        r12.put("is_success", "1");
        r12.put("time", String.valueOf(SystemClock.currentThreadTimeMillis() - this.b[0]));
        r12.put("event_belong", "live_view");
        r12.put("event_page", "live");
        r12.put("event_type", "core");
        kw1.c.d("live_cover_show_finish", r12);
        z0 r16 = this.a.f;
        if (r16 == null) goto L21;
        if (r9 == null) goto L16;
        r0 = r9.getUri();
    L16:
        if (r16.c <= 0) goto L18;
        long r1 = SystemClock.uptimeMillis() - r16.c;
    L19:
        r16.c = 0;
        JSONObject r17 = new JSONObject();
        BaseMonitor.add(r17, "url", r0);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_feed_image_load_all", 0, r1, r17);
        return;
    L18:
        r1 = 0;
        goto L19
    L21:
        return;
    L6:
        r14 = "";
        goto L7
    }
}
