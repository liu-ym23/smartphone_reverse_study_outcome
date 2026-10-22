package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.e7;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p {
    public static final Boolean a = null;

    static {
        a = (Boolean) e7.a.getValue();
    }

    @JvmStatic
    public static final void a(Map<String, String> r0, tlc.d r1) {
        if (r1 == null) goto L10;
        IPublicAreaCommon r2 = v3.a(r1);
        if (r2 == null) goto L11;
        Map<? extends String, ? extends String> r3 = r2.getTrackingParams();
        if (r3 == null) goto L12;
        if (r0 == null) goto L13;
        r0.putAll(r3);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        return;
    }

    @Deprecated(message = "use livesdk_public_screen_message_click_event instead")
    @JvmStatic
    public static final void d(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "clickType");
        u3 r0 = r3.b;
        if ((r0 instanceof u3) == true) goto L5;
        r0 = null;
    L5:
        u3 r1 = r0;
        if (r1 == null) goto L21;
        IPublicAreaCommon r2 = r1.getOrInitPublicAreaCommon();
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.getSuffixText() == null) goto L23;
        HashMap r5 = new HashMap();
        T r6 = r3.b;
        if (r6 == 0) goto L15;
        String r7 = r6.getMessageMethod();
        if (r7 == null) goto L15;
    L16:
        r5.put("message_type", r7);
        r5.put("click_area", r4);
        Map r8 = r2.getTrackingParams();
        if (r8 == null) goto L19;
        r5.putAll(r8);
    L19:
        j0.l().sendLog("livesdk_anchor_tag_priority_display_user_message_click", r5, new Object[]{IRoom.class});
        return;
    L15:
        r7 = BuildConfig.FLAVOR;
        goto L16
    L23:
        return;
    }

    public static void b(String r6, String r7, Map r8) {
        if (a.booleanValue() == true) goto L5;
        return;
    L5:
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L50;
        String r4 = null;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L51;
        LinkedHashMap r2 = new LinkedHashMap();
        Boolean r3 = r1.isAnchor();
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r5) == false) goto L13;
        String r9 = "1";
    L14:
        r2.put("is_anchor", r9);
        if (r6 != null) goto L17;
        r6 = BuildConfig.FLAVOR;
    L17:
        r2.put("message_type", r6);
        if (r7 != null) goto L20;
        r7 = BuildConfig.FLAVOR;
    L20:
        r2.put("click_type", r7);
        if (r8 == null) goto L24;
        r2.putAll(r8);
    L24:
        if (r8 == null) goto L34;
        String r10 = (String) r8.get("msg_show_type");
        if (r10 == null) goto L34;
        if (r10.length() <= 0) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == false) goto L33;
        r4 = r10;
    L33:
        if (r4 == null) goto L34;
    L35:
        r2.put("msg_show_type", r4);
        if (Intrinsics.areEqual(r1.isAnchor(), r5) == false) goto L38;
        String r13 = "anchor";
    L48:
        r2.put("user_type", r13);
        j0.l().sendLog("livesdk_public_screen_message_click_event", r2, new Object[]{IRoom.class});
        return;
    L38:
        IMiddlewareUserService r14 = jc1.k.f(IMiddlewareUserService.class);
        if (r14 == null) goto L47;
        com.bytedance.android.livesdk.user.e r15 = r14.user();
        if (r15 == null) goto L47;
        UserAttr r16 = r15.q();
        if (r16 == null) goto L47;
        if (r16.isAdmin() != true) goto L47;
        r13 = "admin";
    L47:
        r13 = "user";
        goto L48
    L30:
        r11 = false;
    L34:
        r4 = "public_screen_normal";
        goto L35
    L13:
        r9 = "0";
        goto L14
    L51:
        return;
    }

    public static void c(String r2, Map r3, DataCenter r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("click_type", r2);
        r0.putAll(r3);
        b.a(r0, r4);
        j0.l().sendLog("livesdk_public_screen_message_click_event", r0, new Object[]{IRoom.class});
    }
}
