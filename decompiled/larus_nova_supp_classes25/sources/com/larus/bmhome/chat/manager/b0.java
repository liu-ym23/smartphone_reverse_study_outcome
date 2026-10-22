package com.larus.bmhome.chat.manager;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.helper.ChatRouterHelper;
import com.larus.bmhome.view.screenmenu.ScreenMenuLayout;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.im.bean.conversation.ForkConversationRequest;
import com.larus.im.bean.conversation.ForkSource;
import com.larus.im.bean.conversation.ForkType;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 implements Function1<com.larus.bmhome.chat.nestedmenu.c, Unit> {
    public final /* synthetic */ x0 a;
    public final /* synthetic */ View b;
    public final /* synthetic */ t0 c;
    public final /* synthetic */ Fragment d;
    public final /* synthetic */ wc9.e e;
    public final /* synthetic */ String f;

    public b0(x0 r1, View r2, t0 r3, Fragment r4, wc9.e r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r33) {
        com.larus.bmhome.chat.nestedmenu.c r1 = (com.larus.bmhome.chat.nestedmenu.c) r33;
        Intrinsics.checkNotNullParameter(r1, "result");
        ScreenMenuLayout r2 = this.a.a;
        if (r2 == null) goto L5;
        r2.setMenuMask(false);
    L5:
        ReplyOption r3 = r1.f;
        if (r3 == null) goto L36;
        String r4 = r3.getModel().getKey();
        if (r4 == null) goto L36;
        Map r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("reply_mode", r4)});
        String r6 = r1.g;
        String r7 = null;
        if (r6 != null) goto L14;
    L19:
        this.a.c();
        ChatRouterHelper r8 = ChatRouterHelper.a;
        Context r9 = this.b.getContext();
        t0 r10 = this.c;
        if (r10 == null) goto L22;
        String r11 = r10.b;
    L23:
        if (r11 != null) goto L25;
        r11 = "";
    L25:
        String r12 = r11;
        by7.e r13 = this.d;
        if ((r13 instanceof by7.e) == false) goto L28;
        by7.e r23 = r13;
    L29:
        ForkSource.Conversation r14 = new ForkSource.Conversation(this.e.a);
        ForkType r15 = ForkType.CONVERSATION_SETTINGS;
        String r16 = this.e.I;
        if (r16 != null) goto L32;
    L34:
        ForkConversationRequest r17 = new ForkConversationRequest(r14, r15, r7, r5);
        String r18 = this.f;
        wc9.e r19 = this.e;
        ChatRouterHelper.h(r9, r18, r19, null, "click_navigation_cell", r12, null, null, null, null, null, null, null, false, false, false, false, r23, null, null, null, null, false, r17, new a0(r19, r3), 8191944);
        goto L36
    L32:
        if ((true ^ StringsKt.isBlank(r16)) == false) goto L34;
        r7 = r16;
        goto L34
    L28:
        r23 = null;
        goto L29
    L22:
        r11 = null;
        goto L23
    L14:
        if ((!StringsKt.isBlank(r6)) == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L19;
        r5.put("agent_task_param", r6);
    L36:
        return Unit.INSTANCE;
    }
}
