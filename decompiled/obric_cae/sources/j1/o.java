package j1;

import com.obric.cae.userAware.ui.HARStatusActivity;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f8520b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f8521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f8522n;

    public /* synthetic */ o(Object r8, Object r10, boolean r11, int r12) {
        this.f8519a = r12;
        this.f8521m = r8;
        this.f8522n = r10;
        this.f8520b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f8519a;
        boolean r10 = this.f8520b;
        Object r11 = this.f8522n;
        Object r12 = this.f8521m;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        ((p) r12).f((r1.l) r11, r10);
        return;
    L7:
        HARStatusActivity.s((HARStatusActivity) r12, (Set) r11, r10);
    }
}
