package bq;

import android.animation.ObjectAnimator;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.obric.oui.common.style.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f973c;
    public boolean d;
    public int e;
    public float f;
    public GradientDrawable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ObjectAnimator f974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ObjectAnimator f975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f976j;

    public final void a() {
        View r5 = (View) this.f971a.get();
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.f972b == false) goto L11;
        if (r5.isPressed() == false) goto L11;
        r5.setForeground(this.g);
        return;
    L11:
        if (this.d == true) goto L13;
    L15:
        r5.setForeground(null);
        return;
    L13:
        if (r5.isSelected() == false) goto L15;
        r5.setForeground(this.g);
    }

    public final void b(View r5, boolean r10) {
        View r11 = (View) this.f971a.get();
        if (r11 != null) goto L5;
        return;
    L5:
        float r12 = 1.0f;
        if (this.f973c == false) goto L10;
        if (r10 == true) goto L10;
        r12 = this.f;
    L10:
        if (r5 != r11) goto L12;
    L14:
        r11.setAlpha(r12);
        return;
    L12:
        if (r11.isEnabled() == r10) goto L14;
        r11.setEnabled(r10);
        goto L14
    }

    @Override // com.obric.oui.common.style.a
    public final void h(View r5, boolean r10) {
        if (this.d == false) goto L6;
        a();
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void i(String r5) {
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenDisable(boolean r5) {
        this.f973c = r5;
        View r10 = (View) this.f971a.get();
        if (r10 == null) goto L6;
        b(r10, r10.isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenPress(boolean r5) {
        this.f972b = r5;
        View r10 = (View) this.f971a.get();
    }

    @Override // com.obric.oui.common.style.a
    public final void setKeepPressAlpha(boolean r5) {
    }
}
