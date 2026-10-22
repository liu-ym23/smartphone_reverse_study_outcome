package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c<OWNER extends MVIState<?>, T> implements com.bytedance.android.anya.v<OWNER, T> {
    public String a;
    public volatile T b;
    public volatile int c;
    public final Function1<c<OWNER, ?>, Unit> d;
    public final Function1<c<OWNER, ?>, Unit> e;

    public final T c() {
        T r0 = this.b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException(("No value present in StateProperty: " + this + ". Please check corresponding ViewModel is bound.").toString());
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("{ \"name\": \"");
        r0.append(this.a);
        r0.append("@p\", \"value\": ");
        T r1 = this.b;
        if (r1 == null) goto L5;
        String r10 = "\"" + r1 + '\"';
    L6:
        r0.append(r10);
        r0.append(" }");
        return r0.toString();
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.android.anya.v
    public final String getName() {
        return this.a;
    }

    public final void a(T r1) {
        if (b(r1) == false) goto L6;
        this.d.invoke(this);
        this.c++;
        return;
    }

    public boolean b(T r10) {
        boolean r0 = !Intrinsics.areEqual(this.b, r10);
        this.b = r10;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Object r1, Function1 r10, Function1 r11) {
        this.d = r10;
        this.e = r11;
        this.a = "unknown";
        this.b = r1;
        if (r1 != 0) goto L5;
        int r12 = 0;
    L6:
        this.c = r12;
        return;
    L5:
        r12 = 1;
        goto L6
    }
}
