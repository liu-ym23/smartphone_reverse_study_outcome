package com.bytedance.android.live.revlink.impl.behavior;

import android.text.TextUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements d {
    public final LottieAnimationView a;

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void a(zr2.n r2) {
        Intrinsics.checkNotNullParameter(r2, "command");
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void h() {
        this.a.setVisibility(8);
        this.a.setImageResource(0);
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void n() {
        this.a.clearAnimation();
        this.a.setVisibility(4);
    }

    public a(LottieAnimationView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void f(py.k r3) {
        Intrinsics.checkNotNullParameter(r3, "image");
        List r4 = r3.getUrls();
        if (r4 != null) goto L5;
    L8:
        String r5 = null;
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        this.a.setVisibility(0);
        ImageUtil.loadImage(this.a, r5);
        return;
    L13:
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r5 = (String) ListProtector.get(r4, 0);
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void j(float r2) {
        this.a.setAlpha(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void s(int r3) {
        this.a.setVisibility(0);
        this.a.setImageResource(r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final b o(py.k r4, c r5) {
        Intrinsics.checkNotNullParameter(r4, "anim");
        List r6 = r4.getUrls();
        if (r6 != null) goto L5;
    L8:
        String r7 = null;
    L10:
        if (TextUtils.isEmpty(r7) == false) goto L12;
        return null;
    L12:
        this.a.setVisibility(0);
        this.a.clearAnimation();
        this.a.setImageResource(0);
        return o.a(this.a, r7, r5);
    L5:
        if (r6.isEmpty() == true) goto L8;
        r7 = (String) ListProtector.get(r6, 0);
        goto L10
    }
}
