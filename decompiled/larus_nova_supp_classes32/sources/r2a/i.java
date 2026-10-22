package r2a;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public final int a;
    public final List<SpeakerVoice> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "VoiceListResponse(status=" + this.a + ", list=" + this.b + ')';
    }

    public i(int r2, List<SpeakerVoice> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        this.a = r2;
        this.b = r3;
    }
}
