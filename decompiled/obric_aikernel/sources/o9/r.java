package o9;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static final /* synthetic */ boolean a(float[] r10) {
        return b(r10);
    }

    private static final boolean b(float[] r10) {
        if (r10.length != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        return true;
    L8:
        float r12 = r10[0];
        int r13 = r10.length;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L22;
        float r15 = r10[r14];
        r14 = r14 + 1;
        if (r15 == r12) goto L13;
        boolean r16 = true;
    L14:
        if (r16 == false) goto L9;
        return false;
    L13:
        r16 = false;
        goto L14
    L22:
        return true;
    L5:
        r11 = false;
        goto L6
    }
}
