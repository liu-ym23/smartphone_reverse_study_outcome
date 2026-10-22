package ch0;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public final String a;
    public View b;
    public boolean c;
    public boolean d;
    public final boolean e;
    public long f;
    public final int g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L20;
        h r7 = (h) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        View r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.c;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r5 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = r10;
        if (r10 == false) goto L15;
        r11 = 1;
    L15:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.e;
        if (r13 == true) goto L19;
        r7 = r13;
    L19:
        long r14 = this.f;
        return ((((r12 + r7) * 31) + ((int) (r14 ^ (r14 >>> 32)))) * 31) + this.g;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RtcRemoteUserInfo(interactId=" + this.a + ", surfaceView=" + this.b + ", isVideoMute=" + this.c + ", isAudioMute=" + this.d + ", isTalking=" + this.e + ", lastTalkingTime=" + this.f + ", localUserOnlineStatus=" + this.g + ")";
    }

    public /* synthetic */ h(String r10, boolean r11, boolean r12, int r13, int r14) {
        if ((r14 & 64) == 0) goto L5;
        int r8 = 0;
    L6:
        this(r10, null, r11, r12, false, 0, r8);
        return;
    L5:
        r8 = r13;
        goto L6
    }

    public h(String r2, View r3, boolean r4, boolean r5, boolean r6, long r7, int r9) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
    }

    public static h a(h r11, View r12, boolean r13, boolean r14, boolean r15, int r16, int r17) {
        if ((r17 & 1) == 0) goto L5;
        String r1 = r11.a;
    L6:
        String r3 = r1;
        if ((r17 & 2) == 0) goto L9;
        View r4 = r11.b;
    L11:
        if ((r17 & 4) == 0) goto L13;
        boolean r5 = r11.c;
    L15:
        if ((r17 & 8) == 0) goto L17;
        boolean r6 = r11.d;
    L19:
        if ((r17 & 16) == 0) goto L21;
        boolean r7 = r11.e;
    L23:
        if ((r17 & 32) == 0) goto L25;
        long r2 = r11.f;
    L26:
        long r8 = r2;
        if ((r17 & 64) == 0) goto L29;
        int r10 = r11.g;
    L30:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r3, "interactId");
        return new h(r3, r4, r5, r6, r7, r8, r10);
    L29:
        r10 = r16;
        goto L30
    L25:
        r2 = 0;
        goto L26
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
