package fv;

import org.threeten.bp.temporal.j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends c implements org.threeten.bp.temporal.c {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.threeten.bp.temporal.c] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // org.threeten.bp.temporal.c
    public org.threeten.bp.temporal.c minus(long r5, j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        long r11 = 1;
        ?? r12 = plus(Long.MAX_VALUE, r10);
    L7:
        return r12.plus(r11, r10);
    L6:
        r11 = -r5;
        this = this;
        goto L7
    }
}
