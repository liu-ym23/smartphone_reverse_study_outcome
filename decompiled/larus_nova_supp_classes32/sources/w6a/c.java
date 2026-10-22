package w6a;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements LynxKeyframeAnimator.e {
    public final /* synthetic */ h.c a;
    public final /* synthetic */ e b;

    @Override // com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator.e
    public final void a(String r2) {
        this.b.l.remove(r2);
        View r3 = this.b.a.getView();
        if (r3 != null) goto L5;
        return;
    L5:
        ViewParent r0 = r3.getParent();
        if (r0 == null) goto L8;
        ((ViewGroup) r0).removeView(r3);
    L8:
        h.c r4 = this.a;
        if (r4 == null) goto L11;
        r4.a();
    L11:
        this.b.k = false;
    }

    public c(e r1, h.c r2) {
        this.b = r1;
        this.a = r2;
    }
}
