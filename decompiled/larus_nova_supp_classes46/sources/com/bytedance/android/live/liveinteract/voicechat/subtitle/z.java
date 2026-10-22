package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ LinkmicSubtitleSettingDialog a;

    public z(LinkmicSubtitleSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (Intrinsics.areEqual((Boolean) ((IInteractService) jc1.k.n(IInteractService.class)).subtitleExceptPlayModeOpen().first, Boolean.TRUE) == false) goto L12;
        f2.c((String) ((IInteractService) jc1.k.n(IInteractService.class)).subtitleExceptPlayModeOpen().second, 0);
        this.a.dismiss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L16:
        return;
    L12:
        LinkmicSubtitleSettingDialog.U90(this.a, LinkmicSubtitleType.Room);
        s r4 = t.a;
        t.g(this.a.i, "normal_cpation");
    }
}
