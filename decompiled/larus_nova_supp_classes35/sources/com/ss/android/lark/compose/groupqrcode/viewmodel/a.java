package com.ss.android.lark.compose.groupqrcode.viewmodel;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final LoadState a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final long g;

    public a() {
        String r0 = null;
        this(r0, r0, r0, 127);
    }

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
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        long r1 = this.g;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "GroupQrCodeState(loadState=" + this.a + ", url=" + this.b + ", chatId=" + this.c + ", avatarKey=" + this.d + ", chatName=" + this.e + ", ownerName=" + this.f + ", expireTime=" + this.g + ')';
    }

    public /* synthetic */ a(String r12, String r13, String r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        LoadState r3 = LoadState.IDLE;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = BuildConfig.FLAVOR;
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r5 = BuildConfig.FLAVOR;
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r6 = BuildConfig.FLAVOR;
    L19:
        if ((r15 & 16) == 0) goto L21;
        String r7 = BuildConfig.FLAVOR;
    L23:
        if ((r15 & 32) == 0) goto L25;
        String r8 = BuildConfig.FLAVOR;
    L26:
        this(r3, r4, r5, r6, r7, r8, 0);
        return;
    L25:
        r8 = null;
        goto L26
    L21:
        r7 = r14;
        goto L23
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public static a a(a r9, LoadState r10, String r11, String r12, long r13, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r10 = r9.a;
    L5:
        LoadState r1 = r10;
        if ((r15 & 2) == 0) goto L8;
        r11 = r9.b;
    L8:
        String r2 = r11;
        if ((r15 & 4) == 0) goto L11;
        String r3 = r9.c;
    L13:
        if ((r15 & 8) == 0) goto L15;
        String r4 = r9.d;
    L17:
        if ((r15 & 16) == 0) goto L19;
        String r5 = r9.e;
    L21:
        if ((r15 & 32) == 0) goto L23;
        r12 = r9.f;
    L23:
        String r6 = r12;
        if ((r15 & 64) == 0) goto L26;
        r13 = r9.g;
    L26:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "loadState");
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "avatarKey");
        Intrinsics.checkNotNullParameter(r5, "chatName");
        Intrinsics.checkNotNullParameter(r6, "ownerName");
        return new a(r1, r2, r3, r4, r5, r6, r13);
    L19:
        r5 = null;
        goto L21
    L15:
        r4 = null;
        goto L17
    L11:
        r3 = null;
        goto L13
    }

    public a(LoadState r2, String r3, String r4, String r5, String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, "loadState");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "chatId");
        Intrinsics.checkNotNullParameter(r5, "avatarKey");
        Intrinsics.checkNotNullParameter(r6, "chatName");
        Intrinsics.checkNotNullParameter(r7, "ownerName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
