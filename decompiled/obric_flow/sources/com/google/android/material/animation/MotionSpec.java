package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MotionSpec {
    private static final String TAG = "MotionSpec";
    private final SimpleArrayMap<String, PropertyValuesHolder[]> propertyValues;
    private final SimpleArrayMap<String, MotionTiming> timings;

    public MotionSpec() {
        this.timings = new SimpleArrayMap();
        this.propertyValues = new SimpleArrayMap();
    }

    private static void addInfoFromAnimator(@NonNull MotionSpec r5, Animator r10) {
        if ((r10 instanceof ObjectAnimator) == false) goto L7;
        ObjectAnimator r11 = (ObjectAnimator) r10;
        r5.setPropertyValues(r11.getPropertyName(), r11.getValues());
        r5.setTiming(r11.getPropertyName(), MotionTiming.createFromAnimator(r11));
        return;
    L7:
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + r10);
    }

    @NonNull
    private PropertyValuesHolder[] clonePropertyValuesHolder(@NonNull PropertyValuesHolder[] r5) {
        PropertyValuesHolder[] r10 = new PropertyValuesHolder[r5.length];
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10[r11] = r5[r11].clone();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @Nullable
    public static MotionSpec createFromAttribute(@NonNull Context r5, @NonNull TypedArray r10, @StyleableRes int r11) {
        if (r10.hasValue(r11) == false) goto L8;
        int r12 = r10.getResourceId(r11, 0);
        if (r12 != 0) goto L7;
        return null;
    L7:
        return createFromResource(r5, r12);
    L8:
        return null;
    }

    @Nullable
    public static MotionSpec createFromResource(@NonNull Context r5, @AnimatorRes int r10) {
        Animator r11 = AnimatorInflater.loadAnimator(r5, r10);     // Catch: Exception -> L7
        if ((r11 instanceof AnimatorSet) == true) goto L6;
        if (r11 == null) goto L12;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L7
        r12.add(r11);     // Catch: Exception -> L7
        return createSpecFromAnimators(r12);
    L12:
        return null;
    L6:
        return createSpecFromAnimators(((AnimatorSet) r11).getChildAnimations());
    L7:
        e = move-exception;
        Log.w(TAG, "Can't load animation resource ID #0x" + Integer.toHexString(r10), e);
        return null;
    }

    @NonNull
    private static MotionSpec createSpecFromAnimators(@NonNull List<Animator> r5) {
        MotionSpec r10 = new MotionSpec();
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        addInfoFromAnimator(r10, r5.get(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MotionSpec) == true) goto L10;
        return false;
    L10:
        return this.timings.equals(((MotionSpec) r5).timings);
    }

    @NonNull
    public <T> ObjectAnimator getAnimator(@NonNull String r5, @NonNull T r10, @NonNull Property<T, ?> r11) {
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(r10, getPropertyValues(r5));
        r12.setProperty(r11);
        getTiming(r5).apply(r12);
        return r12;
    }

    @NonNull
    public PropertyValuesHolder[] getPropertyValues(String r5) {
        if (hasPropertyValues(r5) == false) goto L7;
        return clonePropertyValuesHolder(this.propertyValues.get(r5));
    L7:
        throw new IllegalArgumentException();
    }

    public MotionTiming getTiming(String r5) {
        if (hasTiming(r5) == false) goto L7;
        return this.timings.get(r5);
    L7:
        throw new IllegalArgumentException();
    }

    public long getTotalDuration() {
        int r5 = this.timings.size();
        long r10 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        MotionTiming r12 = this.timings.valueAt(r11);
        long r13 = r12.getDelay();
        r10 = Math.max(r10, r12.getDuration() + r13);
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    public boolean hasPropertyValues(String r5) {
        if (this.propertyValues.get(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTiming(String r5) {
        if (this.timings.get(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public void setPropertyValues(String r5, PropertyValuesHolder[] r10) {
        this.propertyValues.put(r5, r10);
    }

    public void setTiming(String r5, @Nullable MotionTiming r10) {
        this.timings.put(r5, r10);
    }

    @NonNull
    public String toString() {
        return "\n" + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
    }
}
