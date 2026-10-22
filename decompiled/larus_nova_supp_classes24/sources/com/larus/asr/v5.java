package com.larus.asr;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v5 implements View.OnTouchListener {
    public int a;
    public String b;
    public final /* synthetic */ TouchSpeakerComponent c;
    public final /* synthetic */ EditText d;

    public v5(TouchSpeakerComponent r1, EditText r2) {
        this.c = r1;
        this.d = r2;
        this.b = "";
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View r17, MotionEvent r19) {
        Intrinsics.checkNotNullParameter(r17, "v");
        Intrinsics.checkNotNullParameter(r19, "e");
        com.larus.bmhome.instruction.g r3 = (com.larus.bmhome.instruction.g) this.c.i.getValue();
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L10;
        return false;
    L10:
        int r5 = r19.getActionMasked();
        Pair r2 = TouchSpeakerComponent.N2(this.c, r17, r19);
        Pair r6 = TouchSpeakerComponent.L2(this.c, r17);
        if (r5 != 0) goto L14;
        this.b = UUID.randomUUID().toString();
    L14:
        if (r5 != 2) goto L19;
        int r14 = this.a + 1;
        this.a = r14;
        if (r14 != 1) goto L23;
        f2a.c r15 = this.c.w.b("Touch EVENT: ACTION_MOVE, MOVE START");
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r2.getFirst()).floatValue()));
        r16.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r2.getSecond()).floatValue()));
        r15.d(r16);
        r15.c.d = "buildTouchListenerOnPressInputText.onTouch";
        List r7 = CollectionsKt.listOf(this.b);
        f2a.g r10 = r15.c;
        r10.b = r7;
        r10.e = "InputText";
        f2a.c.c(r15, null, 15);
    L23:
        if (r5 != 0) goto L25;
        f2a.c r1 = this.c.w.b("Touch EVENT: ACTION_DOWN");
        f2a.g r8 = r1.c;
        r8.e = "InputText";
        r8.d = "buildTouchListenerOnPressInputText.onTouch";
        r1.c.b = CollectionsKt.listOf(this.b);
        f2a.c.c(r1, null, 15);
        x5.d().a(true);
        va8.o r9 = this.c.Y2();
        if (r9 == null) goto L47;
        r9.requestDisallowInterceptTouchEvent(true);
    L47:
        ViewParent r11 = this.d.getParent();
        if (r11 == null) goto L50;
        r11.requestDisallowInterceptTouchEvent(true);
    L50:
        Message r12 = this.c.p3().obtainMessage(10001);
        r12.obj = this.c.x;
        r12.getData().putBoolean("from_text_area", true);
        r12.getData().putString("asr_input_trace_id", this.b);
        r12.getData().putString("asr_input_enter_from", "InputText");
        this.c.p3().sendMessageDelayed(r12, this.c.z3().longPressTimeout());
        return true;
    L25:
        if (r5 != 1) goto L27;
    L34:
        x5.d().a(false);
        boolean r13 = this.c.p3().hasMessages(10001);
        f2a.c r20 = this.c.w.b("Touch EVENT: ACTION_UP or ACTION_CANCEL");
        LinkedHashMap r110 = new LinkedHashMap();
        f2a.f r111 = new f2a.f("touch_event");
        if (r5 != 1) goto L37;
        String r21 = "ACTION_UP";
    L38:
        r110.put(r111, r21);
        r110.put(new f2a.f("has_on_speak_msg"), String.valueOf(r13));
        r20.d(r110);
        f2a.g r22 = r20.c;
        r22.e = "InputText";
        r22.d = "buildTouchListenerOnPressInputText.onTouch";
        r20.c.b = CollectionsKt.listOf(this.b);
        f2a.c.c(r20, null, 15);
        if (r13 == false) goto L41;
        this.c.p3().removeMessages(10001);
        final TouchSpeakerComponent r23 = this.c;
        final EditText r24 = this.d;
        r17.post(new u5(r23, r24, r17));
        return true;
    L41:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r25 = TouchSpeakerComponent.P2(this.c);
        if (r25 == null) goto L56;
        r25.pv(-1, ((Number) r2.getFirst()).floatValue(), ((Number) r2.getSecond()).floatValue(), ((Number) r6.getFirst()).floatValue(), ((Number) r6.getSecond()).floatValue());
        return true;
    L56:
        return true;
    L37:
        r21 = "ACTION_CANCEL";
        goto L38
    L27:
        if (r5 != 2) goto L29;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r26 = TouchSpeakerComponent.P2(this.c);
        if (r26 == null) goto L53;
        r26.pv(0, ((Number) r2.getFirst()).floatValue(), ((Number) r2.getSecond()).floatValue(), ((Number) r6.getFirst()).floatValue(), ((Number) r6.getSecond()).floatValue());
        return true;
    L53:
        return true;
    L29:
        if (r5 == 3) goto L34;
        return true;
    L19:
        if (this.a <= 0) goto L21;
        f2a.c r27 = this.c.w.b("Touch EVENT: touchMoveCount > 0, MOVE END");
        r27.c.e = "InputText";
        LinkedHashMap r29 = new LinkedHashMap();
        r29.put(new f2a.f("action_masked"), String.valueOf(r5));
        r29.put(new f2a.f("touch_move_count"), String.valueOf(this.a));
        r29.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r2.getFirst()).floatValue()));
        r29.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r2.getSecond()).floatValue()));
        r27.d(r29);
        r27.c.d = "buildTouchListenerOnPressInputText.onTouch";
        r27.c.b = CollectionsKt.listOf(this.b);
        f2a.c.c(r27, null, 15);
        this.a = 0;
        goto L23
    L21:
        f2a.c r30 = this.c.w.b("Touch EVENT: touchMoveCount <= 0");
        r30.c.e = "InputText";
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put(new f2a.f("action_masked"), String.valueOf(r5));
        r31.put(new f2a.f("touch_move_count"), String.valueOf(this.a));
        r31.put(new f2a.f("global_touch_action_x"), String.valueOf(((Number) r2.getFirst()).floatValue()));
        r31.put(new f2a.f("global_touch_action_y"), String.valueOf(((Number) r2.getSecond()).floatValue()));
        r30.d(r31);
        r30.c.d = "buildTouchListenerOnPressInputText.onTouch";
        r30.c.b = CollectionsKt.listOf(this.b);
        f2a.c.c(r30, null, 15);
        goto L23
    L5:
        if (r3.Wa() != true) goto L7;
        r4 = true;
        goto L8
    }
}
