package com.obric.oui.lisitem;

import android.view.View;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.i;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCardListItem f13600a;

    public b(OCardListItem r5) {
        this.f13600a = r5;
    }

    @Override // com.obric.oui.swipeaction.i
    public final void a(OSwipeLayout r5, int r10) {
        OCardListItem r11 = this.f13600a;
        r11.A = r10;
        View r12 = r11.f13556u;
        if (r12.getVisibility() == 0) goto L5;
        return;
    L5:
        if (r11.B == false) goto L7;
        float r13 = r10;
    L8:
        r12.setTranslationX(r13);
        return;
    L7:
        r13 = 0.0f;
        goto L8
    }

    @Override // com.obric.oui.swipeaction.i
    public final void b(OSwipeLayout r5) {
    }

    @Override // com.obric.oui.swipeaction.i
    public final void c() {
    }

    @Override // com.obric.oui.swipeaction.i
    public final void d() {
        this.f13600a.setContentChecked(true);
    }

    @Override // com.obric.oui.swipeaction.i
    public final void onClose() {
        this.f13600a.setContentChecked(false);
    }
}
