package com.ss.android.lark.inline.ai.creationai.editor;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m {
    public String a;
    public String b;

    public m() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return "ResRevision{revision='" + this.a + "', version='" + this.b + "'}";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (Intrinsics.areEqual(m.class, r5.getClass()) == false) goto L17;
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.b, r6.b) == false) goto L15;
        return true;
    }
}
