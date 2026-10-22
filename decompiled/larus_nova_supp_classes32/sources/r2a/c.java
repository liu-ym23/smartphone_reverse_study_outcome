package r2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final com.larus.network.http.a<SpeakerVoice> a;
    public final String b;
    public final boolean c;

    public c() {
        com.larus.network.http.a r0 = null;
        this(r0, r0, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        com.larus.network.http.a<SpeakerVoice> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        if (this.c == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateUgcVoiceResponseWrapper(res=" + this.a + ", localVoiceId=" + this.b + ", fromCreateApi=" + this.c + ')';
    }

    public /* synthetic */ c(com.larus.network.http.a r2, String r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        this(r2, r3, false);
    }

    public c(com.larus.network.http.a<SpeakerVoice> r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
