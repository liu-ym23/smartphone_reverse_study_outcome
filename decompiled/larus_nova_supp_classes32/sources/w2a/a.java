package w2a;

import com.larus.im.bean.bot.MixVoice;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final List<MixVoice> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MixedVoiceListUpdate(list=" + this.a + ')';
    }

    public a(List<MixVoice> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.a = r2;
    }
}
