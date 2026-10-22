package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.Chatter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final List<Chatter> a;
    public final Chat.Type b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;

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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.e) * 31;
        if (this.f == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "GroupMembersState(chatters=" + this.a + ", chatType=" + this.b + ", isOwner=" + this.c + ", isAdmin=" + this.d + ", userCount=" + this.e + ", isUserCountVisible=" + this.f + ')';
    }

    public c(List<Chatter> r2, Chat.Type r3, boolean r4, boolean r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "chatters");
        Intrinsics.checkNotNullParameter(r3, "chatType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public static c a(c r7, List r8, Chat.Type r9, boolean r10, boolean r11, int r12, boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        List r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        Chat.Type r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.c;
    L11:
        boolean r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.d;
    L14:
        boolean r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.e;
    L17:
        int r5 = r12;
        if ((r14 & 32) == 0) goto L20;
        r13 = r7.f;
    L20:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "chatters");
        Intrinsics.checkNotNullParameter(r2, "chatType");
        return new c(r1, r2, r3, r4, r5, r13);
    }
}
