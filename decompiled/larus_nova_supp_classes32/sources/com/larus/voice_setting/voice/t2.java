package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t2 {
    public final boolean a;
    public final boolean b;
    public final Page c;
    public final String d;
    public final boolean e;
    public final int f;
    public final Function1<SpeakerVoice, Boolean> g;

    public final boolean a() {
        if (this.e == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f != 3) goto L9;
        if (this.a == false) goto L9;
        return true;
    }

    public final boolean b() {
        z2 r0 = z2.a;
        if (r0.I2() == false) goto L5;
    L14:
        return true;
    L5:
        if (this.f != 0) goto L14;
        if (this.c != Page.NON) goto L14;
        if (this.a == false) goto L11;
    L13:
        return false;
    L11:
        if (r0.o3().a == false) goto L13;
        goto L13
    }

    public t2(boolean r3, boolean r4, Page r5, String r6, boolean r7, int r8, Function1 r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r5 = Page.NON;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r6 = "my_tab";
    L15:
        if ((r10 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r8 = 0;
    L21:
        if ((r10 & 64) == 0) goto L23;
        r9 = null;
    L23:
        Intrinsics.checkNotNullParameter(r5, "page");
        Intrinsics.checkNotNullParameter(r6, "tabName");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
