package bq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.obric.oui.common.style.g;
import java.util.Iterator;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f970b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f969a = r10;
        this.f970b = r5;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r5) {
        switch(this.f969a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.onAnimationCancel(r5);
        return;
    L6:
        ((g) this.f970b).a();
        return;
    L8:
        ((b) this.f970b).a();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        switch(this.f969a) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        Iterator r10 = ((CircularProgressView) this.f970b).f8504p.iterator();
        if (r10.hasNext() == true) goto L8;
        return;
    L8:
        throw h.c(r10);
    L9:
        ((g) this.f970b).a();
        return;
    L11:
        ((b) this.f970b).a();
    }
}
