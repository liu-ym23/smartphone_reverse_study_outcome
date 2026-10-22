package vc;

import android.view.View;
import com.obric.oui.titlebar.OUnitedTitleBar;
import k0.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f12834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f12835b;

    public c(OUnitedTitleBar r8, boolean r10) {
        this.f12834a = r8;
        this.f12835b = r10;
    }

    @Override // k0.j
    public final boolean a(View r8) {
        this.f12834a.setExpanded(this.f12835b);
        return true;
    }
}
