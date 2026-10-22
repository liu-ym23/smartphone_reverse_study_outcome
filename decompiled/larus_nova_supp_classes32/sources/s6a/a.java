package s6a;

import android.util.SparseArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Cloneable {
    public String a;
    public long b;
    public long c;
    public int d;
    public int e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final int o;
    public int p;

    public a() {
        this.l = -1;
        this.n = -1;
        this.p = -1;
    }

    public a(a r3) {
        this.l = -1;
        this.n = -1;
        this.p = -1;
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
        this.j = r3.j;
        this.k = r3.k;
        this.l = r3.l;
        this.m = r3.m;
        this.n = r3.n;
        this.o = r3.o;
        this.p = r3.p;
    }

    public static a d(ReadableArray r6) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.size() == 13) goto L8;
        LLog.DTHROW();
    L8:
        a r0 = new a();
        r0.a = r6.getString(0);
        r0.b = (long) r6.getDouble(1);
        int r2 = r0.c(r6, 2);
        int r3 = r2 + 1;
        r0.c = (long) r6.getDouble(r2);
        int r4 = r3 + 1;
        r0.k = r6.getInt(r3) - 1;
        int r1 = r4 + 1;
        r0.m = r6.getInt(r4);
        int r5 = r1 + 1;
        r0.l = r6.getInt(r1);
        r0.n = r6.getInt(r5);
        return r0;
    }

    public final boolean a(a r6) {
        if (r6 != null) goto L4;
    L32:
        return false;
    L4:
        if (this.a.equals(r6.a) == false) goto L32;
        if (this.b != r6.b) goto L32;
        if (this.c != r6.c) goto L32;
        if (this.d != r6.d) goto L32;
        if (this.e != r6.e) goto L32;
        if (this.f != r6.f) goto L32;
        if (this.g != r6.g) goto L32;
        if (this.h != r6.h) goto L32;
        if (this.i != r6.i) goto L32;
        if (this.j != r6.j) goto L32;
        if (this.k != r6.k) goto L32;
        if (this.l != r6.l) goto L32;
        if (this.m != r6.m) goto L32;
        if (this.o != r6.o) goto L32;
        return true;
    }

    public final int c(ReadableArray r5, int r6) {
        if (r5 != null) goto L4;
    L8:
        this.e = 0;
        this.j = 0;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        return r6;
    L4:
        if (r5.size() < 6) goto L8;
        this.e = r5.getInt(r6);
        this.j = r5.getInt(r6 + 1);
        this.f = (float) r5.getDouble(r6 + 2);
        this.g = (float) r5.getDouble(r6 + 3);
        this.h = (float) r5.getDouble(r6 + 4);
        this.i = (float) r5.getDouble(r6 + 5);
        return r6 + 6;
    }

    public static void b(SparseArray<a> r2, int r3, int r4) {
        if (r2.indexOfKey(r3) >= 0) goto L5;
        return;
    L5:
        if (r2.indexOfKey(r4) >= 0) goto L7;
        return;
    L7:
        if (r2.get(r3).p >= r2.get(r4).p) goto L9;
        r2.remove(r3);
        return;
    L9:
        r2.remove(r4);
    }
}
