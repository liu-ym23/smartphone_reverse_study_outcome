package com.larus.platform.api;

import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o4 {
    public final boolean a;
    public final ThirdPartyMusicPlatform b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final String g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o4) == true) goto L8;
        return false;
    L8:
        o4 r6 = (o4) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.d == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.e == true) goto L18;
        r1 = 1237;
    L18:
        int r7 = (((r6 + r1) * 31) + this.f.hashCode()) * 31;
        String r8 = this.g;
        if (r8 != null) goto L21;
        int r9 = 0;
    L23:
        return r7 + r9;
    L21:
        r9 = r8.hashCode();
        goto L23
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MusicAuthResultData(isNeedReSendOrReply=" + this.a + ", authSource=" + this.b + ", isMessageIdFromQuery=" + this.c + ", result=" + this.d + ", isRefused=" + this.e + ", messageId=" + this.f + ", cvsId=" + this.g + ')';
    }

    public o4(boolean r2, ThirdPartyMusicPlatform r3, boolean r4, boolean r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "authSource");
        Intrinsics.checkNotNullParameter(r7, "messageId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = null;
    }
}
