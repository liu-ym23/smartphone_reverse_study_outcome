package com.larus.asr;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.asr.handsfree.HandsfreeDirectEntry;
import com.larus.audio.asr.c0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.trace.l0;
import com.larus.bmhome.utils.r;
import com.larus.im.bean.bot.BotModel;
import com.larus.trace.SendingTextEditTriggeredScene;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import f58.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import t19.s;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w5 implements View.OnTouchListener {
    public long a;
    public boolean b;
    public String c;
    public int d;
    public boolean e;
    public final /* synthetic */ TouchSpeakerComponent f;

    public w5(TouchSpeakerComponent r1) {
        this.f = r1;
        this.c = "";
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r30, MotionEvent r31) {
        Intrinsics.checkNotNullParameter(r30, "v");
        Intrinsics.checkNotNullParameter(r31, "event");
        int r3 = r31.getActionMasked();
        com.larus.bmhome.chat.component.bottom.core.speaker.l r4 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.f.m.getValue();
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (r5 == false) goto L14;
        if (r3 != 0) goto L12;
        s r1 = s.a;
        Context r2 = this.f.getContext();
        r1.getClass();
        s.s(r2, 2131910343);
        f2a.c r6 = this.f.w.a("Touch EVENT: ACTION_DOWN, but enableSpeakerHandleTouch is false");
        f2a.g r7 = r6.c;
        r7.d = "buildTouchListenerOnPressSpeak.onTouch";
        r7.e = "PressSpeak";
        f2a.c.c(r6, null, 15);
    L12:
        return false;
    L14:
        if (TouchSpeakerComponent.F2(this.f) == false) goto L16;
        return false;
    L16:
        Pair r8 = TouchSpeakerComponent.N2(this.f, r30, r31);
        Pair r9 = TouchSpeakerComponent.L2(this.f, r30);
        if (r3 != 0) goto L20;
        this.c = UUID.randomUUID().toString();
    L20:
        if (r3 != 2) goto L25;
        int r14 = this.d + 1;
        this.d = r14;
        if (r14 != 1) goto L28;
        f2a.c r15 = this.f.w.b("Touch EVENT: ACTION_MOVE, MOVE START");
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r8.getFirst()).floatValue()));
        r16.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r8.getSecond()).floatValue()));
        r15.d(r16);
        f2a.g r10 = r15.c;
        r10.d = "buildTouchListenerOnPressSpeak.onTouch";
        r10.e = "PressSpeak";
        r15.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r15, null, 15);
    L28:
        f2a.c r11 = this.f.w.b("onTouch EVENT: " + r3);
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put(new f2a.f("action_masked"), String.valueOf(r3));
        r12.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r8.getFirst()).floatValue()));
        r12.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r8.getSecond()).floatValue()));
        r11.d(r12);
        f2a.g r13 = r11.c;
        r13.d = "buildTouchListenerOnPressSpeak.onTouch";
        r13.e = "PressSpeak";
        r11.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r11, null, 15);
        if (this.f.z3().speakerTouchEnable() == true) goto L34;
        if (r3 != 0) goto L34;
        this.f.C3(2131907325, false);
        return true;
    L34:
        if (r3 == 0) goto L128;
        if (r3 == 1) goto L45;
        if (r3 != 2) goto L39;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r17 = TouchSpeakerComponent.P2(this.f);
        if (r17 == null) goto L167;
        r17.pv(0, ((Number) r8.getFirst()).floatValue(), ((Number) r8.getSecond()).floatValue(), ((Number) r9.getFirst()).floatValue(), ((Number) r9.getSecond()).floatValue());
        return true;
    L167:
        return true;
    L39:
        if (r3 == 3) goto L45;
        return true;
    L45:
        if (this.e == false) goto L48;
        return true;
    L48:
        this.e = true;
        long r19 = System.currentTimeMillis();
        if (Math.abs(r19 - this.a) < 300) goto L51;
    L60:
        this.b = false;
        x5.d().a(false);
        boolean r20 = this.f.p3().hasMessages(10001);
        f2a.c r21 = this.f.w.b("Touch EVENT: ACTION_UP or ACTION_CANCEL");
        LinkedHashMap r22 = new LinkedHashMap();
        f2a.f r110 = new f2a.f("touch_event");
        if (r3 != 1) goto L63;
        Object r23 = "ACTION_UP";
    L64:
        r22.put(r110, r23);
        r22.put(new f2a.f("has_on_speak_msg"), String.valueOf(r20));
        r21.d(r22);
        r21.c.e = "PressSpeak";
        List r24 = CollectionsKt.listOf(this.c);
        f2a.g r25 = r21.c;
        r25.b = r24;
        r25.d = "buildTouchListenerOnPressSpeak.onTouch";
        f2a.c.c(r21, null, 15);
        if (r20 == false) goto L118;
        this.f.p3().removeMessages(10001);
        if (r3 == 1) goto L72;
        if (this.f.nt() == false) goto L72;
        return true;
    L72:
        if (com.larus.platform.service.z2.a.voiceInputHandsfreeConfig().getVoiceInputClickEnabled() == false) goto L81;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r26 = TouchSpeakerComponent.P2(this.f);
        if (r26 != null) goto L76;
    L78:
        boolean r27 = false;
    L79:
        if (r27 == false) goto L81;
        a.a("click");
        return true;
    L76:
        if (r26.dz(HandsfreeDirectEntry.VOICE_INPUT_BUTTON_PRESS, this.c, "PressSpeak") != true) goto L78;
        r27 = true;
    L81:
        y r29 = s1a.d.a(this.f).getAbility(y.class);
        ICoreInputAbility r32 = this.f.h3();
        String r33 = "";
        if (r32 == null) goto L93;
        if (r29 == null) goto L85;
        BotModel r34 = r29.j0();
    L86:
        if (r29 == null) goto L88;
        String r35 = r29.Y1();
    L89:
        if (r35 == null) goto L92;
        r33 = r35;
    L92:
        boolean r36 = r32.lW(r34, r33);
    L104:
        com.larus.bmhome.instruction.g r37 = (com.larus.bmhome.instruction.g) this.f.i.getValue();
        if (r37 != null) goto L107;
    L109:
        boolean r38 = false;
    L110:
        int r39 = r.a;
        if (r.a(s1a.d.a(this.f)).c == false) goto L170;
        if (r36 == false) goto L171;
        if (r38 == false) goto L172;
        StateFlowImpl r40 = ce8.c.a;
        b r41 = s1a.d.a(this.f);
        Intrinsics.checkNotNullParameter(r41, "<this>");
        String r42 = UUID.randomUUID().toString();
        ce8.c.b = r42;
        ce8.c.c = "continuous_chat_single_click_asr_input";
        ce8.c.b("continuous_chat_single_click_asr_input", r42, r41);
        String r43 = ce8.c.b;
        xa8.b r44 = s1a.d.a(this.f).getAbility(xa8.b.class);
        if (r44 == null) goto L173;
        r44.iU("continuous_chat_single_click_asr_input", r43);
        return true;
    L173:
        return true;
    L172:
        return true;
    L171:
        return true;
    L170:
        return true;
    L107:
        if (r37.z0() == true) goto L109;
        r38 = true;
        goto L110
    L88:
        r35 = null;
        goto L89
    L85:
        r34 = null;
        goto L86
    L93:
        VoiceCallServiceDelegate r45 = VoiceCallServiceDelegate.a;
        if (r29 == null) goto L96;
        BotModel r46 = r29.j0();
    L97:
        if (r29 == null) goto L99;
        String r47 = r29.Y1();
    L100:
        if (r47 == null) goto L103;
        r33 = r47;
    L103:
        r36 = r45.r(r46, r33, true);
        goto L104
    L99:
        r47 = null;
        goto L100
    L96:
        r46 = null;
        goto L97
    L118:
        if (r3 != 1) goto L122;
        IAsrDirectFillAbility r48 = this.f.m3();
        if (r48 == null) goto L125;
        r48.S60();
    L125:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r49 = TouchSpeakerComponent.P2(this.f);
        if (r49 == null) goto L175;
        r49.pv(-1, ((Number) r8.getFirst()).floatValue(), ((Number) r8.getSecond()).floatValue(), ((Number) r9.getFirst()).floatValue(), ((Number) r9.getSecond()).floatValue());
        return true;
    L175:
        return true;
    L122:
        IAsrDirectFillAbility r50 = this.f.m3();
        if (r50 == null) goto L125;
        r50.cancel();
        goto L125
    L63:
        r23 = "ACTION_CANCEL";
        goto L64
    L51:
        if (x5.d().d() == true) goto L60;
        if (this.b == true) goto L60;
        f2a.c r51 = this.f.w.c("Touch EVENT: ACTION_UP or ACTION_CANCEL: gap time less than DEBOUNCE_TIME");
        LinkedHashMap r52 = new LinkedHashMap();
        f2a.f r53 = new f2a.f("touch_event");
        if (r3 != 1) goto L57;
        Object r54 = "ACTION_UP";
    L58:
        r52.put(r53, r54);
        r52.put(new f2a.f("current_time"), String.valueOf(r19));
        r52.put(new f2a.f("last_press_time"), String.valueOf(this.a));
        r52.put(new f2a.f("is_asr_speaker_pressed"), String.valueOf(x5.d().d()));
        r51.d(r52);
        r51.c.e = "PressSpeak";
        List r55 = CollectionsKt.listOf(this.c);
        f2a.g r56 = r51.c;
        r56.b = r55;
        r56.d = "buildTouchListenerOnPressSpeak.onTouch";
        f2a.c.c(r51, null, 15);
        return true;
    L57:
        r54 = "ACTION_CANCEL";
        goto L58
    L128:
        f2a.c r57 = this.f.w.b("Touch EVENT: ACTION_DOWN");
        f2a.g r59 = r57.c;
        r59.e = "PressSpeak";
        r59.d = "buildTouchListenerOnPressSpeak.onTouch";
        r57.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r57, null, 15);
        this.e = false;
        this.b = false;
        long r60 = System.currentTimeMillis();
        if (Math.abs(r60 - this.a) >= 300) goto L132;
        f2a.c r61 = this.f.w.c("Touch EVENT: ACTION_DOWN. gap time less than DEBOUNCE_TIME");
        LinkedHashMap r62 = new LinkedHashMap();
        r62.put(new f2a.f("current_time"), String.valueOf(r60));
        r62.put(new f2a.f("last_press_time"), String.valueOf(this.a));
        r61.d(r62);
        f2a.g r63 = r61.c;
        r63.e = "PressSpeak";
        r63.d = "buildTouchListenerOnPressSpeak.onTouch";
        r61.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r61, null, 15);
        return true;
    L132:
        this.a = r60;
        this.b = true;
        x5.d().a(true);
        va8.o r64 = this.f.Y2();
        if (r64 == null) goto L135;
        r64.requestDisallowInterceptTouchEvent(true);
    L135:
        ICoreInputAbility r65 = this.f.h3();
        if (r65 == null) goto L144;
        z8.a r66 = r65.Jd();
        if (r66 == null) goto L144;
        Function0 r67 = r66.o;
        if (r67 == null) goto L144;
        if (((Boolean) r67.invoke()).booleanValue() != true) goto L144;
        boolean r68 = true;
    L145:
        if (r68 == true) goto L159;
        TouchSpeakerComponent.U2(this.f);
        c0 r69 = new c0(this.c, "PressSpeak", 0, 252);
        if (this.f.nt() == false) goto L152;
        if (com.larus.platform.service.z2.a.voiceInputHandsfreeConfig().getVoiceInputClickEnabled() == false) goto L152;
        Message r70 = this.f.p3().obtainMessage(10001);
        r70.getData().putBoolean("from_text_area", false);
        r70.getData().putString("asr_input_trace_id", this.c);
        r70.getData().putString("asr_input_enter_from", "PressSpeak");
        this.f.p3().sendMessageDelayed(r70, this.f.z3().longPressTimeout());
    L152:
        if (this.f.B3() == false) goto L156;
        IAsrDirectFillAbility r71 = this.f.m3();
        if (r71 == null) goto L159;
        r71.il(false, r69);
        goto L159
    L156:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r111 = TouchSpeakerComponent.P2(this.f);
        if (r111 == null) goto L159;
        com.larus.bmhome.chat.component.bottom.core.speaker.l.a.a(r111, false, this.f.X2(), null, false, r69, null, null, null, null, null, 1004);
    L159:
        u7 r72 = (u7) this.f.l.getValue();
        if (r72 == null) goto L164;
        l0 r73 = r72.ON();
        if (r73 == null) goto L164;
        r73.w(SendingTextEditTriggeredScene.ASR);
    L164:
        a.a("long_press");
        return true;
    L144:
        r68 = false;
        goto L145
    L25:
        if (this.d <= 0) goto L27;
        f2a.c r74 = this.f.w.b("Touch EVENT: touchMoveCount > 0, MOVE END");
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put(new f2a.f("action_masked"), String.valueOf(r3));
        r112.put(new f2a.f("touch_move_count"), String.valueOf(this.d));
        r112.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r8.getFirst()).floatValue()));
        r112.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r8.getSecond()).floatValue()));
        r74.d(r112);
        f2a.g r75 = r74.c;
        r75.d = "buildTouchListenerOnPressSpeak.onTouch";
        r75.e = "PressSpeak";
        r74.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r74, null, 15);
        this.d = 0;
        goto L28
    L27:
        f2a.c r76 = this.f.w.b("Touch EVENT: touchMoveCount <= 0");
        LinkedHashMap r77 = new LinkedHashMap();
        r77.put(new f2a.f("action_masked"), String.valueOf(r3));
        r77.put(new f2a.f("touch_move_count"), String.valueOf(this.d));
        r77.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r8.getFirst()).floatValue()));
        r77.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r8.getSecond()).floatValue()));
        r76.d(r77);
        f2a.g r79 = r76.c;
        r79.d = "buildTouchListenerOnPressSpeak.onTouch";
        r79.e = "PressSpeak";
        r76.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r76, null, 15);
        goto L28
    L5:
        if (r4.N70() == true) goto L7;
        r5 = true;
        goto L9
    }
}
