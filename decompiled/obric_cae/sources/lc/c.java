package lc;

import android.view.View;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.swipeaction.OSwipeLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements OSwipeLayout.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCardListItem f9211a;

    public c(OCardListItem r8) {
        this.f9211a = r8;
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.k
    public final void a() {
        this.f9211a.setContentChecked(false);
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.k
    public final void b(int r8) {
        OCardListItem r10 = this.f9211a;
        r10.H = r8;
        View r11 = r10.B;
        if (r11.getVisibility() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        return;
    L8:
        if (r10.I == false) goto L10;
        float r13 = r8;
    L11:
        r11.setTranslationX(r13);
        return;
    L10:
        r13 = 0.0f;
        goto L11
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.k
    public final void c() {
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.k
    public final void d() {
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.k
    public final void e() {
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.k
    public final void f() {
        this.f9211a.setContentChecked(true);
    }
}
