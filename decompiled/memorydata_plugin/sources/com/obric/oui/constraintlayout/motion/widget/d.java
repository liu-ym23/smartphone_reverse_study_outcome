package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f13685a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f13686b;
    int c;
    String d;
    protected int e;
    HashMap<String, ConstraintAttribute> f;

    static {
    }

    public d() {
        int r0 = f13685a;
        this.f13686b = r0;
        this.c = r0;
        this.d = null;
    }

    float a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == false) goto L6;
        return ((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin")).floatValue();
    L6:
        return Float.parseFloat(r2.toString());
    }

    public abstract d a();

    public d a(int r1) {
        this.c = r1;
        return this;
    }

    public d a(d r2) {
        this.f13686b = r2.f13686b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
        return this;
    }

    abstract void a(Context r1, AttributeSet r2);

    public abstract void a(HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r1);

    abstract void a(HashSet<String> r1);

    boolean a(String r1) {
        String r0 = this.d;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.matches(r0);
    L8:
        return false;
    }

    int b(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L6;
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L6:
        return Integer.parseInt(r2.toString());
    }

    public void b(int r1) {
        this.f13686b = r1;
    }

    public void b(HashMap<String, Integer> r1) {
    }

    boolean c(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L6;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        return Boolean.parseBoolean(r2.toString());
    }

    public /* synthetic */ Object clone() {
        return a();
    }
}
