package com.bytedance.android.livesdk.interactivity.like;

import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 implements cc2.n<cc2.i> {
    public final /* synthetic */ DiggWidget a;

    public c0(DiggWidget r1) {
        this.a = r1;
    }

    @Override // cc2.n
    public final void a(cc2.i r1, Boolean r2) {
        if (Intrinsics.areEqual(r1, cc2.i.b.c) == false) goto L5;
        DiggWidget r3 = this.a;
        DiggWidget.xq(r3, r3.e);
        DiggWidget r4 = this.a;
        DiggWidget.xq(r4, r4.d);
        return;
    L5:
        MeasureOptFrameLayout r5 = this.a.d;
        if (r5 == null) goto L10;
        ViewPropertyAnimator r6 = r5.animate();
        if (r6 == null) goto L10;
        r6.cancel();
    L10:
        SimpleDraweeView r7 = this.a.e;
        if (r7 == null) goto L15;
        ViewPropertyAnimator r8 = r7.animate();
        if (r8 == null) goto L15;
        r8.cancel();
    L15:
        MeasureOptFrameLayout r9 = this.a.d;
        if (r9 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r9);
    L18:
        SimpleDraweeView r10 = this.a.e;
        if (r10 == null) goto L23;
        UtilityKotlinExtentionsKt.w(r10);
        return;
    }

    @Override // cc2.n
    public final void b(cc2.i r1, Boolean r2) {
        if (Intrinsics.areEqual(r1, cc2.i.b.c) == false) goto L5;
        DiggWidget r3 = this.a;
        DiggWidget.wq(r3, r3.e);
        DiggWidget r4 = this.a;
        DiggWidget.wq(r4, r4.d);
        return;
    L5:
        MeasureOptFrameLayout r5 = this.a.d;
        if (r5 == null) goto L10;
        ViewPropertyAnimator r6 = r5.animate();
        if (r6 == null) goto L10;
        r6.cancel();
    L10:
        SimpleDraweeView r7 = this.a.e;
        if (r7 == null) goto L15;
        ViewPropertyAnimator r8 = r7.animate();
        if (r8 == null) goto L15;
        r8.cancel();
    L15:
        MeasureOptFrameLayout r9 = this.a.d;
        if (r9 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r9);
    L18:
        SimpleDraweeView r10 = this.a.e;
        if (r10 == null) goto L23;
        UtilityKotlinExtentionsKt.t(r10);
        return;
    }
}
