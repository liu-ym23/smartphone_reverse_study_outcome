package ut8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i extends View {
    public PopupWindow a;
    public Paint b;
    public Paint c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final int g;
    public a h;
    public b i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public final int n;

    public interface a {
        void a(boolean r1, boolean r2, int r3, int r4);

        void b(i r1, MotionEvent r2);
    }

    public interface b {
    }

    public i(Context r4) {
        super(r4);
        this.d = false;
        Resources r1 = getContext().getResources();
        this.g = (int) ((8.0f * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density) + 0.5f);
        this.m = false;
        Resources r0 = getContext().getResources();
        this.n = (int) ((12.0f * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
        int r5 = ContextCompat.getColor(r4, 2131103317);
        Paint r2 = new Paint(1);
        this.b = r2;
        r2.setColor(r5);
        Paint r3 = new Paint(1);
        this.c = r3;
        r3.setColor(r5);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        if (this.m == false) goto L5;
        return;
    L5:
        int r0 = this.n;
        int r1 = this.g;
        r10.drawCircle(r0 + r1, r0 + r1, r1, this.b);
        if (this.e == false) goto L8;
        int r2 = this.n;
        int r3 = this.g;
        r10.drawRect(r2 + r3, r2, (r3 * 2) + r2, r2 + r3, this.c);
        return;
    L8:
        int r4 = this.n;
        int r5 = this.g;
        r10.drawRect(r4, r4, r4 + r5, r4 + r5, this.c);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        if (this.h != null) goto L5;
        return true;
    L5:
        int r0 = ((int) r6.getRawX()) + this.k;
        int r2 = ((int) r6.getRawY()) - this.l;
        int r3 = r6.getAction();
        if (r3 == 0) goto L14;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L10;
        this.h.a(this.f, true, r0, r2);
    L19:
        return true;
    L10:
        if (r3 != 3) goto L19;
    L13:
        this.d = false;
        boolean r4 = this.f;
        this.e = r4;
        this.h.a(r4, false, r0, r2);
        goto L19
    L14:
        this.d = true;
        if (this.e == false) goto L17;
        this.k = (getWidth() - ((int) r6.getX())) - this.n;
    L18:
        this.l = (((int) r6.getY()) - this.n) + (this.j / 2);
        goto L19
    L17:
        this.k = this.n - ((int) r6.getX());
        goto L18
    }

    public void setChangeListener(b r1) {
        this.i = r1;
    }

    public void setIsStartCursor(boolean r1) {
        this.e = r1;
        this.f = r1;
    }

    public void setOutArea(boolean r1) {
        this.m = r1;
    }

    public void setTouchMoveListener(a r1) {
        this.h = r1;
    }
}
