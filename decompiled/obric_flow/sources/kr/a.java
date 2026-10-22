package kr;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.obric.oui.constraintlayout.utils.widget.ImageFilterButton;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageFilterButton f19464b;

    public /* synthetic */ a(ImageFilterButton r5, int r10) {
        this.f19463a = r10;
        this.f19464b = r5;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r10, Outline r11) {
        switch(this.f19463a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ImageFilterButton r12 = this.f19464b;
        r11.setRoundRect(0, 0, r12.getWidth(), r12.getHeight(), r12.d);
        return;
    L6:
        ImageFilterButton r13 = this.f19464b;
        int r5 = r13.getWidth();
        int r14 = r13.getHeight();
        r11.setRoundRect(0, 0, r5, r14, (Math.min(r5, r14) * r13.f12920c) / 2.0f);
    }
}
