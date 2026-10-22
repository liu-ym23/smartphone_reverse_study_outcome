package q9;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Dialog f10198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10199b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f10200m;

    public a(Dialog r8, Rect r10) {
        this.f10198a = r8;
        this.f10199b = r10.left;
        this.f10200m = r10.top;
        ViewConfiguration.get(r8.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r8, MotionEvent r10) {
        View r11 = r8.findViewById(R.id.content);
        int r12 = r11.getLeft() + this.f10199b;
        int r13 = r11.getWidth() + r12;
        int r14 = r11.getTop() + this.f10200m;
        if (new RectF(r12, r14, r13, r11.getHeight() + r14).contains(r10.getX(), r10.getY()) == false) goto L6;
        return false;
    L6:
        MotionEvent r15 = MotionEvent.obtain(r10);
        if (r10.getAction() != 1) goto L9;
        r15.setAction(4);
    L9:
        r8.performClick();
        return this.f10198a.onTouchEvent(r15);
    }
}
