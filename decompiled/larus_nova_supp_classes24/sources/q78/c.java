package q78;

import android.media.AudioFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public final int a;
    public final int b;
    public final AudioFormat c;
    public final boolean d;
    public final a e;
    public final int f;
    public final AudioFormat g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        a r3 = this.e;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return ((((r2 + r4) * 31) + this.f) * 31) + this.g.hashCode();
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioRecordingConfigurationWrapper(clientAudioSource=" + this.a + ", clientAudioSessionId=" + this.b + ", clientFormat=" + this.c + ", isClientSilenced=" + this.d + ", audioDevice=" + this.e + ", audioSource=" + this.f + ", format=" + this.g + ')';
    }

    public c(int r2, int r3, AudioFormat r4, boolean r5, a r6, int r7, AudioFormat r8) {
        Intrinsics.checkNotNullParameter(r4, "clientFormat");
        Intrinsics.checkNotNullParameter(r8, "format");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
