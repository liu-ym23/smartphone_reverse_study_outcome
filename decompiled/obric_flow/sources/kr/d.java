package kr;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.obric.oui.constraintlayout.utils.widget.MotionButton;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MotionButton f19471b;

    public /* synthetic */ d(MotionButton r5, int r10) {
        this.f19470a = r10;
        this.f19471b = r5;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r10, Outline r11) {
        switch(this.f19470a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        MotionButton r12 = this.f19471b;
        r11.setRoundRect(0, 0, r12.getWidth(), r12.getHeight(), r12.f12950b);
        return;
    L6:
        MotionButton r13 = this.f19471b;
        int r5 = r13.getWidth();
        int r14 = r13.getHeight();
        r11.setRoundRect(0, 0, r5, r14, (Math.min(r5, r14) * r13.f12949a) / 2.0f);
    }
}
