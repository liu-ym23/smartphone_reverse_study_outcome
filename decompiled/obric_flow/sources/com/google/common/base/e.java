package com.google.common.base;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f8655b;

    public /* synthetic */ e(char r5, int r10) {
        this.f8654a = r10;
        this.f8655b = r5;
    }

    @Override // com.google.common.base.g
    public final boolean b(char r5) {
        switch(this.f8654a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (r5 == this.f8655b) goto L7;
        return true;
    L7:
        return false;
    L10:
        if (r5 != this.f8655b) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.google.common.base.c
    public final g c() {
        switch(this.f8654a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new e(this.f8655b, 0);
    L7:
        return new e(this.f8655b, 1);
    }

    @Override // com.google.common.base.c, java.util.function.Predicate
    public final /* bridge */ /* synthetic */ Predicate negate() {
        switch(this.f8654a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return c();
    L7:
        return c();
    }

    public final String toString() {
        switch(this.f8654a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        String r5 = g.a(this.f8655b);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(21, r5), "CharMatcher.isNot('", r5, "')");
    L6:
        String r10 = g.a(this.f8655b);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(18, r10), "CharMatcher.is('", r10, "')");
    }
}
