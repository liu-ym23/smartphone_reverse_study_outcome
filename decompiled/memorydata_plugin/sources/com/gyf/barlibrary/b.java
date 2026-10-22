package com.gyf.barlibrary;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Cloneable {
    int A;
    boolean B;
    public boolean C;
    int D;
    boolean E;
    boolean F;
    boolean G;

    @Deprecated
    boolean H;
    i I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f5127b;
    boolean c;
    int d;
    float e;
    float f;
    public boolean g;
    boolean h;
    BarHide i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    float n;
    float o;
    boolean p;
    int q;
    int r;
    Map<View, Map<Integer, Integer>> s;
    float t;
    int u;
    int v;
    float w;
    public boolean x;
    View y;
    View z;

    public b() {
        this.f5126a = 0;
        this.f5127b = ViewCompat.MEASURED_STATE_MASK;
        this.c = true;
        this.d = ViewCompat.MEASURED_STATE_MASK;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = false;
        this.h = false;
        this.i = BarHide.FLAG_SHOW_BAR;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = true;
        this.q = ViewCompat.MEASURED_STATE_MASK;
        this.r = ViewCompat.MEASURED_STATE_MASK;
        this.s = new HashMap();
        this.t = 0.0f;
        this.u = 0;
        this.v = ViewCompat.MEASURED_STATE_MASK;
        this.w = 0.0f;
        this.x = false;
        this.B = false;
        this.C = false;
        this.D = 18;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
    }

    public b a() {
        return (b) ZeusTransformUtils.preCheckCast(super.clone(), b.class, "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    public /* synthetic */ Object clone() {
        return a();
    }
}
