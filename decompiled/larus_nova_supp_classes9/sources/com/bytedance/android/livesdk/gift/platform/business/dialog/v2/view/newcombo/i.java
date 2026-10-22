package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;
import java.security.SecureRandom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements p0 {
    public final /* synthetic */ ComboProgressAnimationViewNew a;
    public final /* synthetic */ boolean b;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final void b(py.k r1, Exception r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public i(ComboProgressAnimationViewNew r1) {
        this.a = r1;
        this.b = true;
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
        HSImageView r5 = this.a.x;
        ViewGroup.LayoutParams r6 = null;
        if (r5 == null) goto L5;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
    L7:
        if ((r7 instanceof ViewGroup.LayoutParams) == false) goto L19;
        float r8 = r2 / r3;
        HSImageView r9 = this.a.x;
        if (r9 == null) goto L11;
        r6 = r9.getLayoutParams();
    L11:
        if (r6 == null) goto L13;
        r6.height = (int) this.a.getContext().getResources().getDimension(2131168699);
    L13:
        if (r6 == null) goto L15;
        r6.width = (int) (r6.height * r8);
    L15:
        HSImageView r10 = this.a.x;
        if (r10 == null) goto L19;
        r10.setLayoutParams(r6);
    L19:
        if (b02.a.e() == true) goto L28;
        if ((new SecureRandom().nextInt(10) % 2) != 0) goto L23;
        float r11 = -5.0f;
    L24:
        HSImageView r13 = this.a.x;
        if (r13 == null) goto L28;
        r13.setRotation(r11);
        goto L28
    L23:
        r11 = 5.0f;
    L28:
        if (this.b == false) goto L31;
        ComboProgressAnimationViewNew.a(this.a, false, false);
        return;
    L31:
        return;
    L5:
        r7 = null;
        goto L7
    }
}
