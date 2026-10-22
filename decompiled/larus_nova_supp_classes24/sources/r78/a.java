package r78;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final int a;
    public final int b;
    public final Object[] c;
    public final Object d;

    public final String toString() {
        return "FlowSamiBlock(dataType=" + this.a + ", numberAudioData=" + this.b + ", audioData=" + Arrays.toString(this.c) + ", userContext=" + this.d + ')';
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + Arrays.hashCode(this.c)) * 31;
        Object r1 = this.d;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.audio.sami.FlowSamiBlock");
        a r6 = (a) r5;
        if (this.a == r6.a) goto L16;
        return false;
    L16:
        if (this.b == r6.b) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.c, r6.c) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public a(int r2, int r3, Object[] r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "audioData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
