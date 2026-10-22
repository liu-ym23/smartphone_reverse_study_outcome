package j22;

import android.text.TextUtils;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends BaseAnimationListener {
    public final /* synthetic */ c.b a;

    public d(c.b r1) {
        this.a = r1;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
        super.onAnimationFrame(r1, r2);
        if (r2 != (r1.getFrameCount() - 1)) goto L11;
        c r3 = this.a.b;
        if (r3.d == false) goto L7;
        r3.a.setController(null);
        this.a.b.a.setVisibility(4);
    L7:
        c.b r4 = this.a;
        if (TextUtils.equals(r4.a, r4.b.c) == true) goto L12;
        c r5 = this.a.b;
        r5.a(r5.c);
        return;
    L12:
        return;
    }
}
