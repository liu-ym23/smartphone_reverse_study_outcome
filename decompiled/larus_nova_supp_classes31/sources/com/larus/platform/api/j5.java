package com.larus.platform.api;

import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j5 {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final String e;
    public final Message f;
    public final AuthScene g;
    public final i5 h;
    public final Function0<Unit> i;

    public j5() {
        this(null, false, false, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j5) == true) goto L8;
        return false;
    L8:
        j5 r6 = (j5) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (((((r3 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        Message r5 = this.f;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r4 + r7) * 31) + this.g.hashCode()) * 31;
        i5 r9 = this.h;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Function0<Unit> r12 = this.i;
        if (r12 == null) goto L23;
        r6 = r12.hashCode();
    L23:
        return r11 + r6;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "StartMusicAuthParams(botId=" + this.a + ", isMessageIdFromQuery=" + this.b + ", isNeedReSendOrReply=" + this.c + ", messageId=" + this.d + ", jumpUrl=" + this.e + ", authMessage=" + this.f + ", authScene=" + this.g + ", startMusicAuthAdditionalJSBParams=" + this.h + ", onClickThirdPartyMusicPlatformToAuthCallback=" + this.i + ')';
    }

    public j5(String r4, boolean r5, boolean r6, String r7, String r8, Message r9, AuthScene r10, i5 r11, com.larus.avlink.plugins.x0 r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r4 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r5 = true;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r6 = true;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r7 = "";
    L15:
        if ((r13 & 16) == 0) goto L18;
        r8 = "";
    L18:
        if ((r13 & 32) == 0) goto L21;
        r9 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r10 = AuthScene.LocalLife;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r11 = null;
    L27:
        if ((r13 & 256) == 0) goto L29;
        r12 = null;
    L29:
        Intrinsics.checkNotNullParameter(r4, "botId");
        Intrinsics.checkNotNullParameter(r7, "messageId");
        Intrinsics.checkNotNullParameter(r8, "jumpUrl");
        Intrinsics.checkNotNullParameter(r10, "authScene");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
    }
}
