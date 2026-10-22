package p2a;

import com.larus.voice_setting.VoiceSettingRuntimeKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x {
    public final h a;
    public final VoiceSettingRuntimeKind b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "VoiceSettingRuntimeSelection(service=" + this.a + ", kind=" + this.b + ')';
    }

    public x(h r2, VoiceSettingRuntimeKind r3) {
        Intrinsics.checkNotNullParameter(r2, "service");
        Intrinsics.checkNotNullParameter(r3, "kind");
        this.a = r2;
        this.b = r3;
    }
}
