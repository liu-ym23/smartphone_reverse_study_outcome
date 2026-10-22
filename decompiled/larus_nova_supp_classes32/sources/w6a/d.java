package w6a;

import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements LynxKeyframeAnimator.e {
    public final /* synthetic */ h.b a;
    public final /* synthetic */ e b;

    @Override // com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator.e
    public final void a(String r27) {
        this.b.l.remove(r27);
        e r1 = this.b;
        if (r1.c == null) goto L11;
        View r2 = r1.a.getView();
        if (r2 == null) goto L11;
        ViewGroup r4 = (ViewGroup) r2.getParent();
        ViewGroup.LayoutParams r5 = r2.getLayoutParams();
        if (r4 == null) goto L10;
        r4.removeView(r2);
    L10:
        int[] r6 = new int[2];
        r1.c.getLocationOnScreen(r6);
        r1.d.removeChild(r1.a);
        r1.d.insertChild(r1.a, r1.b);
        int r9 = r2.getLeft() + r6[0];
        int r10 = r2.getTop() - r6[1];
        LynxUI r3 = r1.a;
        r3.updateLayout(r9, r10, r5.width, r5.height, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r3.getBound());
    L11:
        h.b r7 = this.a;
        if (r7 == null) goto L14;
        ((f) r7).a();
    L14:
        this.b.j = false;
    }

    public d(e r1, h.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
