package lr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f19749n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19752c;
    public String d;
    public int e;
    public int f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f19753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f19754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f19756k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19757l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19758m;

    static {
        SparseIntArray r5 = new SparseIntArray();
        f19749n = r5;
        r5.append(R$styleable.Motion_motionPathRotate, 1);
        r5.append(R$styleable.Motion_pathMotionArc, 2);
        r5.append(R$styleable.Motion_transitionEasing, 3);
        r5.append(R$styleable.Motion_drawPath, 4);
        r5.append(R$styleable.Motion_animateRelativeTo, 5);
        r5.append(R$styleable.Motion_animateCircleAngleTo, 6);
        r5.append(R$styleable.Motion_motionStagger, 7);
        r5.append(R$styleable.Motion_quantizeMotionSteps, 8);
        r5.append(R$styleable.Motion_quantizeMotionPhase, 9);
        r5.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
    }

    public final void a(h r5) {
        this.f19750a = r5.f19750a;
        this.f19751b = r5.f19751b;
        this.d = r5.d;
        this.e = r5.e;
        this.f = r5.f;
        this.f19753h = r5.f19753h;
        this.g = r5.g;
    }

    public final void b(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Motion);
        this.f19750a = true;
        int r5 = r12.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L31;
        int r14 = r12.getIndex(r13);
        switch(f19749n.get(r14)) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L7;
            default: goto L30;
        };
    L7:
        int r15 = r12.peekValue(r14).type;
        if (r15 != 1) goto L12;
        int r16 = r12.getResourceId(r14, -1);
        this.f19758m = r16;
        if (r16 == (-1)) goto L30;
        this.f19757l = -2;
        goto L30
    L12:
        if (r15 != 3) goto L17;
        String r17 = r12.getString(r14);
        this.f19756k = r17;
        if (r17.indexOf("/") <= 0) goto L16;
        this.f19758m = r12.getResourceId(r14, -1);
        this.f19757l = -2;
        goto L30
    L16:
        this.f19757l = -1;
        goto L30
    L17:
        this.f19757l = r12.getInteger(r14, this.f19758m);
        goto L30
    L18:
        this.f19754i = r12.getFloat(r14, this.f19754i);
        goto L30
    L19:
        this.f19755j = r12.getInteger(r14, this.f19755j);
        goto L30
    L20:
        this.g = r12.getFloat(r14, this.g);
        goto L30
    L21:
        this.f19752c = r12.getInteger(r14, this.f19752c);
        goto L30
    L22:
        this.f19751b = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19751b);
        goto L30
    L23:
        this.f = r12.getInt(r14, 0);
        goto L30
    L28:
        this.e = r12.getInt(r14, this.e);
        goto L30
    L29:
        this.f19753h = r12.getFloat(r14, this.f19753h);
        goto L30
    L25:
        if (r12.peekValue(r14).type != 3) goto L27;
        this.d = r12.getString(r14);
        goto L30
    L27:
        this.d = gr.e.d[r12.getInteger(r14, 0)];
    L30:
        r13 = r13 + 1;
        goto L3
    L31:
        r12.recycle();
    }
}
