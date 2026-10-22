package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f534c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object r5, View r10, Object r11, int r12) {
        this.f532a = r12;
        this.f533b = r5;
        this.f534c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f532a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        View r5 = (View) this.f534c;
        Rect r10 = (Rect) this.d;
        DefaultSpecialEffectsController.i((FragmentTransitionImpl) this.f533b, r5, r10);
        return;
    L6:
        SpecialEffectsController.Operation r11 = (SpecialEffectsController.Operation) this.d;
        DefaultSpecialEffectsController r12 = (DefaultSpecialEffectsController) this.f533b;
        DefaultSpecialEffectsController.c((List) this.f534c, r11, r12);
        return;
    L8:
        View r13 = (View) this.f534c;
        DefaultSpecialEffectsController.AnimationInfo r14 = (DefaultSpecialEffectsController.AnimationInfo) this.d;
        DefaultSpecialEffectsController.AnonymousClass3.a((DefaultSpecialEffectsController) this.f533b, r13, r14);
    }

    public /* synthetic */ e(List r5, SpecialEffectsController.Operation r10, DefaultSpecialEffectsController r11) {
        this.f532a = 1;
        this.f534c = r5;
        this.d = r10;
        this.f533b = r11;
    }
}
