package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f544c;

    public /* synthetic */ j(Object r5, SpecialEffectsController.Operation r10, int r11) {
        this.f542a = r11;
        this.f543b = r5;
        this.f544c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f542a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        DefaultSpecialEffectsController.h((DefaultSpecialEffectsController.TransitionInfo) this.f543b, this.f544c);
        return;
    L6:
        SpecialEffectsController.FragmentStateManagerOperation r5 = (SpecialEffectsController.FragmentStateManagerOperation) this.f544c;
        SpecialEffectsController.b((SpecialEffectsController) this.f543b, r5);
        return;
    L8:
        SpecialEffectsController.FragmentStateManagerOperation r10 = (SpecialEffectsController.FragmentStateManagerOperation) this.f544c;
        SpecialEffectsController.a((SpecialEffectsController) this.f543b, r10);
    }
}
