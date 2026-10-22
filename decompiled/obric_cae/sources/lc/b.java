package lc;

import android.view.View;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCardListItem f9210a;

    public b(OCardListItem r8) {
        this.f9210a = r8;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r8, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        OCardListItem r18 = this.f9210a;
        if (r18.B.getVisibility() != 0) goto L5;
        boolean r19 = true;
    L6:
        if (r19 == false) goto L9;
        r18.f();
        return;
    L9:
        return;
    L5:
        r19 = false;
        goto L6
    }
}
