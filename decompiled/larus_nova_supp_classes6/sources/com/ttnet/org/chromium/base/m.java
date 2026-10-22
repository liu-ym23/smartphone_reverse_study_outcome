package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ UnownedUserDataHost a;
    public final /* synthetic */ UnownedUserData b;

    public /* synthetic */ m(UnownedUserDataHost r1, UnownedUserData r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnownedUserDataHost.a(this.a, this.b);
    }
}
