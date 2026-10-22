package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.motion.widget.MotionHelper;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.a;
import com.obric.oui.constraintlayout.motion.widget.e;
import com.obric.oui.constraintlayout.motion.widget.h;
import com.obric.oui.constraintlayout.motion.widget.m;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class MotionEffect extends MotionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13658b;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private int i;

    public MotionEffect(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.f13657a = 0.1f;
        this.f13658b = 49;
        this.d = 50;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.h = -1;
        this.i = -1;
    }

    public MotionEffect(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.f13657a = 0.1f;
        this.f13658b = 49;
        this.d = 50;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.h = -1;
        this.i = -1;
        a(r5, r6);
    }

    public MotionEffect(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.f13657a = 0.1f;
        this.f13658b = 49;
        this.d = 50;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.h = -1;
        this.i = -1;
        a(r6, r7);
    }

    private void a(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L48;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.MotionEffect);
        int r13 = r12.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r13) goto L31;
        int r2 = r12.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_start, "styleable", "MotionEffect_motionEffect_start")) goto L10;
        int r3 = r12.getInt(r2, this.f13658b);
        this.f13658b = r3;
        this.f13658b = Math.max(Math.min(r3, 99), 0);
    L30:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_end, "styleable", "MotionEffect_motionEffect_end")) goto L13;
        int r4 = r12.getInt(r2, this.d);
        this.d = r4;
        this.d = Math.max(Math.min(r4, 99), 0);
        goto L30
    L13:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_translationX, "styleable", "MotionEffect_motionEffect_translationX")) goto L16;
        this.e = r12.getDimensionPixelOffset(r2, this.e);
        goto L30
    L16:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_translationY, "styleable", "MotionEffect_motionEffect_translationY")) goto L19;
        this.f = r12.getDimensionPixelOffset(r2, this.f);
        goto L30
    L19:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_alpha, "styleable", "MotionEffect_motionEffect_alpha")) goto L22;
        this.f13657a = r12.getFloat(r2, this.f13657a);
        goto L30
    L22:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_move, "styleable", "MotionEffect_motionEffect_move")) goto L25;
        this.i = r12.getInt(r2, this.i);
        goto L30
    L25:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_strict, "styleable", "MotionEffect_motionEffect_strict")) goto L28;
        this.g = r12.getBoolean(r2, this.g);
        goto L30
    L28:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_viewTransition, "styleable", "MotionEffect_motionEffect_viewTransition")) goto L30;
        this.h = r12.getResourceId(r2, this.h);
        goto L30
    L31:
        int r14 = this.f13658b;
        int r0 = this.d;
        if (r14 != r0) goto L36;
        if (r14 <= 0) goto L35;
        this.f13658b = r14 - 1;
        goto L36
    L35:
        this.d = r0 + 1;
    L36:
        r12.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper
    public void a(MotionLayout r24, HashMap<View, m> r25) {
        HashMap<View, m> r1 = r25;
        View[] r2 = f((ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin"));
        if (r2 != null) goto L6;
        Log.v(androidx.constraintlayout.helper.widget.MotionEffect.TAG, a.b() + " views = null");
        return;
    L6:
        e r3 = new e();
        e r5 = new e();
        r3.a("alpha", Float.valueOf(this.f13657a));
        r5.a("alpha", Float.valueOf(this.f13657a));
        r3.b(this.f13658b);
        r5.b(this.d);
        h r6 = new h();
        r6.b(this.f13658b);
        r6.c(0);
        r6.a("percentX", 0);
        r6.a("percentY", 0);
        h r8 = new h();
        r8.b(this.d);
        r8.c(0);
        r8.a("percentX", 1);
        r8.a("percentY", 1);
        e r10 = null;
        if (this.e <= 0) goto L9;
        e r9 = new e();
        e r12 = new e();
        r9.a("translationX", Integer.valueOf(this.e));
        r9.b(this.d);
        r12.a("translationX", 0);
        r12.b(this.d - 1);
    L11:
        if (this.f <= 0) goto L13;
        r10 = new e();
        e r13 = new e();
        r10.a("translationY", Integer.valueOf(this.f));
        r10.b(this.d);
        r13.a("translationY", 0);
        r13.b(this.d - 1);
    L14:
        int r14 = this.i;
        if (r14 != (-1)) goto L43;
        int[] r15 = new int[4];
        int r16 = 0;
    L18:
        if (r16 >= r2.length) goto L36;
        m r7 = (m) ZeusTransformUtils.preCheckCast(r1.get(r2[r16]), m.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L35;
        float r11 = r7.c() - r7.a();
        float r22 = r7.d() - r7.b();
        if (r22 >= 0.0f) goto L27;
        r15[1] = r15[1] + 1;
    L27:
        if (r22 <= 0.0f) goto L30;
        r15[0] = r15[0] + 1;
    L30:
        if (r11 <= 0.0f) goto L33;
        r15[3] = r15[3] + 1;
    L33:
        if (r11 >= 0.0f) goto L35;
        r15[2] = r15[2] + 1;
    L35:
        r16 = r16 + 1;
        goto L18
    L36:
        int r19 = 0;
        int r17 = r15[0];
        int r18 = 4;
        int r110 = 1;
    L37:
        if (r110 >= r18) goto L42;
        if (r17 >= r15[r110]) goto L41;
        r17 = r15[r110];
        r19 = r110;
    L41:
        r110 = r110 + 1;
        r18 = 4;
        goto L37
    L42:
        r14 = r19;
    L43:
        int r20 = 0;
    L45:
        if (r20 >= r2.length) goto L99;
        m r111 = (m) ZeusTransformUtils.preCheckCast(r1.get(r2[r20]), m.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L98;
        float r112 = r111.c() - r111.a();
        float r113 = r111.d() - r111.b();
        if (r14 != 0) goto L61;
        if (r113 <= 0.0f) goto L87;
        if (this.g == false) goto L58;
        if (r112 != 0.0f) goto L87;
    L58:
        boolean r114 = false;
    L88:
        if (r114 == false) goto L98;
        int r115 = this.h;
        if (r115 != (-1)) goto L97;
        r111.a(r3);
        r111.a(r5);
        r111.a(r6);
        r111.a(r8);
        if (this.e <= 0) goto L95;
        r111.a(r9);
        r111.a(r12);
    L95:
        if (this.f <= 0) goto L98;
        r111.a(r10);
        r111.a(r13);
        goto L98
    L97:
        r24.applyViewTransition(r115, r111);
    L87:
        r114 = true;
        goto L88
    L61:
        if (r14 != 1) goto L70;
        if (r113 >= 0.0f) goto L87;
        if (this.g == false) goto L58;
        if (r112 != 0.0f) goto L87;
    L70:
        if (r14 != 2) goto L79;
        if (r112 >= 0.0f) goto L87;
        if (this.g == false) goto L58;
        if (r113 != 0.0f) goto L87;
    L79:
        if (r14 != 3) goto L87;
        if (r112 <= 0.0f) goto L87;
        if (this.g == false) goto L58;
        if (r113 != 0.0f) goto L87;
    L98:
        r20 = r20 + 1;
        r1 = r25;
        goto L45
    L99:
        return;
    L13:
        r13 = null;
        goto L14
    L9:
        r9 = null;
        r12 = null;
        goto L11
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper
    public boolean a() {
        return true;
    }
}
