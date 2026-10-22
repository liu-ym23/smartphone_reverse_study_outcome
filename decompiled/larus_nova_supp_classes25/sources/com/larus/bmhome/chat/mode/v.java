package com.larus.bmhome.chat.mode;

import android.view.View;
import com.larus.bmhome.auth.ConversationMode;
import com.larus.platform.api.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v implements View.OnLayoutChangeListener {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ v(ModeSwitchComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        ModeSwitchComponent r10 = this.a;
        if (r10.D == true) goto L22;
        if (r10.B == true) goto L22;
        if (r10.D3() == true) goto L22;
        if (r10.G == true) goto L11;
    L14:
        ry8.b r11 = r10.B3();
        if (r11 == null) goto L22;
        g0 r12 = r11.C5();
        if (r12 == null) goto L22;
        View r13 = r12.getTitle();
        if (r13 == null) goto L22;
        r13.setVisibility(4);
        goto L22
    L11:
        if (r10.C == false) goto L22;
        if (r10.w == true) goto L14;
    L22:
        if (r10.C == true) goto L24;
        return;
    L24:
        if (r10.w == true) goto L26;
        return;
    L26:
        if (r10.B == true) goto L31;
        r10.Q3((ConversationMode) r10.Si().getValue());
        return;
    }
}
