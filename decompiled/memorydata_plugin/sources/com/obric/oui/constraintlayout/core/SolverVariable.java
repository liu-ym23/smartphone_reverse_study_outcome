package com.obric.oui.constraintlayout.core;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes5.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    private static int q = 1;
    private static int r = 1;
    private static int s = 1;
    private static int t = 1;
    private static int u = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13517b;
    int c;
    public int d;
    public float e;
    public boolean f;
    float[] g;
    float[] h;
    Type i;
    b[] j;
    int k;
    public int l;
    boolean m;
    int n;
    float o;
    HashSet<b> p;
    private String v;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CONSTANT = null;
        public static final Type ERROR = null;
        public static final Type SLACK = null;
        public static final Type UNKNOWN = null;
        public static final Type UNRESTRICTED = null;

        static {
            Type r0 = new Type("UNRESTRICTED", 0);
            UNRESTRICTED = r0;
            Type r1 = new Type("CONSTANT", 1);
            CONSTANT = r1;
            Type r3 = new Type("SLACK", 2);
            SLACK = r3;
            Type r5 = new Type(CipherConst.LEVEL_ERROR, 3);
            ERROR = r5;
            Type r7 = new Type("UNKNOWN", 4);
            UNKNOWN = r7;
            $VALUES = new Type[]{r0, r1, r3, r5, r7};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public SolverVariable(Type r4, String r5) {
        this.f13517b = -1;
        this.c = -1;
        this.d = 0;
        this.f = false;
        this.g = new float[9];
        this.h = new float[9];
        this.j = new b[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        this.p = null;
        this.i = r4;
    }

    static void a() {
        r++;
    }

    public int a(SolverVariable r1) {
        return this.f13517b - r1.f13517b;
    }

    public void a(Type r1, String r2) {
        this.i = r1;
    }

    public final void a(b r4) {
        int r0 = 0;
    L3:
        int r1 = this.k;
        if (r0 >= r1) goto L9;
        if (this.j[r0] == r4) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return;
    L9:
        b[] r2 = this.j;
        if (r1 < r2.length) goto L12;
        this.j = (b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), b[].class, "com.obric.memorydata.plugin");
    L12:
        b[] r3 = this.j;
        int r5 = this.k;
        r3[r5] = r4;
        this.k = r5 + 1;
    }

    public void a(d r4, float r5) {
        this.e = r5;
        this.f = true;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        int r1 = this.k;
        this.c = -1;
        int r0 = 0;
    L3:
        if (r0 >= r1) goto L5;
        this.j[r0].a(r4, this, false);
        r0 = r0 + 1;
        goto L3
    L5:
        this.k = 0;
    }

    public final void a(d r5, b r6) {
        int r0 = this.k;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.j[r2].a(r5, r6, false);
        r2 = r2 + 1;
        goto L3
    L5:
        this.k = 0;
    }

    public void b() {
        this.v = null;
        this.i = Type.UNKNOWN;
        this.d = 0;
        this.f13517b = -1;
        this.c = -1;
        this.e = 0.0f;
        this.f = false;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        int r2 = this.k;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        this.j[r4] = null;
        r4 = r4 + 1;
        goto L3
    L5:
        this.k = 0;
        this.l = 0;
        this.f13516a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public final void b(b r5) {
        int r0 = this.k;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        if (this.j[r1] == r5) goto L7;
        r1 = r1 + 1;
    L7:
        if (r1 >= (r0 - 1)) goto L9;
        b[] r6 = this.j;
        int r2 = r1 + 1;
        r6[r1] = r6[r2];
        r1 = r2;
        goto L7
    L9:
        this.k--;
        return;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(SolverVariable r3) {
        return a((SolverVariable) ZeusTransformUtils.preCheckCast(r3, SolverVariable.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        if (this.v == null) goto L5;
        StringBuilder r2 = new StringBuilder().append("").append(this.v);
    L7:
        return r2.toString();
    L5:
        r2 = new StringBuilder().append("").append(this.f13517b);
        goto L7
    }
}
