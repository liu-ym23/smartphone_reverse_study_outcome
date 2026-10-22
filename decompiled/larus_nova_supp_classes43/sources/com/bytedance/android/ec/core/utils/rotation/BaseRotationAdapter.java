package com.bytedance.android.ec.core.utils.rotation;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseRotationAdapter<T> extends e<T> {
    public final Lazy j;
    public final Lazy k;
    public final ViewGroup l;

    public BaseRotationAdapter(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "rootLayout");
        this.l = r10;
        LazyThreadSafetyMode r11 = LazyThreadSafetyMode.NONE;
        this.j = LazyKt.lazy(r11, new BaseRotationAdapter$itemView1$2(this));
        this.k = LazyKt.lazy(r11, new BaseRotationAdapter$itemView2$2(this));
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final View f(int r10) {
        if (r10 != 0) goto L4;
        View r11 = (View) this.j.getValue();
    L6:
        if ((!Intrinsics.areEqual(r11.getParent(), this.l)) == false) goto L14;
        ViewParent r0 = r11.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L10;
        r0 = null;
    L10:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L13;
        r1.removeView(r11);
    L13:
        ViewGroup r12 = this.l;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, -2);
        int r14 = (int) UtilityKotlinExtentionsKt.c(16);
        r13.setMarginStart(r14);
        r13.leftMargin = r14;
        r13.gravity = 8388659;
        r12.addView(r11, r13);
    L14:
        return r11;
    L4:
        r11 = (View) this.k.getValue();
        goto L6
    }
}
