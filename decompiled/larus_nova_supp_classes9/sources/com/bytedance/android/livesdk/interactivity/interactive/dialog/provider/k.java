package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ j.b a;

    public k(j.b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        k82.a r3 = this.a.n.a;
        if (r3 == null) goto L5;
        VSInputSectionType r4 = r3.q();
    L7:
        if (r4 != VSInputSectionType.EMOJI) goto L11;
        k82.a r5 = this.a.n.a;
        if (r5 == null) goto L15;
        r5.A();
        return;
    L15:
        return;
    L11:
        k82.a r6 = this.a.n.a;
        if (r6 == null) goto L17;
        r6.z();
        return;
    L17:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
