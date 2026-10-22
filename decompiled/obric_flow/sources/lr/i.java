package lr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19761c;
    public float d;
    public float e;

    public final void a(Context r5, AttributeSet r10) {
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.PropertySet);
        this.f19759a = true;
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L17;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.PropertySet_android_alpha) goto L8;
        this.d = r11.getFloat(r14, this.d);
    L16:
        r13 = r13 + 1;
        goto L3
    L8:
        if (r14 != R$styleable.PropertySet_android_visibility) goto L11;
        int r15 = r11.getInt(r14, this.f19760b);
        this.f19760b = r15;
        this.f19760b = com.obric.oui.constraintlayout.widget.d.f13066h[r15];
        goto L16
    L11:
        if (r14 != R$styleable.PropertySet_visibilityMode) goto L14;
        this.f19761c = r11.getInt(r14, this.f19761c);
        goto L16
    L14:
        if (r14 != R$styleable.PropertySet_motionProgress) goto L16;
        this.e = r11.getFloat(r14, this.e);
        goto L16
    L17:
        r11.recycle();
    }
}
