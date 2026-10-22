package hc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f8042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f8043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f8044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f8046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8047f;

    public static final class a extends FrameLayout {
        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r8, int r10) {
            super.onMeasure(r8, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r8) / 2, 1073741824));
        }
    }

    public e(Context r8) {
        i.f(r8, "context");
        this.f8046e = r8;
        this.f8047f = 0;
    }

    @Override // hc.f
    public final void b(fc.a r8) {
        i.f(r8, "dialog");
    }

    @Override // hc.f
    public final void c(Context r8, d r10) {
        i.f(r10, "dialogContainer");
        int r11 = this.f8047f;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        FrameLayout r12 = r10.a();
    L9:
        r12.setVisibility(0);
        Context r13 = this.f8046e;
        int r14 = -2;
        if (r11 != 0) goto L22;
        Integer r15 = this.f8044c;
        if (r15 == null) goto L14;
        int r16 = r15.intValue();
    L15:
        Integer r17 = this.f8043b;
        if (r17 == null) goto L18;
        r14 = r17.intValue();
    L18:
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(r16, r14);
        r18.gravity = 1;
        r18.topMargin = android.aimedia.a.a("Resources.getSystem()", 1, 4);
        r18.bottomMargin = android.aimedia.a.a("Resources.getSystem()", 1, 16);
        ImageView r19 = new ImageView(r13);
        r19.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r20 = this.f8042a;
        if (r20 == null) goto L21;
        r19.setImageDrawable(r20);
    L21:
        r12.addView(r19, r18);
        return;
    L14:
        r16 = -2;
        goto L15
    L22:
        Integer r21 = this.f8044c;
        if (r21 == null) goto L25;
        int r22 = r21.intValue();
    L26:
        Integer r23 = this.f8043b;
        if (r23 == null) goto L29;
        r14 = r23.intValue();
    L29:
        FrameLayout.LayoutParams r24 = new FrameLayout.LayoutParams(r22, r14);
        if (this.f8045d == false) goto L32;
        FrameLayout r25 = new FrameLayout(r8);
    L33:
        ImageView r26 = new ImageView(r13);
        r26.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r27 = this.f8042a;
        if (r27 == null) goto L36;
        r26.setImageDrawable(r27);
    L36:
        r25.addView(r26, new FrameLayout.LayoutParams(-1, -1));
        r12.addView(r25, r24);
        return;
    L32:
        r25 = new a(r8);
        goto L33
    L25:
        r22 = -1;
        goto L26
    L7:
        throw new IllegalArgumentException(defpackage.a.d("Unsupported style: ", r11));
    L8:
        r12 = r10.b();
        goto L9
    }
}
