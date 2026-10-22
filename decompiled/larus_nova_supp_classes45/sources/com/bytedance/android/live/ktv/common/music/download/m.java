package com.bytedance.android.live.ktv.common.music.download;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public m() {
        this(false, false, 63);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L18;
        m r4 = (m) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r11 = this.d;
        ?? r12 = r11;
        if (r11 == false) goto L14;
        r12 = 1;
    L14:
        int r13 = (r9 + r12) * 31;
        boolean r14 = this.e;
        ?? r15 = r14;
        if (r14 == false) goto L17;
        r15 = 1;
    L17:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.f;
        if (r17 == true) goto L22;
        r1 = r17;
    L22:
        return r16 + r1;
    }

    public final String toString() {
        return "KtvMusicDownloadConfig(skipProcessingIfDownloaded=" + this.a + ", needDownloadFullTrack=" + this.b + ", needDownloadAccompanimentTrack=" + this.c + ", needDownloadLyric=" + this.d + ", needDownloadMidi=" + this.e + ", needDownloadVocal=" + this.f + ")";
    }

    public m(boolean r6, boolean r7, int r8) {
        boolean r1 = false;
        boolean r2 = true;
        if ((r8 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r8 & 2) == 0) goto L10;
        r6 = true;
    L10:
        if ((r8 & 4) == 0) goto L13;
        r7 = true;
    L13:
        if ((r8 & 8) == 0) goto L15;
        boolean r3 = true;
    L17:
        if ((r8 & 16) != 0) goto L21;
        r2 = false;
    L21:
        if ((r8 & 32) == 0) goto L23;
        r1 = vm2.h.d();
    L23:
        this.a = r0;
        this.b = r6;
        this.c = r7;
        this.d = r3;
        this.e = r2;
        this.f = r1;
        return;
    L15:
        r3 = false;
        goto L17
    L5:
        r0 = false;
        goto L7
    }
}
