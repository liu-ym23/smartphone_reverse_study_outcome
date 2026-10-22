package com.larus.bmhome.chat.trace;

import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, String r4, wc9.e r5, by7.e r6) {
        Intrinsics.checkNotNullParameter(r3, "reeditType");
        by7.a r0 = new by7.a("click_re_edit");
        if (r4 == null) goto L5;
        r0.d("bot_id", r4);
    L5:
        String r7 = null;
        if (r5 == null) goto L8;
        String r1 = ic8.n.f(r5);
    L9:
        if (r1 == null) goto L11;
        r0.d("chat_type", r1);
    L11:
        r0.d("click_from", "answer");
        if (r5 == null) goto L14;
        r7 = r5.a;
    L14:
        r0.d(MusicAppletPage.KEY_CONVERSATION_ID, r7);
        r0.d("edit_type", r3);
        if (r6 == null) goto L17;
        r0.b = r6;
    L17:
        r0.b();
        return;
    L8:
        r1 = null;
        goto L9
    }
}
