package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Registry$NoResultEncoderAvailableException;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f1541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0.a f1543c;
    public final r0.d d;
    public final String e;

    public l(Class r5, Class r10, Class r11, List r12, j0.a r13, r0.d r14) {
        this.f1541a = r5;
        this.f1542b = r12;
        this.f1543c = r13;
        this.d = r14;
        this.e = "Failed DecodePath{" + r5.getSimpleName() + "->" + r10.getSimpleName() + "->" + r11.getSimpleName() + "}";
    }

    public final d0 a(int r17, int r18, com.bumptech.glide.load.data.g r19, i r20, z.f r21) {
        r0.d r10 = this.d;
        List r11 = (List) r10.acquire();
        d0 r5 = b(r19, r17, r18, r21, r11);     // Catch: Throwable -> L54
        r10.release(r11);
        k r12 = (k) r20.f1513b;
        r12.getClass();
        Class<?> r13 = r5.get().getClass();
        DataSource r14 = DataSource.RESOURCE_DISK_CACHE;
        DataSource r15 = (DataSource) r20.f1512a;
        g r16 = r12.f1520a;
        z.h r22 = null;
        if (r15 == r14) goto L7;
        z.i r23 = r16.e(r13);
        z.i r110 = r23;
        d0 r24 = r23.a(r12.f1523h, r5, r12.f1527l, r12.f1528m);
    L9:
        if (r5.equals(r24) == true) goto L12;
        r5.recycle();
    L12:
        if (r16.f1494c.f1388b.d.k(r24.c()) == null) goto L19;
        com.bumptech.glide.d r25 = r16.f1494c.f1388b;
        r25.getClass();
        r22 = r25.d.k(r24.c());
        if (r22 == null) goto L17;
        EncodeStrategy r26 = r22.f(r12.f1530o);
    L16:
        z.h r111 = r22;
        z.c r27 = r12.f1537w;
        ArrayList r28 = r16.b();
        int r29 = r28.size();
        int r30 = 0;
    L22:
        if (r30 >= r29) goto L27;
        if (((d0.q) r28.get(r30)).f16565a.equals(r27) == true) goto L25;
        r30 = r30 + 1;
        goto L22
    L25:
        boolean r31 = true;
    L29:
        switch(r12.f1529n.f1546a) {
            case 0: goto L38;
            case 1: goto L38;
            default: goto L30;
        };
    L30:
        if (r31 == true) goto L34;
        if (r15 != DataSource.DATA_DISK_CACHE) goto L34;
    L36:
        if (r26 != EncodeStrategy.TRANSFORMED) goto L38;
        boolean r32 = true;
    L39:
        if (r32 == false) goto L53;
        if (r111 == null) goto L50;
        int r33 = h.f1508c[r26.ordinal()];
        if (r33 != 1) goto L44;
        Object r34 = new d(r12.f1537w, r12.f1524i);
    L49:
        c0 r35 = (c0) c0.e.acquire();
        r35.d = false;
        r35.f1478c = true;
        r35.f1477b = r24;
        com.google.common.reflect.w r36 = r12.f;
        r36.f9377c = r34;
        r36.f9376b = r111;
        r36.d = r35;
        r24 = r35;
        goto L53
    L44:
        if (r33 != 2) goto L47;
        r34 = new f0(r16.f1494c.f1387a, r12.f1537w, r12.f1524i, r12.f1527l, r12.f1528m, r110, r13, r12.f1530o);
        goto L49
    L47:
        throw new IllegalArgumentException("Unknown strategy: " + r26);
    L50:
        final Class<?> r37 = r24.get().getClass();
        throw new Registry$NoResultEncoderAvailableException(r37);
    L53:
        return this.f1543c.e(r24, r21);
    L34:
        if (r15 == DataSource.LOCAL) goto L36;
    L38:
        r32 = false;
        goto L39
    L27:
        r31 = false;
        goto L29
    L17:
        final Class r38 = r24.c();
        throw new Registry$NoResultEncoderAvailableException(r38);
    L19:
        r26 = EncodeStrategy.NONE;
        goto L16
    L7:
        r24 = r5;
        r110 = null;
    L54:
        th = move-exception;
        r10.release(r11);
        throw th;
    }

    public final d0 b(com.bumptech.glide.load.data.g r10, int r11, int r12, z.f r13, List r14) {
        List r5 = this.f1542b;
        int r15 = r5.size();
        d0 r16 = null;
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L17;
        z.g r18 = (z.g) r5.get(r17);
    L9:
        e = move-exception;
        if (Log.isLoggable("DecodePath", 2) == false) goto L13;
        Log.v("DecodePath", "Failed to decode data for " + r18, e);
    L13:
        r14.add(e);
    L14:
        if (r16 != null) goto L17;
        r17 = r17 + 1;
        goto L3
    L6:
        if (r18.a(r10.c(), r13) == false) goto L14;
        r16 = r18.b(r10.c(), r11, r12, r13);     // Catch: Throwable -> L9
    L17:
        if (r16 == null) goto L20;
        return r16;
    L20:
        throw new GlideException(this.e, new ArrayList(r14));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f1541a + ", decoders=" + this.f1542b + ", transcoder=" + this.f1543c + '}';
    }
}
