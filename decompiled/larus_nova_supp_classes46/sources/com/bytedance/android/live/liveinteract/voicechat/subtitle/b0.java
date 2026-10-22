package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateSubtitleType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ LinkmicSubtitleSettingDialog a;

    public b0(LinkmicSubtitleSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        if (Intrinsics.areEqual((Boolean) ((IInteractService) jc1.k.n(IInteractService.class)).subtitleExceptPlayModeOpen().first, Boolean.TRUE) == false) goto L6;
        f2.c((String) ((IInteractService) jc1.k.n(IInteractService.class)).subtitleExceptPlayModeOpen().second, 0);
        return;
    L6:
        LinkmicSubtitleSettingDialog r9 = this.a;
        boolean r2 = !r9.S90(2131387661).isChecked();
        if (r9.g == false) goto L9;
        f2.b(2131919517, 0);
    L19:
        if (this.a.S90(2131387661).isChecked() == true) goto L21;
        s r10 = t.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter("manual", "<set-?>");
        r10.e = "manual";
        t.g(this.a.i, "caption_open");
    L22:
        t.c(!this.a.S90(2131387661).isChecked());
        return;
    L21:
        s r11 = t.a;
        t.g(this.a.i, "caption_close");
        goto L22
    L9:
        r9.g = true;
        IAudioSubtitleContent r0 = r9.e;
        if (r0 != null) goto L12;
        r0 = (IAudioSubtitleContent) vh7.f.c(IAudioSubtitleContent.class);
    L12:
        if (r2 == false) goto L14;
        int r4 = IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue();
    L15:
        r0.setStatus(r4);
        nj0.b r5 = LinkmicSubtitleBusinessContext.Companion.b();
        if (r5 == null) goto L19;
        r5.N5(r0, UpdateSubtitleType.UNKNOWN, new c0(r9, r2, r0));
        goto L19
    L14:
        r4 = IAudioSubtitleContent.SwitchStatus.SWITCH_OFF.getValue();
        goto L15
    }
}
