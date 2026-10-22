package com.larus.platform.model.chat;

import com.larus.platform.api.creation.TplTagType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f0 {
    public final MessageModifyStyle a;
    public final boolean b;
    public final boolean c;

    public f0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageModifyConfig(style=" + this.a + ", historyMsgEditable=" + this.b + ", offlineMsgEditable=" + this.c + ')';
    }

    public /* synthetic */ f0(int r2) {
        this(MessageModifyStyle.SMALL_BOX, false, false);
    }

    public f0(MessageModifyStyle r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, TplTagType.STYLE);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
