package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ LinkmicSubtitleUIWidget a;

    public f0(LinkmicSubtitleUIWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        FragmentActivity r5 = ContextUtil.contextToFragmentActivity(this.a.getContext());
        if (r5 == null) goto L15;
        FragmentManager r6 = r5.getSupportFragmentManager();
        if (r6 == null) goto L16;
        String r0 = LinkmicSubtitleSettingDialog.j;
        LinkmicSubtitleSettingDialog r1 = LinkmicSubtitleSettingDialog.a.a((IAudioSubtitleContent) b6.p0.getValue(), "click_menu");
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "LinkmicSubtitleSettingDialog", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r1, r2) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r1.show(r6, "LinkmicSubtitleSettingDialog");
        return;
    L17:
        return;
    L16:
        return;
    }
}
