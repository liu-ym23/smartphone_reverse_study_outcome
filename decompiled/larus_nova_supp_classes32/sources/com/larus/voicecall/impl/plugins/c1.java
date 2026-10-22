package com.larus.voicecall.impl.plugins;

import android.text.TextUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.plugins.CommonHelloPlugin;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.platform.model.audio.RealtimeCallSceneModeHelloConfig;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.assistant.RiskPreferenceSettings;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c1 extends CommonHelloPlugin<r> {
    public final String n;

    public final void C1() {
        String r0 = ((r) getContext()).params().o.h;
        String r1 = ((r) getContext()).params().e;
        String r2 = ((r) getContext()).params().p.g;
        String r3 = ((r) getContext()).params().p.i;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l == null) goto L5;
        String r4 = RiskPreferenceSettings.SMART_BALANCE;
    L6:
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        if (r0 != null) goto L22;
    L11:
        if (r1 == null) goto L13;
        r5.put("call_id", r1);     // Catch: JSONException -> L9
    L13:
        if (r3 == null) goto L15;
        r5.put("enter_method", r3);     // Catch: JSONException -> L9
    L15:
        if (r2 == null) goto L17;
        r5.put("chat_type", r2);     // Catch: JSONException -> L9
    L17:
        r5.put("realtime_call_hello_type", r4);     // Catch: JSONException -> L9
    L20:
        TrackParams r6 = new TrackParams().merge(r5);
        by7.a r7 = new by7.a("realtime_call_hello_trigger");
        r7.a.merge(r6);
        r7.b();
        return;
    L9:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallAvatar " + e.getLocalizedMessage());
        goto L20
    L22:
        r5.put("bot_id", r0);     // Catch: JSONException -> L9
        goto L11
    L5:
        r4 = "1";
        goto L6
    }

    public final boolean b1() {
        boolean r0 = j3();
        boolean r1 = s.c((r) getContext()).U();
        FLogger.a.i(this.n, "[CALL] isWaitHello canSend:" + r0 + ", canWait:" + r1);
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean j3() {
        boolean r0 = super.j3();
        o1 r1 = s.e((r) getContext());
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.y1());
    L6:
        FLogger r3 = FLogger.a;
        String r4 = this.n;
        StringBuilder r5 = new StringBuilder("[CALL] canSendHelloEvent super:");
        r5.append(r0);
        r5.append("， current scene can trigger hello:");
        RealtimeCallUtil r6 = RealtimeCallUtil.a;
        r6.getClass();
        com.larus.voicecall.impl.scene.o r7 = RealtimeCallUtil.l;
        if (r7 == null) goto L13;
        SceneModel r8 = r7.a;
        if (r8 == null) goto L13;
        if (r8.getNotTriggerHello() != true) goto L13;
        boolean r9 = true;
    L14:
        r5.append(!r9);
        r5.append(" , openVlm:");
        r5.append(r2);
        r3.i(r4, r5.toString());
        if (r0 == true) goto L26;
        r6.getClass();
        com.larus.voicecall.impl.scene.o r10 = RealtimeCallUtil.l;
        if (r10 == null) goto L23;
        SceneModel r11 = r10.a;
        if (r11 == null) goto L23;
        if (r11.getNotTriggerHello() == true) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == true) goto L26;
    L28:
        return false;
    L23:
        r12 = false;
    L26:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == true) goto L28;
        return true;
    L13:
        r9 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final void k3() {
        id9.d r0 = ((r) getContext()).j();
        if (r0 == null) goto L28;
        TriggerMode r1 = TriggerMode.HELLO;
        JSONObject r2 = new JSONObject();
        if (TextUtils.isEmpty(((r) getContext()).params().R) == true) goto L7;
        r2.putOpt("trigger_event", ((r) getContext()).params().R);
    L12:
        r2.putOpt("enter_method", ((r) getContext()).params().p.i);
        String r3 = ((r) getContext()).params().p.a;
        boolean r5 = true;
        if ((!StringsKt.isBlank(r3)) == false) goto L15;
        r2.putOpt("message_id", r3);
    L15:
        String r4 = ((r) getContext()).params().p.p;
        if (r4 != null) goto L18;
    L26:
        Unit r6 = Unit.INSTANCE;
        r0.p(r1, r2.toString());
        return;
    L18:
        if (r4.length() > 0) goto L21;
        r5 = false;
    L21:
        if (r5 == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L26;
        r2.put("bot_say_hello_text_key", r4);
        goto L26
    L7:
        RealtimeCallUtil.a.getClass();
        if (((RealtimeCallSceneModeHelloConfig) RealtimeCallUtil.p.getValue()).getEnableSceneHello() == false) goto L12;
        if (RealtimeCallUtil.l == null) goto L12;
        r2.put("trigger_event", "scene_mode_introduce");
        goto L12
    }

    public final String T2() {
        return this.n;
    }

    public c1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.n = "RealtimeCallHelloPlugin";
    }
}
