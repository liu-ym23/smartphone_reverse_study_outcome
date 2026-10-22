package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class f extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f1542b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1543m;

    public View getContent() {
        return this.f1542b;
    }

    public int getEmptyVisibility() {
        return this.f1543m;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        if (isInEditMode() == false) goto L6;
        r8.drawRGB(223, 223, 223);
        Paint r10 = new Paint();
        r10.setARGB(255, 210, 210, 210);
        r10.setTextAlign(Paint.Align.CENTER);
        r10.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r11 = new Rect();
        r8.getClipBounds(r11);
        r10.setTextSize(r11.height());
        int r12 = r11.height();
        int r13 = r11.width();
        r10.setTextAlign(Paint.Align.LEFT);
        r10.getTextBounds("?", 0, 1, r11);
        r8.drawText("?", ((r13 / 2.0f) - (r11.width() / 2.0f)) - r11.left, ((r11.height() / 2.0f) + (r12 / 2.0f)) - r11.bottom, r10);
        return;
    }

    public void setContentId(int r8) {
        if (this.f1541a != r8) goto L5;
        return;
    L5:
        View r10 = this.f1542b;
        if (r10 == null) goto L8;
        r10.setVisibility(0);
        ((ConstraintLayout.a) this.f1542b.getLayoutParams()).f1368f0 = false;
        this.f1542b = null;
    L8:
        this.f1541a = r8;
        if (r8 == (-1)) goto L14;
        View r11 = ((View) getParent()).findViewById(r8);
        if (r11 == null) goto L15;
        r11.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r8) {
        this.f1543m = r8;
    }
}
