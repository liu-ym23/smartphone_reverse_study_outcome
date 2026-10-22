package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.View;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;
import com.bytedance.android.live.profile.ui.base.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements ProfileNestedScrollView.b {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.profile.customview.ProfileNestedScrollView.b
    public final void a(int r9, int r10, int r12) {
        a r0 = this.a;
        n r1 = (n) r0.e.getValue();
        if (r1 == null) goto L5;
        int r2 = r1.getBottom();
    L6:
        int r3 = a.i;
        if (r9 < (r2 + r3)) goto L15;
        View r13 = r0.b;
        if (r13 != null) goto L11;
    L12:
        View r14 = r0.b;
        if (r14 == null) goto L30;
        r14.setAlpha(1.0f);
    L30:
        a r15 = this.a;
        if (r10 < r12) goto L39;
        if (r15.g == true) goto L45;
        View r16 = r15.b;
        if (r16 == null) goto L37;
        r16.setOnClickListener(b.a);
    L37:
        r15.g = true;
        return;
    L45:
        return;
    L39:
        if (r15.g == false) goto L47;
        View r17 = r15.b;
        if (r17 == null) goto L43;
        r17.setOnClickListener(null);
    L43:
        r15.g = false;
        return;
    L47:
        return;
    L11:
        if (r13.getAlpha() == 1.0f) goto L30;
    L15:
        if (r9 >= r2) goto L23;
        View r18 = r0.b;
        if (r18 != null) goto L19;
    L20:
        View r19 = r0.b;
        if (r19 == null) goto L30;
        r19.setAlpha(0.0f);
        goto L30
    L19:
        if (r18.getAlpha() == 0.0f) goto L30;
    L23:
        float r20 = (float) (((double) (r9 - r2)) / ((double) r3));
        View r4 = r0.b;
        if (r4 != null) goto L26;
    L27:
        View r5 = r0.b;
        if (r5 == null) goto L30;
        r5.setAlpha(r20);
        goto L30
    L26:
        if (r4.getAlpha() == r20) goto L30;
    L5:
        r2 = 0;
        goto L6
    }
}
