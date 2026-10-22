package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ j.b a;

    public m(j.b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        k82.a r6 = this.a.n.a;
        Map<String, String> r0 = null;
        if (r6 == null) goto L5;
        VSInputSectionType r7 = r6.q();
    L6:
        boolean r2 = true;
        if (r7 != VSInputSectionType.PAID_LIVE_PACKAGE) goto L21;
        k82.a r8 = this.a.n.a;
        if (r8 == null) goto L11;
        r8.A();
    L11:
        int r9 = l82.a.a;
        ImageView r10 = this.a.g;
        if (r10 != null) goto L14;
    L16:
        r2 = false;
    L17:
        k82.a r11 = this.a.n.a;
        if (r11 == null) goto L20;
        r0 = r11.o();
    L20:
        l82.a.a(false, r2, r0);
    L34:
        ImageView r13 = this.a.g;
        if (r13 == null) goto L38;
        UtilityKotlinExtentionsKt.z(r13, false);
        return;
    L38:
        return;
    L14:
        if (r10.getVisibility() != 0) goto L16;
    L21:
        k82.a r14 = this.a.n.a;
        if (r14 == null) goto L24;
        r14.B();
    L24:
        int r15 = l82.a.a;
        ImageView r16 = this.a.g;
        if (r16 != null) goto L27;
    L29:
        boolean r17 = false;
    L30:
        k82.a r1 = this.a.n.a;
        if (r1 == null) goto L33;
        r0 = r1.o();
    L33:
        l82.a.a(true, r17, r0);
        goto L34
    L27:
        if (r16.getVisibility() != 0) goto L29;
        r17 = true;
        goto L30
    L5:
        r7 = null;
        goto L6
    }
}
