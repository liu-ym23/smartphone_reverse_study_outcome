package com.bytedance.android.livesdk.interactivity.comment.utils;

import am2.x;
import com.bytedance.android.live.base.model.data.activityemoji.ActivityEmojiGroup;
import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import ec2.t0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.android.livesdk.interactivity.common.utils.b {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final void e() {
        HashMap r0 = new HashMap();
        IBaseUser r1 = jc1.k.n(IMiddlewareUserService.class).user().b();
        if (r1.getUserHonor() == null) goto L8;
        py.d r2 = r1.getUserHonor();
        if (r2 == null) goto L7;
        int r3 = r2.getLevel();
    L9:
        r0.put("user_id", r1.getIdString());
        r0.put("privilege_level", String.valueOf(r3));
        IInteractivityInjectService r4 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r4 == null) goto L12;
        r4.buildVsRoomLog(null, r0);
    L12:
        j0.l().sendLog("livesdk_danmu_button_show", r0, new Object[]{x.class, IRoom.class});
        return;
    L7:
        r3 = 0;
        goto L9
    L8:
        r3 = -1;
        goto L9
    }

    static {
    }

    @JvmStatic
    public static final void d(com.bytedance.android.live.base.model.data.activityemoji.b r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "emoji");
        Intrinsics.checkNotNullParameter(r4, "showArea");
        HashMap r0 = new HashMap();
        r0.put("show_place", r4);
        String r5 = r3.getIdStr();
        if (r5 != null) goto L5;
        r5 = "0";
    L5:
        r0.put("emoji_id", r5);
        j0.l().sendLog("livesdk_activity_emoji_show", r0, new Object[]{x.class, IRoom.class});
    }

    @JvmStatic
    public static final void c(com.bytedance.android.live.base.model.data.activityemoji.b r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "emoji");
        Intrinsics.checkNotNullParameter(r5, "pattern");
        Intrinsics.checkNotNullParameter(r6, "clickArea");
        HashMap r0 = new HashMap();
        r0.put("emoji_send_entrance_pattern", r5);
        String r7 = r4.getName();
        String r1 = BuildConfig.FLAVOR;
        if (r7 != null) goto L5;
        r7 = BuildConfig.FLAVOR;
    L5:
        r0.put("emoji_name", r7);
        String r8 = r4.getName();
        if (r8 == null) goto L9;
        r1 = r8;
    L9:
        r0.put("emoji_content", r1);
        if ((!Intrinsics.areEqual(r6, "quick")) == false) goto L12;
        r0.put("tab", "activity");
        r0.put("emoji_type", "tab_activity");
    L13:
        r0.put("event_page", "emoji_panel");
        r0.put("emoticons_id", String.valueOf(r4.getActivityEmojiGroupId()));
        String r9 = r4.getIdStr();
        if (r9 != null) goto L16;
        r9 = "0";
    L16:
        r0.put("emoji_id", r9);
        j0.l().sendLog("livesdk_emoji_click", r0, new Object[]{x.class, IRoom.class});
        return;
    L12:
        r0.put("tab", "quick");
        r0.put("emoji_type", "quick_activity");
        goto L13
    }

    @JvmStatic
    public static final void f(com.bytedance.android.live.base.model.message.h r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "emoji");
        Intrinsics.checkNotNullParameter(r6, "clickArea");
        HashMap r0 = new HashMap();
        r0.put("click_area", r6);
        r0.put("tab", "quick_interaction");
        r0.put("emoji_type", "quick_interaction");
        if (r7 == false) goto L5;
        r0.put("click_type", "choose");
    L6:
        MiddlewareRoomContext r8 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L13;
        com.bytedance.live.datacontext.i r9 = r8.isAnchor();
        if (r9 == null) goto L13;
        if (((Boolean) r9.getValue()).booleanValue() != true) goto L13;
        String r10 = "1";
    L14:
        r0.put("is_anchor", r10);
        if (r5.getType() != 1) goto L17;
        r0.put("quick_interaction_type", "say_hi");
    L18:
        j0.l().sendLog("livesdk_emoji_click", r0, new Object[]{x.class, IRoom.class});
        return;
    L17:
        r0.put("quick_interaction_type", "location");
    L13:
        r10 = "0";
        goto L14
    L5:
        r0.put("click_type", "cancel_choose");
        goto L6
    }

    @JvmStatic
    public static final void g(String r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r16, "pattern");
        HashMap r1 = new HashMap();
        List r2 = CollectionsKt.mutableListOf(new String[]{"tab_emoji"});
        EffectiveActivityEmojiGroup r3 = q.c();
        if (r3 == null) goto L5;
        ActivityEmojiGroup r4 = r3.getEmojiGroup();
    L6:
        if (r4 == null) goto L14;
        if (r17 == false) goto L14;
        r2.add("tab_activity");
        List r5 = r4.getActivityEmojiList();
        if (r5 == null) goto L14;
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        d((com.bytedance.android.live.base.model.data.activityemoji.b) r6.next(), "tab");
    L14:
        com.bytedance.android.livesdk.interactivity.api.h r7 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r7 == null) goto L21;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.e> r8 = r7.getFusionEmojiManager();
        if (r8 == null) goto L21;
        com.bytedance.android.livesdk.interactivity.api.emoji.e r9 = (com.bytedance.android.livesdk.interactivity.api.emoji.e) r8.getValue();
        if (r9 == null) goto L21;
        List<com.bytedance.android.livesdk.interactivity.api.emoji.a> r10 = r9.f();
    L23:
        if (r10 == null) goto L28;
        if ((!r10.isEmpty()) != true) goto L28;
        r2.add("fusion");
    L28:
        if (q.f() == null) goto L35;
        if (r18 == false) goto L35;
        fc2.g.a.getClass();
        if (((fc2.g) t0.a.getValue()).a() == false) goto L35;
        if (q.k() == true) goto L35;
        r2.add("quick_interaction");
    L35:
        MiddlewareRoomContext r11 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L42;
        com.bytedance.live.datacontext.i r13 = r11.isAnchor();
        if (r13 == null) goto L42;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L42;
        String r14 = "1";
    L43:
        r1.put("is_anchor", r14);
        r1.put("emoji_type", CollectionsKt.joinToString$default(r2, "|", null, null, 0, null, null, 62, null));
        r1.put("emoji_send_entrance_pattern", r16);
        IInteractivityInjectService r0 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r0 == null) goto L46;
        r0.appendCastSDKLogCommonParams(r1);
    L46:
        j0.l().sendLog("livesdk_emoji_show", r1, new Object[]{IRoom.class, new x()});
        return;
    L42:
        r14 = "0";
    L21:
        r10 = null;
        goto L23
    L5:
        r4 = null;
        goto L6
    }
}
