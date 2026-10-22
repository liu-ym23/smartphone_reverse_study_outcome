package lr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final SparseIntArray f19762o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f19764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f19765c;
    public float d;
    public float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f19766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f19768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f19769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f19770l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19771m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f19772n;

    static {
        SparseIntArray r5 = new SparseIntArray();
        f19762o = r5;
        r5.append(R$styleable.Transform_android_rotation, 1);
        r5.append(R$styleable.Transform_android_rotationX, 2);
        r5.append(R$styleable.Transform_android_rotationY, 3);
        r5.append(R$styleable.Transform_android_scaleX, 4);
        r5.append(R$styleable.Transform_android_scaleY, 5);
        r5.append(R$styleable.Transform_android_transformPivotX, 6);
        r5.append(R$styleable.Transform_android_transformPivotY, 7);
        r5.append(R$styleable.Transform_android_translationX, 8);
        r5.append(R$styleable.Transform_android_translationY, 9);
        r5.append(R$styleable.Transform_android_translationZ, 10);
        r5.append(R$styleable.Transform_android_elevation, 11);
        r5.append(R$styleable.Transform_transformPivotTarget, 12);
    }

    public final void a(j r5) {
        this.f19763a = r5.f19763a;
        this.f19764b = r5.f19764b;
        this.f19765c = r5.f19765c;
        this.d = r5.d;
        this.e = r5.e;
        this.f = r5.f;
        this.g = r5.g;
        this.f19766h = r5.f19766h;
        this.f19767i = r5.f19767i;
        this.f19768j = r5.f19768j;
        this.f19769k = r5.f19769k;
        this.f19770l = r5.f19770l;
        this.f19771m = r5.f19771m;
        this.f19772n = r5.f19772n;
    }

    public final void b(Context r5, AttributeSet r10) {
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.Transform);
        this.f19763a = true;
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L20;
        int r14 = r11.getIndex(r13);
        switch(f19762o.get(r14)) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L19;
        };
    L7:
        this.f19767i = com.obric.oui.constraintlayout.widget.d.l(r11, r14, this.f19767i);
        goto L19
    L8:
        this.f19771m = true;
        this.f19772n = r11.getDimension(r14, this.f19772n);
        goto L19
    L9:
        this.f19770l = r11.getDimension(r14, this.f19770l);
        goto L19
    L10:
        this.f19769k = r11.getDimension(r14, this.f19769k);
        goto L19
    L11:
        this.f19768j = r11.getDimension(r14, this.f19768j);
        goto L19
    L12:
        this.f19766h = r11.getDimension(r14, this.f19766h);
        goto L19
    L13:
        this.g = r11.getDimension(r14, this.g);
        goto L19
    L14:
        this.f = r11.getFloat(r14, this.f);
        goto L19
    L15:
        this.e = r11.getFloat(r14, this.e);
        goto L19
    L16:
        this.d = r11.getFloat(r14, this.d);
        goto L19
    L17:
        this.f19765c = r11.getFloat(r14, this.f19765c);
        goto L19
    L18:
        this.f19764b = r11.getFloat(r14, this.f19764b);
    L19:
        r13 = r13 + 1;
        goto L3
    L20:
        r11.recycle();
    }
}
