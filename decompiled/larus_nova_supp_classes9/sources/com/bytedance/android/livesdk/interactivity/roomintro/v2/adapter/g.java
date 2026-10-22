package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.x0;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ a a;

    public g(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        UtilityKotlinExtentionsKt.t(this.a.d);
        TextCorrectionEditText r4 = this.a.c;
        if (r4 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r4);
    L5:
        String r5 = this.a.a;
        if (r5 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == true) goto L21;
        a r7 = this.a;
        TextCorrectionEditText r0 = r7.c;
        if (r0 == null) goto L16;
        r0.setText(r7.a);
    L16:
        int r8 = this.a.b();
        String r1 = this.a.a;
        if (r1 == null) goto L21;
        int r2 = r1.length();
        TextCorrectionEditText r9 = this.a.c;
        if (r9 == null) goto L21;
        r9.setSelection(RangesKt.coerceAtMost(r2, r8));
    L21:
        x0.b(this.a.c);
        return;
    L8:
        if (r5.length() == 0) goto L11;
        r6 = false;
        goto L12
    }
}
