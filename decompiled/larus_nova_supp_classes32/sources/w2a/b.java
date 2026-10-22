package w2a;

import com.larus.im.bean.bot.MixVoice;
import com.larus.voice_setting.voice.editvoice.b1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final String a;
    public final MixVoice b;
    public final String c;
    public final int d;
    public final List<MixVoice> e;
    public final b1 f;
    public final List<MixVoice> g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        List<MixVoice> r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        b1 r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        List<MixVoice> r8 = this.g;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MixedVoiceUpdate(action=" + this.a + ", voice=" + this.b + ", from=" + this.c + ", updateIndex=" + this.d + ", oldVoiceList=" + this.e + ", oldPitchAndRate=" + this.f + ", newVoiceList=" + this.g + ')';
    }

    public /* synthetic */ b(String r9, MixVoice r10, String r11, List r12, b1 r13, List r14) {
        this(r9, r10, r11, 0, r12, r13, r14);
    }

    public b(String r2, MixVoice r3, String r4, int r5, List<MixVoice> r6, b1 r7, List<MixVoice> r8) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "voice");
        Intrinsics.checkNotNullParameter(r4, "from");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
