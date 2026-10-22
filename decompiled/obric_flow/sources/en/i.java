package en;

import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.view.UISimpleView;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f16847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f16848c;
    public final /* synthetic */ UISimpleView d;

    public /* synthetic */ i(UISimpleView r5, float r10, float r11, int r12) {
        this.f16846a = r12;
        this.d = r5;
        this.f16847b = r10;
        this.f16848c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f16846a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        float r5 = this.f16847b;
        float r10 = this.f16848c;
        ((UIScrollView) this.d).l(r5, r10);
        return;
    L6:
        float r11 = this.f16847b;
        float r12 = this.f16848c;
        ((UIListContainer) this.d).j(r11, r12);
        return;
    L8:
        float r13 = this.f16847b;
        float r14 = this.f16848c;
        ((UIList) this.d).b(r13, r14);
    }
}
