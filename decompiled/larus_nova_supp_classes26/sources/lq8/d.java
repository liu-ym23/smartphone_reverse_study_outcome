package lq8;

import com.larus.bmhome.interactionpanel.InteractionPanelSource;
import com.larus.bmhome.interactionpanel.o;
import com.larus.bmhome.interactionpanel.source.InteractionPanelPayloadTarget;
import com.larus.bmhome.interactionpanel.t;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final o a;
    public final InteractionPanelSource b;
    public final InteractionPanelPayloadTarget c;
    public final t d;
    public final long e;
    public final Long f;
    public final c g;
    public final w h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Long r3 = this.f;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        c r7 = this.g;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        w r10 = this.h;
        if (r10 == null) goto L15;
        r4 = r10.hashCode();
    L15:
        return r9 + r4;
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionPanelUpsertInput(key=" + this.a + ", source=" + this.b + ", payloadTarget=" + this.c + ", payload=" + this.d + ", updateTimeMs=" + this.e + ", expireAtMs=" + this.f + ", sourceId=" + this.g + ", trackContext=" + this.h + ')';
    }

    public d(o r3, InteractionPanelSource r4, InteractionPanelPayloadTarget r5, t r6, long r7, Long r9, c r10, w r11, int r12) {
        if ((r12 & 32) == 0) goto L6;
        r9 = null;
    L6:
        if ((r12 & 64) == 0) goto L9;
        r10 = null;
    L9:
        if ((r12 & 128) == 0) goto L11;
        r11 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "payloadTarget");
        Intrinsics.checkNotNullParameter(r6, "payload");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r11;
    }
}
