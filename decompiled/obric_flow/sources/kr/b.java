package kr;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.obric.oui.constraintlayout.utils.widget.ImageFilterView;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageFilterView f19466b;

    public /* synthetic */ b(ImageFilterView r5, int r10) {
        this.f19465a = r10;
        this.f19466b = r5;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r10, Outline r11) {
        switch(this.f19465a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ImageFilterView r12 = this.f19466b;
        r11.setRoundRect(0, 0, r12.getWidth(), r12.getHeight(), r12.g);
        return;
    L6:
        ImageFilterView r13 = this.f19466b;
        int r5 = r13.getWidth();
        int r14 = r13.getHeight();
        r11.setRoundRect(0, 0, r5, r14, (Math.min(r5, r14) * r13.f) / 2.0f);
    }
}
