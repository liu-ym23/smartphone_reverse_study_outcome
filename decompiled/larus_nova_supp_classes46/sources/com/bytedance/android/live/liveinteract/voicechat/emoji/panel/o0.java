package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o0 extends g {
    public final boolean f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        if (((Boolean) b6.h.getValue()).booleanValue() == true) goto L7;
        return 2131251819;
    L7:
        if (this.f == false) goto L10;
        return 2131251818;
    L10:
        return 2131251820;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (((Boolean) b6.h.getValue()).booleanValue() == true) goto L9;
        if (this.f == true) goto L9;
        return s1.B(2131917581);
    L9:
        if (this.f == false) goto L13;
        return s1.B(2131917596);
    L13:
        return s1.B(2131917801);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if (((Boolean) b6.h.getValue()).booleanValue() == true) goto L6;
        f2.b(2131917478, 0);
        return;
    L6:
        q0 r3 = this.e;
        if (r3 == null) goto L10;
        r3.b(!this.f);
        return;
    }

    public o0(q0 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
        this.f = r3;
    }
}
