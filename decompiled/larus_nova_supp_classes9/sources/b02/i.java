package b02;

import android.animation.Animator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends o12.b {
    public final /* synthetic */ ComboProgressAnimationView a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        ComboProgressAnimationView r5 = this.a;
        boolean r0 = r5.j;
        if (r0 == true) goto L5;
    L7:
        if (r0 == true) goto L10;
        r5.f = false;
    L10:
        if (this.b == false) goto L13;
        this.a.g = false;
        return;
    L13:
        return;
    L5:
        if (this.c == false) goto L7;
        ComboProgressAnimationView.b(r5, true);
        goto L10
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationStart(r2, r3);
        ComboProgressAnimationView r4 = this.a;
        r4.f = true;
        if (this.b == false) goto L6;
        r4.g = true;
        return;
    }

    public i(ComboProgressAnimationView r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
