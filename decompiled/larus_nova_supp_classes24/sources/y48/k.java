package y48;

import android.graphics.Rect;
import com.larus.asr.config.builder.ChatSpeakerElementKey;
import com.larus.asr.config.builder.ChatSpeakerGesturePhase;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k {
    public final ChatSpeakerElementKey a;
    public final ChatSpeakerGesturePhase b;
    public final y c;
    public final Pair<Float, Float> d;
    public final Pair<Float, Float> e;
    public final boolean f;
    public final Rect g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
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
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        Rect r3 = this.g;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerElementGestureContext(elementKey=" + this.a + ", phase=" + this.b + ", uiState=" + this.c + ", globalTouchPosition=" + this.d + ", deltaPosition=" + this.e + ", isVoiceGranted=" + this.f + ", elementBounds=" + this.g + ')';
    }

    public k(ChatSpeakerElementKey r2, ChatSpeakerGesturePhase r3, y r4, Pair<Float, Float> r5, Pair<Float, Float> r6, boolean r7, Rect r8) {
        Intrinsics.checkNotNullParameter(r2, "elementKey");
        Intrinsics.checkNotNullParameter(r3, "phase");
        Intrinsics.checkNotNullParameter(r4, "uiState");
        Intrinsics.checkNotNullParameter(r5, "globalTouchPosition");
        Intrinsics.checkNotNullParameter(r6, "deltaPosition");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
