package b02;

import android.animation.Animator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends o12.b {
    public final /* synthetic */ ComboProgressAnimationView a;

    public h(ComboProgressAnimationView r1) {
        this.a = r1;
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ComboProgressAnimationView r4 = this.a;
        int r0 = ComboProgressAnimationView.x;
        r4.n();
        this.a.m(1800);
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ConstraintLayout r3 = this.a.a(2131367255);
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }
}
