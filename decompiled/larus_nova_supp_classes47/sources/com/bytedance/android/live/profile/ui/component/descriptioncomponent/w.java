package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w extends AnimatorListenerAdapter {
    public final /* synthetic */ ProfileGiftExhibitionComponent a;
    public final /* synthetic */ py.k b;
    public final /* synthetic */ List c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        super.onAnimationEnd(r5);
        if (this.a.o == false) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
        return;
    L8:
        Iterator r6 = this.c.iterator();
    L10:
        if (r6.hasNext() == false) goto L15;
        HSImageView r0 = (HSImageView) r6.next();
        if (r0 == null) goto L10;
        a1.p(r0, UtilityKotlinExtentionsKt.i(this.b.getWidth()));
        a1.k(r0, UtilityKotlinExtentionsKt.i(this.b.getHeight()));
        ImageLoader.bindImageWithAnimation(r0, this.b, null, true);
        goto L10
    }

    public w(ProfileGiftExhibitionComponent r1, py.k r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
