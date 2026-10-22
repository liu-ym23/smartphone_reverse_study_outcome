package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f1260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f1261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f1262c;
    public HashMap d;
    public HashMap e;
    public ArrayList f;
    public SparseArrayCompat g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LongSparseArray f1263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f1264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f1265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f1267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1268m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1269n;

    public h() {
        this.f1260a = new d0();
        this.f1261b = new HashSet();
        this.f1269n = 0;
    }

    public final void a(String r5) {
        u.b.b(r5);
        this.f1261b.add(r5);
    }

    public final float b() {
        return (long) (((this.f1267l - this.f1266k) / this.f1268m) * 1000.0f);
    }

    public final o.h c(String r10) {
        this.f.size();
        int r5 = 0;
    L4:
        if (r5 >= this.f.size()) goto L14;
        o.h r11 = (o.h) this.f.get(r5);
        String r12 = r11.f20377a;
        if (r12.equalsIgnoreCase(r10) == true) goto L12;
        if (r12.endsWith("\r") == false) goto L13;
        if (r12.substring(0, r12.length() - 1).equalsIgnoreCase(r10) == true) goto L12;
    L13:
        r5 = r5 + 1;
    L12:
        return r11;
    L14:
        return null;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LottieComposition:\n");
        Iterator r10 = this.f1264i.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r5.append(((r.g) r10.next()).a(Profiler.DATA_SEP));
        goto L4
    L7:
        return r5.toString();
    }
}
