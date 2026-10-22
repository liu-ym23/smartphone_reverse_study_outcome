package l6a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ SmartRefreshLayout d;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            SmartRefreshLayout r0 = this.a.d;
            if (r0.I2 == null) goto L6;
            r0.T1.b(((Integer) r3.getAnimatedValue()).intValue(), true);
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            SmartRefreshLayout r4 = this.a.d;
            if (r4.I2 == null) goto L9;
            r4.I2 = null;
            RefreshState r0 = r4.V1;
            RefreshState r1 = RefreshState.ReleaseToRefresh;
            if (r0 == r1) goto L7;
            r4.T1.d(r1);
        L7:
            c r5 = this.a;
            r5.d.setStateRefreshing(!r5.c);
            return;
        }
    }

    public final void a() {
        SmartRefreshLayout r0 = this.d;
        if (r0.b2 == RefreshState.Refreshing) goto L5;
        return;
    L5:
        ValueAnimator r1 = r0.I2;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        SmartRefreshLayout r2 = this.d;
        r2.j = r2.getMeasuredWidth() / 2.0f;
        this.d.T1.d(RefreshState.PullDownToRefresh);
        SmartRefreshLayout r3 = this.d;
        r3.I2 = ValueAnimator.ofInt(new int[]{r3.b, (int) (r3.b1 * this.a)});
        this.d.I2.setDuration(this.b);
        this.d.I2.setInterpolator(new r6a.b(0));
        this.d.I2.addUpdateListener(new a(this));
        this.d.I2.addListener(new b(this));
        this.d.I2.start();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(SmartRefreshLayout r1) {
        this.d = r1;
        this.a = 1.0f;
        this.b = 300;
        this.c = false;
    }
}
