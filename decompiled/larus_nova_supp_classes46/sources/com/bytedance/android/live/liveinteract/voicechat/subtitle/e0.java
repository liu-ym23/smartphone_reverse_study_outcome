package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 implements nj0.c {
    public final /* synthetic */ LinkmicSubtitleSettingDialog a;
    public final /* synthetic */ IAudioSubtitleContent b;

    public e0(LinkmicSubtitleSettingDialog r1, IAudioSubtitleContent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // nj0.c
    public final void a(boolean r1, CustomApiServerException r2) {
        if (r1 == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.p0;
        IAudioSubtitleContent r4 = this.b;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
        this.a.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L18;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L18:
        return;
    L10:
        if (r2 == null) goto L13;
        String r6 = r2.getPrompt();
        if (r6 == null) goto L13;
    L14:
        f2.c(r6, 0);
        return;
    L13:
        r6 = s1.B(2131919516);
        goto L14
    }
}
