package com.larus.bmhome.chat.component.bottom;

import android.os.Bundle;
import com.larus.bmhome.bot.health.IChatBotHealthService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.model.n;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.d;
import com.larus.platform.service.z2;
import com.larus.utils.SafeExtKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import de8.c;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c1 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ChatBottomComponent a;

    public c1(ChatBottomComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.larus.bmhome.chat.component.bottom.t0] */
    public final void c(Object r15) {
        final BotModel r16 = (BotModel) r15;
        Intrinsics.checkNotNullParameter(r16, "new");
        final ChatBottomComponent r0 = this.a;
        ChatBottomComponent r2 = this.a;
        int r3 = ChatBottomComponent.L0;
        LarusPageChatBinding r4 = r2.z3();
        String r5 = null;
        if (r4 == null) goto L5;
        TouchInterceptingView r6 = r4.l;
    L6:
        WeakReference r1 = new WeakReference(r6);
        r0.getClass();
        IChatBotHealthService r7 = (IChatBotHealthService) ServiceManager.get().getService(IChatBotHealthService.class);
        if (r7 == 0) goto L9;
        ?? r8 = new t0(r0);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r7.a(r8, r1, com.larus.ui.arch.component.internal.attach.a.b(r0, r0).getParentFragmentManager(), r16);
    L9:
        final ChatBottomComponent r9 = this.a;
        r9.getClass();
        final String r10 = r16.getBotId();
        String r11 = "";
        if (r10 != null) goto L12;
        r10 = "";
    L12:
        BotMemoryConfig r12 = r16.getBotMemoryConfig();
        boolean r13 = false;
        if (r12 == null) goto L15;
        boolean r14 = Intrinsics.areEqual(r12.getHintShouldDisplay(), Boolean.TRUE);
    L16:
        if (r14 == false) goto L18;
        d.a().updateLocalBot(r10, new p0(r16), null);
        Intrinsics.checkNotNullParameter(r9, "<this>");
        SafeExtKt.c(com.larus.ui.arch.component.internal.attach.a.b(r9, r9), new q0(r9, r10), 1000);
    L18:
        c r17 = this.a.f1();
        if (r17 == null) goto L27;
        Bundle r18 = r17.b;
        if (r18 == null) goto L27;
        String r19 = r18.getString("input_text");
        if (r19 == null) goto L27;
        if (com.larus.utils.o0.d(r19) != true) goto L27;
        boolean r110 = true;
    L28:
        if (r110 == false) goto L80;
        c r111 = this.a.f1();
        if (r111 != null) goto L32;
    L34:
        boolean r112 = false;
    L35:
        z2 r20 = z2.a;
        if (z2.c4() == false) goto L47;
        if (r112 == true) goto L47;
        ChatBottomComponent r113 = this.a;
        c r21 = r113.f1();
        if (r21 == null) goto L43;
        Bundle r22 = r21.b;
        if (r22 == null) goto L43;
        r5 = r22.getString("input_text");
    L43:
        if (r5 == null) goto L46;
        r11 = r5;
    L46:
        r113.Q3(r11);
        return;
    L47:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r23 = this.a.f70();
        if (r23 == null) goto L56;
        ChatBottomComponent r24 = this.a;
        if (z2.c4() == true) goto L54;
        n r25 = r24.D;
        if (r25 == null) goto L54;
        r25.l(null);
    L54:
        if (r112 == true) goto L56;
        r23.b2(r23.uM());
        r23.dm();
    L56:
        ChatBottomComponent r114 = this.a;
        c r26 = r114.f1();
        if (r26 == null) goto L65;
        Bundle r27 = r26.b;
        if (r27 == null) goto L65;
        String r28 = r27.getString("input_text");
        if (r28 == null) goto L65;
        if (com.larus.utils.o0.d(r28) != true) goto L65;
        r13 = true;
    L65:
        if (r13 == false) goto L83;
        ICoreInputAbility r29 = r114.E3();
        if (r29 == null) goto L69;
        r29.g2(3, true);
    L69:
        ICoreInputAbility r30 = r114.E3();
        if (r30 == null) goto L84;
        c r115 = r114.f1();
        if (r115 == null) goto L76;
        Bundle r116 = r115.b;
        if (r116 == null) goto L76;
        r5 = r116.getString("input_text");
    L76:
        if (r5 != null) goto L78;
        String r31 = "";
    L79:
        ICoreInputAbility.b.d(r30, r31, true, true, null, null, false, 56);
        return;
    L78:
        r31 = r5;
        goto L79
    L84:
        return;
    L83:
        return;
    L32:
        if (r111.A() != true) goto L34;
        r112 = true;
        goto L35
    L80:
        this.a.c4(true);
        return;
    L27:
        r110 = false;
        goto L28
    L15:
        r14 = false;
        goto L16
    L5:
        r6 = null;
        goto L6
    }
}
