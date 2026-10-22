package org.apache.commons.lang3.time;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends i {
    @Override // org.apache.commons.lang3.time.i
    public final int c(FastDateParser r5, int r10) {
        if (r10 >= 100) goto L9;
        int r11 = r5.d + r10;
        if (r10 < r5.e) goto L8;
        return r11;
    L8:
        return r11 + 100;
    L9:
        return r10;
    }
}
