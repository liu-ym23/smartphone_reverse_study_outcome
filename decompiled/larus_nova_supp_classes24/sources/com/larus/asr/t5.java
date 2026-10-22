package com.larus.asr;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.larus.asr.direct.IAsrDirectFillAbility;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t5 implements View.OnTouchListener {
    public int a;
    public long b;
    public String c;
    public final /* synthetic */ TouchSpeakerComponent d;

    public t5(TouchSpeakerComponent r1) {
        this.d = r1;
        this.c = "";
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View r17, MotionEvent r19) {
        Intrinsics.checkNotNullParameter(r17, "v");
        Intrinsics.checkNotNullParameter(r19, "e");
        com.larus.bmhome.instruction.g r1 = (com.larus.bmhome.instruction.g) this.d.i.getValue();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return false;
    L10:
        int r3 = r19.getActionMasked();
        Pair r0 = TouchSpeakerComponent.N2(this.d, r17, r19);
        Pair r4 = TouchSpeakerComponent.L2(this.d, r17);
        if (r3 != 0) goto L14;
        this.b++;
        this.c = UUID.randomUUID().toString();
    L14:
        if (r3 != 2) goto L19;
        int r14 = this.a + 1;
        this.a = r14;
        if (r14 != 1) goto L23;
        f2a.c r15 = this.d.w.b("Touch EVENT: ACTION_MOVE, MOVE START");
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r0.getFirst()).floatValue()));
        r16.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r0.getSecond()).floatValue()));
        r15.d(r16);
        r15.c.d = "buildTouchListenerOnPressInputText.onTouch";
        List r5 = CollectionsKt.listOf(this.c);
        f2a.g r10 = r15.c;
        r10.b = r5;
        r10.e = "InputText";
        f2a.c.c(r15, null, 15);
    L23:
        if (r3 != 0) goto L25;
        f2a.c r6 = this.d.w.b("Touch EVENT: ACTION_DOWN");
        f2a.g r7 = r6.c;
        r7.e = "InputText";
        r7.d = "buildTouchListenerOnPressInputText.onTouch";
        r6.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r6, null, 15);
        TouchSpeakerComponent.U2(this.d);
        x5.d().a(true);
        va8.o r8 = this.d.Y2();
        if (r8 == null) goto L55;
        r8.requestDisallowInterceptTouchEvent(true);
    L55:
        Message r9 = this.d.p3().obtainMessage(10001);
        r9.obj = this.d.x;
        r9.getData().putBoolean("from_text_area", true);
        r9.getData().putString("asr_input_trace_id", this.c);
        r9.getData().putString("asr_input_enter_from", "InputText");
        this.d.p3().sendMessageDelayed(r9, this.d.z3().longPressTimeout());
        return true;
    L25:
        if (r3 != 1) goto L27;
    L34:
        x5.d().a(false);
        boolean r11 = this.d.p3().hasMessages(10001);
        f2a.c r12 = this.d.w.b("Touch EVENT: ACTION_UP or ACTION_CANCEL");
        LinkedHashMap r13 = new LinkedHashMap();
        f2a.f r110 = new f2a.f("touch_event");
        if (r3 != 1) goto L37;
        String r111 = "ACTION_UP";
    L38:
        r13.put(r110, r111);
        r13.put(new f2a.f("has_on_speak_msg"), String.valueOf(r11));
        r12.d(r13);
        f2a.g r112 = r12.c;
        r112.e = "InputText";
        r112.d = "buildTouchListenerOnPressInputText.onTouch";
        r12.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r12, null, 15);
        if (r11 == false) goto L42;
        this.d.p3().removeMessages(10001);
        final long r20 = this.b;
        final String r21 = this.c;
        final TouchSpeakerComponent r22 = this.d;
        r17.post(new s5(r20, this, r17, r21, r22));
        return true;
    L42:
        if (r3 != 1) goto L46;
        IAsrDirectFillAbility r23 = this.d.m3();
        if (r23 == null) goto L49;
        r23.S60();
    L49:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r24 = TouchSpeakerComponent.P2(this.d);
        if (r24 == null) goto L61;
        r24.pv(-1, ((Number) r0.getFirst()).floatValue(), ((Number) r0.getSecond()).floatValue(), ((Number) r4.getFirst()).floatValue(), ((Number) r4.getSecond()).floatValue());
        return true;
    L61:
        return true;
    L46:
        IAsrDirectFillAbility r25 = this.d.m3();
        if (r25 == null) goto L49;
        r25.cancel();
        goto L49
    L37:
        r111 = "ACTION_CANCEL";
        goto L38
    L27:
        if (r3 != 2) goto L29;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r26 = TouchSpeakerComponent.P2(this.d);
        if (r26 == null) goto L58;
        r26.pv(0, ((Number) r0.getFirst()).floatValue(), ((Number) r0.getSecond()).floatValue(), ((Number) r4.getFirst()).floatValue(), ((Number) r4.getSecond()).floatValue());
        return true;
    L58:
        return true;
    L29:
        if (r3 == 3) goto L34;
        return true;
    L19:
        if (this.a <= 0) goto L21;
        f2a.c r27 = this.d.w.b("Touch EVENT: touchMoveCount > 0, MOVE END");
        r27.c.e = "InputText";
        LinkedHashMap r29 = new LinkedHashMap();
        r29.put(new f2a.f("action_masked"), String.valueOf(r3));
        r29.put(new f2a.f("touch_move_count"), String.valueOf(this.a));
        r29.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r0.getFirst()).floatValue()));
        r29.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r0.getSecond()).floatValue()));
        r27.d(r29);
        r27.c.d = "buildTouchListenerOnPressInputText.onTouch";
        r27.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r27, null, 15);
        this.a = 0;
        goto L23
    L21:
        f2a.c r30 = this.d.w.b("Touch EVENT: touchMoveCount <= 0");
        r30.c.e = "InputText";
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put(new f2a.f("action_masked"), String.valueOf(r3));
        r31.put(new f2a.f("touch_move_count"), String.valueOf(this.a));
        r31.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r0.getFirst()).floatValue()));
        r31.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r0.getSecond()).floatValue()));
        r30.d(r31);
        r30.c.d = "buildTouchListenerOnPressInputText.onTouch";
        r30.c.b = CollectionsKt.listOf(this.c);
        f2a.c.c(r30, null, 15);
        goto L23
    L5:
        if (r1.Wa() != true) goto L7;
        r2 = true;
        goto L8
    }
}
