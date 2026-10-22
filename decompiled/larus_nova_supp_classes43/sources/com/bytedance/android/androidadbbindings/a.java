package com.bytedance.android.androidadbbindings;

import android.net.LocalSocket;
import w6.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends b {
    public final LocalSocket a;

    @Override // w6.a
    public final void close() {
        this.a.close();
    }

    public a(LocalSocket r1) {
        this.a = r1;
    }

    @Override // w6.a
    public final void read(byte[] r10) {
        this.a.getInputStream().read(r10);
    }

    @Override // w6.a
    public final void write(byte[] r10) {
        this.a.getOutputStream().write(r10);
    }
}
