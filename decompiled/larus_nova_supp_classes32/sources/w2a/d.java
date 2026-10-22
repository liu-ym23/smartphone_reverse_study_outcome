package w2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.mix.res.VoiceAuditState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final SpeakerVoice a;
    public final String b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        SpeakerVoice r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.b.hashCode()) * 31) + this.c;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceAuditionUpdate(voice=" + this.a + ", from=" + this.b + ", action=" + this.c + ')';
    }

    public d(SpeakerVoice r2, String r3, @VoiceAuditState int r4) {
        Intrinsics.checkNotNullParameter(r3, "from");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
