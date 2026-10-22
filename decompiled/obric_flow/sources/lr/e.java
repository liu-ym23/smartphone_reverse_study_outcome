package lr;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f19703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f19704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f19705c;
    public final float d;
    public final int e;
    public final com.obric.oui.constraintlayout.widget.d f;

    public e(Context r10, XmlResourceParser r11) {
        this.f19703a = Float.NaN;
        this.f19704b = Float.NaN;
        this.f19705c = Float.NaN;
        this.d = Float.NaN;
        this.e = -1;
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.Variant);
        int r5 = r12.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L23;
        int r14 = r12.getIndex(r13);
        if (r14 != R$styleable.Variant_constraints) goto L10;
        int r15 = r12.getResourceId(r14, this.e);
        this.e = r15;
        String r16 = r10.getResources().getResourceTypeName(r15);
        r10.getResources().getResourceName(r15);
        if ("layout".equals(r16) == false) goto L22;
        com.obric.oui.constraintlayout.widget.d r17 = new com.obric.oui.constraintlayout.widget.d();
        this.f = r17;
        r17.e(r10, r15);
    L22:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r14 != R$styleable.Variant_region_heightLessThan) goto L13;
        this.d = r12.getDimension(r14, this.d);
        goto L22
    L13:
        if (r14 != R$styleable.Variant_region_heightMoreThan) goto L16;
        this.f19704b = r12.getDimension(r14, this.f19704b);
        goto L22
    L16:
        if (r14 != R$styleable.Variant_region_widthLessThan) goto L19;
        this.f19705c = r12.getDimension(r14, this.f19705c);
        goto L22
    L19:
        if (r14 != R$styleable.Variant_region_widthMoreThan) goto L21;
        this.f19703a = r12.getDimension(r14, this.f19703a);
        goto L22
    L21:
        Log.v("ConstraintLayoutStates", "Unknown tag");
        goto L22
    L23:
        r12.recycle();
    }

    public final boolean a(float r5, float r10) {
        float r11 = this.f19703a;
        if (Float.isNaN(r11) == false) goto L5;
    L7:
        float r12 = this.f19704b;
        if (Float.isNaN(r12) == false) goto L10;
    L12:
        float r13 = this.f19705c;
        if (Float.isNaN(r13) == false) goto L15;
    L17:
        float r14 = this.d;
        if (Float.isNaN(r14) == false) goto L20;
        return true;
    L20:
        if (r10 <= r14) goto L24;
        return false;
    L24:
        return true;
    L15:
        if (r5 <= r13) goto L17;
        return false;
    L10:
        if (r10 >= r12) goto L12;
        return false;
    L5:
        if (r5 >= r11) goto L7;
        return false;
    }
}
