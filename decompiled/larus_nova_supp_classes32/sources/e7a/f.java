package e7a;

import android.view.View;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.list.container.ListContainerView;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public final a a;
    public boolean b;
    public boolean c;
    public final double d;
    public final int e;
    public final int f;
    public final double g;

    public interface a {
    }

    public static class b {
        public final int a;
        public final int b;
        public final int c;

        public b(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int b() {
        if (this.b == false) goto L5;
        int r0 = ((ListContainerView) ((UIListContainer.d) this.a).a.getView()).getLinearLayout().getHeight();
        int r1 = ((ListContainerView) ((UIListContainer.d) this.a).a.getView()).getHeight();
    L7:
        return Math.max(0, r0 - r1);
    L5:
        r0 = ((ListContainerView) ((UIListContainer.d) this.a).a.getView()).getLinearLayout().getWidth();
        r1 = ((ListContainerView) ((UIListContainer.d) this.a).a.getView()).getWidth();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(View r7) {
        if ((r7 instanceof com.lynx.tasm.behavior.ui.view.a) == false) goto L13;
        com.lynx.tasm.behavior.ui.view.a r8 = (com.lynx.tasm.behavior.ui.view.a) r7;
        if ((r8.getDrawChildHook() instanceof LynxBaseUI) == false) goto L13;
        LynxBaseUI r9 = (LynxBaseUI) r8.getDrawChildHook();
        if (this.b == false) goto L9;
        double r0 = ((double) r9.getTop()) - (((double) (((ListContainerView) ((UIListContainer.d) this.a).a.getView()).getHeight() - r9.getHeight())) * this.d);
        int r10 = this.e;
    L11:
        return (int) (r0 + ((double) r10));
    L9:
        r0 = ((double) r9.getLeft()) - (((double) (((ListContainerView) ((UIListContainer.d) this.a).a.getView()).getWidth() - r9.getWidth())) * this.d);
        r10 = this.e;
    L13:
        throw new RuntimeException("A list-item is not an AndroidView, some thing went wrong");
    }

    public f(double r5, int r7, double r8, int r10, UIListContainer.d r11) {
        this.a = null;
        this.b = true;
        this.c = false;
        this.d = -1.0d;
        this.e = 0;
        this.f = 1;
        this.g = 0.0d;
        this.d = r5;
        this.e = r7;
        this.g = r8;
        this.f = Math.max(1, r10);
        this.a = r11;
    }
}
