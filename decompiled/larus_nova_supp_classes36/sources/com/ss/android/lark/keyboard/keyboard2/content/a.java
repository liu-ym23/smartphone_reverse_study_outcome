package com.ss.android.lark.keyboard.keyboard2.content;

import com.ss.android.lark.keyboard.event.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements q {
    public final IKeyboardContent.a a;
    public final IKeyboardContent.a b;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        IKeyboardContent.a r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "KeyboardContentChange(from=" + this.a + ", to=" + this.b + ')';
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        StringBuilder r0 = new StringBuilder("from=");
        IKeyboardContent.a r1 = this.a;
        if (r1 == null) goto L5;
        String r2 = r1.getTag();
    L6:
        r0.append(r2);
        r0.append(",to=");
        r0.append(this.b.getTag());
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public a(IKeyboardContent.a r2, IKeyboardContent.a r3) {
        Intrinsics.checkNotNullParameter(r3, "to");
        this.a = r2;
        this.b = r3;
    }
}
