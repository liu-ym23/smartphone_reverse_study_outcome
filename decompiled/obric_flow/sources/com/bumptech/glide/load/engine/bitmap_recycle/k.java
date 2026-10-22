package com.bumptech.glide.load.engine.bitmap_recycle;

import ai.j0;
import android.graphics.Bitmap;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final Bitmap.Config[] d = null;
    public static final Bitmap.Config[] e = null;
    public static final Bitmap.Config[] f = null;
    public static final Bitmap.Config[] g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f1467h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s6.c f1469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f1470c;

    static {
        Bitmap.Config[] r5 = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        r5[r5.length - 1] = Bitmap.Config.RGBA_F16;
        d = r5;
        e = r5;
        f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f1467h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public k() {
        this.f1468a = new e(1);
        this.f1469b = new s6.c(2);
        this.f1470c = new HashMap();
    }

    public static String c(int r5, Bitmap.Config r10) {
        return "[" + r5 + "](" + r10 + ")";
    }

    public final void a(Integer r5, Bitmap r10) {
        NavigableMap r11 = d(r10.getConfig());
        Integer r12 = (Integer) r11.get(r5);
        if (r12 == null) goto L10;
        if (r12.intValue() != 1) goto L7;
        r11.remove(r5);
        return;
    L7:
        r11.put(r5, Integer.valueOf(r12.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r5 + ", removed: " + c(q0.i.c(r10), r10.getConfig()) + ", this: " + this);
    }

    public final Bitmap b(int r11, int r12, Bitmap.Config r13) {
        int r5 = q0.i.b(r11, r12, r13);
        e r10 = this.f1468a;
        h r14 = (h) ((ArrayDeque) r10.f22372b).poll();
        if (r14 != null) goto L5;
        r14 = r10.F();
    L5:
        j r15 = (j) r14;
        r15.f1465b = r5;
        r15.f1466c = r13;
        if (Bitmap.Config.RGBA_F16.equals(r13) == false) goto L8;
        Bitmap.Config[] r16 = e;
    L21:
        int r17 = r16.length;
        int r18 = 0;
    L22:
        if (r18 >= r17) goto L39;
        Bitmap.Config r19 = r16[r18];
        Integer r20 = (Integer) d(r19).ceilingKey(Integer.valueOf(r5));
        if (r20 == null) goto L38;
        if (r20.intValue() > (r5 * 8)) goto L38;
        if (r20.intValue() != r5) goto L34;
        if (r19 != null) goto L33;
        if (r13 == null) goto L39;
    L33:
        if (r19.equals(r13) == true) goto L39;
    L34:
        r10.t(r15);
        int r21 = r20.intValue();
        h r22 = (h) ((ArrayDeque) r10.f22372b).poll();
        if (r22 != null) goto L37;
        r22 = r10.F();
    L37:
        r15 = (j) r22;
        r15.f1465b = r21;
        r15.f1466c = r19;
    L38:
        r18 = r18 + 1;
    L39:
        Bitmap r23 = (Bitmap) this.f1469b.v(r15);
        if (r23 == null) goto L42;
        a(Integer.valueOf(r15.f1465b), r23);
        r23.reconfigure(r11, r12, r13);
    L42:
        return r23;
    L8:
        int r24 = i.f1463a[r13.ordinal()];
        if (r24 != 1) goto L11;
        r16 = d;
        goto L21
    L11:
        if (r24 != 2) goto L13;
        r16 = f;
        goto L21
    L13:
        if (r24 != 3) goto L15;
        r16 = g;
        goto L21
    L15:
        if (r24 == 4) goto L17;
        r16 = new Bitmap.Config[]{r13};
        goto L21
    L17:
        r16 = f1467h;
        goto L21
    }

    public final NavigableMap d(Bitmap.Config r5) {
        HashMap r10 = this.f1470c;
        NavigableMap r11 = (NavigableMap) r10.get(r5);
        if (r11 != null) goto L6;
        TreeMap r12 = new TreeMap();
        r10.put(r5, r12);
        return r12;
    L6:
        return r11;
    }

    public final void e(Bitmap r5) {
        int r10 = q0.i.c(r5);
        Bitmap.Config r11 = r5.getConfig();
        e r12 = this.f1468a;
        h r13 = (h) ((ArrayDeque) r12.f22372b).poll();
        if (r13 != null) goto L5;
        r13 = r12.F();
    L5:
        j r14 = (j) r13;
        r14.f1465b = r10;
        r14.f1466c = r11;
        this.f1469b.A(r14, r5);
        NavigableMap r15 = d(r5.getConfig());
        Integer r16 = (Integer) r15.get(Integer.valueOf(r14.f1465b));
        Integer r17 = Integer.valueOf(r14.f1465b);
        int r18 = 1;
        if (r16 == null) goto L9;
        r18 = 1 + r16.intValue();
    L9:
        r15.put(r17, Integer.valueOf(r18));
    }

    public final String toString() {
        StringBuilder r5 = j0.u("SizeConfigStrategy{groupedMap=");
        r5.append(this.f1469b);
        r5.append(", sortedSizes=(");
        HashMap r10 = this.f1470c;
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry r12 = (Map.Entry) r11.next();
        r5.append(r12.getKey());
        r5.append('[');
        r5.append(r12.getValue());
        r5.append("], ");
        goto L4
    L7:
        if (r10.isEmpty() == true) goto L9;
        r5.replace(r5.length() - 2, r5.length(), "");
    L9:
        r5.append(")}");
        return r5.toString();
    }
}
