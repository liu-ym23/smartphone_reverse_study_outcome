package hda;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewAudioTranscriptCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final MemoryReviewAudioTranscriptCode a;
    public final String b;
    public final String c;
    public final boolean d;
    public final long e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        long r6 = this.e;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewAudioTranscriptChunkDto(code=" + this.a + ", chunk=" + this.b + ", nextCursor=" + this.c + ", hasMore=" + this.d + ", totalBytes=" + this.e + ')';
    }

    public /* synthetic */ a(MemoryReviewAudioTranscriptCode r8) {
        this(r8, NameKeys.UnloadStrategy_No_Strategy, null, false, 0);
    }

    public a(MemoryReviewAudioTranscriptCode r2, String r3, String r4, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.CODE_KEY);
        Intrinsics.checkNotNullParameter(r3, "chunk");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
