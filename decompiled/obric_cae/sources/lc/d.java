package lc;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.obric.oui.lisitem.OCardListItem;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCardListItem f9212a;

    public d(OCardListItem r8) {
        this.f9212a = r8;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r10) {
        i.f(r8, "view");
        i.f(r10, "outline");
        int r11 = r8.getWidth();
        int r12 = r8.getHeight();
        if (this.f9212a.K != 0) goto L5;
        int r13 = 8;
    L6:
        r10.setRoundRect(0, 0, r11, r12, android.aimedia.a.a("Resources.getSystem()", 1, r13));
        return;
    L5:
        r13 = 10;
        goto L6
    }
}
