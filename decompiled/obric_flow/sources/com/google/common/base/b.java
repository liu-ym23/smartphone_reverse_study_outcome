package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8648a = null;

    static {
        f8648a = new b();
    }

    @Override // com.google.common.base.g
    public final boolean b(char r5) {
        if (r5 > 127) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return "CharMatcher.ascii()";
    }
}
