package h1c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends g1c.a<Integer> implements a {
    public b() {
        super(2);
    }

    @Override // g1c.a, g1c.b
    public final boolean a() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h1c.a
    public final boolean d() {
        Integer r0 = (Integer) this.c;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        if (r1 != 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h1c.a
    public final boolean isInterrupted() {
        Integer r0 = (Integer) this.c;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L7:
        if (r1 < ((Number) this.a).intValue()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // g1c.b
    public final boolean isValid() {
        if (isInterrupted() == false) goto L5;
    L8:
        return true;
    L5:
        if (d() == true) goto L8;
        return false;
    }

    @Override // g1c.b
    public final Class<k1c.b<Integer>> b() {
        return m1c.b.class;
    }
}
