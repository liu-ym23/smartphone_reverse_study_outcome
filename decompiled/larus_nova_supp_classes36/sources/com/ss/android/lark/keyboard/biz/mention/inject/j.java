package com.ss.android.lark.keyboard.biz.mention.inject;

import com.ss.android.lark.keyboard.event.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements q {
    public final boolean a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof j) == true) goto L9;
        return false;
    L9:
        if (this.a == ((j) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "SetAtDoubaoTopSelected(selected=" + this.a + ')';
    }

    public j() {
        this.a = true;
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return com.ss.android.lark.keyboard.event.c.a.a(this);
    }
}
