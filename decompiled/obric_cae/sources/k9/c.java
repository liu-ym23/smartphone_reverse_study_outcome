package k9;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import k0.j;

/* JADX INFO: loaded from: classes.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f8978b;

    public c(BottomSheetBehavior r8, int r10) {
        this.f8978b = r8;
        this.f8977a = r10;
    }

    @Override // k0.j
    public final boolean a(View r8) {
        this.f8978b.K(this.f8977a);
        return true;
    }
}
