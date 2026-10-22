package com.larus.asr;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.asr.handsfree.HandsfreeDirectEntry;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import f58.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r5 implements View.OnTouchListener {
    public int a;
    public String b;
    public final /* synthetic */ TouchSpeakerComponent c;

    public r5(TouchSpeakerComponent r1) {
        this.c = r1;
        this.b = "";
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r17, MotionEvent r19) {
        Intrinsics.checkNotNullParameter(r17, "v");
        TouchSpeakerComponent r3 = this.c;
        int r4 = TouchSpeakerComponent.E;
        boolean r5 = false;
        if (r3.z3().speakerTouchEnable() == true) goto L11;
        if (r19 != null) goto L6;
    L8:
        if (r5 == false) goto L10;
        this.c.C3(2131907356, true);
    L10:
        return true;
    L6:
        if (r19.getActionMasked() != 0) goto L8;
        r5 = true;
        goto L8
    L11:
        if (r19 != null) goto L13;
        return true;
    L13:
        int r6 = r19.getActionMasked();
        Pair r2 = TouchSpeakerComponent.N2(this.c, r17, r19);
        Pair r1 = TouchSpeakerComponent.L2(this.c, r17);
        if (r6 != 0) goto L16;
        this.b = UUID.randomUUID().toString();
    L16:
        Boolean r7 = null;
        if (r6 != 2) goto L22;
        int r13 = this.a + 1;
        this.a = r13;
        if (r13 != 1) goto L26;
        f2a.c r14 = this.c.w.b("Touch EVENT: ACTION_MOVE, MOVE START");
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r2.getFirst()).floatValue()));
        r15.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r2.getSecond()).floatValue()));
        r14.d(r15);
        r14.c.d = "buildTouchListenerOnPressActionSpeak.onTouch";
        List r8 = CollectionsKt.listOf(this.b);
        f2a.g r9 = r14.c;
        r9.b = r8;
        r9.e = "PressActionSpeak";
        f2a.c.c(r14, null, 15);
    L26:
        if (r6 != 0) goto L28;
        maa.f r10 = (maa.f) this.c.q.getValue();
        if (r10 == null) goto L94;
        r10.ga(r2);
    L94:
        f2a.c r11 = this.c.w.b("Touch EVENT: ACTION_DOWN");
        f2a.g r12 = r11.c;
        r12.e = "PressActionSpeak";
        r12.d = "buildTouchListenerOnPressActionSpeak.onTouch";
        r11.c.b = CollectionsKt.listOf(this.b);
        f2a.c.c(r11, null, 15);
        TouchSpeakerComponent.U2(this.c);
        x5.d().a(true);
        va8.o r16 = this.c.Y2();
        if (r16 == null) goto L97;
        r16.requestDisallowInterceptTouchEvent(true);
    L97:
        Message r20 = this.c.p3().obtainMessage(10001);
        r20.getData().putBoolean("from_text_area", true);
        r20.getData().putString("asr_input_trace_id", this.b);
        r20.getData().putString("asr_input_enter_from", "PressActionSpeak");
        this.c.p3().sendMessageDelayed(r20, this.c.z3().longPressTimeout());
        return true;
    L28:
        if (r6 != 1) goto L30;
    L40:
        maa.f r21 = (maa.f) this.c.q.getValue();
        if (r21 == null) goto L43;
        r21.ga(null);
    L43:
        x5.d().a(false);
        boolean r22 = this.c.p3().hasMessages(10001);
        f2a.c r23 = this.c.w.b("Touch EVENT: ACTION_UP or ACTION_CANCEL");
        LinkedHashMap r110 = new LinkedHashMap();
        f2a.f r111 = new f2a.f("touch_event");
        if (r6 != 1) goto L46;
        String r112 = "ACTION_UP";
    L47:
        r110.put(r111, r112);
        r110.put(new f2a.f("has_on_speak_msg"), String.valueOf(r22));
        r23.d(r110);
        f2a.g r113 = r23.c;
        r113.e = "PressActionSpeak";
        r113.d = "buildTouchListenerOnPressActionSpeak.onTouch";
        r23.c.b = CollectionsKt.listOf(this.b);
        f2a.c.c(r23, null, 15);
        if (r22 == false) goto L81;
        this.c.p3().removeMessages(10001);
        if (r6 != 1) goto L52;
    L54:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r24 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.c.m.getValue();
        if (r24 == null) goto L59;
        boolean r25 = true;
        if (r24.dz(HandsfreeDirectEntry.MIC_ICON_CLICK, this.b, "PressActionSpeak") != true) goto L61;
        r5 = true;
    L61:
        if (r5 == false) goto L64;
        a.a("click");
        return r25;
    L64:
        ICoreInputAbility r26 = this.c.h3();
        if (r26 == null) goto L70;
        long r27 = de8.d.a((de8.c) this.c.p.getValue());
        va8.o r29 = this.c.Y2();
        if (r29 == null) goto L69;
        r7 = Boolean.valueOf(r29.w());
    L69:
        r26.Wy("audio", r27, r7);
    L70:
        ICoreInputAbility r30 = this.c.h3();
        if (r30 == null) goto L73;
        r30.g2(2, true);
    L73:
        va8.o r31 = this.c.Y2();
        if (r31 == null) goto L76;
        r31.ra();
    L76:
        ICoreInputAbility r32 = this.c.h3();
        if (r32 == null) goto L79;
        r32.qp(true);
    L79:
        a.a("click");
        return true;
    L59:
        r25 = true;
        goto L61
    L52:
        if (this.c.nt() == false) goto L54;
        return true;
    L81:
        if (r6 != 1) goto L85;
        IAsrDirectFillAbility r33 = this.c.m3();
        if (r33 == null) goto L88;
        r33.S60();
    L88:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r34 = TouchSpeakerComponent.P2(this.c);
        if (r34 == null) goto L103;
        r34.pv(-1, ((Number) r2.getFirst()).floatValue(), ((Number) r2.getSecond()).floatValue(), ((Number) r1.getFirst()).floatValue(), ((Number) r1.getSecond()).floatValue());
        return true;
    L103:
        return true;
    L85:
        IAsrDirectFillAbility r35 = this.c.m3();
        if (r35 == null) goto L88;
        r35.cancel();
        goto L88
    L46:
        r112 = "ACTION_CANCEL";
        goto L47
    L30:
        if (r6 != 2) goto L32;
        maa.f r36 = (maa.f) this.c.q.getValue();
        if (r36 == null) goto L37;
        r36.ga(r2);
    L37:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r37 = TouchSpeakerComponent.P2(this.c);
        if (r37 == null) goto L100;
        r37.pv(0, ((Number) r2.getFirst()).floatValue(), ((Number) r2.getSecond()).floatValue(), ((Number) r1.getFirst()).floatValue(), ((Number) r1.getSecond()).floatValue());
        return true;
    L100:
        return true;
    L32:
        if (r6 == 3) goto L40;
        return true;
    L22:
        if (this.a <= 0) goto L24;
        f2a.c r114 = this.c.w.b("Touch EVENT: touchMoveCount > 0, MOVE END");
        r114.c.e = "PressActionSpeak";
        LinkedHashMap r115 = new LinkedHashMap();
        r115.put(new f2a.f("action_masked"), String.valueOf(r6));
        r115.put(new f2a.f("touch_move_count"), String.valueOf(this.a));
        r115.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r2.getFirst()).floatValue()));
        r115.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r2.getSecond()).floatValue()));
        r114.d(r115);
        r114.c.d = "buildTouchListenerOnPressActionSpeak.onTouch";
        r114.c.b = CollectionsKt.listOf(this.b);
        f2a.c.c(r114, null, 15);
        this.a = 0;
        goto L26
    L24:
        f2a.c r38 = this.c.w.b("Touch EVENT: touchMoveCount <= 0");
        r38.c.e = "PressActionSpeak";
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put(new f2a.f("action_masked"), String.valueOf(r6));
        r116.put(new f2a.f("touch_move_count"), String.valueOf(this.a));
        r116.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r2.getFirst()).floatValue()));
        r116.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r2.getSecond()).floatValue()));
        r38.d(r116);
        r38.c.d = "buildTouchListenerOnPressActionSpeak.onTouch";
        r38.c.b = CollectionsKt.listOf(this.b);
        f2a.c.c(r38, null, 15);
        goto L26
    }
}
