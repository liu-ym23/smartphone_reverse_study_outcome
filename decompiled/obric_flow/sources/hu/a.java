package hu;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import gu.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f17469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f17470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f17471c;
    public boolean d;
    public com.obric.oui.lisitem.a e;

    public a(f r5, f r10) {
        this.f17469a = r5;
        this.f17470b = r10;
        this.f17471c = ViewConfiguration.get(r5.getContext()).getScaledTouchSlop();
    }

    public final void a() {
        this.d = false;
        com.obric.oui.lisitem.a r5 = this.e;
        if (r5 == null) goto L6;
        this.f17469a.removeCallbacks(r5);
        this.e = null;
        return;
    }

    public final void b(MotionEvent r10) {
        int r5 = r10.getAction();
        f r11 = this.f17469a;
        boolean r12 = true;
        if (r5 == 0) goto L26;
        if (r5 == 1) goto L25;
        if (r5 != 2) goto L7;
        float r13 = r10.getX();
        float r14 = r10.getY();
        float r15 = this.f17471c;
        float r16 = -r15;
        if (r13 >= r16) goto L12;
    L24:
        a();
        return;
    L12:
        if (r14 < r16) goto L24;
        if (r13 >= (r11.getWidth() + r15)) goto L24;
        if (r14 >= (r11.getHeight() + r15)) goto L24;
        if (this.e != null) goto L20;
        return;
    L20:
        if (r10.getToolType(0) == 2) goto L22;
        return;
    L22:
        if (r10.isButtonPressed(2) == false) goto L40;
        c();
        return;
    L40:
        return;
    L7:
        if (r5 == 3) goto L25;
        return;
    L25:
        a();
        return;
    L26:
        a();
        this.d = false;
        if (this.e != null) goto L29;
        this.e = new com.obric.oui.lisitem.a(this, 10);
    L29:
        r11.postDelayed(this.e, (long) (ViewConfiguration.getLongPressTimeout() * 0.75f));
        if (r10.getToolType(0) == 2) goto L32;
    L34:
        r12 = false;
    L35:
        if (r12 == false) goto L44;
        c();
        return;
    L44:
        return;
    L32:
        if (r10.isButtonPressed(2) == false) goto L34;
        goto L34
    }

    public final void c() {
        f r5 = this.f17469a;
        if (r5.getParent() != null) goto L5;
        return;
    L5:
        if (r5.hasWindowFocus() == false) goto L13;
        r5.isPressed();
        f r10 = this.f17470b;
        if (this.d == true) goto L14;
        r10.onLongClick(r5);
        r5.setPressed(false);
        this.d = true;
        com.obric.oui.lisitem.a r11 = this.e;
        if (r11 == null) goto L15;
        r5.removeCallbacks(r11);
        this.e = null;
        return;
    L15:
        return;
    L14:
        return;
    }
}
