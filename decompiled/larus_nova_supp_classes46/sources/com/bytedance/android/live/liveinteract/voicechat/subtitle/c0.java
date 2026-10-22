package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 implements nj0.c {
    public final /* synthetic */ LinkmicSubtitleSettingDialog a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ IAudioSubtitleContent c;

    @Override // nj0.c
    public final void a(boolean r3, CustomApiServerException r4) {
        LinkmicSubtitleSettingDialog r0 = this.a;
        r0.g = false;
        if (r3 == false) goto L7;
        r0.S90(2131387661).setChecked(this.b);
        com.bytedance.android.livesdk.sharedpref.e r5 = b6.p0;
        IAudioSubtitleContent r6 = this.c;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r6);
        if (this.b == true) goto L13;
        s r7 = t.a;
        String r8 = this.a.h;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.f = r8;
        return;
    L13:
        return;
    L7:
        if (r4 == null) goto L10;
        String r9 = r4.getPrompt();
        if (r9 == null) goto L10;
    L11:
        f2.c(r9, 0);
        return;
    L10:
        r9 = s1.B(2131919516);
        goto L11
    }

    public c0(LinkmicSubtitleSettingDialog r1, boolean r2, IAudioSubtitleContent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
