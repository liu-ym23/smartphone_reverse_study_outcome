package p9;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f12358c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f12359g;

    public a(float r10, float r11) {
        this.f12358c = r10;
        this.f12359g = r11;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        int r12 = r11.getAction();
        if (r12 != 0) goto L5;
        float r13 = this.f12358c;
    L11:
        r10.setAlpha(r13);
        return false;
    L5:
        if (r12 != 1) goto L7;
    L9:
        r13 = this.f12359g;
        goto L11
    L7:
        if (r12 == 3) goto L9;
        return false;
    }
}
