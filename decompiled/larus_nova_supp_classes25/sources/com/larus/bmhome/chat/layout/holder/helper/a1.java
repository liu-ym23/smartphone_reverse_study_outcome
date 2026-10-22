package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.skydoves.balloon.Balloon;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a1 {
    public final Message a;
    public final com.larus.bmhome.chat.api.q0 b;
    public final com.larus.bmhome.chat.api.q0.a c;
    public final t0 d;
    public final ViewGroup e;
    public final JSONObject f;
    public Balloon g;
    public Balloon h;
    public CommonMenu i;

    public abstract void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C0061a r1);

    public abstract ef8.b c(View r1);

    public void d() {
    }

    public static Integer e(JSONObject r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.opt("content_type");
    L7:
        if ((r3 instanceof Number) == false) goto L10;
        return Integer.valueOf(((Number) r3).intValue());
    L10:
        if ((r3 instanceof String) == true) goto L12;
        return null;
    L12:
        return StringsKt.toIntOrNull((String) r3);
    L5:
        r3 = null;
        goto L7
    }

    public final void b(List<? extends ot8.a> r9, boolean r10, Integer r11) {
        ChatControlTrace r0 = ChatControlTrace.b;
        Message r2 = this.a;
        com.larus.bmhome.chat.api.q0.a r1 = this.c;
        if (r1 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r3 = r1.u0();
        if (r3 == null) goto L7;
        BotModel r4 = r3.j0();
    L8:
        com.larus.bmhome.chat.api.q0.a r5 = this.c;
        if (r5 == null) goto L15;
        com.larus.bmhome.chat.component.cvs.y r6 = r5.u0();
        if (r6 == null) goto L15;
        wc9.e r7 = r6.h();
        if (r7 == null) goto L15;
        String r8 = ic8.n.f(r7);
    L16:
        if (r10 == false) goto L18;
        String r12 = "click_long_press_more";
    L19:
        JSONObject r13 = new JSONObject();
        r13.putOpt("content_type", r11);
        Unit r14 = Unit.INSTANCE;
        r0.jc(r9, r2, r4, null, r8, r12, r13);
        return;
    L18:
        r12 = "long_press_message";
    L15:
        r8 = null;
    L7:
        r4 = null;
        goto L8
    }

    public a1(Message r2, com.larus.bmhome.chat.api.q0 r3, com.larus.bmhome.chat.api.q0.a r4, t0 r5, ViewGroup r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r5, "popMenuGroupCreator");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ a1(Message r8, com.larus.bmhome.chat.api.q0 r9, com.larus.bmhome.chat.api.q0.a r10, t0 r11, JSONObject r12, int r13) {
        if ((r13 & 32) == 0) goto L5;
        r12 = null;
    L5:
        this(r8, r9, r10, r11, null, r12);
    }
}
