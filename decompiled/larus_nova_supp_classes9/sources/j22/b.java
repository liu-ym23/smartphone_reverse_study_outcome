package j22;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends BaseAnimationListener {
    public final /* synthetic */ Animatable a;
    public final /* synthetic */ c.a b;

    public b(c.a r1, Animatable r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        super.onAnimationFrame(r2, r3);
        if (r3 != (r2.getFrameCount() - 1)) goto L18;
        c r4 = this.b.b;
        if (r4.d == true) goto L7;
    L9:
        c r5 = this.b.b;
        if (r5.d == true) goto L12;
    L14:
        c.a r6 = this.b;
        if (r6.a.equals(r6.b.b) == true) goto L19;
        c r7 = this.b.b;
        r7.b(r7.b);
        return;
    L19:
        return;
    L12:
        if (r5.e == false) goto L14;
        this.a.stop();
        this.a.jumpToFrame(1);
        goto L14
    L7:
        if (r4.e == true) goto L9;
        r4.a.setController(null);
        this.b.b.a.setVisibility(4);
        goto L9
    }
}
