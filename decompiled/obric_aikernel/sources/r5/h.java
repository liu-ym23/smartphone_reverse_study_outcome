package r5;

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

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap<String, i> f12686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SimpleArrayMap<String, PropertyValuesHolder[]> f12687b;

    public h() {
        this.f12686a = new SimpleArrayMap();
        this.f12687b = new SimpleArrayMap();
    }

    private static void a(@NonNull h r10, Animator r11) {
        if ((r11 instanceof ObjectAnimator) == false) goto L7;
        ObjectAnimator r12 = (ObjectAnimator) r11;
        r10.l(r12.getPropertyName(), r12.getValues());
        r10.m(r12.getPropertyName(), i.b(r12));
        return;
    L7:
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + r11);
    }

    @NonNull
    private PropertyValuesHolder[] b(@NonNull PropertyValuesHolder[] r10) {
        PropertyValuesHolder[] r11 = new PropertyValuesHolder[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].clone();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @Nullable
    public static h c(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L8;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 != 0) goto L7;
        return null;
    L7:
        return d(r10, r13);
    L8:
        return null;
    }

    @Nullable
    public static h d(@NonNull Context r10, @AnimatorRes int r11) {
        Animator r12 = AnimatorInflater.loadAnimator(r10, r11);     // Catch: Exception -> L11
        if ((r12 instanceof AnimatorSet) == true) goto L6;
        if (r12 == null) goto L10;
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L11
        r13.add(r12);     // Catch: Exception -> L11
        return e(r13);
    L10:
        return null;
    L6:
        return e(((AnimatorSet) r12).getChildAnimations());
    L11:
        e = move-exception;
        Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(r11), e);
        return null;
    }

    @NonNull
    private static h e(@NonNull List<Animator> r10) {
        h r11 = new h();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        a(r11, r10.get(r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L10;
        return false;
    L10:
        return this.f12686a.equals(((h) r10).f12686a);
    }

    @NonNull
    public <T> ObjectAnimator f(@NonNull String r10, @NonNull T r11, @NonNull Property<T, ?> r12) {
        ObjectAnimator r13 = ObjectAnimator.ofPropertyValuesHolder(r11, g(r10));
        r13.setProperty(r12);
        h(r10).a(r13);
        return r13;
    }

    @NonNull
    public PropertyValuesHolder[] g(String r10) {
        if (j(r10) == false) goto L7;
        return b(this.f12687b.get(r10));
    L7:
        throw new IllegalArgumentException();
    }

    public i h(String r10) {
        if (k(r10) == false) goto L7;
        return this.f12686a.get(r10);
    L7:
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f12686a.hashCode();
    }

    public long i() {
        int r10 = this.f12686a.size();
        long r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        i r13 = this.f12686a.valueAt(r12);
        r11 = Math.max(r11, r13.c() + r13.d());
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public boolean j(String r10) {
        if (this.f12687b.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k(String r10) {
        if (this.f12686a.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void l(String r10, PropertyValuesHolder[] r11) {
        this.f12687b.put(r10, r11);
    }

    public void m(String r10, @Nullable i r11) {
        this.f12686a.put(r10, r11);
    }

    @NonNull
    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f12686a + "}\n";
    }
}
