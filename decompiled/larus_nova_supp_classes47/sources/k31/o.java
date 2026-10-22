package k31;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public static final Integer a(int r2, Float r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.floatValue() <= 0.0f) goto L11;
        if (r2 != 0) goto L8;
        return null;
    L8:
        return Integer.valueOf((int) (r2 / r3.floatValue()));
    L11:
        return null;
    }

    public static final Integer b(int r2, Float r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.floatValue() <= 0.0f) goto L11;
        if (r2 != 0) goto L8;
        return null;
    L8:
        return Integer.valueOf((int) (r2 * r3.floatValue()));
    L11:
        return null;
    }
}
