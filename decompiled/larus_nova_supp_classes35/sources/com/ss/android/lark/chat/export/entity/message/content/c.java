package com.ss.android.lark.chat.export.entity.message.content;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends e {
    public final List<String> c;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.c, ((c) r4).c) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return "InviteAtChatters(chatters=" + this.c + ')';
    }

    public c(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "chatters");
        super(2, true);
        this.c = r3;
    }
}
