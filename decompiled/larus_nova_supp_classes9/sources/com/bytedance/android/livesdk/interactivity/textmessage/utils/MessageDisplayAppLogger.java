package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import am2.x;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MessageDisplayAppLogger {
    static {
    }

    @JvmStatic
    public static final void a(final c4 r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        b("livesdk_anchor_aggregated_message_show", new MessageDisplayAppLogger$sendAnchorAggregatedMessageShow$1(r1));
    }

    public static void b(String r4, Function1 r5) {
        HashMap r0 = new HashMap();     // Catch: Exception -> L4
        r5.invoke(r0);     // Catch: Exception -> L4
        j0.l().sendLog(r4, r0, new Object[]{new x(), IRoom.class});     // Catch: Exception -> L4
        return;
    }

    @JvmStatic
    public static final void d(final long r7, final long r9) {
        final String r3 = "hit_paid_relationship_gointo_overtime";
        Intrinsics.checkNotNullParameter("hit_paid_relationship_gointo_overtime", "msgShowType");
        b("livesdk_screen_system_msg_show_duration", new MessageDisplayAppLogger$sendSystemMessageShowDurationEvent$1(r7, r3, r9));
    }

    @JvmStatic
    public static final void e(final long r8, final String r10, final String r11, final boolean r13, final Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r10, "msgShowType");
        Intrinsics.checkNotNullParameter(r11, "anchorId");
        if (Intrinsics.areEqual(r10, "ticket_purchase") == false) goto L5;
        j0.l().sendLog("livesdk_paidlive_anchor_tips_show", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_paidlive", "1")}), new Object[]{IRoom.class, x.class});
    L5:
        b("livesdk_screen_system_msg_show", new MessageDisplayAppLogger$sendSystemMessageShowEvent$1(r8, r10, r11, r14, r13));
    }

    @JvmStatic
    public static final void c(final long r9, final String r11, final String r13, final boolean r14, final Map<String, String> r15, final String r16) {
        Intrinsics.checkNotNullParameter(r11, "msgShowType");
        Intrinsics.checkNotNullParameter(r13, "anchorId");
        b("livesdk_screen_system_msg_click", new MessageDisplayAppLogger$sendSystemMessageClickEvent$1(r9, r11, r13, r15, r16, r14));
    }
}
