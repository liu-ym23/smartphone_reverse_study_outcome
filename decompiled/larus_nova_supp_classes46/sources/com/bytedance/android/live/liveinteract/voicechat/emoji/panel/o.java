package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends g {
    public final boolean f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        if (this.f == false) goto L5;
        return 2131251877;
    L5:
        return 2131251876;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (this.f == false) goto L6;
        return s1.B(2131923223);
    L6:
        return s1.B(2131923220);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.e.w0(this.f);
    }

    public o(q0 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
        this.f = r3;
    }
}
