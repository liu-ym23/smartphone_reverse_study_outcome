package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends g {
    public final boolean b;

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r0 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r0 == null) goto L9;
        if (r0.a() == true) goto L9;
        return 2131251819;
    L9:
        if (this.b == false) goto L12;
        return 2131251818;
    L12:
        return 2131251820;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L5;
    L8:
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r0 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r0 == null) goto L15;
        if (r0.a() == true) goto L15;
        return s1.B(2131917581);
    L15:
        if (this.b == false) goto L19;
        return s1.B(2131917596);
    L19:
        return s1.B(2131917801);
    L5:
        if (this.b == true) goto L8;
        return s1.B(2131917801);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r4 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r4 != null) goto L5;
    L8:
        f r5 = this.a;
        if (r5 == null) goto L12;
        r5.x5(!this.b, false);
        return;
    L12:
        return;
    L5:
        if (r4.a() == true) goto L8;
        f2.b(2131917478, 0);
    }

    public h(f r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
        this.b = r3;
    }
}
