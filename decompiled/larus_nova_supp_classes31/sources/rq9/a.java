package rq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements t1a.c {
    public final d a;
    public final h b;
    public final f c;
    public final c d;
    public final g e;

    public a() {
        this(null, null, null, null, 31);
    }

    public /* synthetic */ a(d r9, h r10, f r11, gnc.f r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        d r3 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        h r4 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        f r5 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        gnc.f r6 = null;
    L18:
        this(r3, r4, r5, r6, null);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public a(d r1, h r2, f r3, c r4, g r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
