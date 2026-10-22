package b49;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final int a;
    public final byte[] b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final long h;
    public final int i;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("FlowDoraImageInfo(imageUUID=");
        r0.append(this.a);
        r0.append(", data=");
        byte[] r1 = this.b;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length);
    L6:
        r0.append(r2);
        r0.append(", width=");
        r0.append(this.c);
        r0.append(", height=");
        r0.append(this.d);
        r0.append(", format=");
        r0.append(this.e);
        r0.append(", side=");
        r0.append(this.f);
        r0.append(", linkType=");
        r0.append(this.g);
        r0.append(", mode=");
        r0.append(this.i);
        r0.append(", imageUniqueId=");
        r0.append(this.h);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public h(int r1, byte[] r2, int r3, int r4, int r5, int r6, int r7, int r8, long r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r9;
        this.i = r8;
    }
}
