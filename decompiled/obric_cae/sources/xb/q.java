package xb;

import android.R;
import android.animation.Animator;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f13825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public yb.f f13826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DecelerateInterpolator f13830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f13833i;

    public class a extends xb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f13834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13835b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ q f13836m;

        public a(q r8, CharSequence r10, int r11) {
            this.f13836m = r8;
            this.f13834a = r10;
            this.f13835b = r11;
        }

        @Override // xb.a, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r8) {
            q r10 = this.f13836m;
            r10.b(r10.f13825a, 0);
            r10.f13825a.setAlpha(1.0f);
        }

        @Override // xb.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            q r10 = this.f13836m;
            r10.f13825a.setText(this.f13834a);
            int r11 = this.f13835b;
            TextView r12 = r10.f13825a;
            r10.b(r12, r11);
            ViewPropertyAnimator r13 = r12.animate();
            if (r10.f13831g != 1) goto L5;
            r13.translationX(0.0f);
        L6:
            r13.alpha(1.0f).setDuration(r10.f13828d).setInterpolator(r10.f13830f).setListener(new xb.a()).start();
            return;
        L5:
            r13.translationY(0.0f);
            goto L6
        }
    }

    public q(TextView r8) {
        this.f13826b = yb.f.f14110a;
        this.f13830f = new DecelerateInterpolator(2.0f);
        this.f13831g = 0;
        this.f13832h = 0;
        this.f13833i = null;
        this.f13825a = r8;
        Resources r10 = r8.getResources();
        this.f13827c = 400;
        this.f13828d = r10.getInteger(R.integer.config_shortAnimTime) / 2;
        this.f13829e = (int) TypedValue.applyDimension(1, 20.0f, r10.getDisplayMetrics());
    }

    public final void a(long r8, CalendarDay r10, boolean r11) {
        TextView r12 = this.f13825a;
        r12.animate().cancel();
        b(r12, 0);
        r12.setAlpha(1.0f);
        this.f13832h = r8;
        CharSequence r13 = this.f13826b.a(r10);
        if (r11 == true) goto L6;
        r12.setText(r13);
    L14:
        this.f13833i = r10;
        return;
    L6:
        if (this.f13833i.z(r10) == false) goto L8;
        int r14 = 1;
    L9:
        int r15 = this.f13829e * r14;
        ViewPropertyAnimator r16 = r12.animate();
        if (this.f13831g != 1) goto L12;
        r16.translationX(r15 * (-1));
    L13:
        r16.alpha(0.0f).setDuration(this.f13828d).setInterpolator(this.f13830f).setListener(new a(this, r13, r15)).start();
        goto L14
    L12:
        r16.translationY(r15 * (-1));
        goto L13
    L8:
        r14 = -1;
        goto L9
    }

    public final void b(TextView r8, int r10) {
        if (this.f13831g != 1) goto L5;
        r8.setTranslationX(r10);
        return;
    L5:
        r8.setTranslationY(r10);
    }

    public final void c(int r8) {
        this.f13831g = r8;
    }
}
