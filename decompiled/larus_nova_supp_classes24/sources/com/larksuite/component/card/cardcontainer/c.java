package com.larksuite.component.card.cardcontainer;

import android.content.Context;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public final Context a;
    public final CardData b;
    public final CardContext c;
    public final CardConfig d;
    public final cz7.a e;
    public final Integer f;

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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        Integer r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "UniversalCardShareData(context=" + this.a + ", cardData=" + this.b + ", cardContext=" + this.c + ", cardConfig=" + this.d + ", componentShareData=" + this.e + ", exactLynxViewWidth=" + this.f + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2, CardData r3, CardContext r4, CardConfig r5, cz7.a r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "cardData");
        Intrinsics.checkNotNullParameter(r4, "cardContext");
        Intrinsics.checkNotNullParameter(r5, "cardConfig");
        Intrinsics.checkNotNullParameter(r6, "componentShareData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
