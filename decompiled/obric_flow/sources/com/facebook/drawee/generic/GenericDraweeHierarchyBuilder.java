package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GenericDraweeHierarchyBuilder {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ScalingUtils.ScaleType f7913q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ScalingUtils.ScaleType f7914r = null;
    public static int s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f7915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f7917c;
    public Drawable d;
    public ScalingUtils.AbstractScaleType e;
    public Drawable f;
    public ScalingUtils.AbstractScaleType g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f7918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScalingUtils.AbstractScaleType f7919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f7920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ScalingUtils.AbstractScaleType f7921k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ScalingUtils.ScaleType f7922l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f7923m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f7924n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public StateListDrawable f7925o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RoundingParams f7926p;

    static {
        f7913q = ScalingUtils.ScaleType.f;
        f7914r = ScalingUtils.ScaleType.g;
        s = -1;
    }

    public GenericDraweeHierarchyBuilder(Context r5) {
        this.f7916b = r5;
        b();
    }

    public final GenericDraweeHierarchy a() {
        List r5 = this.f7924n;
        if (r5 == null) goto L9;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        ((Drawable) r10.next()).getClass();
    L9:
        return new GenericDraweeHierarchy(this);
    }

    public final void b() {
        if (s >= 0) goto L5;
        s = 300;
    L5:
        this.f7917c = 0.0f;
        this.d = null;
        ScalingUtils.AbstractScaleType r5 = (ScalingUtils.AbstractScaleType) f7913q;
        this.e = r5;
        this.f = null;
        this.g = r5;
        this.f7918h = null;
        this.f7919i = r5;
        this.f7920j = null;
        this.f7921k = r5;
        this.f7922l = f7914r;
        this.f7923m = null;
        this.f7924n = null;
        this.f7925o = null;
        this.f7926p = null;
    }

    public GenericDraweeHierarchyBuilder(Resources r5) {
        this.f7915a = r5;
        b();
    }
}
