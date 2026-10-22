package ce8;

import android.view.ViewTreeObserver;
import com.larus.bmhome.chat.component.util.PaneAwareFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ PaneAwareFrameLayout a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        PaneAwareFrameLayout r0 = this.a;
        int r1 = PaneAwareFrameLayout.j;
        r0.c();
        this.a.a();
        return true;
    }

    public n(PaneAwareFrameLayout r1) {
        this.a = r1;
    }
}
