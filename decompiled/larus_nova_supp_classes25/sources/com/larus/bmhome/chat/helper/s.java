package com.larus.bmhome.chat.helper;

import com.larus.audio.AudioServiceDelegate;
import com.larus.common_ui.dialog.p0;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import tx9.f3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s implements p0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ CocoSubConversationSettingMenuTrigger b;

    public final void confirm() {
        if (com.larus.utils.o0.d(this.a) == false) goto L6;
        this.b.b(this.a);
    L6:
        if (AudioServiceDelegate.a.getAudioConfig().n(this.b.f) == false) goto L8;
        String r0 = "1";
    L9:
        String r8 = r0;
        BotModel r1 = this.b.f;
        String r2 = null;
        if (r1 == null) goto L12;
        String r3 = r1.getBotId();
    L13:
        CocoSubConversationSettingMenuTrigger r4 = this.b;
        RecommendFrom r5 = r4.c;
        if (r5 == null) goto L16;
        String r7 = r5.c;
    L17:
        if (r5 == null) goto L19;
        r2 = r5.b;
    L19:
        String r9 = r2;
        wc9.e r6 = r4.e;
        if (r6 == null) goto L27;
        Integer r10 = r6.t;
        if (r10 == null) goto L27;
        if (r10.intValue() != 8) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L30;
        String r12 = "archived";
    L31:
        String r13 = r12;
        f3.a(r3, this.a, "default_new", "chat_popup_menu", "chat", null, r7, r8, r9, null, r13, 1120);
        return;
    L30:
        r12 = "normal";
    L27:
        r11 = false;
        goto L28
    L16:
        r7 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    L8:
        r0 = "0";
        goto L9
    }

    public s(String r1, CocoSubConversationSettingMenuTrigger r2) {
        this.a = r1;
        this.b = r2;
    }
}
