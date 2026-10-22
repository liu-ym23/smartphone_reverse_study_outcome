package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12715c;
    public HashMap d;

    public c() {
        this.f12713a = -1;
        this.f12714b = -1;
        this.f12715c = null;
    }

    public static float g(Number r5) {
        if ((r5 instanceof Float) == false) goto L6;
        return ((Float) r5).floatValue();
    L6:
        return Float.parseFloat(r5.toString());
    }

    public abstract void a(HashMap r5);

    public abstract c b();

    public c c(c r5) {
        this.f12713a = r5.f12713a;
        this.f12714b = r5.f12714b;
        this.f12715c = r5.f12715c;
        this.d = r5.d;
        return this;
    }

    public abstract void d(HashSet r5);

    public abstract void e(Context r5, AttributeSet r10);

    public void f(HashMap r5) {
    }
}
