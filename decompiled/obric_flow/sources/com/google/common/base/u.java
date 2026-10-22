package com.google.common.base;

import ai.j0;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8670b;

    public /* synthetic */ u() {
        this.f8669a = 1;
    }

    public String a(Iterable r5) {
        Iterator r10 = r5.iterator();
        StringBuilder r11 = new StringBuilder();
    L12:
        e = move-exception;
        throw new AssertionError(e);
    L4:
        if (r10.hasNext() == false) goto L11;
        r11.append(b(r10.next()));     // Catch: IOException -> L12
    L7:
        if (r10.hasNext() == false) goto L11;
        r11.append(this.f8670b);     // Catch: IOException -> L12
        r11.append(b(r10.next()));     // Catch: IOException -> L12
    L11:
        return r11.toString();
    }

    public CharSequence b(Object r5) {
        Objects.requireNonNull(r5);
        if ((r5 instanceof CharSequence) == false) goto L6;
        return (CharSequence) r5;
    L6:
        return r5.toString();
    }

    public String toString() {
        switch(this.f8669a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return j0.q(new StringBuilder("SccUrlCheckResult{mSuccess=true, mMatchRule='"), this.f8670b, "'}");
    }

    public u(String r5, int r10) {
        this.f8669a = r10;
        switch(r10) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        r5.getClass();
        this.f8670b = r5;
        return;
    L6:
        this.f8670b = r5;
    }

    public u(u r5) {
        this.f8669a = 0;
        this.f8670b = r5.f8670b;
    }
}
