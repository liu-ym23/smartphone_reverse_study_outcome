package vc;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.oui.titlebar.OUnitedTitleBar;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import k0.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f12830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f12831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BaseBehavior f12833d;

    public b(BaseBehavior r8, CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13) {
        this.f12833d = r8;
        this.f12830a = r10;
        this.f12831b = r11;
        this.f12832c = r13;
    }

    @Override // k0.j
    public final boolean a(View r8) {
        BaseBehavior r10 = this.f12833d;
        CoordinatorLayout r11 = this.f12830a;
        OUnitedTitleBar r12 = this.f12831b;
        int r13 = this.f12832c;
        r10.N(r11, r12, r13, new int[]{0, 0});
        return true;
    }
}
