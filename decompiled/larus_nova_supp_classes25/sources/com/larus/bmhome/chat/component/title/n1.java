package com.larus.bmhome.chat.component.title;

import com.larus.bmhome.view.ChatTitleAlignLeftStyle;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.j;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n1 implements com.larus.bmhome.chat.component.cvs.y.a<e> {
    public final /* synthetic */ ChatTitleComponent a;

    public n1(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final void c(Object r9) {
        e r10 = (e) r9;
        Intrinsics.checkNotNullParameter(r10, "new");
        ChatTitleComponent r0 = this.a;
        int r1 = ChatTitleComponent.P1;
        if (r0.B3() == null) goto L59;
        ChatTitleAlignLeftStyle r2 = r0.n;
        if (r2 == null) goto L59;
        if ((r2 instanceof ChatTitleAlignLeftStyle) == false) goto L59;
        j r3 = r0.h3();
        String r4 = "";
        if (r3 == null) goto L15;
        ChatTitleAlignLeftStyle r5 = r2;
        String r6 = r10.c;
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r5.Ia(r6, r3, r10.g());
    L19:
        BotModel r7 = r0.j0();
        boolean r8 = false;
        if (r7 == null) goto L27;
        Integer r11 = r7.getBotStatus();
        if (r11 == null) goto L27;
        if (r11.intValue() != (-40)) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
        r2.Sa("", "", true);
        goto L59
    L30:
        IconImage r13 = r10.b;
        String r14 = null;
        if (r13 == null) goto L35;
        ImageObj r15 = r13.imageOri;
        if (r15 == null) goto L35;
        String r16 = r15.url;
    L36:
        if (r16 != null) goto L38;
        r16 = "";
    L38:
        if (r13 == null) goto L42;
        ImageObj r17 = r13.imageThumb;
        if (r17 == null) goto L42;
        String r18 = r17.url;
    L43:
        if (r18 != null) goto L46;
        r18 = "";
    L46:
        if (r18.length() != 0) goto L48;
        r8 = true;
    L48:
        if (r8 == false) goto L58;
        IconImage r19 = r10.b;
        if (r19 == null) goto L54;
        ImageObj r20 = r19.imageOri;
        if (r20 == null) goto L54;
        r14 = r20.url;
    L54:
        if (r14 == null) goto L57;
        r4 = r14;
    L57:
        r18 = r4;
    L58:
        r2.Sa(r16, r18, true);
    L42:
        r18 = null;
    L35:
        r16 = null;
    L27:
        r12 = false;
        goto L28
    L15:
        String r21 = r10.c;
        if (r21 != null) goto L18;
        r21 = "";
    L18:
        com.larus.platform.api.g0.a.b(r2, r21, r10.g(), 2);
    L59:
        ChatTitleComponent.Y2(this.a);
    }
}
