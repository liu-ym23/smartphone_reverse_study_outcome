package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.collection.SimpleArrayMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap<String, i> f3750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SimpleArrayMap<String, PropertyValuesHolder[]> f3751b;

    public h() {
        this.f3750a = new SimpleArrayMap();
        this.f3751b = new SimpleArrayMap();
    }

    public static h a(Context r3, int r4) {
        Animator r5 = AnimatorInflater.loadAnimator((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);     // Catch: Exception -> L11
        if (ZeusTransformUtils.instanceOf(r5, AnimatorSet.class) == true) goto L6;
        if (r5 == null) goto L10;
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L11
        r1.add(r5);     // Catch: Exception -> L11
        return a(r1);
    L10:
        return null;
    L6:
        return a(((AnimatorSet) ZeusTransformUtils.preCheckCast(r5, AnimatorSet.class, "com.obric.memorydata.plugin")).getChildAnimations());
    L11:
        e = move-exception;
        Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(r4), e);
        return null;
    }

    public static h a(Context r2, TypedArray r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3.hasValue(r4) == false) goto L8;
        int r6 = r3.getResourceId(r4, 0);
        if (r6 != 0) goto L7;
        return null;
    L7:
        return a(r5, r6);
    L8:
        return null;
    }

    private static h a(List<Animator> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        h r0 = new h();
        int r2 = r7.size();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        a(r0, (Animator) ZeusTransformUtils.preCheckCast(r7.get(r3), Animator.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static void a(h r2, Animator r3) {
        if (ZeusTransformUtils.instanceOf(r3, ObjectAnimator.class) == false) goto L7;
        ObjectAnimator r4 = (ObjectAnimator) ZeusTransformUtils.preCheckCast(r3, ObjectAnimator.class, "com.obric.memorydata.plugin");
        r2.a(r4.getPropertyName(), r4.getValues());
        r2.a(r4.getPropertyName(), i.a(r4));
        return;
    L7:
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + r3);
    }

    private PropertyValuesHolder[] a(PropertyValuesHolder[] r3) {
        PropertyValuesHolder[] r2 = new PropertyValuesHolder[r3.length];
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r2[r0] = r3[r0].clone();
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    public long a() {
        int r0 = this.f3750a.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        i r4 = (i) ZeusTransformUtils.preCheckCast(this.f3750a.valueAt(r3), i.class, "com.obric.memorydata.plugin");
        r1 = Math.max(r1, r4.a() + r4.b());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public <T> ObjectAnimator a(String r2, T r3, Property<T, ?> r4) {
        ObjectAnimator r5 = ObjectAnimator.ofPropertyValuesHolder(r3, d(r2));
        r5.setProperty(r4);
        b(r2).a(r5);
        return r5;
    }

    public void a(String r1, i r2) {
        this.f3750a.put(r1, r2);
    }

    public void a(String r1, PropertyValuesHolder[] r2) {
        this.f3751b.put(r1, r2);
    }

    public boolean a(String r1) {
        if (this.f3750a.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public i b(String r2) {
        if (a(r2) == false) goto L7;
        return (i) ZeusTransformUtils.preCheckCast(this.f3750a.get(r2), i.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException();
    }

    public boolean c(String r1) {
        if (this.f3751b.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public PropertyValuesHolder[] d(String r3) {
        if (c(r3) == false) goto L7;
        return a((PropertyValuesHolder[]) ZeusTransformUtils.preCheckCast(this.f3751b.get(r3), PropertyValuesHolder[].class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalArgumentException();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, h.class) == true) goto L10;
        return false;
    L10:
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin");
        return this.f3750a.equals(r4.f3750a);
    }

    public int hashCode() {
        return this.f3750a.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f3750a + "}\n";
    }
}
