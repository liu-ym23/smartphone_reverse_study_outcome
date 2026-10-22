package h3;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f17279a;

    public f(float r5) {
        this.f17279a = r5;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r10, Outline r11) {
        if (r10 == null) goto L8;
        if (r11 != null) goto L6;
        return;
    L6:
        int r5 = r10.getWidth();
        int r12 = r10.getHeight();
        float r13 = this.f17279a;
        r11.setRoundRect(0, 0, r5, r12 + ((int) r13), r13);
        return;
    }
}
