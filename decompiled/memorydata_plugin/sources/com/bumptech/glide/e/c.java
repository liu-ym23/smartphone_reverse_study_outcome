package com.bumptech.glide.e;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f551b = null;

    static {
        f551b = new c();
    }

    private c() {
    }

    public static c a() {
        return f551b;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r1) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
