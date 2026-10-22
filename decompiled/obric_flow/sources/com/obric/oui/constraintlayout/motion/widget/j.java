package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends c {
    public int e;
    public String f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12826l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12827m;

    public j() {
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.f12822h = 0;
        this.f12823i = Float.NaN;
        this.f12824j = Float.NaN;
        this.f12825k = Float.NaN;
        this.f12826l = Float.NaN;
        this.f12827m = 0;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void a(HashMap r5) {
        throw null;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final c b() {
        j r5 = new j();
        super.c(this);
        r5.f = this.f;
        r5.g = this.g;
        r5.f12822h = this.f12822h;
        r5.f12823i = this.f12823i;
        r5.f12824j = Float.NaN;
        r5.f12825k = this.f12825k;
        r5.f12826l = this.f12826l;
        return r5;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void d(HashSet r5) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void e(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.KeyPosition);
        SparseIntArray r13 = i.f12805a;
        int r14 = r12.getIndexCount();
        int r5 = 0;
    L4:
        if (r5 >= r14) goto L33;
        int r15 = r12.getIndex(r5);
        SparseIntArray r16 = i.f12805a;
        switch(r16.get(r15)) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            default: goto L7;
        };
    L7:
        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(r15) + "   " + r16.get(r15));
    L31:
        r5 = r5 + 1;
        goto L4
    L8:
        this.f12824j = r12.getFloat(r15, this.f12824j);
        goto L31
    L9:
        this.f12823i = r12.getFloat(r15, this.f12823i);
        goto L31
    L10:
        this.g = r12.getInt(r15, this.g);
        goto L31
    L11:
        this.f12827m = r12.getInt(r15, this.f12827m);
        goto L31
    L12:
        float r17 = r12.getFloat(r15, this.f12824j);
        this.f12823i = r17;
        this.f12824j = r17;
        goto L31
    L13:
        this.f12826l = r12.getFloat(r15, this.f12826l);
        goto L31
    L14:
        this.f12825k = r12.getFloat(r15, this.f12825k);
        goto L31
    L15:
        this.f12822h = r12.getInt(r15, this.f12822h);
        goto L31
    L16:
        this.e = r12.getInteger(r15, this.e);
        goto L31
    L21:
        this.f12713a = r12.getInt(r15, this.f12713a);
        goto L31
    L18:
        if (r12.peekValue(r15).type != 3) goto L20;
        this.f = r12.getString(r15);
        goto L31
    L20:
        this.f = gr.e.d[r12.getInteger(r15, 0)];
        goto L31
    L23:
        if (MotionLayout.F0 == false) goto L28;
        int r18 = r12.getResourceId(r15, this.f12714b);
        this.f12714b = r18;
        if (r18 != (-1)) goto L31;
        this.f12715c = r12.getString(r15);
        goto L31
    L28:
        if (r12.peekValue(r15).type != 3) goto L30;
        this.f12715c = r12.getString(r15);
        goto L31
    L30:
        this.f12714b = r12.getResourceId(r15, this.f12714b);
        goto L31
    L33:
        if (this.f12713a != (-1)) goto L54;
        Log.e("KeyPosition", "no frame position");
        return;
    }

    public final void h(String r5, Object r10) {
        byte r11 = -1;
        switch(r5.hashCode()) {
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
        switch(r11) {
            case 0: goto L45;
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L53;
        };
    L35:
        this.f12826l = c.g((Number) r10);
        return;
    L36:
        this.f12825k = c.g((Number) r10);
        return;
    L37:
        float r12 = c.g((Number) r10);
        this.f12823i = r12;
        this.f12824j = r12;
        return;
    L38:
        Number r13 = (Number) r10;
        if ((r13 instanceof Integer) == false) goto L41;
        int r14 = ((Integer) r13).intValue();
    L42:
        this.f12822h = r14;
        return;
    L41:
        r14 = Integer.parseInt(r13.toString());
        goto L42
    L43:
        this.f12824j = c.g((Number) r10);
        return;
    L44:
        this.f12823i = c.g((Number) r10);
        return;
    L45:
        this.f = r10.toString();
        return;
    L53:
        return;
    L6:
        if (r5.equals("percentY") == false) goto L33;
        r11 = 6;
        goto L33
    L10:
        if (r5.equals("percentX") == false) goto L33;
        r11 = 5;
        goto L33
    L14:
        if (r5.equals("sizePercent") == false) goto L33;
        r11 = 4;
        goto L33
    L18:
        if (r5.equals("drawPath") == false) goto L33;
        r11 = 3;
        goto L33
    L22:
        if (r5.equals("percentHeight") == false) goto L33;
        r11 = 2;
        goto L33
    L26:
        if (r5.equals("percentWidth") == false) goto L33;
        r11 = 1;
        goto L33
    L30:
        if (r5.equals("transitionEasing") == false) goto L33;
        r11 = 0;
        goto L33
    }
}
