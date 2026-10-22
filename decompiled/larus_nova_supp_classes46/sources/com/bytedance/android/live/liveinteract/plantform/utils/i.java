package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.android.livesdk.config.u5;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final void b() {
        i0 r0 = TalkRoomLogUtils.a;
        String r1 = TalkRoomLogUtils.h;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        TalkRoomLogUtils.i = r1;
        Intrinsics.checkNotNullParameter("live", "<set-?>");
        TalkRoomLogUtils.h = "live";
    }

    static {
    }

    @JvmStatic
    public static final void f(z5 r5) {
        Intrinsics.checkNotNullParameter(r5, "linkerDetail");
        String r6 = r5.getFunctionType2();
        if (r6 == null) goto L11;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("reason", "room/enter");
        i0 r3 = TalkRoomLogUtils.a;
        r2.put("last_function_type2", TalkRoomLogUtils.h);
        r2.put("new_function_type2", r6);
        com.bytedance.android.livesdk.log.b0.o().j("FunctionType2", r2);
        if (r6.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        Intrinsics.checkNotNullParameter("live", "<set-?>");
        TalkRoomLogUtils.h = "live";
        return;
    L10:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        TalkRoomLogUtils.h = r6;
        return;
    L7:
        r4 = false;
        goto L8
    L11:
        i0 r7 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter("live", "<set-?>");
        TalkRoomLogUtils.h = "live";
    }

    @JvmStatic
    public static final void g(z0 r4) {
        Intrinsics.checkNotNullParameter(r4, "linkMicMessage");
        LinkedHashMap r0 = new LinkedHashMap();
        int r2 = (int) r4.getType2();
        String r3 = "";
        if (r2 != 1) goto L5;
        String r1 = "receive_turn_on_msg";
    L9:
        r0.put("reason", r1);
        r0.put("msg_id", String.valueOf(r4.getMessageId2()));
        com.bytedance.android.live.liveinteract.multianchor.model.b r5 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r4.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        if (r5 == null) goto L16;
        String r6 = r5.getFunctionType2();
        if (r6 == null) goto L16;
        r3 = r6;
    L16:
        if (vm2.d.v0() == false) goto L19;
        h(r3, r0);
        return;
    L19:
        if ("new_audience".equals(r3) == false) goto L21;
        i0 r7 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        TalkRoomLogUtils.h = r3;
        return;
    L21:
        c(r4.getValidScene(), r4.getUiLayout(), r0);
        return;
    L5:
        if (r2 == 17) goto L7;
        r1 = "";
        goto L9
    L7:
        r1 = "receive_switch_scene_msg";
        goto L9
    }

    @JvmStatic
    public static final void d(com.bytedance.android.livesdk.chatroom.model.interact.j0 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "linkInitResult");
        Intrinsics.checkNotNullParameter(r4, "logId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("reason", "init_v2_api");
        r0.put("log_id", r4);
        if (vm2.d.v0() == false) goto L5;
        h(r3.getFunctionType2(), r0);
        return;
    L5:
        c(r3.getScene(), r3.getUiLayout(), r0);
    }

    @JvmStatic
    public static final void e(v1 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "switchSceneResponse");
        Intrinsics.checkNotNullParameter(r4, "logId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("reason", "switch_scene_api");
        r0.put("log_id", r4);
        if (vm2.d.v0() == false) goto L5;
        h(r3.getFunctionType2(), r0);
        return;
    L5:
        c(r3.getScene(), r3.getUiLayout(), r0);
    }

    @JvmStatic
    public static final void h(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "logExtra");
        if (r2 != null) goto L5;
        String r0 = TalkRoomLogUtils.h;
    L6:
        r3.put("function_type", r0);
        com.bytedance.android.livesdk.log.b0.o().j("FunctionType2", r3);
        if (r2 == null) goto L10;
        i0 r4 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        TalkRoomLogUtils.h = r2;
        return;
    L10:
        return;
    L5:
        r0 = r2;
        goto L6
    }

    @JvmStatic
    public static final String a(int r10, int r11, boolean r12) {
        if (vm2.d.v0() == false) goto L7;
        if (r12 == true) goto L7;
        i0 r13 = TalkRoomLogUtils.a;
        return TalkRoomLogUtils.h;
    L7:
        u5 r14 = (u5) vm2.d.p4.getValue(null, vm2.d.a[273(0x111, float:3.83E-43)]);
        List r0 = r14.a();
        if (r0 != null) goto L10;
    L30:
        return null;
    L10:
        if (r0.contains(Integer.valueOf(r11)) != true) goto L30;
        Map r15 = r14.b();
        if (r15 == null) goto L30;
        Iterator r16 = r15.entrySet().iterator();
    L15:
        if (r16.hasNext() == false) goto L30;
        Map.Entry r1 = (Map.Entry) r16.next();
        List r3 = StringsKt.split$default((CharSequence) r1.getKey(), new String[]{"_"}, false, 0, 6, null);
        String r4 = (String) ListProtector.get(r3, 0);
        String r5 = (String) ListProtector.get(r3, 1);
        if (r11 != 7) goto L23;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L23;
        return "new_audience";
    L23:
        if (Intrinsics.areEqual(String.valueOf(r10), r4) == false) goto L15;
        if (Intrinsics.areEqual(r5, "*") == true) goto L29;
        if (Intrinsics.areEqual(r5, String.valueOf(r11)) == false) goto L15;
    L29:
        return (String) r1.getValue();
    }

    @JvmStatic
    public static final void c(int r2, int r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "logExtra");
        String r0 = a(r2, r3, false);
        r4.put("target_scene", String.valueOf(r2));
        r4.put("target_ui_layout", String.valueOf(r3));
        r4.put("last_function_type2", TalkRoomLogUtils.h);
        if (r0 != null) goto L5;
        String r5 = TalkRoomLogUtils.h;
    L6:
        r4.put("new_function_type2", r5);
        com.bytedance.android.livesdk.log.b0.o().j("FunctionType2", r4);
        if (r0 == null) goto L10;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        TalkRoomLogUtils.h = r0;
        return;
    L10:
        return;
    L5:
        r5 = r0;
        goto L6
    }
}
