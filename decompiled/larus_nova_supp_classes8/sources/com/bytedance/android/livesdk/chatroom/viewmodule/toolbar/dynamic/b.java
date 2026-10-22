package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.ei1;
import com.bytedance.android.livesdk.config.j4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> a = null;
    public static final b b = null;

    public interface a {
        boolean a(Room r1);

        String getName();
    }

    public b() {
    }

    static {
        b = new b();
        a = new com.bytedance.android.livesdk.sharedpref.e("live_toolbar_alog_upload_record", 0L);
    }

    public static void c(int r3, boolean r4, String r5) {
        LiveMonitor.a r0 = new LiveMonitor.a("ttlive_common_slot_error_alog_upload", LiveTracingMonitor.EventModule.common);
        r0.l(0);
        r0.e("id", String.valueOf(r3));
        if (r4 == false) goto L5;
        String r6 = "1";
    L6:
        r0.e("isAnchor", r6);
        r0.e("type", r5);
        r0.a().report();
        return;
    L5:
        r6 = "0";
        goto L6
    }

    public final void a(int r19, String r20, boolean r21) {
        String r3 = String.valueOf(r19);
        String r4 = q.c(r19);
        ALogger.i("NewToolbarLog", "ToolbarCheck : " + r3 + ' ' + r20 + " reason: " + r4);
        xs2.b.a().post(new zg1.h("ToolbarCheck", "ToolbarCheck : " + r3 + ' ' + r20 + " reason: " + r4));
        String r7 = "";
        if ((!Intrinsics.areEqual(r20, "Success")) == false) goto L52;
        if (StringsKt.contains$default(r4, ToolbarReasonTag.NORMAL.getTag(), false, 2, null) == true) goto L52;
        b(r19, r20, r21, r4, "");
        if (Intrinsics.areEqual(r20, "Success") == true) goto L59;
        ei1 r5 = j4.a.getValue();
        if (r5.b() == true) goto L13;
        return;
    L13:
        if (r5.e() != (-1)) goto L15;
    L17:
        String r6 = r5.d();
        if (r6 != null) goto L20;
    L27:
        String r8 = r5.c();
        if (r8 != null) goto L30;
    L55:
        int r9 = r5.a();     // Catch: Exception -> L45
        int r10 = r5.f();     // Catch: Exception -> L45
        long r11 = System.currentTimeMillis() / ((long) BubbleId.PadCast);     // Catch: Exception -> L45
        com.bytedance.android.livesdk.sharedpref.e<Long> r12 = a;     // Catch: Exception -> L45
        if ((r11 - ((Number) r12.getValue()).longValue()) <= r10) goto L43;
        long r13 = r11 - ((long) r9);     // Catch: Exception -> L45
        IHostMonitor r14 = jc1.k.f(IHostMonitor.class);     // Catch: Exception -> L45
        if (r14 == null) goto L42;
        r14.uploadALog(r13, r11, "ttlive_toolbar");     // Catch: Exception -> L45
    L42:
        com.bytedance.android.livesdk.sharedpref.f.d(r12, Long.valueOf(r11));     // Catch: Exception -> L45
        c(r19, r21, r20);     // Catch: Exception -> L45
        ALogger.i("NewToolbarLog", "upload alog success");     // Catch: Exception -> L45
        return;
    L43:
        ALogger.i("NewToolbarLog", "upload alog interval");     // Catch: Exception -> L45
        return;
    L45:
        e = move-exception;
        String r0 = e.toString();
        if (r0 == null) goto L50;
        r7 = r0;
    L50:
        ALogger.i("NewToolbarLog", "upload alog error! ".concat(r7));
        return;
    L30:
        if (r8.length() <= 0) goto L32;
        boolean r15 = true;
    L33:
        if (r15 != true) goto L55;
        if (StringsKt.contains$default(r4, r5.c(), false, 2, null) == true) goto L55;
        return;
    L32:
        r15 = false;
        goto L33
    L20:
        if (r6.length() <= 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 != true) goto L27;
        if ((!Intrinsics.areEqual(r20, r5.d())) == false) goto L27;
        return;
    L22:
        r16 = false;
        goto L23
    L15:
        if (r19 == r5.e()) goto L17;
        return;
    L59:
        return;
    L52:
        if (Intrinsics.areEqual(r20, "Success") == false) goto L58;
        b(r19, r20, r21, r4, "");
        return;
    }

    public static void b(int r6, String r7, boolean r8, String r9, String r10) {
        s r0 = new s();
        r0.a = r6;
        r0.l.b = false;
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L18;
        RoomContext r12 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r12 == null) goto L16;
        com.bytedance.live.datacontext.m r13 = r12.getRoom();
        if (r13 == null) goto L16;
        Room r14 = (Room) r13.getValue();
        if (r14 == null) goto L16;
        String r15 = String.valueOf(r14.id);
        if (r15 == null) goto L16;
    L17:
        r10 = r15;
    L16:
        r15 = "";
    L18:
        Pair[] r16 = new Pair[7];
        r16[0] = TuplesKt.to("action", "ToolbarCheck");
        r16[1] = TuplesKt.to("result", r7);
        r16[2] = TuplesKt.to("id", String.valueOf(r0.a));
        if (r8 == false) goto L21;
        String r17 = "1";
    L22:
        r16[3] = TuplesKt.to("isAnchor", r17);
        r16[4] = TuplesKt.to("roomId", r10);
        r16[5] = TuplesKt.to("reason", r9);
        r16[6] = TuplesKt.to("fromMsg", String.valueOf(r0.l.b));
        Map r18 = MapsKt.mapOf(r16);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_toolbar_check_load_icon", r18, new Object[]{Room.class, am2.x.class});
        return;
    L21:
        r17 = "0";
        goto L22
    L5:
        r11 = false;
        goto L7
    }
}
