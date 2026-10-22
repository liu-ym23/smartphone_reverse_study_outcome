package com.larus.voicecall.impl.util;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.platform.service.o;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.o0;
import com.larus.voicecall.impl.component.vlm.j2;
import com.lynx.tasm.event.LynxTouchEvent;
import ic8.n;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public x0() {
    }

    public static void a(JSONObject r6, RealtimeCallParam r7, e3a.a r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "param");
        Intrinsics.checkNotNullParameter(r8, "argumentData");
        String r0 = r7.G;
        e r1 = IAIChatControlTraceService.a.Qb(r0, new w0());
        if (r8.h1 == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r4 = null;
        if (o0.d(r8.b1) == false) goto L13;
        if (r2 == false) goto L13;
        Object r3 = r8.b1;
    L26:
        r6.put("is_first_leave_video_call", r8.k1);
        r6.put("is_first_enter_video_call", r8.h1);
        r6.put("is_open_vlm", ((h88.a) r8).m);
        RealtimeCallParam.c r9 = r7.p.o;
        if (r9 == null) goto L29;
        Object r10 = r9.a;
    L30:
        r6.put("action_bar_item_id", r10);
        RealtimeCallParam.c r11 = r7.p.o;
        if (r11 == null) goto L33;
        Object r12 = r11.d;
    L34:
        r6.put("action_bar_key", r12);
        r6.put("call_enter_method", r7.p.i);
        r6.put("enter_method", r3);
        r6.put("bot_id", r7.o.h);
        r6.put("call_id", r7.e);
        r6.put("room_id", r7.d);
        r6.put("conversation_id", r0);
        if (r1 == null) goto L37;
        r4 = n.f(r1);
    L37:
        r6.put("chat_type", r4);
        r6.put("current_page", "chat");
        RealtimeCallUtil r13 = RealtimeCallUtil.a;
        AudioSessionType r5 = r7.s;
        r13.getClass();
        r6.put("is_ve_capture", RealtimeCallUtil.L(r5) ? 1 : 0);
        if (r7.p.q == false) goto L40;
    L43:
        Object r14 = "1";
    L44:
        r6.put("is_continuous_speak", r14);
        return;
    L40:
        if (r7.a == true) goto L43;
        r14 = "0";
        goto L44
    L33:
        r12 = null;
        goto L34
    L29:
        r10 = null;
    L13:
        RealtimeCallParam.c r15 = r7.p.o;
        if (r15 == null) goto L16;
        String r16 = r15.a;
    L18:
        if (o0.d(r16) == false) goto L22;
        if (r2 == false) goto L22;
        r3 = "chat_action_bar";
    L22:
        if (o0.d(r7.p.O) == false) goto L25;
        if (r2 == false) goto L25;
        r3 = r7.p.O;
    L25:
        r3 = "click_video_call";
        goto L26
    L16:
        r16 = null;
        goto L18
    L5:
        if (r8.k1 == true) goto L8;
        r2 = false;
        goto L9
    }

    public static void d(e3a.b r5, e3a.a r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "runtimeData");
        Intrinsics.checkNotNullParameter(r6, "argumentData");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "chat");
        RealtimeCallParam.c r2 = r5.a().p.o;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.a;
    L6:
        r1.put("action_bar_item_id", r4);
        RealtimeCallParam.c r8 = r5.a().p.o;
        if (r8 == null) goto L9;
        r3 = r8.d;
    L9:
        r1.put("action_bar_key", r3);
        if (r7 == null) goto L12;
        r1.put("camera_status", r7);
    L12:
        a(r1, r5.a(), r6);
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("click_video_call", r1);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static void b(String r2, RealtimeCallParam r3, e3a.a r4, boolean r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "enterMethod");
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r4, "argumentData");
        Intrinsics.checkNotNullParameter(r7, "buttonType");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        a(r1, r3, r4);
        r1.put("enter_method", r2);
        r1.put("is_mute", r5 ? 1 : 0);
        r1.put("is_subtitles_mode", r6 ? 1 : 0);
        r1.put("button_type", r7);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("click_share_screen_button", r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(RealtimeCallParam r2, e3a.a r3, boolean r4, boolean r5, Boolean r6, String r7, String r8, j2 r9, int r10) {
        int r11 = r5;
        if ((r10 & 8) == 0) goto L6;
        RealtimeCallUtil.a.getClass();
        r11 = RealtimeCallUtil.z;
    L6:
        if ((r10 & 16) == 0) goto L9;
        r6 = null;
    L9:
        if ((r10 & 64) == 0) goto L11;
        r8 = null;
    L11:
        j2 r12 = r9;
        if ((r10 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L14;
        r12 = null;
    L14:
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r3, "argumentData");
        Intrinsics.checkNotNullParameter(r7, "buttonType");
        o r13 = o.a;
        JSONObject r0 = new JSONObject();
        a(r0, r2, r3);
        r0.put("is_mute", r4 ? 1 : 0);
        if (o0.d(r8) == false) goto L17;
        r0.put("zoom_direction", r8);
    L17:
        r0.put("is_subtitles_mode", r11);
        if (r6 != null) goto L20;
    L24:
        r0.put("button_type", r7);
        if (r12 == null) goto L27;
        r12.invoke(r0);
    L27:
        Unit r14 = Unit.INSTANCE;
        r13.reportEvent("click_video_call_button", r0);
        return;
    L20:
        if (r6.booleanValue() == false) goto L22;
        Object r15 = "back_camera";
    L23:
        r0.put("camera_position", r15);
        goto L24
    L22:
        r15 = "front_camera";
        goto L23
    }
}
