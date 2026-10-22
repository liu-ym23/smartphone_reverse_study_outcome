package com.obric.assistant.view.listening;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements b {
    public final com.obric.assistant.voice.d a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ObricDelegatedListeningUiTarget(presentation=" + this.a + ')';
    }

    public a(com.obric.assistant.voice.d r2) {
        Intrinsics.checkNotNullParameter(r2, "presentation");
        this.a = r2;
    }
}
