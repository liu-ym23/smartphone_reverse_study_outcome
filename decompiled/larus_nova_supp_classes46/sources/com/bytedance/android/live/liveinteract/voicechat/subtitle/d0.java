package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleStyle;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 implements nj0.c {
    public final /* synthetic */ LinkmicSubtitleSettingDialog a;
    public final /* synthetic */ IAudioSubtitleContent b;
    public final /* synthetic */ LinkmicSubtitleStyle c;

    @Override // nj0.c
    public final void a(boolean r4, CustomApiServerException r5) {
        this.a.f = false;
        if (r4 == false) goto L19;
        com.bytedance.android.livesdk.sharedpref.e r6 = b6.p0;
        IAudioSubtitleContent r7 = this.b;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r7);
        LinkmicSubtitleUIContext.a r8 = LinkmicSubtitleUIContext.Companion;
        nj0.f r9 = r8.a();
        if (r9 == null) goto L7;
        r9.dk(this.c.ordinal());
    L7:
        q2 r10 = this.b.getSubtitleStatus();
        if (r10 == null) goto L25;
        nj0.f r11 = r8.a();
        if (r11 == null) goto L25;
        r11.ic((float) r10.getX(), (float) r10.getY(), "update_position_from_update_style");
    L25:
        this.a.dismiss();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L27;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L27:
        return;
    L19:
        if (r5 == null) goto L22;
        String r13 = r5.getPrompt();
        if (r13 == null) goto L22;
    L23:
        f2.c(r13, 0);
        return;
    L22:
        r13 = s1.B(2131919516);
        goto L23
    }

    public d0(LinkmicSubtitleSettingDialog r1, IAudioSubtitleContent r2, LinkmicSubtitleStyle r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
