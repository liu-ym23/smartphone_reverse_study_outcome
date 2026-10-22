package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityTraceMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static long c(Long r7) {
        if (r7 != null) goto L5;
        return 0;
    L5:
        if (r7.longValue() > 0) goto L7;
        return 0;
    L7:
        if (r7.longValue() < System.currentTimeMillis()) goto L9;
        return 0;
    L9:
        return System.currentTimeMillis() - r7.longValue();
    }

    public static String d(Throwable r2) {
        if (r2 != null) goto L5;
        return CardLockInfo.sUNKNOWN;
    L5:
        if ((r2 instanceof ApiServerException) == false) goto L8;
        StringBuilder r0 = new StringBuilder("api error, code is ");
        ApiServerException r3 = (ApiServerException) r2;
        r0.append(r3.getErrorCode());
        r0.append(", prompts is ");
        r0.append(r3.getPrompt());
        return r0.toString();
    L8:
        return "message is " + r2.getMessage();
    }

    public static int e(Throwable r1) {
        if ((r1 instanceof ApiServerException) == true) goto L7;
        return 999;
    L7:
        return ((ApiServerException) r1).getErrorCode();
    }

    public static String f(Throwable r0) {
        if (r0 != null) goto L5;
        return CardLockInfo.sUNKNOWN;
    L5:
        if ((r0 instanceof ApiServerException) == false) goto L7;
        return "api error";
    L7:
        return "local error";
    }

    public static void m(com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r7) {
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("log_info", String.valueOf(r7));
        Unit r8 = Unit.INSTANCE;
        new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, 0, r5, 7).b(InteractivityTraceMonitor.Event.ChatChannelTryCreate);
    }

    public static void j(Map r2, s22.a r3) {
        r2.put("channel_id", String.valueOf(r3.getChannelId()));
        if (((Boolean) r3.v().a).booleanValue() == false) goto L5;
        String r0 = "owner";
    L6:
        r2.put("channel_role", r0);
        r2.put("channel_owner_id", ((User) r3.getOwner().a).getIdStr());
        r2.put("channel_member_count", String.valueOf(((Number) r3.d0().a).longValue()));
        r2.put("channel_current_member_invite_switch", String.valueOf(((Boolean) r3.z().a).booleanValue()));
        r2.put("channel_type", String.valueOf(r3.y()));
        r2.put("channel_status", String.valueOf(r3.b()));
        FansChannelCreateInfo r1 = r3.C();
        if (r1 == null) goto L9;
        Long r4 = Long.valueOf(r1.getFansChannelType());
    L10:
        r2.put("sub_create_type", String.valueOf(r4));
        r2.put("is_valid", String.valueOf(r3.s()));
        String r5 = (String) r2.put("is_guide_show", String.valueOf(r3.x()));
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r0 = "guest";
        goto L6
    }

    public static void l(RoomChannelInfo r8, boolean r9) {
        if (r8 != null) goto L4;
        int r2 = -1;
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("is_from_wrds", String.valueOf(r9));
        String r10 = null;
        if (r8 == null) goto L8;
        Long r0 = Long.valueOf(r8.getChannelId());
    L9:
        r6.put("channel_id", String.valueOf(r0));
        if (r8 == null) goto L12;
        Long r1 = Long.valueOf(r8.getCreateType());
    L13:
        r6.put("create_type", String.valueOf(r1));
        if (r8 == null) goto L18;
        FansChannelCreateInfo r3 = r8.getFansChannelCreateInfo();
        if (r3 == null) goto L18;
        Long r4 = Long.valueOf(r3.getFansChannelType());
    L19:
        r6.put("sub_create_type", String.valueOf(r4));
        if (r8 == null) goto L22;
        Long r5 = r8.getChannelState();
    L23:
        r6.put("channel_status", String.valueOf(r5));
        if (r8 == null) goto L26;
        Long r7 = Long.valueOf(r8.getMemberCount());
    L27:
        r6.put("member_count", String.valueOf(r7));
        if (r8 == null) goto L32;
        User r11 = r8.getOwner();
        if (r11 == null) goto L32;
        r10 = r11.getIdStr();
    L32:
        r6.put("owner", String.valueOf(r10));
        Unit r13 = Unit.INSTANCE;
        new com.bytedance.android.livesdk.interactivity.api.monitor.c(r2, null, 0, r6, 6).b(InteractivityTraceMonitor.Event.ChatChannelCreateMessage);
        return;
    L26:
        r7 = null;
        goto L27
    L22:
        r5 = null;
    L18:
        r4 = null;
        goto L19
    L12:
        r1 = null;
        goto L13
    L8:
        r0 = null;
        goto L9
    L4:
        r2 = 0;
        goto L5
    }

    public static void g(s22.a r7, Throwable r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "channel");
        int r2 = e(r8);
        String r3 = f(r8);
        long r4 = c(Long.valueOf(r9));
        LinkedHashMap r6 = new LinkedHashMap();
        j(r6, r7);
        r6.put("reason", d(r8));
        Unit r10 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r11 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(r2, r3, r4, r6);
        r11.a(InteractivityMonitor.Event.ChatChannelInvite);
        r11.b(InteractivityTraceMonitor.Event.ChatChannelInvite);
    }

    public static void h(s22.a r8, String r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "channel");
        long r4 = c(Long.valueOf(r10));
        LinkedHashMap r6 = new LinkedHashMap();
        j(r6, r8);
        if (r9 != null) goto L5;
        r9 = BuildConfig.FLAVOR;
    L5:
        r6.put("log_id", r9);
        Unit r11 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r13 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, r4, r6, 3);
        r13.a(InteractivityMonitor.Event.ChatChannelInvite);
        r13.b(InteractivityTraceMonitor.Event.ChatChannelInvite);
    }

    public static void i(s22.a r8, String r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "channel");
        long r4 = c(Long.valueOf(r10));
        LinkedHashMap r6 = new LinkedHashMap();
        j(r6, r8);
        if (r9 != null) goto L5;
        r9 = BuildConfig.FLAVOR;
    L5:
        r6.put("log_id", r9);
        Unit r11 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r13 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, r4, r6, 3);
        r13.a(InteractivityMonitor.Event.ChatChannelJoin);
        r13.b(InteractivityTraceMonitor.Event.ChatChannelJoin);
    }

    public static void k(s22.a r8, String r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "channel");
        long r4 = c(Long.valueOf(r10));
        LinkedHashMap r6 = new LinkedHashMap();
        j(r6, r8);
        if (r9 != null) goto L5;
        r9 = BuildConfig.FLAVOR;
    L5:
        r6.put("log_id", r9);
        Unit r11 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r13 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, r4, r6, 3);
        r13.a(InteractivityMonitor.Event.ChatChannelQuit);
        r13.b(InteractivityTraceMonitor.Event.ChatChannelQuit);
    }

    public static void a(s22.a r7, String r8, Throwable r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "chatType");
        int r2 = e(r9);
        String r3 = f(r9);
        long r4 = c(Long.valueOf(r10));
        LinkedHashMap r6 = new LinkedHashMap();
        if (r7 == null) goto L5;
        j(r6, r7);
    L5:
        r6.put("comment_type", r8);
        r6.put("reason", d(r9));
        Unit r11 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r13 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(r2, r3, r4, r6);
        r13.a(InteractivityMonitor.Event.ChatChannelComment);
        r13.b(InteractivityTraceMonitor.Event.ChatChannelComment);
    }

    public static void b(s22.a r8, String r9, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r9, "chatType");
        long r4 = c(Long.valueOf(r11));
        LinkedHashMap r6 = new LinkedHashMap();
        if (r8 == null) goto L5;
        j(r6, r8);
    L5:
        r6.put("comment_type", r9);
        if (r10 != null) goto L8;
        r10 = BuildConfig.FLAVOR;
    L8:
        r6.put("message_id", r10);
        Unit r13 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r14 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, r4, r6, 3);
        r14.a(InteractivityMonitor.Event.ChatChannelComment);
        r14.b(InteractivityTraceMonitor.Event.ChatChannelComment);
    }
}
