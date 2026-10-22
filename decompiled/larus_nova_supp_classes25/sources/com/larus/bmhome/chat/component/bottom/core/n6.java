package com.larus.bmhome.chat.component.bottom.core;

import android.widget.EditText;
import com.ixigua.lib.track.TrackParams;
import com.larus.im.bean.bot.BotModel;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n6 implements Function1 {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ CoreInputComponent b;
    public final /* synthetic */ LarusWidgetInputBinding c;

    public /* synthetic */ n6(EditText r1, CoreInputComponent r2, LarusWidgetInputBinding r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r10) {
        EditText r0 = this.a;
        CoreInputComponent r1 = this.b;
        LarusWidgetInputBinding r2 = this.c;
        boolean r11 = ((Boolean) r10).booleanValue();
        int r3 = CoreInputComponent.d3;
        FLogger.a.i("CoreInputComponent", "setImeAnimationCallback isImeShow=" + r11 + " isFocus=" + r0.hasFocus() + " isResumed=" + a.c(r1).isResumed() + " hashcode=" + a.c(r1).hashCode());
        int r4 = 1;
        if (r11 == false) goto L7;
        int r5 = r2.I.getHeight();
        int r6 = r1.F4().getKvStore().getInt("template_ime_height", -1);
        if (r6 <= 0) goto L9;
        r1.F4().handleFloatWindow(true, Integer.valueOf(r6 - r5));
    L9:
        if (a.c(r1).isResumed() == false) goto L47;
        if (r11 == false) goto L12;
        boolean r7 = r0.hasFocus();
    L13:
        wc9.e r8 = r1.k4().h();
        BotModel r9 = r1.k4().q();
        Boolean r12 = Boolean.valueOf(r11);
        Boolean r13 = Boolean.valueOf(r7);
        String r14 = null;
        if (r9 == null) goto L16;
        String r15 = r9.getBotId();
    L17:
        if (r9 == null) goto L19;
        String r16 = r9.getName();
    L20:
        if (r8 == null) goto L22;
        String r17 = r8.a;
    L23:
        if (r8 == null) goto L25;
        r14 = ic8.n.f(r8);
    L25:
        boolean r18 = tx9.o3.a;
        JSONObject r19 = new JSONObject();
        Intrinsics.checkNotNullParameter(r19, "params");
        if (r12 != null) goto L49;
    L34:
        if (r13 == null) goto L36;
        r19.put("enable", r13.booleanValue() ? 1 : 0);     // Catch: JSONException -> L32
    L36:
        if (r15 == null) goto L38;
        r19.put("bot_id", r15);     // Catch: JSONException -> L32
    L38:
        if (r16 == null) goto L40;
        r19.put("bot_name", r16);     // Catch: JSONException -> L32
    L40:
        if (r17 == null) goto L42;
        r19.put("conversation_id", r17);     // Catch: JSONException -> L32
    L42:
        if (r14 == null) goto L46;
        r19.put("chat_type", r14);     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper mobDevKeyboardShow " + e.getLocalizedMessage());
    L46:
        TrackParams r110 = new TrackParams().merge(r19);
        by7.a r20 = new by7.a("dev_keyboard_show");
        r20.a.merge(r110);
        r20.b();
        goto L47
    L49:
        if (r12.booleanValue() == true) goto L31;
        r4 = 0;
    L31:
        r19.put("is_show", r4);     // Catch: JSONException -> L32
        goto L34
    L22:
        r17 = null;
        goto L23
    L19:
        r16 = null;
        goto L20
    L16:
        r15 = null;
        goto L17
    L12:
        r7 = true;
    L47:
        r1.lj();
        return Unit.INSTANCE;
    L7:
        int[] r21 = new int[2];
        r2.a.getLocationOnScreen(r21);
        r1.F4().getKvStore().storeInt("template_ime_height", r21[1] + r2.a.getHeight());
        goto L9
    }
}
