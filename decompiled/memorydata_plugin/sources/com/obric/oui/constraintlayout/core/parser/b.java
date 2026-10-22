package com.obric.oui.constraintlayout.core.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class b implements Cloneable {
    protected static int e = 80;
    protected static int f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f13596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f13597b;
    protected long c;
    protected a d;
    private int g;

    static {
    }

    public void a(a r1) {
        this.d = r1;
    }

    public b b() {
        return (b) ZeusTransformUtils.preCheckCast(super.clone(), b.class, "com.obric.memorydata.plugin");
    L5:
        throw new AssertionError();
    }

    public int c() {
        return this.g;
    }

    public /* synthetic */ Object clone() {
        return b();
    }

    public String d() {
        String r1 = getClass().toString();
        return r1.substring(r1.lastIndexOf(46) + 1);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == true) goto L9;
        return false;
    L9:
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
        if (this.f13597b == r7.f13597b) goto L13;
        return false;
    L13:
        if (this.c == r7.c) goto L16;
        return false;
    L16:
        if (this.g == r7.g) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.f13596a, r7.f13596a) == true) goto L22;
        return false;
    L22:
        return Objects.equals(this.d, r7.d);
    }

    public int hashCode() {
        int r0 = Arrays.hashCode(this.f13596a) * 31;
        long r1 = this.f13597b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        a r5 = this.d;
        if (r5 == null) goto L5;
        int r6 = r5.hashCode();
    L7:
        return ((r4 + r6) * 31) + this.g;
    L5:
        r6 = 0;
        goto L7
    }

    public String toString() {
        long r0 = this.f13597b;
        long r2 = this.c;
        if (r0 <= r2) goto L5;
    L10:
        StringBuilder r4 = new StringBuilder().append(getClass()).append(" (INVALID, ").append(this.f13597b).append("-").append(this.c);
        String r1 = ")";
    L9:
        return r4.append(r1).toString();
    L5:
        if (r2 == Long.MAX_VALUE) goto L10;
        String r3 = new String(this.f13596a).substring((int) this.f13597b, ((int) this.c) + 1);
        r4 = new StringBuilder().append(d()).append(" (").append(this.f13597b).append(" : ").append(this.c).append(") <<").append(r3);
        r1 = ">>";
        goto L9
    }
}
