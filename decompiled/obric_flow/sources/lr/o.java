package lr;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f19777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f19778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f19779c;
    public final float d;
    public final int e;

    public o(Context r10, XmlResourceParser r11) {
        this.f19777a = Float.NaN;
        this.f19778b = Float.NaN;
        this.f19779c = Float.NaN;
        this.d = Float.NaN;
        this.e = -1;
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.Variant);
        int r5 = r12.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L21;
        int r14 = r12.getIndex(r13);
        if (r14 != R$styleable.Variant_constraints) goto L8;
        int r15 = r12.getResourceId(r14, this.e);
        this.e = r15;
        String r16 = r10.getResources().getResourceTypeName(r15);
        r10.getResources().getResourceName(r15);
        "layout".equals(r16);
    L20:
        r13 = r13 + 1;
        goto L3
    L8:
        if (r14 != R$styleable.Variant_region_heightLessThan) goto L11;
        this.d = r12.getDimension(r14, this.d);
        goto L20
    L11:
        if (r14 != R$styleable.Variant_region_heightMoreThan) goto L14;
        this.f19778b = r12.getDimension(r14, this.f19778b);
        goto L20
    L14:
        if (r14 != R$styleable.Variant_region_widthLessThan) goto L17;
        this.f19779c = r12.getDimension(r14, this.f19779c);
        goto L20
    L17:
        if (r14 != R$styleable.Variant_region_widthMoreThan) goto L19;
        this.f19777a = r12.getDimension(r14, this.f19777a);
        goto L20
    L19:
        Log.v("ConstraintLayoutStates", "Unknown tag");
        goto L20
    L21:
        r12.recycle();
    }

    public final boolean a(float r5, float r10) {
        float r11 = this.f19777a;
        if (Float.isNaN(r11) == false) goto L5;
    L7:
        float r12 = this.f19778b;
        if (Float.isNaN(r12) == false) goto L10;
    L12:
        float r13 = this.f19779c;
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
