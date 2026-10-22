package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final Integer h;
    public final Message i;
    public final String j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        int r2 = 1231;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.g == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        Integer r5 = this.h;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        Message r9 = this.i;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.j;
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
        return "LocalFileCardVMData(darkIcon=" + this.a + ", lightIcon=" + this.b + ", fileName=" + this.c + ", fileType=" + this.d + ", path=" + this.e + ", showFileType=" + this.f + ", showPlayAudioButton=" + this.g + ", rootBackgroundRes=" + this.h + ", message=" + this.i + ", conversationId=" + this.j + ')';
    }

    public a(String r2, String r3, String r4, String r5, String r6, boolean r7, Integer r8, Message r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "darkIcon");
        Intrinsics.checkNotNullParameter(r3, "lightIcon");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "fileType");
        Intrinsics.checkNotNullParameter(r6, MusicAppletPage.KEY_PATH);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = false;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
