package f7a;

import android.view.Choreographer;
import com.lynx.tasm.behavior.ui.list.container.ListContainerView;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Choreographer.FrameCallback {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r4) {
        c r5 = this.a;
        boolean r6 = r5.a(r5.b);
        if (r6 == false) goto L8;
        c r0 = this.a;
        int r1 = r0.b;
        UIListContainer r2 = ((UIListContainer.f) r0).f;
        if (r2.a == false) goto L7;
        ((ListContainerView) r2.getView()).scrollBy(0, r1);
        goto L8
    L7:
        ((ListContainerView) r2.getView()).scrollBy(r1, 0);
    L8:
        c r3 = this.a;
        boolean r7 = r3.a;
        if (r7 == false) goto L16;
        if (r6 == true) goto L14;
        if (r3.c == true) goto L16;
    L14:
        if (r3.d == null) goto L21;
        Choreographer.getInstance().postFrameCallback(this.a.d);
        return;
    L21:
        return;
    L16:
        if (r7 == false) goto L18;
        if (r6 == false) goto L18;
    L19:
        this.a.b();
        return;
    L18:
        UIListContainer.f r8 = (UIListContainer.f) r3;
        ((ListContainerView) UIListContainer.N(r8.f)).w = false;
        ((ListContainerView) UIListContainer.O(r8.f)).setScrollState(1);
        goto L19
    }
}
