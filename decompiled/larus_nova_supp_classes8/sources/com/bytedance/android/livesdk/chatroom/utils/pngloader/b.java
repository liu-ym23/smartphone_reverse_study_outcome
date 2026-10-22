package com.bytedance.android.livesdk.chatroom.utils.pngloader;

import java.io.Closeable;
import po1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Closeable {
    public final int a;
    public final byte[] b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public long h;
    public int i;
    public long j;
    public a k;
    public c l;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f = true;
    }

    public b() {
        byte[] r0 = po1.a.a;
        this.b = new byte[8];
        this.c = 0;
        this.e = false;
        this.f = false;
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.j = 0;
        this.l = null;
        this.a = 8;
        this.d = false;
    }
}
