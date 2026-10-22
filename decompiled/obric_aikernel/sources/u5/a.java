package u5;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Dialog f13133c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f13134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f13135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f13136i;

    public a(@NonNull Dialog r10, @NonNull Rect r11) {
        this.f13133c = r10;
        this.f13134g = r11.left;
        this.f13135h = r11.top;
        this.f13136i = ViewConfiguration.get(r10.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View r10, @NonNull MotionEvent r11) {
        View r12 = r10.findViewById(R.id.content);
        int r13 = this.f13134g + r12.getLeft();
        int r14 = r12.getWidth() + r13;
        int r15 = this.f13135h + r12.getTop();
        if (new RectF(r13, r15, r14, r12.getHeight() + r15).contains(r11.getX(), r11.getY()) == false) goto L5;
        return false;
    L5:
        MotionEvent r16 = MotionEvent.obtain(r11);
        if (r11.getAction() != 1) goto L9;
        r16.setAction(4);
    L9:
        if (Build.VERSION.SDK_INT >= 28) goto L11;
        r16.setAction(0);
        int r17 = this.f13136i;
        r16.setLocation((-r17) - 1, (-r17) - 1);
    L11:
        r10.performClick();
        return this.f13133c.onTouchEvent(r16);
    }
}
