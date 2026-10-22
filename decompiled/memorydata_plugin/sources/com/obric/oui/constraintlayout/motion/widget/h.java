package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class h extends i {
    String g;
    int h;
    int i;
    float j;
    float k;
    float l;
    float m;
    float n;
    float o;
    int p;
    private float r;
    private float s;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f13691a;

        static {
            SparseIntArray r0 = new SparseIntArray();
            f13691a = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_motionTarget, "styleable", "KeyPosition_motionTarget"), 1);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_framePosition, "styleable", "KeyPosition_framePosition"), 2);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_transitionEasing, "styleable", "KeyPosition_transitionEasing"), 3);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_curveFit, "styleable", "KeyPosition_curveFit"), 4);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_drawPath, "styleable", "KeyPosition_drawPath"), 5);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_percentX, "styleable", "KeyPosition_percentX"), 6);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_percentY, "styleable", "KeyPosition_percentY"), 7);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_keyPositionType, "styleable", "KeyPosition_keyPositionType"), 9);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_sizePercent, "styleable", "KeyPosition_sizePercent"), 8);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_percentWidth, "styleable", "KeyPosition_percentWidth"), 11);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_percentHeight, "styleable", "KeyPosition_percentHeight"), 12);
            f13691a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_pathMotionArc, "styleable", "KeyPosition_pathMotionArc"), 10);
        }

        static /* synthetic */ void a(h r0, TypedArray r1) {
            b(r0, r1);
        }

        private static void b(h r8, TypedArray r9) {
            int r0 = r9.getIndexCount();
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L35;
            int r5 = r9.getIndex(r2);
            switch(f13691a.get(r5)) {
                case 1: goto L25;
                case 2: goto L23;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                default: goto L7;
            };
        L7:
            Log.e(TypedValues.PositionType.NAME, "unused attribute 0x" + Integer.toHexString(r5) + "   " + f13691a.get(r5));
        L33:
            r2 = r2 + 1;
            goto L4
        L8:
            float r3 = r9.getFloat(r5, r8.k);
        L13:
            r8.k = r3;
            goto L33
        L9:
            r8.j = r9.getFloat(r5, r8.j);
            goto L33
        L10:
            r8.h = r9.getInt(r5, r8.h);
            goto L33
        L11:
            r8.p = r9.getInt(r5, r8.p);
            goto L33
        L12:
            r3 = r9.getFloat(r5, r8.k);
            r8.j = r3;
            goto L13
        L14:
            r8.m = r9.getFloat(r5, r8.m);
            goto L33
        L15:
            r8.l = r9.getFloat(r5, r8.l);
            goto L33
        L16:
            r8.i = r9.getInt(r5, r8.i);
            goto L33
        L17:
            r8.q = r9.getInteger(r5, r8.q);
            goto L33
        L23:
            r8.f13686b = r9.getInt(r5, r8.f13686b);
            goto L33
        L19:
            if (r9.peekValue(r5).type != 3) goto L21;
            String r4 = r9.getString(r5);
        L22:
            r8.g = r4;
            goto L33
        L21:
            r4 = com.obric.oui.constraintlayout.core.motion.a.c.c[r9.getInteger(r5, 0)];
            goto L22
        L25:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L30;
            r8.c = r9.getResourceId(r5, r8.c);
            if (r8.c != (-1)) goto L33;
        L31:
            r8.d = r9.getString(r5);
            goto L33
        L30:
            if (r9.peekValue(r5).type == 3) goto L31;
            r8.c = r9.getResourceId(r5, r8.c);
            goto L33
        L35:
            if (r8.f13686b != (-1)) goto L53;
            Log.e(TypedValues.PositionType.NAME, "no frame position");
            return;
        }
    }

    public h() {
        this.g = null;
        this.h = f13685a;
        this.i = 0;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = 0;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.e = 2;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a() {
        return new h().a(this);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a(d r3) {
        super.a(r3);
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin");
        this.g = r4.g;
        this.h = r4.h;
        this.i = r4.i;
        this.j = r4.j;
        this.k = Float.NaN;
        this.l = r4.l;
        this.m = r4.m;
        this.n = r4.n;
        this.o = r4.o;
        this.r = r4.r;
        this.s = r4.s;
        return this;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(Context r3, AttributeSet r4) {
        a.a(this, ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.KeyPosition));
    }

    public void a(String r3, Object r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1812823328: goto L30;
            case -1127236479: goto L26;
            case -1017587252: goto L22;
            case -827014263: goto L18;
            case -200259324: goto L14;
            case 428090547: goto L10;
            case 428090548: goto L6;
            default: goto L33;
        };
    L33:
        switch(r1) {
            case 0: goto L42;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L49;
        };
    L35:
        this.m = a(r4);
        return;
    L36:
        this.l = a(r4);
        return;
    L37:
        float r5 = a(r4);
        this.j = r5;
    L40:
        this.k = r5;
        return;
    L38:
        this.i = b(r4);
        return;
    L39:
        r5 = a(r4);
        goto L40
    L41:
        this.j = a(r4);
        return;
    L42:
        this.g = r4.toString();
        return;
    L49:
        return;
    L6:
        if (r3.equals("percentY") == false) goto L33;
        r1 = 6;
        goto L33
    L10:
        if (r3.equals("percentX") == false) goto L33;
        r1 = 5;
        goto L33
    L14:
        if (r3.equals("sizePercent") == false) goto L33;
        r1 = 4;
        goto L33
    L18:
        if (r3.equals("drawPath") == false) goto L33;
        r1 = 3;
        goto L33
    L22:
        if (r3.equals("percentHeight") == false) goto L33;
        r1 = 2;
        goto L33
    L26:
        if (r3.equals("percentWidth") == false) goto L33;
        r1 = 1;
        goto L33
    L30:
        if (r3.equals("transitionEasing") == false) goto L33;
        r1 = 0;
        goto L33
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r1) {
    }

    public void c(int r1) {
        this.p = r1;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public /* synthetic */ Object clone() {
        return a();
    }
}
