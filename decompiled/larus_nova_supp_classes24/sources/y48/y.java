package y48;

import com.larus.asr.config.ChatSpeakerStatus;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y {
    public final boolean a;
    public final ChatSpeakerStatus b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final Pair<Float, Float> h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.d == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.e == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.f == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.g == true) goto L26;
        r1 = 1237;
    L26:
        int r11 = (r10 + r1) * 31;
        Pair<Float, Float> r12 = this.h;
        if (r12 != null) goto L29;
        int r13 = 0;
    L31:
        return r11 + r13;
    L29:
        r13 = r12.hashCode();
        goto L31
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerUiState(visible=" + this.a + ", status=" + this.b + ", isDarkMode=" + this.c + ", isImmerseMode=" + this.d + ", isBlurMode=" + this.e + ", isCountingDown=" + this.f + ", tipsDrivenByHost=" + this.g + ", globalTouchPosition=" + this.h + ')';
    }

    public y(boolean r2, ChatSpeakerStatus r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, Pair<Float, Float> r9) {
        Intrinsics.checkNotNullParameter(r3, "status");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
