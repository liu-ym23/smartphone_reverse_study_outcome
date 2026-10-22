package lc;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.obric.oui.lisitem.OCardListItem;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f9213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f9217e;

    public e(FrameLayout r8, boolean r10, int r11, int r12) {
        this.f9217e = r8;
        this.f9213a = new GradientDrawable();
        this.f9214b = true;
        this.f9216d = -1;
        this.f9215c = r11;
        a(r12, r10);
    }

    public final void a(int r14, boolean r15) {
        if (this.f9214b == r15) goto L5;
    L7:
        this.f9214b = r15;
        this.f9216d = r14;
        int r8 = 0;
        FrameLayout r10 = this.f9217e;
        if (r15 == false) goto L20;
        float r16 = android.aimedia.a.a("Resources.getSystem()", 1, 20);
        int r11 = this.f9215c;
        GradientDrawable r12 = this.f9213a;
        r12.setColor(r11);
        int r13 = this.f9216d;
        int r17 = OCardListItem.L;
        if (r13 != 0) goto L13;
        r12.setCornerRadii(new float[]{r16, r16, r16, r16, r16, r16, r16, r16});
    L19:
        r10.setBackground(r12);
    L22:
        if (this.f9214b == false) goto L24;
        int r18 = android.aimedia.a.a("Resources.getSystem()", 1, 8);
    L25:
        int r19 = this.f9216d;
        int r20 = OCardListItem.L;
        if (r19 == 0) goto L28;
        if (r19 == 1) goto L35;
        if (r19 != 2) goto L41;
        float r110 = 2;
        int r111 = android.aimedia.a.a("Resources.getSystem()", 1, r110);
        Resources r21 = Resources.getSystem();
        i.e(r21, "Resources.getSystem()");
        r10.setPadding(r18, r111, r18, l6.a.I0(TypedValue.applyDimension(1, r110, r21.getDisplayMetrics())));
    L47:
        r10.requestLayout();
        return;
    L41:
        if (r19 != 3) goto L47;
        float r112 = 2;
        r8 = android.aimedia.a.a("Resources.getSystem()", 1, r112);
        if (this.f9214b == false) goto L45;
    L44:
        float r113 = 8;
    L38:
        Resources r114 = Resources.getSystem();
        i.e(r114, "Resources.getSystem()");
        float r115 = TypedValue.applyDimension(1, r113, r114.getDisplayMetrics());
    L46:
        r10.setPadding(r18, r8, r18, l6.a.I0(r115));
        goto L47
    L45:
        Resources r116 = Resources.getSystem();
        i.e(r116, "Resources.getSystem()");
        r115 = TypedValue.applyDimension(1, r112, r116.getDisplayMetrics());
        goto L46
    L35:
        if (this.f9214b == false) goto L37;
        r8 = android.aimedia.a.a("Resources.getSystem()", 1, 8);
    L37:
        r113 = 2;
        goto L38
    L28:
        if (this.f9214b == false) goto L31;
        r8 = android.aimedia.a.a("Resources.getSystem()", 1, 8);
    L31:
        if (this.f9214b == false) goto L37;
    L24:
        r18 = 0;
        goto L25
    L13:
        if (r13 != 1) goto L15;
        r12.setCornerRadii(new float[]{r16, r16, r16, r16, 0.0f, 0.0f, 0.0f, 0.0f});
        goto L19
    L15:
        if (r13 != 2) goto L17;
        r12.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        goto L19
    L17:
        if (r13 != 3) goto L19;
        r12.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r16, r16, r16, r16});
        goto L19
    L20:
        r10.setBackground(null);
        goto L22
    L5:
        if (this.f9216d != r14) goto L7;
    }
}
