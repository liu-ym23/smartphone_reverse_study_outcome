package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n extends mx.h implements View.OnClickListener {
    public final Context m;
    public final ListDialogAbility n;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.n.dismissDialog();
        IAudioSubtitleContent r5 = (IAudioSubtitleContent) b6.p0.getValue();
        if (r5 == null) goto L5;
        jc1.k.n(IInteractService.class).openLinkmicSubtitleSettingDialog(this.m, "more", r5);
    L5:
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.N1;
        if (((Boolean) r6.getValue()).booleanValue() == true) goto L9;
        Boolean r0 = Boolean.TRUE;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r0);
        return;
    }

    public n(Context r4, ListDialogAbility r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "ability");
        super(s1.B(2131919512), s1.B(2131919513), !((Boolean) com.bytedance.android.livesdk.sharedpref.b.N1.getValue()).booleanValue());
        this.m = r4;
        this.n = r5;
        ((mx.h) this).l = this;
    }
}
